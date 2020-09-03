package Tests;

import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class TestBase  {
//extends AbstractTestNGCucumberTests
	
	public static WebDriver driver;
	String baseurl;

	@BeforeSuite
	@Parameters({"browser"})
	public void startdriver(@Optional("chrome") String browsername)
	{
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\videos\\OCP\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browsername.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\IBM_ADMIN\\workspace\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("HeadlessPhantomJS")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
			System.getProperty("C:\\Users\\IBM_ADMIN\\Desktop\\videos\\OCP\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe"));
			String [] phantomJSArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJSArgs);
			driver = new PhantomJSDriver(caps);
		}
		
		else if (browsername.equalsIgnoreCase("HeadlessChrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\Desktop\\videos\\OCP\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-sixe=1920,1080");
			driver = new ChromeDriver(options);
		}


		baseurl = "http://demo.nopcommerce.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);

	}

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

	@AfterSuite
	public void closedriver()
	{
		driver.quit();
	}
}
