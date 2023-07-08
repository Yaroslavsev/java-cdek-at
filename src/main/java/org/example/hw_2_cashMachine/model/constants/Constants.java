package org.example.hw_2_cashMachine.model.constants;

public class Constants {
    public final int WITHDRAWAL_LIMIT = 30000;
    public final int AMOUNT_REASON_FOR_CASHBACK = 1000000;
    public final double CASHBACK_AMOUNT = 2000;
    public final int DEBET_SCORE_OPERATIONS_BLOCK_LIMIT = -20000;

    public int getWITHDRAWAL_LIMIT() {
        return WITHDRAWAL_LIMIT;
    }

    public int getAMOUNT_REASON_FOR_CASHBACK() {
        return AMOUNT_REASON_FOR_CASHBACK;
    }

    public double getCASHBACK_AMOUNT() {
        return CASHBACK_AMOUNT;
    }

    public int getDEBET_SCORE_OPERATIONS_BLOCK_LIMIT() {
        return DEBET_SCORE_OPERATIONS_BLOCK_LIMIT;
    }
}
