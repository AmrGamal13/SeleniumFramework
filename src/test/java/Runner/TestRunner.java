package Runner;

import org.testng.annotations.Test;

import Tests.TestBase;
import cucumber.api.CucumberOptions;

//features: path of the feature file
//glue:place of the step definition 
//plugin: to make a report in html shape inside target folder

@CucumberOptions(features = "src/test/java/features", glue = { "Stepdefinitions" }, plugin = { "pretty",
		"html:target/cucumber-html-report" })
public class TestRunner extends TestBase {
	
	
}
