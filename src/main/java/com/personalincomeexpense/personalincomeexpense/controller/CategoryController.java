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

import com.personalincomeexpense.personalincomeexpense.model.Category;
import com.personalincomeexpense.personalincomeexpense.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category/")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "createCategory", method = RequestMethod.POST)
	public String createCategory(@RequestBody Category model) {
		return categoryService.insertCategory(model);
	}
	
	@RequestMapping(value = "getCategoryList", method = RequestMethod.GET)
	public List<Category> getCategoryList(Long userId, Boolean isIncome, Boolean isExpense){
		return categoryService.getCategoryList(userId, isIncome, isExpense);
	}
	
	@RequestMapping(value = "getCategory", method = RequestMethod.GET)
	public Category getCategory(Long id){
		return categoryService.getCategory(id);
	}
	
	@RequestMapping(value = "updateCategory", method = RequestMethod.PUT)
	public String updateCategory(@RequestBody Category model) {
		return categoryService.updateCategory(model);
	}
	
	@RequestMapping(value = "deleteCategory", method = RequestMethod.DELETE)
	public String deleteCategory(Long id) {
		return categoryService.deleteCategory(id);
	}
}
