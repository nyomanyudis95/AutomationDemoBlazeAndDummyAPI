@web @Login
Feature: Login
  Scenario Outline: user can close sign in modal with button close
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user click button close in sign in modal
    Then Sign In Modal will be hide
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
  Scenario Outline: user can't sign up with empty username and password
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user click button Login
    Then show alert "Please fill out Username and Password."
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
  Scenario Outline: user can't sign up with empty password
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user filled username in Login Modal with "ada"
    And user click button Login
    Then show alert "Please fill out Username and Password."
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
  Scenario Outline: user can't sign up with empty username
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user filled password in Login Modal with "ada"
    And user click button Login
    Then show alert "Please fill out Username and Password."
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
  Scenario Outline: user can't login with not existing username
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user filled username in Login Modal with "!@$!@"
    And user filled password in Login Modal with "!$!@$!@$"
    And user click button Login
    Then show alert "User does not exist."
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
  Scenario Outline: user can't login with wrong password
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user filled username in Login Modal with "nyoman"
    And user filled password in Login Modal with "!$!@$!@$"
    And user click button Login
    Then show alert "Wrong password."
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
  Scenario Outline: user can login with valid username and password
    Given user already in "<Page>"
    And user click button navigation Sign In
    And Sign In Modal will be show
    When user filled username in Login Modal with "nyoman"
    And user filled password in Login Modal with "nyoman"
    And user click button Login
    Then wait reload HomePage
    And Sign In Modal will be hide
    And Assert you are already login with username "nyoman"
    And Assert user has cookies token
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |


