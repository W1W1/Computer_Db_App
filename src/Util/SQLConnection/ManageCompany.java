package Util.SQLConnection;


import Util.Company;
import Util.Computer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class ManageCompany{
    private static SessionFactory factory;
    /**
     Permet le listing des entreprises de la DB.
     @return La liste de toute les entreprises.
     */
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
            return companies;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
    /**
     Permet la recuperation de l'entreprise spécifié.
     @param id Le numero d'identification de l'entrprise.
     @return L'entreprise voulu.
     */
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
            String str = "FROM Company where id = ";
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
    /**
     Permet l'ajout de l'entreprise spécifié.
     @param company L'entrprise a mettre en memoire
     */
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

    /**
     Permet la supression d'une entreprise.
     @param companyID Le numero d'identification à supprimer de la DB.
     */
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

    /**
     Permet la recuperation de la dernière entreprise ajouté.
     */
    public static long getLastCompanyId() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
            return lastId;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    /**
     Permet la recuperation d'une liste d'entreprise selon la racherche.
     @param search variable contenant l'expression de recherche
     */
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
    /**
     Permet le listing des entreprises de la DB.
     @param nbElements le nombre d'elements par page
     @param page le numero de page que l'utilisateur demande
     @return La liste de toute les entreprises limitée par les paramètres.
     */
    public static List<Company> listCompany(int nbElements, int page) {
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
            String str ="";

            org.hibernate.Query query = session.createQuery("FROM Company");

            query.setFirstResult((page-1)*nbElements);
            query.setMaxResults(nbElements*(page));
            List companyList = query.list();
            for (Iterator iterator = companyList.iterator(); iterator.hasNext(); ) {
                Company company = (Company) iterator.next();
                str+=company;
            }
            return companyList;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    /**
     * LEGACY CODE
     Prototype de recuperation du nombre d'ordianteur par entreprise
     prototype fonctionel mais Erroné par la façon d'utiliser Hibernate,
     manque de performance flagrant.
     */
    public static int nbComputer(long companyId) {
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
            String str ="FROM Computer WHERE company_id="+companyId;

            int size = session.createQuery(str).list().size();

            return size;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return -1;
        } finally {
            session.close();
        }
    }
}
