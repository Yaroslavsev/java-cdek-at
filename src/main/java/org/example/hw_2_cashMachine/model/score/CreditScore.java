package org.example.hw_2_cashMachine.model.score;

import org.example.hw_2_cashMachine.model.money.Money;
import org.example.hw_2_cashMachine.model.account.Account;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    protected boolean checkBefore(Money money){
        return true;
    };
}
