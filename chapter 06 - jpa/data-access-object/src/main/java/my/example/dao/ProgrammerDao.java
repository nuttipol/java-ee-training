package my.example.dao;

import java.sql.SQLException;
import java.util.List;

import my.example.jpa.lab03.Programmer;

public interface ProgrammerDao {
	public Programmer find(long id) throws SQLException;
	public List<Programmer> findByName(String name)throws SQLException;
	public List<Programmer> findByCriteria(Programmer programmer);
}
