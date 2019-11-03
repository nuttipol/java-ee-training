package my.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.jdbc.ProgrammerJdbcImpl;
import my.example.dao.jpa.ProgrammerJpaImpl;
import my.example.jpa.lab03.Programmer;

@Slf4j
public class ProgrammerTest extends AbstractDbUnitTest{
	
	private ProgrammerDao programmerJdbcDao;
	private ProgrammerDao programmerJpaDao;

	@Before
	public void setUp() throws Exception {
		log.trace("Begin setUp -------------- ");
		programmerJdbcDao 	= new ProgrammerJdbcImpl(connection);
		programmerJpaDao 	= new ProgrammerJpaImpl(em);
		
		int rowCount = dataset.getTable("programmer").getRowCount(); 
    	log.info("rowcount="+rowCount);
	}

	@Test
	public void testFindById() throws SQLException, DataSetException {
		Programmer programmerJdbc = programmerJdbcDao.find(1);
		log.info("programmerJdbc>>"+programmerJdbc);
		
		Programmer programmerJpa = programmerJpaDao.find(1);
		log.info("programmerJpa>>"+programmerJpa);
		
		Assert.assertEquals(programmerJpa.getName(), programmerJdbc.getName());
	}
	
	@Test
	public void testFindByName() throws SQLException, DataSetException {
		List<Programmer> programmerJdbcs = programmerJdbcDao.findByName("Tony");
		log.info("programmerJdbcs>>"+programmerJdbcs);
		
		List<Programmer> programmerJpas = programmerJpaDao.findByName("Tony");
		log.info("programmerJpas>>"+programmerJpas);
	
		Assert.assertEquals(programmerJpas.size(), programmerJdbcs.size());
		Assert.assertEquals(programmerJpas.get(0).getName(), programmerJdbcs.get(0).getName());
		
	}


	@Test
	public void testJpaFindByCriteria() throws SQLException, DataSetException {
		Programmer cr = new Programmer();
		cr.setName("Peter");
		
		List<Programmer> programmers = programmerJpaDao.findByCriteria(cr);
		log.info("testJpaFindByCriteria>>"+programmers);
		
		Assert.assertEquals(1, programmers.size());
		Assert.assertEquals("Peter", programmers.get(0).getName());
	}
	
	
	@Test
	public void testJpaInsert() throws SQLException, DataSetException {
		Programmer programmer = new Programmer();
		programmer.setId(4L);
		programmer.setName("Thor");
		
		em.getTransaction().begin();
		programmer = programmerJpaDao.insert(programmer);
		em.getTransaction().commit();
		
		log.info("testJpaInsert>>"+programmer);
		
		Assert.assertEquals(1, programmer.getVersion());
	}
}
