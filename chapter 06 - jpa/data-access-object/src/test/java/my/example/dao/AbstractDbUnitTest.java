package my.example.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractDbUnitTest {
	protected static IDataSet dataset;
	protected static IDatabaseConnection iDatabaseConnection;

	protected static EntityManager em;
	protected static Connection connection;

	@BeforeClass
	public static void initEntityManager() throws DatabaseUnitException, IOException {
		em = Persistence.createEntityManagerFactory("jpa_local").createEntityManager();
		
		em.getTransaction().begin();
		
		iDatabaseConnection = new DatabaseConnection(em.unwrap(java.sql.Connection.class));
		iDatabaseConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
		
		connection	= 	em.unwrap(java.sql.Connection.class);
		
		dataset = new XlsDataSet(new File("src/test/data/case-1.xls"));
		
		em.getTransaction().commit();
	}

	@AfterClass
	public static void closeEntityManager() {
		em.close();
	}
	
	@Before
	public void cleanDB() throws DatabaseUnitException, SQLException {
		DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataset);
	}
}
