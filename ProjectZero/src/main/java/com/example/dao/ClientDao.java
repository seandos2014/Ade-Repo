package com.example.dao;

import java.util.List;

import com.example.model.Client;

public interface ClientDao {

	/*
	 * the following Data Access Object methods
	 * are to be implemented 
	 * in the concrete class
	 * of this interface 
	 * To be implemented in 
	 * the ClientDaoimpl
	 */
    List<?> get_all_client();
	
    Client getClient(String sql);
	
	Client create_new_client();
	
	Client update_a_client();
	
	void  delete_a_client(String sql);
	
	
}
