/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Try
 *
 */

import com.personalincomeexpense.personalincomeexpense.model.Currency;
import com.personalincomeexpense.personalincomeexpense.service.CurrencyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/currency/")
public class CurrencyController {
	@Autowired
	CurrencyService currencyService;
	
	@RequestMapping(value = "getCurrencyList", method = RequestMethod.GET)
	public List<Currency> getCurrencyList(){
		return currencyService.getCurrencyList();
	}
}
