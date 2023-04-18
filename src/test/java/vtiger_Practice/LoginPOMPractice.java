package vtiger_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import generic_Utility.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewLeadPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LeadsPage;
import vTiger.ObjectRepository.LoginPage;

public class LoginPOMPractice {
public static void main(String[] args) {
	 
	WebDriverUtility wUtil=new WebDriverUtility();
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(option);
	
	driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");

	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	LoginPage lPage=new LoginPage(driver);
	lPage.loginTopage("admin","admin");
	
	HomePage hPage=new HomePage(driver);
	LeadsPage LeadsPage=new LeadsPage(driver);
	hPage.clickLeadsLnk();
	//LeadsPage.clickCreateLeadsBtn();
	//CreateNewLeadPage create=new CreateNewLeadPage(driver);
	
	hPage.clickContactsLnk();
	
	hPage.clickHomeLnk();
	
	
	
	/*  create.selectLastName("AVCS");
	create.selectCompany("FGDG");
	create.clickSaveBtn();
	*/
	
	hPage.clickHomeLnk();
	
	hPage.clickOrganizationLnk();
	
	hPage.clickSignOutLnk(driver);
}
}
