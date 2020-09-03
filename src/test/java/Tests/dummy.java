package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class dummy {
	public static WebDriver driver;
	String baseurl;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\videos\\OCP\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseurl = "http://demo.nopcommerce.com/";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void nopcommercedummy() throws InterruptedException {
		WebElement registerbtn = driver.findElement(By.linkText("Register"));
		registerbtn.click();
		Thread.sleep(3000);
		WebElement nametxt = driver.findElement(By.id("FirstName"));
		nametxt.sendKeys("Adel");
		WebElement lasttxt = driver.findElement(By.id("LastName"));
		lasttxt.sendKeys("gamal");
		WebElement emailtxt = driver.findElement(By.id("Email"));
		emailtxt.sendKeys("adel@gmail.com");
		WebElement passtxt = driver.findElement(By.id("Password"));
		passtxt.sendKeys("1234567");
		WebElement repasstxt = driver.findElement(By.id("ConfirmPassword"));
		repasstxt.sendKeys("1234567");
		WebElement regisbtn = driver.findElement(By.id("register-button"));
		regisbtn.click();


	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
