/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.java;

import java.util.Random;

public class MainTest {

	public static void main(String[] args) {

		Town sofia = new Town("Sofia", 100000);
		Town london = new Town("London", 1000000);
		Town plovdiv = new Town("Plovdiv", 20000);

		String[] femaleNames = new String[] { "Maria", "Gergana", "Desi",
				"Lili", "Cveti", "Penka", "Sevda", "Bistra", "Kuna", "Radka" };
		String[] maleNames = new String[] { "Pesho", "Goshp", "Atanas",
				"Angel", "Pencho", "Ivan", "Vesko", "Stifo", "Kalata", "Yavor" };

		Random randomGenerator = new Random();
		for (int i = 1; i <= 10; i++) {
			Person person;
			int age = randomGenerator.nextInt(100);
			char sex = 'm';
			if (age % 2 == 0) {
				sex = 'f';
			}
			int fName = randomGenerator.nextInt(10);
			int choice = randomGenerator.nextInt();
			if (choice % 2 == 0) {
				person = new Person(femaleNames[fName], "Ivanova", age, sex);
			} else {
				person = new Person(maleNames[fName], "Petrov", age, sex);
			}
			int townChoice = randomGenerator.nextInt(3);
			if (townChoice == 1) {
				sofia.addPerson(person);
			} else if (townChoice == 2) {
				plovdiv.addPerson(person);
			} else {
				london.addPerson(person);
			}

		}
		sofia.getArea();
		System.out.println(sofia.getCountPopAge());
		System.out.println(plovdiv.getCountPopAge());
		System.out.println(london.getCountPopAge());
		// System.out.print(sofia.toString());

		Country bg = new Country("Bulgaria");
		Statistics stat = new Statistics();
		
		bg.addTown(sofia);
		bg.addTown(plovdiv);
		bg.addTown(london);
		
		System.out.println(stat.oldestPeopleTown(bg).toString());

	}
}
