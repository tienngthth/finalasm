package com.DAO;

import com.model.Account;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Qualifier("DAOImpl")
public class DaoImpl implements DAOInterface {

    private final EntityManager entityManager;

    @Autowired
    public DaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    private Query createQuery(String stringQuery) {
        return (Query) entityManager.createQuery(stringQuery);
    }

    @Override
    public List<Account> getAll(int startAt, int maxResults){
        Query query = createQuery("FROM Account ORDER BY id")
                        .setFirstResult(startAt)
                        .setMaxResults(maxResults);
        return query.getResultList();
    }

    @Override
    public Account findById(int id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> find(Account account, int startAt, int maxResults) {
        String queryString =
                " FROM Account WHERE " +
                " age = :age AND " +
                " dob = :dob AND " +
                " name LIKE :name ";
        Query query = createQuery(queryString)
                .setParameter("age", account.getAge())
                .setParameter("dob", account.getDob())
                .setParameter("name","%" + account.getName() + "%")
                .setFirstResult(startAt)
                .setMaxResults(maxResults);
        return query.getResultList();
    }

    @Override
    public Account save(Account account) {
        return entityManager.merge(account);
    }

    @Override
    public void delete(int id) {
        Query query = createQuery("delete from Account where id=:id").setParameter("id", id);
        query.executeUpdate();
    }
}
