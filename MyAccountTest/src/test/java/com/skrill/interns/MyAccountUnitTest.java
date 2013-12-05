/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns;

import static org.junit.Assert.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyAccountUnitTest {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void when_registration_is_successful() throws Exception {
		// GIVEN
		driver.get("https://my-integr.dev.moneybookers.net/signup");

		// WHEN
		// select Bulgaria as country
		new Select(driver.findElement(By
				.id("user_registration_address_country_id")))
				.selectByVisibleText("Bulgaria");
		// choose language
		new Select(driver.findElement(By
				.id("user_registration_profile_language_id")))
				.selectByValue("ES");

		// click business type radio button
		driver.findElement(By.id("user_registration_type_business")).click();
		// click expenses radio button
		driver.findElement(By.id("user_registration_purpose_expense")).click();

		// fill company name
		driver.findElement(
				By.id("user_registration_business_profile_data_company_name"))
				.sendKeys("Blueberry");
		// choose type of legal form
		new Select(driver.findElement(By
				.id("user_registration_business_profile_data_legal_form")))
				.selectByValue("Aktionerno druzhestvo (AD)");
		// fill in address
		driver.findElement(By.id("user_registration_address_address_line_1"))
				.sendKeys("123456");
		// fill in city
		driver.findElement(By.id("user_registration_address_city")).sendKeys(
				"sofia");
		// fill in postal code
		driver.findElement(By.id("user_registration_address_postal_code"))
				.sendKeys("0000");
		// fill in profile first name
		driver.findElement(By.id("user_registration_profile_first_name"))
				.sendKeys("Gergana");
		// fill in profile last name
		driver.findElement(By.id("user_registration_profile_last_name"))
				.sendKeys("Nikolova");
		// choose position in company
		new Select(
				driver.findElement(By
						.id("user_registration_business_profile_data_representative_position_id")))
				.selectByValue("CEO");
		// choose date of birth
		new Select(driver.findElement(By
				.id("user_registration_profile_birth_date_3i")))
				.selectByValue("1");
		// choose month of birth;
		new Select(driver.findElement(By
				.id("user_registration_profile_birth_date_2i")))
				.selectByValue("1");
		// choose year of birth
		new Select(driver.findElement(By
				.id("user_registration_profile_birth_date_1i")))
				.selectByValue("1995");
		// choose telephone type
		new Select(driver.findElement(By
				.id("user_registration_address_phone_type")))
				.selectByValue("normal");
		// fill in telephone
		driver.findElement(By.id("user_registration_address_phone_phone"))
				.sendKeys("899456123");
		// click the button to go to next page
		driver.findElement(By.name("commit")).submit();
		// fill in email
		driver.findElement(By.id("user_registration_email")).sendKeys(
				"Gergana.Nikolova@skrill.com");
		// fill in password
		driver.findElement(By.id("user_registration_credentials_password"))
				.sendKeys("test1234@");
		// fill in confirmation password
		driver.findElement(
				By.id("user_registration_credentials_password_confirmation"))
				.sendKeys("test1234@");
		// fill in verify you're a human field

		new WebDriverWait(driver, 10, 15).until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id("recaptcha_response_field"))).sendKeys(
				"*(_)$skrill98712=");
		driver.findElement(By.name("commit")).submit();

		// THEN
	}
	
	@Test
	public void when_registration_fails() throws Exception {
		// GIVEN
		// WHEN
		// THEN
	}
}
