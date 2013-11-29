/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.java;

import java.util.ArrayList;
import java.util.List;

public class Country {

	private String name;
	private List<Town> towns = new ArrayList<Town>();
	private int countTowns = 0;

	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addTown(Town town) {
		if (town != null) {
			towns.add(town);
			countTowns++;
		}

	}

	public int getCountTowns() {
		return countTowns;
	}

	public List<Town> getTowns() {
		return towns;
	}
}
