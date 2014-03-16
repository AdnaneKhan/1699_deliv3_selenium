Feature: Login System

Scenario: Registered User Login
Given I am a registered user
and my username is TestUser
and my password is test_pw
When I try to log in
and I enter TestUser
and I enter test_pw
Then I am given access to the site

Scenario: Registered User Wrong Pw
Given I am a registered user
and my username is TestUser
and my password is test_pw
When I try to log in
and I enter TestUser
and I enter test_wrong_pw
then I am notififed that my login was invalid
and I am not given access to the site

Scenario: Admin user Login
Given that I am a forum administrator
When I try to log in
and my login is accepted
then I am able to access the admin control panel

