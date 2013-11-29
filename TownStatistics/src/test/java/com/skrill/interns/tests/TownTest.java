package com.skrill.interns.tests;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.List;

import org.testng.annotations.*;

import com.skrill.interns.java.Person;
import com.skrill.interns.java.Town;

public class TownTest {

	Person person;
	Town town;
	Person personSpy;

	@BeforeMethod
	public void setup() {
		town = new Town("sofia");
		person = new Person("gagi", "nikolova", 22, 'f');
		personSpy = spy(person);
	}

	// test addPerson if getAge is invoked

	@Test
	public void addPerson_invokes_getAge() throws Exception {
		// GIVEN
		// WHEN
		town.addPerson(personSpy);
		// THEN
		verify(personSpy).getAge();
	}

	// test addPerson if getSex is invokes

	@Test
	public void addPerson_invokes_getSex() throws Exception {
		// GIVEN
		// WHEN
		town.addPerson(personSpy);
		// THEN
		verify(personSpy).getSex();
	}

	// test if addPerson adds person

	@Test
	public void addPerson_adds_person() throws Exception {
		// GIVEN
		// WHEN
		town.addPerson(person);
		// THEN
		assertEquals(town.getCountPopulation(), 1);
	}  

	// test -verify add was never invoked

	@Test
	public void addPerson_add_never_invoked() throws Exception {
		// GIVEN
		List mockedList = mock(List.class);
		person = null;
		// WHEN
		town.addPerson(person);
		// THEN
		verify(mockedList, never()).add(person);
	}
	
	// test if addPerson when you add new woman increases countWomen

	@Test
	public void addPerson_countWomen_increases() throws Exception {
		// GIVEN
		// WHEN
		town.addPerson(person);
		// THEN
		assertNotEquals(town.getCountWomen(), 0);
	}

	// test if addPerson when you add new man increases countMen

	@Test
	public void addPerson_countMen_increases() throws Exception {
		// GIVEN
		person.setSex('m');
		// WHEN
		town.addPerson(person);
		// THEN
		assertNotEquals(town.getCountMen(), 0);
	}

	// test countAge increases when you add new person

	@Test
	public void addPerson_countAge_when_person_is_added() throws Exception {
		// GIVEN
		// WHEN
		town.addPerson(person);
		// THEN
		assertNotEquals(town.getCountPopAge(), 0);
	}

}
