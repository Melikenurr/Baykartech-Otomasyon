package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import util.ElementHelper;

public class LanguagePages {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    // Dil değiştirme butonları
    By btnEnglish = By.cssSelector("a[href='/en/']");
    By btnTurkish = By.cssSelector("a[href='/tr/']");

    public LanguagePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void goToHomePage(String lang) {
        driver.get("https://kariyer.baykartech.com/" + lang + "/");
    }

    public void switchToEnglish() {
        driver.findElement(btnEnglish).click();
        wait.until(ExpectedConditions.titleContains("Home Page"));
    }

    public void switchToTurkish() {
        driver.findElement(btnTurkish).click();
        wait.until(ExpectedConditions.titleContains("Ana Sayfa"));
    }

    public void verifyEnglishPage() {
        String title = driver.getTitle();
        assertTrue(title.contains("Home Page"));
        System.out.println("Dil değişimi başarılı! İngilizce sayfanın başlığı: " + title);
    }

    public void verifyTurkishPage() {
        String title = driver.getTitle();
        assertTrue(title.contains("Ana Sayfa"));
        System.out.println("Dil değişimi başarılı! Türkçe sayfanın başlığı: " + title);
    }
}
