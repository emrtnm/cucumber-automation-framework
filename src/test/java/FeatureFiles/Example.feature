Feature: Example Feature Functionality

  @Smoke @Regression @Auth
  Scenario: Search something
    Given Enter "James Gosling" to search box
    And Click to search button
    When I should see the results