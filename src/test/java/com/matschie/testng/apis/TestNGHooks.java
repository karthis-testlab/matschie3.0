package com.matschie.testng.apis;

import static io.restassured.RestAssured.*;
import static com.matschie.general.utils.PropertiesHandler.*;

import org.testng.annotations.BeforeMethod;

import io.restassured.response.Response;

public class TestNGHooks {
	
	protected Response response;
	
	@BeforeMethod
	public void beforeMethod() {
		baseURI = config("service.now.instance.baseUri");
		basePath = config("service.now.instance.basePath");
		authentication = basic(config("service.now.instance.username"), secret("service.now.instance.password"));
	}	
	
}