Feature: Hit Demo API and verify it response
  Scenario: Verify POST API Response
    Given I hit the API
    And I add body title and Learn API Testing request to the URL
    And I add body body and Practicing API testing with JSONPlaceholder request to the URL
    And I add integer body userId and 101 request to the URL
    When I hit the Post URL using request body
    Then I receive Post response Learn API Testing and Practicing API testing with JSONPlaceholder and 101 as expected

  Scenario: Verify GET API Response
    Given I hit the API
    When I pass the Get request to the URL
    Then I receive Get response as expected

  Scenario: Verify DELETE API Response
    Given I hit the API
    When I pass the delete 1 request to the URL
    Then I receive delete response as expected

  Scenario: Verify PUT API Response
    Given I hit the API
    And I add body title and Updated Post Title request to the URL
    And I add body body and This is the updated body content. request to the URL
    And I add integer body userId and 99 request to the URL
    When I pass the put 1 request to the URL
    Then I receive put response Updated Post Title and This is the updated body content. and 99 as expected