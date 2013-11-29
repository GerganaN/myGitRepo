package com.skrill.interns.java;

public class Person {

	String fName;
	String lName;
	int age;
	char sex;
	
	public Person(String fName, String lName, int age, char sex){
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.sex = sex;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

}
