package com.revature.userModel;

public class UserModel {

	public int userId;
	public String username;
	public String password;
	public int fkAccountId;
	public int fkEmployeeId;
	

	public UserModel(int user_Id, String username, String password, int fk_Account_Id, int fk_Employee_Id) {
		this.userId = user_Id;
		this.username = username;
		this.password = password;
		fkAccountId = fk_Account_Id;
		fkEmployeeId = fk_Employee_Id;
		}
	
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", username=" + username + ", password=" + password + ", fkAccountId="
				+ fkAccountId + ", fkEmployeeId=" + fkEmployeeId + "]";
	}


	public UserModel(){
		
		}
}
