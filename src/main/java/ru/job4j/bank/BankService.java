package ru.job4j.bank;

import java.util.*;

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
        Optional<User> chk = this.findByPassport(passport);
        if (chk.isPresent()) {
            List<Account> accounts = users.get(this.findByPassport(passport).get());
            if (accounts != null && !accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользователя по номеру пасспотра
     * @param passport номер паспорта
     * @return возвращает найденого пользователя или null если не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(obj -> obj.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет получить счет по реквизитам состоящий из
     * @param passport номера пасспорта
     * @param requisite номера счет
     * @return возвращает найденый счет или null если счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> chk = this.findByPassport(passport);
        if (chk.isPresent()) {
            return users.get(this.findByPassport(passport).get())
                    .stream()
                    .filter(obj -> obj.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite).get();
        Account dstAccount = findByRequisite(destPassport, destRequisite).get();
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