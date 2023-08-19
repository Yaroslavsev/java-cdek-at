Feature: Tracing
  Scenario Outline: Search by valid number
    Given anonimous on the "tracking" page
    When enter "<tracknumber>" to the search pane
    And tap track
    Then there is "№ <tracknumber>" on the order pane
    And has "<statusFinal>"
    Examples:
      |tracknumber|statusFinal|
      |1419098030 |Вручен|