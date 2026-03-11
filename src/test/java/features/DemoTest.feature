Feature: Test for Demo App

  Scenario: Success Login on the app
    Given User navigates to app
    When user login to their account
    Then user logged in to their account

  Scenario: Success Purchase Selected Product
    Given User navigates to app
    When user login to their account
    When user purchase a product
    Then user success purchase

  Scenario: Success sorting product
    Given User navigates to app
    When user sort name product descending
    When user sort price product ascending
    Then user see result as expected