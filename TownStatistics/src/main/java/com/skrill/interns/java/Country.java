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
	private long freeZone = 0;

	public Country(String name) {
		this.name = name;
	}

	public Country(String name, long freeZone) {
		this.name = name;
		this.freeZone= freeZone;
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

	public long totalArea() {
		long ruralZone = 0;
		long totalArea = 0;
		if (countTowns == 0 || towns == null) {
			return freeZone;
		}
		for (int i = 0; i < countTowns; i++) {
			ruralZone += towns.get(i).getArea();

		}
		totalArea = ruralZone + freeZone;
		return totalArea;
	}

	public void setFreeZone(long freeZone) {
		this.freeZone = freeZone;
	}

	public long getFreeZone() {
		return freeZone;
	}

	public int getCountTowns() {
		return countTowns;
	}

	public List<Town> getTowns() {
		return towns;
	}
}
