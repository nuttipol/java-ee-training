package my.example.chapter01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import my.example.chapter01.dao.EmployeeDao;
import my.example.chapter01.dao.qualifier.DatabaseApi;
import my.example.chapter01.model.Employee;

/**
 * This is a sample concept for Implement EmployeeDAO with JDBC (can not be run)
 *
 */
@ApplicationScoped
@DatabaseApi(name = DatabaseApi.JDBC)
public class EmployeeJdbcImpl implements EmployeeDao {
	
	private Connection connection;

	@Override
	public Employee find(String id) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Employee member = null;
		try {
			String selectSQL = "SELECT * FROM t_person where id = ? ";

			try {
				preparedStatement = this.connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, id);

				rs = preparedStatement.executeQuery();

				if (rs.next()) {
					member = new Employee();

					member.setId(rs.getString("id"));
					member.setFirstName(rs.getString("f_name"));
					member.setLastName(rs.getString("l_name"));
				}
			} finally {
				if (rs != null)
					rs.close();
			}
			return member;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}

	@Override
	public List<Employee> findByName(String name) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Employee> personList = new ArrayList<>();
		try {
			String selectSQL = "SELECT * FROM t_person where f_name = ? ";

			try {
				preparedStatement = this.connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, name);

				rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Employee member = new Employee();

					member.setId(rs.getString("id"));
					member.setFirstName(rs.getString("f_name"));
					member.setLastName(rs.getString("l_name"));

					personList.add(member);
				}
			} finally {
				if (rs != null)
					rs.close();
			}
			return personList;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}

	@Override
	public void insert(Employee member) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			String selectSQL = "insert into t_person values (?,?,?)";

			preparedStatement = this.connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getFirstName());
			preparedStatement.setString(3, member.getLastName());

			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}

}
