/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Try
 *
 */
import com.personalincomeexpense.personalincomeexpense.model.UserLogin;
import com.personalincomeexpense.personalincomeexpense.service.UserLoginService;
import com.personalincomeexpense.personalincomeexpense.model.LoginDTO;
import com.personalincomeexpense.personalincomeexpense.service.UserLoginService.UserMessage;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserLoginController {
	@Autowired
	UserLoginService userLoginService;
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public UserMessage registerUserLogin(@RequestBody UserLogin model) {
		return userLoginService.registerUser(model);
	}
	
	@RequestMapping(value = "/user/verifyUser", method = RequestMethod.GET)
	public String verifyUser(Long userId, String otp, Long verifyTypeId) {
		return userLoginService.verifyUser(userId, otp, verifyTypeId);
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public UserLogin login(@RequestBody LoginDTO model) {
		return userLoginService.userLogin(model);
	}
	
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String changePassword(Long id, String oldPassword, String newPassword) {
		return userLoginService.changePassword(id, oldPassword, newPassword);
	}
	
	@RequestMapping(value = "/user/resetPassword", method = RequestMethod.GET)
	public UserMessage resetPassword(String email) {
		return userLoginService.resetPassword(email);
	}
	
	@RequestMapping(value = "/user/createPassword", method = RequestMethod.GET)
	public String createPassword(Long id, String newPassword) {
		return userLoginService.createPassword(id, newPassword);
	}
}
