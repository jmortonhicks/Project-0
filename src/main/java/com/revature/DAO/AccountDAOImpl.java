package com.revature.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.userModel.AccountModel;



public class AccountDAOImpl implements AccountDAO {

	private static Connection conn = ConnectionManager.getConnection();
	
	public static void main(String[] args) {
	
	}
	
	public AccountModel getAccount(int acctNumber) {
		try {
			
			String query = "SELECT * FROM account WHERE accountnumber = ?";
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
			
			statement.setInt(1, acctNumber);
			//statement.setInt(1, acctNumber);
			//statement.setString(2, acctType);
			//statement.setInt(3, acctBalance);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				AccountModel acct = new AccountModel();
				
				acct.acctNumber = rs.getInt("accountnumber");
				acct.acctType = rs.getString("accounttype"); 
				acct.acctBalance = rs.getInt("accountbalance");
				return acct;
			} else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateAccount(AccountModel account) {
	
		try {
			String query = "UPDATE account set accountnumber= ?,"
					+ "accounttype = ?,"
					+ "accountbalance=? "
					+ "WHERE accountnumber = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, account.acctNumber);
			stmt.setString(2,account.acctType);
			stmt.setInt(3,account.acctBalance);
			stmt.setInt(4, account.acctNumber);
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void createAccount(AccountModel newAcct) {
		try {
			
			String query = "INSERT INTO account (accountNumber, accountType, accountBalance, status) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			//statement.setInt(1, newAcct.acctId);
			statement.setInt(1, newAcct.acctNumber);
			statement.setString(2, newAcct.acctType);
			statement.setInt(3, newAcct.acctBalance);
			statement.setBoolean(4, newAcct.appStatus);
			statement.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteAccount(AccountModel cAccount) {
		try {
			
			String query = "DELETE FROM account WHERE accountnumber = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, cAccount.acctNumber);

			statement.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<AccountModel> getAllAccounts() {
		try {
			
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM account");
			
			ArrayList<AccountModel> accounts = new ArrayList<AccountModel>();
			
		
			while(rs.next()) {
				int acctNumber1 = rs.getInt("accountNumber");
				String acctType1 = rs.getString("accountType");
				int acctBalance1 = rs.getInt("accountBalance");
				int fkUserId1 = rs.getInt("fk_userId");
				boolean status1 = rs.getBoolean("status");
				
				//this adds each new student to our student list(array)
				accounts.add(new AccountModel(acctNumber1, acctType1, acctBalance1, fkUserId1, status1));		
			}
			return accounts;
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
/*	public int getCurrentBalance(int currBalance) {
		try {
	
			String query = "SELECT accountBalance FROM account WHERE accountId = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, currBalance);
			//statement.setInt(1, acctId.getAcctBalance());
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				int currentBalance = rs.getInt("accountBalance");
				System.out.println("CurrentBalance: ");
				System.out.println(currentBalance);
				return currentBalance;
			}else 
				System.out.println("no account exists");
			//return acctBalance;
		} catch (SQLException e) {
			e.printStackTrace();
		} return 0;
		
	}

	public void depositAccount(AccountModel updateAcct) {
		// TODO Auto-generated method stub
		
	}

	public void withdrawAccount(AccountModel updateAcct) {
		// TODO Auto-generated method stub
		
	}

	public int getCurrentBalance(AccountModel getBalance) {
		// TODO Auto-generated method stub
		return 0;
	}

	public AccountModel currentBalance(int currBalance) {
		try {
			
		String query = "SELECT accountBalance FROM account WHERE accountId = ?";
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setInt(1, currBalance);
		
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			AccountModel am = new AccountModel();
			am.acctBalance = rs.getInt("accountBalance");
			
			return am;
			}else return null;
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
	*/
	
}
