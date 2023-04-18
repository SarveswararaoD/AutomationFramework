package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;
/** This class consists of elements present in Home Page
 * 
 * @author D.Sarveswarao 
 *
 */
public class HomePage extends WebDriverUtility {

	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomeLnk;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorLnk;
		
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	
	public  HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getHomeLnk() {
		return HomeLnk;
	}


	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}


	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}


	public WebElement getContactsLnk() {
		return ContactsLnk;
	}


	public WebElement getAdminstratorLnk() {
		return AdminstratorLnk;
	}


	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	/** This method clicks on HomeLnk
	 * 
	 */
	public void clickHomeLnk()
	{
		HomeLnk.click();
	}
	/** This method clicks on LeadsLnk
	 * 
	 */
	public void clickLeadsLnk()
	{
		LeadsLnk.click();
	}
	public void clickOrganizationLnk()
	{
		OrganizationsLnk.click();
	}
	public void clickContactsLnk()
	{
		ContactsLnk.click();
	}
	public void clickSignOutLnk(WebDriver driver)
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.mouseHoverAction(driver, AdminstratorLnk);
		SignOutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
