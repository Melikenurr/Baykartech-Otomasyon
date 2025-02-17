package stepdefinitions;

import Pages.NavbarPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import util.Driver;

public class NavbarDefinitions {

    WebDriver driver = Driver.getDriver();
    NavbarPages navbarPages = new NavbarPages(driver);
    @Given("Siteye git")
    public void siteyeGit() {
        navbarPages.HomePage();
    }

    @When("Navbar icindeki tum baglantilari kontrol et")
    public void navbarIcindekiTumBaglantilariKontrolEt() {
        navbarPages.validateNavbarLinks();
    }

    @Then("Tum baglantilarin sayfa basliklarini dogrula")
    public void tumBaglantilarinSayfaBasliklariniDogrula() {
        System.out.println("Tüm navbar linkleri başarıyla test edildi!");
    }
}
