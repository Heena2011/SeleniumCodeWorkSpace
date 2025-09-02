package com.questions;
/*Q7. Web Table Data Extraction
Open [https://the-internet.herokuapp.com/tables](https://the-internet.herokuapp.com/tables)

* Print all names from the first table
* Find the email ID of the user "Jason"*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question7 {

	WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
	}
	
	@Test
    public void extractTableData() {
        // 1️ Get all rows of the first table (table id="table1")
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println("All names in the first table:");
        for(WebElement row : rows) {
            // The first column has the full name
            String name = row.findElement(By.xpath("td[1]")).getText();
            System.out.println(name);
        }

        // 2️ Find email of user "Jason"
        for(WebElement row : rows) {
            String name = row.findElement(By.xpath("td[1]")).getText();
            if(name.contains("Jason")) {
                String email = row.findElement(By.xpath("td[3]")).getText();
                System.out.println("Email of Jason: " + email);
                break; // stop after finding Jason
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
