package com.example;

import com.example.dao.CompanyDao;
import com.example.dao.entity.Address;
import com.example.dao.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        CompanyDao companyDao = new CompanyDao(session);

        companyDao.getAll().forEach(System.out::println);
        System.out.println("------");
        System.out.println(companyDao.getById(1));
        System.out.println("------");

        Company temp = new Company();
        temp.setName("test");
        temp.setNip("000000");
        Address tempAddress = new Address();
        tempAddress.setCity("Krakow");
        tempAddress.setStreet("testowa");
        tempAddress.setZipCode("00-000");
        temp.setAddress(tempAddress);

        int id = companyDao.add(temp);
        System.out.println(companyDao.getById(id));
        System.out.println("------");

        temp.setName("test2");
        session.save(temp);

        System.out.println(companyDao.getById(temp.getId()));
        System.out.println("------");

        companyDao.delete(temp);
        System.out.println(companyDao.getById(id));

        session.close();
        sessionFactory.close();
    }
}
