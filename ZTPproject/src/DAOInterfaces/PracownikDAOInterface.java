package DAOInterfaces;

import POJO.Pracownik;
import java.util.List;
import org.hibernate.SessionFactory;

public interface PracownikDAOInterface {

    public void addPracownik(Pracownik pracownik, SessionFactory sessionFactory);

    public void removePracownik(int id, SessionFactory sessionFactory);

    public void editPracownik(Pracownik pracownik, SessionFactory sessionFactory);

    public Pracownik getPracownik(int id, SessionFactory sessionFactory);

    public List<Pracownik> getEachPracownik(SessionFactory sessionFactory);
}
