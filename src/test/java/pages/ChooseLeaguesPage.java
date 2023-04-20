package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import coreFlow.IPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Helper;

public class ChooseLeaguesPage implements IPage {

	AppiumDriver driver;
	
	By continueButton = By.xpath("//*[@text='Continue']");

	public boolean validateScreen(String leagueName, String teamName){
		try {
			WebElement leagueTeam = driver.findElement(By.xpath("//*[@text='" + leagueName + "']"));
			leagueTeam.click(); //Clicked on league team
			System.out.println("User cliked on the " + leagueName + " option from the list");
			
			Helper.waitUntilVisible(driver, continueButton, 5);
			Helper.clickOn(driver, continueButton); //Clicked on continue btn
			System.out.println("User cliked on the continue button");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public ChooseLeaguesPage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	}
}
