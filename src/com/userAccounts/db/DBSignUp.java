package com.userAccounts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBSignUp {
	
	public boolean DbAccess(String userId , String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://3.88.150.209/db","root","123");
			String query = " insert into users (userid, password)"
			        + " values (?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,userId);
			preparedStatement.setString(2,password);
			preparedStatement.executeUpdate();		
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//return false;
	}

}
