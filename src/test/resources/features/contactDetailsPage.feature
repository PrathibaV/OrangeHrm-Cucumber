@tag
Feature: Contact details page
  To validate the features of Login page

 Background: 
 	Given User is logged in with valid credentials
 	And user is in My Info page
 	
  @tag1
 Scenario: Verify the user is able to add the contact details
     Given User is in Contact Details page
     When User enters all the contact details
     	| street1 | city | state | zip | country | mobilePh | otherEmail |
     	| test street | Memphis | TN | 38034 | United States | 1234567890 | testemail@yahoo.com |
     And user clicks Save button 
     Then User gets the success message "Successfully Saved"  
    

 