package generic_Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/** This class consists of generic methods related to webDriver actions
 * 
 * @author D.Sarveswararao
 *
 */
public class WebDriverUtility {
	/**
	 * This method maximizes the browser window
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method minimizes the browser window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * This method waits for the page to be loaded for 20 seconds
 * @param driver
 * @param element
 */
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
/**
 * This method waits for a webElement to be visible for 20 seconds
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method waits for the webElement to be click-able for  20 seconds
 * @param driver
 * @param element
 */
public void waitForElementTOClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method handles the drop down using index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element, int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method handles the drop down using value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element,String value)
{
	Select sel=new Select(element);
	sel.selectByValue(value);
}
/**
 * This method handles the drop down using Visible Text
 * @param text
 * @param element
 */
public void handleDropDown(String text, WebElement element)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/** This method will help to mouse to a particular webElement
 * 
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();;
}
/** This method will help to right click anywhere in the browser
 * 
 * @param driver
 */
public void rightClick(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/** This method will right click on particular element
 * 
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/** This method will double click anywhere in the browser
 * 
 * @param driver
 */
public void doubleClick(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/** This method will double click on particular element
 * 
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/** This method will perform drag and drop operation from selected source to target element
 * 
 * @param driver
 * @param src
 * @param target
 */
public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src, target).perform();
}
/** This method will drag and drop on a selected element
 * Can be used for slider operations
 * @param driver
 * @param src
 * @param x
 * @param y
 */
public void dragAndDrop(WebDriver driver,WebElement src, int x,int y)
{
	Actions act=new Actions(driver);
	act.dragAndDropBy(src,x ,y);
}
/** This method will click on Enter key
 * 
 * @param driver
 * @throws Exception
 */
public void pressEnter() throws Exception
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
}
/** This method will release Enter key
 * 
 * @throws Exception
 */
public void releaseEnter() throws Exception
{
	Robot r=new Robot();
	r.keyRelease(KeyEvent.VK_ENTER);
}
/** This method will handle a frame using index number 
 * 
 * @param driver
 * @param frameIndex
 */
public void handleFrame(WebDriver driver, int frameIndex)
{
	driver.switchTo().frame(frameIndex);
}
/** This method will handle frame using nameorId
 * 
 * @param driver
 * @param nameorId
 */
public void handleFrame(WebDriver driver,String nameorId)
{
	driver.switchTo().frame(nameorId);
}
/** This method handles frames using web element
 * 
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/** This method will switch the current frame to immediate parent frame
 * 
 * @param driver
 */
public void handleParent(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/** This method will switch back to default parent frame
 * 
 * @param driver
 */
public void switchBacktoDefault(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/** This method will accept the alert popup
 * 
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/** 
 * This method will dismiss the alert popup
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/** This method will print the alert text
 * 
 * @param driver
 * @return
 */
public String printAlert(WebDriver driver)
{
 return	driver.switchTo().alert().getText();
}
/** This method will take screenshot and save it with given name
 * 
 * @param driver
 * @param screenshotName
 * @throws Exception
 */
public String takeScreenshot(WebDriver driver,String screenshotname) throws Exception
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".\\Screenshots\\"+screenshotname+".png");
	FileUtils.copyFile(src, dest);
	
	return dest.getAbsolutePath();// To save it to Extent reports
}
/** This method can switch between windows either from parent to child or child to parent
 * 
 * @param driver
 * @param partialWinTitle
 */
public void switchWindow(WebDriver driver, String partialWinTitle)
{
	// To capture all window IDS
	Set<String> winIDS=driver.getWindowHandles();
// To compare the windows and switch accordingly	
	for(String id:winIDS)
	{
		String currentWin=driver.switchTo().window(id).getTitle();
		
		if(currentWin.equals(partialWinTitle))
		{
			break;
		}
	}
}
/** This method will scroll down randomly
 * 
 * @param driver
 */
public void scroll(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)","");
}
/** This method will scroll down till it finds the given element
 * 
 * @param driver
 * @param element
 */
public void scroll(WebDriver driver,WebElement element)
{
JavascriptExecutor jse=(JavascriptExecutor)driver;
int y=element.getLocation().getY();
jse.executeScript("window.scrollBy(0,"+y+")", element);
}













}