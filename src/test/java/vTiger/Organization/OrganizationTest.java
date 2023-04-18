package vTiger.Organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_Utility.BaseClass;
import generic_Utility.Excel_Utility;
import generic_Utility.Iconstants_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriverUtility;

import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTiger.ObjectRepository.OrganziationInfoPage;
@Listeners(generic_Utility.ListenersImplementationClass.class)
public class OrganizationTest extends BaseClass{
	@Test(groups = {"smoke"})
	public void createOrganizationTest() throws Exception{
		FileInputStream fisp=new FileInputStream(Iconstants_Utility.propertyPath);
		Properties p=new Properties();
		Excel_Utility eUtil=new Excel_Utility();
		Java_Utility jUtil=new Java_Utility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
	
		HomePage hPage=new HomePage(driver);
		OrganizationsPage oPage=new OrganizationsPage(driver);
		CreateNewOrgPage newOrg=new CreateNewOrgPage(driver);
		OrganziationInfoPage oInfo=new OrganziationInfoPage(driver);
		
	
		Random r=new Random();
		int value=r.nextInt(10000);
		
		
		String Orgname=eUtil.readDataFromExcel("Organization",4 ,2 )+value;
		String Industry=eUtil.readDataFromExcel("Organization",4,3);		
		
		
		
		hPage.clickOrganizationLnk();
		Reporter.log("clicked on organization link");
		
		//Assert.fail();
	    oPage.clickCreateOrgLnk();
	    Reporter.log("clicked on create organization link");
		newOrg.createOrganization(Orgname, Industry);		
		
		
	
		String OrgHeader=oInfo.getOrgHeader();
	Assert.assertTrue(OrgHeader.contains(Orgname));
		
	}
	}


