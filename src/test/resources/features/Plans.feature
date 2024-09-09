@regression
  Feature: Validate Plans page data
    As a CSR user, I want to validate data rows in Plans page

  Background: common steps
    When user clicks on "Login" link
    Given user enters "supervisor" in "Username" field
    And user enters "tek_supervisor" in Password field
    When user clicks on "Sign In" button
    Then validate user is in Customer Service Portal
    When user clicks on "Plans" link
    Then user should be navigated to Plans page

    @Plans_UserStory1
    Scenario: Validate number of table records in Plans page
      Then validate there are 4 records displayed

    @Plans_UserStory2
    Scenario: Validate 'Create Date' and 'Expiry Date' in Plans page
      Then validate DATE CREATED is today's date
      Then validate DATE EXPIRE is tomorrow's date


