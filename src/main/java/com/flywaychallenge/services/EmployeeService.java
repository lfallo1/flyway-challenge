package com.flywaychallenge.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.BadSqlGrammarException;

import com.flywaychallenge.app.DbUtil;
import com.flywaychallenge.models.Employee;

public class EmployeeService {
	
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	private DbUtil dbUtil;
	
	public EmployeeService(DbUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
	
	public void printEmployeeList(){
		try{
			List<Employee> listEmp = dbUtil.getEmployeeDao().getAll();
			for (Employee e : listEmp) {
				e.setDepartment(dbUtil.getDepartmentDao().getById(e.getDepartment().getId()));
			}
			for (Employee e : listEmp) {
				System.out.println(e.getName() + " " + e.getJobTitle() + " ( started " + e.getStartDate().toString("MMMM-dd-YYYY") + " )"
						+ " - Department: " + e.getDepartment().toString());
			}
		}
		catch(BadSqlGrammarException e){
			logger.error("Unable to execute query " + e.getMessage());
		}
	}
}
