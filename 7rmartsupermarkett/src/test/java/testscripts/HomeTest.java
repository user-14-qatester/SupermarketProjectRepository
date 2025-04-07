package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	HomePage homepage;

	@Test(description="Verify whether user is able to logout successfully")
	public void verifyWhetherUserIsAbleToLogoutSuccessfully() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue=ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickOnSignInButton();
		homepage.clickAdminLink();
		loginpage=homepage.clickLogoutLink();
		String actualResult=homepage.getTextFromTitle();
		String expectedResult="7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, "User was unable to logout successfully");
	}
	
}
