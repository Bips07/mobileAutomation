Feature: Verify login functionality

  Scenario Outline: Verify login functionality with valid credentials
    Given user is on OMR branch app login page
    When user enters "<userName>" and "<password>"
    And user clicks on login button
    Then user should be redirected to the seach page

    Examples: 
      | userName            | password   |
      | bipevstar@gmail.com | Chayowo@12 |
