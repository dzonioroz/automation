package webApi.automation.frontend.login;

import junit.framework.Assert;
import webApi.automation.frontend.BaseTest;

public class LoginBaseTest extends BaseTest {

	public void maximazeWindow() {
		getDriver().manage().window().maximize();
	}

	public void loginPageIsOpened(Boolean expectedStatus) {
		loginPage.isPageOpen(expectedStatus, propertiesLoader.getDataProperty("login.page.title"));
	};

	public void userIsSignedIn(Boolean expectedStatus) {
		dashboardPage.isPageOpen(expectedStatus, propertiesLoader.getDataProperty("dashboard.page.title"));
	}

	public void validateErrorMessage(String msg) {
		Assert.assertTrue(loginPage.getErrorMessage(msg).isDisplayed());
	}

}
