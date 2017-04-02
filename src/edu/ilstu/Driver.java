package edu.ilstu;

import java.util.Scanner;

public class Driver{
	public static void main(String[] args){
		BankAccount account=null;
		Scanner kb=new Scanner(System.in);
		float initAmount=0.0f;
		float amountAdd=0.0f;
		float amountWithdraw=0.0f;
		int choice=0;
		char[] username={'t', 'e', 's', 't'};
		char[] password={'1', '2', '3', '4', 'a', 'b', 'c'};
		String inUser=null;
		String inPassword=null;
		char[] inUserC=null;
		char[] inPasswordC=null;
		
		System.out.print("Enter initial amount: ");
		initAmount=kb.nextFloat();
		
		account=new BankAccount(initAmount, username, password);
		
		System.out.print("Select option:\n1. Add\n2. Withdraw\n3. Check Balance\n4. Verify\n5. Quit\nEnter here: ");
		choice=kb.nextInt();
		while(choice!=5){
			if(choice==1){
				System.out.print("Enter amount to add: ");
				amountAdd=kb.nextFloat();
				account.addToBalance(amountAdd);
				System.out.print(amountAdd+" was added. Total: "+account.getBalance());
			}
			else if(choice==2){
				System.out.print("Enter amount to withdraw: ");
				amountWithdraw=kb.nextFloat();
				System.out.print(account.getCash(amountWithdraw)+" was withdrawn. Total: "+account.getBalance());
			}
			else if(choice==3){
				System.out.print("Currenct balance: "+account.getBalance());
			}
			else if(choice==4){
				System.out.print("Enter username: ");
				inUser=kb.next();
				System.out.print("Enter password: ");
				inPassword=kb.next();
				
				inUserC=new char[inUser.length()];
				inPasswordC=new char[inPassword.length()];
				
				for(int i=0; i<inUser.length();  i++){
					inUserC[i]=inUser.charAt(i);
					System.out.print(inUserC[i]);
				}
				for(int i=0; i<inPassword.length(); i++){
					inPasswordC[i]=inPassword.charAt(i);
					System.out.print(inPasswordC[i]);
				}
				
				if(account.verify(inUserC, inPasswordC)){
					System.out.print("Verified.");
				}
				else{
					System.out.print("Verification failure. Username "+inUser+" and password "+inPassword+" is wrong.");
				}
			}
			System.out.print("\nSelect option:\n1. Add\n2. Withdraw\n3. Check Balance\n4. Verify\n5. Quit\nEnter here: ");
			choice=kb.nextInt();
		}
		kb.close();
	}
}
