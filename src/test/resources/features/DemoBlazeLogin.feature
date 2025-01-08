Feature: DemoBlaze login feature

  Scenario: Successful Login to user account
    Given I visit website
    When I click the login button
    And Enter my login details "admin" and "admin"
    Then I should be successfully logged in
    And Greeted with the welcome message "Welcome admin"
