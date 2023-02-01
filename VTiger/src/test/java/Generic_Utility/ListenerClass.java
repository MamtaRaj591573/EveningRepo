package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener
{

	public void onTestFailure(ITestResult result) {
		{
			String testName=result.getMethod().getMethodName();
			System.out.println("-----------execute-------------");
			EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		
			File src=edriver.getScreenshotAs( OutputType.FILE);
			File dest=new File("./screenshot/"+testName+".png");
			try
			{
				FileUtils.copyFile(src,dest);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
