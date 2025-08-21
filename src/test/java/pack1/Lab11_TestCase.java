package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab11_TestCase {
	WebDriver driver;
	Lab11_3TestNG loginPage;
	Lab11_4TestNG amazonHome;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Initialize page objects
		loginPage = new Lab11_3TestNG(driver);
		amazonHome = new Lab11_4TestNG(driver);
	}

	@Test(priority = 1)
	public void testAutomationPracticeLoginPage() {
		driver.get("http://www.automationpractice.pl/index.php?");
		loginPage.clickSignIn();
		int textFields = loginPage.getTextFieldCount();
		System.out.println("Total text fields on Login page: " + textFields);
	}

	@Test(priority = 2)
	public void testAmazonHomePageLinks() {
		driver.get("https://www.amazon.in/");
		int totalLinks = amazonHome.getTotalLinks();
		System.out.println("Total links in amazon.in: " + totalLinks);
		amazonHome.printAllLinks();
	}
}
