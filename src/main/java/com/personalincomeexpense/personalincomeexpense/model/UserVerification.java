/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.model;

import java.sql.Timestamp;
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
@Table(name = "user_verification")
public class UserVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "verify_code")
	private String verify_code;
	
	@Column(name = "send_date")
	private Date send_date;
	
	@Column(name = "verify_type_id")
	private int verify_type_id;
	
	@Column(name = "verify_status_id")
	private int verify_status_id;

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
	 * @return the verify_code
	 */
	public String getVerify_code() {
		return verify_code;
	}

	/**
	 * @param verify_code the verify_code to set
	 */
	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}

	/**
	 * @return the send_date
	 */
	public Date getSend_date() {
		return send_date;
	}

	/**
	 * @param send_date the send_date to set
	 */
	public void setSend_date(Date send_date) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		send_date = timestamp;
		this.send_date = send_date;
	}

	/**
	 * @return the verify_type_id
	 */
	public int getVerify_type_id() {
		return verify_type_id;
	}

	/**
	 * @param verify_type_id the verify_type_id to set
	 */
	public void setVerify_type_id(int verify_type_id) {
		this.verify_type_id = verify_type_id;
	}

	/**
	 * @return the verify_status_id
	 */
	public int getVerify_status_id() {
		return verify_status_id;
	}

	/**
	 * @param verify_status_id the verify_status_id to set
	 */
	public void setVerify_status_id(int verify_status_id) {
		this.verify_status_id = verify_status_id;
	}
	
}
