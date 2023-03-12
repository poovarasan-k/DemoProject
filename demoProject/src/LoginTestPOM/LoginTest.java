package LoginTestPOM;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTest {
	WebDriver driver;
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
		//Sheet sheet1=workbook.getSheet(0);
		Sheet sheet2=workbook.getSheet(1);
		
		//int Rows1=sheet1.getRows();
		//int columns1=sheet1.getColumns();
		
		int Rows2=sheet2.getRows();
		int columns2=sheet2.getColumns();
	
		//get the value so create the two dimensional array
		String testData[][]=new String[Rows2-1][columns2];// give the row and column count, header row is not needed so remove that use -1
		
		//itration so use for loop
		for(int i=1;i<Rows2;i++) {
			for(int j=0;j<columns2;j++) {
			testData[i-1][j]=	sheet2.getCell(j, i).getContents();
			}
		}
		return testData;
		
	}
	
	
	
	
	
	@DataProvider(name = "loginData")
	public String[][] dataProvider() throws BiffException, IOException {
		String[][]	data=getDataFromxl();
		return data;
	}

	@Test (dataProvider ="loginData")
	public void loginScenario(String userNmae, String password) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		 WebDriver driver =new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  Thread.sleep(4000);
		  PageFactory.initElements(driver, LoginPom.class);
		  LoginPom.username.sendKeys(userNmae);
		  LoginPom.password.sendKeys(password);
		  LoginPom.loginbutton.click();
		  
	}
}
