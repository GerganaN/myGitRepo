package com.skrill.java.design.patterns.proxy.builder;


public class Account {

	private final String name; //required
	private final String email; //required
	private final int code; //required
	private final int initialCapital; //required
	private int salary = 0; //optional
	private int bonuses = 0; //optional
	private int scholarship = 0; //optional
	private int luck = 0; //optional
	private int rent = 0; //optional
	private int living = 0; //optional
	private int taxes = 0; //optional
	private long totalAmount;
       	
	private Account(AccountBuilder builder){
		this.name = builder.name;
		this.email = builder.email;
		this.code = builder.code;
		this.initialCapital = builder.initialCapital;
		this.salary = builder.salary;
		this.bonuses = builder.bonuses;
		this.scholarship = builder.scholarship;
		this.luck = builder.luck;
		this.rent = builder.rent;
		this.living = builder.living;
		this.taxes = builder.taxes;	
		this.setTotalAmount();
	}

	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public int getCode(){
		return code;
	}
	
	public int getInitialCapital(){
		return initialCapital;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonuses() {
		return bonuses;
	}

	public void setBonuses(int bonuses) {
		this.bonuses = bonuses;
	}

	public int getScholarship() {
		return scholarship;
	}

	public void setScholarship(int scholarship) {
		this.scholarship = scholarship;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getLiving() {
		return living;
	}

	public void setLiving(int living) {
		this.living = living;
	}

	public int getTaxes() {
		return taxes;
	}

	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}
	
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(){
		totalAmount = initialCapital + salary + bonuses + scholarship
				+  luck
				- rent
				-living
				-taxes;
	}
	public void setTotalAmount(long param){
		this.totalAmount = param;
	}
		
	
	public static class AccountBuilder{
		
		private final String name; 
		private final String email; 
		private final int code; 
		private final int initialCapital; 
		private int salary; 
		private int bonuses; 
		private int scholarship; 
		private int luck; 
		private int rent; 
		private int living; 
		private int taxes; 
		
		public AccountBuilder(String name, String email,int code, int  initialCapital){
			this.name = name;
			this. email = email;
			this.code = code;
			this.initialCapital = initialCapital;
			
		}
		public AccountBuilder salary(int salary){
			this.salary = salary;
			return this;
		}
		public AccountBuilder bonuses(int bonuses){
			this.bonuses = bonuses;		
			return this;
		}
		public AccountBuilder scholarship(int scholarship){
			this.scholarship= scholarship;
			return this;
		}
		public AccountBuilder luck(int luck){
			this.luck= luck;
			return this;			
		}
		public AccountBuilder rent(int rent){
			this.rent = rent;
			return this;
		}
		public AccountBuilder living(int living){
			this.living = living;
			return this;
		}
		public AccountBuilder taxes(int taxes){
			this.taxes = taxes;
			return this;
		}
		public Account build(){
			return new Account(this);
		}
				
	}

}
