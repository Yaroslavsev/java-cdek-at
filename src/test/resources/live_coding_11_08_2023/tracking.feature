Feature: Tracing

  Scenario Outline: Search by valid number
    Given anonymous on the "tracking" page
    When enter "<tracknumber>" to the search pane
    And tap track
    Then there is "№ <tracknumber>" on the order pane
    And has "<statusLabel>"
    And order was in CREATED status
    And order was in IN PROGRESS status
    And order was in ISSUED FOR DELIVERY status
    And order was in HANDED OVER status
    Examples:
      | tracknumber | statusLabel |
      | 1419098030  | Вручен      |

  Scenario Outline: Search by invalid number
    Given anonymous on the "tracking" page
    When enter "<invalidTrackNumber>" to the search pane
    And tap track
    Then there is "Error. Order not found" message
    Examples:
      | invalidTrackNumber |
      | 1991114488         |