Feature: Search a product on Bibit Website Step

  Scenario: User search for specific product
    Given User open Bibit homepage
    When User is searching for "Trimegah Kas Syariah" reksadana
    Then User shown the expected "Trimegah Kas Syariah" reksadana
    When User is trying to logout
    Then User shown logged out state