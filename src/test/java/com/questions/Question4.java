package com.questions;
/*Q4. Handle Dropdown
Open [https://www.selenium.dev/selenium/web/web-form.html](https://www.selenium.dev/selenium/web/web-form.html)

* Select “Option 2” from the dropdown
* Verify the selected option*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question4 {

	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().maximize();
	}

	@Test
	public void selectDrpDown() {
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='my-select']"));
		// driver.findElement(By.xpath("//select[@name='my-select']//option[@value=\"2\"]")).click();
		Select drp = new Select(dropdown);
		drp.selectByVisibleText("Two");
		String selectedOption = drp.getFirstSelectedOption().getText();
		if (selectedOption.equals("Two")) {
			System.out.println("Option 'Two' is selected successfully!");
		} else {
			System.out.println("Option 'Two' is NOT selected.");
		}

	}
	 @AfterClass
	    public void QuitBrowser() {
	    	driver.quit();
	    }
		
}
