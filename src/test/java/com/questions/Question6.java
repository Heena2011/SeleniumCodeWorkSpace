package com.questions;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*Q6. Handle Checkbox
Write a Selenium script to:

* Open [https://the-internet.herokuapp.com/checkboxes](https://the-internet.herokuapp.com/checkboxes)
* Select both checkboxes (if not already selected)
* Verify that both checkboxes are checked
*/
public class Question6 {
  
	WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		
	}
	@Test
	public void checkBox() {
	List<WebElement> elements=	driver.findElements(By.xpath("//input[@type='checkbox']"));
	
	for(WebElement ele: elements) {
		if(ele.isSelected()) {
			System.out.println("already selected");
		}else {
			System.out.println("Not selelcted plz select");
			ele.click();
		}
	}
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
