package com.flywaychallenge.app;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import com.flywaychallenge.services.EmployeeService;

public class Driver {

	private static final Logger logger = Logger.getLogger(Driver.class);
	private static Boolean continueFlyway = true;
	
	public static void main(String[] args) {
		//Create instance of flyway
		FlywayHelper flywayHelper = new FlywayHelper();
		Flyway flyway = flywayHelper.getFlyway();
		
		try{
			/*
			 * ---------------------------------
			 * CONFIG FLYWAY / PERFORM MIGRATION
			 * ---------------------------------
			 */

			System.out.println(flywayHelper.getInfo());
		}
		catch(FlywayException e){
			logger.error("Unable to migrate: " + e.getMessage());
			continueFlyway = false;
		}
		
		//Print employees to console
		if(continueFlyway){
			EmployeeService empService = new EmployeeService(new DbUtil());
			empService.printEmployeeList();
		}
		else{
			System.out.println("flyway migration failed.");
		}
	}
}
