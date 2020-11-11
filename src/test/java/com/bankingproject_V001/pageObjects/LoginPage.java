package com.bankingproject_V001.pageObjects;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	 public WebDriver driver;
	 public JavascriptExecutor js;
	 public String custId;
	 public String accountId;
	 
	 public LoginPage(WebDriver driver)
	 
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
 
		
		//locators
	 
	 @FindBy(xpath="//input[@name='uid']")
	 @CacheLookup
	 WebElement txtUserid;
	 
	 @FindBy(xpath="//input[@name='password']")
	 @CacheLookup
	 WebElement txtPassword;
	 
	 @FindBy(xpath="//input[@name='btnLogin']")
	 @CacheLookup
	 WebElement loginBtn;
	 
	 @FindBy(xpath="//td[contains(text(),'Manger Id : mngr264919')]")
	 @CacheLookup
	 WebElement managerId;
	 
	 @FindBy(xpath="//a[contains(text(),'Log out')]")
	 @CacheLookup
	 WebElement logOutBtn;
	 
	 @FindBy(xpath="//a[contains(text(),'Change Password')]")
	 @CacheLookup
	 WebElement changePwdLink;
	 
	 @FindBy(xpath="//input[@name='oldpassword']")
	 @CacheLookup
	 WebElement txtOldPassword;
	 
	 @FindBy(xpath="//input[@name='newpassword']")
	 @CacheLookup
	 WebElement txtNewPassword;
	 
	 @FindBy(xpath="//input[@name='confirmpassword']")
	 @CacheLookup
	 WebElement txtConfirmPassword;
	 
	 @FindBy(xpath="//input[@name='sub']")
	 @CacheLookup
	 WebElement submitBtn;
	 
	 @FindBy(xpath="//p[@class='heading3']")
	 @CacheLookup
	 WebElement pcHeading;
	 
	 @FindBy(xpath="//a[contains(text(),'New Customer')]")
	 @CacheLookup
	 WebElement newCustomerLink;
	 
	 @FindBy(xpath="//input[@name='name']")
	 @CacheLookup
	 WebElement txtCustName;
	 
	 @FindBy(xpath="//tr[5]//td[2]//input[1]")
	 @CacheLookup
	 WebElement radioBtn;
	 
	 @FindBy(xpath="//input[@id='dob']")
	 @CacheLookup
	 WebElement txtDob;
	 
	 @FindBy(xpath="//textarea[@name='addr']")
	 @CacheLookup
	 WebElement txtAdd;
	 
	 @FindBy(xpath="//input[@name='city']")
	 @CacheLookup
	 WebElement txtCity;
	 
	 @FindBy(xpath="//input[@name='state']")
	 @CacheLookup
	 WebElement txtState;
	 
	 @FindBy(xpath="//input[@name='pinno']")
	 @CacheLookup
	 WebElement txtPinNo;
	 
	 @FindBy(xpath="//input[@name='telephoneno']")
	 @CacheLookup
	 WebElement txtMobileNo;
	 
	 @FindBy(xpath="//input[@name='emailid']")
	 @CacheLookup
	 WebElement txtEmailId;
	 
	 @FindBy(xpath="//input[@name='password']")
	 @CacheLookup
	 WebElement txtNewCustomerPassword;
	 
	 @FindBy(xpath="//p[@class='heading3']")
	 @CacheLookup
	 WebElement text;
	 
	 @FindBy(xpath="//table[@id='customer']//tbody//tr[2]")
	 @CacheLookup
	 WebElement customerDetailsHeading;
	 
	 @FindBy(xpath="//a[contains(text(),'Continue')]")
	 @CacheLookup
	 WebElement continueBtn;
	 
	 @FindBy(xpath="//a[contains(text(),'New Account')]")
	 @CacheLookup
	 WebElement newAccountLink;
	 
	 @FindBy(xpath="//input[@name='cusid']")
	 @CacheLookup
	 WebElement txtCustId;
	 
	 @FindBy(xpath="//select[@name='selaccount']")
	 @CacheLookup
	 WebElement dropdown;
	 
	 @FindBy(name="inideposit")
	 @CacheLookup
	 WebElement txtDeposit;
	 
	 @FindBy(xpath="//input[@name='button2']")
	 @CacheLookup
	 WebElement submitBtn2;
	 
	 @FindBy(xpath="//table[@id='account']//tbody//tr[2]")
	 @CacheLookup
	 WebElement accountDetailsHeading;
	 
	 @FindBy(xpath="//a[contains(text(),'Fund Transfer')]")
	 @CacheLookup
	 WebElement fundTransferLink;
	 
	 @FindBy(xpath="//input[@name='payersaccount']")
	 @CacheLookup
	 WebElement txtPayersAccountNo;
	 
	 @FindBy(xpath="//input[@name='payeeaccount']")
	 @CacheLookup
	 WebElement txtPayeeAccountNo;
	 
	 @FindBy(xpath="//input[@name='ammount']")
	 @CacheLookup
	 WebElement txtAmount;
	 
	 @FindBy(xpath="//input[@name='desc']")
	 @CacheLookup
	 WebElement txtDescription;
	 
	 @FindBy(xpath="//input[@name='AccSubmit']")
	 @CacheLookup
	 WebElement accSubmitBtn;
	 
     @FindBy(xpath="//p[contains(text(),'Fund Transfer Details')]")
     @CacheLookup
     WebElement fundTransferHeading;
     
     @FindBy(xpath="//a[contains(text(),'Mini Statement')]")
     @CacheLookup
     WebElement miniStatementLink;
     
     @FindBy(xpath="//input[@name='accountno']")
     @CacheLookup
     WebElement txtMiniStatementAccNo;
    
    
	 
	
	 
	 //actions
	 
	 public void setUserId(String userid)
	 {
		 txtUserid.clear();
		 txtUserid.sendKeys(userid);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 txtPassword.clear();
		 txtPassword.sendKeys(pwd);
	 }
	 
	 public void clickOnLoginBtn()
	 {
	     loginBtn.click();
	 }
	 
	 public boolean verifyingSuccessfullLoginIn(String exp_title, String exp_alerttext) throws IOException, HeadlessException, AWTException, InterruptedException
	 { 
	   boolean flag=false;
	   try {
		   
		   Alert alert=driver.switchTo().alert();
		   String act_alerttext=alert.getText();
		   System.out.println(act_alerttext);
		   if(act_alerttext.equals(exp_alerttext))
		   {
		     BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		     ImageIO.write(image, "png", new File(System.getProperty("user.dir")+"\\Screenshots\\"+"verifyingSuccessfullLoginIn.png")); 
		     System.out.println("Screenshots taken.....");
		     Thread.sleep(4000);
		     flag=false;
		   }
		   else if(!act_alerttext.equals(exp_alerttext))
		   {
			   flag=true;
		   }
		
	 }
	   catch(Exception e)
	   {
		  String act_title= driver.getTitle();
		  System.out.println(act_title);
		  if(act_title.equals(exp_title))
		  {
			System.out.println("passed....");
			flag= true;
		  }
		  else if(!act_title.equals(exp_title))
			{   
		       TakesScreenshot ts= (TakesScreenshot)driver;
				File source= ts.getScreenshotAs(OutputType.FILE);
				File target= new File(System.getProperty("user.dir")+"\\Screenshots\\"+"verifyingSuccessfullLoginIn.png");
				FileUtils.copyFile(source, target);
				System.out.println("Screenshot taken...");
				flag= false;
		    }
	  }
	   
	   return flag;
	 }
	 
	 public boolean verifyingManagerIdAfterLoginIn(String exp_text)
	 {
		 String act_text=managerId.getText();
		 System.out.println(act_text);
		 if(act_text.equals(exp_text))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public void clickOnLogoutBtn()
	 {
		 js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();",logOutBtn);
		 logOutBtn.click();
	 }
	 
	 public String gettingTextFromAlert() 
	 { String act_text="";
	   try {
		 Alert alert=driver.switchTo().alert();
		 act_text=act_text+alert.getText();
		 System.out.println(act_text);
	   }catch(Exception UnhandledAlertException)
	   {
		   System.out.println("No such alert present....");
	   }
		 return act_text;
	 }
   
	 public void clickOnOkBtnOnAlert()
	 { 
		 try
		 {
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	 public void clickOnChangePasswordLInk()
	 {
		 js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();",changePwdLink);
		 changePwdLink.click();
	 }
	 
	 public void setOldPassword(String opwd)
	 {
		 txtOldPassword.clear();
		 txtOldPassword.sendKeys(opwd);
	 }
	 
	 public void setNewPassword(String npwd)
	 {
		 txtNewPassword.clear();
		 txtNewPassword.sendKeys(npwd);
	 }
	 
	 public void setConfirmPassword(String cpwd)
	 {
		 txtConfirmPassword.clear();
		 txtConfirmPassword.sendKeys(cpwd);
	 }
	 
	 public void clickOnSubmitBtn()
	 {
		 submitBtn.click();
	 }
	 
	 public boolean verifyingPopUpMsgAfterEnteringIncorrectPassword(String exp_alerttext)
	 {  boolean flag=true;
		 Alert alert =driver.switchTo().alert();
		 String act_alerttext=alert.getText();
		 System.out.println("ALert text is:"+act_alerttext);
		 if(act_alerttext.equals(exp_alerttext))
		 {
			 alert.accept();
	         flag=true;
	     }
		 else
		 {
			 flag=false;
			 
			 
		 }
		 
		 return flag;
	 }
	 
	 public boolean verifyingRedirectedToChangePasswordIsShown(String exp_text)
	 {
		String act_text= pcHeading.getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}

	 }
	 
	 public boolean verifyingPageTitleAfterPasswordHasChanged(String exp_title)
	 {
		String act_title= driver.getTitle();
		System.out.println("Page title is:"+act_title);
		if(act_title.equals(exp_title))
		{
			return true;
		}
		else
		{
			return false;
		}
	 }
	 
	 public void clickOnNewCustomerLink()
	 {
		 newCustomerLink.click();
	 }
	 
	 public void setEmailId(String email) throws InterruptedException
	 {
		 txtEmailId.clear();
		 txtEmailId.sendKeys(email);
		 Thread.sleep(2000);
	 }
	 
	 public void fillingUpRequiredFields(String name, String dob, String address, String city, String state, String pin, String mobile, String pwd) throws InterruptedException
	 {
		 txtCustName.clear();
		 txtCustName.sendKeys(name);
		 radioBtn.click();
		 txtDob.clear();
		 txtDob.sendKeys(dob);
		 txtAdd.clear();
		 txtAdd.sendKeys(address);
		 Thread.sleep(2000);
		 txtCity.clear();
		 txtCity.sendKeys(city);
		 Thread.sleep(2000);
		 txtState.clear();
		 txtState.sendKeys(state);
		 Thread.sleep(2000);
		 txtPinNo.clear();
		 txtPinNo.sendKeys(pin);
		 Thread.sleep(2000);
		 txtMobileNo.clear();
		 txtMobileNo.sendKeys(mobile);
		 Thread.sleep(2000);
		 txtNewCustomerPassword.clear();
		 txtNewCustomerPassword.sendKeys(pwd);
		 
	 }
	 
	 public boolean verifyingCustomerRegisteredSuccessfully(String exp_text)
	 {
		 String act_text=text.getText();
		 System.out.println(act_text);
		 if(act_text.equals(exp_text))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
	 }
	 
    public boolean verifyingCustomerDetailsIsShown(String exp_text)
	{
    	String act_text=customerDetailsHeading.getText();
    	System.out.println(act_text);
    	if(act_text.equals(exp_text))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
	}
    
    public void gettingCustomerId(String exp_text)
    {
    	List<WebElement> rownum=driver.findElements(By.xpath("//table[@id='customer']//tbody//tr"));
    	for(int r=4; r<=rownum.size();r++)
    	{  
    		String act_text=driver.findElement(By.xpath("//table[@id='customer']//tbody//tr["+r+"]//td[1]")).getText();
    		System.out.println(act_text);
    		if(act_text.equals(exp_text))
    		{
    		  custId=driver.findElement(By.xpath("//table[@id='customer']//tbody//tr["+r+"]//td[2]")).getText();
    		  System.out.println("Customer id is:"+custId);
    		  break;
    		}
    	}
    	
    }
	
    public void clickOnContinueBtn()
    {
    	continueBtn.click();
    }
    
    public void clickOnNewAccountLink()
    {
    	js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",newAccountLink);
    	newAccountLink.click();
    }
    
    public void setCustomerId(String custid)
    {  
    	txtCustId.clear();
    	txtCustId.sendKeys(custid);
    }
    
    public void clickOnAccountTypeFromDropDown(String value)
    {
    	dropdown.click();
    	Select select=new Select(dropdown);
    	select.selectByVisibleText(value);
    	
    }
    
    public void setInitialDeposit(String amount )
    {
    	txtDeposit.clear();
    	txtDeposit.sendKeys(amount);
    }
    
    public void clickOnSubmitBtn2()
    {
    	submitBtn2.click();
    }
    
    public boolean verifyingCustomerAccountDetailsIsShown(String exp_text)
    {
    	String act_text=accountDetailsHeading.getText();
    	System.out.println(act_text);
    	if(act_text.equals(exp_text))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    public void gettingAccountId(String exp_text)
    {
    	List<WebElement> rownum=driver.findElements(By.xpath("//table[@id='account']//tbody//tr"));
    	for(int r=4; r<=rownum.size();r++)
    	{  
    		String act_text=driver.findElement(By.xpath("//table[@id='account']//tbody//tr["+r+"]//td[1]")).getText();
    		System.out.println(act_text);
    		if(act_text.equals(exp_text))
    		{
    		  accountId=driver.findElement(By.xpath("//table[@id='account']//tbody//tr["+r+"]//td[2]")).getText();
    		  System.out.println("Account id is:"+accountId);
    		  break;
    		}
    	}
    	
    }
    
	public void clickOnfundTransferLink()
	 {   
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", fundTransferLink);

	 }
	 
	 public void setPayersAccountNumber(String accNo)
	 {
		 txtPayersAccountNo.clear();
		 txtPayersAccountNo.sendKeys(accNo);
	 }
	 
	 public void setPayeesAccountNumber(String accNo)
	 {
		 txtPayeeAccountNo.clear();
		 txtPayeeAccountNo.sendKeys(accNo);
	 }
	 
	 public void setAmount(String amount)
	 {
		 txtAmount.clear();
		 txtAmount.sendKeys(amount);
	 }
	 
	 public void setDescription(String des)
	 {
		 txtDescription.clear();
		 txtDescription.sendKeys(des);
	 }
	 
	 public void clickOnAccSubmitBtn()
	 {
		 accSubmitBtn.click();
	 }
	 
	 public boolean verifyingFundTransferHeding(String exp_text)
	 {
		 String act_text=fundTransferHeading.getText();
		 if(act_text.equals(exp_text))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 
	 
	 public boolean verifyingFundTransferDetails(String exp_text, String exp_fromAccNo, String exp_text2, String exp_toAccNo, String exp_text3, int exp_amount)
	 { 
		boolean flag=false;
		List<WebElement> rownum=driver.findElements(By.xpath("//table[@border='1']//tbody//tr"));
		for(int r=1; r<=rownum.size();r++)
		{
			String act_text=driver.findElement(By.xpath("//table[@border='1']//tbody//tr["+r+"]//td[1]")).getText();
			System.out.println(act_text);
			if(act_text.equals(exp_text))
			{
				String act_fromAccNo=driver.findElement(By.xpath("//table[@border='1']//tbody//tr["+r+"]//td[2]")).getText();
				System.out.println(act_fromAccNo);
				if(act_fromAccNo.equals(exp_fromAccNo))
				{
					String act_text2=driver.findElement(By.xpath("//table[@border='1']//tbody//tr["+(r+1)+"]//td[1]")).getText();
					System.out.println(act_text2);
					if(act_text2.equals(exp_text2))
					{
						String act_toAccNo=driver.findElement(By.xpath("//table[@border='1']//tbody//tr["+(r+1)+"]//td[2]")).getText();
						System.out.println(act_toAccNo);
						if(act_toAccNo.equals(exp_toAccNo))
						{  
							String act_text3=driver.findElement(By.xpath("//table[@border='1']//tbody//tr["+(r+2)+"]//td[1]")).getText();
							System.out.println(act_text3);
							if(act_text3.equals(exp_text3))
							{
								String act_amount=driver.findElement(By.xpath("//table[@border='1']//tbody//tr["+(r+2)+"]//td[2]")).getText();
								int amount=Integer.parseInt(act_amount);
								System.out.println(amount);
								if(amount==exp_amount)
								{
									flag=true;
								
								}
								else
								{
									flag=false;
								}

                            }
						
					}
				}
			}
		  }
	   }
	  return flag;
	}
	
	 public boolean verifyingTitleOfThePage(String exp_title)
	 {
		String act_title= driver.getTitle();
		System.out.println("Title of the page is:"+act_title);
		if(act_title.equals(exp_title))
		{
			return true;
		}
		else
		{
			return false;
		}
	 }
	 
	 public void clickOnClickOnMiniStatementLink()
	 {
		 js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", miniStatementLink);

	 }
	 
	 public void setAccountNo(String accNo)
	 {
		 txtMiniStatementAccNo.clear();
		 txtMiniStatementAccNo.sendKeys(accNo);
	 }
	 
	 public boolean verifyingLastTransactionAppearOnMiniStatement(String exp_text1, String exp_text2, String exp_text3, String exp_text4, String exp_text5, String exp_details1,String exp_details2, String exp_details3,String exp_details4, String exp_details5 )
	 {   
		 boolean flag=false;
		 List<WebElement>rownum=driver.findElements(By.xpath("//table[@id='ministmt']//tbody//tr"));
		 List<WebElement>colnum=driver.findElements(By.xpath("//table[@id='ministmt']//tbody//tr[2]//td"));
		 for(int r=1; r<=rownum.size(); r++)
		 {
			 String act_text=driver.findElement(By.xpath("//table[@id='ministmt']//tbody//tr["+r+"]//th")).getText();
			 System.out.println(act_text);
			 if((act_text.equals(exp_text1))||(act_text.equals(exp_text2))||(act_text.equals(exp_text3))||(act_text.equals(exp_text4))||(act_text.equals(exp_text5)))
				 {  
				    for(int c=1;c<=colnum.size();c++)
				    {
				     String act_transactionDetails= driver.findElement(By.xpath("//table[@id='ministmt']//tbody//tr["+(r+1)+"]//td["+c+"]")).getText();
				     System.out.println(act_transactionDetails);
				     if((act_transactionDetails.equals(exp_details1))||(act_transactionDetails.equals(exp_details2))||(act_transactionDetails.equals(exp_details3))||(act_transactionDetails.equals(exp_details4))||(act_transactionDetails.equals(exp_details5)))
				     {
				    	flag=true;
				    	
				     }
				     else
				     {
				    	 flag=false;
				     }
				    }
				 }
			   break;
		     }
		 return flag;
	 }
	 
	 public boolean verifyingPopupMsgFromAlert(String exp_popupMsg)
	 { 
		boolean flag=false;
		Alert alert= driver.switchTo().alert();
		String act_popupMsg=alert.getText();
		System.out.println("Alert msg:"+act_popupMsg);
		if(act_popupMsg.equals(exp_popupMsg))
		{
		    flag=true;
			alert.accept();
		}
		else
		{
			flag= false;
		}
		return flag;
	 }
	 
}
