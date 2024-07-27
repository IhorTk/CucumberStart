
Feature: Verifying site login credentials

  @positive
  Scenario Outline: login with existing credentials
    Given The user is on the main page
    When enter data login'<login>' and password '<password>'
    Then The user will see the Welcome message '<login>'
    And log out to the main page
    Then The user can see the Log in button
    Examples:
      |  login  | password   |
      | GrauWolf| TraTaTa    |
      |  ZZGZGZG| KMKMNKL    |

  @negative
  Scenario Outline: login with non-existent credentials(login)
    Given The user is on the main page
    When enter data login'<login>' and password '<password>'
    Then The user will see the error message "alertNotUserExist"
    And The user confirm Alert message

    Examples:
      |  login   | password   |
      | GrauWolf1| TraTaTa    |
      |  ZZGZGZG1| KMKMNKL    |

  @negative
  Scenario Outline: login with non-existent credentials(password)
    Given The user is on the main page
    When enter data login'<login>' and password '<password>'
    Then The user will see the error message "alertWrongPassword"
    And The user confirm Alert message

    Examples:
      |  login   | password   |
      | GrauWolf | TraTaTa1   |
      |  ZZGZGZG | KMKMNKL1   |


