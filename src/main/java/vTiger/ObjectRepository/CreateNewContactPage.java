package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;
/**
 *  This class contains all the required web elements of CreateContactPage
 * @author D.Sarveswararao
 *
 */
public class CreateNewContactPage extends WebDriverUtility{
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchNowBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/** This method creates contact with mandatory fields
	 * 
	 * @param LastName
	 */
	public void createContact(String LastName)
	{
		LastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}
	/** This method creates contact with lastName and Organization name
	 * 
	 * @param driver
	 * @param LastName
	 * @param OrgName
	 */
	public void  createContact(WebDriver driver,String LastName,String OrgName)
	{
		LastNameEdt.sendKeys(LastName);
		OrgLookUpImg.click();
		switchWindow(driver, "Accounts");
		SearchEdt.sendKeys(OrgName);
		SearchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchWindow(driver,"Contacts");
		SaveBtn.click();
		
	}
}
