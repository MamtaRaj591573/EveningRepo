package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repo.Home_Page;
import Object_Repo.Login_Page;

public class CreateCampWithProductUtilityObj 
{

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		Login_Page login=new Login_Page(driver);
		Home_Page home=new Home_Page(driver);
		
		wlib.maximizeScreen(driver);
		
		String URL=flib.getKeyAndValue("url");
		String USERNAME=flib.getKeyAndValue("username");
		String PASSWORD=flib.getKeyAndValue("password");
		driver.get(URL);
		
		login.loginApp(USERNAME, PASSWORD);
		wlib.waitForPageToLoad(driver);		
		home.clickProductLink();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		int rannum=jlib.getRandomNum();
		
		String prddata=elib.getExcelData("product", 0, 0)+rannum;
		
		driver.findElement(By.name("productname")).sendKeys(prddata);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//additional link with campaign
		
		home.moreLink(driver);
		
		
//		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		String campdata=elib.getExcelData("campaign", 0, 0)+rannum;
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campdata);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//window switching
		
		wlib.switchToWindow(driver,"Products&action");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(prddata);
		
		//search button
		
		driver.findElement(By.xpath("//input[@name='search']")).click();
		//click on displayed product
		driver.findElement(By.xpath("//a[text()='"+prddata+"']")).click();
		
		//window switching back
		wlib.switchToWindow(driver, "Campaigns&action");
		//save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		home.getSignoutImg().click();
		home.signoutLink(driver);


	}

}
