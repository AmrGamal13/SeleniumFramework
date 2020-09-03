package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

	WebDriver driver;

	@FindBy(css="a.button-2.print-order-button")
	WebElement PrintBtn;
	
	@FindBy(css="a.button-2.pdf-invoice-button")
	WebElement PDFInvoiceBtn;
	
	public OrderDetailsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ViewOrderInfo() throws InterruptedException
	{
		PDFInvoiceBtn.click();
		Thread.sleep(3000);
		PrintBtn.click();
	}
}

