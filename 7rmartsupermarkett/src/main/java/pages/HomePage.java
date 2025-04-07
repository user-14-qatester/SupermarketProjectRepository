package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage 
{
    WaitUtility wait=new WaitUtility();
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") private WebElement adminUser;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") private WebElement logout;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement mainTitle;
	@FindBy(xpath="//p[text()='Manage News']//parent::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") private WebElement manageNewsNav;
	@FindBy(xpath = "//a[@class='nav-link']//child::i[@class='nav-icon fas fa-users']")
	private WebElement adminUserNav;
	@FindBy(xpath = "//p[text()='Manage Users']//parent::a[@class='nav-link']")
	private WebElement manageUserRadiobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subcatgeoryHomeButton;
	
	
	public HomePage clickAdminLink()
	{
		adminUser.click();
		return this;
	}
	
	public LoginPage clickLogoutLink()
	{
		wait.waitUntilVisibilityOfElement(driver, logout);
		logout.click();
		return new LoginPage(driver);
	}
	public String getTextFromTitle()
	{
		return mainTitle.getText();
	}
	
	public ManageNewsPage clickOnManageNewsNavigationLink()
	{
		manageNewsNav.click();
		return new ManageNewsPage(driver);
	}
	
	public HomePage clickOnAdminUsersNavigationLink() {
		adminUserNav.click();
		return this;
	}

	public ManageUsersPage clickOnManageUsersRadioButton() {
	//	wait.waitUntilElementToBeSelected(driver, manageUserRadiobutton);
		manageUserRadiobutton.click();
		return new ManageUsersPage(driver);	
	}
	public SubCategoryPage clickOnSubcategoryHomeButton()
	{
		subcatgeoryHomeButton.click();
		return new SubCategoryPage(driver);
	}
}
