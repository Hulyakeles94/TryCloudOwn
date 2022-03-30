@wip
Feature:  As a user, I should be able to search any item/ users from the homepage.
  Scenario: Verify users can search any files/folder/users from the search box.
    Given user on the dashboard page
    When the user clicks the magnifier icon on the right top
    And users search any "HulyaFileAdded" existing file folder user name
    Then verify the "HulyaFileAdded" displays the expected result option