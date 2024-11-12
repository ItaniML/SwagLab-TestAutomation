@SwagLabs
@Purchase
Feature: Checkout

  Scenario Outline: Complete a purchase
    Given the user is on the login page
    And the user enters username "standard_user" and password "secret_sauce"
    Then the user verify Products after logging in
    And the user selects an "<item>"
    And the user adds an item to the cart
    And the user clicks on cart icon
    Then the item should be visible in the cart
    When the user proceeds to checkout
    And enters shipping information "<name>", "<last name>" and "<zip code>"
    And completes the checkout process
    Then the order confirmation should be displayed "Checkout: Overview", "Payment Information:" and "Price Total"
    And the user clicks on finish button
    Then the user validate "Checkout: Complete!" page
    Examples:
      | name     | last name | zip code | item                |
      | TestName | LastName  | 0124     | Sauce Labs Backpack |