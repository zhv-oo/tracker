package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = users.get(this.findByPassport(passport));
        if (accounts != null && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (Map.Entry<User, List<Account>> tmp: users.entrySet()) {
            if (tmp.getKey().getPassport().equals(passport)) {
                rsl = tmp.getKey();
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        List<Account> accounts = users.get(this.findByPassport(passport));
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account dstAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && srcAccount.getBalance() >= amount
                && dstAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            dstAccount.setBalance(dstAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}