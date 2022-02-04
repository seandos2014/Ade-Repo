package com.example.model;

public class Account {
  private int account_no;
  private int customer_id;
  private String account_date_opened;
  private double account_balance;
  
public int getAccount_no() {
	return account_no;
}

public void setAccount_no(int account_no) {
	this.account_no = account_no;
}

public int getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}

public String getAccount_date_opened() {
	return account_date_opened;
}

public void setAccount_date_opened(String account_date_opened) {
	this.account_date_opened = account_date_opened;
}

public double getAccount_balance() {
	return account_balance;
}

public void setAccount_balance(double account_balance) {
	this.account_balance = account_balance;
}

public Account(int account_no, int customer_id, String account_date_opened, double account_balance) {
	super();
	this.account_no = account_no;
	this.customer_id = customer_id;
	this.account_date_opened = account_date_opened;
	this.account_balance = account_balance;
}

public Account() {
	
}

@Override
public String toString() {
	return "Account [account_no=" + account_no + ", customer_id=" + customer_id + ", account_date_opened="
			+ account_date_opened + ", account_balance=" + account_balance + "]";
}
  
  
  
	
}
