package com.spring.jdbc.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedTemplate;
	
	// private SimpleJdbcTemplate simpleJdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {
		this.namedTemplate = namedTemplate;
	}


	// Insert record - Using JdbcTemplate
	public int saveEmployee(Employee e) {
		String query = "insert into employee values('" + e.getEmp_id() + "','" + e.getEmp_name() + "','" + e.getDepartment() + "')";
		return jdbcTemplate.update(query);
	}

	// Update record - Using JdbcTemplate
	public int updateEmployee(Employee e) {
		String query = "update employee set emp_id='" + e.getEmp_id() + "', emp_name='" + e.getEmp_name() + "', department='" + e.getDepartment() + "'";
		return jdbcTemplate.update(query);
	}

	// Delete record - Using JdbcTemplate
	public int deleteEmployee(Employee e) {
		String query = "delete from employee where emp_id=" + e.getEmp_id();
		return jdbcTemplate.update(query);
	}

	// Insert record - Using PreparedStatement
	public Boolean saveEmployeeByPreparedStatement(final Employee e) {
		String query = "insert into employee values (?, ?, ?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, e.getEmp_id());
				ps.setString(2, e.getEmp_name());
				ps.setString(3, e.getDepartment());
				return ps.execute();
			}
		});
	}

	// ResultSetExtractor
	public List<Employee> getAllEmployees() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Employee>>() {
			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list = new ArrayList<Employee>();
				while (rs.next()) {
					Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
					list.add(e);
				}
				return list;
			}
		});
	}
	
	// RowMapper - Better than ResultSetExtractor since RowMapper iterates result set and internally adds it to Collection.
	public List<Employee> getAllEmployeesUsingRowMapper() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, new RowMapper<Employee>(){
			@Override
			public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
				return e;
			}			
		});
	}
	
	// NamedParameterJdbcTemplate
	public void saveUsingNamedParameterJdbcTemplate(Employee e) {
		String query = "insert into employee values(:id, :name, :dept)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", e.getEmp_id());
		map.put("name", e.getEmp_name());
		map.put("dept",  e.getDepartment());
		
		namedTemplate.execute(query, map, new PreparedStatementCallback<Object>(){
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}
}
