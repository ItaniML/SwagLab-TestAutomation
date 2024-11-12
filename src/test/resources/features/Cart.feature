@SwagLabs
@ShoppingCart
Feature: Shopping Cart

  Scenario Outline: Add and Remove an item to the cart
    Given the user is on the login page
    And the user enters username "standard_user" and password "secret_sauce"
    Then the user verify Products after logging in
    And the user selects an "<item>"
    And the user adds an item to the cart
    And the user clicks on cart icon
    Then the item should be visible in the cart
    And the removes an item from the
    Then user verify that the item is removed
    Examples:
      | item                |
      | Sauce Labs Backpack |