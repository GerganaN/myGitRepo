package com.skrill.java.design.patterns.proxy.builder;

import java.util.ArrayList;
import java.util.Scanner;

public class FinanceActivitiesTest {

	static Scanner console = new Scanner (System.in);
	public static void main(String args[]){
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		ArrayList<User> users = new ArrayList<User>();
		
		System.out.println("Do you want to add new user ? Y/N ");
		String choice = console.nextLine();
		while (choice.charAt(0)=='y' || choice.charAt(0) =='Y'){
			System.out.println( "Create new User :");
			System.out.println("Enter User's Name : ");
			String uName = console.nextLine();
			System.out.println("Enter User's Email : ");
			String uEmail = console.nextLine();
			System.out.println("Enter User's Code for the Account : ");
			int uCode = Integer.parseInt(console.nextLine());
			users.add( User.createUser(uName, uEmail, uCode));
			System.out.println("Do you want to add new user ? Y/N ");
			choice = console.nextLine();
		}
		
		
		User peshoUser = new User ("pesho", "pesho@dir.bg",12345);
		User billyUser = new User ("Bill", "billy@abv.bg",01234);
		users.add(peshoUser);
		users.add(billyUser);
		
		
		Account pesho = (new Account.AccountBuilder("pesho", "pesho@dir.bg", 12345, 100))
						.salary(1000)
						.bonuses(100)
						.rent(100)
						.build();
		
		Account billy = (new Account.AccountBuilder("Bill Gates", "billy@abv.bg", 49737643, 20000000))
						.bonuses(40)
						.salary(300000)
						.living(100000)
						.taxes(20)
						.rent(9000)
						.build();
	
		
		accounts.add(pesho);
		accounts.add(billy);
		
		
		
		
		System.out.println("Please enter your name :");
		String name = console.nextLine();
		
		for (int i = 0; i < users.size(); i++) {
			
			if (users.get(i).getName().equals(name)){
				
				for (int j =0 ; j <accounts.size() ;j++){
					
					FinanceActivitiesProxy proxy = new FinanceActivitiesProxy(users.get(i), accounts.get(j));
					
					System.out.println(users.get(i).getName() + " is trying to reach " + accounts.get(j).getName() + "'s account\n");
					System.out.println ("What do you want to do with this account ? ");
					System.out.println ("1. Press 1 to go add your salary \n"
							+ "2. Press 2 to pay your rent \n"
							+ "3. Press 3 to pay your taxes \n"
							+ "4. Press 4 to pay your living cost \n"
							+ "5. Press 5 to add your bonuses \n"
							+ "6. Press 6 to go shopping \n"
							+ "7. Press 7 to steal some money \n"
							+ "8. Press 8 to close your account \n"
							+ "****************************** \n"
							+ "Enter your choice : \n");
							
					
					choice = console.nextLine();
					switch (Integer.parseInt(choice)){
					
					case 1:
						proxy.addSalary(100);
						break;
						
					case 2:
						proxy.payRent(700);
						break;
					case 3:
						proxy.payTaxes(300);
						break;
					case 4:
						proxy.payLivingCost(200);
						break;
					case 5:
						proxy.addBonuses(300);
						break;
					case 6:
						System.out.println("Choose what you want to buy : \n"
								+ "1. Press 1 for food \n"
								+ "2. Press 2 for alcohol \n"
								+ "3. Press 3 for clothes \n"
								+ "4. Press 4 for technology \n"
								+ "Enter your choice : ");
						
						choice = console.nextLine();
						switch (Integer.parseInt(choice)){
						case 1 :
							proxy.shop(1);
							break;
						case 2 :
							proxy.shop(2);
							break;
						case 3 :
							proxy.shop(3);
							break;
						case 4 :
							proxy.shop(4);
							break;
						default : 
							System.out.println("You did not enter correct choice! You cannot buy anything!");
							break;
						}
						break;			
					case 7:
						proxy.stealSomeMoney();
						break;
					case 8 :
						proxy.closeAccount();
						break;
					default : 
						System.out.println("You did not enter correct choice! You cannot do anything with any money!");
					break;
					}
					
				}
				
				}
			else{
				System.out.println("You are not in the User's list!");
				break;
			}
			}
		}
		
	
	
}
