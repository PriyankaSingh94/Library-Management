package main.java.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import main.java.DAO.LoginDAO;

public class LoginPage implements ActionListener {
	LoginDAO lgn;
	JFrame frame ;
	JPanel main ;
	JPanel panel ;
	JPanel myLib ;
	JLabel userlbl ;
	JTextField username ;
	JLabel passlbl ;
	JTextField password ;
	JButton login ;
	
	public void loginIntoApp(){
		
		frame = new JFrame();
		main = new JPanel();
		panel = new JPanel();
		myLib = new JPanel();
		userlbl = new JLabel("UserName : ");
		username = new  JTextField(15);
		passlbl = new JLabel("Password : ");
		password = new  JTextField(15);
		login = new JButton("Login");
		login.addActionListener(this);
		login.setBackground(Color.ORANGE);
		
		panel.add(Box.createVerticalStrut(100));
		panel.setSize(100, 500);
		panel.add(userlbl, BorderLayout.WEST);
		panel.add(username, BorderLayout.EAST);
		panel.add(Box.createVerticalStrut(20));
		panel.add(passlbl);
		panel.add(password);
		panel.add(Box.createVerticalStrut(20));
		panel.add(login);
		panel.setBackground(new Color(30, 144, 255));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		myLib.setBackground(Color.RED);
		
		main.add(panel);
		main.setBackground(new Color(30, 144, 255));
		frame.getContentPane().add(BorderLayout.EAST,main);
		frame.getContentPane().add(new JLabel(new ImageIcon("C:/Users/pc/Downloads/MyLibrary.JPG")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Library");
		frame.setSize(500, 700);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent evt){
		System.out.println("logged in");
		lgn = new LoginDAO();
		lgn.loginUser(username.getText(),password.getText());
		
	}
}
