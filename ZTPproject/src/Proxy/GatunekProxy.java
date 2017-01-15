package Proxy;

import DAO.GatunekDAO;
import DAOInterfaces.GatunekDAOInterface;
import POJO.Gatunek;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import windows.MainWindow;

public class GatunekProxy implements GatunekDAOInterface {

    private GatunekDAOInterface gatunek;

    public GatunekProxy() {
        this.gatunek = new GatunekDAO();
    }

    public void addGatunek(Gatunek gatunek, SessionFactory sessionFactory) {
        switch (MainWindow.getRole()) {
            case 0:
                this.gatunek.addGatunek(gatunek, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak uprawnień!2", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }
    }

    public void removeGatunek(int id, SessionFactory sessionFactory) throws HibernateException {
        switch (MainWindow.getRole()) {
            case 0:
                this.gatunek.removeGatunek(id, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak uprawnień!2", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }   
    }

    public void editGatunek(Gatunek gatunek, SessionFactory sessionFactory) {
        
        switch (MainWindow.getRole()) {
            case 0:
                this.gatunek.editGatunek(gatunek, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak uprawnień!", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }      
    }

    public Gatunek getGatunek(int id, SessionFactory sessionFactory) {
        return this.gatunek.getGatunek(id, sessionFactory);
    }

    public List<Gatunek> getEachGatunek(SessionFactory sessionFactory) {
        return this.gatunek.getEachGatunek(sessionFactory);
    }

}
