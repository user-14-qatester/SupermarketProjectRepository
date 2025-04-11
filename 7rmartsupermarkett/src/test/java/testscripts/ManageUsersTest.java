package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageUsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageUsersTest extends Base {

	ManageUsersPage manageusers;
	HomePage homepage;
	@Test(description = "Verify whether user is able to navigate to Manage Users page and add a new user", priority = 1)
	public void verifyWhetherUserIsAbleToNavigateToManageUsersPageAndAddANewUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		homepage.clickOnAdminUsersNavigationLink();
		manageusers=homepage.clickOnManageUsersRadioButton();
		manageusers.clickOnNewButtonOfManageUsersPage();
		RandomDataUtility random=new RandomDataUtility();
		String userNameFieldValue = random.createRandomUsername();
		String passwordFieldValue = random.createRandomPassword();
		manageusers.enterValueOnUsernameFieldofManageUsersPage(userNameFieldValue).enterValueOnPasswordFieldofManageUsersPage(passwordFieldValue).selectUserType().clickOnSaveButtonManageUsersPage();
		boolean isAlertCloseButtonDisplayed = manageusers.isAlertCloseButtonDisplayed();
		Assert.assertTrue(isAlertCloseButtonDisplayed, Messages.ADDANEWUSERERROR);

	}

	@Test(description = "Verify whether user is able to navigate to Manage Users page and search for a user", priority = 2,retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToNavigateToManageUsersPageAndSearchForAUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		homepage.clickOnAdminUsersNavigationLink();
		manageusers=homepage.clickOnManageUsersRadioButton();
		manageusers.clickOnSearchButtonOfManageUsersPage();
		String usernameValue = ExcelUtility.getStringdata(0, 0, "ManageUsersSearchUser");
		manageusers.enterValueOnUsernameFieldToSearchAUser(usernameValue).selectUserTypeToSearchAUser().clickOnSearchUserButton();
		boolean isAdminUsersHeaderDisplayed = manageusers.isAdminUsersHeaderDisplayed();
		Assert.assertTrue(isAdminUsersHeaderDisplayed, Messages.SEARCHFORAUSERERROR);
	}

	@Test(description = "Verify whether user is able to navigate to Manage Users page and perform a reset", priority = 3)
	public void verifyWhetherUserIsAbleToNavigateToManageUsersPageAndPerformAReset() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		homepage.clickOnAdminUsersNavigationLink();
		manageusers=homepage.clickOnManageUsersRadioButton();
		manageusers.clickOnSearchButtonOfManageUsersPage();
		String usernameValue = ExcelUtility.getStringdata(0, 0, "ManageUsersSearchUser");
		manageusers.enterValueOnUsernameFieldToSearchAUser(usernameValue).selectUserTypeToSearchAUser().clickOnSearchUserButton().scrollManageUsersPage().clickOnResetButton();
		boolean isSearchUsersHeaderDisplayed = manageusers.isSearchUsersHeaderDisplayed();
		Assert.assertFalse(isSearchUsersHeaderDisplayed, Messages.RESETERROR);
	}
}
