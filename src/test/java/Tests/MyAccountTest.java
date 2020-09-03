package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPageNew;

public class MyAccountTest extends TestBase{

	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;
	MyAccountPage myaccountpageobj;

	@Test(priority = 1, alwaysRun=true)
	public void RegisterationHappyPath() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		userRegistnewObject = new UserRegisterationPageNew(driver);
		//click on register link on homepage
		homepageobject.clickonRegisterlnk();
		//fill all the fields in registration page
		userRegistnewObject.register("Adel", "Gamal", "123456788", "adelgamalmo@gm.com");
		//verifying that the successful message appear successfully
		Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
	}

	@Test(priority=2)
	public void UserCanChangePassword() throws InterruptedException {
		myaccountpageobj = new MyAccountPage(driver);
		userRegistnewObject.openmyaccountpage();
		myaccountpageobj.OpenChangepasswordPage();
		Thread.sleep(3000);
		myaccountpageobj.ChangePasswrd("123456788", "12345678");
		Assert.assertTrue(myaccountpageobj.passwordmesslabel.getText().contains("Password was changed"));

	}
	@Test(priority=3)
	public void UserCanLogout()
	{
		userRegistnewObject.logout();
	}

	@Test(priority=4)
	public void UserCanLogin() throws InterruptedException
	{
		homepageobject.clickonlogin();
		loginpageobject = new LoginPage(driver);
		Thread.sleep(3000);
		loginpageobject.login("adelgamalmo@gm.com", "12345678");
		//verify that log out link appeared after login in
		Assert.assertTrue(userRegistnewObject.logoutlnk.isDisplayed());
	}
}
