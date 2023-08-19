Feature: Tracing by stategies
  @strategy
  Scenario Outline: Search by valid number using strategies
    When search "<tracknumber>" in URL
    Then there is "№ <tracknumber>" on the order pane
    And has "<statusFinal>"
    Examples:
      |tracknumber|statusFinal|
      |1419098030 |Вручен|

  @strategy
  Scenario Outline: Search by valid number using strategies
    When search "<tracknumber>" in UI
    Then there is "№ <tracknumber>" on the order pane
    And has "<statusFinal>"
    Examples:
      |tracknumber|statusFinal|
      |1419098030 |Вручен|