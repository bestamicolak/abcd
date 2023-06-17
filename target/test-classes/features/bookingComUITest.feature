Feature: Booking.com
  @smoke
  Scenario Outline: Flow of a flight reservation
    Given user launch the browser and enter the web page "https://www.booking.com/"
    When the user clicks on flights option
    Then user verifies the page title
    And user chooses a one way trip for from "Heathrow" to "Istanbul" for "2023-07-15" and clicks search button
    Then user verifies the flights are shown
    And user clicks on See flight option
    Then user verifies the flight details
    And user clicks on select button and
    Then user verifies the title as "London to Istanbul"
    And user fills the "<ContactEmail>" "<PhoneNumber>" "<FirstName>" "<LastName>" "<Gender>" and date of birth and click to Next button
    And user clicks on next button
    Then user verifies the payment page title
    And user closes the browser


    Examples: Data
    |ContactEmail |PhoneNumber|FirstName|LastName|Gender|
    |sag@gmail.com|7552551515 |Sag      |Saglim  |Male  |




