Feature: CustomerID

  Scenario: End to end flow of customer create Get and delete request.

    Given I have created customer through Post method
    When i retrieve the above created customer for confirmation
    Then I should be able to delete it.