Feature: HomePage Feature

Background:
Given user has already logged in to application
|username			|password			|
|standard_user|secret_sauce	|

@accounts
Scenario: Home page Header
Given user is on Accounts page
When user gets the title of the page
Then page title should be "Swag Labs"
When user gets the header of the page
Then page header should be "PRODUCTS"

@accounts
Scenario: Menu iteams count
Given user is on Accounts page
When user clicks on Hamburger icon on the top left corner
Then user gets a list of Menu items
|ALL ITEMS|
|ABOUT|
|LOGOUT|
|RESET APP STATE|
And Menu items count should be 4