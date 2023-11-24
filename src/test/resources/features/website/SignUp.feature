Feature: Sign Up
    Scenario Outline: user can close sign up modal with button close
      Given user already in "<Page>"
      And user click button navigation Sign Up
      And Sign Up Modal will be show
      When user click button close in sign up modal
      Then Sign Up Modal will be hide
      Examples:
        | Page          |
        | HomePage      |
        | CartPage      |
        | ProductPage   |

    Scenario Outline: user can't sign up with empty username and password
      Given user already in "<Page>"
      And user click button navigation Sign Up
      And Sign Up Modal will be show
      When user click button Sign Up
      Then show alert "Please fill out Username and Password."
      Examples:
        | Page          |
        | HomePage      |
        | CartPage      |
        | ProductPage   |

    Scenario Outline: user can't sign up with empty password
      Given user already in "<Page>"
      And user click button navigation Sign Up
      And Sign Up Modal will be show
      When user filled username with "ada"
      And user click button Sign Up
      Then show alert "Please fill out Username and Password."
      Examples:
        | Page          |
        | HomePage      |
        | CartPage      |
        | ProductPage   |

    Scenario Outline: user can't sign up with empty username
      Given user already in "<Page>"
      And user click button navigation Sign Up
      And Sign Up Modal will be show
      When user filled password with "ada"
      And user click button Sign Up
      Then show alert "Please fill out Username and Password."
      Examples:
        | Page          |
        | HomePage      |
        | CartPage      |
        | ProductPage   |

    Scenario Outline: user can't sign up with existing username
      Given user already in "<Page>"
      And user click button navigation Sign Up
      And Sign Up Modal will be show
      When user filled username with "nyoman"
      And user filled password with "nyoman"
      And user click button Sign Up
      Then show alert "This user already exist."
      Examples:
        | Page          |
        | HomePage      |
        | CartPage      |
        | ProductPage   |

