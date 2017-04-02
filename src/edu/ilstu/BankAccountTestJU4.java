package edu.ilstu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * This is a JU4 test class to test the class BankAccount.java.
 * 
 * @author Christopher A Runyan
 */
public class BankAccountTestJU4{
	BankAccount account=null;
	BankAccount account2=null;
	BankAccount mergedAccount=null;
	float beginningBalance=50.0f;
	float beginningBalance2=100.0f;
	float DELTA=0.0f;
	char[] username={'t', 'e', 's', 't'};
	char[] username2={'t','3', 's', 't'};
	char[] username3={'t', 'e', 's', 't', '2'};
	char[] password={'1', '2', '3', '4', 'a', 'b', 'c'};
	char[] password3={'4', '3', '2', '1', 'c', 'b', 'a'};
	
	@Rule
	public Timeout time=new Timeout(5000, TimeUnit.MILLISECONDS);
	
	/*
	 * No resources to aquire.
	 */
	@BeforeClass
	public static void start(){
		System.out.println("I am executed only once");
	}
	
	/*
	 * Creates a new bank account object with variables that are testable.
	 */
	@Before
	public void initialize(){
		account=new BankAccount(beginningBalance, username, password);
	}
	
	/*
	 * Tests the ability to create an account and that the correct data is 
	 * saved when an account is created.
	 */
	@Test
	public void testCreateAccount(){
		account2=new BankAccount(beginningBalance2, username3, password3);
		assertEquals(beginningBalance2, account2.getBalance(), DELTA);
		assertEquals(true, account2.verify(username3, password3));
	}
	
	/*
	 * Tests if a user can login to an account.
	 */
	@Test
	public void testLogin(){
		assertEquals(true, account.verify(username, password));
	}
	
	/*
	 * Tests that an account will not accept incorrect credentials.
	 */
	@Test
	public void testLogin2(){
		assertEquals(false, account.verify(username2, password));
	}
	
	/*
	 * Tests that the amount deposited is adding up.
	 */
	@Test
	public void testDeposit(){
		account.addToBalance(25.0f);
		assertEquals(75.0f, account.getBalance(), DELTA);
	}
	
	/*
	 * Tests that the correct amount is withdrawn.
	 */
	@Test
	public void testWithdrawal(){
		assertEquals(5.0f, account.getCash(5.0f), DELTA);
	}
	
	/*
	 * Tests that the balance reflects withdrawals.
	 */
	@Test
	public void testBalanceAfterWithdrawal(){
		account.getCash(5.0f);
		assertEquals(45.0f, account.getBalance(), DELTA);
	}
	
	/*
	 * Tests that the correct amount is withdrawn when more money than the balance is requested.
	 */
	@Test
	public void testWithdrawal2(){
		assertEquals(0.0f, account.getCash(100.0f), DELTA);
	}
	
	/*
	 * Tests that the account does not allow overdrafts.
	 */
	@Test
	public void testBalanceAfterWithdrawal2(){
		account.getCash(100.0f);
		assertEquals(50.0f, account.getBalance(), DELTA);
	}
	
	
	/*
	 * Tests the balance when two accounts are merged.
	 */
	@Test
	public void testBalanceMergedAccount(){
		account2=new BankAccount(beginningBalance2, username3, password3);
		mergedAccount=account.mergeAccounts(account2);
		assertEquals(150.0f, mergedAccount.getBalance(), DELTA);
	}
	
	/*
	 * Resets everything.
	 */
	@After
	public void cleanUp(){
		account=null;
		account2=null;
		mergedAccount=null;
		assertNull(account);
		assertNull(account2);
		assertNull(mergedAccount);
	}
	
	/*
	 * No resources to close.
	 */
	@AfterClass
	public static void done(){
		System.out.println("All done with testing");
	}
}
