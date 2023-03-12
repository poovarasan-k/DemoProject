package loginTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectUserName {
	@Parameters({"userName","password"})
	@Test 
	 
	public void loginwithCorrectUser(String userName, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(4000);
	  WebElement userNames=driver.findElement(By.xpath("//input[@name='username']"));
	  userNames.sendKeys(userName);
	  
	  WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
	  passWord.sendKeys(password);
	  
	  WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));
	  submitButton.click();
	  driver.quit();
	}
}
