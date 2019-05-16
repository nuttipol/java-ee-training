package my.example.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab07.Cabinet;
import my.example.jpa.lab07.CabinetUser;
import my.example.jpa.lab07.Privilege;
import my.example.jpa.lab07.User;

@Slf4j
public class Lab07Test {

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

		User a = em.merge(new User("A"));
		User b = em.merge(new User("B"));
		
		Cabinet c1 = em.merge(new Cabinet("c1",a));
		Cabinet c2 = em.merge(new Cabinet("c2",b));
		
		Privilege C = em.merge(new Privilege("C"));
		Privilege R = em.merge(new Privilege("R"));
		Privilege U = em.merge(new Privilege("U"));
		Privilege D = em.merge(new Privilege("D"));
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		c1.addCabinetUser(new CabinetUser(c1,a,new ArrayList<Privilege>(Arrays.asList(C,R,U,D))));
		c1.addCabinetUser(new CabinetUser(c1,b,new ArrayList<Privilege>(Arrays.asList(R))));

		c2.addCabinetUser(new CabinetUser(c2,a,new ArrayList<Privilege>(Arrays.asList(C,R))));
		c2.addCabinetUser(new CabinetUser(c2,b,new ArrayList<Privilege>(Arrays.asList(U,D))));

		em.merge(c1);
		em.merge(c2);
		
		em.getTransaction().commit();
		
		List<Cabinet> result = em.createQuery("select u from Cabinet u",Cabinet.class).getResultList();
		
		log.info("result.size()="+result.size());
		
		for (Cabinet cabinet :result) {
			log.info(cabinet.getName());

			for (CabinetUser cabinetUser : cabinet.getCabinetUsers()) {
				log.info("	"+cabinetUser.getUser().getName());
				
				for (Privilege privilege : cabinetUser.getPrivileges()) {
					log.info("		"+privilege.getName());	
				}
			}
		}
	
	}
}
