package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyAfterAddingNewCustomerPageRedirectsToDetailsOfAddedCustomer_006 extends BaseClass{
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingDetailsOfAddedCustomerMustBeShown() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		lpObj.clickOnNewCustomerLink();
		String email=randomString()+"@gmail.com";
		lpObj.setEmailId(email);
		lpObj.fillingUpRequiredFields("Jackson", "11/23/1990", "Buffalo","NewYork", "NewYork", "345612", "6512898989", "123456#");
		Thread.sleep(3000);
		lpObj.clickOnSubmitBtn();
		Thread.sleep(10000);
		lpObj.gettingCustomerId("Customer ID");
		boolean status1=lpObj.verifyingCustomerRegisteredSuccessfully("Customer Registered Successfully!!!");
		boolean status2=lpObj.verifyingCustomerDetailsIsShown("Registered Customer details are as follows:");
		if((status1==true)&&(status2==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(4000);
		lpObj.clickOnContinueBtn();
		Thread.sleep(5000);
		
	}

}
