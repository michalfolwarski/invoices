package com.example.dao;

import com.example.dao.entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDao implements Dao<Company>{
    private Session session;

    public CompanyDao(Session session) {
        this.session = session;
    }

    @Override
    public int add(Company company){
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(company);
        transaction.commit();
        return id;
    }

    @Override
    public void delete(Company company) {
        Transaction transaction = session.beginTransaction();
        session.delete(company);
        transaction.commit();
    }

    @Override
    public void update(Company company) {
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
    }

    @Override
    public Company getById(int id) {
        return session.get(Company.class, id);
    }

    @Override
    public List<Company> getAll() {
        return session.createQuery("from Company", Company.class).getResultList();
    }
}
