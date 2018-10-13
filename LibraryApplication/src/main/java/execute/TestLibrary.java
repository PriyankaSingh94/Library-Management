package main.java.execute;

import java.io.IOException;
import java.sql.SQLException;

import main.java.DAO.RolesAndDepartmentsDAO;
import main.java.DAO.TestConnection;
import main.java.UI.AddUserPage;
import main.java.UI.HomePage;
import main.java.UI.LoginPage;

public class TestLibrary {

	public static void main(String[] args) throws IOException, SQLException {
		
//		LoginPage lgn = new LoginPage();
//		lgn.loginIntoApp();
//		AddUserPage add = new AddUserPage();
//		add.addUser();
		RolesAndDepartmentsDAO set = new RolesAndDepartmentsDAO();
		set.addRolesAndDepts();;
		HomePage hm =new HomePage();
		hm.welcome();
	}

}
