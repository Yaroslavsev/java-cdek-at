package org.example.hw_2_cashMachine.model.constants;

public class Constants {
    public final double WITHDRAWAL_LIMIT = 30000.00;
    public final double AMOUNT_REASON_FOR_CASHBACK = 1000000.00;
    public final double CASHBACK_AMOUNT = 2000.00;
    public final double DEBET_SCORE_OPERATIONS_BLOCK_LIMIT = -20000.00;

    public double getWITHDRAWAL_LIMIT() {
        return WITHDRAWAL_LIMIT;
    }

    public double getAMOUNT_REASON_FOR_CASHBACK() {
        return AMOUNT_REASON_FOR_CASHBACK;
    }

    public double getCASHBACK_AMOUNT() {
        return CASHBACK_AMOUNT;
    }

    public double getDEBET_SCORE_OPERATIONS_BLOCK_LIMIT() {
        return DEBET_SCORE_OPERATIONS_BLOCK_LIMIT;
    }
}
