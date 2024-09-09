
  Feature: Validate Accounts page data
    As a CSR user, I want to validate data rows in Accounts page

  Background: common steps
    When user clicks on "Login" link
    Given user enters "supervisor" in "Username" field
    And user enters "tek_supervisor" in Password field
    When user clicks on "Sign In" button
    Then validate user is in Customer Service Portal
    When user clicks on "Accounts" link
    Then user should be navigated to Accounts page

    @Accounts_UserStory1
    Scenario: Validate number of table records in Accounts page
      Then validate there are 5 records displayed

    @Accounts_UserStory2
    Scenario: Validate table records update when changing 'Show records' to 10, 25, and 50 in Accounts page
      When user selects "Show 10" from Show records dropdown
      Then validate there are 10 records displayed
      When user selects "Show 25" from Show records dropdown
      Then validate there are 25 records displayed
      When user selects "Show 50" from Show records dropdown
      Then validate there are 50 records displayed
