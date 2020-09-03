package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.UserRegisterationPageNew;
import data.ExcelReader;

public class UserRegisterationParallelTest extends TestBaseGrid {

	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;
	
//data provider for get the data from the excel sheet from ExcelReader class
	@DataProvider(name="ExcelData")
	public static Object[][] userRegisterData() throws IOException
	{
		//object from the excel reader to access and get the method of reading the data excel sheet
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
	}
	//the parameters should be in the order of the columns in the excel sheet
	//will make parameters for the data that we stored in the previous method
  @Test(dataProvider="ExcelData")
  public void UserCanRegisterSuccessfully(String firstname, String lastname, String email, String password ) {
	  homepageobject = new HomePageNew(getDriver());
		userRegistnewObject = new UserRegisterationPageNew(getDriver());
		homepageobject.clickonRegisterlnk();
		//will enter the data from the parameter that we used in the method
		userRegistnewObject.register(firstname, lastname, email, password);
		Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
		userRegistnewObject.logout();
		homepageobject.clickonlogin();
		loginpageobject = new LoginPage(getDriver());
		//will enter the data from the parameter that we used in the method
		loginpageobject.login(email, password);
		//verify that log out link appeared after login in
		Assert.assertTrue(userRegistnewObject.logoutlnk.isDisplayed());
		userRegistnewObject.logout();
		
		
  }
}
