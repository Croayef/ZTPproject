package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private SessionFactory sessionFactory;
    private static HibernateUtil instance;
    
    private HibernateUtil() {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static HibernateUtil getInstance() {
        
        if(instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }
    
}
