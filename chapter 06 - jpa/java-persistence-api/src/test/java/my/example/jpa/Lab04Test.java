package my.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab04.Labtop;
import my.example.jpa.lab04.Locker;
import my.example.jpa.lab04.Mobile;
import my.example.jpa.lab04.Student;

@Slf4j
public class Lab04Test {

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

		Labtop lt = new Labtop("SONY");
		Locker lk = new Locker("L1");
		
		Student student = new Student();
		student.setName("Nuttipol");
		student.setComputer(lt);
		student.setLocker(lk);
		
//		em.persist(lt);			
		em.persist(lk);				//	non cascade with locker']
		student = em.merge(student);
		
    	log.info("persist student.getId() : "+student.getId() );
    	
    	Mobile mobile1	= new Mobile("ASUS");
    	em.persist(mobile1);
    	Mobile mobile2	= new Mobile("LENOVO");
    	em.persist(mobile2);

    	tx.commit();
 
		log.info("persist student : " + student );
		log.info("persist phone : " + mobile1 );
		log.info("persist phone : " + mobile2 );
		
		tx.begin();
		
		Labtop labtop2 = new Labtop("DELL");
		
		em.persist(labtop2);
		
        tx.commit();

		log.info("persist labtop : "+labtop2 );
    
		tx.begin();
		
		Student student2 = em.find(Student.class, student.getId());

		student2.setComputer(labtop2);
		student2.setPhone(mobile2);
		em.persist(student2);
		
        tx.commit();
        
        log.info("update student");
        		
        Student student3 	= 	em.find(Student.class, student2.getId());
        em.refresh(student3);
        
		log.info("find student : "+ student3 );
		
		Assert.assertEquals("DELL", student3.getComputer().getBrand());
//		Assert.assertEquals("ASUS", student3.getPhone().getBrand());	Null Because @PrimaryKeyJoinColumn

		tx.begin();
		
		em.remove(student3);
		
		tx.commit();
		
		log.info("remove student");
		
		log.info("locker : "+ em.find(Locker.class, 1));	//	exists
		log.info("labtop 1 : "+ em.find(Labtop.class, 1));//	exists	
		log.info("labtop 2 : "+ em.find(Labtop.class, 2));	// delete from cascade
		
		
	}
}
