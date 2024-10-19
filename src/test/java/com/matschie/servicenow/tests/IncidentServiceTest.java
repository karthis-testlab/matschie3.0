package com.matschie.servicenow.tests;

import org.testng.annotations.Test;

import com.matschie.servicenow.servcies.IncidentService;
import com.matschie.testng.apis.TestNGHooks;

public class IncidentServiceTest extends TestNGHooks {
	
	IncidentService incident = new IncidentService();
	
	@Test
	public void validateCreateIncidentCall() {		
		response = incident.createIncident();
		incident.validateSuccessResponse(response);
		System.out.println(incident.extractSysId(response));
	}	

}