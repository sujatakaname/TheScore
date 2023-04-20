package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import coreFlow.IPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Helper;

public class LeaguePage implements IPage{

	AppiumDriver driver;
	
	By leagueButton = By.xpath("//*[@text='Leagues']");
	By editButton = By.xpath("//*[@text='Edit']");
	By actualLeagueStr = By.xpath("//*[@text='My Leagues']/../following-sibling::android.view.ViewGroup//android.widget.TextView");
	By nhlOption = By.xpath("//*[@text='NHL']");

	public boolean validateScreen(String leagueName, String teamName){
		try {
			Helper.waitUntilVisible(driver, leagueButton, 5);
			Helper.clickOn(driver, leagueButton); //Clicked on league btn from bottom navigation bar
			System.out.println("User clicked on league btn from bottom navigation bar");
			Helper.clickOn(driver, editButton); //Clicked on edit Button to verify
			
			Helper.waitUntilVisible(driver, actualLeagueStr, 5);
			String actualLeague = driver.findElement(actualLeagueStr).getText();
			String reqLeague = leagueName;
			Helper.printSelections("League Name", reqLeague, actualLeague);
			assertTrue(reqLeague.contains(actualLeague)); //Verify Selected league
			System.out.println("Verified user is on correct tab and corresponds to the league");
			
			Helper.waitUntilVisible(driver, nhlOption, 5);
			Helper.clickOn(driver, nhlOption); //Clicked on league from the list
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public LeaguePage(AppiumDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	}
}
