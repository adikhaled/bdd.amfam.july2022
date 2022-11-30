@auto
Feature: Auto Quote validation

  Scenario: Auto Qutote test
    Given user navigate to homePage
    When user click start new quote
    And user input zipcode
    And user click car insurance option
    And user click lets go button
    And select city and state
    And user click on continue button
    And continue overlay handled
    Then title of the page will be <auto quote page>
    When user input address
    Then user able to click start new quote button