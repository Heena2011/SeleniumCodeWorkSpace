package pack1;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab15_CSVFile {
	WebDriver driver;
	 String projectpath=System.getProperty("user.dir");
 @Test(dataProvider = "dp")
 public void f(String firstname, String lastname,String email,String telephone,String password,String confirm) {
	  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	  driver.findElement(By.linkText("Register")).click();
	  driver.findElement(By.name("firstname")).sendKeys(firstname);
	  driver.findElement(By.name("lastname")).sendKeys(lastname);
	  driver.findElement(By.name("email")).sendKeys(email);
	  driver.findElement(By.name("telephone")).sendKeys(telephone);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("confirm")).sendKeys(confirm);
	 driver.findElement(By.name("newsletter")).click();
	 driver.findElement(By.name("agree")).click();
	 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	  
 }
 @BeforeMethod
 public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://tutorialsninja.com/demo/index.php");
 }

 @AfterMethod
 public void afterMethod() {
 }


 @DataProvider
 public Object[][] dp() throws IOException, CsvException {
	  String[][] data1=new String[2][6];
	  /*  
	  String projectpath=System.getProperty("user.dir")  ;
	  File file1=new File(projectpath+"\\data.xlsx");
	  FileInputStream fs=new FileInputStream(file1);
	  XSSFWorkbook workbook=new XSSFWorkbook(fs);
	  XSSFSheet worksheet=workbook.getSheetAt(0);
	  int rowcount=worksheet.getPhysicalNumberOfRows();
	  System.out.println("rows:"+rowcount);
	  */
	  String csvFile = projectpath+"\\UserDetails.csv";  // Path to your CSV file
	        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
	        List<String[]> data = csvReader.readAll(); // Read all rows
	   
	        // Iterate over CSV data (skipping header)
	        for (int i = 0; i < data.size(); i++) {  // Start from 1 to skip header
	            data1[i][0] = data.get(i)[0];  // Get username from the CSV
	            data1[i][1] = data.get(i)[1];  // Get password from the CSV
	            data1[i][2] = data.get(i)[2];  // Get username from the CSV
	            data1[i][3] = data.get(i)[3];  // Get password from the CSV
	            data1[i][4] = data.get(i)[4];  // Get username from the CSV
	            data1[i][5] = data.get(i)[5];  // Get password from the CSV
	          
	   
	        }
	   
	  return data1;
 }
 @BeforeClass
 public void beforeClass() {
 }

 @AfterClass
 public void afterClass() {
 }

 @BeforeTest
 public void beforeTest() {
 }

 @AfterTest
 public void afterTest() {
 }

 @BeforeSuite
 public void beforeSuite() {
 }

 @AfterSuite
 public void afterSuite() {
 }

}
