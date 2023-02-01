package product;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Object_Repo.Home_Page;


public class CreateProductDemoTest extends BaseClass 
{
	@Test(groups="main")
	public void CreateProductDemoTest() throws Throwable
	{
		Home_Page home=new Home_Page(driver);
		home.getProductLinkText().click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		Java_Utility jlib=new Java_Utility();
		int rannum=jlib.getRandomNum();
		Excel_Utility elib=new Excel_Utility();
		String prddata=elib.getExcelData("product", 0, 0)+rannum;
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prddata);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		

	}



}
