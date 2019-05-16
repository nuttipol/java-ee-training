package my.example.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.jdbc.ProgrammerJdbcImpl;
import my.example.dao.jpa.ProgrammerJpaImpl;
import my.example.jpa.lab03.Programmer;

@Slf4j
public class ProgrammerImplTest extends DBTestCase{
	private Connection  con;
	private EntityManager  em;
	
    public ProgrammerImplTest(String name) throws IOException{
        super( name );
        Properties prop = new Properties();
		InputStream inputStream = DSM.class.getClassLoader().getResourceAsStream("jdbc.proeperties");
		 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file jdbc.proeperties not found in the classpath");
		}
		
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, prop.getProperty("class.name"));
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, prop.getProperty("url") );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
    }
    private IDataSet loadedDataSet;
	@Override
    protected IDataSet getDataSet() throws Exception{
		loadedDataSet = new XlsDataSet(new File("src/test/data/case-1.xls"));
		return loadedDataSet;
    }
	
	public void setUp() throws Exception {
		con = DSM.createLocalConnection();
		em = EMF.createLocalEntityManager(); 
		super.setUp();
	}

	public void tearDown() throws Exception {
		con.close();
		em.close(); 
		super.tearDown();
	}
	 
	@Test
	public void testFindByName() throws SQLException {
		ProgrammerJdbcImpl jdbc = new ProgrammerJdbcImpl(con);
		log.info("testFindByName>>"+jdbc.findByName("Steve").toString());
	}
	
	@Test
	public void testJpaFindByCriteria() throws SQLException, DataSetException {
		int rowCount = loadedDataSet.getTable("programmer").getRowCount(); 

    	log.info("rowcount="+rowCount);
		ProgrammerJpaImpl jpa = new ProgrammerJpaImpl(em);
		Programmer cr = new Programmer();
		cr.setName("Peter");
		log.info("testJpaFindByCriteria>>"+jpa.findByCriteria(cr));
	}
	
	@Test
	public void testJpaFindByName() throws SQLException, DataSetException {
		int rowCount = loadedDataSet.getTable("programmer").getRowCount(); 

    	log.info("rowcount="+rowCount);
		ProgrammerJpaImpl jpa = new ProgrammerJpaImpl(em);
		log.info("testJpaFindByName>>"+jpa.findByName("Tony"));
	}
}
