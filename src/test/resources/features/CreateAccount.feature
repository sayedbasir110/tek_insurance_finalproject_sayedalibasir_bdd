@smoke
Feature: User Account Creation Workflow
  As a new user, I want to create a primary account so that I can use the platform.

  Background: common steps
    When  user clicks on "Create Primary Account" link

  @CreateNewAccount_UserStory1
  Scenario: Validate navigation to create new account form and form title
    Then validate user is in Create Primary Account Page and section title is "Create Primary Account Holder"

  @CreateNewAccount_UserStory2
  Scenario: Validate navigation and email on successful primary account creation
    When user enters "random email" in "Email Address" field
    And user selects "Mr." from "Title / Prefix" dropdown
    And user enters "John" in "First Name" field
    And user enters "Doe" in "Last Name" field
    And user selects "Male" from "Gender" dropdown
    And user selects "Single" from "Marital Status" dropdown
    And user enters "Self Employment" in "Employment Status" field
    And user enters "1996-02-01" in "Date Of Birth" field
    And user clicks on "Create Account" button
    Then user should be navigated to sign-up page
    And email address should match the provided email

  @CreateNewAccount_UserStory3,4
  Scenario Outline: Validate account creation errors
    When user enters "<email>" in "Email Address" field
    And user selects "Mr." from "Title / Prefix" dropdown
    And user enters "John" in "First Name" field
    And user enters "Doe" in "Last Name" field
    And user selects "Male" from "Gender" dropdown
    And user selects "Single" from "Marital Status" dropdown
    And user enters "Self Employment" in "Employment Status" field
    And user enters "<dateOfBirth>" in "Date Of Birth" field
    And user clicks on "Create Account" button
    Then user should see error "<error>"
    Examples:
      | email              | dateOfBirth | error                                           |
      | john.doe@gmail.com | 1996-02-01  | Account with email john.doe@gmail.com is exist  |
      | random email       | 2010-02-01  | you must be 18 years or older to create account |

    @CreateNewAccount_UserStory5
    Scenario: Create new account, sign in and validate profile name
      When user enters "random email" in "Email Address" field
      And user selects "Mr." from "Title / Prefix" dropdown
      And user enters "John" in "First Name" field
      And user enters "Doe" in "Last Name" field
      And user selects "Male" from "Gender" dropdown
      And user selects "Single" from "Marital Status" dropdown
      And user enters "Self Employment" in "Employment Status" field
      And user enters "1996-02-01" in "Date Of Birth" field
      And user clicks on "Create Account" button
      Then user should be navigated to sign-up page
      When user enters "random userName" in "Username" field
      And user enters "Password@123" in Password field
      And user enters "Password@123" in Confirm Password field
      And user clicks on "Submit" button
      Then user should be navigated to sign-in page
      When user enters "userName" in "Username" field
      And user enters "Password@123" in Password field
      And user clicks on "Sign In" button
      Then user should be navigated to Primary Account Portal page
      When user clicks on profile button
      Then profile name should be "John Doe"
