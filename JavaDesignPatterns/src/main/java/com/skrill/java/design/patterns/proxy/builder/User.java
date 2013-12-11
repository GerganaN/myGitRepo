package com.skrill.java.design.patterns.proxy.builder;

public class User {

	private String name;
	String email;
	int code;
	
	public User(String name, String email,int code){
		this.name= name;
		this.email = email;
		this.code = code;
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
	public static User createUser(String name, String email, int code){
		return new User(name, email, code);
	}
}
