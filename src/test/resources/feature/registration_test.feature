Feature: Registration test

  Background: User navigates to the Login page
    Given I navigate to to the Login page
    And I navigate to the Registration page

  Scenario Outline: Successful registration
    When I register with valid USER data
    Then I should get "<email validation request message>" message
    Examples:
      | email validation request message                         |
      | A fiók aktiválásához meg kell erősítened az email címet. |

  Scenario Outline: Unsuccessful registration with not matching passwords
    When I try to register with not matching USER1 passwords
    Then I should get "<alert message>" warning message
    Examples:
      | alert message              |
      | A két jelszó nem egyezik.. |

  Scenario: Unsuccessful registration with unchecked terms
    When I try to register with USER2 without checking the terms checkbox
    Then the Registration button should be disabled
