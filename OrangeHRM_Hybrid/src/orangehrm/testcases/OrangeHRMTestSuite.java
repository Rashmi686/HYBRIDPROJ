package orangehrm.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import orangehrm.library.Employee;
import orangehrm.library.LoginPage;
import orangehrm.library.User;
import utils.AppUtils;
import utils.XLUtils;

public class OrangeHRMTestSuite extends AppUtils 
{

	String tcfile = "C:\\Selenium8AM\\OrangeHRM_Hybrid\\testcasefiles\\OrangeHRMKeywords.xlsx";
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	
	
	
	@Test
	public void checkOrangeHRM() throws IOException, InterruptedException
	{
		int tccount = XLUtils.getRowCount(tcfile, tcsheet);
		int tscount = XLUtils.getRowCount(tcfile, tssheet);
		
		String tcid,tcexeflag;
		String tstcid,keyword;
		
				
		LoginPage lp = new LoginPage();
		Employee emp = new Employee();
		User us = new User();
		
		String uid,pwd;
		String fname,lname;
		String role,empname,empuid,emppwd;
		
		
		String stepres,tcres;
		boolean res=false;
		
		for(int i=1;i<=tccount;i++)
		{
			tcid = XLUtils.getStringData(tcfile, tcsheet, i, 0);
			tcexeflag = XLUtils.getStringData(tcfile, tcsheet, i, 2);
			
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				for(int j=1;j<=tscount;j++)
				{
					tstcid = XLUtils.getStringData(tcfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword = XLUtils.getStringData(tcfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
							case "adminlogin": 
								uid = XLUtils.getStringData(tcfile, tssheet, j, 5);
								pwd = XLUtils.getStringData(tcfile, tssheet, j, 6);
								lp.login(uid, pwd);
								res = lp.isAdminModuleDisplayed();
								break;
							case "logout":
								res = lp.logout();
								break;
							case "invalidlogin":
								uid = XLUtils.getStringData(tcfile, tssheet, j, 5);
								pwd = XLUtils.getStringData(tcfile, tssheet, j, 6);
								lp.login(uid, pwd);
								res = lp.isErrMsgDisplayed();
								break;
							case "empreg":
								fname=XLUtils.getStringData(tcfile, tssheet, j, 5);
								lname=XLUtils.getStringData(tcfile, tssheet, j, 6);
								res = emp.addEmployee(fname, lname);
								break;
							case "userreg":
								role = XLUtils.getStringData(tcfile, tssheet, j, 5);
								empname = XLUtils.getStringData(tcfile, tssheet, j, 6);
								empuid = XLUtils.getStringData(tcfile, tssheet, j, 7);
								emppwd = XLUtils.getStringData(tcfile, tssheet, j, 8);
								res = us.addUser(role,empname,empuid,emppwd);
								break;
							case "emplogin":
								empuid = XLUtils.getStringData(tcfile, tssheet, j, 5);
								emppwd = XLUtils.getStringData(tcfile, tssheet, j, 6);
								lp.login(empuid, emppwd);
								res = lp.isEmpModuleDisplayed();
								break;
								
						}
						// code to update Step Result
						if(res)
						{
							stepres = "Pass";
							XLUtils.setData(tcfile, tssheet, j, 3, stepres);
							XLUtils.fillGreenColor(tcfile, tssheet, j, 3);
						}else
						{
							stepres = "Fail";
							XLUtils.setData(tcfile, tssheet, j, 3, stepres);
							XLUtils.fillRedColor(tcfile, tssheet, j, 3);
						}
						
						// code to update TestCase Result						
						tcres = XLUtils.getStringData(tcfile, tcsheet, i, 3);
						if(!tcres.equalsIgnoreCase("fail"))
						{
							XLUtils.setData(tcfile, tcsheet, i, 3, stepres);
						}
						
						// code to fill TestCase Result colors
						tcres = XLUtils.getStringData(tcfile, tcsheet, i, 3);
						if(tcres.equalsIgnoreCase("pass"))
						{
							XLUtils.fillGreenColor(tcfile, tcsheet, i, 3);
						}else
						{
							XLUtils.fillRedColor(tcfile, tcsheet, i, 3);
						}
						
						
						
						
					}
				}
				
			}else
			{
				XLUtils.setData(tcfile, tcsheet, i, 3, "Blocked");
				XLUtils.fillRedColor(tcfile, tcsheet, i, 3);
			}
		}
	}
	
	
	
	
	
}
