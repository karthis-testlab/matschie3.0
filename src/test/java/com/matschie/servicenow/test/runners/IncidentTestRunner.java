package com.matschie.servicenow.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/com/matschie/servicenow/features/incident.feature",
		          glue = {"com.matschie.servicenow.stepdefinitions", "com.matshie.servicenow.cucumber.hooks"},
		          dryRun = false,
		          monochrome = true,
		          plugin = {
		        		  "pretty",	
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		          }
		         )
public class IncidentTestRunner extends AbstractTestNGCucumberTests {

}