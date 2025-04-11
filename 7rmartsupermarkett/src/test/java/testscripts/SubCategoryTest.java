package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {

	HomePage homepage;
	SubCategoryPage subcategory;
	
	@Test(description = "Verify whether user is able to add a new category on the subcategory page", priority = 1)
	public void verifyWhetherUserIsAbleToAddANewCategoryOnTheSubCategoryPage() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		subcategory=homepage.clickOnSubcategoryHomeButton();
		subcategory.clickOnNewButton().selectCategoryDropDown();
		String subcategoryValue = ExcelUtility.getStringdata(3, 0, "VegetablesSubcategories");
		subcategory.enterValueOnSubCategoryField(subcategoryValue).chooseFileUsingRobotClass().clickSaveButton();
		boolean isCloseButtonOfAlertDisplayed = subcategory.isAlertDisplayedOnAddingANewSubcategory();
		Assert.assertTrue(isCloseButtonOfAlertDisplayed, Messages.ADDANEWSUBCATEGORYERROR);
	}

	@Test(description = "Verify whether user is able to perform search on the subcategory page", priority = 2,retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToPerformSearchOnTheSubCategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringdata(0, 0, "LoginPageData");
		String passwordvalue = ExcelUtility.getStringdata(0, 1, "LoginPageData");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=login.clickOnSignInButton();
		subcategory=homepage.clickOnSubcategoryHomeButton();
		subcategory.clickOnSearchButton().selectCategoryDropDownSearchPage();
		String subcategoryValueOfSearchPage = ExcelUtility.getStringdata(1, 0, "VegetablesSubcategories");
		subcategory.enterValueOnSubCategoryFieldOfSearchPage(subcategoryValueOfSearchPage).clickOnSearchButtonOfSubCategorySearchPage();
		boolean isListSubcategoriesHeaderDisplayed = subcategory.isListSubcategoriesHeaderDisplayedOnSearchingASubcategory();
		Assert.assertTrue(isListSubcategoriesHeaderDisplayed,Messages.SEARCHFORASUBCATEGORYERROR);
	}

}
