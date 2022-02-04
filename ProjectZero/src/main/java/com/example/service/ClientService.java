package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.CustomerDB_Connection;

public class ClientService {
	CustomerDB_Connection dbConnect = new CustomerDB_Connection();
	public List<Integer> clientIDs = new ArrayList<Integer>();
	
	
	
	public List<Integer> getAllClientID() {
		try(Connection con = dbConnect.getDBConnection()){
			String sql = "select * from customers";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				clientIDs.add(rs.getInt(1));
			            }
		}catch(SQLException e) {
			e.printStackTrace();
		}System.out.println(clientIDs);
		return clientIDs;
	}

		
}
