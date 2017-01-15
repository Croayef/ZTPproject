package Proxy;

import DAO.FilmDAO;
import DAOInterfaces.FilmDAOInterface;
import POJO.Film;
import java.util.List;
import org.hibernate.SessionFactory;
import DAOInterfaces.FilmDAOInterface;

public class FilmProxy implements FilmDAOInterface {

    private FilmDAOInterface film; 
    
    public void addFilm(Film film, SessionFactory sessionFactory) {
        this.film = new FilmDAO();
    }

    
    public void removeFilm(int id, SessionFactory sessionFactory) {
        this.film.removeFilm(id, sessionFactory);
    }

    
    public void editFilm(Film film, SessionFactory sessionFactory) {
        this.film.editFilm(film, sessionFactory);
    }

   
    public Film getFilm(int id, SessionFactory sessionFactory) {
        return this.film.getFilm(id, sessionFactory);
    }

    
    public List<Film> getEachFilm(SessionFactory sessionFactory) {
       return this.getEachFilm(sessionFactory);
    }
    
}
