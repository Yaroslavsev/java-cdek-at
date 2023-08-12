package org.example.hw_2_cashMachine.model.score;

import org.example.hw_2_cashMachine.model.constants.Constants;
import org.example.hw_2_cashMachine.model.money.Money;
import org.example.hw_2_cashMachine.model.account.Account;

public class DebetScore extends Score {
    private CreditScore creditScore;

    public DebetScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    @Override
    protected boolean checkBefore(Money money) {
        if (this.creditScore.getBalance().getValue() > constants.getDEBET_SCORE_OPERATIONS_BLOCK_LIMIT()){
            return true;
        } else {
            System.out.println("Credit score is less than -20000. Debit score operation is not allowed");
            return false;
        }
    }
}
