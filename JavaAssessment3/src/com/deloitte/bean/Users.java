package com.deloitte.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	private String name;
	private String pwd;
	private String email;
	private String mobile;

	public Users() {
	
	}	

	public Users(String name, String pwd, String email, String mobile) {
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.mobile = mobile;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", pwd=" + pwd + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
}

