package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Railway {
public static boolean login(String id, String pwd)
{
	 
		boolean status=false;
		try{
			final String url = "jdbc:mysql://localhost:3306/test";
			final String username = "root";

			final String password = "root2458";

			Connection con = DriverManager.getConnection(url+"?&serverTimezone=UTC", username, password);
			PreparedStatement ps=con.prepareStatement("select * from logintable where EMAIL=? and PASSWORD=?");
			ps.setString(1,id);
			ps.setString(2,pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		return status;
	}
}

