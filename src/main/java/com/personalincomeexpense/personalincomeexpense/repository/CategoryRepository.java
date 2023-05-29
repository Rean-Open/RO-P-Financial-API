/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalincomeexpense.personalincomeexpense.model.Category;
/**
 * @author Try
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	@Query("SELECT c FROM Category c WHERE c.user_id = :user_id AND c.is_income = :is_income AND c.is_expense = :is_expense")
	List<Category> getCategory(@Param("user_id") Long user_id, @Param("is_income") Boolean is_income, @Param("is_expense") Boolean is_expense);
}
