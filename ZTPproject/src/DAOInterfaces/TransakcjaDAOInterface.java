package DAOInterfaces;

import POJO.Transakcja;
import java.util.List;
import org.hibernate.SessionFactory;

public interface TransakcjaDAOInterface {

    public void addTransakcja(Transakcja transakcja, SessionFactory sessionFactory);

    public void removeTransakcja(int id, SessionFactory sessionFactory);

    public void editTransakcja(Transakcja transakcja, SessionFactory sessionFactory);

    public Transakcja getTransakcja(int id, SessionFactory sessionFactory);

    public List<Transakcja> getEachTransakcja(SessionFactory sessionFactory);
}
