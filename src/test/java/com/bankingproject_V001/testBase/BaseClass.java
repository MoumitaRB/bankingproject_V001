package com.bankingproject_V001.testBase;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties propObj;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browserName) throws IOException
	{    
		//load config file
		 propObj= new Properties();
		 FileInputStream configProp= new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		 propObj.load(configProp);
		
		//open browser
		 
		 if(browserName.equals("chrome"))
			{	
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  
			}
		 else if(browserName.equals("firefox"))
			{
			  WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
			}
		
		
		//global wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}
	
	@AfterClass
	 public void tearDown()
	 {
		  driver.quit();
	 }

	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken...");
	  

	}
	
	public void CaptureScreenshot(WebDriver driver, String tname) throws HeadlessException, AWTException, IOException {
		
	 
	// This code will capture screenshot of current screen		
	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		    
	// This will store screenshot on Specific location
	ImageIO.write(image, "png", new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png")); 
	System.out.println("Screenshots taken.....");
	 
	}
	
	public String randomString()
	{
		String genaratedString1=RandomStringUtils.randomAlphabetic(5);
		
		return genaratedString1;
	}
		
   public String randomNumeric()
   {
	  String genaratedString2= RandomStringUtils.randomNumeric(4);
	  
	  return genaratedString2;
   }
	 
}
