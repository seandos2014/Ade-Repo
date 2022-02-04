
package com.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.dao.AccountDaoImpl;
import com.example.model.Account;

public class UpdateAccountView {
	private static int accountNO;
	private static int customerID;
	private static String accountDate;
	private static Double accountBalance;
	public static int getAccountNO() {
		return accountNO;
	}

	public static void setAccountNO(int accountNO) {
		UpdateAccountView.accountNO = accountNO;
	}

	public static int getCustomerID() {
		return customerID;
	}

	public static void setCustomerID(int customerID) {
		UpdateAccountView.customerID = customerID;
	}

	public static String getAccountDate() {
		return accountDate;
	}

	public static void setAccountDate(String accountDate) {
		UpdateAccountView.accountDate = accountDate;
	}

	public static Double getAccountBalance() {
		return accountBalance;
	}

	public static void setAccountBalance(Double accountBalance) {
		UpdateAccountView.accountBalance = accountBalance;
	}

	JFrame frame = new JFrame("New Account");
	Account account = new Account();
 //view variables
	JLabel custId = new JLabel("Account No:");
	JLabel fname = new JLabel("Customer ID:");
	JLabel lname = new JLabel("Date Opened:");
	JLabel uname = new JLabel("Balance:");
	
	JLabel hint = new JLabel("Enter Account No to retrieve before updating");
			
	JTextField ct = new JTextField();
	JTextField ft = new JTextField();
	JTextField lt = new JTextField();
	JTextField ut = new JTextField();

	JButton sub = new JButton("Update");
	JButton ret = new JButton("Retrieve");
	
	public UpdateAccountView() {
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(350, 350);
		frame.add(custId);
		frame.add(fname);
		frame.add(lname);
		frame.add(uname);
		
		frame.add(ct);
		frame.add(ft);
		frame.add(lt);
		frame.add(ut);
		frame.add(sub);
		frame.add(sub);
		frame.add(ret);

		frame.add(hint);
       
		custId.setBounds(5, 5, 100, 20);
		fname.setBounds(5, 30, 100, 20);
		lname.setBounds(5, 60, 100, 20);
		uname.setBounds(5, 90, 100, 20);
		ct.setBounds(110, 5, 200, 20);
		ft.setBounds(110, 30, 200, 20);
		lt.setBounds(110, 60, 200, 20);
		ut.setBounds(110, 90, 200, 20);
		
		sub.setBounds(110, 120, 100, 20);
		ret.setBounds(215, 120, 100, 20);
		hint.setBounds(5, 150, 300, 20);
		
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		   setAccountNO(Integer.parseInt(ct.getText()));
		   setCustomerID(Integer.parseInt(ft.getText()));
		   setAccountDate(lt.getText());
		   setAccountBalance(Double.parseDouble(ut.getText()));
			}});
		ret.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setAccountNO(Integer.parseInt(ct.getText()));
				AccountDaoImpl aDao = new AccountDaoImpl();
				aDao.retrieveAccount();
				
				ct.setText(accountNO+"");
				ft.setText(customerID+"");
				lt.setText(accountDate);
				ut.setText(accountBalance+"");
			}});

	}


}
