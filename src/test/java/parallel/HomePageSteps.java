package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps 
{
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	private HomePage hp;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable CredTable) 
	{
	  List<Map<String, String>> credList = CredTable.asMaps();
	  String userName = credList.get(0).get("username");
	  String passWord = credList.get(0).get("password");
	  
	  DriverFactory.getDriver().get("https://www.saucedemo.com/");
	  hp = lp.doLogin(userName, passWord);
	  
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() 
	{
		String title = hp.getHomePageTitle();
		System.out.println("The Home Page Title as Displayed is: " + title);
	}

	@When("user gets the header of the page")
	public void user_gets_the_header_of_the_page() 
	{
	  Assert.assertTrue(hp.validateHomePageHeader());
	}

	@Then("page header should be {string}")
	public void page_header_should_be(String expHeader) 
	{
		String header = hp.getHomePageHeader();
		Assert.assertEquals(header,expHeader);
	}

	@When("user clicks on Hamburger icon on the top left corner")
	public void user_clicks_on_hamburger_icon_on_the_top_left_corner() 
	{
	    hp.clickOnMenuIcon();
	}

	@Then("user gets a list of Menu items")
	public void user_gets_a_list_of_menu_items(DataTable MenuItemList) 
	{
	    List<String> expectedMenuItemList = MenuItemList.asList();
	    System.out.println("Expected Menu Item List: " + expectedMenuItemList);
	    
	    List<String> actualMenuItemList = hp.getMenuItemsList();
	    System.out.println("Actual Menu Item List: " + actualMenuItemList);
	    
	    Assert.assertTrue(expectedMenuItemList.containsAll(actualMenuItemList));
	}

	@Then("Menu items count should be {int}")
	public void menu_items_count_should_be(Integer expectedCount) 
	{
	   Assert.assertTrue(hp.getMenuItemsListsize() == expectedCount);
	}
}
