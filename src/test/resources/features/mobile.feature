Feature: Testing the HS18 Mobile App

Scenario: Test for adding profile
Given I am able to access the MedHelper Dashboard
When I swipe down to click on profiles
And I click on addProfiles
And I enter "hello" in first_name
And I click on info_tab
And I click on date_button
And I set date as "20 Jan 2013"
And I click on save
Then I should see the profile created

