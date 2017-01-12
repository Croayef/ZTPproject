package DAO;

import DAOInterfaces.AdresDAOInterface;
import org.hibernate.SessionFactory;


public class AdresDAO implements AdresDAOInterface{

    @Override
    public void addAdres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
    public void removeAdres(int id, SessionFactory session) {
       session.getCurrentSession()
    }

    @Override
    public void editAdres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAdres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getEachAdres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
