package Util.SQLConnection;


import Util.Computer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class ManageComputer {
    private static SessionFactory factory;

    public static void getComputer(int id) {
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
            String str = "FROM Computer C where C.id =";
            List computer = session.createQuery(str + id).list();
            for (Iterator iterator = computer.iterator(); iterator.hasNext(); ) {
                Computer computer1 = (Computer) iterator.next();
                System.out.println(computer1);
            }


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void listComputer() {
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
            String str = "FROM Computer";
            List computer = session.createQuery(str).list();
            for (Iterator iterator = computer.iterator(); iterator.hasNext(); ) {
                Computer computer1 = (Computer) iterator.next();
                System.out.println(computer1);
            }


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
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
}
