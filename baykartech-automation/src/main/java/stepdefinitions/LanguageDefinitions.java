package stepdefinitions;

import Pages.LanguagePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import util.Driver;

public class LanguageDefinitions {
    LanguagePages languagePages = new LanguagePages(Driver.getDriver());

    @Given("Kariyer Baykar TR anasayfasina git")
    public void kariyerBaykarTRAnasayfasinaGit() {
        languagePages.goToHomePage("tr");
    }

    @When("Sayfada Dil degistir ve icerigin dogru oldugu kontrol et")
    public void sayfadaDilDegistirVeIceriginDogruOlduguKontrolEt() {
        languagePages.switchToEnglish();
        languagePages.verifyEnglishPage();
        languagePages.switchToTurkish();
        languagePages.verifyTurkishPage();
    }

    @Then("Sayfayı Kapat")
    public void sayfayıKapat() {

    }
}
