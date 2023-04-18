package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;
/** This class consists of web elements present in createNewOrganization webpage
 * 
 * @author D.Sarveswararao
 *
 */
public class CreateNewOrgPage extends WebDriverUtility{
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewOrgPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	/** This method creates Organization with Organization name and submits it
	 * 
	 * @param OrgName
	 */
	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	/** This method creates organization with Organization name and industry type and submits it
	 * 
	 * @param OrgName
	 * @param Industry
	 */
	public void createOrganization(String OrgName,String Industry)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(Industry, IndustryDropdown);
		SaveBtn.click();
	}

}
