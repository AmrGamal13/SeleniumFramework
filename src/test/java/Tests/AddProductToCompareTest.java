package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddProuctToComparePage;
import Pages.HomePageNew;
import Pages.ProductDetailsPage;

public class AddProductToCompareTest extends TestBase {
 
	/*
	 * 1-Search for the first product
	 * 2-search for the second product
	 * 3-Add to compare
	 * 4-clear compare list
	 */
	
	AddProuctToComparePage addproductcompobj;
	HomePageNew homepageobject;
	ProductDetailsPage productdetailsobj;
	
	@Test(priority=1)
	public void UserCanCompareProduct() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		productdetailsobj = new ProductDetailsPage(driver);
		homepageobject.ProductsearchusingAutoCom("Mac");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
		productdetailsobj.CLickOnCompListPage();
		homepageobject.ProductsearchusingAutoCom("Asus");
		js.executeScript("scrollBy(0,500)");
		productdetailsobj.CLickOnCompListPage();
		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
		addproductcompobj = new AddProuctToComparePage(driver);
		Assert.assertTrue(addproductcompobj.AsusProduct.getText().contains("Asus N551JK-X"));
		Assert.assertTrue(addproductcompobj.AppleProduct.getText().contains("Apple MacBook Pro 13-inch"));
		addproductcompobj.CompareList();		
	}
	
	
	@Test(priority=2)
  public void UserCanClearComparelist() {
		addproductcompobj = new AddProuctToComparePage(driver);
		addproductcompobj.ClearComparelist();
		Assert.assertTrue(addproductcompobj.NoDataLabelmessage.getText().contains("You have no items to compare."));
  }
}
