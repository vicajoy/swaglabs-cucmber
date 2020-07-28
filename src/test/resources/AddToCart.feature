Feature: Add products to cart

  As a Swag Labs customer
  I want to add products to my cart
  In order to buy them

  Background:
    Given I am on Products page

  Scenario: Cart badge count changes when adding a product to cart
    When I add an item to cart
    Then cart badge count is "1"

  Scenario: Product is available in cart when adding it to the cart
    When I add an item to cart
    Then I can see it in the cart

  Scenario: When removing the last item, cart badge count disappears
    Given I add an item to cart
    When I remove the item from cart
    Then cart badge count disappears