package generic_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/** This class consists of the  methods which are required to read and write from Excel
 * 
 * @author D.Sarveswararao
 *
 */
public class Excel_Utility {
	/** This method reads the data from Excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Exception
	 */
public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
{
	FileInputStream fise=new FileInputStream(Iconstants_Utility.excelPath);
	Workbook book=WorkbookFactory.create(fise);
	//DataFormatter formatter=new DataFormatter();
	Sheet sh=book.getSheet(sheetName);
	Row r=sh.getRow(rowNum);
	Cell c=r.getCell(cellNum);
	String value=c.getStringCellValue();
	book.close();
	//String value=formatter.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
	return value;
}
/** 
 * This method is used to write data into Excel
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param value
 * @throws Exception
 */
public void writeData(String sheetName,int rowNum,int cellNum,String value) throws Exception
{
	FileInputStream fis=new FileInputStream(Iconstants_Utility.excelPath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetName);
	Row r=sh.createRow(rowNum);
	Cell c=r.createCell(cellNum);
	c.setCellValue(value);
	
	FileOutputStream fos=new FileOutputStream(Iconstants_Utility.excelPath);
	book.write(fos);
	book.close();
	
}

/** This method will return the data to DataProvider
 * 
 * @param SheetName
 * @return
 * @throws Exception
 */
public Object[][] readDataFromExcel(String SheetName) throws Exception
{
	FileInputStream fis=new FileInputStream(Iconstants_Utility.excelPath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("DataProviderOrg");
	int lastRow=sh.getLastRowNum();
	int lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return  data;
}
}
