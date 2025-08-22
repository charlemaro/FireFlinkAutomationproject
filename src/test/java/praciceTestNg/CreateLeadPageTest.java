package praciceTestNg;

import org.testng.annotations.Test;

import ObjectRepository.CreateLeadPage;
import ObjectRepository.DashBoardPage;
import utility.BaseClass;
import utility.JavaUtility;

public class CreateLeadPageTest extends BaseClass {
	@Test(groups = "sample")
	public void tc_002_creatLeadTest() throws Throwable {
		JavaUtility ju=new JavaUtility();
		String SHEET="Sheet1";
		String ID=futil.readStringDataFromExcel(SHEET,4,6);
		String LEADSTATUS=futil.readStringDataFromExcel(SHEET,13,6);
		String LEADNAME=futil.readStringDataFromExcel(SHEET,13,2);
		String COMPANY=futil.readStringDataFromExcel(SHEET,13,3);
		String LEADSOURCE=futil.readStringDataFromExcel(SHEET,13,2);
		String PHONE=futil.readStringDataFromExcel(SHEET,13,4)+ju.getRandomNumber()+ju.getRandomNumber()+ju.getRandomNumber()+ju.getRandomNumber()+ju.getRandomNumber();
		String INDUSTRY=futil.readStringDataFromExcel(SHEET,13,2);
		DashBoardPage db=new DashBoardPage(driver);
		db.enterLead();
		db.enterCreateLead();
		CreateLeadPage cp=new CreateLeadPage(driver);
		
		cp.enterLeadStatus(LEADSTATUS);
		cp.enterLeadName(LEADNAME);
		cp.enterCompany(COMPANY);
		cp.enterLeadSource(LEADSOURCE);
		cp.enterIndustrt(INDUSTRY);
		cp.enterPhoneNo(PHONE);
		cp.scrollDown(driver,200,200);
		cp.enterCampaign(driver,ID);
		cp.createLead();
		
	}
	
	@Test
	public void sample() {
		System.out.println("sample");
	}

}
