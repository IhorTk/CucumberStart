Feature: Cart Page management

  Scenario Outline: Adding one product to cart
    Given The user is on the main page
    When Sort products into '<group>'
    And Add to cart  '<product>'.
    Then Go to cart
    And Check that the '<product>' has been added to the cart and the <price> is correct

    Examples:
      | group    | product           | price |
      | Phones   | Samsung galaxy s7 | 800   |
      | Laptops  | MacBook Pro       | 1100  |
      | Monitors | Apple monitor 24  | 400   |

#  Scenario Outline: Adding multiple product to cart
#    Given The user is on the main page
#    When The user takes turns finding '<product>' by '<group>' and adding them to the cart
#    Then Go to cart
#    And Check that  all '<product>' has been added to the cart and the <price> is correct
#
#    Examples:
#      | group    | product           | price |
#      | Phones   | Samsung galaxy s7 | 800   |
#      | Laptops  | MacBook Pro       | 1100  |
#      | Monitors | Apple monitor 24  | 400   |