@SwagLabs
@Login
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "standard_user" and password "secret_sauce"
    Then the user verify Products after logging in

  Scenario: Successful login with invalid credentials
    Given the user is on the login page
    When the user enters username "error_user" and password "error_pass"
    Then an error message container should be displayed