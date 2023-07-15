package com.example.solidbank;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        account.setBalance(account.getBalance()-amount);
    }
}