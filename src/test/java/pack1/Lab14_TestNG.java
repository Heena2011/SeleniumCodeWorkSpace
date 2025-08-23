package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab14_TestNG {

	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;

	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Before method");
		  WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("After method");
		  driver.quit();
	  }
	 
	 

	  @DataProvider(name = "dp")
	  public Object[][] dp() throws IOException {
	      String projectpath = System.getProperty("user.dir");
	      File file = new File(projectpath + "\\data.xlsx");
	      FileInputStream fs = new FileInputStream(file);
	      XSSFWorkbook workbook = new XSSFWorkbook(fs);
	      XSSFSheet worksheet = workbook.getSheetAt(0);

	      int rowcount = worksheet.getPhysicalNumberOfRows();   // total rows
	      int colcount = worksheet.getRow(0).getLastCellNum();  // total cols

	      String[][] data = new String[rowcount - 1][colcount];  // exclude header

	      for (int i = 1; i < rowcount; i++) {
	          for (int j = 0; j < colcount; j++) {
	              data[i - 1][j] = worksheet.getRow(i).getCell(j).toString();
	          }
	      }

	      workbook.close();
	      fs.close();
	      return data;
	  }
	  @Test(dataProvider = "dp")
	  public void f(String username, String password, String email, String role, String city, String mobile) 
	          throws InterruptedException, IOException {
	      
	      String title = driver.getTitle();
	      System.out.println("The Title is:" + title);

	      ExtentReports extent = new ExtentReports();
	      String reportpath = projectpath + "\\Augreport.html";
	      ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
	      extent.attachReporter(spark);
	      ExtentTest test = extent.createTest("Verify the title of the page");
	      Thread.sleep(3000);

	      if (title.equals("OrangeHRM")) {
	          test.pass("title is matched");
	      } else {
	          test.fail("title is not matched");
	      }

	      File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      String dest = projectpath + "\\screenshot1.png";
	      File detfile = new File(dest);
	      FileUtils.copyFile(scr, detfile);
	      test.addScreenCaptureFromPath(dest);

	      extent.flush();
	      Thread.sleep(3000);

	      login_pageobjects obj = new login_pageobjects(driver);
	      obj.enterusername(username);
	      obj.enterpassword(password);
	      obj.clickonlogin();

	      // 🔹 Print extra values from Excel
	      System.out.println("Email=" + email + ", Role=" + role + 
	                         ", City=" + city + ", Mobile=" + mobile);
	  }
}
