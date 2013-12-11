package com.skrill.java.design.patterns.proxy.builder;

public interface IFinanceActivities {
	
	public void shop(int choice);
	public void addSalary(int salary);
	public void addBonuses(int bonuses);
	public void payTaxes(int taxes);
	public void payRent(int rent);
	public void payLivingCost(int living);
	public void stealSomeMoney();
	public void closeAccount();
	
}
