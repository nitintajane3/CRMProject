package com.qa.login;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.qa.utils.TestUtils;


public class LoginTest extends TestBase
{

	LoginPage loginPage ;
	HomePage homePage;
	String sheetname = "Sheet1";

	public LoginTest() throws IOException 
	{
		super();
		
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void initialiseBrowser() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@DataProvider
	public  Object[][] getDataExcel() throws IOException, InvalidFormatException
	{
		 Object objects[][] = TestUtils.getTestData(sheetname);
		 return objects;
	}
	
	
	@Test(dataProvider="getDataExcel")
	public void loginTestone(String username, String passwrod) throws IOException
	{
		loginPage.login(username,passwrod);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		 driver.quit();
	}
	

}
