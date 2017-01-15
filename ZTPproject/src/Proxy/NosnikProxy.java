package Proxy;

import DAO.NosnikDAO;
import DAOInterfaces.NosnikDAOInterface;
import POJO.Nosnik;
import java.util.List;
import org.hibernate.SessionFactory;

public class NosnikProxy implements NosnikDAOInterface{
    private NosnikDAOInterface nosnik;

    public NosnikProxy() {
        this.nosnik = new NosnikDAO();
    }

    
    public void addNosnik(Nosnik nosnik, SessionFactory sessionFactory) {
        this.nosnik.addNosnik(nosnik, sessionFactory);
    }

  
    public void removeNosnik(int id, SessionFactory sessionFactory) {
       this.nosnik.removeNosnik(id, sessionFactory);
    }

  
    public void editNosnik(Nosnik nosnik, SessionFactory sessionFactory) {
        this.nosnik.editNosnik(nosnik, sessionFactory);
    }

   
    public Nosnik getNosnik(int id, SessionFactory sessionFactory) {
        return this.nosnik.getNosnik(id, sessionFactory);
    }

   
    public List<Nosnik> getEachNosnik(SessionFactory sessionFactory) {
        return this.nosnik.getEachNosnik(sessionFactory);
    }
    
    
    
    
}
