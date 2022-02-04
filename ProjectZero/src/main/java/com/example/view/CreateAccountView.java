package com.example.view;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

import com.example.model.Account;

	public class CreateAccountView {
		private static int accountNO;
		private static int customerID;
		private static String accountDate;
		private static Double accountBalance;
		
		public static int getAccountNO() {
			return accountNO;
		}

		public static void setAccountNO(int accountNO) {
			CreateAccountView.accountNO = accountNO;
		}

		public static int getCustomerID() {
			return customerID;
		}

		public static void setCustomerID(int customerID) {
			CreateAccountView.customerID = customerID;
		}

		public static String getAccountDate() {
			return accountDate;
		}

		public static void setAccountDate(String accountDate) {
			CreateAccountView.accountDate = accountDate;
		}

		public static Double getAccountBalance() {
			return accountBalance;
		}

		public static void setAccountBalance(Double accountBalance) {
			CreateAccountView.accountBalance = accountBalance;
		}

		JFrame frame = new JFrame("New Account");
		Account account = new Account();
	 //view variables
		JLabel custId = new JLabel("Account No:");
		JLabel fname = new JLabel("Customer ID:");
		JLabel lname = new JLabel("Date Opened:");
		JLabel uname = new JLabel("Balance:");
				
		JTextField ct = new JTextField();
		JTextField ft = new JTextField();
		JTextField lt = new JTextField();
		JTextField ut = new JTextField();

		JButton sub = new JButton("Create");
		
		public CreateAccountView() {
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setSize(350, 350);
			frame.add(custId);
			frame.add(fname);
			frame.add(lname);
			frame.add(uname);
			frame.add(sub);
			frame.add(ct);
			frame.add(ft);
			frame.add(lt);
			frame.add(ut);
			
			custId.setBounds(5, 5, 100, 20);
			fname.setBounds(5, 30, 100, 20);
			lname.setBounds(5, 60, 100, 20);
			uname.setBounds(5, 90, 100, 20);
			ct.setBounds(110, 5, 200, 20);
			ft.setBounds(110, 30, 200, 20);
			lt.setBounds(110, 60, 200, 20);
			ut.setBounds(110, 90, 200, 20);
			
			sub.setBounds(110, 120, 100, 20);
			
	sub.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
			   int acctN = Integer.parseInt(ct.getText());
			   int custN = Integer.parseInt(ft.getText());
			   setAccountNO(acctN);
			   setCustomerID(custN);
			   setAccountDate(lt.getText());
			   setAccountBalance(Double.parseDouble(ut.getText()));
				}});
	
		}


}
