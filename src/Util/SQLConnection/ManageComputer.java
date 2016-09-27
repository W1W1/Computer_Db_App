package Util.SQLConnection;


import Util.Computer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.management.Query;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class ManageComputer {
    private static SessionFactory factory;

    /**
     Permet la recuperation de l'ordinateur spécifié.
     @param id Le numero d'identification de l'ordinateur.
     @return L'ordinateur voulu.
     */
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
    /**
     Permet le listing des ordinateurs de la DB.
     @return La liste de toute les ordinateurs.
     */
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
    /**
     Permet le listing des ordinateurs de la DB.
     @param nbElements le nombre d'elements par page
     @param page le numero de page que l'utilisateur demande
     @return La liste de toute les ordinateurs limitée par les paramètres.
     */
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
    /**
     Permet l'ajout de l'ordinateur spécifié.
     @param computer L'ordinateur a mettre en memoire
     */
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
            session.save(computer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

<<<<<<< Updated upstream
    public static void updateComputer(Computer computer) {
=======
    public static void updateComputerV1(Computer computer) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
>>>>>>> Stashed changes
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(computer);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void updateComputer(Computer computer) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();

        try {

            session.beginTransaction();
            session.update(computer);
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     Permet la supression d'une ordinateur.
     @param computerID Le numero d'identification à supprimer de la DB.
     */
    public static void deleteComputer(Integer computerID) {
        Session session = factory.openSession();
        long l = computerID;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Computer computer =
                    (Computer) session.get(Computer.class, l);
            session.delete(computer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     Permet la recuperation de la dernière ordinateur ajouté.
     */
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
    /**
     Permet la recuperation d'une liste d'ordinateur selon la racherche.
     @param search variable contenant l'expression de recherche
     */
    public static List<Computer> searchComputer(String search) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Computer.class);
            cr.add(Restrictions.like("name", search+"%"));
            List computerList = cr.list();
            for (Iterator iterator = computerList.iterator(); iterator.hasNext(); ) {
                Computer computer = (Computer) iterator.next();
                System.out.println(computer);
            }
            return computerList;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
