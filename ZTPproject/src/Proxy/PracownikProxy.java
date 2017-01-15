package Proxy;

import DAO.PracownikDAO;
import DAOInterfaces.PracownikDAOInterface;
import POJO.Pracownik;
import java.util.List;
import org.hibernate.SessionFactory;

public class PracownikProxy implements PracownikDAOInterface{
    private PracownikDAOInterface pracownik;

    public PracownikProxy() {
        this.pracownik = new PracownikDAO();
    }
    
    public void addPracownik(Pracownik pracownik, SessionFactory sessionFactory) {
        this.pracownik.addPracownik(pracownik, sessionFactory);
    }
    
    public void removePracownik(int id, SessionFactory sessionFactory) {
        this.pracownik.removePracownik(id, sessionFactory);
    }
    
    public void editPracownik(Pracownik pracownik, SessionFactory sessionFactory) {
        this.pracownik.editPracownik(pracownik, sessionFactory);
    }
    
    public Pracownik getPracownik(int id, SessionFactory sessionFactory) {
        return this.pracownik.getPracownik(id, sessionFactory);
    }
    
    public List<Pracownik> getEachPracownik(SessionFactory sessionFactory) {
        return this.pracownik.getEachPracownik(sessionFactory);
    }
    
    
    
}
