package com.deloitte.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="login")
public class LoginPage {
	@Id
	@Column(name="username")
	private String name;
	@Column(name="password")
	private String pwd;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private String mobile;

	public LoginPage() {
		
	}	

	public LoginPage(String name, String pwd, String email, String mobile) {
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.mobile = mobile;
	}

	@NotEmpty(message="Username is required")
	@Pattern(regexp="^[A-Z][A-Za-z]{2,40}$", 
	   message="Username should have only characters and first letter should be uppercase")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message="Password is required")
	@Pattern(regexp = "[a-z0-9]{8}",
	message="Password length should be 8 characters. Characters can be alphanumeric.")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@NotEmpty(message="Email is required")	
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
			message="email is not in proper format")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty(message="Mobile is required")
	@Pattern(regexp = "[7-9][0-9]{9}",
		message="Mobile should start with 7,8 or 9 and have 10 digits")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "LoginPage [name=" + name + ", pwd=" + pwd + ", email=" + email + ", mobile=" + mobile + "]";
	}

}

