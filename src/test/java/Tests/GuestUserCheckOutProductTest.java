package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckOutPage;
import Pages.HomePageNew;
import Pages.OrderDetailsPage;
import Pages.ProductDetailsPage;
import Pages.ShoppingCartPage;

public class GuestUserCheckOutProductTest extends TestBase {
  
	HomePageNew homepageobject;
	ProductDetailsPage productdetailsobj;
	ShoppingCartPage shoppingcartobj;
	CheckOutPage checkoutobj;
	OrderDetailsPage orderdetailsobj;
	
	@Test(priority=1)
	public void UserCanSearchUsingAutoComplete() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		homepageobject.ProductsearchusingAutoCom("Mac");
		productdetailsobj = new ProductDetailsPage(driver);
		Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
	}
	
	@Test(priority=2)
	  public void UserCanUseAddShoppingCart() throws InterruptedException {
			productdetailsobj.ClickOnAddtoCart();
			shoppingcartobj = new ShoppingCartPage(driver);
			shoppingcartobj.UpdateShoppingCart("2");
			Assert.assertTrue(shoppingcartobj.TotalLabel.getText().contains("$3,600.00"));
			
	  }
	
	@Test(priority=3)
  public void UserCanCheckOutProduct() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
		shoppingcartobj.OpenCheckOutPage();
		checkoutobj = new CheckOutPage(driver);
		checkoutobj.GuestUserCheckOutProduct("Adel", "Mohamed", "abc@abc.com", "United States minor outlying islands", "NYC", "abc", "12345222", "123312122", "123312122");
		Assert.assertTrue(checkoutobj.ProductNameLink.getText().contains("Apple MacBook Pro 13-inch"));
		checkoutobj.NavigateToconfirmationOfTheOrder();
		Assert.assertTrue(checkoutobj.OrderSuccessfulMessLabl.isDisplayed());
		Assert.assertTrue(checkoutobj.OrderDetailsLink.isDisplayed());
  }
	
	@Test(priority=4)
	public void UserCanViewOrderDetailsOfTheProduct() throws InterruptedException
	{
		checkoutobj.NavigateToOrderPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderdetailsobj= new OrderDetailsPage(driver);
		orderdetailsobj.ViewOrderInfo();
	}
}
