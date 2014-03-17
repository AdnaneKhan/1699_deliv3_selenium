Feature: Profile Options

  Scenario: User Twitter Handle
    Given I am a registered user
    And my username is "Admin"
    And my password is "1699_pw"
    When I edit my profile
    And I set my Twitter handle as "user1"
    And I submit my changes
    Then my twitter handle should appear below posts that I have made
    And I close my browser
    
  Scenario: Add A Signature
   	Given I am a user
    And my username is "Admin"
    And my password is "1699_pw"
    When I edit my profile
    And I set my Signature to "I am the rules of the board"
    And then set my signature to attach
    And then I save these chages
    Then my signature should appear below posts that I have made
    And I close my browser
    
Scenario: Hide my signature
	Given that I am a user
	And my username is "Admin"
	And my password is "1699_pw"
	When I edit my profile
	And disable attaching of my signature
	And then I save these changes
	Then no longer should my signature appear beneath posts I have participated in
	And I close my browser
