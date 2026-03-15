Feature: Login to Bibit Website Step

  Scenario: User is trying to login to their account
    Given User navigate to Login Page
    When User is trying to login
    Then User shown logged in state