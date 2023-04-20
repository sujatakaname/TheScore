package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import coreFlow.IPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Helper;

public class ChooseTeamPage implements IPage {

	AppiumDriver driver;
	
	By continueButton = By.xpath("//*[@text='Continue']");

	public boolean validateScreen(String leagueName, String teamName){
		try {
			WebElement team = driver.findElement(By.xpath("//*[@text='" + teamName + "']"));
			team.click(); //Clicked on team
			System.out.println("User clicked on the desired team from the list");
			
			Helper.waitUntilVisible(driver, continueButton, 5);
			Helper.clickOn(driver, continueButton); //Clicked on continue btn
			System.out.println("User cliked on the continue button");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public ChooseTeamPage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	}
}
