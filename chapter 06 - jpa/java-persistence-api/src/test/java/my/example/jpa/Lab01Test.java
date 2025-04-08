package my.example.jpa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab01.Address;
import my.example.jpa.lab01.Alien;
import my.example.jpa.lab01.MaritalStatus;
import my.example.jpa.lab01.People;

@Slf4j
public class Lab01Test {

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
	public void testPeople() throws Exception {
		EntityTransaction tx 	= 	em.getTransaction();

		tx.begin();
		
		People nuttipol = new People(); 
		Address address = new Address();
		Calendar calendar = new GregorianCalendar(1977,11,22);
		
		address.setStreet("Rama 2");
		address.setCity("Bangkok");
		address.setCountry("Thailand");
		
		nuttipol.setName("Nuttipol");
		nuttipol.setPersonalId("1234567890123");
		nuttipol.setAddress(address);
		nuttipol.setBirthDate(calendar.getTime());
		nuttipol.setMaritalStatus(MaritalStatus.SINGLE);
		
		People nextPeople = new People(); 
		nextPeople.setName("Steve");
		nextPeople.setPersonalId("123456780456");
		
    	em.persist(nuttipol); 
    	em.persist(nextPeople); 
    	
        tx.commit();
        
		Assert.assertEquals(1, nuttipol.getVersion());
		Assert.assertEquals(1, nextPeople.getVersion());
		
		Assert.assertNotNull(nuttipol.getId());
		Assert.assertNotNull(nextPeople.getId());
		
		People people2 = em.find(People.class, nextPeople.getId());
        
		log.info("people.id : " + people2.getId() );
		
		em.refresh(people2);
		
		tx.begin();
		
		people2.setThaiCitizen(true);
		
		em.persist(people2);
		
		tx.commit();
		
		Assert.assertEquals(2, people2.getVersion());
		
		Assert.assertTrue(
				em.createNativeQuery
				("Select * from people m where m.marital_status_code = 'S' ").
				getResultList().size() > 0 );
		Assert.assertTrue(
				em.createQuery
				("Select m from People m where m.maritalStatus.code = 'S' ",
						People.class).getResultList().size() > 0 );
	}
	
	@Test
	public void testAlien() throws Exception {
		EntityTransaction tx 	= 	em.getTransaction();

		tx.begin();
		
		Alien asgardian = new Alien(); 
		asgardian.setName("Thor");
		Alien eternal = new Alien(); 
		eternal.setName("Thanos");
		
    	em.persist(asgardian); 
    	em.persist(eternal); 
    	
        tx.commit();
        
		Assert.assertNotNull(asgardian.getId());
		Assert.assertNotNull(eternal.getId());

	}
	 
}
