@tag
Feature: Dependents page
  To validate the features of Dependents page

 Background: 
 	Given User is logged in with valid credentials
 	And user is in My Info page
 	
  @tag1
  Scenario Outline: Verify the user is able to add dependent details
    Given User is in Dependents page
    When User clicks Add button under Assigned Dependents section
    And User enters all the dependents details from "<sheetName>" and <rowNum> 
    And User clicks Save button 
    Then User gets the success message "Successfully Saved"   
   
    Examples: 
      | sheetName | rowNum | 
      | DependentsData | 1 |
     # | DependentsData | 2 | 
