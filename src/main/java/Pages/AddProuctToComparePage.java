package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProuctToComparePage {

	WebDriver driver;

	@FindBy(css="a.clear-list")
	WebElement ClearLIstLink;

	@FindBy(css="div.no-data")
	public WebElement NoDataLabelmessage;

	@FindBy(css="table.compare-products-table")
	WebElement CompareTable;

	@FindBy(tagName="tr")
	List<WebElement> AllRows;

	@FindBy(tagName="td")
	List<WebElement> AllCols;

	@FindBy(linkText="Asus N551JK-XOO76H Laptop")
	public WebElement AsusProduct;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement AppleProduct;

	public AddProuctToComparePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void ClearComparelist() {
		ClearLIstLink.click();
	}

	public void CompareList() {
		//get the size of the rows
		System.out.println(AllRows.size());
		
		//list all the values of the rows
		for (WebElement Row : AllRows) {
			
			System.out.println(Row.getText() + "\t" );
			for (WebElement Col : AllCols) {
				
				System.out.println(Col.getText() + "\t");
			}
		}
	}
}


