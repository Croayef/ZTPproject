package Proxy;

import DAO.KlientDAO;
import DAOInterfaces.KlientDAOInterface;
import POJO.Klient;
import java.util.List;
import org.hibernate.SessionFactory;

public class KlientProxy implements KlientDAOInterface{    
    private KlientDAOInterface klient;

    public KlientProxy() {
        this.klient = new KlientDAO();
    }

   
    public void addKlient(Klient klient, SessionFactory sessionFactory) {
        this.klient.addKlient(klient, sessionFactory);
    }

   
    public void removeKlient(int id, SessionFactory sessionFactory) {
        this.klient.removeKlient(id, sessionFactory);
    }

  
    public void editKlient(Klient klient, SessionFactory sessionFactory) {
        this.klient.editKlient(klient, sessionFactory);
    }

  
    public Klient getKlient(int id, SessionFactory sessionFactory) {
        return this.klient.getKlient(id, sessionFactory);
    }

  
    public List<Klient> getEachKlient(SessionFactory sessionFactory) {
        return this.klient.getEachKlient(sessionFactory);
    }
    
    
}
