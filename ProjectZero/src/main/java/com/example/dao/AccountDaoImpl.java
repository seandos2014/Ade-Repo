package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;
import com.example.view.CreateAccountView;
import com.example.view.UpdateAccountView;

public class AccountDaoImpl implements AccountDao{
	private ArrayList<Account> accountList = new ArrayList<>();
	private Account createdAccount;
    private Account updatedAccount;
    private Account retrievedAccount;
    public Account getAccountDeposited() {
		return accountDeposited;
	}


	public void setAccountDeposited(Account accountDeposited) {
		this.accountDeposited = accountDeposited;
	}


	public Account getAccountWithdrawn() {
		return accountWithdrawn;
	}


	public void setAccountWithdrawn(Account accountWithdrawn) {
		this.accountWithdrawn = accountWithdrawn;
	}

	private Account account;
    private Account accountDeposited;
    private Account accountWithdrawn;

	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}


	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}


	public Account getCreatedAccount() {
		return createdAccount;
	}


	public void setCreatedAccount(Account createdAccount) {
		this.createdAccount = createdAccount;
	}


	public Account getUpdatedAccount() {
		return updatedAccount;
	}


	public void setUpdatedAccount(Account updatedAccount) {
		this.updatedAccount = updatedAccount;
	}


	public Account getRetrievedAccount() {
		return retrievedAccount;
	}


	public void setRetrievedAccount(Account retrievedAccount) {
		this.retrievedAccount = retrievedAccount;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	CustomerDB_Connection dbConnect = new CustomerDB_Connection();
	
	@Override
	public List<Account> get_all_account() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from checkings";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getDouble(4)));
			            }
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(accountList);
		return accountList;
	}

	
	@Override
	public Account create_new_account() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "insert into checkings(checking_no, customerid, checking_date_opened, checking_balance) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,    CreateAccountView.getAccountNO());
			ps.setInt(2, CreateAccountView.getCustomerID());
			ps.setString(3, CreateAccountView.getAccountDate());
			ps.setDouble(4, CreateAccountView.getAccountBalance());
			ps.execute();
			createdAccount = 
					new Account(CreateAccountView.getAccountNO(),
					CreateAccountView.getCustomerID(),
					CreateAccountView.getAccountDate(),
					CreateAccountView.getAccountBalance());
		}catch(SQLException e) {
			e.printStackTrace();
		}return createdAccount;
		
	}

	public Account retrieveAccount() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from checkings where checking_no= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  UpdateAccountView.getAccountNO());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				retrievedAccount = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getDouble(4));
				UpdateAccountView.setCustomerID(rs.getInt(2));
				UpdateAccountView.setAccountDate(rs.getString(3));
				UpdateAccountView.setAccountBalance(rs.getDouble(4));            
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return retrievedAccount;
	}
    
	public Account getAccount(String sql) {
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				setAccount(new Account(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getDouble(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(getAccount());
		return account;
	}
	


	@Override
	public Account update_an_account() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "update checkings set checking_no=?,customerid=?,checking_date_opened=?, checking_balance=? where checking_no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,    UpdateAccountView.getAccountNO());
			ps.setInt(2, UpdateAccountView.getCustomerID());
			ps.setString(3, UpdateAccountView.getAccountDate());
			ps.setDouble(4, UpdateAccountView.getAccountBalance());		
			ps.setInt(5,    UpdateAccountView.getAccountNO());
			ps.execute();
			updatedAccount = new Account(UpdateAccountView.getAccountNO(),
					UpdateAccountView.getCustomerID(),
					UpdateAccountView.getAccountDate(),
					UpdateAccountView.getAccountBalance());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return updatedAccount;
		
	}

	@Override
	public void delete_an_account(String sql) {
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
	        ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Account deposit_into_account(int accountNO, double amount) {
		String sql = "update checkings set checking_balance= ? where checking_no= ?";
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountNO);
	        ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}return accountDeposited;
	}
		

	@Override
	public Account withdraw_from_account(int accountNO, double amount) {
		String sql = "update checkings set checking_balance= ? where checking_no= ?";
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountNO);
	        ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accountWithdrawn;
	}

	public Account getAccount(int accountNO) {
		String sql = "select * from checkings where checking_no= ?";
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNO);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				setAccountDeposited(new Account(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getDouble(4)));
				setAccountWithdrawn(new Account(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getDouble(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(getAccount());
		return account;
	}

}
