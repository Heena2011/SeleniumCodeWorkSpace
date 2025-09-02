package com.questions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/*Q2. Automate Login Page
Automate the following scenario:

* Open [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login)
* Enter username: tomsmith
* Enter password: SuperSecretPassword!
* Click Login
* Verify successful login message
*/
import org.testng.annotations.Test;

public class Question2 {
  
	WebDriver driver;
	@BeforeClass
	public void openBrowser(){
	driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/login");
	driver.manage().window().maximize();
	}
	@Test
	public void login(){
	//Username
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
	//Password
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
	//login button
	driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
	String successMsg = driver.findElement(By.id("flash")).getText();
    System.out.println("Login Message: " + successMsg);

    // Assertion (TestNG will mark test pass/fail)
    Assert.assertTrue(successMsg.contains("You logged into a secure area!"),
            "Login was not successful!");
	
	
	
	}
	@AfterClass
	public void closeBrowser(){
	driver.quit();
	}

}
