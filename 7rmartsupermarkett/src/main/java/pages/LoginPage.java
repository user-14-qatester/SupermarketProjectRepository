package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']") private WebElement username;
	@FindBy(xpath="//input[@name='password']") private WebElement password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") private WebElement signInButton;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement errorAlert;



	public LoginPage enterUsername(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}

	public HomePage clickOnSignInButton()
	{
		signInButton.click();
		return new HomePage(driver);
	}
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public boolean isErrorAlertDisplayed()
	{
		return errorAlert.isDisplayed();
	}
}
