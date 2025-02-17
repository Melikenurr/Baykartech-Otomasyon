package util;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import util.Driver;
import util.ConfigReader;

import java.util.Properties;

public class Hooks {
    static WebDriver driver;
    static Properties properties;

    @Before
    public void before() {
        properties = ConfigReader.initProperties();
        String browser = properties.getProperty("browser", "chrome");

        driver = Driver.initDriver(browser);
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
