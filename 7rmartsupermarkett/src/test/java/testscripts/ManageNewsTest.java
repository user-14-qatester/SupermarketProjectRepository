package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
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
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		managenews=homepage.clickOnManageNewsNavigationLink();
		managenews.clickOnNewButtonOfManageNewsPage();
		String newsText = ExcelUtility.getStringdata(0, 0, "News");
		managenews.addNews(newsText).clickOnSaveButton();
		boolean isSuccessAlertDisplayed = managenews.isSuccessAlertDisplayed();
		Assert.assertTrue(isSuccessAlertDisplayed, Messages.ADDANEWSERROR);
	}

	@Test(description = "Verify whether user is able to navigate to Manage News page and search a news", priority = 2,retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToNavigateToManageNewsPageAndSearchANews() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		managenews=homepage.clickOnManageNewsNavigationLink();
		managenews.clickOnSearchButtonManageNews();
		String newsSearchText = ExcelUtility.getStringdata(0, 0, "SearchNews");
		managenews.enterNewsToSearch(newsSearchText).clickOnSearchButtonSearchNews();
		boolean isManageNewsHeaderDisplayed = managenews.isSearchResultsDisplayed();
		Assert.assertTrue(isManageNewsHeaderDisplayed, Messages.SEARCHFORANEWSERROR);

	}

}
