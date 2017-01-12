package DAOInterfaces;

import POJO.Klient;
import java.util.List;
import org.hibernate.SessionFactory;

public interface KlientDAOInterface {
    public void addKlient(Klient klient, SessionFactory sessionFactory);
    public void removeKlient(int id, SessionFactory sessionFactory);
    public void editKlient(Klient klient, SessionFactory sessionFactory);
    public Klient getKlient(int id, SessionFactory sessionFactory);
    public List<Klient> getEachKlient(Klient klient, SessionFactory sessionFactory);   
}
