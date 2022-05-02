package com.revature.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.userModel.AccountModel;
import com.revature.userModel.EmployeeModel;

public class EmployeeDAOImpl implements EmployeeDAO {

	
	public EmployeeModel getCustomer(int employId) {
		try {
			
			String query = "SELECT * FROM account WHERE employeeId = ?";
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
			
			statement.setInt(1, employId);
			//statement.setInt(1, acctNumber);
			//statement.setString(2, acctType);
			//statement.setInt(3, acctBalance);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				 EmployeeModel employ = new EmployeeModel();
				employ.employId = rs.getInt("EmployeeId");
				employ.employId = rs.getInt("username");
				employ.employId = rs.getInt("password");
				return employ;
			} else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EmployeeModel deleteCustomerAccount(int employId) {
		// TODO Auto-generated method stub
		return null;
	}

}
