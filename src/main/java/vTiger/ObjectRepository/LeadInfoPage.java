package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class LeadInfoPage extends WebDriverUtility {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement LeadHeaderText;
	
	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLeadHeaderText() {
		return LeadHeaderText;
	}
	
	public String getLeadHeader()
	{
	return	LeadHeaderText.getText();
	}

}
