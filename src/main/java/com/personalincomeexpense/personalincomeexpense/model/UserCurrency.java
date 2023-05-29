/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Try
 *
 */
@Entity
@Table(name = "user_currency")
public class UserCurrency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "currency_id")
	private Long currency_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private UserLogin user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Currency currency;

	/**
	 * @return the currency
	 */
	public String getCurrencyName() {
		return currency.getName();
	}

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

	/**
	 * @return the currency_id
	 */
	public Long getCurrency_id() {
		return currency_id;
	}

	/**
	 * @param currency_id the currency_id to set
	 */
	public void setCurrency_id(Long currency_id) {
		this.currency_id = currency_id;
	}
}
