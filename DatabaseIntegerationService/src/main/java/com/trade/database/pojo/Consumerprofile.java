package com.trade.database.pojo;

// Generated Mar 19, 2017 4:34:57 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Consumerprofile generated by hbm2java
 */
@Entity
@Table(name = "consumerprofile", catalog = "trade")
public class Consumerprofile implements java.io.Serializable {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String createddate;
	private String createdby;
	private Integer addressid;

	public Consumerprofile() {
	}

	public Consumerprofile(String firstname, String lastname, String email,
			String createddate, String createdby, Integer addressid) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.createddate = createddate;
		this.createdby = createdby;
		this.addressid = addressid;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "firstname", length = 45)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "createddate", length = 45)
	public String getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	@Column(name = "createdby", length = 45)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "addressid")
	public Integer getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

}
