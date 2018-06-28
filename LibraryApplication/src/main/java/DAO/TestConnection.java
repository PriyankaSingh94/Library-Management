package main.java.DAO;

import java.sql.*;

public class TestConnection {

	public Connection getConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","Priyanka","priyanka");  
		System.out.println("done");
		return con;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
