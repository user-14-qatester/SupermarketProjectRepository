package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithVisibleText(WebElement element, String value) {
		Select selectObj = new Select(element);

		selectObj.selectByVisibleText(value);
	}

	public void selectDropdownWithIndex(WebElement element, int value) {
		Select selectObj = new Select(element);
		selectObj.selectByIndex(value);

	}

	public void verifyMouseHover(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void verifyRightClick(WebElement element) {

		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void handlingCheckbox(WebElement element) {
		element.click();

	}

	public void handlingRadiobutton(WebElement element) {

		element.click();

	}

}
