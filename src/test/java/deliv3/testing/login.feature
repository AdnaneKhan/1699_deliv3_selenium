Feature: Login System

Scenario: Registered User Login
Given I am a registered user
And my username is "TestUser"
And my password is "test_pw"
When I try to log in
And I enter TestUser
And I enter test_pw
Then I am given access to the site

Scenario: Registered User Wrong Pw
Given I am a registered user
And my username is "TestUser"
And my password is "test_pw"
When I try to log in
And I enter "TestUser"
And I enter "test_wrong_pw"
Then I am notified that my login was invalid
And I am not given access to the site

Scenario: Admin Login
Given that I am a forum administrator
And my username is "Admin"
And my password is "admin_pw"
When I try to log in
And my login is accepted
Then I am able to access the control panel

