package Util.SQLConnection;


import Util.Company;
import Util.Computer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class ManageComputer {
    private static SessionFactory factory;

    public static Computer getComputer(int id) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        Computer computer1=null;
        try {
            tx = session.beginTransaction();
            String str = "FROM Computer C where C.id =";
            List computer = session.createQuery(str + id).list();
            for (Iterator iterator = computer.iterator(); iterator.hasNext(); ) {
                computer1 = (Computer) iterator.next();
            }
            return computer1;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();

        }
    }
    public static List<Computer> listComputer() {
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
            List computer = session.createQuery("FROM Computer").list();
            for (Iterator iterator = computer.iterator(); iterator.hasNext(); ) {
                Computer computer1 = (Computer) iterator.next();
                str+=computer1;
            }
            return computer;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public static List<Computer> listComputer(int nbElements, int page) {
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

            org.hibernate.Query query = session.createQuery("FROM Computer");

            query.setFirstResult((page-1)*nbElements);
            query.setMaxResults(nbElements*(page));
            List computer = query.list();
            for (Iterator iterator = computer.iterator(); iterator.hasNext(); ) {
                Computer computer1 = (Computer) iterator.next();
                str+=computer1;
            }
            return computer;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public static List<Computer> listComputer(int companyId) {
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

            List computer = session.createQuery(str).list();

            for (Iterator iterator = computer.iterator(); iterator.hasNext(); ) {
                Computer computer1 = (Computer) iterator.next();
                str+=computer1;
            }
            return computer;

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public static void addComputer(Computer computer) {
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
            int computerID = (Integer) session.save(computer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void deleteComputer(Integer computerID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Computer computer =
                    (Computer) session.get(Computer.class, computerID);
            session.delete(computer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static long getLastComputerId() {
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
}
