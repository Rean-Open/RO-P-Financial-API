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

import com.personalincomeexpense.personalincomeexpense.model.UserCurrency;
import com.personalincomeexpense.personalincomeexpense.service.UserCurrencyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usercurrency/")
public class UserCrrencyController {
	@Autowired
	UserCurrencyService userCurrencyService;
	
	@RequestMapping(value = "setUpUserCurrency", method = RequestMethod.POST)
	public String setUpUserCurrency(@RequestBody UserCurrency model) {
		return userCurrencyService.setUpUserCurrency(model);
	}
	
	@RequestMapping(value = "getUserCurrency", method = RequestMethod.GET)
	public UserCurrency getUserCurrency(Long userId){
		return userCurrencyService.getUserCurrency(userId);
	}
}
