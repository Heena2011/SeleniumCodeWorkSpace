package pack1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Lab7 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Title :" + driver.getTitle());

		driver.get("https://letcode.in/alert");

		// for alert
		driver.findElement(By.id("accept")).click();
		Alert salert = driver.switchTo().alert();
		System.out.println("The Message : " + salert.getText());
		salert.accept();

		//for confirm alert
		driver.findElement(By.id("confirm")).click();
		Alert calert = driver.switchTo().alert();
		System.out.println("The Message is : " + calert.getText());
		calert.accept();
		
		
		//for promt alert
		driver.findElement(By.id("prompt")).click();
		Alert palert = driver.switchTo().alert();
		System.out.println("The Message : " + palert.getText());
		palert.sendKeys("Vivek");
		palert.accept();
		


	}
}
