@web @HeaderNavigation
Feature: Check all menu header navigation
    Scenario Outline: User can open modal sign up
        Given user already in "<Page>"
        When user click button navigation Sign Up
        Then Sign Up Modal will be show
          Examples:
            | Page          |
            | HomePage      |
            | CartPage      |
            | ProductPage   |
    Scenario Outline: User can open modal sign in
        Given user already in "<Page>"
        When user click button navigation Sign In
        Then Sign In Modal will be show
        Examples:
            | Page          |
            | HomePage      |
            | CartPage      |
            | ProductPage   |
    Scenario Outline: User can navigate to cart page by click button cart navigation
        Given user already in "<Page>"
        When user click button navigation Cart
        Then move to Cart Page
        Examples:
            | Page          |
            | HomePage      |
            | ProductPage   |
    Scenario Outline: User can open modal Contact
        Given user already in "<Page>"
        When user click button navigation Contact
        Then Contact Modal will be show
        Examples:
            | Page          |
            | HomePage      |
            | CartPage      |
            | ProductPage   |
    Scenario Outline: User can open modal About Us
        Given user already in "<Page>"
        When user click button navigation About Us
        Then About Us Modal will be show
        Examples:
            | Page          |
            | HomePage      |
            | CartPage      |
            | ProductPage   |
    Scenario Outline: User reload page When click button Home from HomeScreen
        Given user already in "<Page>"
        When user click button navigation Home
        Then check user is in Home Screen
        Examples:
            | Page          |
            | HomePage      |
            | CartPage      |
            | ProductPage   |
    Scenario Outline: User reload page When click button Icon DemoBlaze from HomeScreen
        Given user already in "<Page>"
        When user click button icon demoblaze
        Then check user is in Home Screen
        Examples:
            | Page          |
            | HomePage      |
            | CartPage      |
            | ProductPage   |

