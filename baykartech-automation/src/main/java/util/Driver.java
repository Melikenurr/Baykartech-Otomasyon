package util;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.edge.EdgeDriver;

        import org.openqa.selenium.support.ui.WebDriverWait;
        import io.github.bonigarcia.wdm.WebDriverManager;
        import java.time.Duration;
        import java.util.Properties;
        import java.util.concurrent.TimeUnit;

public class Driver {
    static WebDriver driver;
    static Properties properties;
    static WebDriverWait wait;

    public static WebDriver initDriver(String browser) {
        properties = ConfigReader.getProperties();



        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }  else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        String url = properties.getProperty("url");
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        int explicitWait = Integer.parseInt(properties.getProperty("explicitWait"));

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static void closeDriver() {
    }
}
