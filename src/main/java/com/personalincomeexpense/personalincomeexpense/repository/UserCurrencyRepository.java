/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalincomeexpense.personalincomeexpense.model.UserCurrency;
/**
 * @author Try
 *
 */
@Repository
public interface UserCurrencyRepository extends JpaRepository<UserCurrency, Long> {
	@Query("SELECT c FROM UserCurrency c WHERE c.user_id = :user_id")
	UserCurrency getUserCurrency(@Param("user_id") Long user_id);
}
