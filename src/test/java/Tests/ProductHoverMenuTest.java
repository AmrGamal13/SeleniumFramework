package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePageNew;

public class ProductHoverMenuTest extends TestBase{
	HomePageNew homepageobject;

  @Test
  public void UserCanHoverOnMenuToSelectProduct() {
	  homepageobject = new HomePageNew(driver);
	  homepageobject.SelectNotebooks();
	  Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
  }
}
