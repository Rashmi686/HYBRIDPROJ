package orangehrm.library;

import org.openqa.selenium.By;

import utils.utils;

public class loginpage extends utils {

	
	public void login(String uid,String pwd)
	{		
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();		
	}
	
	public boolean isAdminModuleDisplayed()
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public void logout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public boolean isErrMsgDisplayed()
	{
		String errmsg;
		errmsg = driver.findElement(By.id("spanMessage")).getText();
		if(errmsg.toLowerCase().contains("invalid") || errmsg.toLowerCase().contains("empty"))
		{
			return true;
		}else
		{
			return false;
		}		
	}
	
	public boolean isEmpModuleDisplayed()
	{
		try 
		{
			driver.findElement(By.linkText("Admin")).isDisplayed();
			return false;
			
		} catch (Exception e)
		{
			return true;
		}
		
	}
	
	
}
	
	
	
	
	
	
	
	
	

