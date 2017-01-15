package Proxy;

import DAO.OddzialDAO;
import DAOInterfaces.OddzialDAOInterface;
import POJO.Oddzial;
import java.util.List;
import org.hibernate.SessionFactory;

public class OddzialProxy implements OddzialDAOInterface{
    private OddzialDAOInterface oddzial;

    public OddzialProxy() {
        this.oddzial = new OddzialDAO();
    }
    
    public void addOddzial(Oddzial oddzial, SessionFactory sessionFactory) {
        this.oddzial.addOddzial(oddzial, sessionFactory);
    }

   
    public void removeOddzial(int id, SessionFactory sessionFactory) {
       this.oddzial.removeOddzial(id, sessionFactory);
    }

   
    public void editOddzial(Oddzial oddzial, SessionFactory sessionFactory) {
       this.oddzial.editOddzial(oddzial, sessionFactory);
    }

   
    public Oddzial getOddzial(int id, SessionFactory sessionFactory) {
       return this.oddzial.getOddzial(id, sessionFactory);
    }

   
    public List<Oddzial> getEachOddzial(SessionFactory sessionFactory) {
       return this.oddzial.getEachOddzial(sessionFactory);
    }
    
    
    
}
