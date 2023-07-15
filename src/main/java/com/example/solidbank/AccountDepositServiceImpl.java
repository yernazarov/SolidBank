package com.example.solidbank;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance()+amount);
    }
}