package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Account;
import com.example.model.Client;
import com.example.view.CreateClientView;
import com.example.view.UpdateClientView;

public class ClientDaoImpl implements ClientDao{
	private ArrayList<Client> clientList = new ArrayList<>();
	private Client createdClient;
	private List<Object> accountList = new ArrayList<>();
    private Account createdAccount;
    private Client updatedClient;
    private Client retrievedClient;
    private Client customer;
    private List<Object> clientAccounts = new ArrayList<>();
    
	public List<Object> getClientAccounts() {
		return clientAccounts;
	}

	public void setClientAccounts(List<Object> clientAccounts) {
		this.clientAccounts = clientAccounts;
	}

	public Client getCustomer() {
		return customer;
	}

	public void setCustomer(Client customer) {
		this.customer = customer;
	}

	public Client getRetrievedClient() {
		return retrievedClient;
	}

	public void setRetrievedClient(Client retrievedClient) {
		this.retrievedClient = retrievedClient;
	}

	public Client getUpdatedClient() {
		return updatedClient;
	}

	public void setUpdatedClient(Client updatedClient) {
		this.updatedClient = updatedClient;
	}

	public ArrayList<Client> getClientList() {
		return clientList;
	}

	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}

	public Client getCreatedClient() {
		return createdClient;
	}

	public void setCreatedClient(Client createdClient) {
		this.createdClient = createdClient;
	}

	public List<Object> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Object> accountList) {
		this.accountList = accountList;
	}

	public Account getCreatedAccount() {
		return createdAccount;
	}

	public void setCreatedAccount(Account createdAccount) {
		this.createdAccount = createdAccount;
	}

	CustomerDB_Connection dbConnect = new CustomerDB_Connection();
	
	@Override
	public List<Client> get_all_client() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from customers";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				clientList.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),
						rs.getString(7),rs.getString(8)));
			            }
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(clientList);
		return clientList;
	}

	public List<Object> get_all_clientAccounts(int customer_id) {
     try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from customers cu left outer join checkings ch on cu.customerid = ch.customerid where cu.customerid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				clientAccounts.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),
						rs.getString(7),rs.getString(8)));
				accountList.add(new Account(rs.getInt("checking_no"), rs.getInt("customerid"), rs.getString("checking_date_opened"), rs.getDouble("checking_balance")));		
			clientAccounts.add(accountList);
			}
			return clientAccounts;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client create_new_client() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select new_customer(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,    CreateClientView.getCustomerID());
			ps.setString(2, CreateClientView.getFirstname());
			ps.setString(3, CreateClientView.getLastname());
			ps.setString(4, CreateClientView.getUsername());
			ps.setString(5, CreateClientView.getCustomer_email());
			ps.setInt(6,    CreateClientView.getCustomer_age());
			ps.setString(7, CreateClientView.getCustomer_address());
			ps.setString(8, CreateClientView.getPhoneNumber());
			ps.execute();
			createdClient = new Client(CreateClientView.getCustomerID(),
					CreateClientView.getFirstname(),
					CreateClientView.getLastname(),
					CreateClientView.getUsername(),
					CreateClientView.getCustomer_email(),
					CreateClientView.getCustomer_age(),
					CreateClientView.getCustomer_address(),
					CreateClientView.getPhoneNumber());
		}catch(SQLException e) {
			e.printStackTrace();
		}return createdClient;
		
	}

	public Client retrieveClient() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from customers where customerid= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  UpdateClientView.getCustomerID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				retrievedClient = new Client(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),
						rs.getString(7),rs.getString(8));
				UpdateClientView.setCustomerID(rs.getInt(1));
				UpdateClientView.setFirstname(rs.getString(2));
				UpdateClientView.setLastname(rs.getString(3));
				UpdateClientView.setUsername(rs.getString(4));
				UpdateClientView.setCustomer_email(rs.getString(5));
				UpdateClientView.setCustomer_age(rs.getInt(6));
				UpdateClientView.setCustomer_address(rs.getString(7));
				UpdateClientView.setPhoneNumber(rs.getString(8));            
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return retrievedClient;
	}
    
	public Client getClient(String sql) {
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				setCustomer(new Client(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),
						rs.getString(7),rs.getString(8)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(getCustomer());
		return customer;
	}
	


	@Override
	public Client update_a_client() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "update customers set customerid=?,firstname=?,lastname=?,username=?,email=?,customer_age=?,address=?,phone=? where customerid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,    UpdateClientView.getCustomerID());
			ps.setString(2, UpdateClientView.getFirstname());
			ps.setString(3, UpdateClientView.getLastname());
			ps.setString(4, UpdateClientView.getUsername());
			ps.setString(5, UpdateClientView.getCustomer_email());
			ps.setInt(6,    UpdateClientView.getCustomer_age());
			ps.setString(7, UpdateClientView.getCustomer_address());
			ps.setString(8, UpdateClientView.getPhoneNumber());
			ps.setInt(9,    UpdateClientView.getCustomerID());
			ps.execute();
			updatedClient = new Client(CreateClientView.getCustomerID(),
					UpdateClientView.getFirstname(),
					UpdateClientView.getLastname(),
					UpdateClientView.getUsername(),
					UpdateClientView.getCustomer_email(),
					UpdateClientView.getCustomer_age(),
					UpdateClientView.getCustomer_address(),
					UpdateClientView.getPhoneNumber());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return updatedClient;
		
	}

	@Override
	public void delete_a_client(String sql) {
		try(Connection con = dbConnect.getDBConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
	        ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
