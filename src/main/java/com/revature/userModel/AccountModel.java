package com.revature.userModel;

public class AccountModel {

	
	public int acctNumber;
	public String acctType;
	public int acctBalance;
	public int fkUserId;
	public boolean appStatus;
	
	


public AccountModel( int accountNumber, String accountType, int accountBalance, int fk_userId, boolean status){
	
	acctNumber = accountNumber;
	acctType = accountType;
	acctBalance = accountBalance;
	fkUserId = fk_userId;
	appStatus = status;
	}

@Override
public String toString() {
	return "AccountModel [acctNumber=" + acctNumber + ", acctType=" + acctType + ", acctBalance=" + acctBalance
			+ ", fkUserId=" + fkUserId + ", appStatus=" + appStatus + "]";
}



public AccountModel() {
	
}



/*public AccountModel(int accountId, int accountNumber, String accountType) {

}*/

/*
public int getAcctId() {
	return acctId;
}

public void setAcctId(int acctId) {
	this.acctId = acctId;
}

public int getAcctNumber() {
	return acctNumber;
}

public void setAcctNumber(int acctNumber) {
	this.acctNumber = acctNumber;
}

public String getAcctType() {
	return acctType;
}

public void setAcctType(String acctType) {
	this.acctType = acctType;
}

public int getAcctBalance() {
	return acctBalance;
}

public void setAcctBalance(int acctBalance) {
	this.acctBalance = acctBalance;
} 
*/

}