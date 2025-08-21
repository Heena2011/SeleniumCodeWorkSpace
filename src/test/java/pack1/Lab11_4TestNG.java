package pack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lab11_4TestNG {

	 WebDriver driver;

	    // Locator
	    By allLinks = By.tagName("a");

	    // Constructor
	    public Lab11_4TestNG(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public int getTotalLinks() {
	        List<WebElement> links = driver.findElements(allLinks);
	        return links.size();
	    }

	    public void printAllLinks() {
	        List<WebElement> links = driver.findElements(allLinks);
	        for (WebElement link : links) {
	            System.out.println("Link Text: " + link.getText());
	            System.out.println("Link Href: " + link.getAttribute("href"));
	        }
	    }
}
