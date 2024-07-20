package orangehrm.library;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.AppUtils;

public class AdminUtils extends AppUtils 
{

	public static  String adminuid = "Admin";
	public static  String adminpwd = "Qedge123!@#";
	
	LoginPage lp;
	
	@BeforeTest
	public void adminLogin()
	{
		lp = new LoginPage();
		lp.login(adminuid, adminpwd);				
	}
	
	@AfterTest
	public void adminLogout()
	{
		lp.logout();
	}
	
}
