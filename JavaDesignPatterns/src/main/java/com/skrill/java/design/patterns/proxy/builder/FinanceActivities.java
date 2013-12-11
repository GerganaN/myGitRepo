package com.skrill.java.design.patterns.proxy.builder;

public class FinanceActivities implements IFinanceActivities{

	Account account;
	public FinanceActivities(Account account){
		this.account=account;
	}
	public void shop(int choice) {
		
		if (account.getTotalAmount()<0){
			System.out.println("You are POOR! Work harder ot go home !");
		}
			long sum = account.getTotalAmount();
			
			if (choice ==1 && sum >100){
				sum-=100;
				account.setTotalAmount(sum);
			}
			if (choice ==2 && sum >200){
				sum-=200;
				account.setTotalAmount(sum);
			}
			if (choice ==3 && sum >50){
				sum-=50;
				account.setTotalAmount(sum);
			}
			if (choice==4 && sum >1000){
				sum-=1000;
				account.setTotalAmount(sum);
			}
			else {
				System.out.println("You are not rich enough to buy these things!");
			}
		System.out.println("Your total Amount after shopping is " + account.getTotalAmount());
	}
	
	public void addSalary(int salary){
		account.setSalary(salary);
		account.setTotalAmount();
		System.out.println("Your total sum after receiving your salary is : " + account.getTotalAmount());
 }
	
	public void payRent(int rent){
		account.setRent(rent);
		account.setTotalAmount();
		System.out.println("Your total sum after paying your rent is : " + account.getTotalAmount());
	}

	public void payTaxes(int taxes){
		account.setTaxes(taxes);
		account.setTotalAmount();
		System.out.println("Your total sum after paying your taxes is : " + account.getTotalAmount());
	}
	public void stealSomeMoney() {
		System.out.println( "You have stolen " + account.getTotalAmount() + " from " + account.getName() + " 's account.");
		account.setTotalAmount(0);
		System.out.println(account.getName() + " now has " + account.getTotalAmount() + " money in his account");
	}
	public void closeAccount() {
		account = null;
		System.out.println("Is Account deleted :  " + (account ==null));
		
	}
	public void addBonuses(int bonuses) {
		account.setBonuses(bonuses);
		account.setTotalAmount();
		System.out.println("Your total sum after receiving your bonuses is : " + account.getTotalAmount());
		
	}
	public void payLivingCost(int living) {
		account.setLiving(living);
		account.setTotalAmount();
		System.out.println("Your total sum after paying your living cost is : " + account.getTotalAmount());
		
	}
	
}
