package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	ManageNewsPage managenews;
	HomePage homepage;
	@Test(description = "Verify whether user is able to navigate to Manage News page and add a news", priority = 1)
	public void verifyWhetherUserIsAbleToNavigateToManageNewsPageAndAddANews() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		homepage=login.enterUsername(usernamevalue).enterPassword(passwordvalue).clickOnSignInButton();
		 
		managenews=homepage.clickOnManageNewsNavigationLink();
		managenews.clickOnNewButtonOfManageNewsPage();
		String newsText = ExcelUtility.getStringdata(0, 0, "News");
		managenews.addNews(newsText);
		managenews.clickOnSaveButton();
		boolean isSuccessAlertDisplayed = managenews.isSuccessAlertDisplayed();
		Assert.assertTrue(isSuccessAlertDisplayed, "User is not able to add a news from the Manage news page");
	}

	@Test(description = "Verify whether user is able to navigate to Manage News page and search a news", priority = 2)
	public void verifyWhetherUserIsAbleToNavigateToManageNewsPageAndSearchANews() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		homepage=login.enterUsername(usernamevalue).enterPassword(passwordvalue).clickOnSignInButton();
		managenews=homepage.clickOnManageNewsNavigationLink();
		managenews.clickOnSearchButtonManageNews();
		String newsSearchText = ExcelUtility.getStringdata(0, 0, "SearchNews");
		managenews.enterNewsToSearch(newsSearchText);
		managenews.clickOnSearchButtonSearchNews();
		boolean isManageNewsHeaderDisplayed = managenews.isSearchResultsDisplayed();
		Assert.assertTrue(isManageNewsHeaderDisplayed, "User is not displayed with the search results");

	}

}
