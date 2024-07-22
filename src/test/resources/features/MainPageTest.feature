
Feature: Main page management

  @positive
  Scenario: Checking the amount of products on the main page
    Given The user is on the main page
    When The amount of products on the main page should be 9

  @positive
  Scenario: Checking the amount of products on the site
    Given The user is on the main page
    When counting products by moving through pages, there should be 15 of them

  @positive
  Scenario Outline: Checking the quantity of goods on the site by group
    Given The user is on the main page
    When sorting products by group<group>, there should be <amount> of them
    Examples:
      | group     | amount  |
      | Phones    |  7      |
      | Laptops   |  6      |
      | Monitors  |  2      |
