package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import coreFlow.IPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Helper;

public class WelcomePage implements IPage{
	
	AppiumDriver driver;
    
    By getStartedBtn = By.xpath("//*[@text='Get Started']");
	
	public boolean validateScreen(String leagueName, String teamName){
		try {
			Helper.waitUntilVisible(driver, getStartedBtn, 5);
			Helper.clickOn(driver, getStartedBtn);
			System.out.println("User clicked on get started button");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public WelcomePage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	}
}
