/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.personalincomeexpense.personalincomeexpense.model.Currency;
/**
 * @author Try
 *
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	@Query("SELECT c FROM Currency c WHERE c.is_active = 1")
	List<Currency> getCurrencyList();
}
