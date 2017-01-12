package DAOInterfaces;

import POJO.Gatunek;
import java.util.List;
import org.hibernate.SessionFactory;

public interface GatunekDAOInterface {
    public void addGatunek(Gatunek gatunek, SessionFactory sessionFactory);
    public void removeGatunek(int id, SessionFactory sessionFactory);
    public void editGatunek(Gatunek gatunek, SessionFactory sessionFactory);
    public Gatunek getGatunek(int id, SessionFactory sessionFactory);
    public List<Gatunek> getEachGatunek(SessionFactory sessionFactory); 
}
