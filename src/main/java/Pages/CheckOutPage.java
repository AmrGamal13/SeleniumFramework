package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

	WebDriver driver;

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement Firstnametextbox;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement Lastnametextbox;

	@FindBy(id="BillingNewAddress_Email")
	WebElement Emailntextbox;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement SelectCountry;

	@FindBy(id="BillingNewAddress_City")
	WebElement CityTextBox;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement AddressTextBox;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement ZipCodeTextBox;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement PhoneTextBox;

	@FindBy(id="BillingNewAddress_FaxNumber")
	WebElement FaxNuTextBox;

	@FindBy(xpath="//div[@id='billing-buttons-container']/input[@title='Continue']")
	WebElement ContinueAftBillBtn;
	               
	@FindBy(xpath="//div[@id='shipping-buttons-container']/input[@title='Continue']")
	WebElement ContAftShippAddBtn;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']/input[@value='Continue']")
	WebElement ContAfterPaymMethBtn;

	@FindBy(xpath="//div[@id='payment-info-buttons-container']/input[@value='Continue']")
	WebElement ContAfterPayInfoBtn;

	@FindBy(css="a.product-name")
	public WebElement ProductNameLink;

	@FindBy(xpath="//div[@id='confirm-order-buttons-container']/input[@value='Confirm']")
	WebElement ContAfterConfOrdBtn;

	@FindBy(linkText="Click here for order details.")
	public WebElement OrderDetailsLink;

	@FindBy(xpath="/html/body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='master-column-wrapper']"
			+ "//strong[.='Your order has been successfully processed!']")
	public WebElement OrderSuccessfulMessLabl;
	
	@FindBy(xpath="/html/body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='master-column-wrapper']//input[@value='Continue']")
	WebElement ContAfterThankyouBtn;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void GuestUserCheckOutProduct(String firstname, String lastname, String email, String country, String city, String address, String zipcode,String phone, String faxnumber) throws InterruptedException
	{
		Firstnametextbox.sendKeys(firstname);
		Lastnametextbox.sendKeys(lastname);
		Emailntextbox.sendKeys(email);
		Select sl = new Select(SelectCountry);
		sl.selectByVisibleText(country);
		CityTextBox.sendKeys(city);
		AddressTextBox.sendKeys(address);
		ZipCodeTextBox.sendKeys(zipcode);
		PhoneTextBox.sendKeys(phone);
		FaxNuTextBox.sendKeys(faxnumber);
		ContinueAftBillBtn.click();
		//ContAftShippAddBtn.click();
		Thread.sleep(2000);
		ContAfterPaymMethBtn.click();
		ContAfterPayInfoBtn.click();
	}
	
	public void NavigateToconfirmationOfTheOrder() {
		ContAfterConfOrdBtn.click();
	}
	
	public void NavigateToOrderPage()
	{
		OrderDetailsLink.click();
	}
	
}
