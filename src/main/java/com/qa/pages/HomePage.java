package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
	private WebDriver driver;
	private List<WebElement> menulist;
	private By header = By.xpath("//span[contains(text(),'Products')]");
	private By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");
	private By menuList = By.xpath("//div[@class='bm-menu']/nav//a");
	
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateHomePageHeader()
	{
		return driver.findElement(header).isDisplayed();
	}
	
	public String getHomePageHeader()
	{
		return driver.findElement(header).getText();
	}
	
	public void clickOnMenuIcon()
	{
		driver.findElement(menuButton).click();
	}
	
	public List<String> getMenuItemsList()
	{
		List<String> listOfItems = new ArrayList<>();
		menulist = driver.findElements(menuList);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		for(WebElement e: menulist)
		{
			String text = e.getText();
			System.out.println(text);
			listOfItems.add(text);
		}
		return listOfItems;
	}
	
	public int getMenuItemsListsize()
	{
		menulist = driver.findElements(menuList);
		return menulist.size(); 
	}
	
}
