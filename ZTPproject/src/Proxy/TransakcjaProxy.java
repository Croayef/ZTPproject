package Proxy;

import DAO.TransakcjaDAO;
import DAOInterfaces.TransakcjaDAOInterface;
import POJO.Transakcja;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.derby.impl.tools.sysinfo.Main;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import windows.MainWindow;

public class TransakcjaProxy implements TransakcjaDAOInterface{
    private TransakcjaDAOInterface transakcja;

    public TransakcjaProxy() {
        this.transakcja = new TransakcjaDAO();
    }

    
    public void addTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
        switch(MainWindow.getRole()) {
            case 1:
                this.transakcja.addTransakcja(transakcja, sessionFactory);
                break;
            default :
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "");
                
                throw new HibernateException("Brak uprawnien");
        }
    }

   
    public void removeTransakcja(int id, SessionFactory sessionFactory) {
        this.transakcja.removeTransakcja(id, sessionFactory);
    }

  
    public void editTransakcja(Transakcja transakcja, SessionFactory sessionFactory) {
        this.transakcja.editTransakcja(transakcja, sessionFactory);
    }

  
    public Transakcja getTransakcja(int id, SessionFactory sessionFactory) {
        return this.transakcja.getTransakcja(id, sessionFactory);
    }

   
    public List<Transakcja> getEachTransakcja(SessionFactory sessionFactory) {
        return this.transakcja.getEachTransakcja(sessionFactory);
    }
    
    
}
