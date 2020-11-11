package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyNewAccountCanBeAddedToNewCustomer_007 extends BaseClass {
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingDetailsOfAccountMustBeShown() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		lpObj.clickOnNewAccountLink();
		Thread.sleep(3000);
		lpObj.setCustomerId("71423");
		Thread.sleep(2000);
		lpObj.clickOnAccountTypeFromDropDown("Savings");
		Thread.sleep(2000);
		lpObj.setInitialDeposit("500");
		Thread.sleep(2000);
		lpObj.clickOnSubmitBtn2();
		Thread.sleep(2000);
		lpObj.gettingAccountId("Account ID");
		boolean status1=lpObj.verifyingCustomerRegisteredSuccessfully("Account Generated Successfully!!!");
		boolean status2=lpObj.verifyingCustomerAccountDetailsIsShown("Created Account details are as follows:");
		if((status1==true)&&(status2==true))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(7000);
	}

}
