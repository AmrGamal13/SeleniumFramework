package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.UserRegisterationPageNew;

public class UserRegisterationTestDDTandDataProvider extends TestBase {
	
	
	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;
	
//data provider for test data that i will use in my test case
	@DataProvider(name="TestData")
	public static Object[][] userData()
	{
		return new Object[][]{
			{"Adel","Gamal","teststest@test.com","123451234" },
			{"Ahmed","Ali","testssww@test.com", "1234567891234"}
		};
	}
	
	//will make parameters for the data that we stored in the previous method
  @Test(dataProvider="TestData")
  public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password) {
	  homepageobject = new HomePageNew(driver);
		userRegistnewObject = new UserRegisterationPageNew(driver);
		homepageobject.clickonRegisterlnk();
		//will enter the data from the paramter that we used in the method
		userRegistnewObject.register(fname, lname, password, email);
		Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
		userRegistnewObject.logout();
		homepageobject.clickonlogin();
		loginpageobject = new LoginPage(driver);
		//will enter the data from the paramter that we used in the method
		loginpageobject.login(email, password);
		//verify that log out link appeared after login in
		Assert.assertTrue(userRegistnewObject.logoutlnk.isDisplayed());
		userRegistnewObject.logout();
		
		
  }
}
