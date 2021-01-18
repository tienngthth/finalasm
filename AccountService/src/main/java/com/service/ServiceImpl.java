package com.service;

import com.DAO.DAOInterface;
import com.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    private final DAOInterface DAO;

    @Autowired
    public ServiceImpl(@Qualifier("DAOImpl") DAOInterface DAO){
        this.DAO = DAO;
    }

    @Override
    @Transactional
    public Account create(Account account) {
        return DAO.save(account);
    }

    @Override
    @Transactional
    public List<Account> find(Account account, int startAt, int maxResults) {
        return DAO.find(account, startAt, maxResults);
    }

    @Override
    @Transactional
    public List<Account> getAll(int startAt, int maxResults) {
        return DAO.getAll(startAt, maxResults);
    }

    @Override
    @Transactional
    public Account update(Account account)  {
        Account currentAccount = findById(account.getId());
        if (currentAccount != null) {
            return DAO.save(account);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public String delete(int id) {
        Account currentAccount = findById(id);
        if (currentAccount != null) {
            DAO.delete(id);
            return "Deleted";
        } else {
            return "Id not found";
        }
    }

    @Override
    @Transactional
    public Account findById(int id) {
        return DAO.findById(id);
    }

}
