package org.example.live_coding_9_08_2023;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BetCalculator {
    private static Set<Stake> stakeSet = new HashSet<>();

    public static void addStake(Stake stake) {
        stakeSet.add(stake);
    }

    public static List<String> getWinners(final long gameId, String result) {
        return
                stakeSet.stream()
                        .filter(stake -> stake.getGameId().equals(gameId))
                        .filter(stake -> stake.getResult().equals(result))
                        .map(stake -> stake.getOwner())
                        .collect(Collectors.toList());
    }

    public static List<String> getLosers(final long gameId, String result) {
        return
                stakeSet.stream()
                        .filter(stake -> stake.getGameId().equals(gameId))
                        .filter(stake -> !stake.getResult().equals(result))
                        .map(stake -> stake.getOwner())
                        .collect(Collectors.toList());
    }
}
