Feature: Order product feature
  Background: User already pick one item and in Cart Page
    Given user already in HomScreen
    And user click first item image
    And user click button add to cart
    And show alert "Product added"
    And user click button navigation Cart in Product Page
    And user click button place order in Cart Page
    And check order modal is show

    Scenario: User can close order modal by click button close
      When user click button close in Order Modal
      Then check order modal is hide

    Scenario: User can't purchase if name and card is empty 
      When user click button purchase in Order Modal 
      Then show alert "Please fill out Name and Creditcard."

    Scenario: User can purchase with all filled input
      When user input name with "nyoman"
      And user input country with "indonesia"
      And user input city with "Bekasi"
      And user input credit card with "Mega Mega"
      And user input month with "January"
      And user input year with "1995"
      And user click button purchase in Order Modal
      Then check success purchase modal is show
      And check information in success purchase modal
      And click button OK in success purchase modal
      And check user is in Home Screen
      And user click button navigation Cart
      And check list item is empty

