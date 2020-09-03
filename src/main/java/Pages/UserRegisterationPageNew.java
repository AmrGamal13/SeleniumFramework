package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegisterationPageNew {

	WebDriver driver;
	
	@FindBy(id="gender-male")
	WebElement genderchkbox;
	
	@FindBy(id="FirstName")
	WebElement firstnametxtbox;
	
	@FindBy(id="LastName")
	WebElement lastnametxtbox;

	@FindBy(id="Email")
	WebElement emailtxtbox;
	
	@FindBy(id="Password")
	WebElement passwordtxtbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement conpasstxtbox;
	
	@FindBy(id="register-button")
	WebElement registerbtn;
	
	@FindBy(css="div.result")
	public WebElement registerationsuccmessage;
	
	@FindBy (linkText="Log out")
	public WebElement logoutlnk;
	
	@FindBy (linkText="My account")
	public WebElement Myaccountlink;
	
	public UserRegisterationPageNew(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register(String firstname, String lastname , String email, String password) {
		genderchkbox.click();
		firstnametxtbox.sendKeys(firstname);
		lastnametxtbox.sendKeys(lastname);
		emailtxtbox.sendKeys(email);
		passwordtxtbox.sendKeys(password);
		conpasstxtbox.sendKeys(password);
		registerbtn.click();
	}
	
	public void logout()
	{
		logoutlnk.click();
	}
	
	public void openmyaccountpage() {
		Myaccountlink.click();
	}
}
