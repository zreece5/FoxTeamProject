Feature: Login
  My LoginPage
  Scenario: a login process
    Given I started the application
    When I use the correct username and password
    Then I should be logged in