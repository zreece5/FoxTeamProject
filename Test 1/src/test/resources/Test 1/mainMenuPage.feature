Feature: Main Menu
  my Main Menu Page
  Scenario: see the main menu
    Given I have logged in
    When I open the main menu page
    Then the main menu should be viewable