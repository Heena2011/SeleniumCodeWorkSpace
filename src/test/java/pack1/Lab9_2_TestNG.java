package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Lab9_2_TestNG {
	@Parameters("browser")
	@Test
	public void test2(@Optional("chrome") String browser) 
  {
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup(); 
		  WebDriver driver=new ChromeDriver(); 
		  driver.get("https://tutorialsninja.com/demo/index.php?");
		  String title=driver.getTitle();
		  System.out.println("Title name is: "+title);
		  Assert.assertEquals(driver.getTitle(),"Your Store");
		  driver.findElement(By.linkText("Desktops")).click();
		  driver.findElement(By.linkText("Mac (1)")).click();
		  //driver.findElement(By.cssSelector("#content > h2"));
		  Assert.assertEquals("Mac", driver.findElement(By.cssSelector("h2")).getText());
		  System.out.println("Mac heading verified");
		  WebElement sort=driver.findElement(By.id("input-sort"));
		  Select sle=new Select(sort);
		  sle.selectByIndex(1);
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		  driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
		  driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		  driver.findElement(By.id("input-search")).clear();
		  driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		  driver.findElement(By.id("button-search")).click();
		  //Monitor
		  driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Monitor");
		  driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		  driver.findElement(By.id("input-search")).clear();
		  driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		  driver.findElement(By.id("button-search")).click();
	  }
	  else
	  {
		  WebDriverManager.edgedriver().setup(); 
		  WebDriver driver=new EdgeDriver(); 
		  driver.get("https://tutorialsninja.com/demo/index.php?");
		  String title=driver.getTitle();
		  System.out.println("Title name is: "+title);
		  Assert.assertEquals(driver.getTitle(),"Your Store");
		  driver.findElement(By.linkText("Desktops")).click();
		  driver.findElement(By.linkText("Mac (1)")).click();
		  //driver.findElement(By.cssSelector("#content > h2"));
		  Assert.assertEquals("Mac", driver.findElement(By.cssSelector("h2")).getText());
		  System.out.println("Mac heading verified");
		  WebElement sort=driver.findElement(By.id("input-sort"));
		  Select sle=new Select(sort);
		  sle.selectByIndex(1);
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		  driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
		  driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		  driver.findElement(By.id("input-search")).clear();
		  driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		  driver.findElement(By.id("button-search")).click();
		  //Monitor
		  driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Monitor");
		  driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		  driver.findElement(By.id("input-search")).clear();
		  driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		  driver.findElement(By.id("button-search")).click();
	  }
	  
		  
	  
  }
}
