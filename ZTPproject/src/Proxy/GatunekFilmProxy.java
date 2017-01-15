package Proxy;

import DAO.GatunekFilmDAO;
import DAOInterfaces.GatunekFilmDAOInterface;
import POJO.GatunekFilm;
import java.util.List;
import org.hibernate.SessionFactory;

public class GatunekFilmProxy implements GatunekFilmDAOInterface {

    private GatunekFilmDAOInterface gatunekFilm;

    public GatunekFilmProxy() {
        this.gatunekFilm = new GatunekFilmDAO();
    }

    public void addGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory) {
        this.gatunekFilm.addGatunekFilm(gatunekFilm, sessionFactory);
    }

    public void removeGatunekFilm(int id, SessionFactory sessionFactory) {
        this.gatunekFilm.removeGatunekFilm(id, sessionFactory);
    }

    public void editGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory) {
        this.gatunekFilm.editGatunekFilm(gatunekFilm, sessionFactory);
    }

    public GatunekFilm getGatunekFilm(int id, SessionFactory sessionFactory) {
        return this.gatunekFilm.getGatunekFilm(id, sessionFactory);
    }

    public List<GatunekFilm> getEachGatunekFilm(SessionFactory sessionFactory) {
        return this.getEachGatunekFilm(sessionFactory);
    }

}
