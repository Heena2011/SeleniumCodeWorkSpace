package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC014_TestNG {

	
	 WebDriver driver;
	    String projectpath = System.getProperty("user.dir");
	   // File file1 = new File(projectpath + "\\data.xlsx");

	    @Test(dataProvider = "dp")
	    public void f(String firstname, String lastname, String email_id, String phnnumber, String password, String confirmpassword) throws InterruptedException {
	        Thread.sleep(3000);
	        String title = driver.getTitle();
	        System.out.println("Title:" + title);

	        if (title.equals("Your Store")) {
	            System.out.println("title is matched");
	        } else {
	            System.out.println("title is not matched");
	        }

	        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	        driver.findElement(By.linkText("Register")).click();

	        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
	        if (text.getText().equals("Register Account")) {
	            System.out.println("Text is matched");
	        } else {
	            System.out.println("text is mismatched");
	        }

	        // Enter all the details from Excel
	        driver.findElement(By.name("firstname")).sendKeys(firstname);
	        driver.findElement(By.name("lastname")).sendKeys(lastname);
	        driver.findElement(By.name("email")).sendKeys(email_id);
	        driver.findElement(By.name("telephone")).sendKeys(phnnumber);
	        driver.findElement(By.name("password")).sendKeys(password);
	        driver.findElement(By.name("confirm")).sendKeys(confirmpassword);

	        // Click on checkbox of newsLetter
	        driver.findElement(By.name("newsletter")).click();

	        // Select “I have read and agree to the Privacy Policy” check box
	        driver.findElement(By.name("agree")).click();

	        // click on continue
	        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://tutorialsninja.com/demo/index.php");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        driver.quit();
	    }

	    @DataProvider
	    public Object[][] dp() throws IOException {
	    	String projectpath = System.getProperty("user.dir");
	        File file = new File(projectpath + "\\data.xlsx"); 
	        FileInputStream fs = new FileInputStream(file);
	        XSSFWorkbook workbook = new XSSFWorkbook(fs);
	        XSSFSheet worksheet = workbook.getSheetAt(0);

	        int rowcount = worksheet.getPhysicalNumberOfRows();   // total rows including header
	        int colcount = worksheet.getRow(0).getLastCellNum();  // number of columns

	        System.out.println("Rows: " + rowcount + " Columns: " + colcount);

	        // skip header row → so rowcount-1
	        String[][] data = new String[rowcount - 1][colcount];

	        for (int i = 1; i < rowcount; i++) {   // start from row 1
	            for (int j = 0; j < colcount; j++) {
	                if (worksheet.getRow(i).getCell(j) != null) {
	                    data[i - 1][j] = worksheet.getRow(i).getCell(j).toString();
	                } else {
	                    data[i - 1][j] = ""; // replace null with empty string
	                }
	            }
	        }

	        workbook.close();
	        fs.close();
	        return data;
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before class");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("After Class");
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
//	    @Parameters("browser")
//	    @Test
//	    public void test2(@Optional("chrome") String browser) {
//	        WebDriver driver = null;
//
//	        if (browser.equalsIgnoreCase("chrome")) {
//	            System.out.println("This is Chrome test");
//	            WebDriverManager.chromedriver().setup();
//	            driver = new ChromeDriver();
//
//	        } else if (browser.equalsIgnoreCase("edge")) {
//	            System.out.println("This is Edge test");
//	            WebDriverManager.edgedriver().setup();
//	            driver = new EdgeDriver();
//	        }
//
//	        // common code
//	        if (driver != null) {
//	            driver.get("https://www.flipkart.com/");
//	            driver.manage().window().maximize();
//	        }
//	    }
//	}


//	@Parameters("browser")
//	@Test
//	public void test2(String browser) {
//		
//		if ( browser.equalsIgnoreCase("chrome")) {
//			System.out.println("This is chrometest");
//			WebDriverManager.chromedriver().setup();
//			WebDriver driver = new ChromeDriver();
//			driver.get("https://www.flipkart.com/");
////		} else if (browser.equalsIgnoreCase("firefox")) {
////			System.out.println("This is firefoxtest");
////			WebDriverManager.firefoxdriver().setup();
////			WebDriver driver = new FirefoxDriver();
////			driver.get("https://www.flipkart.com/");
//		} else if (browser.equalsIgnoreCase("edge")) {
//			System.out.println("This is edgetest");
//			WebDriverManager.edgedriver().setup();
//			WebDriver driver = new EdgeDriver();
//			driver.get("https://www.flipkart.com/");
//		}
//
//	}
//}
