/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalincomeexpense.personalincomeexpense.model.LoginDTO;
/**
 * @author Try
 *
 */
import com.personalincomeexpense.personalincomeexpense.model.UserLogin;
import com.personalincomeexpense.personalincomeexpense.model.UserVerification;
import com.personalincomeexpense.personalincomeexpense.repository.UserLoginRepository;
import com.personalincomeexpense.personalincomeexpense.repository.UserVerificationRepository;

@Service
public class UserLoginService {
	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	UserVerificationRepository userVerificationRepository;
	
	@Autowired
	SendEmail sendEmail;
	
	UserMessage message = new UserMessage();
	
	public UserMessage registerUser(UserLogin model) {
		if (model != null)
		{
			UserLogin user = userLoginRepository.findByUserAndEmail(model.getUser_name(), model.getEmail());
			if (user != null) {
				message.msg = "Username or Email already exist in system.";
				return message;
			}
			
			Timestamp timestamp = new Timestamp(new Date().getTime());
			model.setJoin_date(timestamp);
			model.setIs_active(false);
			model.setIs_verify(false);
			user = userLoginRepository.save(model);
			if (user != null) {
				try {
					String otp = requestOTP(user.getId(), 1);
					sendEmail.sendEmail(model.getEmail(), otp);
					
					message.userId = user.getId();
					message.msg = "success";
					return message;
				} catch (MessagingException e) {
//					e.printStackTrace();
					message.msg = "something went wrong!";
					return message;
				}
			}
		}
		
		message.msg = "fail";
		return message;
	}
	
	private String requestOTP(Long userId, int verifyTypeId) {		
		try {
			String otp = String.valueOf(generateOTP(6));
			UserVerification model = new UserVerification();
			model.setUser_id(userId);
			model.setVerify_code(otp);
			model.setSend_date(null);
			model.setVerify_type_id(verifyTypeId);
			model.setVerify_status_id(1);
			userVerificationRepository.save(model);
			return otp;
		} catch (Exception e) {
			return "fail";
		}		
	}
	
	public String verifyUser(Long userId, String otp, Long verifyTypeId) {
		UserVerification userVerify = userVerificationRepository.getVerification(userId, otp, verifyTypeId);
		if (userVerify != null) {
			userVerify.setVerify_status_id(2);
			userVerificationRepository.save(userVerify);
			
			if (verifyTypeId == 1) {
				UserLogin model = userLoginRepository.findById(userId).get();
				if(model != null) {
					model.setIs_active(true);
					model.setIs_verify(true);
					userLoginRepository.save(model);
				}
			}
			
			return "success";
		}
		return "invalid";
	}
	
	public UserLogin userLogin(LoginDTO login){
		UserLogin model = userLoginRepository.getUserLogin(login.getUsername(), login.getPassword());
		if (model != null) {
			if (model.getIs_active() == true && model.getIs_verify() == true) {
				return model;
			}
		}
		return null;
	}
	
	public String changePassword(Long id, String oldPassword, String newPassword) {
		UserLogin userLogin = userLoginRepository.findById(id).get();
		if(userLogin != null) {
			if (oldPassword.equals(userLogin.getPassword())) {
				userLogin.setPassword(newPassword);
				userLoginRepository.save(userLogin);
				return "success";
			}
		}
		return "fail";
	}
	
	public UserMessage resetPassword(String email) {
		UserLogin user = userLoginRepository.findByUserOrEmail(email);
		if (user != null) {
			try {
				String otp = requestOTP(user.getId(), 2);
				sendEmail.sendEmail(user.getEmail(), otp);
				
				message.userId = user.getId();
				message.msg = "success";
				
				return message;
			} catch (MessagingException e) {
//				e.printStackTrace();
				message.msg = "something went wrong!";
				return message;
			}
		}
		
		message.msg = "invalid";
		return message;
	}
	
	public String createPassword(Long userId, String newPassword) {
		try {
			UserLogin user = userLoginRepository.findById(userId).get();
			user.setPassword(newPassword);
			userLoginRepository.save(user);
			
			return "success";
		} catch (Exception e) {
//			e.printStackTrace();
			return "fail";
		}
	}
	
	private static char[] generateOTP(int len) {
		String numbers = "0123456789";
		Random rndm_method = new Random();
		char[] otp = new char[len];
		for (int i = 0; i < len; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}
	
	public class UserMessage {
		public Long userId = null;
		public String msg = "";
	}
}
