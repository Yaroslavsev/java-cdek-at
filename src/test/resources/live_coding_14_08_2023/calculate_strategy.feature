Feature: Calculate services

  Scenario Outline: Calculate order delivery
    When calculate order delivery FROM Moscow TO Novosibirsk and PACKAGE SIZE is Envelope
    Then service price is "<price>"
    Examples:
      | price |
      | 970 ₽ |

  Scenario Outline: Calculate courier call
    When calculate courier call FROM Moscow TO Novosibirsk and PACKAGE SIZE is Envelope
    Then service price is "<price>"
    Examples:
      | price  |
      | 1135 ₽ |