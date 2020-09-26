package com.versapay.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.versapay.qa.utils.Utils;
import com.versapay.qa.utils.WebEventsListener;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TestBase {
	
public static WebDriver driver;
public static Properties prop;
public static Logger logger;
public static EventFiringWebDriver edriver;//for event firing webdriver
public static WebEventsListener eventListener;//for event firing webdriver


public TestBase() {
	
	
	
	prop = new Properties();
	FileInputStream fis;//this should be discussed
	
	try {
		fis = new FileInputStream("./src\\main\\java\\com\\versapay\\qa\\configuration\\Config.properties"
				);
		prop.load(fis);
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



@BeforeClass
public void loggersetUp() {
	logger = Logger.getLogger(TestBase.class);//instatnsation of class
	PropertyConfigurator.configure("log4j.properties");
	BasicConfigurator.configure(); 
	logger.setLevel(Level.INFO);
	//logger file must be imported in the project .it is a standard template
}


	
	public void  initialisation() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	}
		else {
			System.out.println("Browser Not Avaliable");
		}
		
	// WebFire Event Listener
	edriver = new EventFiringWebDriver(driver);
	eventListener = new WebEventsListener();
	edriver.register(eventListener);
	driver=edriver;
	
	driver.manage().window().maximize();
 	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOADOUT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	//logger.info("=====Application Started=====");
	driver.get(prop.getProperty("url"));
	
	
}
}
