package com.example;

import com.example.controller.AccountController;
import com.example.controller.ClientController;
import com.example.dao.AccountDaoImpl;
import com.example.dao.ClientDaoImpl;
import com.example.service.AccountService;
import com.example.service.ClientService;
import com.example.view.AppView;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AppDriver {
	

	public static void main(String[] args) {
		new AppView();
		
		
		Javalin app = Javalin.create(config->{
			config.enableCorsForAllOrigins();
		});

		app.start(9012);
		ClientService cServ = new ClientService();
		cServ.getAllClientID();
		AccountService aServ = new AccountService();
		aServ.getAllAccountID();
		aServ.getAccountBalance();
		
		app.get("/getAllClients",ClientController.GET_ALL_CLIENT);
		
		app.post("/newClient", ClientController.CREATE_NEW_CLIENT);
		
		app.put("/updateClient", ClientController.UPDATE_CLIENT);
		
        app.get("/getAccounts",AccountController.GET_ALL_ACCOUNT);
		
		app.post("/newAccount", AccountController.CREATE_NEW_ACCOUNT);
		
		app.put("/updateAccount", AccountController.UPDATE_ACCOUNT);
		
		ClientDaoImpl cDao = new ClientDaoImpl();
		final Handler GET_CLIENT = (ctx) ->{
			String cust_id = ctx.pathParam("cust_id");
			String sqlQ = "select * from customers where customerid= ";
			String sql = sqlQ.concat(cust_id);
			if(cServ.clientIDs.indexOf(Integer.parseInt(cust_id))!=-1) {
				cDao.getClient(sql);
				ctx.json(cDao.getCustomer()); 
				ctx.status(200);
				cServ.getAllClientID();
			}else {
				ctx.status(404);}
		};
		
		final Handler DELETE_CLIENT = (ctx) ->{
			String cust_id = ctx.pathParam("cust_id");
			String sqlQ = "delete from customers where customerid= ";
			String sql = sqlQ.concat(cust_id);
			if(cServ.clientIDs.indexOf(Integer.parseInt(cust_id))!=-1) {
				cDao.delete_a_client(sql);
				ctx.status(200);
				ctx.result("Client Deleted Successfully");
				cServ.getAllClientID();
			}else {
				ctx.status(404);}
		};
		
		
		AccountDaoImpl aDao = new AccountDaoImpl();
		final Handler GET_ACCOUNT = (ctx) ->{
			String acct_id = ctx.pathParam("acct_id");
			String sqlQ = "select * from checkings where checking_no= ";
			String sql = sqlQ.concat(acct_id);
			if(aServ.accountIDs.indexOf(Integer.parseInt(acct_id))!=-1) {
				aDao.getAccount(sql);
				ctx.json(aDao.getAccount()); 
				ctx.status(200);
				aServ.getAllAccountID();
			}else {
				ctx.status(404);}
		};
		
		final Handler DELETE_ACCOUNT = (ctx) ->{
			String acct_id = ctx.pathParam("acct_id");
			String sqlQ = "delete from checkings where checking_no= ";
			String sql = sqlQ.concat(acct_id);
			if(aServ.accountIDs.indexOf(Integer.parseInt(acct_id))!=-1) {
				aDao.delete_an_account(sql);
				ctx.status(200);
				ctx.result("Client's Account Successfully Deleted ");
				aServ.getAllAccountID();
			}else {
				ctx.status(404);}
		};
		
		final Handler GET_CLIENT_ACCOUNTS = (ctx) ->{
			String cust_id = ctx.pathParam("cust_id");
			int x = Integer.parseInt(cust_id);
			if(cServ.clientIDs.indexOf(Integer.parseInt(cust_id))!=-1) {
				cDao.get_all_clientAccounts(x);
				ctx.json(cDao.getClientAccounts());
				ctx.status(200);
				cServ.getAllClientID();
				aServ.getAllAccountID();
			}else {
				ctx.status(404);}
		};
		
		final Handler ACCOUNT_DEPOSIT = (ctx) ->{
			String acct_no = ctx.pathParam("acct_no");
			int accNum = Integer.parseInt(acct_no);
			String amt = ctx.pathParam("amt");
			double amountDeposited = Double.parseDouble(amt);
			if(aServ.accountIDs.indexOf(Integer.parseInt(acct_no))!=-1) {
				double amountTotal = amountDeposited+aServ.accountBalance.get(accNum);
				aDao.deposit_into_account(accNum, amountTotal);
				aDao.getAccount(accNum);
				ctx.json(aDao.getAccountDeposited());
				ctx.status(200);
				cServ.getAllClientID();
				aServ.getAllAccountID();
				aServ.getAccountBalance();
			}else {
				ctx.status(404);}
		};
		
		final Handler ACCOUNT_WITHDRAW = (ctx) ->{
			String acct_no = ctx.pathParam("acct_no");
			int accNum = Integer.parseInt(acct_no);
			String amt = ctx.pathParam("amt");
			double amountWithdrawn = Double.parseDouble(amt);
			if(amountWithdrawn>0&&aServ.accountIDs.indexOf(Integer.parseInt(acct_no))!=-1) {
				double amountTotal = aServ.accountBalance.get(accNum)-amountWithdrawn;
				aDao.deposit_into_account(accNum, amountTotal);
				aDao.getAccount(accNum);
				ctx.json(aDao.getAccountWithdrawn());
				ctx.status(200);
				cServ.getAllClientID();
				aServ.getAllAccountID();
				aServ.getAccountBalance();
			}else {
				ctx.status(404);}
		};
		
		app.get("/retrieveClient/:cust_id", GET_CLIENT);
		
		app.delete("/deleteClient/:cust_id", DELETE_CLIENT);
		
        app.get("/retrieveAccount/:acct_id", GET_ACCOUNT);
		
		app.delete("/deleteAccount/:acct_id", DELETE_ACCOUNT);
	
		app.get("/getClientAccounts/:cust_id", GET_CLIENT_ACCOUNTS);
		
		app.patch("/accountDeposit/:acct_no/:amt", ACCOUNT_DEPOSIT);
		
		app.patch("/accountWithdrawal/:acct_no/:amt", ACCOUNT_WITHDRAW);
	}

}
