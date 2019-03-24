Feature: EditProfile
  my Edit Profile Page
  Scenario: a profile edit process
    Given I have logged in and see the main menu screen
    When I open the edit profile page
    Then my profile should be editable