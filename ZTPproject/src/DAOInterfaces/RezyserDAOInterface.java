package DAOInterfaces;

import POJO.Rezyser;
import java.util.List;
import org.hibernate.SessionFactory;

public interface RezyserDAOInterface {

    public void addRezyser(Rezyser rezyser, SessionFactory sessionFactory);

    public void removeRezyser(int id, SessionFactory sessionFactory);

    public void editRezyser(Rezyser rezyser, SessionFactory sessionFactory);

    public Rezyser getRezyser(int id, SessionFactory sessionFactory);

    public List<Rezyser> getEachRezyser(SessionFactory sessionFactory);
}
