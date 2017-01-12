package DAOInterfaces;

import POJO.Adres;
import java.util.List;
import org.hibernate.SessionFactory;

public interface AdresDAOInterface {
    public void addAdres(Adres adres, SessionFactory session);
    public void removeAdres(Adres adres, SessionFactory session);
    public void editAdres(Adres adres, SessionFactory session);
    public Adres getAdres(String id, SessionFactory session);
    public List<Adres> getEachAdres(SessionFactory session);
}
