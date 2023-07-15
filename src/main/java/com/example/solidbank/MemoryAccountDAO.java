package com.example.solidbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountList.stream()
                .filter(x -> x.getClientID().equals(clientID))
                .collect(Collectors.toList());
    }

    @Override
    public void createNewAccount(Account account) {
        this.accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        Account accountToBeUpdated = accountList.stream()
                .filter(x -> account.getId().equals(x.getId()))
                .findAny()
                .orElse(null);
        System.out.println("This feature is not represented properly in the UML diagram");
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, String accountType) {
        return this.accountList.stream()
                .filter(x -> x.getAccountType() == accountType)
                .filter(x -> x.getClientID().equals(clientID))
                .collect(Collectors.toList());
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return (AccountWithdraw) accountList.stream()
                .filter(x -> x.getClientID().equals(clientID))
                .filter(x -> x.getId().equals(accountID))
                .filter(x -> x.isWithdrawAllowed())
                .findAny()
                .orElse(null);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountList.stream()
                .filter(x -> x.getClientID().equals(clientID))
                .filter(x -> x.getId().equals(accountID))
                .findAny()
                .orElse(null);
    }
}