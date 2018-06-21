package webApi.automation.frontend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import webApi.automation.handlers.PropertiesLoader;
import webApi.automation.pages.AddBlogPage;
import webApi.automation.pages.BlogManagementPage;
import webApi.automation.pages.DashboardPage;
import webApi.automation.pages.LoginPage;

public class BaseTest {

	private WebDriver driver;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public BlogManagementPage blogManagementPage;
	public AddBlogPage addBlogPage;
	public static PropertiesLoader propertiesLoader;

	@BeforeMethod
	public void setUp() {
		initProp();
		initDrivers();
	}

	public void initDrivers() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/data/geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(propertiesLoader.getEnvProperty("base.url"));
		
		loginPage = new LoginPage(getDriver());
		
		dashboardPage = new DashboardPage(getDriver());
		
		blogManagementPage = new BlogManagementPage(getDriver());
	}

	public void initProp() {
		propertiesLoader = new PropertiesLoader();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait waitForElementToLoad() {
		WebDriverWait waitForElement = new WebDriverWait(driver, 3);
		return waitForElement;
	}
	
	public void enterCredentials(String email, String password) {
		loginPage.setEmail(email);
		loginPage.setPassword(password);
	};

	public void clickSignIn() {
		loginPage.getLoginButton().click();
	}
}
