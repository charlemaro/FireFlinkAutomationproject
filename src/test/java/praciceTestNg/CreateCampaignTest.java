package praciceTestNg;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CreateCampaignPage;
import ObjectRepository.DashBoardPage;
import utility.BaseClass;

@Listeners(utility.ListenersImplementation.class)
public class CreateCampaignTest extends BaseClass{
	
	@Test(groups="SmokeTesting")
	public void tc_001_createCampaignTest() throws Throwable {
		
		String SHEET="Sheet1";
		String CAMPAIGNNAME=futil.readStringDataFromExcel(SHEET,4,2);
		String TARGETSIZE=futil.readStringDataFromExcel(SHEET,4,5);
		
		
		CreateCampaignPage cp=new CreateCampaignPage(driver);
		cp.enterCampaignField();
		Reporter.log("Entered Campaign creation field",true);
		cp.enterCampaignName(CAMPAIGNNAME);
		Reporter.log("Entered Campaign name",true);
		cp.enterTargetSize(TARGETSIZE);
		Reporter.log("Entered Target size",true);
		cp.createCampaign();
		Reporter.log("Clicked Create Capaign button",true);
		Thread.sleep(1000);
	}
	
	
	@Test
	public void sample() {
		System.out.println("sample");
	}

}
