package com.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateClientView {
	private static int createdCustId;
	public static int getCreatedCustId() {
		return createdCustId;
	}

	public static void setCreatedCustId(int createdCustId) {
		CreateClientView.createdCustId = createdCustId;
	}

	public static String getFirstname() {
		return firstname;
	}

	public static void setFirstname(String firstname) {
		CreateClientView.firstname = firstname;
	}

	public static String getLastname() {
		return lastname;
	}

	public static void setLastname(String lastname) {
		CreateClientView.lastname = lastname;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		CreateClientView.username = username;
	}

	public static String getCustomer_email() {
		return customer_email;
	}

	public static void setCustomer_email(String customer_email) {
		CreateClientView.customer_email = customer_email;
	}

	public static String getCustomer_address() {
		return customer_address;
	}

	public static void setCustomer_address(String customer_address) {
		CreateClientView.customer_address = customer_address;
	}

	public static String getPhoneNumber() {
		return phoneNumber;
	}

	public static void setPhoneNumber(String phoneNumber) {
		CreateClientView.phoneNumber = phoneNumber;
	}

	public static int getCustomerID() {
		return customerID;
	}

	public static void setCustomerID(int customerID) {
		CreateClientView.customerID = customerID;
	}

	public static int getCustomer_age() {
		return customer_age;
	}

	public static void setCustomer_age(int customer_age) {
		CreateClientView.customer_age = customer_age;
	}

	private static String firstname,lastname,username,customer_email,customer_address,phoneNumber;
	private static int customerID, customer_age;
 //view variables
	JFrame frame2 = new JFrame("New Client");
	JLabel custId = new JLabel("Customer ID:");
	JLabel fname = new JLabel("Firstname:");
	JLabel lname = new JLabel("Lastname:");
	JLabel uname = new JLabel("Username:");
	JLabel email = new JLabel("Email:");
	JLabel age = new JLabel("Age:");
	JLabel address = new JLabel("Address:");
	JLabel phone = new JLabel("Phone:");
	
	JTextField ct = new JTextField();
	JTextField ft = new JTextField();
	JTextField lt = new JTextField();
	JTextField ut = new JTextField();
	JTextField et = new JTextField();
	JTextField at = new JTextField();
	JTextField adt = new JTextField();
	JTextField pt = new JTextField();
	JButton sub = new JButton("Create");
	
	public CreateClientView() {
		frame2.setVisible(true);
		frame2.setLayout(null);
		frame2.setSize(350, 350);
		frame2.add(custId);
		frame2.add(fname);
		frame2.add(lname);
		frame2.add(uname);
		frame2.add(email);
		frame2.add(age);
		frame2.add(address);
		frame2.add(phone);
		frame2.add(ct);
		frame2.add(ft);
		frame2.add(lt);
		frame2.add(ut);
		frame2.add(et);
		frame2.add(at);
		frame2.add(adt);
		frame2.add(pt);
        frame2.add(sub);		
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
				setCreatedCustId(Integer.parseInt(ct.getText()));
			}
		});
		
	}
}
