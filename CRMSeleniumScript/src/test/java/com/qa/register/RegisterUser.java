package com.qa.register;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;

public class RegisterUser extends TestBase
{

	LoginPage loginPage ; 
	
	public RegisterUser() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void initialiseBrowser() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void RegisterUser() 
	{
		System.out.println("Registered user test has finish");
	}
	
	@AfterMethod
	public void tearDown()
	{
		 driver.quit();
	}
}
