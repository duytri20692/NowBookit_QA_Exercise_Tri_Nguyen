package com.nowbookit.models;

public class User {
	String firstName;
	String lastName;
	String mobile;
	String emailAddress;
	String company;

	public User(String firstName, String lastName, String mobile, String emailAddress, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.emailAddress = emailAddress;
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
