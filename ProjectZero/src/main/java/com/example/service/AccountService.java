package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dao.CustomerDB_Connection;

public class AccountService {

	CustomerDB_Connection dbConnect = new CustomerDB_Connection();
	public List<Integer> accountIDs = new ArrayList<Integer>();
	public Map<Integer, Double> accountBalance = new HashMap<Integer, Double>();
	
	
	
	public List<Integer> getAllAccountID() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from checkings";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountIDs.add(rs.getInt(1));
			            }
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(accountIDs);
		return accountIDs;
	}

	public Map<Integer, Double> getAccountBalance() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from checkings";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountBalance.put(rs.getInt(1), rs.getDouble(4));
			            }
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(accountBalance);
		return accountBalance;
	}

	
	
}
