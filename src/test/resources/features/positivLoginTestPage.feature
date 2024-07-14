Feature: site login test

  @positive
  Scenario: login to the site as a registered user
    Given user is on the main page
    When enter data a registered user
    Then we will see the Welcome message
    And log out to the main page
    Then we will see the Log in button

  Scenario Outline: login to the site as a registered user
    Given user is on the main page
    When enter data login<login> and password<password> a registered user
    Then we will see the Welcome message"<login>"
    And log out to the main page
    Then we will see the Log in button
    Examples:
       |  login  | password   |
       | GrauWolf| TraTaTa    |
       |  ZZGZGZG| KMKMNKL    |