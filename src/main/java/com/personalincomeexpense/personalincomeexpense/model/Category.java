/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Try
 *
 */
@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_income")
	private Boolean is_income;
	
	@Column(name = "is_expense")
	private Boolean is_expense;
	
	@Column(name = "is_visible")
	private Boolean is_visible;
	
	@Column(name = "disactive_date")
	private Date disactive_date;
	
	@Column(name = "user_id")
	private Long user_id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the is_income
	 */
	public Boolean getIs_income() {
		return is_income;
	}

	/**
	 * @param is_income the is_income to set
	 */
	public void setIs_income(Boolean is_income) {
		this.is_income = is_income;
	}

	/**
	 * @return the is_expense
	 */
	public Boolean getIs_expense() {
		return is_expense;
	}

	/**
	 * @param is_expense the is_expense to set
	 */
	public void setIs_expense(Boolean is_expense) {
		this.is_expense = is_expense;
	}

	/**
	 * @return the is_visible
	 */
	public Boolean getIs_visible() {
		return is_visible;
	}

	/**
	 * @param is_visible the is_visible to set
	 */
	public void setIs_visible(Boolean is_visible) {
		this.is_visible = is_visible;
	}

	/**
	 * @return the disactive_date
	 */
	public Date getDisactive_date() {
		return disactive_date;
	}

	/**
	 * @param disactive_date the disactive_date to set
	 */
	public void setDisactive_date(Date disactive_date) {
		this.disactive_date = disactive_date;
	}

	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
