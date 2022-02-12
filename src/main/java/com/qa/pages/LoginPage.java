package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	//By Locators/Object Repository:
	private WebDriver driver;
	private By userId = By.id("user-name");
	private By password = By.id("password");
	private By signInButton = By.id("login-button");
	
	//Constructor of the Page Class:
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Page Actions/Methods:
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(userId).sendKeys(username);
	}
	
	public void enterPassword (String psswd)
	{
		driver.findElement(password).sendKeys(psswd);
	}
	
	public void clickOnSignInButton()
	{
		driver.findElement(signInButton).click();
	}
	
	public HomePage doLogin(String un, String pwd)
	{
		System.out.println("Login By: " + un +" & " + pwd);
		driver.findElement(userId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new HomePage(driver);
	}
	
	
}
