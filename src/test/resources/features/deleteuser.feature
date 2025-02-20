


Feature: Delete user

  Scenario: Delete user with valid username
    Given Jhoana wants to delete the user with username "jchs"
    When she sends the request to delete the user
    Then the response message should contain the username "jchs"