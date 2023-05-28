package com.example.solidbank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Account {
    private String accountType;
    private String id;
    private String clientID;
    private double balance;
    protected boolean withdrawAllowed; //was changed to protected to implement the abstraction
    public double getBalance = this.balance;
    public String toString() { //this is defined as parameter in UML, but it is impossible for immutable object as String
        //to be constantly changing (because of the balance) parameter, so I changed it to method
        return String.format("Account{accountType=%s, id='%s', clientID='%s', balance=%.1f}", accountType, id, clientID, balance);
    }

    public Account(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }
}
