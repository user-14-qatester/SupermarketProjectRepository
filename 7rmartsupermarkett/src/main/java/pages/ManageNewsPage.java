package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;



public class ManageNewsPage 
{
	WaitUtility wait = new WaitUtility();
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-danger']") private WebElement newButtonManageNewsPage;
	@FindBy(xpath="//textarea[@id='news']") private WebElement newsEntryArea;
	@FindBy(xpath="//button[@type='submit']") private WebElement saveButtonAddNewsPage;
	@FindBy(xpath="//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-primary']") private WebElement searchButtonManageNews; 
	@FindBy(xpath="//input[@placeholder='Title']") private WebElement titleField;
	@FindBy(xpath="//button[@value='sr']") private WebElement searchUserButtonSeachNews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement addNewsSuccessAlert;

	@FindBy(xpath="//h4[text()='Manage News']") private WebElement manageNewsHeader;
	
	



public ManageNewsPage clickOnNewButtonOfManageNewsPage()
{
	newButtonManageNewsPage.click();
	return this;
}
public ManageNewsPage addNews(String news)
{
	newsEntryArea.sendKeys(news);
	return this;
}
public ManageNewsPage clickOnSaveButton()
{
	saveButtonAddNewsPage.click();
	return this;
}
public ManageNewsPage clickOnSearchButtonManageNews()
{
	searchButtonManageNews.click();
	return this;
}
public ManageNewsPage enterNewsToSearch(String newsSearch)
{
	titleField.sendKeys(newsSearch);
	return this;
}
public ManageNewsPage clickOnSearchButtonSearchNews()
{
	searchUserButtonSeachNews.click();
	return this;
}
public ManageNewsPage isAlertDisplayed()
{
	wait.waitUntilAlertIsPresent(driver, addNewsSuccessAlert);
	return this;
}
public boolean isSuccessAlertDisplayed()
{
	return addNewsSuccessAlert.isDisplayed();
}
public boolean isSearchResultsDisplayed()
{
	return manageNewsHeader.isDisplayed();
}
}