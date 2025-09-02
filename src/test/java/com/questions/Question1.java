package com.questions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/*Q1. Launch Browser and Open Google
Write a Selenium script in Java to:

* Launch Chrome browser
* Open [https://www.google.com](https://www.google.com)
* Print the page title in the console*/
import org.testng.annotations.Test;

public class Question1 {
  
	WebDriver driver;
	@BeforeClass
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}
	@Test
	public void titleOfPage() {
	//String title = driver.findElement(By.xpath("//title[text()='Google']")).getText();
		String title = driver.getTitle();
	System.out.println(title);
	
	}
	@AfterClass
	public void closingBrowser() {
		driver.quit();
	}
}
