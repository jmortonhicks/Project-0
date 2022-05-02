package com.revature.DAO;

import java.util.ArrayList;

import com.revature.userModel.AccountModel;

public interface AccountDAO {

	public AccountModel getAccount(int acctId);

	
	public void createAccount(AccountModel newAccount);

	public void updateAccount(AccountModel myAcct);
	
	public void deleteAccount(AccountModel cAccount);
	
	public ArrayList<AccountModel> getAllAccounts();
	
	//public void createAccount(int acctId, int acctNumber, String acctType, int acctBalance);

	//public void createAccount(AccountModel newAcct);
	
	//public int getCurrentBalance(int currBalance);
	
	//public AccountModel currentBalance(int currBalance);
}
