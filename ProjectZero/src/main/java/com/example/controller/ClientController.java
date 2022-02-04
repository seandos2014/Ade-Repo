package com.example.controller;

import com.example.dao.ClientDaoImpl;
import com.example.model.Client;
import com.example.service.ClientService;
import com.example.view.CreateClientView;

import io.javalin.http.Handler;

public class ClientController {
	Client client = new Client();
	static  ClientDaoImpl cDao = new ClientDaoImpl();
	static ClientService cServ = new ClientService();
	
	public static final Handler GET_ALL_CLIENT = (ctx) ->{
		cDao.get_all_client();
		if(cDao.getClientList()!=null) {
			ctx.json(cDao.getClientList());
			ctx.status(200);
			cServ.getAllClientID();
		}else {
			ctx.status(404);}
	};
	
	
	public static final Handler CREATE_NEW_CLIENT = (ctx) ->{
		cServ.getAllClientID();
		if(cServ.clientIDs.indexOf(CreateClientView.getCreatedCustId())==-1) {
			cDao.create_new_client();
			ctx.json(cDao.getCreatedClient()); 
			ctx.status(201);
			cServ.getAllClientID();
		}else {
			ctx.status(404);}
	};
	
	public static final Handler UPDATE_CLIENT = (ctx) ->{
		cServ.getAllClientID();
		if(cServ.clientIDs.indexOf(CreateClientView.getCreatedCustId())!=-1) {
			cDao.update_a_client();
			ctx.json(cDao.getUpdatedClient()); 
			ctx.status(200);
			cServ.getAllClientID();
		}else {
			ctx.status(404);}
	};
	
	

}
