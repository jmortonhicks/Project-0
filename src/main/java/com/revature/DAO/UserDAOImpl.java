package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.userModel.UserModel;

public class UserDAOImpl implements UserDAO{

	private Connection conn = ConnectionManager.getConnection();

	public UserModel getUser(String username, String password) {
		try {
			
			String query = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				//UserModel user = new UserModel();
				int userId = rs.getInt("user_id");
				String username1 = rs.getString("username"); 
				String password1 = rs.getString("password");
				int acctNumberId = rs.getInt("fk_account_id");
				int employNumberId = rs.getInt("fk_employee_id");
				return new UserModel(userId, username1, password1, acctNumberId, employNumberId);
				
			} else return null; // user does not exist
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
public void createUser(UserModel newUser) {
		
		try {
			
			String query = "INSERT into Users (username, password) VALUES (?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, newUser.username);
			pstmt.setString(2, newUser.password);
			
			pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(UserModel user) {
		// TODO Auto-generated method stub
		
	}
}
/*public UserModel getUser(int userId, String username, String password) {
	try {
		
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs = statement.executeQuery();
		
		if (rs.next()) {
			UserModel user = new UserModel();
			user.userId = rs.getInt("user_id");
			user.username = rs.getString("username"); 
			user.password = rs.getString("password");
			return user;
			
		} else return null; // user does not exist
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}*/