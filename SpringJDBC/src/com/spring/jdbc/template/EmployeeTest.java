package com.spring.jdbc.template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {

	private static EmployeeDAO empDO = null;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.context.bean.xml");
		empDO = (EmployeeDAO) context.getBean("employeeDAOBean");
		
		// jdbcTemplateTest();

		// jdbcPreparedStatementTest();

		jdbcResultSetExtractorTest();
		
		jdbcRowMapperTest();
		
		namedTemplateTest();
	}

	private static void jdbcTemplateTest() {
		int status = empDO.saveEmployee(new Employee(1012, "Khalid", "Marketing"));
		System.out.println("Save Employee status : " + status);

		Employee e = new Employee();
		e.setEmp_id(1004);
		status = empDO.deleteEmployee(e);
		System.out.println("Delete Employee status : " + status);

	}

	private static void jdbcPreparedStatementTest() {
		Boolean b = empDO.saveEmployeeByPreparedStatement(new Employee(1013, "Ravi", "Marketing"));
	}

	private static void jdbcResultSetExtractorTest() {
		List<Employee> list = empDO.getAllEmployees();
		for (Employee e : list) {
			System.out.println("^ " + e);
		}
	}
	
	private static void jdbcRowMapperTest() {
		List<Employee> list = empDO.getAllEmployeesUsingRowMapper();
		for (Employee e : list) {
			System.out.println("* " + e);
		}
		
	}
	
	private static void namedTemplateTest() {
		empDO.saveUsingNamedParameterJdbcTemplate(new Employee(2002, "Madan", "Purchase & Delivery"));
	}
}
