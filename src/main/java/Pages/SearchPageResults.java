package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageResults {

	WebDriver driver;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement ProductTitle;
	
	public SearchPageResults(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnproducttitle() {
		ProductTitle.click();
	}
	
}
