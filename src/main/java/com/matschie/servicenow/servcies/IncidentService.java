package com.matschie.servicenow.servcies;

import static io.restassured.RestAssured.*;
import java.io.File;

import com.matschie.testng.apis.TestNGHooks;

public class IncidentService extends TestNGHooks {
	
	public void createIncident(String requestPayload) {
		
	}
	
	public void createIncident(File requestPayload) {
		
	}
	
	public void createIncident(Object requestPayload) {
		
	}
	
	public void createIncident() {
		response = given()
				       .header("Content-Type", "application/json")
				   .when()
				       .post("/incident");
				   
	}

}