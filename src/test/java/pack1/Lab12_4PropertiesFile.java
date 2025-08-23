package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12_4PropertiesFile {

	WebDriver driver;
	  @Test()
	  public void f() throws InterruptedException, IOException {
		  Properties prob=new Properties();
		  FileInputStream fis=new FileInputStream("F:\\Java-Selenium-Batch 9\\SeleniumClassCode\\Lab12.properties");
		  prob.load(fis);
		  String username=prob.getProperty("username");
		  String password=prob.getProperty("password");
				
				
	  }
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  Properties prob=new Properties();
		  FileInputStream fis=new FileInputStream("F:\\Java-Selenium-Batch 9\\SeleniumClassCode\\Lab12.properties");
		  prob.load(fis);
		  String url=prob.getProperty("url");
		 
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get(url);
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Before Class");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("After class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Before Test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("After Test");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Before Suite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("After Suite");
	  }

}

