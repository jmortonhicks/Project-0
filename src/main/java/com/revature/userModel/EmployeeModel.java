package com.revature.userModel;

public class EmployeeModel {

	public int employId;
	public String eUsername;
	public String ePassword;
	public boolean admin;


public EmployeeModel(int EmployeeId, String username, String password, boolean admin) {
	employId = EmployeeId;
	eUsername = username;
	ePassword = password;
	this.admin = admin;
	}


@Override
public String toString() {
	return "EmployeeModel [employId=" + employId + ", eUsername=" + eUsername + ", ePassword=" + ePassword + "]";
}

public EmployeeModel() {
	
}

}
