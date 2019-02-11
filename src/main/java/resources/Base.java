package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {

public static WebDriver driver;	
public Properties pro;

public WebDriver InitiliazeDriver() throws IOException
{
	pro=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\THENAPPAN SHANKAR\\Cucumber\\src\\main\\java\\resources\\base1.properties");
	pro.load(fis);
	String browserName=pro.getProperty("browser");
	
	
	if(browserName.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
	driver=new ChromeDriver();
	
}
	else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
		driver=new FirefoxDriver();
	}

	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.MicrosoftWeb.driver", "C:\\Users\\MicrosoftWebdriver.exe");
		driver=new EdgeDriver();
	}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}
public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(src, new File("C://"));
	FileHandler.copy(src, new File("C://Users//THENAPPAN SHANKAR//test//"+result+"Screenshot.png"));
}
}