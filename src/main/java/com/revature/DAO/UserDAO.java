package com.revature.DAO;

import com.revature.userModel.UserModel;

public interface UserDAO {
	
	public UserModel getUser(String username, String password);
	
	public void createUser(UserModel user);
	
	public void updateUser(UserModel user);
	
}
