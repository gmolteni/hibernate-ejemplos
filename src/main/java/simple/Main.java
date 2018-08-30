package simple;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {	
		BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        
		Session session = HibernateUtil.getSession();
		/***
		 * No es simplemente grabo en una base de datos, sino que persisto mis objetos
		 * y si algun objeto cambio, se cambia en la base de datos . . .
		 */

		// borrar la tabla que tenia usando un query
		session.createQuery("delete from Palabras").executeUpdate();
		
		Palabras palabra = new Palabras();
		palabra.setPalabra("Auto");		
		session.beginTransaction();     session.save(palabra);      session.getTransaction().commit();

		palabra.setPalabra("Avion");      // este objeto esta pisando al anterior
		session.beginTransaction();     session.save(palabra);      session.getTransaction().commit();
		
		palabra = new Palabras();
		palabra.setPalabra("Camion");
		session.beginTransaction();     session.save(palabra);      session.getTransaction().commit();
		
        session.beginTransaction();
        ArrayList<Palabras> result = (ArrayList<Palabras>)session.createQuery("from Palabras").list();
        session.getTransaction().commit();
        session.close();

        for (Palabras e:result) System.out.println(e.getPalabra());
	}

}
