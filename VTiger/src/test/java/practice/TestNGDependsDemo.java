package practice;

import org.testng.annotations.Test;

public class TestNGDependsDemo
{
	@Test(invocationCount=2)
	public void create()
	{
		System.out.println("create");
		//int ar[]= {1,2,3};
		//System.out.println(ar[5]);
		//fail and rest will skip as dependent on this method   
	}
	@Test(dependsOnMethods="create")
	public void modify()
	{
		System.out.println("modify");
	}
	@Test(dependsOnMethods="modify")
	public void delete()
	{
		System.out.println("delete");
	}

}
