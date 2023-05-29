/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Try
 *
 */

import com.personalincomeexpense.personalincomeexpense.model.UserCurrency;
import com.personalincomeexpense.personalincomeexpense.repository.UserCurrencyRepository;
@Service
public class UserCurrencyService {
	@Autowired
	UserCurrencyRepository userCurrencyRepository;
	
	public String setUpUserCurrency(UserCurrency model) {
		UserCurrency userCurrency = userCurrencyRepository.getUserCurrency(model.getUser_id());
		if (userCurrency != null) {
			userCurrency.setUser_id(model.getUser_id());
			userCurrency.setCurrency_id(model.getCurrency_id());
			userCurrencyRepository.save(userCurrency);
		} else {
			userCurrencyRepository.save(model);
		}
		return "success";
	}
	
	public UserCurrency getUserCurrency(Long userId){
		return userCurrencyRepository.getUserCurrency(userId);
	}
}
