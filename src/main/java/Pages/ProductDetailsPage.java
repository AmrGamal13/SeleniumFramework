package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	WebDriver driver;

	@FindBy(css="strong.current-item")
	public WebElement ProductNameBreadCrumb;
	
	@FindBy(xpath="//*[@id='product-details-form']//div//div[1]//div[2]//div[10]//div[3]//input")
	WebElement EmailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement ProductPriceLabel;
	
	@FindBy(linkText="Add your review")
	WebElement AddReviewLnk;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement AddToWishListBtn;
	
	@FindBy(linkText="wishlist")
	WebElement WishListLink;
	
	@FindBy(xpath= "/html//form[@id='product-details-form']/div//div[@class='compare-products']/input[@value='Add to compare list']")
	WebElement AddToCompareListBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	@FindBy(xpath="//div[@id='bar-notification']//a[@href='/cart']")
	WebElement ShoppingCartLnk;

	public ProductDetailsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void OpenEmailFriend() {
		EmailFriendBtn.click();
	}
	
	public void OpenAddReview() {
		AddReviewLnk.click();
	}
	
	public void OpenWishListButton() {
		AddToWishListBtn.click();
	}
	
	public void ClickOnWishLstLnk() {
		WishListLink.click();
	}
	
	public void CLickOnCompListPage() {
		AddToCompareListBtn.click();
	}
	
	public void ClickOnAddtoCart() throws InterruptedException {
		AddToCartBtn.click();
		Thread.sleep(2000);
		ShoppingCartLnk.click();
	}
}
