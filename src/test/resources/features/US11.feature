@wip
Feature: As a user, I should be able to access to Talks module
  Scenario: verify users to access to Talks module
    Given user on the dashboard page
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud"
  Scenario: verify users to send a message
    Given user on the dashboard page
    When the user clicks the "Talk" module
    And user search user "User45" from the search box
    And user write "Test" message
    And user clicks to submit button
    Then the user should be able to see the "Test" message is displayed on the conversation log