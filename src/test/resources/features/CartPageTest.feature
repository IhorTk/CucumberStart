@ignored
Feature: Cart Page management

  @positive
  Scenario Outline: Adding one product to cart
    Given The user is on the main page
    When Sort products into '<group>'
    And Add to cart  '<title>'.
    Then Go to cart
    And Check that the '<title>' has been added to the cart and the <price> is correct

    Examples:
      | group    | title             | price |
      | Phones   | Samsung galaxy s7 | 800   |
      | Laptops  | MacBook Pro       | 1100  |
      | Monitors | Apple monitor 24  | 400   |

  @positive
  Scenario: Adding multiple product to cart
    Given The user is on the main page
    When The user takes turns adding product to the cart
      | group    | title             | price |
      | Phones   | Samsung galaxy s7 | 800   |
      | Laptops  | MacBook Pro       | 1100  |
      | Monitors | Apple monitor 24  | 400   |
    Then Go to cart
    And Check sure all items in your cart and total price is correct
      | group    | title             | price |
      | Phones   | Samsung galaxy s7 | 800   |
      | Laptops  | MacBook Pro       | 1100  |
      | Monitors | Apple monitor 24  | 400   |

  @positive
  Scenario: Remove product from cart
    Given The user is on the main page
    When The user takes turns adding product to the cart
      | group    | title             | price |
      | Laptops  | MacBook Pro       | 1100  |
      | Phones   | Samsung galaxy s7 | 800   |
      | Monitors | Apple monitor 24  | 400   |
    Then Go to cart
    Then Remove one item from cart "Apple monitor 24"
    And Check sure all items in your cart and total price is correct
      | group    | title             | price |
      | Laptops  | MacBook Pro       | 1100  |
      | Phones   | Samsung galaxy s7 | 800   |
