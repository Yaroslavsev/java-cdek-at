package live_coding_9_08_2023;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.live_coding_9_08_2023.BetCalculator;
import org.example.live_coding_9_08_2023.Stake;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BettingSteps {

    private static List<String> winners = new ArrayList<>();
    private static List<String> losers = new ArrayList<>();

    @Given("^([^\"]*) have (\\d+) dollars stake for (\\d+) id game for result ([^\"]*)$")
    public void givenStartStakeCondition(String ownerName, int stakeBalance, long gameId, String result) {
        BetCalculator.addStake(new Stake(ownerName, gameId, result, stakeBalance, 1));
    }

    @When("^game (\\d+) id ends with ([^\"]*) result")
    public void whenSomeGameEndsWithResult(long gameId, String result) {
        winners.addAll(BetCalculator.getWinners(gameId, result));
        losers.addAll(BetCalculator.getLosers(gameId, result));
    }

    @Then("^([^\"]*) contains in winners")
    public void checkWinnerForGame(String stakeOwner) {
        assertTrue(winners.contains(stakeOwner));
    }

    @Then("^([^\"]*) miss in winners$")
    public void checkLossersForGame(String stakeOwner) {
        assertFalse(winners.contains(stakeOwner));
    }

    @Then("^([^\"]*) contains in winners and losers$")
    public void checkWinnersAndLosersForGame(String stakeOwner){
        assertTrue(winners.contains(stakeOwner));
        assertTrue(losers.contains(stakeOwner));
    }
}
