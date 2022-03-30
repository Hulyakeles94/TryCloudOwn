
Feature: As a user, I should be able to update settings.

Scenario: Verify users update settings
Given user on the dashboard page
When the user clicks the "Files" module
And user clicks "Settings" dropdown module
Then the user should be able to click any buttons

Scenario: Verify users to see the app storage usage
Given user on the dashboard page
When the user clicks the "Files" module
And user checks the current storage usage
And user  uploads file with the upload file option
And user refresh the page
Then the user should be able to see storage usage is increased