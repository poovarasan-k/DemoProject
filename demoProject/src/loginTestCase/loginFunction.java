package loginTestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class loginFunction {
	  WebDriver driver;
	//String [][] data= null;
//		
//		{
//			{"Admin","admin123"},
//			{"Admin1","admin123"},
//			{"Admin","admin123r"},
//			{"Adminf","admin123f"}
//	};
	@BeforeTest
	public void beforeSuit() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		   driver =new ChromeDriver();
	}
	@AfterTest
public void afterSuit() {
		driver.quit();
	}
	
	public String[][] getDataFromxl() throws BiffException, IOException {
		FileInputStream excel=new FileInputStream("D:\\Document\\TesData.xls");
	
		Workbook workbook=Workbook.getWorkbook(excel);
		
		//Sheet sheet=workbook.getSheet("sheet1");
		Sheet sheet=workbook.getSheet(0);
		
		int Rows=sheet.getRows();
		int columns=sheet.getColumns();
		
	
		//get the value so create the two dimensional array
		String testData[][]=new String[Rows-1][columns];// give the row and column count, header row is not needed so remove that use -1
		
		//itration so use for loop
		for(int i=1;i<Rows;i++) {
			for(int j=0;j<columns;j++) {
			testData[i-1][j]=	sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}
	
	
	
	
	
	@DataProvider(name = "loginData")
	public String[][] dataProvider() throws BiffException, IOException {
		String[][]	data=getDataFromxl();
		return data;
	}
      @Test(dataProvider = "loginData")
	public void loginFubnction(String userNmae, String password) throws InterruptedException {
		
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(4000);
	  WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
	  userName.sendKeys(userNmae);
	  
	  WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
	  passWord.sendKeys(password);
	  
	  WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));
	  submitButton.click();
	 
	}
}
