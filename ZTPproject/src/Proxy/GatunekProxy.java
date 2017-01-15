package Proxy;
import DAO.GatunekDAO;
import DAOInterfaces.GatunekDAOInterface;
import POJO.Gatunek;
import java.util.List;
import org.hibernate.SessionFactory;

public class GatunekProxy implements GatunekDAOInterface {

    private GatunekDAOInterface gatunek;

    public GatunekProxy() {
        this.gatunek = new GatunekDAO();
    }
    
    public void addGatunek(Gatunek gatunek, SessionFactory sessionFactory) {
        this.addGatunek(gatunek, sessionFactory);
    }

  
    public void removeGatunek(int id, SessionFactory sessionFactory) {
        this.removeGatunek(id, sessionFactory);
    }

   
    public void editGatunek(Gatunek gatunek, SessionFactory sessionFactory) {
        this.editGatunek(gatunek, sessionFactory);
    }

    
    public Gatunek getGatunek(int id, SessionFactory sessionFactory) {
        return this.gatunek.getGatunek(id, sessionFactory);
    }

    
    public List<Gatunek> getEachGatunek(SessionFactory sessionFactory) {
        return this.gatunek.getEachGatunek(sessionFactory);
    }
    
}
