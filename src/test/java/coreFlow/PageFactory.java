package coreFlow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.AlertOptionPage;
import pages.ChooseLeaguesPage;
import pages.ChooseTeamPage;
import pages.LeaguePage;
import pages.SelectedLeaguePage;
import pages.WelcomePage;

public class PageFactory {
	
	 public List<IPage> getPages(AppiumDriver<MobileElement> driver, FLOW_NAMES flow) {
		 List<String> pageIds = new FlowMapper().getPageIds(flow);
		 
		 initialize(driver);
		 List<IPage> pages = new ArrayList<>();
		 pageIds.forEach(s ->  {
	            pages.add(nameToPageMap.get(s));
	        });
		 
		return Collections.unmodifiableList(pages);
	 }
	
	 private void initialize(AppiumDriver<MobileElement> driver) {
		 nameToPageMap.put("welcome", new WelcomePage(driver));
		 nameToPageMap.put("chooseLeagues", new ChooseLeaguesPage(driver));
		 nameToPageMap.put("chooseTeam", new ChooseTeamPage(driver));
		 nameToPageMap.put("alertOption", new AlertOptionPage(driver));
		 nameToPageMap.put("league", new LeaguePage(driver));
		 nameToPageMap.put("selectedLeague", new SelectedLeaguePage(driver));
	 }
	
	Map<String, IPage> nameToPageMap = new HashMap();
	
}
