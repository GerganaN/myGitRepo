/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.tests;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skrill.interns.java.Country;
import com.skrill.interns.java.Person;
import com.skrill.interns.java.Statistics;
import com.skrill.interns.java.Town;

public class StatisticsTest {

	Statistics statistics;
	Town town;
	Town townSpy;
	Country country;
	Country countrySpy;
	BigDecimal result;

	@BeforeMethod
	public void setup() {
		town = new Town("sofia", 123);
		statistics = new Statistics();
		townSpy = spy(town);
	}

	// test when town is not initialized and is null
	@Test
	public void populationDensity_is_town_is_null() throws Exception {
		// GIVEN
		town = null;
		// WHEN
		result = statistics.populationDensity(town);
		// THEN
		assertNull(result);
	}

	// test if populationDensity method invokes countPopulation
	@Test
	public void populationDensity_invokes_getCountPopulation() throws Exception {
		// GIVEN

		// WHEN
		statistics.populationDensity(townSpy);
		// THEN
		verify(townSpy).getCountPopulation();
	}

	// test if populationDensity method invokes getArea
	@Test
	public void populationDensity_invokes_getArea() throws Exception {
		// GIVEN
		// WHEN
		statistics.populationDensity(townSpy);
		// THEN
		verify(townSpy).getArea();

	}

	// test populationDensity method for division by zero
	@Test
	public void populationDensity_divide_by_zero() throws Exception {
		// GIVEN
		townSpy.setArea(0);
		// WHEN
		result = statistics.populationDensity(townSpy);
		// THEN
		assertNull(result);
	}

	@Test
	public void populationDensity_when_result_is_2() throws Exception {
		// GIVEN
		town.setArea(1);
		Person person1 = new Person("gosho", "goshov", 22, 'm');
		Person person2 = new Person("pesho", "peshov", 25, 'm');
		town.addPerson(person1);
		town.addPerson(person2);
		// WHEN
		result = statistics.populationDensity(town);
		// THEN
		assertEquals(result, BigDecimal.valueOf(2));
	}

	// test dominantSex if town is not initialized and is null
	@Test
	public void dominantSexy_when_town_is_null() throws Exception {
		// GIVEN
		town = null;
		// WHEN
		String result = statistics.dominantSex(town);
		// THEN
		assertEquals(result, null);
	}

	// test dominantSex method if countMen is invoked
	@Test
	public void dominantSex_invokes_getCountMen() throws Exception {
		// GIVEN
		// WHEN
		statistics.dominantSex(townSpy);
		// THEN
		verify(townSpy).getCountMen();
	}

	// test dominantSex method if countWomen is invoked
	@Test
	public void dominantSex_invokes_getCountWomen() throws Exception {
		// GIVEN
		// WHEN
		statistics.dominantSex(townSpy);
		// THEN
		verify(townSpy).getCountWomen();
	}

	// test dominantSex if men are more than women
	@Test
	public void dominantSex_when_men_are_more() throws Exception {
		// GIVEN
		Person person1 = new Person("gosho", "goshov", 22, 'm');
		Person person2 = new Person("pesho", "peshov", 25, 'm');
		Person person3 = new Person("mariika", "ivanoiva", 11, 'm');
		town.addPerson(person1);
		town.addPerson(person2);
		town.addPerson(person3);
		// WHEN
		String result = statistics.dominantSex(town);
		// THEN
		assertEquals(result, "Men exceed women");
	}

	// test dominantSex if women are more than men
	@Test
	public void dominantSex_when_women_are_more() throws Exception {
		// GIVEN
		Person person1 = new Person("gosho", "goshov", 22, 'm');
		Person person2 = new Person("penka", "ivanova", 25, 'f');
		Person person3 = new Person("mariika", "ivanoiva", 11, 'f');
		town.addPerson(person1);
		town.addPerson(person2);
		town.addPerson(person3);
		// WHEN
		String result = statistics.dominantSex(town);
		// THEN
		assertEquals(result, "Women conquered the world!");
	}

	// test averegaAge if town is not initialized and is null
	@Test
	public void averageAge_when_town_is_null() throws Exception {
		// GIVEN
		town = null;
		// WHEN
		String result = statistics.dominantSex(town);
		// THEN
		assertEquals(result, null);
	}
 //test averageAge if getCountPopulation is zero

@Test
public void averageAge_when_getCountPopulation_is_zero() throws Exception {
	// GIVEN
	// WHEN
	result = statistics.averageAge(town);
	// THEN
	assertNull(result);
}	
	// test averageAge if getCountPopAge is invoked
	@Test
	public void averageAge_invokes_getCountPopAge() throws Exception {
		// GIVEN
		// WHEN
		statistics.averageAge(townSpy);
		// THEN
		verify(townSpy).getCountPopAge();
	}

	// test averageAge if getCountPopulation is invoked
	@Test
	public void averageAge_invokes_getCountPopulation() throws Exception {
		// GIVEN
		// WHEN
		statistics.averageAge(townSpy);
		// THEN
		verify(townSpy).getCountPopulation();
	}

	//test averageAge just a test
	
	@Test
	public void averageTest_when_result_is_35() throws Exception {
		// GIVEN
		Person person1 = new Person("gosho", "goshov", 50, 'm');
		Person person2 = new Person("pesho", "peshov", 20, 'm');
		town.addPerson(person1);
		town.addPerson(person2);
		// WHEN
		result = statistics.averageAge(town);
		// THEN
		assertEquals(result, BigDecimal.valueOf(35));
	}
	//test oldestTown when country is null
	
	@Test
	public void oldestTown_when_country_is_null() throws Exception {
		// GIVEN
		country = null;
		// WHEN
		Town result = statistics.oldestPeopleTown(country);
		// THEN
		assertNull(result);
	}
	//test oldestTown that other methods are  invoked
	
	@Test
	public void oldestTown_methods_are_invoked() throws Exception {
		// GIVEN
		country =new Country("bulgaria");
		country.addTown(townSpy);
		countrySpy = spy(country);
		
		// WHEN
		statistics.oldestPeopleTown(countrySpy);
		// THEN
		verify(countrySpy).getTowns();
		verify(townSpy).getCountPopAge();
		
		
	}
}
