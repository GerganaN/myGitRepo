/*
 *
 * Gergana Nikolova Project
 */
package com.skrill.interns;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountTest {

	public static List<String> unsupportedCountries = new ArrayList<String>();
	static {
		unsupportedCountries.add("Cuba");
		unsupportedCountries.add("Afghanistan");
		unsupportedCountries.add("Korea(North)");
	}

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		/*
		 * DesiredCapabilities capabilityFF = DesiredCapabilities.firefox();
		 * RemoteWebDriver webDriver = null; //WebDriver = null; try { webDriver
		 * = new RemoteWebDriver(new URL("http://10.32.23.174:14445/wd/hub"),
		 * capabilityFF); } catch (MalformedURLException e) {
		 * e.printStackTrace(); }
		 */

		String email = "Gergana.Nikolova@skrill.com";
		String password = "test1234@";

		register(driver);
		// login(driver, email, password);
		// logout(driver);
		driver.close();
	}

	public static void register(WebDriver webDriver) {
		Select select;
		Random randomGenerator = new Random();

		webDriver.get(MyAccountParameters.URL_LOGIN);
		// select Bulgaria as country
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.COUNTRY_DROPDOWN)));

		 select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));
		// choose language
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.LANGUAGE)));
		select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));

		// click business type radio button
		webDriver.findElement(By.id(MyAccountParameters.BUSINESS_TYPE)).click();
		// click expenses radio button
		webDriver.findElement(By.id(MyAccountParameters.EXPENSES_TYPE)).click();

		// fill company name
		webDriver.findElement(By.id(MyAccountParameters.COMPANY_NAME))
				.sendKeys("Blueberry");

		// choose type of legal form
		WebElement drop = webDriver.findElement(By
				.id(MyAccountParameters.LEGAL_FORM_DROPDOWN));

		if ("input".equalsIgnoreCase(drop.getTagName())) {
			drop.sendKeys("asdf");
		} else {
			select = new Select(drop);
			select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));
		}

		// fill in address
		webDriver.findElement(By.id(MyAccountParameters.REGISTRATION_ADDRESS1))
				.sendKeys("mladost 4");
		// fill in city
		webDriver.findElement(
				By.id(MyAccountParameters.REGISTRATION_ADDRESS_CITY)).sendKeys(
				"sofia");
		// fill in postal code

		webDriver.findElement(
				By.id(MyAccountParameters.REGISTRATION_POSTAL_CODE)).sendKeys(
				Integer.toString(randomGenerator.nextInt(10000)));

		// fill in profile first name
		webDriver.findElement(
				By.id(MyAccountParameters.REGISTRATION_PROFILE_FIRST_NAME))
				.sendKeys("Gergana");
		// fill in profile last name
		webDriver.findElement(
				By.id(MyAccountParameters.REGISTRATION_PROFILE_LAST_NAME))
				.sendKeys("Nikolova");
		// choose position in company
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.COMPANY_POSITION_DROPDOWN)));
		select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));
		// choose date of birth
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.BIRTH_DATE_DROPDOWN)));
		select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));
		// choose month of birth;
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.BIRTH_MONTH_DROPDOWN)));
		select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));
		// choose year of birth
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.BIRTH_YEAR_DROPDWON)));
		select.selectByIndex(randomGenerator.nextInt(select.getOptions().size()));
		// choose telephone type
		select = new Select(webDriver.findElement(By
				.id(MyAccountParameters.TELEPHONE_TYPE_DROPDOWN)));
		select.selectByIndex(randomGenerator.nextInt(1));
		// fill in telephone
		webDriver.findElement(By.id(MyAccountParameters.ADDRESS_PHONE_ID))
				.sendKeys("899456123");
		// click the button to go to next page
		webDriver.findElement(By.name(MyAccountParameters.BUTTON_NAME))
				.submit();
		// fill in email
		new WebDriverWait(webDriver, 10).until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id(MyAccountParameters.EMAIL))).sendKeys(
				"Gergana.Nikolova@skrill.com");

		// webDriver.findElement(By.id(MyAccountParameters.EMAIL)).sendKeys(
		// "Gergana.Nikolova@skrill.com");

		// fill in password
		webDriver.findElement(By.id(MyAccountParameters.PASSWORD)).sendKeys(
				"test1234@");
		// fill in confirmation password
		webDriver.findElement(By.id(MyAccountParameters.CONFIRM_PASSWORD))
				.sendKeys("test1234@");
		// fill in verify you're a human field

		new WebDriverWait(webDriver, 10, 15).until(
				ExpectedConditions.visibilityOfElementLocated(By
						.id(MyAccountParameters.RECAPTCHA_FIELD))).sendKeys(
				MyAccountParameters.RECAPTCHA_FILL);
		// driver.findElement(By.name("commit")).submit();

	}

	public static void login(WebDriver driver, String email, String password) {
		driver.get("https://my-integr.dev.moneybookers.net/login");

		driver.findElement(By.id(MyAccountParameters.LOGIN_EMAIL_ID)).sendKeys(
				email);
		driver.findElement(By.id(MyAccountParameters.PASSWORD_AUTHECATION_ID))
				.sendKeys(password);
		driver.findElement(By.name(MyAccountParameters.BUTTON_NAME)).submit();
		new WebDriverWait(driver, 10);

	}

	public static void logout(WebDriver driver) {

		new WebDriverWait(driver, 5).until(
				ExpectedConditions.visibilityOfElementLocated(By
						.cssSelector("div.user-actions a.logout-btn"))).click();

		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 * 
		 * driver.findElement( By.xpath(
		 * "//div[contains(@class, 'user-actions')]/a[contains(@class, 'btn register-btn')]"
		 * )) .click();
		 */
	}

}
