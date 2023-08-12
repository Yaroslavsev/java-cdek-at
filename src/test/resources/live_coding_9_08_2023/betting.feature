Feature: Get winner calculation for group of stakes

  Scenario: I am single winner of the game
    Given i have 100 dollars stake for 777 id game for result 1:1
    When game 777 id ends with 1:1 result
    Then i contains in winners

  Scenario: I am single loser of the game
    Given i have 100 dollars stake for 777 id game for result 1:0
    When game 777 id ends with 5:2 result
    Then i miss in winners

  Scenario: I've made winning and losing bets
    Given i have 100 dollars stake for 333 id game for result 3:3
    And i have 100 dollars stake for 555 id game for result 5:5
    When game 333 id ends with 3:3 result
    And game 555 id ends with 0:0 result
    Then i contains in winners and losers