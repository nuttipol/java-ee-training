package my.example.jpa;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab03.Programmer;
import my.example.jpa.lab03.Tester;

@Slf4j
public class Lab03Test {

	private EntityManager  em;
	@Before
	public void setUp() throws Exception {
		em = EMF.createLocalEntityManager(); 
	}

	@After
	public void tearDown() {
		em.close();
	}
	
	@Test
	public void testService() throws Exception {
		em.getTransaction().begin();
		
		Programmer pg = new Programmer();
		pg.setName("PROGRAMMER");
		Tester ts = new Tester();
		ts.setName("TESTER");
		
		pg = em.merge(pg);
		ts = em.merge(ts);
		
		log.info(pg.toString());
		log.info(ts.getName());
		
		em.getTransaction().commit();
	}
}

