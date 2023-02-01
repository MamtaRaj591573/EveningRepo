package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{

	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);//to initialize web elements
		//static iniiElement static method of PageFactoryfor initializing web element
		//@FindyBy :webelements are identified by this annotation
		//tagName, partialLinkText, name, linkText, id, css, className, xpath

	}
	//declaration
	@FindBy(name="user_name")
	private WebElement usertextfield ;
	@FindBy(name="user_password")
	private WebElement passwordtextfield;
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	//getter methods
	public WebElement getUsertextfield()
	{
		return usertextfield;
	}	
	public WebElement getPasswordtextfield()
	{
		return passwordtextfield;
	}
	public WebElement getLoginbutton() 
	{
		return loginbutton;
	}
	//business logic
	public void loginApp(String username,String password)
	{
		usertextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		loginbutton.click();
	}
	
}
