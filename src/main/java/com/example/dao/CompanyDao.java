package com.example.dao;

import com.example.dao.entity.Company;
import org.hibernate.Session;

import java.util.List;

public class CompanyDao implements Dao<Company>{
    private Session session;

    public CompanyDao(Session session) {
        this.session = session;
    }

    @Override
    public int add(Company company){
        return (int) session.save(company);
    }

    @Override
    public void delete(Company company) {
        session.delete(company);
    }

    @Override
    public void update(Company company) {
        session.update(company);
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
