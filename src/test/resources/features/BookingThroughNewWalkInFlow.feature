@NowBookItBooking
Feature: Make a booking through New Walk in flow

  @BookingThroughNewWalkInFlow
  Scenario: Booking Through New Walk In Flow
    Given User Login to NBI application with Username and Password
    When User navigates to Admin Portal page
    And User click on Venue Name "My Pizza Shop"
    And User click on open Restaurant button
    And User should see the Booking page displaying
    And User click on New Walk In button
    And User select table option is "T1"
    And User click on Customer Walk in tab and input Name is "Joes"
    And User input Booking note is "Test"
    And User click on Save button
    And User open created booking with name is "Joes"
    Then Users should see that the information they have entered is displayed correctly
      | Fields        | Values           |
      | Table         | T1 * C21 outside |
      | Booking Notes | Test             |
      | Detail Name   | Joes             |
    And User cancel above booking