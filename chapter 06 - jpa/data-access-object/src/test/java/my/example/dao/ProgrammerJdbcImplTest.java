package my.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.dataset.DataSetException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.jdbc.ProgrammerJdbcImpl;
import my.example.jpa.lab03.Programmer;

@Slf4j
public class ProgrammerJdbcImplTest extends AbstractDbUnitTest{
	
	private ProgrammerDao programmerDao;
	
	@Before
	public void setUp() throws Exception {
		log.trace("Begin setUp -------------- ");
		programmerDao = new ProgrammerJdbcImpl(connection);
		
		int rowCount = dataset.getTable("programmer").getRowCount(); 
    	log.info("rowcount="+rowCount);
	}

	@Test
	public void testJdbcFindById() throws SQLException, DataSetException {
		Programmer programmer = programmerDao.find(1);
		log.info("testJdbcFindById>>"+programmer);
		
		Assert.assertEquals("Steve", programmer.getName());
	}
	
	@Test
	public void testJdbcFindByName() throws SQLException, DataSetException {
		List<Programmer> programmers = programmerDao.findByName("Tony");
		log.info("testJdbcFindByName>>"+programmers);
		
		Assert.assertEquals(1, programmers.size());
		Assert.assertEquals("Tony", programmers.get(0).getName());
	}
}
