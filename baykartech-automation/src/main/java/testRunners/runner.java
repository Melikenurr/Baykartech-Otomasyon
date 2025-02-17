package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.openqa.selenium.WebDriver;
import util.Driver;



@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"stepdefinitions", "util"},
        tags = " ",
        plugin = {
                "summary","pretty","html:Reports/CucumberReport/Reports.html"
        }
)
public class runner extends AbstractTestNGCucumberTests {
    static WebDriver driver = Driver.getDriver();
}