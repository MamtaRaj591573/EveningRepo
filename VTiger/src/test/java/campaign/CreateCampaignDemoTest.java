package campaign;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Object_Repo.Home_Page;

public class CreateCampaignDemoTest extends BaseClass
{
	@Test
	public void CreateCampaignDemoTest() throws Throwable
	{
	Home_Page home=new Home_Page(driver);
	home.moreLink(driver);
	home.clickCampaignlinkText();
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	Java_Utility jlib=new Java_Utility();
	int rannum=jlib.getRandomNum();
	Excel_Utility elib=new Excel_Utility();
	String campdata=elib.getExcelData("campaign", 0, 0)+rannum;
	driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campdata);
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	}
}
