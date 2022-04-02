@us14
Feature:  As a user, I should be able to search any item/ users from the homepage.
  Scenario: Verify users can search any files/folder/users from the search box.
    Given user on the dashboard page
    When the user clicks the magnifier icon on the right top
    And users search any "User45" existing file folder user name
    Then verify the "User45" displays the expected result option