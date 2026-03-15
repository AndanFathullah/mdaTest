Feature: Logout to Bibit Website Step

  Scenario: User is trying to logout from their account
    Given User is already logged in
    When User is trying to logout
    Then User shown logged out state