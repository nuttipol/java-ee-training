package my.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.jpa.ProgrammerJpaImpl;
import my.example.jpa.lab03.Programmer;

@Slf4j
public class ProgrammerJpaImplTest extends AbstractDbUnitTest{
	
	private ProgrammerDao programmerDao;
	
	@Before
	public void setUp() throws Exception {
		log.trace("Begin setUp -------------- ");
		programmerDao = new ProgrammerJpaImpl(em);
		
		int rowCount = dataset.getTable("programmer").getRowCount(); 
    	log.info("rowcount="+rowCount);
	}
	
	@Test
	public void testJpaFindByCriteria() throws SQLException, DataSetException {
		Programmer cr = new Programmer();
		cr.setName("Peter");
		
		List<Programmer> programmers = programmerDao.findByCriteria(cr);
		log.info("testJpaFindByCriteria>>"+programmers);
		
		Assert.assertEquals(1, programmers.size());
		Assert.assertEquals("Peter", programmers.get(0).getName());
	}
	
	@Test
	public void testJpaFindByName() throws SQLException, DataSetException {
		List<Programmer> programmers = programmerDao.findByName("Tony");
		log.info("testJpaFindByName>>"+programmers);
		
		Assert.assertEquals(1, programmers.size());
		Assert.assertEquals("Tony", programmers.get(0).getName());
	}
	
	@Test
	public void testJpaInsert() throws SQLException, DataSetException {
		Programmer programmer = new Programmer();
		programmer.setName("Thor");
		
		em.getTransaction().begin();
		programmer = programmerDao.insert(programmer);
		em.getTransaction().commit();
		
		log.info("testJpaInsert>>"+programmer);
		
		Assert.assertEquals(1, programmer.getVersion());
	}
}
