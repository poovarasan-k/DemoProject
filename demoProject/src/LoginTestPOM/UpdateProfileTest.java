package LoginTestPOM;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class UpdateProfileTest {
	
	WebDriver driver;
	@BeforeTest
	public void beforeSuit() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		   driver =new ChromeDriver();
	}

	
	public String [][] getDataFromXls() throws BiffException, IOException {
		
		FileInputStream excel=new FileInputStream("D:\\Document\\TesData.xls");
		
		Workbook workbook=Workbook.getWorkbook(excel);
		
		Sheet sheet2=workbook.getSheet(1);
		
		int rows=sheet2.getRows();
		int columns=sheet2.getColumns();
		System.out.println("row2colum:"+rows+","+columns);
		
		String testData[][]=new String[rows-1][columns];
		System.out.println("data;"+testData);
		for(int i=1;i<rows;i++) {
		for(int j=0;j<columns;j++) {
			//testData[i-1][j]=sheet2.getCell(j, i).getContents();
			testData[i-1][j]=	sheet2.getCell(j, i).getContents();
			
		}
	}
		return testData;
		
	}
	
	
	@DataProvider(name="loginData")
	public String[][] dataProvider() throws BiffException, IOException {
		String [][] data=getDataFromXls();
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void updateprofile(String email,String password) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver =new ChromeDriver();
		  driver.get("https://phptravels.org/login");
		  
		 PageFactory.initElements(driver, UpdateProfilePom.class);
		  
		 UpdateProfilePom.inputEmail.sendKeys(email);
		 UpdateProfilePom.inputPassword.sendKeys(password);
		 UpdateProfilePom.login.click();
		  System.out.println(email);
	}
}
