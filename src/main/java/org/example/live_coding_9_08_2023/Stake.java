package org.example.live_coding_9_08_2023;

import java.util.Objects;

public class Stake {
    private String owner;
    private Long gameId;
    private String result;
    private double sum;
    private float koef;

    public Stake(String owner, Long gameId, String result, double sum, float koef) {
        this.owner = owner;
        this.gameId = gameId;
        this.result = result;
        this.sum = sum;
        this.koef = koef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stake stake = (Stake) o;
        return Double.compare(stake.sum, sum) == 0 && Float.compare(stake.koef, koef) == 0 && Objects.equals(owner, stake.owner) && Objects.equals(gameId, stake.gameId) && Objects.equals(result, stake.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, gameId, result, sum, koef);
    }

    public float getKoef() {
        return koef;
    }

    public void setKoef(float koef) {
        this.koef = koef;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Stake{" +
                "owner='" + owner + '\'' +
                ", gameId=" + gameId +
                ", result='" + result + '\'' +
                ", sum=" + sum +
                '}';
    }
}