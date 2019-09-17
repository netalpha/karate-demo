Feature: create a customer

  Background:
    * url baseUrl

  Scenario: create a customer
    Given path '/customer'
    And request { "name": "jay"}
    When method POST
    Then status 200

  Scenario Outline: create a customer with table
    Given path '/customer'
    And request { "name": <name> }
    When method POST
    Then status 200
    Examples:
    |name |
    | a   |
    | b   |
#
#  Scenario: create a customer with faker data
#    Given path '/customer'
#    And request fakerCustomer
#    When method POST
#    Then status 200
