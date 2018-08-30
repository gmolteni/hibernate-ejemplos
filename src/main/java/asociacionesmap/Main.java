package asociacionesmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		
		XFamilia familia = new XFamilia();
		familia.setNombreFamilia("Lopez44");
		XNombre nombre1 = new XNombre();
		nombre1.setNombre("Pedro");
		nombre1.setEdad(22);
		XNombre nombre2 = new XNombre();
		nombre2.setNombre("Jose");
		nombre2.setEdad(33);

		Map <XNombre, Integer> conjunto = new HashMap<XNombre, Integer>();
		
		
// la clave es un string
		
		
		Map <XNombre,Integer> conjuntoNombres = new HashMap<XNombre,Integer>();
		conjuntoNombres.put(nombre1,33);
		conjuntoNombres.put(nombre2,44);
		familia.setNombres(conjuntoNombres);
		
		session.beginTransaction();     
		session.save(familia);     
		session.getTransaction().commit();
		
		
		session.beginTransaction();
        ArrayList<XFamilia> result = (ArrayList<XFamilia>)session.createQuery("from Familia").list();
        session.getTransaction().commit();
        for (XFamilia e:result) System.out.println(e.toString());
		
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
