
Feature: Sayfa Dili Kontrolü

  @LangTest
  Scenario:  Baykartech Sayfasının dilleri arasında geçiş yapıldığının kontrol edilmesi

    Given Kariyer Baykar TR anasayfasina git
    When Sayfada Dil degistir ve icerigin dogru oldugu kontrol et
    Then Sayfayı Kapat