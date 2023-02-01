package organisation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Object_Repo.Home_Page;

public class CreateOrganisationDemoTest extends BaseClass
{
	@Test()
	public void CreateOrganisationDemoTest() throws Throwable
	{
				
		Home_Page home=new Home_Page(driver);
		home.getOrganisationLinkText().click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Java_Utility jlib=new Java_Utility();
		int rannum=jlib.getRandomNum();
		Excel_Utility elib=new Excel_Utility();
		String orgdata=elib.getExcelData("organisation", 0, 0)+rannum;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgdata);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
	}

}
