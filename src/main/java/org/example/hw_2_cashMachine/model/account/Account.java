package org.example.hw_2_cashMachine.model.account;

import org.example.hw_2_cashMachine.model.score.Score;

import java.util.HashMap;

public class Account {
    private Principal principal;
    private String login;
    private String password;
    private HashMap<Integer, Score> scoreMap;

    public Account(Principal principal, String login, String password) {
        this.principal = principal;
        this.login = login;
        this.password = password;
        scoreMap = new HashMap<Integer, Score>();
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Integer, Score> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(HashMap<Integer, Score> scoreMap) {
        this.scoreMap = scoreMap;
    }
}
