package my.example.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nuttipol
 */
public class EMF  {

    private static EntityManagerFactory emf;
     
	public static EntityManager createLocalEntityManager() {
		EMF.emf = Persistence.createEntityManagerFactory("jpa_local");
		return EMF.emf.createEntityManager();
	}

}