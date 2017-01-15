package DAO;

import DAOInterfaces.StanowiskoDAOInterface;
import POJO.Stanowisko;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StanowiskoDAO implements StanowiskoDAOInterface {

    public void addStanowisko(Stanowisko stanowisko, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(stanowisko);
        transaction.commit();
        session.close();
    }

    public void removeStanowisko(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Stanowisko stanowisko = (Stanowisko) session.get(Stanowisko.class, id);
        session.delete(stanowisko);
        transaction.commit();
        session.close();
    }

    public void editStanowisko(Stanowisko stanowisko, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(stanowisko);
        transaction.commit();
        session.close();
    }

    public Stanowisko getStanowisko(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Stanowisko stanowisko = (Stanowisko) session.get(Stanowisko.class, id);
        transaction.commit();
        session.close();
        return stanowisko;
    }

    public List<Stanowisko> getEachStanowisko(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Stanowisko> positions = (List<Stanowisko>) session.createCriteria(Stanowisko.class).list();
        transaction.commit();
        session.close();
        return positions;
    }
}
