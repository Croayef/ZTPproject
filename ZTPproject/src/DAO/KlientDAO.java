/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAOInterfaces.KlientDAOInterface;
import POJO.Klient;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Artur
 */
public class KlientDAO implements KlientDAOInterface {
private Session session;
private Transaction transaction;
    @Override
    public void addKlient(Klient klient, SessionFactory sessionFactory) {
    session= sessionFactory.getCurrentSession();
    transaction = session.beginTransaction();
    session.save(klient);
    transaction.commit();
    session.close();
    }

    @Override
    public void removeKlient(int id, SessionFactory sessionFactory) {
    session= sessionFactory.getCurrentSession();
    transaction = session.beginTransaction();
        Klient klient = (Klient) session.get(Klient.class, id);
        session.delete(klient);
        transaction.commit();
        session.close();
    }

    @Override
    public void editKlient(Klient klient, SessionFactory sessionFactory) {
    session= sessionFactory.getCurrentSession();
    transaction = session.beginTransaction();
    session.update(klient);
    transaction.commit();
    session.close();
    }

    @Override
    public Klient getKlient(int id, SessionFactory sessionFactory) {
        session= sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        Klient klient = (Klient) session.get(Klient.class, id);
        transaction.commit();
        session.close();
        return klient;
    }

    @Override
    public List<Klient> getEachKlient(Klient klient, SessionFactory sessionFactory) {
               session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Klient> klientlist = (List<Klient>) session.createCriteria(Klient.class).list();
        transaction.commit();
        session.close();
        return klientlist;
    }
    
}
