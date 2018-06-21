package webApi.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddBlogPage extends BasePage {

	public AddBlogPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getAddButton() {
		WebElement addButton = driver.findElement(By.xpath("//button[@type='submit']"));
		return addButton;
	}

	public WebElement getPostDescriptionInput() {
		WebDriver descriptionFrame = driver.switchTo().frame(0);
		WebElement descriptionInput = descriptionFrame.findElement(By.xpath("//p"));
		return descriptionInput;
	}

	public void setPostDescription(String description) {
		getPostDescriptionInput().sendKeys(description);
	}

	public WebElement getPostTitleInput() {
		WebElement titleElement = driver.findElement(By.name("title"));
		return titleElement;
	}

	public void setPostTitle(String title) {
		getPostTitleInput().sendKeys(title);
	}
	
	public Select getStatusSelect() {
		Select statusElement = new Select(driver.findElement(By.name("status")));
		return statusElement;
	}

	public void setStatusSelect(String status) {
		getStatusSelect().selectByVisibleText("Disable");
	}
	
	public Select getCategorySelect() {
		Select categoryElement = new Select(driver.findElement(By.name("category")));
		return categoryElement;
	}

	public void setCategorySelect(String category) {
		getCategorySelect().selectByVisibleText(" Adventure ");
	}
	
	public WebElement getRelatedPosts() {
		WebElement relatedPostsElement = driver.findElement(By.id("s2id_autogen1"));
		return relatedPostsElement;
	}

	public void clickRelatedPosts() {
		getRelatedPosts().click();
	}
	
	public Select getRelatedPotsSelect() {
		clickRelatedPosts();
		Select element = new Select(driver.findElement(By.name("relatedposts[]")));
		return element;
	}

	public void setRelatedPostsSelect(String relatedPost) {
		getCategorySelect().selectByValue(relatedPost);
	}
	
	public WebElement getThumbnail() {
		WebElement titleElement = driver.findElement(By.name("defaultphoto"));
		return titleElement;
	}

	public void setThumbnail(String fileLocation) {
		getThumbnail().sendKeys(fileLocation);
	}

	public WebElement getSEOKeywords() {
		WebElement keywordsElement = driver.findElement(By.name("keywords"));
		return keywordsElement;
	}

	public void setSEOKeywords(String keywords) {
		getSEOKeywords().sendKeys(keywords);
	}

	public WebElement getSEODescription() {
		WebElement descriptionElement = driver.findElement(By.name("metadesc"));
		return descriptionElement;
	}

	public void setSEODescription(String description) {
		getSEODescription().sendKeys(description);
	}

	public WebElement getSubmitButton() {
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		return submitButton;
	}
	
	public WebElement getPermalinkInput() {
		WebElement permalinkInput = driver.findElement(By.name("slug"));
		return permalinkInput;
	}

}
