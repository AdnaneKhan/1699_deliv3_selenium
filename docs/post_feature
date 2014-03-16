Feature: Posting

Scenario: Post Thread
Given that I am a user
and I am trying to post a thread
and I have permission to post a thread
When I fill in the thread body
and I post the thread
Then the thread appears for other users to view

Scenario: Post Access Restriction
Given that I am an admin
and I make a post restricted to admins only
when a non-administrator views the forum
then the user is unable to see the restricted thread