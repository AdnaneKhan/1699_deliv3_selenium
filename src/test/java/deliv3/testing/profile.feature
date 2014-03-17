Feature: Profile Options

  Scenario: User Twitter Handle
    Given I am a registered user
    And my username is "TestUser"
    And my password is "test_pw"
    When I try to log in
    And I edit my profile
    And I want to change my Twitter account to "RyanUlan"
    And I submit my changes
    Then my twitter handle should appear below posts that I have made
    And I close my browser
    
  Scenario: Add A Signature
   	Given I am a registered user
    And my username is "TestUser"
    And my password is "test_pw"
    When I try to log in
    And I edit my profile
    And I set my Signature to "I am the ruler of the board"
    And then set my signature to attach
    And I submit my changes
    Then my signature should appear below posts that I have made
    And I close my browser
    
Scenario: Hide my signature
	Given that I am a user
	And my username is "Admin"
	And my password is "1699_pw"
	When I edit my profile
	And disable attaching of my signature
	And I submit my changes
	Then no longer should my signature appear beneath posts I have participated in
	And I close my browser
