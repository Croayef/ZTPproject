/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DAOInterfaces.NosnikDAOInterface;
import POJO.Nosnik;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Artur
 */
public class NosnikDAO implements NosnikDAOInterface {

    @Override
    public void addNosnik(Nosnik nosnik, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(nosnik);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeNosnik(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Nosnik nosnik = (Nosnik) session.get(Nosnik.class, id);
        session.delete(nosnik);
        transaction.commit();
        session.close();
    }

    @Override
    public void editNosnik(Nosnik nosnik, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(nosnik);
        transaction.commit();
        session.close();
    }

    @Override
    public Nosnik getNosnik(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Nosnik nosnik = (Nosnik) session.get(Nosnik.class, id);
        transaction.commit();
        session.close();
        return nosnik;
    }

    @Override
    public List<Nosnik> getEachNosnik(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Nosnik> nosniki = (List<Nosnik>) session.createCriteria(Nosnik.class).list();
        transaction.commit();
        session.close();
        return nosniki;
    }

    
}
