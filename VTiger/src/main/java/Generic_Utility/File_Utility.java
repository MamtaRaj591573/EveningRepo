package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility 
{
	public String getKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}
}
