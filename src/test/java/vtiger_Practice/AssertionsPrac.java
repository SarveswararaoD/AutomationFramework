package vtiger_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.Properties_Utility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;

public class AssertionsPrac {
	
	@Test
	public void practice()
	{
		System.out.println("Step1");
		Assert.assertEquals(false, true);
		System.out.println("Step2");
		Assert.assertTrue(false);
		System.out.println("Step3");
		
		System.out.println("Step4");
		
		System.out.println("Step5");
		
	}
	
	@Test
	public void practice1()
	{
		SoftAssert sa=new SoftAssert();
		
		System.out.println("Step1");
		sa.assertEquals(false, true);
		System.out.println("Step2");
		
		System.out.println("Step3");
		
		System.out.println("Step4");
		sa.assertEquals('a', 'c');
		System.out.println("Step5");
		sa.assertAll();
	}
}
