package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidaNavigation extends Base {
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver=InitiliazeDriver();
		driver.get("http://www.qaclickacademy.com");
	}
	@Test
	public void basePageNavigation() throws IOException
	{
		
		LandingPage L=new LandingPage(driver);
	    //L.getLogin().click();
		Assert.assertEquals(L.getTitle().getText(), "FEATURED COURSES");
		
	}
		@AfterTest
		public void teardown()
		{
			driver.close();
			driver=null;
		}
	   
	  
	
	

}