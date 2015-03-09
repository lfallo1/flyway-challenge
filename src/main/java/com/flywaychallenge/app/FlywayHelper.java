package com.flywaychallenge.app;

import java.util.ResourceBundle;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;

public class FlywayHelper {
	private static final String APP_PROPERTIES_PATH = "app";
	private Flyway flyway = null;
	
	public FlywayHelper(){
		ResourceBundle bundle = ResourceBundle.getBundle(APP_PROPERTIES_PATH);
		String url = bundle.getObject("url").toString();
		String username = bundle.getObject("user").toString();
		String password = bundle.getObject("password").toString();
		String locations = bundle.getObject("locations").toString();
		
		flyway = new Flyway();
		flyway.setDataSource(url, username, password);
		flyway.setLocations(locations);			
	}
	
	public String getInfo(){
		MigrationInfoService service = flyway.info();
		StringBuilder sb = new StringBuilder();
		for (MigrationInfo info : service.all()) {
			sb.append(String.format("<<version %s>>\t<<description %s>>\t<<state %s>>\r\n", info.getVersion().getVersion(), info.getDescription(), info.getState().getDisplayName()));
		}	
		return sb.toString();
	}

	public Flyway getFlyway() {
		return flyway;
	}

	public void setFlyway(Flyway flyway) {
		this.flyway = flyway;
	}

}
