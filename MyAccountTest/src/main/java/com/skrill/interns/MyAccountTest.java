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

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		/*
		 * DesiredCapabilities capabilityFF = DesiredCapabilities.firefox();
		 * RemoteWebDriver webDriver = null; //WebDriver = null; try { webDriver
		 * = new RemoteWebDriver(new URL("http://10.32.23.174:14445/wd/hub"),
		 * capabilityFF); } catch (MalformedURLException e) {
		 * e.printStackTrace(); }
		 */
				String password = "test1234@";

		User pesho = new User();
		pesho.register(driver, password);
		
		// pesho.login(driver, email, password);
		// pesho.logout(driver);
		driver.close();
	}

	

}
