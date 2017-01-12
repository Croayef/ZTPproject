package DAO;

import DAOInterfaces.AdresDAOInterface;
import POJO.Adres;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AdresDAO implements AdresDAOInterface{
private Session session;
private Transaction transaction;
    @Override
    public void addAdres(Adres adres, SessionFactory sessionFactory) {
    session= sessionFactory.getCurrentSession();
    transaction = session.beginTransaction();
    session.save(adres);
    transaction.commit();
    session.close();
    }

    @Override
    public void removeAdres(Adres adres, SessionFactory sessionFactory) {
         session= sessionFactory.getCurrentSession();
         transaction = session.beginTransaction();
         session.delete(adres);
         transaction.commit();
         session.close();
    }

    @Override
    public void editAdres(Adres adres, SessionFactory sessionFactory) {
         session= sessionFactory.getCurrentSession();
         transaction = session.beginTransaction();
         session.update(adres);
         transaction.commit();
         session.close();
    }

    @Override
    public Adres getAdres(String id, SessionFactory sessionFactory) {
        session= sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        Adres adres = (Adres) session.get(Adres.class, id);
        transaction.commit();
        session.close();
        return adres;
    }

    @Override
    public List<Adres> getEachAdres(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Adres> addresses = (List<Adres>) session.createCriteria(Adres.class).list();
        transaction.commit();
        session.close();
        return addresses;
    }

}
