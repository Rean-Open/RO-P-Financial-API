/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Try
 *
 */
@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "activity_type_id")
	private Long activity_type_id;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "description")
	private String description;

	@Column(name = "category_id")
	private Long category_id;

	@Column(name = "payment_method_id")
	private Long payment_method_id;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "remark")
	private String remark;

	@Column(name = "reference")
	private String reference;

	@Column(name = "tag")
	private String tag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_method_id", referencedColumnName = "id", insertable = false, updatable = false)
	private PaymentMethod paymentMethod;

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
	 * @return the activity_type_id
	 */
	public Long getActivity_type_id() {
		return activity_type_id;
	}

	/**
	 * @param activity_type_id the activity_type_id to set
	 */
	public void setActivity_type_id(Long activity_type_id) {
		this.activity_type_id = activity_type_id;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
	 * @return the category_id
	 */
	public Long getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the payment_method_id
	 */
	public Long getPayment_method_id() {
		return payment_method_id;
	}

	/**
	 * @param payment_method_id the payment_method_id to set
	 */
	public void setPayment_method_id(Long payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	/**
	 * @return the created_date
	 */
	public Date getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the category's name
	 */
	public String getCategoryName() {
		return category.getName();
	}

	/**
	 * @return the paymentMethod's name
	 */
	public String getPaymentMethodName() {
		return paymentMethod.getName();
	}
}
