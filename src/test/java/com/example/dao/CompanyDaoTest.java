package com.example.dao;

import com.example.dao.entity.Address;
import com.example.dao.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import static org.junit.Assert.*;

public class CompanyDaoTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private CompanyDao companyDao;

    @BeforeClass
    public static void beforeAllTests() throws Exception {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @AfterClass
    public static void afterAllTests() throws Exception {
        sessionFactory.close();
    }

    @Before
    public void setUp() throws Exception {
        session = sessionFactory.openSession();
        companyDao = new CompanyDao(session);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void shouldReturnZeroWhenDatabaseIsEmpty() {
        assertEquals(0, companyDao.getAll().size());
    }

    private static Company getTestCompany() {
        Company newCompany = new Company();
        newCompany.setName("Test");
        newCompany.setNip("00000");

        Address address = new Address();
        address.setZipCode("00-000");
        address.setStreet("street");
        address.setCity("Test");

        newCompany.setAddress(address);

        return newCompany;
    }

    @Test
    public void shouldAddNewCompanyToDatabase() {
        assertEquals(0, companyDao.getAll().size());

        Company newCompany = getTestCompany();

        int id = companyDao.add(newCompany);
        assertEquals(1, id);

        assertNotNull(companyDao.getById(id));
        assertEquals(1, companyDao.getAll().size());
    }

    @Test
    public void shouldRemoveCompanyFromDatabase() {
        assertEquals(0, companyDao.getAll().size());
        Company newCompany = getTestCompany();

        int id = companyDao.add(newCompany);
        assertEquals(1, companyDao.getAll().size());

        companyDao.delete(companyDao.getById(id));
        assertNull(companyDao.getById(id));
        assertEquals(0, companyDao.getAll().size());
    }

    @Test
    public void shouldUpdateCompany(){
        assertEquals(0, companyDao.getAll().size());
        Company newCompany = getTestCompany();

        int id = companyDao.add(newCompany);
        assertEquals(1, companyDao.getAll().size());

        newCompany.setNip("11111");
        companyDao.update(newCompany);

        assertEquals(newCompany.getNip(), companyDao.getById(id).getNip());
        assertEquals(1, companyDao.getAll().size());
    }
}