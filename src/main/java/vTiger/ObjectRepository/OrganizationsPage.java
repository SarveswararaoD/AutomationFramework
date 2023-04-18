package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** This class consists of web elements of Organization page
 * 
 * @author D.Sarveswararao
 *
 */
public class OrganizationsPage {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLnk;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCreateOrgLnk()
	{
		return createOrgLnk;
	}
	/** This method clicks on create organization link
	 * 
	 */
	public void clickCreateOrgLnk()
	{
		createOrgLnk.click();
	}
	
}
