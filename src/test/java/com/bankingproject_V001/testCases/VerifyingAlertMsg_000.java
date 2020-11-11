package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyingAlertMsg_000 extends BaseClass{
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingAlertMsg() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
        Thread.sleep(3000);
        String text=lpObj.gettingTextFromAlert();
        System.out.println(text);
        Thread.sleep(3000);
        lpObj.clickOnOkBtnOnAlert();
        Thread.sleep(3000);
        
        if(text.equals("User or Password is not valid"))
        {
        	Assert.assertTrue(true);
        }
        else
        {
        	Assert.assertTrue(false);
        }
        
        Thread.sleep(2000);
	}

}
