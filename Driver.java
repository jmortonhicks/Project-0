package com.revature.driver;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.DAO.AccountDAO;
import com.revature.DAO.AccountDAOImpl;
import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAOImpl;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.userModel.AccountModel;
import com.revature.userModel.EmployeeModel;
import com.revature.userModel.UserModel;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	
	//sign in and create user attributes
	static UserDAO userdao = new UserDAOImpl();
	static UserModel cUser;
	static String user;
	static String pass;
	static int currentUserId;
	
	//sign in as employee
	static EmployeeDAO employDAO = new EmployeeDAOImpl();
	static EmployeeModel eUser;
	
	//create and register for bank account
	static AccountDAOImpl acctDAO = new AccountDAOImpl();
	static AccountModel acct;
	static int acctNumb;
	static String typeAccount;
	
	
	
	
	static int amountDeposited;
	static int amountWithdrawn;
	static int balance;
	
	//static int deposit;
	//static int withdraw;
	public static void main(String[] args ) {
    	
		Driver obj = new Driver();
		//AccountModel am = acctDAO.getAllAccounts();
		//System.out.println(am);
    	introPage();
    	accountOptions();
    	showMenu();   
    	
 }
	
	   public static void introPage() {	
		   
		   Scanner sc = new Scanner(System.in);
	    	
	    	System.out.println("*****Welcome to The Iron Bank!*****");
	    	System.out.println("\n");
	    	System.out.println("Sign in or create a user with us!");
	    	System.out.println("1. Sign in");
	    	System.out.println("2. Create User");
	    	
	    	int option = sc.nextInt();
	    	
	    	// Can add more options here for applying for joint account.
	    	
	    	switch (option) {
	    	case 1: cUser = signIn();
	    	break;
	    	case 2: cUser = createUser();
	    	break;
	    	default:
	    	
	    	}
	    	
	    }
	    
	    public static UserModel signIn() {
	    		
	    		Scanner sc = new Scanner(System.in);
	    		
	    		System.out.println("\n");
	    	    System.out.println("Login");
	    		System.out.print("Enter username: ");
	    		user = sc.next();
	    		System.out.println();
	    		System.out.print("Enter password: ");
	    		pass = sc.next();
	    		UserModel cUser = userdao.getUser(user, pass);
	  
	    		while (cUser == null){
	    			System.out.println("Invalid username or password."); 
	    			System.out.println("Please try again.");
	    			System.out.print("Enter username: ");
	    	    	user = sc.next();
	    	    	System.out.println();
	    	    	System.out.print("Enter password: ");
	    	    	pass = sc.next();
	    			cUser = userdao.getUser(user, pass);
	    			}
	    		
	    		
	    		//System.out.println(cUser.userId); //printed out users ID
	    		System.out.println("You are now logged in.");
	    		
	    		return cUser;
	    }
	    
	    public static UserModel createUser() { //this causes problems when it creates a bank account.
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("\n");
	    	System.out.println("Please enter username and password to sign up");
			System.out.println("Create username: ");
			user = sc.next();
			System.out.println();
			System.out.println("Create password: ");
			pass = sc.next();
			UserModel cUser = new UserModel(0, user, pass, 0, 0); 
			userdao.createUser(cUser);
			System.out.println("\n");
			System.out.println("User created! Welcome, " + user);
			return cUser;
	}
	    
	    
	    public static void accountOptions() {
	    	System.out.println("\n");
	    	System.out.println("1. Create a bank account.");
	    	System.out.println("2. Search an existing account.");
	    	
	    	int option = sc.nextInt();
	    	
	    	switch (option) {
	    	case 1: acct = createBankAccount();
	    	break;
	    	case 2: acct = showMenu();
	    	break;
	    	default:
	    }
	 }  
	    
	    public static AccountModel createBankAccount() { //THIS WORKS
	    	acct = new AccountModel();
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("\n");
	    	//System.out.println("***********************************************************************************");
	    	System.out.println("To apply to open an account with The Iron Bank, just complete the following steps!");
	    	//System.out.println("***********************************************************************************");
	    	System.out.println("\n");
	    	System.out.println("Create an account number: ");
	    	System.out.println();
	    	acctNumb = sc.nextInt(); //removed 'acct'.acctNumber
	    	System.out.println("What type of account would you like to open?");
	    	System.out.println("Please type 'Checking' or 'Savings'");
	    	typeAccount = sc.next(); //acct.acctType
	    	System.out.println("\n");
	    	cUser = userdao.getUser(user, pass); // to assign user id
	    	acct = new AccountModel(acctNumb, typeAccount, 0, cUser.userId, false); //removed 'AccountModel' prefix
	    	System.out.println(acct.acctType + " account: " + acct.acctNumber + " was created!");
	    	 	
	    	acctDAO.createAccount(acct);
	    	
	    	return acct;
	    	
	    }
	    
	    
		static void deposit(AccountModel account, int amount) { 
				
			if(amount >= 0) {
				account.acctBalance = account.acctBalance + amount;
				acctDAO.updateAccount(account);
			}
		}
		
		static void withdraw(AccountModel account, int amount) { 
			
			if(amount >= 0) {
				account.acctBalance = account.acctBalance - amount;
				acctDAO.updateAccount(account);
			}			
		}
	    
		public static AccountModel showMenu() { //ADDED RETURN TYPE 'AccountModel' instead of void
			
			char option='0';
			
			Scanner sc = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("Menu:");
			System.out.println("----");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Sign out");
			
			//int option = sc.nextInt();
		do {
			option = sc.next().charAt(0);
			switch (option) {
	    	case '1': acct = checkBalance();
	    		break;
	    	case '2': acct = makeDeposit();
	    		break;
	    	case '3': acct = makeWithdrawl();
	    		break;
	    	case '4': 
	    		break;
	    	//case 'A': acct = 
	    		//break;
	    	case 'E': acct = accountLookUp(); //create arraylist to call all accounts
	    		//break;
	    	default:
	    	System.out.println("Invalid option. Please select a differnt option");
	    	break;
	    	
	    	}			
		}while (option != '4');
		System.out.println("You have now signed out");
		return null;
		}
			
		public static AccountModel checkBalance() {
			System.out.println("Which account balance did you want to check?"); //searches by primary key (accountId)
			int searchUserScanner = sc.nextInt();
			//System.out.println("Balance =" + balance); // this tells me the balance within this method..not helpful
			AccountModel acct = acctDAO.getAccount(searchUserScanner);
			System.out.println("Balance =" + acct.acctBalance); //this tells me the database balance
			return null;
		}
		
		public static AccountModel makeDeposit() {
			
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Which account would like to deposit into?");
			int acctNumberScanner = sc.nextInt();
		    AccountModel myAccount = acctDAO.getAccount(acctNumberScanner); //removed 'acct ='
			
			System.out.println("How much would you like to deposit?");
			int amount = sc.nextInt();
			sc.nextLine();
			deposit(myAccount, amount); //took 'amount' out
			//deposit = sc.nextInt();
			System.out.println("You have deposited $" + amount + " into your account");
			
			return null;
		}
					
		public static AccountModel makeWithdrawl() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Which account would like to withdraw from?");
			int acctNumberScanner = sc.nextInt();
			AccountModel myAccount = acctDAO.getAccount(acctNumberScanner);

			System.out.println("How much would you like to withdraw?");
			int amount = sc.nextInt();
			if(amount > myAccount.acctBalance)
				System.out.println("Insufficient funds available");
			else {
				if(myAccount.acctBalance >= 0) {   
					withdraw(myAccount, amount);				
			System.out.println("You have withdrawn $" + amount + " out of your account");
			System.out.println("\n");
			}
		}
			return null; 
	}

		public static AccountModel accountLookUp() {
			Scanner sc = new Scanner(System.in);
			
			ArrayList<AccountModel> accounts = acctDAO.getAllAccounts();
			//System.out.println(acctDAO.getAllAccounts());
			//System.out.println("Select Customer: ");
			System.out.println("\n");
			System.out.println("1. View all accounts");
			System.out.println("2. Look up by account");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1: System.out.println(acctDAO.getAllAccounts());
				break;
			case 2: System.out.println("Which account would you like to look up?");
				int acctNumberScanner = sc.nextInt();
		    AccountModel acctLookUp = acctDAO.getAccount(acctNumberScanner);
		    System.out.println(acctLookUp);
				break;
			}
			System.out.println("\n");
    		user = sc.next();
    		return null;
		}
		
		
		
		

		
}
