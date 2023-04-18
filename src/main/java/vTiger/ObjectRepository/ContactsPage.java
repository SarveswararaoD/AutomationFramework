package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** This class consists of Web elements of Contacts Page
 * 
 * @author D.Sarveswararao
 *
 */
public class ContactsPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateNewContactLnk;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateNewContactLnk() {
		return CreateNewContactLnk;
	}
/** This method clicks on createContactLink
 * 
 */
	public void clickCreateContactsLnk()
	{
		CreateNewContactLnk.click();
	}
}
             