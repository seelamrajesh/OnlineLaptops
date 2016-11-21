package com.niit.model;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Register implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "mobile")
	private String mobile;
	
	
	@Column(name = "email")
	private String email;
	 
	@Column(name = "address")
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Transient
	private String role;
	@Transient
	private boolean enabled;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}