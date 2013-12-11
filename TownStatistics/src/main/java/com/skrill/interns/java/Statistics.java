package com.skrill.interns.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;
import java.util.List;

public class Statistics {

	public BigDecimal populationDensity(Town town) {
		if (town == null) {
			return null;
		}
		int area = town.getArea();
		long population = town.getCountPopulation();
		if (area == 0 || population == 0) {
			return null;
		}
		long result = population / area;
		return BigDecimal.valueOf(result);
	}

	public String dominantSex(Town town) {
		if (town == null) {
			return null;
		}
		if (town.getCountMen() < town.getCountWomen()) {
			return "Women conquered the world!";
		} else {
			return "Men exceed women";
		}
	}

	public BigDecimal averageAge(Town town) {
		if (town == null) {
			return null;
		}

		long age = town.getCountPopAge();
		long population = town.getCountPopulation();
		if (population == 0) {
			return null;
		}
		BigDecimal result = BigDecimal.valueOf(age / population);

		return result;

	}

	public Town oldestPeopleTown(Country country) {
		
		Town oldestPeopleTown = null;

		try {
			List<Town> countryTownsList = country.getTowns();
			oldestPeopleTown = countryTownsList.get(0);
			Statistics stat = new Statistics();
			BigDecimal oldestAge = stat.averageAge(oldestPeopleTown);

			if (oldestAge == null || countryTownsList == null){
				return null;
			}
			for (int i = 1; i < country.getCountTowns(); i++) {
				if (oldestAge
						.compareTo(stat.averageAge(countryTownsList.get(i))) == -1) {
					oldestAge = stat.averageAge(countryTownsList.get(i));
					oldestPeopleTown = countryTownsList.get(i);
				}
			}
			return oldestPeopleTown;
		} catch (NullPointerException ex) {
			System.out.println("Exception found! Program ends.");
			
		}
		return oldestPeopleTown;
	}

	public BigDecimal procentFreeZone(Country country) {
		if (country == null) {
			return null;
		}
		long totalArea = country.totalArea();
		long freeZone = country.getFreeZone();
		if (totalArea == 0){ 
			return null;
		}
		BigDecimal procent = (BigDecimal.valueOf(freeZone).divide(
				BigDecimal.valueOf(totalArea), 3, BigDecimal.ROUND_FLOOR))
				.multiply(BigDecimal.valueOf(100));
		return procent;
	}

	public BigDecimal countryDensity(Country country) {
		try {
			long area = country.totalArea();
			long countPop = 0;
			List<Town> countryTownsList = country.getTowns();
			if (countryTownsList == null){
				return null;
			}
			for (int i = 0; i < country.getCountTowns(); i++) {
				countPop += countryTownsList.get(i).getCountPopulation();
			}
			BigDecimal countryDensity = BigDecimal.valueOf(countPop).divide(
					BigDecimal.valueOf(area), 3, BigDecimal.ROUND_FLOOR);
			return countryDensity;

		} catch (NullPointerException ex) {
			System.out.println("Exception found!");
		}
		return null;

	}

	public int countMarriedPeople(Town town) {
		int counter = 0;
		try {

			List<Person> peopleList = town.getPopulation();
			for (int i = 0; i < town.getCountPopulation(); i++)
				for (int j = 0; j < town.getCountPopulation(); j++) {
					if (i != j) {
						if (peopleList.get(i).getlName()
								.equals(peopleList.get(j).getlName() + "a")
								|| (peopleList.get(j).getlName())
										.equals(peopleList.get(i).getlName()
												+ "a")) {
							counter++;
						}
					}

				}
			return counter / 2;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return counter;
	}
}
