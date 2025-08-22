package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains of generic methods related
 * to FileOperations like propertyfile , excel file, 
 * @author Charle Maro J
 * @throws Throwable 
 */

public class FileUtility {

	
	/**
	 * getData from property cell
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fobj=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fobj);
		return prop.getProperty(key);
	}
	/**
	 * getString cell value
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readStringDataFromExcel(String sheetName,int rowNo,int cellNo) throws Throwable{
		FileInputStream fobj=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fobj);
		return wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).toString();
	}
	
	
	/**
	 * getInt cell value
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public int readIntDataFromExcel(String sheetName,int rowNo,int cellNo) throws Throwable{
		FileInputStream fobj=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fobj);
		return (int)wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	
	
	
	
}
