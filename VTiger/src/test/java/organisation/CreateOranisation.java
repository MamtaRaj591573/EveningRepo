 package organisation;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Object_Repo.Home_Page;

public class CreateOranisation 
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
			Thread.sleep(2000);
					

			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();

	}

}
