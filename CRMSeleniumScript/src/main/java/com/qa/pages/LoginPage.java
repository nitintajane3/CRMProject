package com.qa.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends com.qa.testbase.TestBase
{
	
	
	
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver , this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//button[@class='btn small btn-secondary ng-binding']")
	WebElement signinbuttonmac;
	
	@FindBy(xpath="//button[@class='btn small btn-secondary ng-binding']")
	WebElement signinbutton;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement usernamefield;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement  loginbtn;
	
	
	public void login(String username,String passwrod) throws IOException
	{
		
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(passwrod);
		loginbtn.click();
		
		
	}
	
	

}
