package organisation;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		//Thread.sleep(4000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.titleContains("Accounts&parenttab"));

		Thread.sleep(5000);
//		Actions action=new Actions(driver);
//		WebElement contact_ele=driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]"));
//		action.moveToElement(contact_ele).perform();
		
		
		driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("raj");
		
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		//driver to next window
		
		Set<String> allid=driver.getWindowHandles();
		Iterator<String> itr=allid.iterator();
		while(itr.hasNext())
		{
			String id=itr.next();
			driver.switchTo().window(id);
			String title=driver.getTitle();
			if(title.contains("Accounts&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(orgdata);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgdata+"']")).click();
		Set<String> allid1=driver.getWindowHandles();
		Iterator<String> itr1=allid1.iterator();
		while(itr1.hasNext())
		{
			String id1=itr1.next();
			driver.switchTo().window(id1);
			String title1=driver.getTitle();
			if(title1.contains("Contacts&action"))
				break;
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	

	}

}
