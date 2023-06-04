Feature: Login with Valid Credentials
@sanity
Scenario: Successful Login with Valid Credentials
Given User Launch browser
And opens URL "https://www.saucedemo.com/v1/"
When browser navigate to Login Page
And User enters Username as "standard_user" and Password as "secret_sauce"
And Click on Login button
Then User navigates to Products Page