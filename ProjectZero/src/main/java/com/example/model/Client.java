package com.example.model;

import java.util.List;

public class Client {
	
	@Override
	public String toString() {
		return "Client [customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", email=" + email + ", customer_age=" + customer_age + ", address="
				+ address + ", phone=" + phone + "]";
	}
	private int customer_id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private int customer_age;
	private String address;
	private String phone;
	private List<Account> accountList;
	
	public Client(int customerID, String firstname, String lastname, String username, String email, int customer_age,
			String address, String phone) {
		super();
		this.customer_id = customerID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.customer_age = customer_age;
		this.address = address;
		this.phone = phone;
	}
	
	public Client() {
		
	}
	
	public int getCustomerID() {
		return customer_id;
	}
	public void setCustomerID(int customerID) {
		this.customer_id = customerID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomer_age() {
		return customer_age;
	}
	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList= accountList;
		
	}
	

}
