@smoke
Feature: Testing the Users features on the GoRest application

  Scenario:Create a new user & verify if the user is added
    When I create a new user by providing the information name email gender and status
    Then I verify that the new user is created

  Scenario:Updating the user created and verify it is updated with status 200
    When I update the store with name email gender and status
    Then I verify that the user information is updated

  Scenario:Deleting the user created and verify it is deleted
    When I delete the user created with id
    Then I verify that the user is deleted and get the status 204