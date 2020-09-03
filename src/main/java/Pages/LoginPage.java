package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id="Email")
	WebElement email_login_txtbox;

	@FindBy(id="Password")
	WebElement pass_login_txtbox;

	@FindBy(css="input.button-1.login-button")
	WebElement loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String email, String password) {

		email_login_txtbox.sendKeys(email);
		pass_login_txtbox.sendKeys(password);
		loginbtn.click();
	}
	//asasd 
}
