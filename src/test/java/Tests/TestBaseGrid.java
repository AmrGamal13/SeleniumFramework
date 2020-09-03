package Tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseGrid {

	public static String BaseUrl= "http://demo.nopcommerce.com/";

	//in grid we use remotewebdriver not webdriver, and here we will threads because every browser will be launched in a separate thread 

	protected ThreadLocal<RemoteWebDriver> driver = null;

	@BeforeClass
	@Parameters(value = {"browser"})
	public void setup(@Optional("chrome") String browser) throws MalformedURLException
	{
		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		//the url here is the url of the hub that through it will go and open the nodes that we see from the console 
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		//to navigate to the url of the app
		getDriver().get(BaseUrl);
	}

	//method to work with the thread
	public WebDriver getDriver()
	{
		return driver.get();
	}

	@AfterClass
	public void StopDriver()
	{
		getDriver().quit();
		//removing the threads
		driver.remove();
	}
	//method for getting the screenshot
	@AfterMethod
	public void takingscreenshot(ITestResult result) throws IOException {

		if (ITestResult.FAILURE== result.getStatus()) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot.....");
			// create reference for taking screenshot
			//will ask the driver to ivoke and use the takescreenshot interface clas
			TakesScreenshot ts = (TakesScreenshot)driver;
			//make a file which is the screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);
			//will add a new dependecy on maven for the file utilities class
			//search for file utils maven im google and add it 
			//take the screenshot image and put it in screenshots folder in the poject
			FileUtils.copyFile(source, new File("./screenshots" + result.getName()+ ".png"));
		}
	}

}
