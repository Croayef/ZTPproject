/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAOInterfaces.TransakcjaDAOInterface;
import POJO.Transakcja;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Artur
 */
public class TransakcjaDAO implements TransakcjaDAOInterface {
private Session session;
private Transaction transaction;
    @Override
    public void addTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
    session= sessionFactory.getCurrentSession();
    transaction = session.beginTransaction();
    session.save(transakcja);
    transaction.commit();
    session.close();
    }

    @Override
    public void removeTransakcja(int id, SessionFactory sessionFactory) {
         session= sessionFactory.getCurrentSession();
         transaction = session.beginTransaction();
        Transakcja transakcja = (Transakcja) session.get(Transakcja.class, id);
        session.delete(transakcja);
        transaction.commit();
        session.close();
    }

    @Override
    public void editTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
         session= sessionFactory.getCurrentSession();
         transaction = session.beginTransaction();
         session.update(transakcja);
         transaction.commit();
         session.close();
    }

    @Override
    public Transakcja getTransakcja(int id, SessionFactory sessionFactory) {
        session= sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        Transakcja transakcja = (Transakcja) session.get(Transakcja.class, id);
        transaction.commit();
        session.close();
        return transakcja;
    }

    @Override
    public List<Transakcja> getEachTransakcja(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Transakcja> transactions = (List<Transakcja>) session.createCriteria(Transakcja.class).list();
        transaction.commit();
        session.close();
        return transactions;
    }
    
}
