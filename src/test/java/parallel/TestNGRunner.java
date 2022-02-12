package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
			plugin = {"pretty",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/",
					"rerun:target/failedSC.txt"
					},
			glue = {"parallel"},
			features = {"src/test/resources/parallel/HomePage.feature"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests
{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
