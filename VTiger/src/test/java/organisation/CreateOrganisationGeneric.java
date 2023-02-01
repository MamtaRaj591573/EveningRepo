package organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repo.Home_Page;
import Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationGeneric 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		String BROWSER=flib.getKeyAndValue("browser");
		WebDriver driver;
	
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}
		Login_Page login=new Login_Page(driver);
		Home_Page home=new Home_Page(driver);
		wlib.maximizeScreen(driver);
		String URL=flib.getKeyAndValue("url");
		String USERNAME=flib.getKeyAndValue("username");
		String PASSWORD=flib.getKeyAndValue("password");
		driver.get(URL);
		login.loginApp(USERNAME, PASSWORD);
		wlib.waitForPageToLoad(driver);	
		
		home.clickOrganisationsLinkText();
	
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		int rannum=jlib.getRandomNum();
		String orgdata=elib.getExcelData("organisation", 0, 0)+rannum;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgdata);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(4000);
		home.getSignoutImg().click();
		home.signoutLink(driver);


	}

}
