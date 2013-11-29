package com.skrill.interns.java;

import java.math.BigDecimal;
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
	
	public Town oldestPeopleTown(Country country){
		if (country == null){
			return null;
		}
		List<Town> countryTownsList = country.getTowns();
		Town oldestPeopleTown = countryTownsList.get(0);
		long oldestAge = countryTownsList.get(0).getCountPopAge();
		
		for ( int i= 1 ; i <countryTownsList.size() ;i++){
			if (oldestAge < countryTownsList.get(i).getCountPopAge()){
				oldestPeopleTown = countryTownsList.get(i);
			}
		}
		return oldestPeopleTown;
	}
	

}
