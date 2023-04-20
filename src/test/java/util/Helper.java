package util;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	public static void clickOn(WebDriver driver, By getStartedBtn) {
		WebElement clickElement = driver.findElement(getStartedBtn);
		clickElement.click();
	} // click On method
	
	public static void waitUntilVisible(WebDriver driver, By getStartedBtn, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(getStartedBtn));
	} // Wait till element is visible method
	
	public static void printSelections(String elementName, String required, String actual){
		System.out.println(String.format(" %s | REQ: %s | ACT: %s", elementName, required, actual));
	}
}
