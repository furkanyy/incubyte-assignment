Feature: User Authentication

  Scenario: Successful user sign-up

    # Sign Up
    Given the user is on the sign-up page
    When the user fills the required fields
    And the user clicks on the create an account button
    Then the user should be redirected to the my account page

  Scenario: Successful user sign-in
    # Sign In
    Given the user is on the sign-in page
    When the user enters a valid credentials
    And the user clicks on the sign in button
    Then the user should be redirected to the my account page 