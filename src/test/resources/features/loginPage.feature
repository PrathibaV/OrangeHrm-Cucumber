@login
Feature: Login Page
  To validate the features of Login page

  Scenario: Verify login with valid credentials
    Given User is in Login page
    When User enters valid username and password
    And clicks Login button
    Then User lands on Dashboard page

  Scenario Outline: Verify login with invalid credentials
    Given User is in Login page
    When User enters invalid credentials from "<sheetName>" and <rowNum> 
    And clicks Login button
    Then User sees appropriate error message

    Examples: 
      | sheetName | rowNum | 
      | LoginData |     1 |
      | LoginData |     2 |
