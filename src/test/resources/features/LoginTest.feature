Feature: Login feature
  Scenario: Login Success
    Given I open Login Page
    When I enter email "elzat.nurmanbetova@testpro.io"
    And i enter password "kochkor123-Q!"
    And I submit
    Then I am logged in