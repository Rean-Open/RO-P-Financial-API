/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.controller;

import java.util.List;

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

import com.personalincomeexpense.personalincomeexpense.model.PaymentMethod;
import com.personalincomeexpense.personalincomeexpense.service.PaymentMethodService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/paymentMethod/")
public class PaymentMethodController {
	@Autowired
	PaymentMethodService paymentMethodService;
	
	@RequestMapping(value = "createPaymentMethod", method = RequestMethod.POST)
	public String createPaymentMethod(@RequestBody PaymentMethod model) {
		return paymentMethodService.insertPaymentMethod(model);
	}
	
	@RequestMapping(value = "getPaymentMethodList", method = RequestMethod.GET)
	public List<PaymentMethod> getPaymentMethodList(Long userId){
		return paymentMethodService.getPaymentMethodList(userId);
	}
	
	@RequestMapping(value = "getPaymentMethod", method = RequestMethod.GET)
	public PaymentMethod getPaymentMethod(Long id){
		return paymentMethodService.getPaymentMethod(id);
	}
	
	@RequestMapping(value = "updatePaymentMethod", method = RequestMethod.PUT)
	public String updatePaymentMethod(@RequestBody PaymentMethod model) {
		return paymentMethodService.updatePaymentMethod(model);
	}
	
	@RequestMapping(value = "deletePaymentMethod", method = RequestMethod.DELETE)
	public String deletePaymentMethod(Long id) {
		return paymentMethodService.deletePaymentMethod(id);
	}
}
