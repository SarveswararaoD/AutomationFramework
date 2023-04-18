package crossBrowserExecutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_Utility.BaseClass;
import generic_Utility.BaseClass_CrossBroswer;
import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.Properties_Utility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsPage;
import vTiger.ObjectRepository.OrganziationInfoPage;
@Listeners(generic_Utility.ListenersImplementationClass.class)
public class CreateContactWithOrgNameTest extends BaseClass_CrossBroswer{
@Test
public void createContactWithOrgTest() throws Exception
{
	String LastName=eUtil.readDataFromExcel("Contacts", 2, 2)+jUtil.getRandomNumber();
	String OrgName=eUtil.readDataFromExcel("Contacts", 2, 3)+jUtil.getRandomNumber();
	String Industry=eUtil.readDataFromExcel("Organization", 4, 3);
	
	HomePage hPage=new HomePage(driver);
	OrganizationsPage oPage=new OrganizationsPage(driver);
	CreateNewOrgPage newOrg=new CreateNewOrgPage(driver);
	OrganziationInfoPage oInfo=new OrganziationInfoPage(driver);
	ContactsPage cPage=new ContactsPage(driver);
	CreateNewContactPage newContact=new CreateNewContactPage(driver);
	ContactInfoPage cInfo=new ContactInfoPage(driver);
	
	hPage.clickOrganizationLnk();
	oPage.clickCreateOrgLnk();
	newOrg.createOrganization(OrgName, Industry);
	String OrgHeader=oInfo.getOrgHeader();
	
	if(OrgHeader.contains(OrgName))
	{
		System.out.println("Organization created");
	}
	else
	{
		System.out.println("Organization not created");
	}
	
	
	hPage.clickContactsLnk();
	cPage.clickCreateContactsLnk();
	newContact.createContact(driver, LastName, OrgName);
	String ContactHeader=cInfo.getContactHeader(LastName);
	
	if(ContactHeader.contains(LastName))
	{
		System.out.println("Contact created");
	}
	else
	{
		System.out.println("Contact not created");
	}
	}

@Test
public void demo()
{
	System.out.println("demo");
}
}
