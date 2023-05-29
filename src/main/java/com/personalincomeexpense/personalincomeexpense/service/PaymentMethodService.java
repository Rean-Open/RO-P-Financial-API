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

import com.personalincomeexpense.personalincomeexpense.model.PaymentMethod;
import com.personalincomeexpense.personalincomeexpense.repository.PaymentMethodRepository;
@Service
public class PaymentMethodService {
	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	
	public String insertPaymentMethod(PaymentMethod model) {
		if (model != null) {
			paymentMethodRepository.save(model);
			return "success";
		}
		return "fail";
	}
	
	public List<PaymentMethod> getPaymentMethodList(Long userId){
		return paymentMethodRepository.getPaymentMethodList(userId);
	}
	
	public PaymentMethod getPaymentMethod(Long id){
		return paymentMethodRepository.findById(id).get();
	}
	
	public String updatePaymentMethod(PaymentMethod model) {
		if (model != null) {
			PaymentMethod paymethMethod = paymentMethodRepository.findById(model.getId()).get();
			if (paymethMethod != null) {
				paymethMethod.setName(model.getName());
				paymethMethod.setDescription(model.getDescription());
				paymentMethodRepository.save(paymethMethod);
				return "success";
			}
		}
		return "fail";
	}
	
	public String deletePaymentMethod(Long id) {
		if (id != null) {
			paymentMethodRepository.deleteById(id);
			return "success";
		}
		return "fail";
	}
}
