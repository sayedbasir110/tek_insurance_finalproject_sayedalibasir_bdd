
Feature: CSR portal profile and logout validation
  As a CSR user, I want to ensure CSR profile information is correct and I can logout successfully.

  Background: Common steps
    When user clicks on "Login" link
    Given user enters "supervisor" in "Username" field
    And user enters "tek_supervisor" in Password field
    When user clicks on "Sign In" button
    Then validate user is in Customer Service Portal
    When user clicks on profile button

  @UserProfile_UserStory1
  Scenario: Validate navigation to CSR profile and profile information with valid CSR credentials
    Then validate profile "USER TYPE" is "CSR"
    Then validate profile "FULL NAME" is "Supervisor"
    Then validate profile "USERNAME" is "supervisor"
    Then validate profile AUTHORITIES is "admin"

  @UserProfile_UserStory2
  Scenario: Validate navigation to HomePage when user log out
    When user clicks on "Logout" button
    Then validate user is in Homepage

