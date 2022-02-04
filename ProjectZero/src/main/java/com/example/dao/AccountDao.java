package com.example.dao;

import java.util.List;

import com.example.model.Account;

public interface AccountDao {

	/*
	 * the following Data Access Object methods
	 * are to be implemented 
	 * in the concrete class
	 * of this interface
	 * to be implemented in the 
	 * AccountDaoImpl
	 */
    List<Account> get_all_account();
	
    Account getAccount(String sql);
	
	Account create_new_account();
	
	Account update_an_account();
	
	void  delete_an_account(String sql);

	Account deposit_into_account(int accountNO, double amount);
	
	Account withdraw_from_account(int accountNO, double amount);
	
	
}
