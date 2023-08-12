package org.example.hw_2_cashMachine.model.money;

import org.example.hw_2_cashMachine.model.money.Currency;
import org.example.hw_2_cashMachine.model.money.CurrencyHolder;

public class Money {
    private Currency currency;
    private double value;

    public Money(String currencyName, double value) {
        this.currency = CurrencyHolder.getCurrencyByName(currencyName);
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
