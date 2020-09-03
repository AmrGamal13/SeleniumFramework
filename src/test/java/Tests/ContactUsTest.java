package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePageNew;

public class ContactUsTest extends TestBase {

	HomePageNew homepageobject;
	ContactUsPage contactusobj;

	@Test
	public void UserCanUseContactUs() {
		homepageobject = new HomePageNew(driver);
		contactusobj = new ContactUsPage(driver);
		// scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,5000)");
		homepageobject.OpenContactUs();
		contactusobj.performcontactus("Adel", "adgamal@eg.ibm.com", "I have an inquiry");
		// verifying the success message appears
		Assert.assertTrue(contactusobj.successmessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}
}
