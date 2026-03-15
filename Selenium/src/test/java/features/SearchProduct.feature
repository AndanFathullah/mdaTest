Feature: Search a product on Bibit Website Step

  Scenario: User search for specific product
    Given User open Bibit homepage
    When User is searching for "Emas" product
    Then User shown the expected "Emas" product