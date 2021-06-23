package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс описывает работу простеших банковских операций
 * @author OLEG ZHV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов и их счетов осуществляется в коллекции типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавлять новых клиентов, при этом счет будет пустым типа List
     * @param user новый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить новый счет к существующему пользователю
     * Для этого используем метод findByPassport получаем пользователя и
     * если пользователь существует и счета еще нет добавляем новый
     * @param passport номер паспорта
     * @param account добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        List<Account> accounts = users.get(this.findByPassport(passport));
        if (accounts != null && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод позволяет найти пользователя по номеру пасспотра
     * @param passport номер паспорта
     * @return возвращает найденого пользователя или null если не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(obj -> obj.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет получить счет по реквизитам состоящий из
     * @param passport номера пасспорта
     * @param requisite номера счет
     * @return возвращает найденый счет или null если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
//        Account rsl = null;
//        List<Account> accounts = users.get(this.findByPassport(passport));
//        if (accounts != null) {
//            for (Account account : accounts) {
//                if (account.getRequisite().equals(requisite)) {
//                    rsl = account;
//                    break;
//                }
//            }
//        }
        List<Account> accounts = users.get(this.findByPassport(passport));
        if (accounts != null) {
            return users.get(this.findByPassport(passport))
                    .stream()
                    .filter(obj -> obj.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет осуществить перевод средств с одно счета на другой
     * @param srcPassport номер паспорта отправителя
     * @param destPassport номер паспорта получателя
     * @param srcRequisite номер счета для отправления
     * @param destRequisite номер счета для зачисления
     * @param amount сумма перевода
     * @return возвращает true если операция выполнена успешно и false если нет
     */
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