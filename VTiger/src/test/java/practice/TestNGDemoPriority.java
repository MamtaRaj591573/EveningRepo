package practice;

import org.testng.annotations.Test;

public class TestNGDemoPriority 
{
	@Test(priority=1)
	public void create()
	{
		System.out.println("create run");
	}
	@Test(priority=2)
	public void modify()
	{
		System.out.println("modify run");
	}
	@Test(priority=3)
	public void delete()
	{
		System.out.println("delete run");
	}
	
	

}
