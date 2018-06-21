package webApi.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogManagementPage extends BasePage {

	public BlogManagementPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getAddButton() {
		WebElement addButton = driver.findElement(By.xpath("//button[@type='submit']"));
		return addButton;
	}

}
