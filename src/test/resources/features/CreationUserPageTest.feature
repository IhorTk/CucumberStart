Feature: New User Registration

  @negative
  Scenario Outline: try to register an existing user
    Given The user is on the main page
    When press to button Sign up
    And When enter data login<login> and password<password> a registered user
    Then  The user will see the error registration message "alertNewUserNo"
    And The user confirm Alert message

    Examples:
      |  login  | password   |
      | GrauWolf| TraTaTa    |
      |  ZZGZGZG| KMKMNKL    |
