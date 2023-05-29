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

import com.personalincomeexpense.personalincomeexpense.model.Category;
import com.personalincomeexpense.personalincomeexpense.repository.CategoryRepository;
@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public String insertCategory(Category model) {
		if (model != null) {
			categoryRepository.save(model);
			return "success";
		}
		return "fail";
	}
	
	public List<Category> getCategoryList(Long userId, Boolean isIncome, Boolean isExpense){
		return categoryRepository.getCategory(userId, isIncome, isExpense);
	}
	
	public Category getCategory(Long id){
		return categoryRepository.findById(id).get();
	}
	
	public String updateCategory(Category model) {
		if (model != null) {
			Category category = categoryRepository.findById(model.getId()).get();
			if (category != null) {
				category.setName(model.getName());
				category.setDescription(model.getDescription());
				category.setIs_income(model.getIs_income());
				category.setIs_expense(model.getIs_expense());
				category.setIs_visible(model.getIs_visible());
				category.setDisactive_date(model.getDisactive_date());
				categoryRepository.save(category);
				return "success";
			}
		}
		return "fail";
	}
	
	public String deleteCategory(Long id) {
		if (id != null) {
			categoryRepository.deleteById(id);
			return "success";
		}
		return "fail";
	}
}
