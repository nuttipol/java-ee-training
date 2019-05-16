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
	public void testService() throws Exception {
		em.getTransaction().begin();
		
		EntityTransaction tx 	= 	em.getTransaction();

		People people = new People(); 
		Address address = new Address();
		Calendar calendar = new GregorianCalendar(1977,11,22);
		
		address.setStreet("Rama 2");
		address.setCity("Bangkok");
		address.setCountry("Thailand");
		
		people.setName("Nuttipol");
		people.setPersonalId("1234567890123");
		people.setAddress(address);
		people.setBirthDate(calendar.getTime());
		people.setMaritalStatus(MaritalStatus.SINGLE);
		
    	em.persist(people); 
    	
        tx.commit();
        
		log.info("people.version : " + people.getVersion() );

		People p2 = em.find(People.class, 1);
        
		log.info("people : " + p2 );
		
		em.refresh(p2);
		
		tx.begin();
		
		p2.setThaiCitizen(true);
		
		em.persist(p2);
		tx.commit();
		
		log.info("people.version : " + p2.getVersion() );
		
		Assert.assertEquals(2, p2.getVersion());
		
		Assert.assertEquals(1, em.createQuery("Select m from People m where m.maritalStatus.code = 'S' ", People.class).getResultList().size());
	}
}
