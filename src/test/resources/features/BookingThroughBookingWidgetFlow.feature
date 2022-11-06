@NowBookItBooking
Feature: Make a booking through Booking Widget flow

  @BookingThroughBookingWidgetFlow
  Scenario: Booking Through Booking Widget Flow
    Given User Login to NBI application with Username and Password
    When User navigates to Admin Portal page
    And User click on Venue Name "My Pizza Shop"
    And User click on open Booking Widget
    And User should see the Booking Widget page displaying
    And User click Plus button to add "2" people
    And User select service is "FOOD TIME"
    And User select time is "8:30pm"
    And User click on Next button
    And User input detail information
      | Fields       | Values                      |
      | First Name   | zdravko                     |
      | Last Name    | stojkoski                   |
      | Mobile       | 0423845803                  |
      | Email        | zdravko.stojkoski@gmail.com |
      | Company Name | test                        |
    And User click on Book Now button
    And User back to the Restaurants detail page and click on open Restaurant button
    And User should see the Booking page displaying
    And User open created booking with name is "zdravko stojkoski, test"
    Then Users should see that the information they have entered by booking widget is displayed correctly
      | Fields       | Values                      |
      | People       | 2                           |
      | Time         | 8:30pm                      |
      | First Name   | zdravko                     |
      | Last Name    | stojkoski                   |
      | Mobile       | +61 423 845 803             |
      | Email        | ZDRAVKO.STOJKOSKI@GMAIL.COM |
      | Company Name | test                        |
    And User cancel above booking