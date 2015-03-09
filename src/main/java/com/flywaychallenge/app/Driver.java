package com.flywaychallenge.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.flywaychallenge.models.Employee;



public class Driver {

	private static final Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		//Create instance of flyway
		FlywayHelper flywayHelper = new FlywayHelper();
		Flyway flyway = flywayHelper.getFlyway();
		
		//Migrate db using flyway object
		try{

		}
		catch(FlywayException e){
			logger.error("Unable to migrate: " + e.getMessage());
		}
		
		//Get flyway migration status
		System.out.println(flywayHelper.getInfo());
		
		//Get Data
		DbUtil dbUtil = new DbUtil();
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
			logger.error("Unable to execute query");
		}
		
	}

}
