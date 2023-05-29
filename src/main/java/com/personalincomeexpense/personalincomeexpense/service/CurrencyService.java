/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Try
 *
 */

import com.personalincomeexpense.personalincomeexpense.model.Currency;
import com.personalincomeexpense.personalincomeexpense.repository.CurrencyRepository;
@Service
public class CurrencyService {
	@Autowired
	CurrencyRepository currencyRepository;
	
	public List<Currency> getCurrencyList(){
		return currencyRepository.getCurrencyList();
	}
}
