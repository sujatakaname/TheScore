package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import coreFlow.IPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Helper;

public class SelectedLeaguePage implements IPage{

	AppiumDriver driver;

	By standingsButton = By.xpath("//*[@text='STANDINGS']");
	By leagueHeader = By.xpath("//*[@text='Leagues']");
	
	public boolean validateScreen(String leagueName, String teamName){
		try {
			Helper.waitUntilVisible(driver, standingsButton, 5);
			Helper.clickOn(driver, standingsButton); //Clicked on standings Button
			System.out.println("User clicked on Standings button");
			
			driver.navigate().back(); //navigated back screen
			
			boolean validateHeader = driver.findElements(leagueHeader).size() != 0;
			assertTrue(validateHeader); //validate page is navigated to the previous page
			System.out.println("User Successfully returns to the previous page");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public SelectedLeaguePage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	}
}
