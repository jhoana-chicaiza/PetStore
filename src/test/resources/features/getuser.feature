


Feature: Get user information

  Scenario: Retrieve user information with valid username
    Given Jhoana wants to retrieve the user information for username "jchs"
    When she sends the request to get the user information
    Then the user information should be retrieved successfully