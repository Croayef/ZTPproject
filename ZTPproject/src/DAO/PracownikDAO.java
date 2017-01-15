package DAO;

import DAOInterfaces.PracownikDAOInterface;
import POJO.Pracownik;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PracownikDAO implements PracownikDAOInterface {

    public void addPracownik(Pracownik pracownik, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pracownik);
        transaction.commit();
        session.close();
    }

    public void removePracownik(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Pracownik pracownik = (Pracownik) session.get(Pracownik.class, id);
        session.delete(pracownik);
        transaction.commit();
        session.close();
    }

    public void editPracownik(Pracownik pracownik, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(pracownik);
        transaction.commit();
        session.close();
    }

    public Pracownik getPracownik(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Pracownik pracownik = (Pracownik) session.get(Pracownik.class, id);
        transaction.commit();
        session.close();
        return pracownik;
    }

    public List<Pracownik> getEachPracownik(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Pracownik> employees = (List<Pracownik>) session.createCriteria(Pracownik.class).list();
        transaction.commit();
        session.close();
        return employees;
    }

}
