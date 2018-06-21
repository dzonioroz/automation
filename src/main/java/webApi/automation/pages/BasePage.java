package webApi.automation.pages;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void isPageOpen(Boolean expectedStatus, String expectedTitle) {
		String title = driver.getTitle();
		// TODO Title is incorrectly spelled on Administrator Login page
		if (expectedStatus == true) {
			Assert.assertTrue("Page " + title + " is not opened", driver.getTitle().equalsIgnoreCase(expectedTitle));
		}
		if (expectedStatus == false) {
			Assert.assertFalse("Page " + title + " is opened", driver.getTitle().equalsIgnoreCase(expectedTitle));
		}
	}
}
