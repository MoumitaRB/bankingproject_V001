package com.bankingproject_V001.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;

public class VerifyCustomerDetailsAppearOnTheCustomizedStatement_009 extends BaseClass{
	
	public LoginPage lpObj;
	
	@Test
	public void verifyingCustomerDetailsAppearOnTheCustomizedStatement() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(propObj.getProperty("userId"));
		lpObj.setPassword(propObj.getProperty("passWord"));
        lpObj.clickOnLoginBtn();
		Thread.sleep(4000);
		lpObj.clickOnClickOnMiniStatementLink();
		Thread.sleep(2000);
		lpObj.setAccountNo("80066");
		Thread.sleep(3000);
		lpObj.clickOnAccSubmitBtn();
		Thread.sleep(2000);
		boolean transactionStatus=lpObj.verifyingLastTransactionAppearOnMiniStatement("Transaction ID", "Amount", "Transaction Type", "Date of Transaction", "Description", "142653", "100", "t", "2020-06-18", "CashTansfer To80188");
		Thread.sleep(8000);
		Assert.assertEquals(transactionStatus, true);
		Thread.sleep(3000);
	}

}
