package com.suntaragali.freecrm.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/suntaragali/freecrm/resources/freeCRM.feature"},
		glue = {"com.suntaragali.freecrm.step_definitions"},
		plugin= { "pretty", "html:target/test-output"},
		monochrome=true,
		dryRun=false,
		strict = true
		)
		
public class TestRunner {


}
