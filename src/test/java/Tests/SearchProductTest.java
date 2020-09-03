package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePageNew;
import Pages.ProductDetailsPage;
import Pages.SearchPageResults;

public class SearchProductTest extends TestBase {
	
	HomePageNew homepageobject;
	SearchPageResults searchpageobj;
	ProductDetailsPage productdetailsobj;
	
  @Test
  public void UserCanSearchforProduct() {
	  homepageobject= new HomePageNew(driver);
	  searchpageobj = new SearchPageResults(driver);
	  homepageobject.ProductSearch("Apple MacBook Pro 13-inch");
	  searchpageobj.ClickOnproducttitle();
	  productdetailsobj = new ProductDetailsPage(driver);
	  Assert.assertEquals(productdetailsobj.ProductNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
  }
}
