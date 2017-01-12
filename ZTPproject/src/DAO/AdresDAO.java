package DAO;

import DAOInterfaces.AdresDAOInterface;
import POJO.Adres;
import java.util.List;
import org.hibernate.SessionFactory;


public class AdresDAO implements AdresDAOInterface{

    @Override
    public void addAdres(Adres adres, SessionFactory session) {
      session.getCurrentSession().save(adres);

    }
 
    @Override
    public void removeAdres(Adres adres, SessionFactory session) {
       session.getCurrentSession().delete(adres);
    }

    @Override
    public void editAdres(Adres adres, SessionFactory session) {
        session.getCurrentSession().update(adres);
    }

    @Override
    public Adres getAdres(String id, SessionFactory session) {
        Adres adres = (Adres) session.getCurrentSession().get(Adres.class, id);
        return adres;
    }

    @Override
    public List<Adres> getEachAdres(SessionFactory session) {
        List<Adres> adresses = (List<Adres>) session.getCurrentSession().createQuery("from Adres").list();
        return adresses;
    }

}
