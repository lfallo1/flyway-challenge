package com.flywaychallenge.app;

import org.flywaydb.core.Flyway;

import com.flywaychallenge.models.Employee;



public class Driver {

	public static void main(String[] args) {
		//Create instance of flyway
		FlywayHelper flywayHelper = new FlywayHelper();
		Flyway flyway = flywayHelper.getFlyway();
		//flyway.clean();
		flyway.migrate();
		DbUtil dbUtil = new DbUtil();

		//Do Stuff
		
		
		//Get flyway migration status
		System.out.println(flywayHelper.getInfo());
		for (Employee e : dbUtil.getEmployeeDao().getAll()) {
			System.out.println(e.getName() + " " + e.getJobTitle() + " ( started " + e.getStartDate().toString("MMMM-dd-YYYY") + " )");
		}
		
	}

}
