package Proxy;

import DAO.FilmDAO;
import POJO.Film;
import java.util.List;
import org.hibernate.SessionFactory;
import DAOInterfaces.FilmDAOInterface;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import windows.MainWindow;

public class FilmProxy implements FilmDAOInterface {

    private FilmDAOInterface film; 
    
    
    public FilmProxy() {
        this.film = new FilmDAO();
    }
    
    public void addFilm(Film film, SessionFactory sessionFactory) {
        switch(MainWindow.getRole()) {
            case 0:
                this.film.addFilm(film, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak Uprawnień!", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }
        
    }

    
    public void removeFilm(int id, SessionFactory sessionFactory) {
        switch(MainWindow.getRole()) {
            case 0:
                this.film.removeFilm(id, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak Uprawnień!", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }   
    }

    
    public void editFilm(Film film, SessionFactory sessionFactory) {
        switch(MainWindow.getRole()) {
            case 0:
                this.film.editFilm(film, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak Uprawnień!", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }  
    }

   
    public Film getFilm(int id, SessionFactory sessionFactory) {
        return this.film.getFilm(id, sessionFactory);
    }

    
    public List<Film> getEachFilm(SessionFactory sessionFactory) {
       return this.film.getEachFilm(sessionFactory);
    }
    
}
