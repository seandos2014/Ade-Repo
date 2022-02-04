package com.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppView {
JFrame frame = new JFrame("App View");
JButton butC = new JButton("New Client");
JButton butA = new JButton("New Account");
JButton upC = new JButton("Update Client");
JButton upA = new JButton("Update Account");


public AppView() {
	frame.setVisible(true);
	frame.setLayout(null);
	frame.setSize(350, 350);
	
	butC.setBounds(5, 5, 150, 20);
	butA.setBounds(5, 30, 150, 20);
	upC.setBounds(155, 5, 150, 20);
	upA.setBounds(155, 30, 150, 20);
	frame.add(butA);
	frame.add(butC);
	frame.add(upC);
	frame.add(upA);
	
	butC.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			new CreateClientView();
		}});
	butA.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			new CreateAccountView();
		}});
	upC.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			new UpdateClientView();
		}});
	upA.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			new UpdateAccountView();
		}});
}
}
