package DAOInterfaces;
import POJO.Nosnik;
import java.util.List;
import org.hibernate.SessionFactory;

public interface NosnikDAOInterface {
    public void addNosnik(Nosnik nosnik, SessionFactory sessionFactory);
    public void removeNosnik(int id, SessionFactory sessionFactory);
    public void editNosnik(Nosnik nosnik, SessionFactory sessionFactory);
    public Nosnik getNosnik(int id, SessionFactory sessionFactory);
    public List<Nosnik> getEachNosnik(SessionFactory sessionFactory);   
}
