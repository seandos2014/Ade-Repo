
package com.example.controller;

import com.example.dao.AccountDaoImpl;
import com.example.model.Account;
import com.example.service.AccountService;
import com.example.view.CreateAccountView;
import com.example.view.UpdateAccountView;

import io.javalin.http.Handler;

public class AccountController {

		Account account = new Account();
		static  AccountDaoImpl aDao = new AccountDaoImpl();
		static AccountService aServ = new AccountService();
		
		public static final Handler GET_ALL_ACCOUNT = (ctx) ->{
			aDao.get_all_account();
			if(aDao.getAccountList()!=null) {
				ctx.json(aDao.getAccountList());
				ctx.status(200);
				aServ.getAllAccountID();
			}else {
				ctx.status(404);}
		};
		
		
		public static final Handler CREATE_NEW_ACCOUNT = (ctx) ->{
			aServ.getAllAccountID();
			if(aServ.accountIDs.indexOf(CreateAccountView.getAccountNO())==-1) {
				aDao.create_new_account();
				ctx.json(aDao.getCreatedAccount()); 
				ctx.status(201);
				aServ.getAllAccountID();
			}else {
				ctx.status(404);}
		};
		
		public static final Handler UPDATE_ACCOUNT = (ctx) ->{
			aServ.getAllAccountID();
			if(aServ.accountIDs.indexOf(UpdateAccountView.getAccountNO())!=-1) {
				aDao.update_an_account();
				ctx.json(aDao.getUpdatedAccount()); 
				ctx.status(200);
				aServ.getAllAccountID();
			}else {
				ctx.status(404);}

		
		};	


	
}