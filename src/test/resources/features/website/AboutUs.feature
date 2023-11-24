Feature: All Feature in About Us
  Scenario Outline: User hide modal about us by click button close
    Given user already in "<Page>"
    And user click button navigation About Us
    And About Us Modal will be show
    When user click button close in About Us Modal
    Then About Us Modal will be hide
    Examples:
      | Page          |
      | HomePage      |
      | CartPage      |
      | ProductPage   |
