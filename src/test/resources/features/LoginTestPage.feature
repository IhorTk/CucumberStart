Feature: site login test

  @positive
  Scenario: login with existing credentials
    Given user is on the main page
    When enter data a registered user
    Then we will see the Welcome message
    And log out to the main page
    Then we will see the Log in button

  @positive
  Scenario Outline: login with existing credentials
    Given user is on the main page
    When enter data login<login> and password<password> a registered user
    Then we will see the Welcome message"<login>"
    And log out to the main page
    Then we will see the Log in button
    Examples:
       |  login  | password   |
       | GrauWolf| TraTaTa    |
       |  ZZGZGZG| KMKMNKL    |

  @negative
  Scenario Outline: login with non-existent credentials(login)
    Given user is on the main page
    When enter data login<login> non-existent credentials and password<password> a registered user
    Then  we will see the Alertuser message"User does not exist."
    And user confirm Alert message
    Then we will see the Log in button
    Examples:
      |  login   | password   |
      | GrauWolf1| TraTaTa    |
      |  ZZGZGZG1| KMKMNKL    |

  @negative
  Scenario Outline: login with non-existent credentials(password)
    Given user is on the main page
    When enter data login<login> non-existent credentials and password<password> a registered user
    Then  we will see the Alertpassword message"Wrong password."
    And user confirm Alert message
    Then we will see the Log in button
    Examples:
      |  login   | password   |
      | GrauWolf | TraTaTa1   |
      |  ZZGZGZG | KMKMNKL1   |
