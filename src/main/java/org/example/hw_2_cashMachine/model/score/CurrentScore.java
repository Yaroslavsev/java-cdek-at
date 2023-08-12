package org.example.hw_2_cashMachine.model.score;

import org.example.hw_2_cashMachine.model.constants.Constants;
import org.example.hw_2_cashMachine.model.money.Money;
import org.example.hw_2_cashMachine.model.account.Account;

public class CurrentScore extends Score {
    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }

    @Override
    protected boolean checkBefore(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        if (usdValueIn > constants.getAMOUNT_REASON_FOR_CASHBACK()){
            this.debetScore.addMoney(new Money("USD", constants.getCASHBACK_AMOUNT()));
        }
        return true;
    }
}
