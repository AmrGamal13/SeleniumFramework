package Stepdefinitions;

import org.testng.Assert;

import Pages.HomePageNew;
import Pages.UserRegisterationPageNew;
import Tests.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegisteration extends TestBase {

	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	
	@Given("^the user is on the home page$")
	public void the_user_is_on_the_home_page() throws Throwable {
		homepageobject = new HomePageNew(driver);
		userRegistnewObject = new UserRegisterationPageNew(driver);
	}

	@When("^I click on the register link$")
	public void i_click_on_the_register_link() throws Throwable {
		homepageobject.clickonRegisterlnk();
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));

	}
	
	/*@When("^I entered the user Data$")
	public void i_entered_the_user_Data() throws Throwable {
		userRegistnewObject.register("Adel", "Gamal", "hnm@hmn.com", "123456788");
	}*/
	
	@When("^I entered \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) throws Throwable {
		userRegistnewObject.register(firstname, lastname, email, password);
	}



	@Then("^the registeration page displays successfully$")
	public void the_registeration_page_displays_successfully() throws Throwable {
		Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
		userRegistnewObject.logout();
	}

}
