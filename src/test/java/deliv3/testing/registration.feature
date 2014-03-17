Feature: User Registration

  Scenario: New User Sign Up
 	Given that I am an unregistered user
 	And I wish to sign up for the forum
 	And I agree to the terms of use of the board
 	When I enter a valid username "Foo"
 	And email address "foo@bar.com"
 	And I enter "foobar1000" and my password
 	And I click Submit
 	Then I get taken to the front page
 	And I'm 
 	