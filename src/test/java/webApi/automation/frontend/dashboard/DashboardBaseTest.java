package webApi.automation.frontend.dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;
import webApi.automation.frontend.BaseTest;
import webApi.automation.frontend.login.LoginBaseTest;

public class DashboardBaseTest extends BaseTest {

	protected LoginBaseTest loginBaseTest;

	public void login() {
		enterCredentials(propertiesLoader.getDataProperty("email"), propertiesLoader.getDataProperty("password"));
		clickSignIn();
	}

	public void userIsOnDashboardPage(Boolean expectedStatus) {
		waitForElementToLoad()
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[contains(text(),'Dashboard')]")));
		dashboardPage.isPageOpen(expectedStatus, propertiesLoader.getDataProperty("dashboard.page.title"));
	}

	public void userIsOnBlogManagementPage(Boolean expectedStatus) {
		waitForElementToLoad().until(ExpectedConditions.elementToBeClickable((blogManagementPage.getAddButton())));
		blogManagementPage.isPageOpen(expectedStatus, propertiesLoader.getDataProperty("blog.management.page.title"));
	}

	public ArrayList<String> getButtonsFromDashboardPage() {
		ArrayList<String> arrayOfButtons = new ArrayList<String>();
		List<WebElement> listOfButtons = dashboardPage.getButtons();
		Iterator<WebElement> itr = listOfButtons.iterator();
		while (itr.hasNext()) {
			WebElement button = itr.next();
			String buttonName = button.getText().replaceAll("\\s", "");
			System.out.println(button.getText());
			arrayOfButtons.add(buttonName);
		}
		System.out.println(arrayOfButtons);
		return arrayOfButtons;
	}

	public ArrayList<String> expectedButtonsDashboardPage() {
		ArrayList<String> arrayOfExpectedButtons = new ArrayList<String>();
		arrayOfExpectedButtons.add(("QUICK BOOKING").replaceAll("\\s", ""));
		arrayOfExpectedButtons.add(("BOOKINGS").replaceAll("\\s", ""));
		arrayOfExpectedButtons.add(("CMS PAGES").replaceAll("\\s", ""));
		arrayOfExpectedButtons.add(("BLOG").replaceAll("\\s", ""));
		arrayOfExpectedButtons.add(("SEND NEWSLETTER").replaceAll("\\s", ""));
		arrayOfExpectedButtons.add(("BACKUP DATABSE").replaceAll("\\s", ""));

		return arrayOfExpectedButtons;
	}

	public static boolean compareButtonList(List<String> actualButtons, List<String> expectedButtons) {
		if (actualButtons.size() != expectedButtons.size())
			return false;
		Collections.sort(actualButtons);
		Collections.sort(expectedButtons);
		for (int i = 0; i < actualButtons.size(); i++) {
			if (!actualButtons.get(i).equals(expectedButtons.get(i)))
				return false;
		}
		return true;
	}

	public void validateAllButtonsArePresent() {
		ArrayList<String> actualButtons = getButtonsFromDashboardPage();
		ArrayList<String> expectedButtons = expectedButtonsDashboardPage();

		Assert.assertTrue(compareButtonList(actualButtons, expectedButtons));

	}

	public void clickBlogAndPostsButton() {
		dashboardPage.getBlogButton().click();
		dashboardPage.getPostsButton().click();
	}

	public void addNewPost() {
		addBlogPage.setPostTitle("Test Post");
		addBlogPage.setPostDescription("This is my first post");
		addBlogPage.setStatusSelect("Disable");
		addBlogPage.setCategorySelect(" Adventure ");
		addBlogPage.setRelatedPostsSelect("30");
		addBlogPage.setRelatedPostsSelect("31");
		addBlogPage.setThumbnail("C:\\Users\\HP 840 G3\\Downloads\\logo.png");
		addBlogPage.setSEOKeywords("Post");
		addBlogPage.setSEODescription("What a beautiful post");

		addBlogPage.getSubmitButton().click();
	}

	public void clickAddButton() {
		blogManagementPage.getAddButton().click();
	}

	public void userIsOnAddBlogPage(Boolean expectedStatus) {
		waitForElementToLoad().until(ExpectedConditions.elementToBeClickable((addBlogPage.getSubmitButton())));
		addBlogPage.isPageOpen(expectedStatus, propertiesLoader.getDataProperty("add.blog.page.title"));
	}

	public void permalinkFieldIsPopulated() {
		String permalink = addBlogPage.getPermalinkInput().getText();
		Assert.assertFalse(permalink.isEmpty());
	}
	
	public void deletePost() {
		
	}
}
