

Feature: Create a new user

  Scenario: Create a new user with valid information
    Given Jhoana wants to create a new user
    When she sends the user information
    Then the user should be created successfully