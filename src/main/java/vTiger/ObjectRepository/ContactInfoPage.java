package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** This class contains ContactHeader text 
 * 
 * @author D.Sarveswararao
 *
 */
public class ContactInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	/** This method returns contactHeader to caller
	 * 
	 * @param ContactName
	 * @return
	 */
	public String getContactHeader(String ContactName)
	{
		return ContactHeaderText.getText();
		
	}

}
