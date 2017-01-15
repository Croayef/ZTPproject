package Proxy;

import DAO.TransakcjaDAO;
import DAOInterfaces.TransakcjaDAOInterface;
import POJO.Transakcja;
import java.util.List;
import org.hibernate.SessionFactory;

public class TransakcjaProxy implements TransakcjaDAOInterface{
    private TransakcjaDAOInterface transakcja;

    public TransakcjaProxy() {
        this.transakcja = new TransakcjaDAO();
    }

    
    public void addTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
        this.transakcja.addTransakcja(transakcja, sessionFactory);
    }

   
    public void removeTransakcja(int id, SessionFactory sessionFactory) {
        this.removeTransakcja(id, sessionFactory);
    }

  
    public void editTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
        this.editTransakcja(transakcja, sessionFactory);
    }

  
    public Transakcja getTransakcja(int id, SessionFactory sessionFactory) {
        return this.transakcja.getTransakcja(id, sessionFactory);
    }

   
    public List<Transakcja> getEachTransakcja(SessionFactory sessionFactory) {
        return this.transakcja.getEachTransakcja(sessionFactory);
    }
    
    
}
