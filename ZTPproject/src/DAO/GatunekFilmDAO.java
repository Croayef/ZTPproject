package DAO;

import DAOInterfaces.GatunekFilmDAOInterface;
import POJO.GatunekFilm;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class GatunekFilmDAO implements GatunekFilmDAOInterface{

    
    public void addGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(gatunekFilm);
        transaction.commit();
        session.close();
    }

    
    public void removeGatunekFilm(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        GatunekFilm gatunekFilm = (GatunekFilm) session.get(GatunekFilm.class, id);
        session.delete(gatunekFilm);
        transaction.commit();
        session.close();    
    }

    
    public void editGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(gatunekFilm);
        transaction.commit();
        session.close();
    }

    
    public GatunekFilm getGatunekFilm(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        GatunekFilm gatunekFilm = (GatunekFilm) session.get(GatunekFilm.class, id);
        transaction.commit();
        session.close();
        return gatunekFilm;
    }

    
    public List<GatunekFilm> getEachGatunekFilm(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<GatunekFilm> genresFilms = (List<GatunekFilm>) session.createCriteria(GatunekFilm.class).list();
        transaction.commit();
        session.close();
        return genresFilms;
    }

    
     
}
