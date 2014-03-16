Feature: Profile Options

Scenario: User Twitter Handle
Given that I am a user
And my username is "Admin"
And my password is "**Admin_PW**"
When edit my profile
And I set my Twitter handle as "user1"
And then save these changes
Then my twitter handle should appear below posts that I have made