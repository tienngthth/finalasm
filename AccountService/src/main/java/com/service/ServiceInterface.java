package com.service;

import com.model.Account;

import java.util.List;

public interface ServiceInterface {

    Account create(Account account);

    List<Account> getAll(int startAt, int maxResults);

    Account findById(int id);

    List<Account> find(Account account, int startAt, int maxResults);

    Account update(Account account);

    String delete(int id);
}
