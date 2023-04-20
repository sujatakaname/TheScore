package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import coreFlow.IPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Helper;

public class AlertOptionPage implements IPage {

	AppiumDriver driver;
	
	By doneButton = By.xpath("//*[@text='Done']");

	public boolean validateScreen(String leagueName, String teamName){
		try {
			Helper.waitUntilVisible(driver, doneButton, 5);
			Helper.clickOn(driver, doneButton); //Clicked on Done btn
			System.out.println("User clicked on done button");
			
			driver.navigate().back(); //close the dashboard popup
			System.out.println("User closed the dashboard popup");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public AlertOptionPage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	}
}
