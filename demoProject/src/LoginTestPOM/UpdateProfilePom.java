package LoginTestPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProfilePom {

	//that one for no find be annotation is not used method
	@FindBy(id="inputEmail")
	public static WebElement inputEmail;
	@FindBy(id="inputPassword")
	public static WebElement inputPassword;
	@FindBy(id="login")
	public static WebElement login;
}
