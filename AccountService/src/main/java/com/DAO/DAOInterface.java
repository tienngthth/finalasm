package com.DAO;

import com.model.Account;
import java.util.List;

public interface DAOInterface {

    List<Account> getAll(int startAt, int maxResults);

    Account findById(int id);

    List<Account> find(Account account, int startAt, int maxResults);

    Account save(Account account);

    void delete(int id);
}
