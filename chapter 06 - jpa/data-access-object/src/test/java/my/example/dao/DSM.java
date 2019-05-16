package my.example.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DSM {
	public static Connection createLocalConnection() throws ClassNotFoundException, SQLException, IOException {
		Properties prop = new Properties();
		InputStream inputStream = DSM.class.getClassLoader().getResourceAsStream("jdbc.proeperties");
		 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file jdbc.proeperties not found in the classpath");
		}
		Class.forName(prop.getProperty("class.name"));
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
	}
}
