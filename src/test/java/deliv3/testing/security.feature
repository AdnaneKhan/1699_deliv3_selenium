Feature: Account Security

  Scenario: Change Password
    Given that I am a user
    And my username is "TestUser"
    And my password is "test_pw"
    And try to log in
    And my login is accepted
    When I want to change my password to "not_test_pw"
    And I submit my changes
    And I log out
    Then my old password of "test_pw" does not work
    And I close my browser

  Scenario: Bad PW Change Attempt
    Given that I am a user
    And my username is "TestUser"
    And my password is "test_pw"
    And try to log in
    And my login is accepted
    When I want to change my password to "not_test_pw"
    When I am asked to enter my old password I enter "wrong_pw"
    And I submit my changes
    Then my password change is rejected
    And I close my browser

  Scenario: Invalid Password Confirmation
    Given that I am a user
    And my username is "TestUser"
    And my password is "test_pw"
    And try to log in
    And my login is accepted
    When I want to change my password to "not_test_pw"
    When I am asked to confirm the new password I enter "not_tesst_pw"
    And I submit my changes
    Then my password change is rejected
    And I close my browser
