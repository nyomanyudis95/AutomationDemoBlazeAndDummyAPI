Feature: User can select, add to cart, and delete of product feature
  Background: User already click first item in Home Screen and go to Product Page
    Given user already in HomScreen

    Scenario: user can select first product name to Product Page
      When user click first item name
      And check user is in Product Page
      And check product information must be same with previous selected item

    Scenario: user can select first product image to Product Page
      When user click first item image
      And check user is in Product Page
      And check product information must be same with previous selected item

    Scenario: User can add product to cart by click button add to cart
      Given user click first item image
      And user click button add to cart
      And show alert "Product added"
      When user click button navigation Cart in Product Page
      Then check item is in table products

    Scenario: User can delete product in Cart Page
      Given user click first item image
      And user click button add to cart
      And show alert "Product added"
      And user click button navigation Cart in Product Page
      When user click button delete in first item
      Then check list item is empty


