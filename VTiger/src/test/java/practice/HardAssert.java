package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert 
{
	/*@Test
	public void createContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		//hard assert
		Assert.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void modifyContact()
	{
		System.out.println("step5");
		System.out.println("step6");
	}
	*/
	@Test
	public void demo()
	{
		String actual="momo";
		String expected="momo";
		Assert.assertEquals(expected, actual);
	}

}
