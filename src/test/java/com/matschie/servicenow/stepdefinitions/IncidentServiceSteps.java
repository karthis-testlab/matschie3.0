package com.matschie.servicenow.stepdefinitions;

import static io.restassured.RestAssured.basePath;

import java.util.List;

import com.matschie.pojo.serialization.IncidentRequestPayload;
import com.matschie.servicenow.servcies.IncidentService;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class IncidentServiceSteps {
	
	IncidentRequestPayload requestPayload = new IncidentRequestPayload();
	IncidentService incident = new IncidentService();
	Response response;

	@Given("set the base path of the service now incident table")
	public void set_the_base_path_of_the_service_now_incident_table() {
		basePath = "/api/now/table";
	}

	@When("/^send the post request for the incident service to create one record with (.*) short description$/")
	public void send_the_post_request_for_the_incident_service_to_create_one_record_with_restapisep2024_short_description(String arg) {
		requestPayload.setShort_description(arg);
	}

	@When("/^send the post request for the incident service to create record with (.*) description$/")
	public void send_the_post_request_for_the_incident_service_to_create_record_with_rest_api_post_call_description(String arg) {
		requestPayload.setDescription(arg);
		response = incident.createIncident(requestPayload);
	}

	@Then("ensure the record successfully create")
	public void ensure_the_record_successfully_create(DataTable dataTable) {
		List<List<String>> cells = dataTable.cells();
		for (int i = 1; i < cells.size(); i++) {
			incident.valdiateStatuscode(response, Integer.parseInt(cells.get(i).get(0)));
			incident.valdiateStatusLine(response, cells.get(i).get(1));
			incident.valdiateContentType(response, cells.get(i).get(2));
		}
	}

}