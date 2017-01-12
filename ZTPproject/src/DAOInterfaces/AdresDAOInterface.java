package DAOInterfaces;

import POJO.Adres;
import java.util.List;
import org.hibernate.SessionFactory;

public interface AdresDAOInterface {
    public void addAdres(Adres adres, SessionFactory sessionFactory);
    public void removeAdres(int id, SessionFactory sessionFactory);
    public void editAdres(Adres adres, SessionFactory sessionFactory);
    public Adres getAdres(int id, SessionFactory sessionFactory);
    public List<Adres> getEachAdres(SessionFactory sessionFactory);
}
