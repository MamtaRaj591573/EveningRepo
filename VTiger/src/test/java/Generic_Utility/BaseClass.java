package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repo.Home_Page;
import Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups= {"smoke","regression"})
	public void BS()
	{
		System.out.println("Database connection");
	}
	@BeforeTest(groups= {"smoke","regression"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void BC(String BROWSER) throws Throwable
	{
		//File_Utility flib=new File_Utility();
		//String BROWSER=flib.getKeyAndValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximizeScreen(driver);
		sdriver=driver;
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void BM() throws Throwable
	{
		File_Utility flib=new File_Utility();
		String URL=flib.getKeyAndValue("url");
		String USERNAME=flib.getKeyAndValue("username");
		String PASSWORD=flib.getKeyAndValue("password");
		driver.get(URL);
		Login_Page login=new Login_Page(driver);
		login.loginApp(USERNAME,PASSWORD);
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
	}
	
	
	
	
	
	@AfterMethod(groups= {"smoke","regression"})
	public void AM()
	{
		
		Home_Page home=new Home_Page(driver);
		home.getSignoutImg().click();
		home.signoutLink(driver);
	}
	@AfterClass(groups= {"smoke","regression"})
	public void AC()
	{
		
		
	}
	@AfterTest(groups= {"smoke","regression"})
	public void AT()
	{
		System.out.println("execution done");
	}
	@AfterSuite(groups= {"smoke","regression"})
	public void AS()
	{
		System.out.println("Databse closed");
	}


}
