@web @Logout
Feature: Logout Feature
  Scenario Outline: User can logout by click logout in header navigation
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    And user filled username in Login Modal with "nyoman"
    And user filled password in Login Modal with "nyoman"
    And user click button Login
    And wait reload HomePage
    And Sign In Modal will be hide
    And Assert you are already login with username "nyoman"
    And Assert user has cookies token
    When user click button logout in header navigation
    Then Assert user already logout
    And Assert user dont have cookies token
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |