
Feature: Placing and confirming an order

  @positive
  Scenario Outline: Normal placing and confirming an order
    Given The user is on the main page
    When Sort products into '<group>'
    And Add to cart '<title>'.
    Then Go to cart
    When The user go to place order page
    And The user enters test data to place an order
      | name     | country       | city   | card                | month | year |
      | Moriarty | Great Britain | London | 4552 3689 7526 8990 | 05    | 2030 |
    And  confirms the entered data
    Then Check that the data is correct and amount is '<price>'
    And The user confirms order
    And The user is on the main page

    Examples:
      | group   | title       | price |
      | Laptops | MacBook Pro | 1100  |


    @positive
  Scenario Outline: Placing an order when entering incomplete data
    Given The user is on the main page
    When Sort products into '<group>'
    And Add to cart '<title>'.
    Then Go to cart
    When The user go to place order page
    And The user enters incomplete test data to place an order
      | country       | city   | month | year |
      | Great Britain | London | 05    | 2030 |
    And confirms the entered data
    Then The user will see the error message "alertPlaceOrder"
    And The user confirm Alert message

    Examples:
      | group   | title       |
      | Laptops | MacBook Pro |
