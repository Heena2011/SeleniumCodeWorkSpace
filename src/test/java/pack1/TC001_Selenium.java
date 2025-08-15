package pack1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Selenium {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        
	        String title = driver.getTitle();
	        System.out.println("The title is: " + title);

	        // ✅ Wait for the username field to be visible
	        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement usernameField = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
	        );
	        
	        usernameField.sendKeys("Admin");
	        driver.findElement(By.name("password")).sendKeys("admin123");
	    
	}}
