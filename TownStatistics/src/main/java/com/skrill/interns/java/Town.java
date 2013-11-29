package com.skrill.interns.java;

import java.util.ArrayList;
import java.util.List;

public class Town {

	private String name;
	private int area;
	private List<Person> population = new ArrayList<Person>();
	private long countPopulation = 0;
	private long countPopAge = 0;
	private long countWomen = 0;
	private long countMen = 0;

	
	public Town(String name) {
		this.name = name;
	}

	public Town(String name, int area) {
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public long getCountPopulation() {
		return countPopulation;
	}

	public long getCountPopAge() {
		return countPopAge;
	}

	public long getCountWomen() {
		return countWomen;
	}

	public long getCountMen() {
		return countMen;
	}

	public void addPerson(Person person) {
		if (person != null) {
			population.add(person);
			countPopulation++;
			countPopAge += person.getAge();
 
			if (person.getSex() == 'm') {
				countMen++;

			} else {
				countWomen++;

			}

		}

	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Town : " + getName() + "\n");
		s.append("Info for people in town : \n");
		for (int i = 0; i < countPopulation; i++) {
			s.append(population.get(i).getfName());
			s.append(", ");
			s.append(population.get(i).getlName());
			s.append(", ");
			s.append(population.get(i).getAge());
			s.append(", ");
			s.append(population.get(i).getSex());
			s.append("\n");
		}
		return s.toString();
	}
	/*
	 * public long getPeopleAge() {
	 * 
	 * if (population == null) { return 0; } int totalAge = 0; for (int i = 0; i
	 * < population.size(); i++) { totalAge += population.get(i).getAge(); }
	 * return totalAge; }
	 * 
	 * public int countPopulation() {
	 * 
	 * if (population == null) { return 0; } return population.size(); }
	 * 
	 * public int countWomen() { int count = 0; if (population == null) { count
	 * = 0; } for (int i = 0; i < population.size(); i++) { if
	 * (population.get(i).getSex() == 'f') { count++; } } return count; }
	 * 
	 * public int countMen() { int count = 0; if (population == null) { count =
	 * 0; }
	 * 
	 * for (int i = 0; i < population.size(); i++) { if
	 * (population.get(i).getSex() == 'm') { count++; } } return count; }
	 */
}
