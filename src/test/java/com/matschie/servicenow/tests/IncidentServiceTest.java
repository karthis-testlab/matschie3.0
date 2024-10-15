package com.matschie.servicenow.tests;

import org.testng.annotations.Test;

import com.matschie.servicenow.servcies.IncidentService;
import com.matschie.testng.apis.TestNGHooks;

public class IncidentServiceTest extends TestNGHooks {
	
	@Test
	public void validateCreateIncidentCall() {		
		IncidentService incident = new IncidentService();
		incident.createIncident();
		
		// new IncidentService().createIncident();
	}

}