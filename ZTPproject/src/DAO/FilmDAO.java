package DAO;

import DAOInterfaces.FilmDAOInterface;
import POJO.Film;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class FilmDAO implements FilmDAOInterface {

    public void addFilm(Film film, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(film);
        transaction.commit();
        session.close();
    }

    public void removeFilm(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Film film = (Film) session.get(Film.class, id);
        session.delete(film);
        transaction.commit();
        session.close();
    }

    public void editFilm(Film film, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(film);
        transaction.commit();
        session.close();
    }

    public Film getFilm(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Film film = (Film) session.get(Film.class, id);
        transaction.commit();
        session.close();
        return film;
    }

    public List<Film> getEachFilm(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("DAO.FilmDAO.getEachFilm()");
        List<Film> movies = (List<Film>) session.createCriteria(Film.class).list();
        transaction.commit();
        session.close();
        System.out.println("DAO.FilmDAO.getEachFilm() dziala");
        return movies;
    }
}
