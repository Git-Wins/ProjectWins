Feature: Login Action

Scenario: Successful login providing valid creds
Given User is on the Home Page
When User navigates to Login Page
And User enters Username and Password
Then Message to be displayed that User has logged in successfully
