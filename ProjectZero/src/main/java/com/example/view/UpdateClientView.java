package com.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.dao.ClientDaoImpl;
import com.example.model.Client;

public class UpdateClientView {
	private static String firstname,lastname,username,customer_email,customer_address,phoneNumber;
	private static int customerID, customer_age;
	
	public static String getFirstname() {
		return firstname;
	}

	public static void setFirstname(String firstname) {
		UpdateClientView.firstname = firstname;
	}

	public static String getLastname() {
		return lastname;
	}

	public static void setLastname(String lastname) {
		UpdateClientView.lastname = lastname;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		UpdateClientView.username = username;
	}

	public static String getCustomer_email() {
		return customer_email;
	}

	public static void setCustomer_email(String customer_email) {
		UpdateClientView.customer_email = customer_email;
	}

	public static String getCustomer_address() {
		return customer_address;
	}

	public static void setCustomer_address(String customer_address) {
		UpdateClientView.customer_address = customer_address;
	}

	public static String getPhoneNumber() {
		return phoneNumber;
	}

	public static void setPhoneNumber(String phoneNumber) {
		UpdateClientView.phoneNumber = phoneNumber;
	}

	public static int getCustomerID() {
		return customerID;
	}

	public static void setCustomerID(int customerID) {
		UpdateClientView.customerID = customerID;
	}

	public static int getCustomer_age() {
		return customer_age;
	}

	public static void setCustomer_age(int customer_age) {
		UpdateClientView.customer_age = customer_age;
	}

	JFrame frame = new JFrame("Update Client");
	Client client = new Client();
	 //view variables
		JLabel custId = new JLabel("Customer ID:");
		JLabel fname = new JLabel("Firstname:");
		JLabel lname = new JLabel("Lastname:");
		JLabel uname = new JLabel("Username:");
		JLabel email = new JLabel("Email:");
		JLabel age = new JLabel("Age:");
		JLabel address = new JLabel("Address:");
		JLabel phone = new JLabel("Phone:");
		
		JLabel hint = new JLabel("Enter Customer ID to retrieve before updating");
		
		JTextField ct = new JTextField();
		JTextField ft = new JTextField();
		JTextField lt = new JTextField();
		JTextField ut = new JTextField();
		JTextField et = new JTextField();
		JTextField at = new JTextField();
		JTextField adt = new JTextField();
		JTextField pt = new JTextField();
		
		JButton sub = new JButton("Update");
		JButton ret = new JButton("Retrieve");
		
		public UpdateClientView() {
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setSize(350, 350);
			frame.add(custId);
			frame.add(fname);
			frame.add(lname);
			frame.add(uname);
			frame.add(email);
			frame.add(age);
			frame.add(address);
			frame.add(phone);
			frame.add(ct);
			frame.add(ft);
			frame.add(lt);
			frame.add(ut);
			frame.add(et);
			frame.add(at);
			frame.add(adt);
			frame.add(pt);
			frame.add(sub);
			frame.add(ret);
			frame.add(hint);
			
			frame.add(hint);
			custId.setBounds(5, 5, 100, 20);
			fname.setBounds(5, 30, 100, 20);
			lname.setBounds(5, 60, 100, 20);
			uname.setBounds(5, 90, 100, 20);
			email.setBounds(5, 120, 100, 20);
			age.setBounds(5, 150, 100, 20);
			address.setBounds(5, 180, 100, 20);
			phone.setBounds(5, 210, 100, 20);
			
			ct.setBounds(110, 5, 200, 20);
			ft.setBounds(110, 30, 200, 20);
			lt.setBounds(110, 60, 200, 20);
			ut.setBounds(110, 90, 200, 20);
			et.setBounds(110, 120, 200, 20);
			at.setBounds(110, 150, 200, 20);
			adt.setBounds(110, 180, 200, 20);
			pt.setBounds(110, 210, 200, 20);
			
			sub.setBounds(110, 240, 100, 20);
			ret.setBounds(215, 240, 100, 20);
			hint.setBounds(5, 280, 300, 20);
			sub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setCustomerID(Integer.parseInt(ct.getText()));
					setFirstname(ft.getText());
					setLastname(lt.getText());
					setUsername(ut.getText());
					setCustomer_email(et.getText());
					setCustomer_age(Integer.parseInt(at.getText()));
					setCustomer_address(adt.getText());
					setPhoneNumber(pt.getText());
				}
			});
			
			ret.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setCustomerID(Integer.parseInt(ct.getText()));
					ClientDaoImpl cDao = new ClientDaoImpl();
					cDao.retrieveClient();
					
					ft.setText(firstname);
					lt.setText(lastname);
					ut.setText(username);
					et.setText(customer_email);
					at.setText(customer_age+"");
					adt.setText(customer_address);
					pt.setText(phoneNumber);
				}
			});
		}

}
