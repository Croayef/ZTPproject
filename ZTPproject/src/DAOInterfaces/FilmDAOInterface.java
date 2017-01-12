package DAOInterfaces;

import POJO.Film;
import java.util.List;
import org.hibernate.SessionFactory;

public interface FilmDAOInterface {
    public void addFilm(Film film, SessionFactory sessionFactory);
    public void removeFilm(int id, SessionFactory sessionFactory);
    public void editFilm(Film film, SessionFactory sessionFactory);
    public Film getFilm(int id, SessionFactory sessionFactory);
    public List<Film> getEachFilm(SessionFactory sessionFactory);
}
