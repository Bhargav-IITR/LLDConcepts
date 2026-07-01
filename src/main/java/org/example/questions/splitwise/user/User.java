package org.example.questions.splitwise.user;

import org.example.questions.splitwise.balanceSheet.BalanceSheet;

public class User {
    String userId;
    String userName;

    BalanceSheet balanceSheet;

    public User(String id, String name){
        this.userId = id;
        this.userName = name;
        balanceSheet = new BalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
}
