package DAOInterfaces;

import POJO.Stanowisko;
import java.util.List;

import org.hibernate.SessionFactory;

public interface StanowiskoDAOInterface {

    public void addStanowisko(Stanowisko stanowisko, SessionFactory sessionFactory);

    public void removeStanowisko(int id, SessionFactory sessionFactory);

    public void editStanowisko(Stanowisko stanowisko, SessionFactory sessionFactory);

    public Stanowisko getStanowisko(int id, SessionFactory sessionFactory);

    public List<Stanowisko> getEachStanowisko(SessionFactory sessionFactory);
}
