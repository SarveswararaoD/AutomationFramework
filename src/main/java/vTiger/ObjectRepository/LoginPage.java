package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/** This class consists of all the elements present is LoginPage
 * 
 * @author D.Sarveswararao
 *
 */
public class LoginPage {      // create a seperate POM class for each webpage
	 // Identify all the elements using Annotations
	@FindBy(name="user_name")
	private  WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	// Create a constructor to initialise the variables
	public LoginPage(WebDriver driver) {     
		PageFactory.initElements(driver,this);
	}
// Provide getter methods for all the variables
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	// Create a Business library
	public void loginTopage(String UserName,String Password)
	{
	    getUserNameEdt().sendKeys(UserName);
	    getPasswordEdt().sendKeys(Password);
	    getLoginBtn().click();
	    
	}
	

}
