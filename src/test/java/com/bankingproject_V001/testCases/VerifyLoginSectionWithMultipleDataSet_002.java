package com.bankingproject_V001.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankingproject_V001.pageObjects.LoginPage;
import com.bankingproject_V001.testBase.BaseClass;
import com.bankingproject_V001.utilities.XUtils;

public class VerifyLoginSectionWithMultipleDataSet_002 extends BaseClass {
	
	public LoginPage lpObj;
	
	@Test(dataProvider="LoginData")
	public void verifyingLoginTest(String userid, String password, String exp) throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		lpObj=new LoginPage(driver);
		lpObj.setUserId(userid);
		lpObj.setPassword(password);
        lpObj.clickOnLoginBtn();
	    Thread.sleep(2000);

         
	    try {
	    	
	    	Alert alert=driver.switchTo().alert();
	    	String act_text=alert.getText();
			System.out.println(act_text);
			if(act_text.equals("User or Password is not valid"))
			{
				if(exp.equals("Login Successful"))
					{
				    	lpObj.clickOnLogoutBtn();
						Assert.assertTrue(false);
				    }
					else if(exp.equals("Fail"))
					{
						lpObj.gettingTextFromAlert();
						alert.accept();
						Assert.assertTrue(true);
					}
			 }
			
			
	    }catch(Exception e)
	    {  
	       String act_text=driver.getTitle();
	       System.out.println(act_text);
	       if(act_text.equals("Guru99 Bank Manager HomePage"))
	    	{
	    	  if(exp.equals("Login Successful"))
	    		{   
	    		  boolean status=lpObj.verifyingManagerIdAfterLoginIn("Manger Id : mngr264919");
	    		  Thread.sleep(3000);
	    		  captureScreen(driver, "verifyingLoginTest");
	    	      Assert.assertEquals(status, true);
	    		  lpObj.clickOnLogoutBtn();
	    		  Thread.sleep(2000);
	    		  lpObj.gettingTextFromAlert();
	    		  lpObj.clickOnOkBtnOnAlert();
	    	
	    		}
	    	  else if(exp.equals("Fail"))
	    		{
	    		  lpObj.clickOnOkBtnOnAlert();
	    		  Assert.assertTrue(false);
	    		}
	     
	        }
	    	
	    }
		
	
	}
		
	
	
	
	@DataProvider(name="LoginData")
	public Object[][]getData() throws IOException, InterruptedException{
		
		String path=System.getProperty("user.dir")+"\\TestData\\GuruLoginData2.xlsx";
		int rownum=XUtils.getRowCount(path, "sheet1");
		System.out.println("Total number of rows:"+rownum);
		int column=XUtils.getCellCount(path, "sheet1", 1);
		System.out.println("Total number of column:"+column);
		
		
		String loginData[][]=new String[rownum][column];
		
		for(int r=1; r<=rownum; r++ )
		{
			for(int c=0; c<column; c++)
			{
				loginData[r-1][c]=XUtils.getCellData(path, "sheet1", r, c);
				
				System.out.println(loginData[r-1][c]+" ");
			}
			System.out.println();
		}
		Thread.sleep(3000);
	 return loginData;
	}

}
