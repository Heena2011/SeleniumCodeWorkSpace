package pack1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_Keys {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php?");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		if(driver.findElement(By.id("email_create")).isDisplayed())
		{
			System.out.println("email create is displayed");
			driver.findElement(By.id("email_create")).clear();
			driver.findElement(By.id("email_create")).sendKeys("asdfgd@gmail.com");
			driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
			driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
		}
		else
		{
			System.out.println("email create is not displayed!!");
		}
		
		
		
		// Explicit wait instead of Thread.sleep
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1"))).click();

        if (driver.findElement(By.id("id_gender1")).isSelected()) {
            System.out.println("gender1 is selected");
        } else {
            System.out.println("gender1 is not selected");
        }

        driver.quit();
		
//		 Thread.sleep(3000);
//		driver.findElement(By.id("id_gender1")).click();
//		
//		if(	driver.findElement(By.id("id_gender1")).isSelected())
//		{
//			System.out.println("gender1 is selected");
//		}
//		else
//		{
//			System.out.println("gender1 is not selected");
//		}
		
}
}
