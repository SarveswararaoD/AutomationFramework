package generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/** This class contains basic configuration Annotations
 * 
 * @author D.Sarveswararao
 *
 */
public class BaseClass_CrossBroswer {
	public Properties_Utility pUtil=new Properties_Utility();
public 	Excel_Utility eUtil=new Excel_Utility();
	public Java_Utility jUtil=new Java_Utility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public static WebDriver sdriver;
	public WebDriver driver=null;
	
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("DB connection Successful");
	}

	@Parameters("browser")
	@BeforeClass
	public void bcConfig(String browser) throws Exception
	{
		String URL=pUtil.readDataFromProperties("url");
		//String Browser=pUtil.readDataFromProperties("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);
			System.out.println("Browser launched");
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{   
			System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Browser launched");
		}
		else
		{
			System.out.println("Invalid browser");
		}
		sdriver=driver;
		driver.get(URL);
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
	}
	
	@BeforeMethod
	public void bmConfig() throws Exception
	{
		String Uname=pUtil.readDataFromProperties("username");
		String Pwd=pUtil.readDataFromProperties("password");
		
		LoginPage lPage=new LoginPage(driver);
		lPage.loginTopage(Uname, Pwd);
		System.out.println("Login succesfull");
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hPage=new HomePage(driver);
		hPage.clickSignOutLnk(driver);
		System.out.println("Logout successful");
	}
	
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("DB connection closed");
	}
}
