package Util.SQLConnection;


import Util.Company;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class ManageCompany{
    private static SessionFactory factory;
    public static List<Company> listCompany( ){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List companies = session.createQuery("FROM Company ").list();
            for (Iterator iterator =companies.iterator(); iterator.hasNext();){
                Company company = (Company) iterator.next();
//                System.out.println(company);
            }
            return companies;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
    public static Company getCompany(int id) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        Company company = null;
        try {
            tx = session.beginTransaction();
            String str = "FROM Company";
            List companies = session.createQuery(str + id).list();
            for (Iterator iterator = companies.iterator(); iterator.hasNext(); ) {
                company = (Company) iterator.next();


            }
            return company;


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public static void addCompany(Company company) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String str = "FROM Company";
            session.save(company);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void deleteCompany(Integer companyID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Company company =
                    (Company) session.get(Company.class, companyID);
            session.delete(company);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static List<Company> searchCompany(String search) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Company.class);
            cr.add(Restrictions.like("name", search+"%"));
            List company = cr.list();
            for (Iterator iterator = company.iterator(); iterator.hasNext(); ) {
                Company company1 = (Company) iterator.next();
                System.out.println(company1);
            }
            return company;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
