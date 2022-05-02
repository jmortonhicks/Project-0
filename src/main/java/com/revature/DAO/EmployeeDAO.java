package com.revature.DAO;

import com.revature.userModel.EmployeeModel;

public interface EmployeeDAO {

	public EmployeeModel getCustomer(int employId);
	
	public EmployeeModel deleteCustomerAccount(int employId);
	
	
}
