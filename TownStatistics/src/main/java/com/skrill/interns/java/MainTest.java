/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTest {

	static List<String> femaleNames = new ArrayList<String>();
	static List<String> maleNames = new ArrayList<String>();
	static List<String> fLastNames = new ArrayList<String>();
	static List<String> mLastNames = new ArrayList<String>();

	static {
		femaleNames.add("Gergana");
		femaleNames.add("Angelinka");
		femaleNames.add("Mariika");
		femaleNames.add("Pena");
		femaleNames.add("Ceci");
		femaleNames.add("Radka");
		femaleNames.add("Temenujka");
		femaleNames.add("Snejinka");
		femaleNames.add("Desislava");
		femaleNames.add("Kuna");

		maleNames.add("Kalata");
		maleNames.add("Stifo");
		maleNames.add("Nasko");
		maleNames.add("Vesko");
		maleNames.add("Yavor");
		maleNames.add("Pesho");
		maleNames.add("Ivan");
		maleNames.add("Gosho");
		maleNames.add("Angel");
		maleNames.add("Petko");

		fLastNames.add("Nikolova");
		fLastNames.add("Georgieva");
		fLastNames.add("Dimitrova");
		fLastNames.add("Petrova");
		fLastNames.add("Ivanova");
		fLastNames.add("Vasileva");
		fLastNames.add("Ilieva");
		fLastNames.add("Gospodinova");
		fLastNames.add("Velinova");
		fLastNames.add("Iordanova");

		mLastNames.add("Ivanov");
		mLastNames.add("Tonov");
		mLastNames.add("Banev");
		mLastNames.add("Petrov");
		mLastNames.add("Dimitrov");
		mLastNames.add("Stoyanov");
		mLastNames.add("Tonchev");
		mLastNames.add("Srebrev");
		mLastNames.add("Danailov");
		mLastNames.add("Draganov");

	}

	public static void main(String[] args) {

		Town sofia = new Town("Sofia", 100000);
		Town london = new Town("London", 20000);
		Town plovdiv = new Town("Plovdiv", 30000); 

		Random randomGenerator = new Random();
		for (int i = 1; i <= 100; i++) {
			Person person;
			int age = randomGenerator.nextInt(100);
			char sex = 'm';
			int fName = randomGenerator.nextInt(10);
			int choice = randomGenerator.nextInt();
			if (choice % 2 == 0) {
				sex = 'f';
				person = new Person(femaleNames.get(fName),
						fLastNames.get(fName), age, sex);
			} else {
				person = new Person(maleNames.get(fName),
						mLastNames.get(fName), age, sex);
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

		Country bulgaria = new Country("Bulgaria", 200000); 
		Statistics stat = new Statistics();

		bulgaria.addTown(sofia);
		bulgaria.addTown(plovdiv);
		bulgaria.addTown(london);

		System.out
				.println("********************************************************\n Average Age in Bulgaria's Towns :");
		System.out.println(stat.averageAge(sofia));
		System.out.println(stat.averageAge(plovdiv));
		System.out.println(stat.averageAge(london));
		System.out.println("Oldest Town in Bulgaria is :");
		System.out.println(stat.oldestPeopleTown(bulgaria));
		System.out.println("How many procent are uninhabited in "
				+ bulgaria.getName() + " ?");
		System.out.println(stat.procentFreeZone(bulgaria) + "%");
		System.out.println("Population density in Bulgaria is : ");
		System.out.println(stat.countryDensity(bulgaria));
		System.out.println("How many married couples are there ? ");
		Town oldestPeopleTown = stat.oldestPeopleTown(bulgaria);
		System.out.println(stat.countMarriedPeople(oldestPeopleTown));

	}
}
