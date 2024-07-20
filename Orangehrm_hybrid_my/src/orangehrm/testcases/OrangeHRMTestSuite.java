package orangehrm.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.XLUtils;

public class OrangeHRMTestSuite {

	String tcfile = "d:\\Selenium work\\Orangehrm_hybrid_my\\testcasefiles2\\Keywords.xlsx";
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	@Test
	public void checkorangehrmlogin() throws IOException
	{
		
	int tccount = XLUtils.getRowCount(tcfile, tcsheet);	
		int tscount = XLUtils.getRowCount(tssheet, tcsheet);
		
		String tcid,tcexeflag;
		for(int i=1;i<=tccount;i++)
		{
			
			tcid = XLUtils.getStringData(tcfile, tcsheet, i, 0);
			tcexeflag = XLUtils.getStringData(tcfile, tcsheet, i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				System.out.println(tcid+" is selected to execute!" );
			}else
			{
				XLUtils.setData(tcfile, tcsheet, i, 3,"Blocked");
				XLUtils.fillRedColour(tcfile, tcsheet, i, 3, tcexeflag);
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
