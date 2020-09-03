package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchPageResults;
import Pages.ShoppingCartPage;
import Pages.UserRegisterationPageNew;
import Pages.WishListPage;

public class AddProductToShoppingCartTest extends TestBase {
	/*
	 * 1-Search for the first product
	 * 2-Add to shoping cart
	 * 3-Update Shopping Cart compare list
	 * 4-Remove Shopping cart
	 */
	HomePageNew homepageobject;
	ProductDetailsPage productdetailsobj;
	ShoppingCartPage shoppingcartobj;
	
	@Test(priority=1)
	public void UserCanSearchUsingAutoComplete() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		homepageobject.ProductsearchusingAutoCom("Mac");
		productdetailsobj = new ProductDetailsPage(driver);
		Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
	}
	
	@Test(dependsOnMethods={"UserCanSearchUsingAutoComplete"})
  public void UserCanUseAddShoppingCart() throws InterruptedException {
		productdetailsobj.ClickOnAddtoCart();
		shoppingcartobj = new ShoppingCartPage(driver);
		shoppingcartobj.UpdateShoppingCart("2");
		Assert.assertTrue(shoppingcartobj.TotalLabel.getText().contains("$3,600.00"));
  }
	
	@Test(dependsOnMethods={"UserCanUseAddShoppingCart"})
	public void UserCanRemovefromShoppingCart()
	{
		shoppingcartobj.Removefromshoppingcart();
		Assert.assertTrue(shoppingcartobj.MessageConfirmation.getText().contains("Your Shopping Cart is empty!"));
	}
}
