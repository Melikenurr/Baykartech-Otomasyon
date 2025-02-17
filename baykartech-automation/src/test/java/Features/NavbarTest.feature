Feature: Navbar Otomasyonu

  @NavbarTest

  Scenario: Navbar bağlantılarının çalıştığını doğrula
    Given Siteye git
    When Navbar icindeki tum baglantilari kontrol et
    Then Tum baglantilarin sayfa basliklarini dogrula