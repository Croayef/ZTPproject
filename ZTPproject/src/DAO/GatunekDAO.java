package DAO;

import POJO.Gatunek;

import DAOInterfaces.GatunekDAOInterface;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GatunekDAO implements GatunekDAOInterface {

    public void addGatunek(Gatunek gatunek, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(gatunek);
        transaction.commit();
        session.close();
    }

    public void removeGatunek(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Gatunek gatunek = (Gatunek) session.get(Gatunek.class, id);
        session.delete(gatunek);
        transaction.commit();
        session.close();
    }

    public void editGatunek(Gatunek gatunek, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(gatunek);
        transaction.commit();
        session.close();
    }

    public Gatunek getGatunek(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Gatunek gatunek = (Gatunek) session.get(Gatunek.class, id);
        transaction.commit();
        session.close();
        return gatunek;
    }

    public List<Gatunek> getEachGatunek(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Gatunek> genres = (List<Gatunek>) session.createCriteria(Gatunek.class).list();
        transaction.commit();
        session.close();
        return genres;
    }
}
