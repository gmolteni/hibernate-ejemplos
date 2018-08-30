package asociaciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import simple.Palabras;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
	
		Session session = HibernateUtil.getSession();
		session.beginTransaction();     
		session.getTransaction().commit();
        session.close();
		session = HibernateUtil.getSession();

        
        
		// borrar la tabla que tenia usando un query
		//session.createQuery("delete from Nombre").executeUpdate();		        // borrar la tabla que tenia usando un query
		
		Familia familia = new Familia();
		familia.setNombreFamilia("Lopez44");
		Nombre nombre1 = new Nombre(familia);
		nombre1.setNombre("Juan");
		Nombre nombre2 = new Nombre(familia);
		nombre2.setNombre("Luis");
		List <Nombre> conjuntoNombres = new ArrayList<Nombre>();
		conjuntoNombres.add(nombre1);
		conjuntoNombres.add(nombre2);
		familia.setNombres(conjuntoNombres);
		
		session.beginTransaction();     
		session.save(familia);     
		session.save(nombre1);     
		session.save(nombre2);     
		session.getTransaction().commit();
		
		
		session.beginTransaction();
        ArrayList<Familia> result = (ArrayList<Familia>)session.createQuery("from Familia").list();
        session.getTransaction().commit();
        for (Familia e:result) System.out.println(e.toString());
		
        /*
		session.beginTransaction(); // por olvidarme esto, se colgaba el SQL
		session.createSQLQuery("DROP TABLE familia_nombre").executeUpdate();
		session.createSQLQuery("DROP TABLE nombre").executeUpdate();
		session.createSQLQuery("DROP TABLE familia").executeUpdate();
        session.getTransaction().commit();
        */
        
        session.close();
		System.out.println("Fin programa");
	}
}
