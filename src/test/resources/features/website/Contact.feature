@web @Contact
Feature: Test All feature in Contact Modal Page
   Scenario Outline: User can close contact modal with btn close
     Given user already in "<Page>"
     And user click button navigation Contact
     And Contact Modal will be show
      When user click button close in contact modal
      Then contact modal is hide
     Examples:
       | Page          |
       | HomePage      |
       | CartPage      |
       | ProductPage   |

    Scenario Outline: User can send message with valid email, contact, and message
      Given user already in "<Page>"
      And user click button navigation Contact
      And Contact Modal will be show
      When user input email in Contact Modal with "nyoman@mailinator.com"
      And user input contact name in Contact Modal with "nyoman"
      And user input message in Contact Modal with "Please check again"
      And user click button Send in Contact Modal
      Then show alert "Thanks for the message!!"
      Examples:
        | Page          |
        | HomePage      |
        | CartPage      |
        | ProductPage   |