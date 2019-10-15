package main.java.DAO;

import java.sql.*;

public class TestConnection {
	
	Connection con;
	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","Priyanka","priyanka");  
			System.out.println("Success");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
}
