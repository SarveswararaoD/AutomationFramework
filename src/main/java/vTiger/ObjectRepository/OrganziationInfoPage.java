package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;
/** This class consists of web elements of Organization info page
 * 
 * @author D.Sarveswararao
 *
 */
public class OrganziationInfoPage extends WebDriverUtility {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganziationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText()
	{
		return OrgHeaderText;
	}
	/** This method returns Organization header to caller
	 * 
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
	}
}
