package edu.ilstu;

public class BankAccount{
	// Starting balance
	private float balance = 0.0f;
	// Username and password
	private char[] username = null;
	private char[] password = null;
		
	public BankAccount(float balance, char[] user,char[] pass){
		this.balance = balance;
		this.username = user;
		this.password = pass;
	}
	
	/*
	 * verify user login
	 */
	public boolean verify(char[] user,char[] pass){
		boolean valid = false;
		if(username == user && password == pass)
			valid = true;
		return valid;
	}
	
	/*
	 * Add amount to the balance
	 */
	public void addToBalance(float deposit){
		balance = balance+deposit;
	}
	
	/*
	 * With draw money
	 * 
	 * This method is modified. I added the code between the markers and commented out
	 * other code. This was to fix an issue where more cash was withdrawn than 
	 * the balance of the account.
	 */
	public float getCash(float cash){
		
		/* ----*/
		if(cash<=balance){
			balance-=cash;
		}
		else{
			cash=0.0f;
		}
		/* ----*/
		
//		balance = balance - cash;
		return cash;
	}
	
	/*
	 * Merge two accounts.
	 */
	public BankAccount mergeAccounts(BankAccount account){
		if(account ==null)
			throw new NullPointerException();
		return new BankAccount(this.balance+account.getBalance(),
			this.username,this.password);
	}
		
	public float getBalance() {
		return balance;
	}
}
