package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyUserCanLoginWIthTheNewPasswordAfterPasswordHasChanged_005 extends BaseClass{
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingUserCanLoginWithTheNewPassword() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		boolean titleStatus=lpObj.verifyingPageTitleAfterPasswordHasChanged("Guru99 Bank Manager HomePage");
		Assert.assertEquals(titleStatus, true);
		Thread.sleep(4000);
	}

}
