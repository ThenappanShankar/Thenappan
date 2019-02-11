package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver=InitiliazeDriver();
	
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
		driver.get("http://qaclickacademy.com");
		LandingPage L=new LandingPage(driver);
	    L.getLogin().click();
	    LoginPage Lp=new LoginPage(driver);
	   
	    Lp.getEmail().sendKeys(username);
	    
	    Lp.getPassword().sendKeys(password);
	    
	    System.out.println(text);
	  
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
@DataProvider
public Object[][] getData()
{

Object[][] data=new Object[2][3];
data[0][0]="thenulakhs@gmail.com";
data[0][1]="hari";
data[0][2]="This is my first data provider";

data[1][0]="hari0837@gmail.com";
data[1][1]="hello";
data[1][2]="This is my second data provider";

return data;
}

}