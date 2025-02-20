


Feature: Search updated user information

  Scenario: Retrieve updated user information with valid username
    Given Jhoana wants to retrieve the user update information for username "cchs"
    When she sends the request to get the user update information
    Then the username in the response should be "cchs"