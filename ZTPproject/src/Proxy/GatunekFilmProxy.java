package Proxy;

import DAO.GatunekFilmDAO;
import DAOInterfaces.GatunekFilmDAOInterface;
import POJO.GatunekFilm;
import POJO.GatunekFilmId;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import windows.MainWindow;

public class GatunekFilmProxy implements GatunekFilmDAOInterface {

    private GatunekFilmDAOInterface gatunekFilm;

    public GatunekFilmProxy() {
        this.gatunekFilm = new GatunekFilmDAO();
    }

    public void addGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory) {
        this.gatunekFilm.addGatunekFilm(gatunekFilm, sessionFactory);
    }

    public void removeGatunekFilm(GatunekFilmId id, SessionFactory sessionFactory) {
        switch (MainWindow.getRole()) {
            case 0:
                this.gatunekFilm.removeGatunekFilm(id, sessionFactory);
                break;
            default:
                JOptionPane.showMessageDialog(MainWindow.getInstance(), "Wymagane uprawnienia administratora!", "Brak uprawnień!", JOptionPane.ERROR_MESSAGE);
                throw new HibernateException("Brak uprawnien");
        }     
    }

    public void editGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory) {
        this.gatunekFilm.editGatunekFilm(gatunekFilm, sessionFactory);
    }

    public GatunekFilm getGatunekFilm(int id, SessionFactory sessionFactory) {
        return this.gatunekFilm.getGatunekFilm(id, sessionFactory);
    }

    public List<GatunekFilm> getEachGatunekFilm(SessionFactory sessionFactory) {
        return this.gatunekFilm.getEachGatunekFilm(sessionFactory);
    }

}
