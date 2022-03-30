Feature: As a user, I should be able to delete a file/folder.
  Scenario: Verify users delete a file/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And the user clicks the add icon on the top
    And user choose the "Delete" option
    When the user clicks the "Deleted files" sub-module
    Then Verify the deleted file is displayed on the page.