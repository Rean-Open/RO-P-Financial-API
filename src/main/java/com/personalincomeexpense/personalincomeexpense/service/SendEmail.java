/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @author Try
 *
 */
@Service
public class SendEmail {
	@Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email, String otp) throws MessagingException {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Personal Income & Expense");
        msg.setText(otp + " is your verification code for verify your account.");

        javaMailSender.send(msg);
    }
}
