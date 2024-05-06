Feature: Login feature
  Background:
    Given I open Login Page
  Scenario: Login Success
    When I enter email "elzat.nurmanbetova@testpro.io"
    And i enter password "kochkor123-Q!"
    And I submit
    Then I am logged in

   Scenario: Login incorrect password
     When I enter email "elzat.nurmanbetova@testpro.io"
     And I enter incorrect password "Teststudent"
     And I submit
     Then I still Login page

   Scenario: Login not existing email
     When I enter not existing email "elzat.nur@testpro.io"
     And I enter incorrect password "teststudent"
     And I submit
     Then I still Login page

  Scenario: Empty Login and Password
    When I enter Empty email " "
    And I enter Empty password " "
    And I submit
    Then I still Login page

  Scenario: check all Songs
    When I enter email "elzat.nurmanbetova@testpro.io"
    And i enter password "kochkor123-Q!"
    And I click all songs button
    Then I get all songs page

  Scenario: play first Song
    When I enter email "elzat.nurmanbetova@testpro.io"
    And i enter password "kochkor123-Q!"
    And I click all songs button
    And I get all songs page
    And I click first Song









