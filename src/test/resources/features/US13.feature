@wip
Feature: As a user, I should be able to view the contact list.

Scenario:  verify users can see all the contact names on the contact list
Given user on the dashboard page
When the user clicks the "Contacts" module
Then verify the contact names are in the list

#(Pre-condition: there should be at least 2 contact names are displayed
#On the contact list so that view list function can be tested)