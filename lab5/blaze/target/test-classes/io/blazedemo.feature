Feature: Flight reservation
  Allow a user to make a flight reservation with web automation.

  Scenario: Reserve a flight in Blazedemo
    When Access "https://blazedemo.com"
    And Select "Portland" as departure
    And Select "Dublin" as destination
    And Click find flights
    And the page title should be Flights from "Portland" to "Dublin":
    And Press Choose This Flight
    And Check reservation info
    And Fill the form
    Then Check purchase info