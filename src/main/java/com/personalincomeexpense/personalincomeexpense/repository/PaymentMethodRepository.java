/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalincomeexpense.personalincomeexpense.model.PaymentMethod;
/**
 * @author Try
 *
 */
@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
	@Query("SELECT c FROM PaymentMethod c WHERE c.user_id = :user_id")
	List<PaymentMethod> getPaymentMethodList(@Param("user_id") Long user_id);
}
