package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tamplo.qa.testbase.TestBase;

public class HomePage extends TestBase
{

	public HomePage() throws IOException
	{
		
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//h5[normalize-space()='Login']")
	WebElement logintitle;
	
	
	
	
	
	
	public String veryfyloginPage() 
	{
		String loginpage = logintitle.getText();
		
		return loginpage;
	}
	
	
	
	

}
