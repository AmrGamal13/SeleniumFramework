package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductReviewPage {

	WebDriver driver;

	@FindBy(id="AddProductReview_Title")
	WebElement ReviewTitleTxtbox;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement ReviewTextTxtbox;

	@FindBy(id="addproductrating_4")
	WebElement RatingCheckbox;

	@FindBy(name="add-review")
	WebElement AddReviewBtn;

	@FindBy(css="div.result")
	public WebElement MessageNotification;


	public AddProductReviewPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void AddReview(String reviewtitle, String reviewtextbox) {
		ReviewTitleTxtbox.sendKeys(reviewtitle);
		ReviewTextTxtbox.sendKeys(reviewtextbox);
		RatingCheckbox.click();
		AddReviewBtn.click();
	}
}
