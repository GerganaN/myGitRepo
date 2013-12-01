/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns.tests;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skrill.interns.java.Country;
import com.skrill.interns.java.Town;

public class CountryTest {

	Country country;
	Town town;

	@BeforeMethod
	public void setup() {
		country = new Country("Bulgaria");
	}

	//test if town is null - no town is added
	@Test
	public void addTown_when_town_is_null() throws Exception {
		// GIVEN	
		List mockedList = mock(List.class);
		town =null;
		// WHEN
		country.addTown(town);
		// THEN
		verify(mockedList,never()).add(town);
	}
	//test if town is added in the country
	
	@Test
	public void addTown_when_town_is_added() throws Exception {
		// GIVEN
		town = new Town("varna", 2000);
		// WHEN
		country.addTown(town);
		// THEN
		assertEquals(country.getCountTowns(), 1);
	}
	//test totalArea when == 2000
	@Test
	public void totalArea_when_equals_2000(){
		//given
		Town sofia = new Town("sofia", 500);
		Town varna = new Town("varna", 500);
		country.addTown(varna);
		country.addTown(sofia);
		country.setFreeZone(1000);
		//when
		long result = country.totalArea();
		//then
	assertEquals(result, 2000, "test passed");
	}
	@Test
	public void totalArea_when_no_towns(){
		//given
		country.setFreeZone(1000);
		//when
		long result = country.totalArea();
		//then
		assertEquals(result, country.getFreeZone());
	}
	@Test
	public void totalArea_exception() throws Exception {
		//given
		town = new Town ("sofia" , 111);
		country.addTown(town);
		List<Town> listTowns = country.getTowns();
		Town aaa = listTowns.get(0);
		Town spyTown = spy(aaa);
		//when
		country.totalArea();
		//then
		verify(spyTown).getArea();//.getArea();
	}
	
}
