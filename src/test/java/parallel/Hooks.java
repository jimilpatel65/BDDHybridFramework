package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
	
	private DriverFactory driverF;
	private WebDriver driver;
	private ConfigReader configR;
	Properties prop;
	
	@Before (order = 0)
	public void getProperty()
	{
		configR = new ConfigReader();
		prop = configR.init_prop();
	}
	
	@Before (order = 1)
	public void setUpBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverF = new DriverFactory();
		driver = driverF.init_driver(browserName);
	}
	
	@After (order = 1)
	public void takeScreenShot(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			String screenShotName = scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
		}
	}
	@After (order = 0)
	public void tearDownBrowser()
	{
		driver.quit();
	}
}
