package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class Home_Page
{
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	@FindBy(linkText="More")
	private WebElement moreLink;
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLinkText;
	@FindBy(linkText="Organizations")
	private WebElement organisationLinkText;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG'] ")
	private WebElement signoutImg;
	@FindBy(linkText="Sign Out")
	private WebElement signoutLinkText;
	
	//getters methods
	public WebElement getProductLinkText() {
		return productLinkText;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getCampaignsLinkText() {
		return campaignsLinkText;
	}
	public WebElement getOrganisationLinkText() {
		return organisationLinkText;
	}
	public WebElement getSignoutImg() {
		return signoutImg;
	}
	public WebElement getSignoutLinkText() {
		return signoutLinkText;
	}
	
	//Business logic for product
	public void clickProductLink()
	{
		productLinkText.click();
	}
	//Business logic for More
	public void moreLink(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnElement(driver,moreLink);
		
	}
	//campaign
	public void clickCampaignlinkText()
	{
		campaignsLinkText.click();
	}
	//organisation
	public void clickOrganisationsLinkText()
	{
		organisationLinkText.click();
	}
	//signout
	public void signoutLink(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(signoutImg).perform();
		signoutLinkText.click();
	}
}
