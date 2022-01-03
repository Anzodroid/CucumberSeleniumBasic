Feature: check login functionality

Scenario: Check login is successful with valid credenntials
    Given user is on login page
    When user enters valid username and password
    And clicks on login button
    Then user is navigated to the home page