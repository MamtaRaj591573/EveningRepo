package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage
{
	public ValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="span.lvtHeaderText")
	private WebElement actualProductData;
	@FindBy(css="span.dvtHeaderText")
	private WebElement actualCampaignData;
	@FindBy(css="span.dvtHeaderText")
	private WebElement actualOrganisationData;
	@FindBy(css="input[title='Delete [Alt+D]'")
	private WebElement deleteButton;
	
	
	
	public WebElement getActualProductData() {
		return actualProductData;
	}
	public void setActualProductData(WebElement actualProductData) {
		this.actualProductData = actualProductData;
	}
	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}
	public void setActualCampaignData(WebElement actualCampaignData) {
		this.actualCampaignData = actualCampaignData;
	}
	public WebElement getActualOrganisationData() {
		return actualOrganisationData;
	}
	public void setActualOrganisationData(WebElement actualOrganisationData) {
		this.actualOrganisationData = actualOrganisationData;
	}
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(WebElement deleteButton) {
		this.deleteButton = deleteButton;
	}
	//Business logic
	public void verificationOfProductDataCreated(String productName)
	{
		String actData=actualProductData.getText();
		if(actData.contains(productName))
			System.out.println("pass");
		else
		   System.out.println("Fail");
	}
	public void verificationOfCampaignDataCreated(String campaignName)
	{
		String actData=actualProductData.getText();
		if(actData.contains(campaignName))
			System.out.println("pass");
		else
		   System.out.println("Fail");
	}
	public void verificationOfOrganisationDataCreated(String organisationName)
	{
		String actData=actualProductData.getText();
		if(actData.contains(organisationName))
			System.out.println("pass");
		else
		   System.out.println("Fail");
	}
	public void verificationOfProductData
	
	(String productName)
	{
		String actData=actualProductData.getText();
		if(actData.contains(productName))
			System.out.println("pass");
		else
		   System.out.println("Fail");
	}

}
