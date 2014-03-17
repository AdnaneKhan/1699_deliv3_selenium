Feature: Posting

  Scenario: Post Thread
   	Given I am a registered user
    And my username is "TestUser"
    And my password is "test_pw"
    And I am trying to post a new thread
    And I have permission to post a thread
    When I click "Test Forum"
    And I click New Topic
    And I write "Greetings" into the thread subject
    And I enter "How's everyone doing today?" into the thread body
    And I click Post Thread
    Then the thread appears for other users to view
    And I close my browser

  Scenario: Post Access Restriction
    Given that I am an admin
    And I make a thread named "NSA" restricted to admins only
    When a non-administrator views the forum
    Then that user is unable to see the restricted thread
    And I close my browser
