package com.flywaychallenge.app;

import java.util.ResourceBundle;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.flywaychallenge.dao.DepartmentDao;
import com.flywaychallenge.dao.EmployeeDao;

public class DbUtil {
	private static final String APP_PROPERTIES_PATH = "app";
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private DataSource dataSource;

	public DbUtil(){
		setupDatabaseConnection();
		employeeDao = new EmployeeDao();
		employeeDao.setJdbcTemplate(dataSource);
		departmentDao = new DepartmentDao();
		departmentDao.setJdbcTemplate(dataSource);
	}
	private void setupDatabaseConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle(APP_PROPERTIES_PATH);
		dataSource = new DataSource();
		dataSource.setUrl(bundle.getString("url"));
		dataSource.setUsername(bundle.getString("user"));
		dataSource.setPassword(bundle.getString("password"));
		dataSource.setDriverClassName(bundle.getString("driver"));
	}
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
}
