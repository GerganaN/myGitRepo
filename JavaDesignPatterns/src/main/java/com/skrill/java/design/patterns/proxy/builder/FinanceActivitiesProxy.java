package com.skrill.java.design.patterns.proxy.builder;

public class FinanceActivitiesProxy implements IFinanceActivities {

	User user;
	Account account;
	FinanceActivities shop;
	
	public FinanceActivitiesProxy(User user,Account account) {
		this.user = user;
		this.account =account;
	}
			
	public void shop(int choice) {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())){
			shop = new FinanceActivities(account);
			shop.shop(choice);
			}
		else {
			System.out.println("You do not have access to this Account!");
			}
	}

	public void addSalary(int salary) {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())){
			shop = new FinanceActivities(account);
			shop.addSalary(salary);
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
	}

	public void payTaxes(int taxes) {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())){
			shop = new FinanceActivities(account);
			shop.payTaxes(taxes);
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
		
	}

	public void payRent(int rent) {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())){
			shop = new FinanceActivities(account);
			shop.payRent(rent);
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
		
	}

	public void stealSomeMoney() {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())&& (user.getCode()==account.getCode())){
			shop = new FinanceActivities(account);
			shop.stealSomeMoney();
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
			
	}

	public void closeAccount() {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())&& (user.getCode()==account.getCode())){
			shop = new FinanceActivities(account);
			shop.closeAccount();
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
		
	}

	public void addBonuses(int bonuses) {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())){
			shop = new FinanceActivities(account);
			shop.addBonuses(bonuses);
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
	}

	public void payLivingCost(int living) {
		if (user.getName().equals( account.getName())&& user.getEmail().equals(account.getEmail())){
			shop = new FinanceActivities(account);
			shop.payLivingCost(living);
		}
		else {
			System.out.println("You do not have access to this Account!");
		}
	}
	
	
}
	

