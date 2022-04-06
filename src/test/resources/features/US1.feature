
Feature: US_01 As a user, I should be able to log in.
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user enters username "<username>" and password "<password>"
    And user click the login button
    Then verify the user should be at the dashboard page
    Examples:
      | username | password    |
      | User14   | Userpass123 |
      | User44   | Userpass123 |
      | User74   | Userpass123 |
      | User104  | Userpass123 |