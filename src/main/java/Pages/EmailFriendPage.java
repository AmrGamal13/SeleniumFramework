package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailFriendPage {

	WebDriver driver;

	@FindBy(id="FriendEmail")
	WebElement FriendsEmailTxtbox;

	@FindBy(id="PersonalMessage")
	WebElement PersonalMessageTxtbox;

	@FindBy(name="send-email")
	WebElement SendEmailBtn;

	@FindBy(css="div.result")
	public WebElement MessagNotification;

	public EmailFriendPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void PerformEmailFriend(String friendemail, String personalmessage) {
		FriendsEmailTxtbox.sendKeys(friendemail);
		PersonalMessageTxtbox.sendKeys(personalmessage);
		SendEmailBtn.click();
	}
}
