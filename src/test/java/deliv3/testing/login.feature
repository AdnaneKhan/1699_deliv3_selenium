Feature: Login System

  Scenario: Registered User Login
    Given I am a registered user
    And my username is "TestUser"
    And my password is "test_pw"
    When I try to log in
    Then my login is accepted
    And I close my browser

  Scenario: Registered User Wrong Pw
    Given I am a registered user
    And my username is "TestUser"
    And my correct password is "test_pw"
    And instead I enter "test_wrong_pw"
    When I try to log in
    Then I am notified that my login was invalid
    And I am not given access to the site
    And I close my browser

  Scenario: Admin Login
    Given that I am a forum administrator
    And my username is "Admin"
    And my password is "1699_pw"
    When I try to log in
   	Then my login is accepted
    And I am able to access the control panel
	And I close my browser