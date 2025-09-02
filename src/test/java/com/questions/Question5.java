package com.questions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*Q5. Handle Alert Popup
Automate the following:

* Open [https://the-internet.herokuapp.com/javascript\_alerts](https://the-internet.herokuapp.com/javascript_alerts)
* Click "Click for JS Alert"
* Accept the alert
* Verify that the result text shows "You successfully clicked an alert"*/
public class Question5 {
  
	WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
	}
	@Test
	public void handleAlret() throws Exception {
	WebElement js=driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']"));
	js.click();
	
	Alert jsAlert = driver.switchTo().alert();
	Thread.sleep(5000);
	jsAlert.accept();
	String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
	
	if(result.equals("You successfully clicked an alert")) {
		System.out.println(result);
	}else {
		System.out.println("Wrong result");
	}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
