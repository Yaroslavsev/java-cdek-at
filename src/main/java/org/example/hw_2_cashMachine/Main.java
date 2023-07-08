package org.example.hw_2_cashMachine;

import org.example.hw_2_cashMachine.model.account.Account;
import org.example.hw_2_cashMachine.model.account.Principal;
import org.example.hw_2_cashMachine.model.money.Money;
import org.example.hw_2_cashMachine.model.score.CreditScore;
import org.example.hw_2_cashMachine.model.score.CurrentScore;
import org.example.hw_2_cashMachine.model.score.DebetScore;

public class Main {
    public static void main(String[] args) {
        Principal meAsBankClient = new Principal("Anton", "Yaroslavtsev", "Sergeevich", (short) 32);
        Account myBankAccount = new Account(meAsBankClient, "accountLogin", "accountPassword");
        Money myMoney = new Money("JPY", 1500.00);
        CreditScore myCreditScore = new CreditScore(myMoney, myBankAccount, 2123820);
        DebetScore myDebetScore = new DebetScore(myMoney, myBankAccount, 2123820, myCreditScore);
        CurrentScore myCurrentScore = new CurrentScore(myMoney, myBankAccount, 2123820, myDebetScore);


    }
}

/*
- Убрать Currency в package private
- Перевести строки в Енамки и убрать в пакет константы ???
- Как-то закрыть Аккаунт и\или Принципал, чтобы нельзя было создавать новые аккаунты ???
 */