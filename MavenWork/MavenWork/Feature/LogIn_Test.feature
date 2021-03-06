Feature: Test Order of Hooks
This is the Description block

Background:
Given this is the Given-bg block
When this is the When-bg block
Then this is the Then-bg block

@First
Scenario: This is the 1st Scenario
Given this is the first step
When this is the second step
Then this is the final-third step

@Second
Scenario: This is the 2nd Scenario
Given this is the first step
When this is the second step
Then this is the final-third step

#@complete
#Feature: Login Action
#This feature tests the Login & the Logout functionalities on the website
#
#@smoke @regression
#Scenario Outline: Successful login providing valid creds
#Given User is on the Home Page
#When User navigates to Login Page
#And User enters "<username>" and "<password>"
#Then Message to be displayed that User has logged in successfully
#
#Examples:
#|	username				 	|	password	|
#|	winstonvijay87@gmail.com	|	Test@123!	|
#|	winstonmanvijay@gmail.com	|	Test@123!	|
#
#@sanity
#Scenario: Successful Logout
#When User Logs Out
#Then Message to be displayed that User has logged out successfully