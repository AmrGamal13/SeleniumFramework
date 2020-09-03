package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	WebDriver driver;

	@FindBy(id="FullName")
	WebElement YourNametxtbox;

	@FindBy(id="Email")
	WebElement YourEmailtxtbox;

	@FindBy(id="Enquiry")
	WebElement Enquirytxtbox;

	@FindBy(name="send-email")
	WebElement SubmitBtn;

	@FindBy(css="div.result")
	public WebElement successmessage;

	public ContactUsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void performcontactus(String fullname, String email, String Enquiry) {

		YourNametxtbox.sendKeys(fullname);
		YourEmailtxtbox.sendKeys(email);
		Enquirytxtbox.sendKeys(Enquiry);
		SubmitBtn.click();
	}
}
