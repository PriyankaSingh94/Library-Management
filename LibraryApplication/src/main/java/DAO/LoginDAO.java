package main.java.DAO;

import java.sql.*;

public class LoginDAO {
	
	TestConnection test;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public void loginUser(String username, String password){
		
		try{
			test = new TestConnection();
			con = test.getConnection();
			stmt = con.createStatement();
			String str = "select * from library_app.tbl_users where username = '"+username+"' and password = '"+password+"'";
			System.out.println(str);
			rs = stmt.executeQuery(str);
			
			while(rs.next()){
				System.out.println("first"+rs.getString(1));
				System.out.println("sec"+rs.getString(2));
				System.out.println("third"+rs.getString(3));
				System.out.println("four"+rs.getString(4));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
