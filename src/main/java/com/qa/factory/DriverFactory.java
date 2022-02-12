package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author jimil
 *
 */
public class DriverFactory 
{
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); //Creating an object of ThreadLocal Class for storing the values of WebDriver.
	//"ThreadLocal" Class is used to maintain WebDrivers and perform Parallel execution of the Tests over multiple Browsers
	
	/*This is used to set up driver with ThreadLocal on the basis of given browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser value is: " + browser);
		/*if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if (browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}*/
		if(browser.equals("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			tlDriver.set(new FirefoxDriver());
		} 
		else if (browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			tlDriver.set(new ChromeDriver());	  
		}
		else
		{
			System.out.println("Please enter an appropriate browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/*This is used to get the driver with ThreadLocal
	*
	*@return
	*
	*/
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
}
