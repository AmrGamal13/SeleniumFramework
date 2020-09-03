package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	@FindBy(linkText="Change password")
	WebElement Changepaswordlink;

	@FindBy(id="OldPassword")
	WebElement oldpasswordtxtbox;

	@FindBy(id="NewPassword")
	WebElement newpasswordtxtbox;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmpasswdtxtbox;

	@FindBy(css="input.button-1.change-password-button")
	WebElement changepasswbtn;

	@FindBy(css="div.result")
	public WebElement passwordmesslabel;

	public MyAccountPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void OpenChangepasswordPage()
	{
		Changepaswordlink.click();
	}
	
	public void ChangePasswrd(String oldpassword, String newpass) 
	{
		oldpasswordtxtbox.sendKeys(oldpassword);
		newpasswordtxtbox.sendKeys(newpass);
		confirmpasswdtxtbox.sendKeys(newpass);
		changepasswbtn.click();
	}
	
}
