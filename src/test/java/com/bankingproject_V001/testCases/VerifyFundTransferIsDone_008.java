package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyFundTransferIsDone_008 extends BaseClass {
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingFundTransferIsSuccessful() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(4000);
		lpObj.clickOnfundTransferLink();
		Thread.sleep(3000);
		lpObj.setPayersAccountNumber("80066");
		Thread.sleep(2000);
		lpObj.setPayeesAccountNumber("80188");
		Thread.sleep(2000);
		lpObj.setAmount("100");
		Thread.sleep(2000);
		lpObj.setDescription("Cash");
		Thread.sleep(2000);
		lpObj.clickOnAccSubmitBtn();
		Thread.sleep(2000);
		boolean headingStatus=lpObj.verifyingFundTransferHeding("Fund Transfer Details");
		boolean transferDetailsStatus=lpObj.verifyingFundTransferDetails("From Account Number","80066", "To Account Number", "80188", "Amount", 100);
		Thread.sleep(6000);
		if((headingStatus==true)&&(transferDetailsStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(4000);
	}
	
	@Test
	public void verifyingPageIsRedirectingToFundTransferDetaisPage() throws InterruptedException
	{
		lpObj=new LoginPage(driver);
		driver.navigate().refresh();
		Thread.sleep(3000);
	    boolean titleStatus=lpObj.verifyingTitleOfThePage("Guru99 Bank Fund Transfer Entry Page");
	    Assert.assertEquals(titleStatus, true);
	    Thread.sleep(5000);
	}

}
