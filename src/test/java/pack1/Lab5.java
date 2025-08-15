package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://demo.nopcommerce.com/");
	//WebElement register = driver.findElement(By.name("ico-register"));
//		search.sendKeys("Automation Testing Tools");
//		search.submit();
 	System.out.println("Title:"+driver.getTitle());
	}
}
