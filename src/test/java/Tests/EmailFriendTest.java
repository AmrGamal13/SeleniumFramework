package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchPageResults;
import Pages.UserRegisterationPageNew;

public class EmailFriendTest extends TestBase{
	
	//1-user registeration
	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;
	SearchPageResults searchpageobj;
	ProductDetailsPage productdetailsobj;
	EmailFriendPage Emailfriendobj;

	@Test(priority = 1, alwaysRun=true)
	public void RegisterationHappyPath() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		userRegistnewObject = new UserRegisterationPageNew(driver);
		//click on register link on homepage
		homepageobject.clickonRegisterlnk();
		//fill all the fields in registration page
		userRegistnewObject.register("Adel", "Gamal", "12345678n", "adelmoomotm@gm.com");
		//verifying that the successful message appear successfully
		Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
	}
	
	//2-Search for the product
	@Test(priority=2)
	  public void UserCanSearchUsingAutoComplete() throws InterruptedException {
		  homepageobject = new HomePageNew(driver);
		  homepageobject.ProductsearchusingAutoCom("Mac");
		  //searchpageobj = new SearchPageResults(driver);
		  //searchpageobj.ClickOnproducttitle();
		  productdetailsobj = new ProductDetailsPage(driver);
		  Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
	  }
	
  @Test(priority= 3)
  public void RegisteredUserCanEmailProductToaFriend() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("scrollBy(0,500)");
	  productdetailsobj.OpenEmailFriend();
	  Emailfriendobj = new EmailFriendPage(driver);
	  Emailfriendobj.PerformEmailFriend("adgamal@eg.ibm.com", "HelloFriend");
	  Assert.assertTrue(Emailfriendobj.MessagNotification.getText().contains("Your message has been sent."));
  }
  
  //4-logout
  @Test(priority=4)
	public void UserCanLogout()
	{
		userRegistnewObject.logout();
	}
}
