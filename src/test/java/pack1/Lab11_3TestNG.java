package pack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lab11_3TestNG {
	 WebDriver driver;

	    // Locators
	    By signInLink = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	    By textFields = By.xpath("//input[@type='text']");

	    // Constructor
	    public Lab11_3TestNG(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void clickSignIn() {
	        driver.findElement(signInLink).click();
	    }

	    public int getTextFieldCount() {
	        List<WebElement> fields = driver.findElements(textFields);
	        return fields.size();
	    }
}
