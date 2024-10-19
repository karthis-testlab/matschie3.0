package com.matschie.servicenow.servcies;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.io.File;

import com.google.gson.Gson;

import io.restassured.response.Response;

public class IncidentService {
	
	public Response createIncident(String requestPayload) {
		return given()
			       .header("Content-Type", "application/json")
			   .when()
			       .body(requestPayload)
			       .post("/incident");
	}
	
	public Response createIncident(File requestPayload) {
		return given()
			       .header("Content-Type", "application/json")
			   .when()
			       .body(requestPayload)
			       .post("/incident");
	}
	
	public Response createIncident(Object requestPayload) {
		return given()
			       .header("Content-Type", "application/json")
			   .when()
			       .body(new Gson().toJson(requestPayload))
			       .post("/incident");
	}
	
	public Response createIncident() {
		return given()
				       .header("Content-Type", "application/json")
				   .when()
				       .post("/incident");				   
	}
	
	public void validateSuccessResponse(Response response) {
		assertThat(response.getStatusCode(), equalTo(201));
		assertThat(response.getStatusLine(), containsString("Created"));
		assertThat(response.getContentType(), containsString("application/json"));
	}
	
	public String extractSysId(Response response) {
		return response.jsonPath().getString("result.sys_id");
	}
	
	public void validateShortDescriptionValue(Response response, String expected) {
		assertThat(response.jsonPath().getString("result.short_description"), equalTo(expected));
	}
	
	public void validateDescriptionValue(Response response, String expected) {
		assertThat(response.jsonPath().getString("result.description"), equalTo(expected));
	}
	
	public void valdiateStatuscode(Response response, int statusCode) {
		assertThat(response.getStatusCode(), equalTo(statusCode));
	}

	public void valdiateStatusLine(Response response, String statusLine) {
		assertThat(response.getStatusLine(), containsString(statusLine));
	}

	public void valdiateContentType(Response response, String contentType) {
		assertThat(response.getContentType(), containsString(contentType));
	}

}