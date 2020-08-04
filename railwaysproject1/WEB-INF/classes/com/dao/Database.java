package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{
	
	public static Connection getConnection() {
		
	
	Connection con =null;
		try{
			final String url = "jdbc:mysql://localhost:3306/test";
			final String username = "root";

			final String password = "root2458";

			con = DriverManager.getConnection(url+"?&serverTimezone=UTC", username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


	return con;
}
	}