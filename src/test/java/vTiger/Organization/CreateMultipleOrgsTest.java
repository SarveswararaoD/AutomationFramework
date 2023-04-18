package vTiger.Organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Utility.BaseClass;
import generic_Utility.Excel_Utility;
import generic_Utility.Iconstants_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTiger.ObjectRepository.OrganziationInfoPage;

public class CreateMultipleOrgsTest extends BaseClass {
	
	
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrganizationTest(String ORG, String Industry) throws Exception{
		
			
		 Random r=new Random();
		 int value=r.nextInt(1000);
	
		String Orgname=ORG+value;	
		
		HomePage hPage=new HomePage(driver);
		OrganizationsPage oPage=new OrganizationsPage(driver);
		CreateNewOrgPage newOrg=new CreateNewOrgPage(driver);
		OrganziationInfoPage oInfo=new OrganziationInfoPage(driver);
		
		
		hPage.clickOrganizationLnk();
	    oPage.clickCreateOrgLnk();
		newOrg.createOrganization(Orgname, Industry);		
		
		
	
		String OrgHeader=oInfo.getOrgHeader();
		if(OrgHeader.contains(Orgname))
		{
			System.out.println("created succesfully");
		}
		else
		{
			System.out.println("Couldn't create");
		}
		
		
	}
	
	@DataProvider(name = "OrgWithIndustry")
	public Object[][] getData() throws Exception
	{
		Object[][] data=eUtil.readDataFromExcel("DataProviderOrg");
		
		
		return data;
				
				
	}

}
