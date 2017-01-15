package DAO;

import POJO.Gatunek;

import DAOInterfaces.GatunekDAOInterface;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

    public void removeGatunek(int id, SessionFactory sessionFactory) throws HibernateException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("delete Gatunek where idGatunku =:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw new HibernateException("Nie pykło");
        } finally {
            transaction.commit();
            session.close();
        }
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
