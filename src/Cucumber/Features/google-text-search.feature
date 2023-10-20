Feature: Google search

  Scenario Outline: User can search any keyword

    Given an open browser with google.com
    When a keyword <keyword> is entered in input field
    And search button is clicked
    Then the first one should contain <expectedSearchText>
    And close browser

    Examples:
      | keyword   | expectedSearchText |
      | selenium  | selenium           |
      | wikipedia | wikipedia          |