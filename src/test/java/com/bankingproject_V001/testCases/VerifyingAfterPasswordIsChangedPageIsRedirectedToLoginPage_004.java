package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyingAfterPasswordIsChangedPageIsRedirectedToLoginPage_004 extends BaseClass {
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingPopUpMsgAfterProvidingCorrectPassword() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		lpObj.clickOnChangePasswordLInk();
		lpObj.setOldPassword("123456#");
		Thread.sleep(2000);
		lpObj.setNewPassword("123456#");
		Thread.sleep(2000);
		lpObj.setConfirmPassword("123456#");
		Thread.sleep(3000);
		lpObj.clickOnSubmitBtn();
		Thread.sleep(2000);
		boolean msgStatus=lpObj.verifyingPopUpMsgAfterEnteringIncorrectPassword("Password is Changed");
		Thread.sleep(3000);
		Assert.assertEquals(msgStatus, true);
		Thread.sleep(3000);
	}
	
   @Test
   public void verifyingRedirectedToLoginPageShown() throws InterruptedException
   {
	   lpObj=new LoginPage(driver);
	   boolean loginPageStatus=lpObj.verifyingPageTitleAfterPasswordHasChanged("Guru99 Bank Home Page");
	   Assert.assertEquals(loginPageStatus, true);
	   Thread.sleep(4000);
   }
	

}
