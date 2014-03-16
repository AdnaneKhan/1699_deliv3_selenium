Feature: Posting

Scenario: Post Thread
Given that I am a user
And I am trying to post a thread
And I have permission to post a thread
When I fill in the thread body
And I post the thread
Then the thread appears for other users to view

Scenario: Post Access Restriction
Given that I am an admin
And I make a post restricted to admins only
Then a non-administrator views the forum
Then the user is unable to see the restricted thread