package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
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
		homepage=login.enterUsername(usernamevalue).enterPassword(passwordvalue).clickOnSignInButton();
		manageusers=homepage.clickOnAdminUsersNavigationLink().clickOnManageUsersRadioButton();
		manageusers.clickOnNewButtonOfManageUsersPage();
		RandomDataUtility random=new RandomDataUtility();
		String userNameFieldValue = random.createRandomUsername();
		String passwordFieldValue = random.createRandomPassword();
		manageusers.enterValueOnUsernameFieldofManageUsersPage(userNameFieldValue);
		manageusers.enterValueOnPasswordFieldofManageUsersPage(passwordFieldValue);
		manageusers.selectUserType();
		manageusers.clickOnSaveButtonManageUsersPage();
		boolean isAlertCloseButtonDisplayed = manageusers.isAlertCloseButtonDisplayed();
		Assert.assertTrue(isAlertCloseButtonDisplayed, "User was unable to add a new user");

	}

	@Test(description = "Verify whether user is able to navigate to Manage Users page and search for a user", priority = 2)
	public void verifyWhetherUserIsAbleToNavigateToManageUsersPageAndSearchForAUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		homepage=login.enterUsername(usernamevalue).enterPassword(passwordvalue).clickOnSignInButton();
		

		manageusers=homepage.clickOnAdminUsersNavigationLink().clickOnManageUsersRadioButton();
		manageusers.clickOnSearchButtonOfManageUsersPage();
		String usernameValue = ExcelUtility.getStringdata(0, 0, "ManageUsersSearchUser");
		manageusers.enterValueOnUsernameFieldToSearchAUser(usernameValue);
		manageusers.selectUserTypeToSearchAUser();
		manageusers.clickOnSearchUserButton();
		boolean isAdminUsersHeaderDisplayed = manageusers.isAdminUsersHeaderDisplayed();
		Assert.assertTrue(isAdminUsersHeaderDisplayed, "Results not displayed on searching for a user");
	}

	@Test(description = "Verify whether user is able to navigate to Manage Users page and perform a reset", priority = 3)
	public void verifyWhetherUserIsAbleToNavigateToManageUsersPageAndPerformAReset() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		homepage=login.enterUsername(usernamevalue).enterPassword(passwordvalue).clickOnSignInButton();

		manageusers=homepage.clickOnAdminUsersNavigationLink().clickOnManageUsersRadioButton();
		manageusers.clickOnSearchButtonOfManageUsersPage();
		String usernameValue = ExcelUtility.getStringdata(0, 0, "ManageUsersSearchUser");
		manageusers.enterValueOnUsernameFieldToSearchAUser(usernameValue).selectUserTypeToSearchAUser().clickOnSearchUserButton().scrollManageUsersPage().clickOnResetButton();
		boolean isSearchUsersHeaderDisplayed = manageusers.isSearchUsersHeaderDisplayed();
		Assert.assertFalse(isSearchUsersHeaderDisplayed, "User was not able to reset search users page");
	}
}
