package simple;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Esta clase da las conexiones con la base de datos
 *
 */
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
 
	static {
        try {        	
            sessionFactory = new AnnotationConfiguration().configure(new File("simple.hbm.xml")).buildSessionFactory();            
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

}