package parallel;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps 
{
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String logintitle;
	
	@Given("user is on login page")
	public void user_is_on_login_page() 
	{
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() 
	{
		logintitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is: " +logintitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		Assert.assertEquals(logintitle, expectedTitle);
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) 
	{
	    loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) 
	{
	    loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() 
	{
		loginPage.clickOnSignInButton();
	}
}
