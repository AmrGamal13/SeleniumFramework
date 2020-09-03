package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.ProductDetailsPage;

public class ChangeCurrencyTest extends TestBase {
	HomePageNew homepageobject;
	ProductDetailsPage productdetailsobj;


	@Test(priority=1)
	public void UserCanChangeCurrency() {
		homepageobject = new HomePageNew(driver);
		homepageobject.PerformChangeCurrency();
	}

	@Test(priority=2)
	public void UserCanSearchUsingAutoComplete() throws InterruptedException {
		homepageobject = new HomePageNew(driver);
		homepageobject.ProductsearchusingAutoCom("Mac");
		productdetailsobj = new ProductDetailsPage(driver);
		Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		Assert.assertTrue(productdetailsobj.ProductPriceLabel.getText().contains("€"));
		System.out.println(productdetailsobj.ProductPriceLabel.getText());
	}
}
