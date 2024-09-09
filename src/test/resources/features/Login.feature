@smoke
Feature: Login functionality
  As a user, I want to be able to log in to the Customer Service Portal with valid CSR credentials
  and receive appropriate error messages for invalid attempts.

  Background: Common steps
    When user clicks on "Login" link

  @Login_UserStory1
  Scenario: Validate navigation to Customer Service Portal with valid CSR credentials
    Given user enters "supervisor" in "Username" field
    And user enters "tek_supervisor" in Password field
    When user clicks on "Sign In" button
    Then validate user is in Customer Service Portal

  @Login_UserStory2
  Scenario Outline: Validate login errors
    When user enters "<userName>" in "Username" field
    And user enters "<password>" in Password field
    And user clicks on "Sign In" button
    Then user should see error "<error>"
    Examples:
      | userName        | password          | error                          |
      | invalidUserName | Password@123      | User invalidUserName not found |
      | supervisor      | incorrectPassword | Password not matched           |