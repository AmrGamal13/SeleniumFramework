package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageNew {

	WebDriver driver;

	@FindBy(linkText="Register")
	WebElement registerlink;

	@FindBy(linkText="Log in")
	WebElement loginlnk;

	@FindBy(id="small-searchterms")
	WebElement searchtxtbox;

	@FindBy(css="input.button-1.search-box-button")
	WebElement searchbtn;

	@FindBy(id="ui-id-1")
	List<WebElement> Autocompleteproduct;

	@FindBy(linkText="Contact us")
	WebElement ContactUsLink;

	@FindBy(id="customerCurrency")
	WebElement CurrencyDropDownlist;

	@FindBy(linkText="Computers")
	WebElement ComputersMenu;

	@FindBy(linkText="Notebooks")
	WebElement NotebooksMenu;

	public HomePageNew(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonRegisterlnk() {
		registerlink.click();
	}

	public void clickonlogin() {
		loginlnk.click();
	}

	public void ProductSearch(String productname) {
		searchtxtbox.sendKeys(productname);
		searchbtn.click();
	}

	public void ProductsearchusingAutoCom( String searchtext) throws InterruptedException {
		searchtxtbox.sendKeys(searchtext);
		Thread.sleep(3000);
		//click on the first element in the list , the first element that will appear in the auto complete
		Autocompleteproduct.get(0).click();
	}

	public void OpenContactUs() {
		ContactUsLink.click();
	}

	public void PerformChangeCurrency() {
		Select sl= new Select(CurrencyDropDownlist);
		sl.selectByVisibleText("Euro");
	}
	
	public void SelectNotebooks() {
		//for using hover menu we take an object from actions
		Actions act = new Actions(driver);
		//hover on computer menu then hover on notebooks menu then click on it
		act.moveToElement(ComputersMenu).moveToElement(NotebooksMenu).click().build().perform();
	}
}
