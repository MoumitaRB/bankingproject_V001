package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyingChangePasswordAndLogin_003 extends BaseClass{
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingPopUpMsgAfterProvidingOldPassword() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		lpObj.clickOnChangePasswordLInk();
		lpObj.setOldPassword("1234");
		Thread.sleep(2000);
		lpObj.setNewPassword("123456$");
		Thread.sleep(2000);
		lpObj.setConfirmPassword("123456$");
		Thread.sleep(3000);
		lpObj.clickOnSubmitBtn();
		Thread.sleep(2000);
		boolean msgStatus=lpObj.verifyingPopUpMsgAfterEnteringIncorrectPassword("Old Password is incorrect");
		Thread.sleep(3000);
		Assert.assertEquals(msgStatus, true);
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyingUserRedirectedToPasswordChangeIsShown() throws InterruptedException
	{
		lpObj=new LoginPage(driver);
		boolean passwordShownStatus=lpObj.verifyingRedirectedToChangePasswordIsShown("Change Password");
		Assert.assertEquals(passwordShownStatus, true);
		Thread.sleep(5000);
	}

}
