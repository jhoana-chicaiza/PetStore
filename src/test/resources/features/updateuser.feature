


Feature: Update user information

  Scenario: Update user information with valid data
    Given Jhoana wants to update the user information for username "jchs"
    When she sends the updated user information
    Then the user information should be updated successfully