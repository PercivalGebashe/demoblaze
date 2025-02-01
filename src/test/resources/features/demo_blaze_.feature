Feature: DemoBlaze login feature

  Background: Open home page
    Given I visit "https://www.demoblaze.com/" website

  Scenario: Successful Login to user account
    When I click the login button
    And Enter my login details "admin" and "admin"
    Then I should be successfully logged in
    And Greeted with the welcome message "Welcome admin"

#  Scenario: I Buy a product from the online store
#    When I click on the product "Samsung galaxy s6"
#    Then I should be on the product details page and see "Samsung galaxy s6"
#    When I click the add to card button
#    Then I should see alert "Product added"