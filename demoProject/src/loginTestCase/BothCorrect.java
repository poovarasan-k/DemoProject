package loginTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	@Parameters({"userName","password"})
	@Test 
	 
	public void loginwithBothCorrect(String userName, String passWord) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(4000);
	  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys(userName);
	  
	  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys(passWord);
	  
	  WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));
	  submitButton.click();
	  
	  //driver.quit();
	}
}
