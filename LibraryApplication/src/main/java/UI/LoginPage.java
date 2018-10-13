package main.java.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.DAO.LoginDAO;

public class LoginPage implements ActionListener {

	String username;
	String password;
	LoginDAO lgn;
	JFrame frame;
	JPanel main;
	JPanel panel;
	JLabel userlbl;
	JTextField userName;
	JLabel passlbl;
	JTextField passWord;
	JButton login;
	JLabel userError;
	JLabel passError;
	JOptionPane error = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE);

	public void loginIntoApp() {

		frame = new JFrame();
		main = new JPanel();
		panel = new JPanel();
		userlbl = new JLabel("UserName : ");
		userName = new JTextField(20);
		userError = new JLabel("Username is empty");
		userError.setForeground(Color.red);
		userError.setVisible(false);
		passlbl = new JLabel("Password : ");
		passWord = new JTextField(20);
		passError = new JLabel("Password is empty");
		passError.setForeground(Color.red);
		passError.setVisible(false);
		login = new JButton("Login");
		login.addActionListener(this);
		login.setBackground(Color.ORANGE);

		panel.add(Box.createVerticalStrut(100));
		panel.setSize(100, 500);
		panel.add(userlbl);
		panel.add(userName);
		panel.add(userError);
		panel.add(Box.createVerticalStrut(20));
		panel.add(passlbl);
		panel.add(passWord);
		panel.add(passError);
		panel.add(Box.createVerticalStrut(20));
		panel.add(login);
		panel.add(Box.createVerticalStrut(20));
		JPanel sign = new JPanel();
		sign.setBackground(new Color(30, 144, 255));
		JLabel s1 = new JLabel("Not an user ");
		JLabel signUp = new JLabel("Sign Up");
		signUp.setForeground(Color.orange);
		signUp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AddUserPage usr = new AddUserPage();
				try {
					usr.addUser();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		JLabel s2 = new JLabel(" here ");
		sign.add(s1);
		sign.add(signUp);
		sign.add(s2);
		panel.add(sign);
		panel.setBackground(new Color(30, 144, 255));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		main.add(panel);
		main.setBackground(new Color(30, 144, 255));
		frame.getContentPane().add(BorderLayout.EAST, main);
		frame.getContentPane().add(new JLabel(new ImageIcon("C:/Users/pc/Downloads/MyLibrary.JPG")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Library");
		frame.setBounds(350, 30, 600, 650);
		frame.setVisible(true);

		userName.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {

			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				userError.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
			}
			// implement the methods
		});
		passWord.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				passError.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
			}
			// implement the methods
		});
	}

	public void actionPerformed(ActionEvent evt) {
		System.out.println("logged in");
		username = userName.getText().trim();
		password = passWord.getText().trim();
		userError.setVisible(false);
		passError.setVisible(false);
		if (username.equals("") || password.equals("")) {
			if (username.equals("")) {
				error = new JOptionPane("Empty Username", JOptionPane.ERROR_MESSAGE);
				userError.setVisible(true);
			} else {
				error = new JOptionPane("Empty Password", JOptionPane.ERROR_MESSAGE);
				passError.setVisible(true);
			}
			// JDialog dialog = error.createDialog("Error");
			// dialog.setAlwaysOnTop(true);
			// dialog.setVisible(true);
		} else {
			lgn = new LoginDAO();
			lgn.loginUser(username, password);
		}
//		HomePage hm = new HomePage();
//		try {
//			hm.welcome();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
