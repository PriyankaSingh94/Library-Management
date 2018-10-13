package main.java.DAO;

import java.sql.*;
import main.java.UI.HomePage;
import main.java.utils.LoggedUser;

public class LoginDAO {
	
	TestConnection test;
	Connection con;
	Statement stmt;
	ResultSet rs;
	HomePage home;
	
	public void loginUser(String username, String password){
		
		try{
			test = new TestConnection();
			con = test.getConnection();
			stmt = con.createStatement();
			String str = "select * from library_app.tbl_users where username = '"+username+"' and password = '"+password+"'";
			System.out.println(str);
			rs = stmt.executeQuery(str);
			
			while(rs.next()){
				LoggedUser user =new LoggedUser();
				user.setLoggedInUser(username);
				home = new HomePage();
				home.welcome();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
