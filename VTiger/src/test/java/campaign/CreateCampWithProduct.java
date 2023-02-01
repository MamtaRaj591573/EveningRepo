package campaign;

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
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampWithProduct
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
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		Random ran=new Random();
		int rannum=ran.nextInt(1000);
		FileInputStream efis=new FileInputStream("./src/test/resources/Jan5.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("product");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		String prddata=cel.getStringCellValue()+rannum;
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prddata);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		FileInputStream efis1=new FileInputStream("./src/test/resources/Jan5.xlsx");
		Workbook book1=WorkbookFactory.create(efis1);
		Sheet sh1=book1.getSheet("campaign");
		Row row1=sh1.getRow(0);
		Cell cel1=row1.getCell(0);
		String campname=cel1.getStringCellValue()+rannum;
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campname);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		//window switching 
		Set<String> allid=driver.getWindowHandles();
		Iterator<String> itr=allid.iterator();
		while(itr.hasNext())
		{
			String wid=itr.next();
			driver.switchTo().window(wid);
			String title=driver.getTitle();
			if(title.contains("Products&action"))
			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys(prddata);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+prddata+"']")).click();
		//window switching back
		Set<String> allid1=driver.getWindowHandles();
		Iterator<String> itr1=allid1.iterator();
		while(itr1.hasNext())
		{
			String wid1=itr1.next();
			driver.switchTo().window(wid1);
			String title1=driver.getTitle();
			if(title1.contains("Campaigns&action"))
			{
				break;
			}
			
		}
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
