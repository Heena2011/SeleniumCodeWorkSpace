package com.questions;
import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/*Q3. Search in E-commerce Website
Write a Selenium script to:

* Open [https://www.amazon.in/](https://www.amazon.in/)
* Search for "laptop"
* Print the first 5 product names from the results*/
import org.testng.annotations.Test;

public class Question3 {
  

	WebDriver driver;	
	
	@BeforeClass
	public void openBorwser(){
	driver=new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	}
	@Test
	public void searchLaptop() throws Exception{
	//Search for elements
		Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop");
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	Thread.sleep(3000);
	//search for first five elments
	//List<WebElement> laptopList =  driver.findElements(By.xpath("//div[@role='listitem' and @data-index<=\"7\"]"));
	List<WebElement> laptopList =  driver.findElements(By.xpath("//div[@role='listitem' and @data-index<=\"7\"]//h2//span"));
	for(WebElement li : laptopList) {
	System.out.println(li.getText());
	System.out.println();
	}
	}
	@AfterClass
	public void quitBrowser() throws Exception{
		Thread.sleep(5000);
	driver.quit();
	}
}
