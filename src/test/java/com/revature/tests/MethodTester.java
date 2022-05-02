package com.revature.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.DAO.AccountDAO;
import com.revature.DAO.AccountDAOImpl;
import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAOImpl;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.userModel.AccountModel;
import com.revature.userModel.UserModel;


class MethodTester {
	
		
	
	AccountDAO act = new AccountDAOImpl();
	UserDAO cus = new UserDAOImpl();
	EmployeeDAO emp = new EmployeeDAOImpl();
	
	

	@Test
	void testGetAccountBalance() {
		AccountModel act1 = act.getAccount(111);
		assertTrue(1 == act1.acctBalance);
		
	}

	@Test
	void testGetAccountType() {
		AccountModel act1 = act.getAccount(111);
		assertEquals("Checking", act1.acctType);
	}
	@Test
	void testGetAccountStatus() {
		AccountModel act1 = act.getAccount(111);
		assertTrue(false == act1.appStatus);
	}
	@Test
	void testGetUserFkAccountId() {
		UserModel cus1 = cus.getUser("admin", "ilikemyboss");
		assertTrue(111 == cus1.fkAccountId);
	}
	@Test
	void testGetUserUserId() {
		UserModel cus1 = cus.getUser("admin", "ilikemyboss");
		assertTrue(2 == cus1.userId);
	}
	@Test
	void testGetUserFkEmployeeId() {
		UserModel cus1 = cus.getUser("admin", "ilikemyboss");
		assertTrue(501 == cus1.fkEmployeeId);
	}

}
