package org.example.hw_2_cashMachine.model.money;

public interface MoneyInterface {
    void addMoney(Money money);

    Money getMoney(double balanceLess);

    Money getMoneyWithoutLess();
}
