package Proxy;

import DAO.AdresDAO;
import DAOInterfaces.AdresDAOInterface;
import POJO.Adres;
import java.util.List;
import org.hibernate.SessionFactory;

public class AdresProxy implements AdresDAOInterface {

    private AdresDAOInterface adres;
    
    public AdresProxy(){
        this.adres = new AdresDAO();
    }
    
    public void addAdres(Adres adres, SessionFactory sessionFactory) {
        this.adres.addAdres(adres, sessionFactory);
    }
    
    public void removeAdres(int id, SessionFactory sessionFactory) {
        this.adres.removeAdres(id, sessionFactory);
    }

    public void editAdres(Adres adres, SessionFactory sessionFactory) {
        this.adres.editAdres(adres, sessionFactory);
    }

    public Adres getAdres(int id, SessionFactory sessionFactory) {
        return this.adres.getAdres(id, sessionFactory);
    }

    public List<Adres> getEachAdres(SessionFactory sessionFactory) {
        return this.adres.getEachAdres(sessionFactory);
    }
    
}
