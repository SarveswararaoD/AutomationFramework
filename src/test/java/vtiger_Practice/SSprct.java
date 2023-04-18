package vtiger_Practice;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import generic_Utility.Iconstants_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriverUtility;

public class SSprct {
	
			public Object[][] getMultipleData(String Sheet) throws Exception{
				
				FileInputStream fis=new FileInputStream(Iconstants_Utility.excelPath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(Sheet);
				int lastRow=s.getLastRowNum();
				int lastCell=s.getRow(0).getLastCellNum();
				DataFormatter df=new DataFormatter();
				Object[][] data=new Object[lastRow][lastCell];
				
				for(int i=0;i<lastRow;i++) {
					Row r=s.getRow(i+1);
					for(int j=0;j<lastCell;j++) {
						
						
						data[i][j]=df.formatCellValue(r.getCell(j));
						
					}
				}return data;
					
		}
			
			public static void main(String[] args) throws Exception {
				
				SSprct md=new SSprct();
				
				System.out.println(md.getMultipleData("MultipleData"));
			}
		}



