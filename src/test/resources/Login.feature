Feature: Login

  As a Swag Labs customer
  I want to log in to the platform
  In order to do some shopping

  Background:
    Given I am on Login page

  Scenario: Login with valid credentials
    When I enter valid username and password
    Then I should be redirected to Products page


  Scenario: Login with invalid credentials
    When I enter invalid username and password
    Then I should see error message