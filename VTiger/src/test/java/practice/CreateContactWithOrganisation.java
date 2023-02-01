package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.WebDriver_Utility;

public class CreateContactWithOrganisation 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Random ran=new Random();
		int rannum=ran.nextInt(1000);
		FileInputStream efis=new FileInputStream("./src/test/resources/Jan5.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("organisation");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		String orgdata=cel.getStringCellValue()+rannum;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgdata);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		WebDriver_Utility wlib=new WebDriver_Utility();

		//navigate to contact
		WebElement contacttab=driver.findElement(By.linkText("Contacts"));
		wlib.mouseOverOnElement(driver, contacttab);
		contacttab.click();
		
		wlib.waitForElementWithCustomTimeOut(driver, contacttab, 10);
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Raj");
		//+org
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		//switch to another window
		Set<String> allid=driver.getWindowHandles();
		Iterator<String> itr=allid.iterator();
		while(itr.hasNext())
		{
			String wid=itr.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Accounts&action"))
				break;
		}
		//search and pass value
		
		driver.findElement(By.id("search_txt")).sendKeys(orgdata);
		driver.findElement(By.xpath("//input[@name='search']"));
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		
		//switch to parent window
		
		Set<String> allid1=driver.getWindowHandles();
		Iterator<String> itr1=allid1.iterator();
		while(itr1.hasNext())
		{
			String wid1=itr1.next();
			driver.switchTo().window(wid1);
			if(driver.getTitle().contains("Contacts&action"));
				break;
		}
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();	
		
	}

}
