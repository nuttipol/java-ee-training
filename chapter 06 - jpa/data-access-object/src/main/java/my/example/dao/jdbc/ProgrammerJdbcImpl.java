package my.example.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import my.example.dao.ProgrammerDao;
import my.example.jpa.lab03.Programmer;

@Slf4j
public class ProgrammerJdbcImpl implements ProgrammerDao {
	public ProgrammerJdbcImpl(Connection connection){
		this.connection = connection;
	}
	
	private Connection connection;

	@Override
	public Programmer find(long id) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Programmer programmer= null;
		try {
			String selectSQL = "SELECT * FROM programmer where id = ? ";
			
			log.debug("selectSQL = {}", selectSQL);
			try{
				preparedStatement = this.connection.prepareStatement(selectSQL);
				preparedStatement.setLong(1, id);
				
				rs = preparedStatement.executeQuery();
				
				if (rs.next()) {
					programmer = new Programmer();
					
					programmer.setId(rs.getLong("id"));
					programmer.setName(rs.getString("name"));
					programmer.setVersion(rs.getInt("version_id"));
				}
			} finally {
				if (rs != null) rs.close();
			}
			return programmer;
		} finally {
			if (preparedStatement != null) preparedStatement.close();
		}
	}
 
	@Override
	public List<Programmer> findByName(String name) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Programmer> programmers= new ArrayList<>();
		try {
			String selectSQL = "SELECT * FROM programmer where name = ? ";
			
			log.debug("selectSQL = {}", selectSQL);
			try{
				preparedStatement = this.connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, name);
				
				rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					Programmer programmer = new Programmer();
					
					programmer.setId(rs.getLong("id"));
					programmer.setName(rs.getString("name"));
					programmer.setVersion(rs.getInt("version_id"));
					
					programmers.add(programmer);
				}
			} finally {
				if (rs != null) rs.close();
			}
			return programmers;
		} finally {
			if (preparedStatement != null) preparedStatement.close();
		}
	}

	@Override
	public List<Programmer> findByCriteria(Programmer programmer) {
		return null;
	}

}
