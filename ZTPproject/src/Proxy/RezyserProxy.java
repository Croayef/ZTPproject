package Proxy;

import DAO.RezyserDAO;
import DAOInterfaces.RezyserDAOInterface;
import POJO.Rezyser;
import java.util.List;
import org.hibernate.SessionFactory;

public class RezyserProxy implements RezyserDAOInterface {
    private RezyserDAOInterface rezyser;

    public RezyserProxy() {
        this.rezyser = new RezyserDAO();
    }

    
    public void addRezyser(Rezyser rezyser, SessionFactory sessionFactory) {
        this.rezyser.addRezyser(rezyser, sessionFactory);
    }

   
    public void removeRezyser(int id, SessionFactory sessionFactory) {
        this.rezyser.removeRezyser(id, sessionFactory);
    }

   
    public void editRezyser(Rezyser rezyser, SessionFactory sessionFactory) {
        this.rezyser.editRezyser(rezyser, sessionFactory);
    }

   
    public Rezyser getRezyser(int id, SessionFactory sessionFactory) {
        return this.rezyser.getRezyser(id, sessionFactory);
    }

  
    public List<Rezyser> getEachRezyser(SessionFactory sessionFactory) {
        return this.rezyser.getEachRezyser(sessionFactory);
    }
    
    
    
}
