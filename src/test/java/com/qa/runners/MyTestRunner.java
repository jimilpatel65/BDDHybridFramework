package com.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resource/com/qa/features"},
			glue = {"com/qa/steps", "com/qa/hooks"},
			plugin = {"pretty", 
					"summary",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //Generates Extent Spark Reports
					"timeline:test-output-ThreadReport/"}, //Generates HTML Report for the Parallel Execution Time-line
			publish = true
		)
public class MyTestRunner 
{
}
