package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

	WebDriver driver;
	
	@FindBy(css="h1")
	public WebElement WishListHeader;
	
	@FindBy(css="a.product-name")
	public WebElement ProductCell;
	
	@FindBy(name="updatecart")
	WebElement UpdateWishlistBtn;
	
	@FindBy(name="removefromcart")
	WebElement RemovefromCartChckBox;
	
	@FindBy(css="div.no-data")
	public WebElement MessageAftRemov;
	
	public WishListPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void RemoveFromWishLst() {
		RemovefromCartChckBox.click();
		UpdateWishlistBtn.click();
	}
}
