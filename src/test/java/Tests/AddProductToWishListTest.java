package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddProductReviewPage;
import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchPageResults;
import Pages.UserRegisterationPageNew;
import Pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;
	SearchPageResults searchpageobj;
	ProductDetailsPage productdetailsobj;
	WishListPage wishlistobj;
	//search for the product
	@Test(priority=1)
	public void UserCanSearchUsingAutoComplete() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		homepageobject.ProductsearchusingAutoCom("Mac");
		productdetailsobj = new ProductDetailsPage(driver);
		Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
	}

	//click on add to the wishlist & do assertion to make sure we are on the wishlist page and item is displayed
	@Test(priority= 2)
	public void UserCanAddProductToWishList() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
		productdetailsobj = new ProductDetailsPage(driver);
		productdetailsobj.OpenWishListButton();
		productdetailsobj.ClickOnWishLstLnk();
		wishlistobj = new WishListPage(driver);
		Assert.assertTrue(wishlistobj.WishListHeader.isDisplayed());
		Assert.assertTrue(wishlistobj.ProductCell.getText().contains("Apple MacBook Pro 13-inch"));
	}

	//remove item from the wishlist and verify wishlist is empty
	@Test (priority=3)
	public void UserCanRemoveFromWishList()
	{		
		wishlistobj = new WishListPage(driver);
	    wishlistobj.RemoveFromWishLst();
	    Assert.assertTrue(wishlistobj.MessageAftRemov.getText().contains("The wishlist is empty!"));

	}

}
