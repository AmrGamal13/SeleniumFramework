package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.ProductDetailsPage;
import Pages.SearchPageResults;

public class AutoCompleteSearchTest extends TestBase {
	
	HomePageNew homepageobject;
	SearchPageResults searchpageobj;
	ProductDetailsPage productdetailsobj;
	
  @Test
  public void UserCanSearchUsingAutoComplete() throws InterruptedException {
	  homepageobject = new HomePageNew(driver);
	  homepageobject.ProductsearchusingAutoCom("Mac");
	  //searchpageobj = new SearchPageResults(driver);
	  //searchpageobj.ClickOnproducttitle();
	  productdetailsobj = new ProductDetailsPage(driver);
	  Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");

  }
}
