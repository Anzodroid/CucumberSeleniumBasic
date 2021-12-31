@SmokeScenario
Feature: feature to test login funnctionality

  #@SmokeTest
  #Scenario: Check login is successful with valid credenntials
  #Given browser is opened
  #And user is on login page
  #When user enters username and password
  #And clicks on login button
  #Then user is navigated to the home page
  
  
  Scenario Outline: Check login is successful with valid credenntials
    Given browser is opened
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username     | password |
      | anzo         |    12345 |
      | cucumber     |    12345 |
      | happynewyear |    12345 |
