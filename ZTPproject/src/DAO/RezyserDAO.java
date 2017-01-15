package DAO;

import DAOInterfaces.RezyserDAOInterface;
import POJO.Rezyser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RezyserDAO implements RezyserDAOInterface {

    public void addRezyser(Rezyser rezyser, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(rezyser);
        transaction.commit();
        session.close();
    }

    public void removeRezyser(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Rezyser rezyser = (Rezyser) session.get(Rezyser.class, id);
        session.delete(rezyser);
        transaction.commit();
        session.close();
    }

    public void editRezyser(Rezyser rezyser, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(rezyser);
        transaction.commit();
        session.close();
    }

    public Rezyser getRezyser(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Rezyser rezyser = (Rezyser) session.get(Rezyser.class, id);
        transaction.commit();
        session.close();
        return rezyser;
    }

    public List<Rezyser> getEachRezyser(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Rezyser> rezysers = (List<Rezyser>) session.createCriteria(Rezyser.class).list();
        transaction.commit();
        session.close();
        return rezysers;
    }
}
