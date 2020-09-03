package Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import Pages.HomePageNew;
import Pages.LoginPage;
import Pages.UserRegisterationPageNew;

public class UserRegisterationTestDDTandCSV extends TestBase {

	HomePageNew homepageobject;
	UserRegisterationPageNew userRegistnewObject;
	LoginPage loginpageobject;
	//object from the csvreader to be able to use the methof of reading the csv files
	CSVReader reader;

	@Test(alwaysRun= true)
	public void UserCanRegisterSuccessfully() throws IOException {
		//get the path of the csv file
		String csv_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserDatacsv.csv";
		reader = new CSVReader(new FileReader(csv_file));
		//array for getting the data from the csv
		String [] csvcell;
		//while loop on the file for reading all the values till the last value
		//as long as we can read the next value , go and execute my script and get the value for 
		while ((csvcell=reader.readNext())!= null) {
			//the first value that will be read is the first name
			String firstnamevalue = csvcell[0];
			//the second value that will be read is the last name
			String lastnamevalue = csvcell[1];
			//the third value that will be read is the email
			String emailvalue = csvcell[2];
			//the fourth value that will be read is the password
			String passwordvalue = csvcell[3];

			homepageobject = new HomePageNew(driver);
			userRegistnewObject = new UserRegisterationPageNew(driver);
			homepageobject.clickonRegisterlnk();
			//will enter the data from the parameter that we used in the method
			userRegistnewObject.register(firstnamevalue, lastnamevalue,emailvalue ,passwordvalue );
			Assert.assertTrue(userRegistnewObject.registerationsuccmessage.getText().contains("Your registration completed"));
			userRegistnewObject.logout();
			homepageobject.clickonlogin();
			loginpageobject = new LoginPage(driver);
			//will enter the data from the parameter that we used in the method
			loginpageobject.login(emailvalue,passwordvalue );
			//verify that log out link appeared after login in
			Assert.assertTrue(userRegistnewObject.logoutlnk.isDisplayed());
			userRegistnewObject.logout();
		}
	}
}
