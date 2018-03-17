@complete
Feature: Login Action
This feature tests the Login & the Logout functionalities on the website

@smoke @regression
Scenario Outline: Successful login providing valid creds
Given User is on the Home Page
When User navigates to Login Page
And User enters "<username>" and "<password>"
Then Message to be displayed that User has logged in successfully

Examples:
|	username				 	|	password	|
|	winstonvijay87@gmail.com	|	Test@123!	|
|	winstonmanvijay@gmail.com	|	Test@123!	|

@sanity
Scenario: Successful Logout
When User Logs Out
Then Message to be displayed that User has logged out successfully

