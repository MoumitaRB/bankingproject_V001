package com.bankingproject_V001.testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifySuccessfullLogin_001 extends BaseClass{
	
	public LoginPage lpObj;
	
	
	@Test
	public void verifyingLoginIsSuccessfull() throws InterruptedException, IOException, HeadlessException, AWTException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(3000);
	    boolean titleStatus=lpObj.verifyingSuccessfullLoginIn("Guru99 Bank Manager HomePage","User or Password is not valid");
		System.out.println(titleStatus);
		Thread.sleep(2000);
		if(titleStatus==true)
		{
		   Assert.assertTrue(true);
		 }
	    else
		{   
		   Assert.assertTrue(false);
			
	     }
	    }
		
	    

	    @Test(dependsOnMethods="verifyingLoginIsSuccessfull")
	    public void verifyingManagerIdAfterLoginIn() throws IOException, InterruptedException
	    {
	      lpObj=new LoginPage(driver);
		  boolean managerIdStatus=lpObj.verifyingManagerIdAfterLoginIn("Manger Id : mngr264919");
		
		 if(managerIdStatus==true)
		  { 
		    captureScreen(driver, "verifyingLoginIsSuccessfull");
			Assert.assertTrue(true);
		  }
		 else
		 {   
			captureScreen(driver, "verifyingLoginIsSuccessfull");
			Thread.sleep(4000);
			Assert.assertTrue(false);
		 }
		
		Thread.sleep(3000);
	    
	}

}
