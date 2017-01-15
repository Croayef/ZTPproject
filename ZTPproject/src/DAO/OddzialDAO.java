package DAO;

import DAOInterfaces.OddzialDAOInterface;
import POJO.Oddzial;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OddzialDAO implements OddzialDAOInterface {

    public void addOddzial(Oddzial oddzial, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(oddzial);
        transaction.commit();
        session.close();
    }

    public void removeOddzial(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Oddzial oddzial = (Oddzial) session.get(Oddzial.class, id);
        session.delete(oddzial);
        transaction.commit();
        session.close();
    }

    public void editOddzial(Oddzial oddzial, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(oddzial);
        transaction.commit();
        session.close();
    }

    public Oddzial getOddzial(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Oddzial oddzial = (Oddzial) session.get(Oddzial.class, id);
        transaction.commit();
        session.close();
        return oddzial;
    }

    public List<Oddzial> getEachOddzial(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Oddzial> departaments = (List<Oddzial>) session.createCriteria(Oddzial.class).list();
        transaction.commit();
        session.close();
        return departaments;
    }
}
