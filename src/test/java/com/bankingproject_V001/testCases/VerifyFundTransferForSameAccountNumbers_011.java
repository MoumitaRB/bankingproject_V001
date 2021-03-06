package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyFundTransferForSameAccountNumbers_011 extends BaseClass{
	
	public LoginPage lpObj;
	
	@Test
	public void verifingFundTransferForSameAccountNumber() throws InterruptedException
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
		lpObj.setPayeesAccountNumber("80066");
		Thread.sleep(2000);
		lpObj.setAmount("100");
		Thread.sleep(2000);
		lpObj.setDescription("Cash");
		Thread.sleep(2000);
		lpObj.clickOnAccSubmitBtn();
		Thread.sleep(2000);
		boolean popUpMsgStatus=lpObj.verifyingPopupMsgFromAlert("Payers account No and Payees account No Must Not be Same!!!");
		Thread.sleep(3000);
		if(popUpMsgStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
	}
	

}
