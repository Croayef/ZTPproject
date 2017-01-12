package DAOInterfaces;

import org.hibernate.SessionFactory;
import POJO.Oddzial;
import java.util.List;

public interface OddzialDAOInterface {
    public void addOddzial(Oddzial oddzial, SessionFactory sessionFactory);
    public void removeOddzial(int id, SessionFactory sessionFactory);
    public void editOddzial(Oddzial oddzial, SessionFactory sessionFactory);
    public Oddzial getOddzial(int id, SessionFactory sessionFactory);
    public List<Oddzial> getEachOddzial(SessionFactory sessionFactory);  
}
