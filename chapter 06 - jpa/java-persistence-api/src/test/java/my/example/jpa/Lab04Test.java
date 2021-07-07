package my.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab02.ParentId;
import my.example.jpa.lab02.ParentType;
import my.example.jpa.lab04.Labtop;
import my.example.jpa.lab04.Locker;
import my.example.jpa.lab04.Mobile;
import my.example.jpa.lab04.Student;
import my.example.jpa.lab04.StudentParent;
import my.example.jpa.lab04.StudentParentAge;

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
		
		EntityTransaction tx 	= 	em.getTransaction();

		tx.begin();
		
		Mobile asusMobile	= new Mobile("ASUS");
    	Mobile samsungMobile	= new Mobile("LENOVO");
    	
		Labtop labtop1 = new Labtop("SONY");
		Labtop labtop2 = new Labtop("DELL");
		
		Locker locker1 = new Locker("L1");

		Student student = new Student();
		student.setName("Nuttipol");
		student.setComputer(labtop1);
		student.setLocker(locker1);
		
		em.persist(asusMobile);
    	em.persist(samsungMobile);
		
    	em.persist(locker1);	//	must persist 
//		em.persist(labtop1);	// 	no need persist
    	em.persist(labtop2);
		student = em.merge(student);
		
		log.info("persist student.getId() : "+student.getId() );
    	log.info("persist student.getLocker().getId() : "+student.getLocker().getId() );
    	log.info("persist student.getComputer().getId() : "+student.getComputer().getId() );
    	log.info("persist mobile1.getId() : "+asusMobile.getId() );
    	log.info("persist mobile2.getId() : "+samsungMobile.getId() );
    	
    	Assert.assertNotNull(student.getId());
		Assert.assertNotNull(student.getLocker().getId());
		Assert.assertNotNull(student.getComputer().getId());
		Assert.assertNotNull(asusMobile.getId());
		Assert.assertNotNull(samsungMobile.getId());
    	    	
    	tx.commit();
 
		tx.begin();
		
		Student student2 = em.find(Student.class, student.getId());

		student2.setComputer(labtop2);
		student2.setPhone(samsungMobile);
		em.persist(student2);
		
        tx.commit();
        
        log.info("update student");
        		
        Student student3 	= 	em.find(Student.class, student2.getId());
        
        em.refresh(student3);
        
		log.info("find student : "+ student3.toString() );
		
		Assert.assertEquals("DELL", student3.getComputer().getBrand());

		tx.begin();
		
		em.remove(student3);
		
		tx.commit();
		
		log.info("remove student");
		
		Assert.assertEquals(1, em.createQuery("Select m from Labtop m ", Labtop.class).getResultList().size());
		Assert.assertEquals(1, em.createQuery("Select m from Locker m ", Locker.class).getResultList().size());
		
	}
	
	
	@Test
	public void testPrimaryKeyJoinColumn() throws Exception {
		
		EntityTransaction tx 	= 	em.getTransaction();

		tx.begin();
		
		Student student = new Student();
		student.setName("Nuttipol");
		student = em.merge(student);
		
		Mobile asusMobile	= new Mobile("ASUS");
		asusMobile.setId(student.getId().intValue());
		
		em.persist(asusMobile);
		
		Assert.assertNotNull(student.getId());
		 
		tx.commit();
		
		Student student2 	= 	em.find(Student.class, student.getId());
        
        em.refresh(student2);
        
        Assert.assertEquals("ASUS",student.getPhone().getBrand());
	}
	
	
	@Test
	public void testPrimaryJoinColumns() throws Exception {
		EntityTransaction tx 	= 	em.getTransaction();

		tx.begin();

		ParentId fatherId = new ParentId();
		fatherId.setPersonId(1);
		fatherId.setParentType(ParentType.FATHER);
		
		StudentParent father = new StudentParent();
		father.setId(fatherId);
		father.setName("dad");
		
		StudentParentAge fatherAge = new StudentParentAge();
		fatherAge.setId(fatherId);
		fatherAge.setAge(40L);
		
		father.setParentAge(fatherAge);
		
		em.persist(father);
		
		tx.commit();
		
		StudentParent studentParent = 	em.find(StudentParent.class, fatherId);
		
		Assert.assertEquals(40L,studentParent.getParentAge().getAge().longValue());
		
	}
}
