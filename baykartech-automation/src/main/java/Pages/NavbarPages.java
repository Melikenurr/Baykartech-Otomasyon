package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class NavbarPages {
    WebDriver driver;
    util.ElementHelper elementHelper;
    WebDriverWait wait;

    public NavbarPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        this.elementHelper = new util.ElementHelper(driver);
    }
    public void HomePage() {

    }

    public void validateNavbarLinks() {
        System.out.println("Navbar testi başlıyor");

        List<WebElement> navbarElements = driver.findElements(By.cssSelector("nav .dropdown, nav a"));

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (WebElement element : navbarElements) {
            String linkText = element.getText().trim();
            if (!linkText.isEmpty()) {
                actions.moveToElement(element).perform();
                wait.until(ExpectedConditions.elementToBeClickable(element));

                // Eğer dropdown menüyse, içindeki linklere tıkla
                if (element.getAttribute("class").contains("dropdown")) {
                    List<WebElement> dropdownItems = element.findElements(By.cssSelector(".dropdown-menu a"));
                    for (WebElement dropdownItem : dropdownItems) {
                        if (dropdownItem.isDisplayed()) {
                            actions.moveToElement(dropdownItem).click().perform();
                            System.out.println("Dropdown menü tıklandı: " + dropdownItem.getText());
                            driver.navigate().back();
                            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav")));

                        }
                    }
                } else {

                    element.click();
                    System.out.println("Tıklanan Link: " + linkText);
                    driver.navigate().back();
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav")));

                }
            }
        }
        System.out.println("Navbar testi tamamlandı.");
    }

    }

