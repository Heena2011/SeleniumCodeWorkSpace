package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Lab9_1_TestNG {
	@Parameters("browser")
	@Test
	public void test1(@Optional("chrome") String browser) {
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup(); 
		  WebDriver driver=new ChromeDriver(); 
		  driver.get("https://tutorialsninja.com/demo/index.php?");
		  driver.findElement(By.linkText("Desktops")).click();
		  driver.findElement(By.linkText("Mac (1)")).click();
		  WebElement sort=driver.findElement(By.id("input-sort"));
		  Select sle=new Select(sort);
		  sle.selectByIndex(1);
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		  System.out.println("Run successfully");
	  }
	  else
	  {
		  WebDriverManager.edgedriver().setup(); 
		  WebDriver driver=new EdgeDriver(); 
		  driver.get("https://tutorialsninja.com/demo/index.php?");
		  driver.findElement(By.linkText("Desktops")).click();
		  driver.findElement(By.linkText("Mac (1)")).click();
		  WebElement sort=driver.findElement(By.id("input-sort"));
		  Select sle=new Select(sort);
		  sle.selectByIndex(1);
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		  System.out.println("Run successfully");
	  }
		 
	  
  }
}