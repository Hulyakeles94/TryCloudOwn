@wip
Feature: As a user, I should be able to write comments to files/folders.
  Scenario: Verify users to write comments to files/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And the user clicks action-icon  from any file on the page
    And user choose the "Details" option
    And user click Comment module
    And user write a "anything" comment inside the input box
    And user click the submit button to post it
    Then Verify the "anything" comment is displayed in the comment section.