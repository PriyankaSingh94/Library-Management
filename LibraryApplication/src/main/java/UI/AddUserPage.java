package main.java.UI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import main.java.DAO.AddUserDAO;
import main.java.DAO.RolesAndDepartmentsDAO;
import main.java.DTOs.*;

public class AddUserPage implements ActionListener {

	JFrame frame;
	JButton submit;
	JButton cancel;
	JButton reset;
	JTextField nameFirst;
	JTextField nameLast;
	JTextField mail;
	JTextField contact;
	JTextField usrName;
	JTextField pswrd;
	JTextField reEnter;
	JTextArea address;
	JComboBox<String> roles;
	JComboBox<String> depts;
	String[] roleNames;
	String[] deptNames;
	String deptName;

	public void addUser() throws SQLException {

		frame = new JFrame();
		submit = new JButton("Add User");
		JLabel wlcmLbl = new JLabel("Welcome User");
		JLabel frstName = new JLabel("First name : ");
		JLabel lastName = new JLabel("Last name : ");
		JLabel email = new JLabel("Email : ");
		JLabel contactNo = new JLabel("Contact No. : ");
		JLabel contactAdd = new JLabel("Address : ");
		JLabel rolesLbl = new JLabel("Roles : ");
		JLabel deptLbl = new JLabel("Departments : ");
		JLabel userName = new JLabel("Username : ");
		JLabel password = new JLabel("Password : ");
		JLabel pswrdReEnter = new JLabel("Please enter password again");
		nameFirst = new JTextField(20);
		nameLast = new JTextField(20);
		mail = new JTextField(20);
		contact = new JTextField(10);
		usrName = new JTextField(10);
		pswrd = new JTextField(10);
		reEnter = new JTextField(10);
		address = new JTextArea();
		getRolesAndDepartments();
		roles = new JComboBox<String>(roleNames);
		depts = new JComboBox<String>(deptNames);
		Font f1 = new Font("Serif", Font.BOLD, 18);
		Font f2 = new Font("Serif", Font.BOLD, 16);

		wlcmLbl.setForeground(Color.ORANGE);
		wlcmLbl.setFont(new Font("Serif", Font.BOLD, 22));
		wlcmLbl.setBounds(230, 0, 150, 50);
		frstName.setFont(f1);
		frstName.setBounds(15, 100, 100, 20);
		nameFirst.setFont(f2);
		nameFirst.setBounds(130, 100, 150, 20);
		lastName.setFont(f1);
		lastName.setBounds(285, 100, 100, 20);
		nameLast.setFont(f2);
		nameLast.setBounds(400, 100, 150, 20);
		email.setFont(f1);
		email.setBounds(15, 155, 100, 20);
		mail.setFont(f2);
		mail.setBounds(130, 155, 200, 20);
		contactNo.setFont(f1);
		contactNo.setBounds(15, 210, 150, 20);
		contact.setFont(f2);
		contact.setBounds(130, 210, 150, 20);
		contactAdd.setFont(f1);
		contactAdd.setBounds(15, 265, 100, 20);
		address.setFont(f2);
		address.setBounds(130, 265, 250, 20);
		rolesLbl.setFont(f1);
		rolesLbl.setBounds(15, 320, 100, 20);
		roles.setFont(f1);
		roles.setBounds(130, 320, 100, 20);
		deptLbl.setFont(f1);
		deptLbl.setBounds(285, 320, 160, 20);
		depts.setFont(f2);
		depts.setBounds(400, 320, 100, 20);
		userName.setFont(f1);
		userName.setBounds(15, 375, 100, 20);
		usrName.setFont(f2);
		usrName.setBounds(130, 375, 150, 20);
		password.setFont(f1);
		password.setBounds(15, 430, 100, 20);
		pswrd.setFont(f2);
		pswrd.setBounds(130, 430, 150, 20);
		pswrdReEnter.setFont(new Font("Serif", Font.PLAIN, 14));
		pswrdReEnter.setForeground(Color.RED);
		pswrdReEnter.setBounds(130, 460, 300, 20);
		reEnter.setFont(f2);
		reEnter.setBounds(130, 485, 150, 20);
		submit.setFont(f1);
		submit.setBackground(Color.ORANGE);
		submit.setBounds(230, 540, 150, 40);
		submit.addActionListener(this);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		frame.setBounds(350, 30, 600, 650);
		frame.setTitle("Add User");
		frame.add(wlcmLbl);
		frame.add(frstName);
		frame.add(nameFirst);
		frame.add(lastName);
		frame.add(nameLast);
		frame.add(email);
		frame.add(mail);
		frame.add(contactNo);
		frame.add(contact);
		frame.add(contactAdd);
		frame.add(address);
		frame.add(rolesLbl);
		frame.add(roles);
		frame.add(deptLbl);
		frame.add(depts);
		frame.add(userName);
		frame.add(usrName);
		frame.add(password);
		frame.add(pswrd);
		frame.add(pswrdReEnter);
		frame.add(reEnter);
		frame.add(submit);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void getRolesAndDepartments() throws SQLException {

		ArrayList<RoleDTO> rolesList = new ArrayList<RoleDTO>();
		RolesAndDepartmentsDAO obj = new RolesAndDepartmentsDAO();
		ArrayList<DepartmentDTO> deptsList = new ArrayList<DepartmentDTO>();
		int index = 0;
		rolesList = obj.getRoles();
		roleNames = new String[rolesList.size()-1];
		for (RoleDTO role : rolesList) {
			if (!role.getRoleName().equals("admin")) {
				roleNames[index] = role.getRoleName();
				index++;
			}
		}
		int i = 0;
		deptsList = obj.getDepartments();
		deptNames = new String[deptsList.size()];
		for (DepartmentDTO dept : deptsList) {
			deptNames[i] = dept.getDeptName();
			i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CommonDTO obj = new CommonDTO();
		AddUserDAO addUsr = new AddUserDAO();
		UserDTO user = new UserDTO();
		String selecetdRole = (String) roles.getSelectedItem();
		String deptName = (String) depts.getSelectedItem();
		switch (selecetdRole) {
		case "student":
			obj = new StudentDTO();
			break;
		case "teacher":
			obj = new TeacherDTO();
			break;
		case "librarian":
			obj = new LibrarianDTO();
			break;
		}
		user.setUserName(usrName.getText());
		user.setPassword(pswrd.getText());
		user.setRoleName(selecetdRole);
		obj.setFirstName(nameFirst.getText());
		obj.setLastName(nameLast.getText());
		obj.setEmailId(mail.getText());
		obj.setAddress(address.getText());
		obj.setContactNum(Long.getLong(contact.getText()));
		obj.setUserDto(user);
		addUsr.addUser(obj, deptName);
	}
}
