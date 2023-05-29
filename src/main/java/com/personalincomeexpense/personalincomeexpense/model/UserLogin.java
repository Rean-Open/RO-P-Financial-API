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
@Table(name = "user_login")
public class UserLogin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="user_name")
    private String user_name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="hash")
    private String hash;
    
    @Column(name="salt")
    private String salt;
    
    @Column(name="join_date")
    private Date join_date;
    
    @Column(name="is_verify")
    private Boolean is_verify;
    
    @Column(name="is_active")
    private Boolean is_active;

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
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the join_date
	 */
	public Date getJoin_date() {
		return join_date;
	}

	/**
	 * @param join_date the join_date to set
	 */
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	/**
	 * @return the is_verify
	 */
	public Boolean getIs_verify() {
		return is_verify;
	}

	/**
	 * @param is_verify the is_verify to set
	 */
	public void setIs_verify(Boolean is_verify) {
		this.is_verify = is_verify;
	}

	/**
	 * @return the is_active
	 */
	public Boolean getIs_active() {
		return is_active;
	}

	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
}
