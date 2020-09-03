package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;
	
	@FindBy(name="removefromcart")
	WebElement RemoveCheckbox;
	
	@FindBy(name="updatecart")
	WebElement updateshoppingcartBtn;
	
	@FindBy(css="span.product-subtotal")
	public WebElement TotalLabel;
	
	@FindBy(css="input.qty-input")
	WebElement QuantityTextBox;
	
	@FindBy(css="div.no-data")
	public WebElement MessageConfirmation;
	
	@FindBy(id="checkout")
	WebElement CheckOutBtn;
	
	@FindBy(id="termsofservice")
	WebElement TermsOfServicescheckbox;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement ContinAsGuestBtn;
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Removefromshoppingcart()
	{
		RemoveCheckbox.click();
		updateshoppingcartBtn.click();
	}
	
	public void UpdateShoppingCart(String quantity) {
		QuantityTextBox.clear();
		QuantityTextBox.sendKeys(quantity);
		updateshoppingcartBtn.click();
	}
	
	public void OpenCheckOutPage() throws InterruptedException {
		TermsOfServicescheckbox.click();
		CheckOutBtn.click();
		Thread.sleep(2000);
		ContinAsGuestBtn.click();
	}
}
