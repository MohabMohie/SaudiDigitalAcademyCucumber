Feature: This is a Selenium Demo using Cucumber

  Background:
    Given my browser is open

  @Regression
  Scenario Outline: Google Search
    When I navigate to google
    And I search for "<query>"
#    And I search for the following text:
#      | cow   | horse | sheep |
    Then result stats would not be empty

    Scenarios:
      | query                     |
      |    Saudi Digital Academy  |
      |    Test Automation        |


  Scenario Outline: Google Search
    When I navigate to google
    And I search for "<query>"
#    And I search for the following text:
#      | cow   | horse | sheep |
    Then result stats would not be empty

    Scenarios:
      | query                     |
      |    Saudi Digital Academy  |
      |    Test Automation        |
