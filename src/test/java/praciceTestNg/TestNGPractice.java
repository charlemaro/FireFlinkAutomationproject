package praciceTestNg;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.FileUtility;

public class TestNGPractice {

	
	/*@Test(priority = 2)
	public void create() {
		System.out.println("Create");
	}
	
	@Test(invocationCount = 2)
	public void modify() {
		Assert.fail();
		System.out.println("Modify");
	}
	@Test(enabled = true)
	public void delete() {
		System.out.println("Delete");
	}
	*/
	
	
	/*@Test
	public void create() {
		//Assert.fail();
		System.out.println("Create");
	}
	
	@Test(dependsOnMethods = "create")
	public void modify() {
		System.out.println("Modify");
	}
	@Test(dependsOnMethods = {"create","modify"})
	public void delete() {
		System.out.println("Delete");
	}*/
	
	@Test(dataProvider = "customerinfo")
	public void create(String name,int id) {
		//Assert.fail();
		System.out.println(name+" with "+id+"-Created");
	}

	@Test
	public void modify() {
		System.out.println("Modify");
	}
	
	
	@Test
	public void delete() {
		System.out.println("Delete");
	}
	
	/*@DataProvider(name="customerinfo")
	public Object[][] getData(){
		Object[][] data=new Object[4][2];
		
		data[0][0]="Batman";
		data[0][1]=1;
		
		data[1][0]="Spiderman";
		data[1][1]=2;
		
		data[2][0]="Aquaman";
		data[2][1]=3;
		
		data[3][0]="Hulk";
		data[3][1]=4;
		
		
		return data;
	}*/
	
	@DataProvider(name="customerinfo")
	public Object[][] getData() throws Throwable{
		FileUtility fu=new FileUtility();
		Object[][] data= {
				{fu.readStringDataFromExcel("Sheet2",1,0),fu.readIntDataFromExcel("Sheet2",1,1)},
				{fu.readStringDataFromExcel("Sheet2",2,0),fu.readIntDataFromExcel("Sheet2",2,1)},
				{fu.readStringDataFromExcel("Sheet2",3,0),fu.readIntDataFromExcel("Sheet2",3,1)},
				{fu.readStringDataFromExcel("Sheet2",4,0),fu.readIntDataFromExcel("Sheet2",4,1)}
		};
		return data;
	}
	
	
	
	
	
}
