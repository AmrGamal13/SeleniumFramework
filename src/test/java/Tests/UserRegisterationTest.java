package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.UserRegisterationPageNew;

public class UserRegisterationTest extends TestBase {
	//take objects from the page object models classes for taking the elements
	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;

	@Test(priority = 1, alwaysRun=true)
	public void RegisterationHappyPath() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		userRegistnewObject = new UserRegisterationPageNew(driver);
		//click on register link on homepage
		homepageobject.clickonRegisterlnk();
		//fill all the fields in registration page
		userRegistnewObject.register("Adel", "Gamal", "12345678n", "adel223@gm.com");
		//verifying that the successful message appear successfully
		Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"RegisterationHappyPath"})
	public void UserCanLogout()
	{
		userRegistnewObject.logout();
	}
	
	@Test(dependsOnMethods= {"UserCanLogout"})
	public void UserCanLogin()
	{
		homepageobject.clickonlogin();
		loginpageobject = new LoginPage(driver);
		loginpageobject.login("adel223@gm.com", "12345678n");
		//verify that log out link appeared after login in
		Assert.assertTrue(userRegistnewObject.logoutlnk.isDisplayed());
	}
	
}
