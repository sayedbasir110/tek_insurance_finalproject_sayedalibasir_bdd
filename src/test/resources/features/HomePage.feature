@smoke
Feature: Validate Home Page Layout and Elements
  As a user, I want to ensure that the home page has the correct title and a visible 'Create Primary Account' button

  @HomePage_UserStory1
  Scenario: Validate home page title and 'Create Primary Account' button exists
    Then page title should be "TEK Insurance UI"
    And Create Primary Account button should be displayed
