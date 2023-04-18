package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class CreateNewLeadPage extends WebDriverUtility {
	
	@FindBy(name="salutationtype")
	private WebElement FirstNameDropdown;

	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name="company")
	private WebElement CompanyEdt;
		
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement SaveBtn;
	
	public CreateNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getFirstNameDropdown()
	{
		return FirstNameDropdown;
	}
	
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getCompanyEdt() {
		return CompanyEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
		
	public void createLead(String FirstName,String LastName)
	{
		handleDropDown(FirstName, FirstNameDropdown);
		LastNameEdt.sendKeys(LastName);
		SaveBtn.click();
		
	}
	public void createLead(String FirstName,String LastName, String CompanyName)
	{
		handleDropDown(FirstName, FirstNameDropdown);
		LastNameEdt.sendKeys(LastName);
		CompanyEdt.sendKeys(CompanyName);
		SaveBtn.click();
}
}
