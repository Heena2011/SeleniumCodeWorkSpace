//package pack1;
//
//
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class OpenCartRegisterTest {
//    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Part 1: Launch and navigate
//        driver.get("https://demo.opencart.com/");
//        driver.manage().window().maximize();
//
//        // Verify title
//        String expectedTitle = "Your Store";
//        String actualTitle = driver.getTitle();
//        if (actualTitle.equals(expectedTitle)) {
//            System.out.println("Title verified: " + actualTitle);
//        } else {
//            System.out.println("Title mismatch! Found: " + actualTitle);
//        }
//
//        // Click My Account > Register
//        WebElement myAccountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
//        myAccountDropdown.click();
//        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
//        registerLink.click();
//
//        // Verify heading
//        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Register Account']")));
//        if (heading.isDisplayed()) {
//            System.out.println("Register Account page opened successfully");
//        }
//
//        // Click Continue without filling anything to trigger warning
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
//        WebElement privacyWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
//        System.out.println("Warning message: " + privacyWarning.getText());
//
//        // Part 2: Personal Details
//        WebElement firstName = driver.findElement(By.id("input-firstname"));
//        String firstNameText = "A".repeat(33);
//        firstName.sendKeys(firstNameText);
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
//        WebElement firstNameError = driver.findElement(By.cssSelector(".text-danger"));
//        System.out.println("First Name error: " + firstNameError.getText());
//
//        firstName.clear();
//        firstName.sendKeys("John");
//
//        WebElement lastName = driver.findElement(By.id("input-lastname"));
//        lastName.sendKeys("Doe");
//
//        WebElement email = driver.findElement(By.id("input-email"));
//        email.sendKeys("john.doe" + System.currentTimeMillis() + "@gmail.com");
//
//        WebElement telephone = driver.findElement(By.id("input-telephone"));
//        telephone.sendKeys("9876543210");
//
//        // Part 3: Address
//        WebElement address1 = driver.findElement(By.id("input-address-1"));
//        address1.sendKeys("123 Main Street");
//
//        WebElement city = driver.findElement(By.id("input-city"));
//        city.sendKeys("Mumbai");
//
//        WebElement postCode = driver.findElement(By.id("input-postcode"));
//        postCode.sendKeys("400001");
//
//        Select countryDropdown = new Select(driver.findElement(By.id("input-country")));
//        countryDropdown.selectByVisibleText("India");
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("input-zone")));
//        Select regionDropdown = new Select(driver.findElement(By.id("input-zone")));
//        regionDropdown.selectByIndex(1); // first state in India
//
//        // Part 4: Password
//        WebElement password = driver.findElement(By.id("input-password"));
//        password.sendKeys("Test1234");
//
//        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
//        confirmPassword.sendKeys("Test1234");
//
//        // Newsletter
//        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
//        driver.findElement(By.name("agree")).click();
//
//        // Submit
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//        // Verify account creation
//        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your Account Has Been Created!']")));
//        System.out.println("Success: " + successMsg.getText());
//
//        driver.findElement(By.xpath("//a[text()='Continue']")).click();
//
//        // View Order History
//        WebElement orderHistory = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View your order history")));
//        orderHistory.click();
//
//        System.out.println("Order history page opened: " + driver.getTitle());
//
//        driver.quit();
//    }
//}
