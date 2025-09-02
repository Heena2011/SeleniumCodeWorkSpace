package com.questions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question9 {

	WebDriver driver;

    @BeforeClass
    public void setup() {
       
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void captureScreenshot() throws IOException {
        // Cast driver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot and store it as a file
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Define destination path in your project folder
        File dest = new File("homepage.png");

        // Copy screenshot to destination
        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
