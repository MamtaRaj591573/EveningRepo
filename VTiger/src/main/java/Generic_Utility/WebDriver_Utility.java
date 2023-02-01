package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility 
{
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	/** used to wait for element to be clickable 
	 * 
	 */
	 public void  waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime)
	 {
		 FluentWait wait=new FluentWait(driver);
		 wait.pollingEvery(Duration.ofSeconds(pollingTime));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 
	 }
	 public void switchToWindow(WebDriver driver,String partialWindowTitle)
	 {
		 Set<String> allid=driver.getWindowHandles();
		 Iterator<String> itr=allid.iterator();
		 while(itr.hasNext())
		 {
			 String wid=itr.next();
			 driver.switchTo().window(wid);
			 if(driver.getTitle().contains(partialWindowTitle))
				 break;
		 }
	 }
	 public void switchToAlertAndAccept(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
		 
	 }
	 public void switchToAlertAndDismiss(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 public void switchToFrame(WebDriver driver, int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 public void switchToFrame(WebDriver driver,String id_name_attribute)
	 {
		 driver.switchTo().frame(id_name_attribute);
	 }
	 public void select(WebElement element,int index)
	 {
		 Select sel=new Select(element);
		 sel.selectByIndex(index);
		 
	 }
	 public void select(WebElement element,String text)
	 {
		 Select sel=new Select(element);
		 sel.selectByValue(text);
		 
	 }
	 public void mouseOverOnElement(WebDriver driver,WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.moveToElement(element).perform();
		 
	 }
	 public void rightCickOnElement(WebDriver driver,WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.contextClick(element).perform();
		 
	 }
	 public void moveByOffset(WebDriver driver,int x,int y)
	 {
		 Actions action=new Actions(driver);
		 action.moveByOffset(x,y).click().perform();
		 
	 }
	 
}
