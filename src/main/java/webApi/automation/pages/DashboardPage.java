package webApi.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getBlogButton() {
		WebElement blogButton = driver.findElement(By.xpath("//li/ul[@id='Blog']"));
		return blogButton;
	}

	public WebElement getPostsButton() {
		WebElement postsButton = driver.findElement(By.xpath("//ul[@id='Blog']/li/a[contains(text(),'Posts')]"));
		return postsButton;
	}

	public List<WebElement> getButtons() {
		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='row form-group']//div//button"));
		return buttons;
	}

}
