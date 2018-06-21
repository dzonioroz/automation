package webApi.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void isOpen(Boolean expectedStatus) {
		String title = driver.getTitle();
		System.out.println(title);
		// TODO Title is incorrectly spelled, bug to report
		if (expectedStatus == true) {
			Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Administator Login"));
		}
		if (expectedStatus == false) {
			Assert.assertFalse(driver.getTitle().equalsIgnoreCase("Administator Login"));
		}
	}

	public WebElement getEmailInput() {
		WebElement emailInput = driver.findElement(By.name("email"));
		return emailInput;
	}

	public void setEmail(String email) {
		getEmailInput().sendKeys(email);
	}

	public WebElement getPasswordInput() {
		WebElement passwordInput = driver.findElement(By.name("password"));
		return passwordInput;
	}

	public void setPassword(String password) {
		getPasswordInput().sendKeys(password);
	}

	public WebElement getLoginButton() {
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		return loginButton;
	}
	
	public WebElement getErrorMessage(String msg) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), '" + msg + "')]"));
		return errorMessage;
	}

}
