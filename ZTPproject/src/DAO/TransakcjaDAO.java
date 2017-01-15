package DAO;

import DAOInterfaces.TransakcjaDAOInterface;
import POJO.Transakcja;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TransakcjaDAO implements TransakcjaDAOInterface {

    private Session session;
    private Transaction transaction;

    public void addTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        System.out.println("DAO.TransakcjaDAO.addTransakcja()");
        transaction = session.beginTransaction();
        session.save(transakcja);
        System.out.println("DAO.TransakcjaDAO.addTransakcja()2");
        transaction.commit();
        session.close();
        System.out.println("DAO.TransakcjaDAO.addTransakcja()3");
    }

    public void removeTransakcja(int id, SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Transakcja transakcja = (Transakcja) session.get(Transakcja.class, id);
        session.delete(transakcja);
        transaction.commit();
        session.close();
    }

    public void editTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(transakcja);
        transaction.commit();
        session.close();
    }

    public Transakcja getTransakcja(int id, SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Transakcja transakcja = (Transakcja) session.get(Transakcja.class, id);
        transaction.commit();
        session.close();
        return transakcja;
    }

    public List<Transakcja> getEachTransakcja(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Transakcja> transactions = (List<Transakcja>) session.createCriteria(Transakcja.class).list();
        transaction.commit();
        session.close();
        return transactions;
    }
}
