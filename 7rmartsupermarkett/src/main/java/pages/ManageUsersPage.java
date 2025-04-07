package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class ManageUsersPage {
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonManageUsersPage;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@type='submit']//child::i[@class='fa fa-save']")
	private WebElement saveButtonManageUsersPage;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButtonManageUsersPage;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement usernameFieldSearchUser;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement userTypeSearchUser;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchUserButton;
	@FindBy(xpath = "//button[@value='sr']//following::a[@class='btn btn-default btn-fix']")
	private WebElement resetUserButton;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseButton;

	@FindBy(xpath = "//h4[text()='Search Admin Users']")
	private WebElement searchUsersHeader;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	private WebElement adminUsersHeader;

	

	public ManageUsersPage clickOnNewButtonOfManageUsersPage() {
		newButtonManageUsersPage.click();
		return this;
	}

	public ManageUsersPage enterValueOnUsernameFieldofManageUsersPage(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public ManageUsersPage enterValueOnPasswordFieldofManageUsersPage(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public ManageUsersPage selectUserType() {
		
		Select select = new Select(userTypeDropdown);
		select.selectByIndex(3);
		return this;
		
	}

	public ManageUsersPage clickOnSaveButtonManageUsersPage() {
		wait.waitUntilElementToBeClickable(driver, saveButtonManageUsersPage);
		saveButtonManageUsersPage.click();
		return this;
	}

	public ManageUsersPage clickOnSearchButtonOfManageUsersPage() {
		searchButtonManageUsersPage.click();
		return this;
	}

	public ManageUsersPage enterValueOnUsernameFieldToSearchAUser(String usernameSearchUser) {
		usernameFieldSearchUser.sendKeys(usernameSearchUser);
		return this;
	}

	public ManageUsersPage selectUserTypeToSearchAUser() {
		Select select = new Select(userTypeSearchUser);
		
		select.selectByIndex(2);
		return this;
	}

	public ManageUsersPage clickOnSearchUserButton() {
		searchUserButton.click();
		return this;
	}

	public ManageUsersPage scrollManageUsersPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		return this;
	}

	public ManageUsersPage clickOnResetButton() {
		resetUserButton.click();
		return this;
	}

	public boolean isAlertCloseButtonDisplayed() {
		return alertCloseButton.isDisplayed();
	}

	public boolean isSearchUsersHeaderDisplayed() {
		return searchUsersHeader.isDisplayed();
	}

	public boolean isAdminUsersHeaderDisplayed() {
		return adminUsersHeader.isDisplayed();
	}
}
