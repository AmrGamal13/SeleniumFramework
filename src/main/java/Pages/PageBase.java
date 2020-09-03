package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	//will initialize here the webdriver
	 WebDriver driver;
	
	//create a constructor to initialize our page factory
	//will take a parameter of the driver
	public PageBase(WebDriver driver)
	{
	//initialize page factory ,this means here to use that class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}