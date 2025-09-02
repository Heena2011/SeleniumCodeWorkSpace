package com.questions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/*Q8. Multiple Windows Handling
Open [https://the-internet.herokuapp.com/windows](https://the-internet.herokuapp.com/windows)

* Click "Click Here" to open a new window
* Switch to the new window and print its title
* Switch back to the parent window and print its title*/
import org.testng.annotations.Test;

public class Question8 {

	WebDriver driver;

	@BeforeClass
	public void open() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();

	}

	@Test
	public void windoHandles() {
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

		Set<String> allwindows = driver.getWindowHandles();
		for (String win : allwindows) {
			if (!win.equals(parentWindow)) {
				driver.switchTo().window(win);
				System.out.println(driver.getTitle());
			}
		}

	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
