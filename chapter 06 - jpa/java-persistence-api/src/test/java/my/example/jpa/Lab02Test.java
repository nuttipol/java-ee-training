package my.example.jpa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import my.example.jpa.lab01.Address;
import my.example.jpa.lab01.MaritalStatus;
import my.example.jpa.lab01.People;
import my.example.jpa.lab02.Parent;
import my.example.jpa.lab02.ParentId;
import my.example.jpa.lab02.ParentType;

public class Lab02Test {

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
		
		People people = new People(); 
		Address address = new Address();
		Calendar calendar = new GregorianCalendar(1977,11,22);
		
		address.setCity("Bangkok");
		address.setCountry("Thailand");
		
		people.setName("Nachanok");
		people.setPersonalId("1111111111111");
		people.setAddress(address);
		people.setBirthDate(calendar.getTime());
		people.setMaritalStatus(MaritalStatus.SINGLE);
		
//    	em.persist(people);
    	
    	people = em.merge(people);
    	
    	Parent father = new Parent();
    	ParentId fatherId = new ParentId();
    	fatherId.setPersonId(people.getId());
    	fatherId.setParentType(ParentType.FATHER);
    	
		father.setId(fatherId);
		father.setName("Nuttipol");
		
		em.persist(father);
		
		em.getTransaction().commit();
		
		Assert.assertEquals("Nuttipol", father.getName());
		
	}
}
