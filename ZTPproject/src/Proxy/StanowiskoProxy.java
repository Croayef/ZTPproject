package Proxy;

import DAO.StanowiskoDAO;
import DAOInterfaces.StanowiskoDAOInterface;
import POJO.Stanowisko;
import java.util.List;
import org.hibernate.SessionFactory;

public class StanowiskoProxy implements StanowiskoDAOInterface{
    private StanowiskoDAOInterface stanowisko;

    public StanowiskoProxy() {
        this.stanowisko = new StanowiskoDAO();
    }

    
    public void addStanowisko(Stanowisko stanowisko, SessionFactory sessionFactory) {
        this.stanowisko.addStanowisko(stanowisko, sessionFactory);
    }

    
    public void removeStanowisko(int id, SessionFactory sessionFactory) {
        this.stanowisko.removeStanowisko(id, sessionFactory);
    }

    
    public void editStanowisko(Stanowisko stanowisko, SessionFactory sessionFactory) {
        this.stanowisko.editStanowisko(stanowisko, sessionFactory);
    }

    
    public Stanowisko getStanowisko(int id, SessionFactory sessionFactory) {
        return this.stanowisko.getStanowisko(id, sessionFactory);
    }

   
    public List<Stanowisko> getEachStanowisko(SessionFactory sessionFactory) {
        return this.stanowisko.getEachStanowisko(sessionFactory);
    }
    
    
}
