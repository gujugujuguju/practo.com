Feature: Finding doctors records
@sanity @regression
  Scenario: Successful getting names of doctors
    Given user is on practo.com website.
    And verifying the logo of webpage.
    When user clicks the location box and clears existing data.
    And enters required location.
    And clicks the search box to type Dermatologist doctors.
    Then the page starts to search for records of doctors who are Dermatologist and its displayed.
    And applying filters for Patient Stories, Experience, Fees, Availability and any one Sorting.
    And Fetch & display the first five Doctor details.
@sanity
   Scenario: Successful retreival of popular surgeries
    Given user navigate to surgeries section.
    When scrolls the page.
    Then user gets a list of popular surgery and prints it.
@sanity @regression
   Scenario: Unsuccessful demo booking with invalid inputs(email)
   Given user navigates to Health & Wellness Plan under For Corporates section.
   When user enters all the fields with invalid email input.
   Then Schedule a demo button is disabled and user tries to clicks it but it will not work.
   And Print test failed successfully in the console and clears all inputs.
@sanity @regression
   Scenario: Successful demo booking with valid inputs
   Given user is on Health & Wellness Plan under For Corporates section.
   When user enters all the fields with valid inputs.
   Then Schedule a demo button is enabled and user clicks it.
   And Thank you message is printed.
   
