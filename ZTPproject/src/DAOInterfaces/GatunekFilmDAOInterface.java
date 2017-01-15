package DAOInterfaces;

import POJO.GatunekFilm;
import POJO.GatunekFilmId;
import java.util.List;
import org.hibernate.SessionFactory;

public interface GatunekFilmDAOInterface  {

    public void addGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory);

    public void removeGatunekFilm(GatunekFilmId id, SessionFactory sessionFactory);

    public void editGatunekFilm(GatunekFilm gatunekFilm, SessionFactory sessionFactory);

    public GatunekFilm getGatunekFilm(int id, SessionFactory sessionFactory);

    public List<GatunekFilm> getEachGatunekFilm(SessionFactory sessionFactory);
}
