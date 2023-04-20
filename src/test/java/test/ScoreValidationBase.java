package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import coreFlow.FLOW_NAMES;
import coreFlow.IPage;
import coreFlow.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScoreValidationBase {
	static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public static void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "OnePlus 6T");
	        capabilities.setCapability("platformVersion", "11");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("udid", "26ea3ff5");
	        capabilities.setCapability("appPackage", "com.fivemobile.thescore");
	        capabilities.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
	        capabilities.setCapability("automationName", "UiAutomator2");
	        capabilities.setCapability("autoGrantPermissions",true); //Capabilities
	     	        
	        driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities); //opens the Score app
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Test method
	*/	
	@Test(dataProvider= "testdata")
	public void test(String leagueName, String teamName) {
		FLOW_NAMES flowName = FLOW_NAMES.LEAGUE_FLOW;
		List<IPage> pages = new PageFactory().getPages(driver,flowName);
		 
		 if (pages != null) {
             Iterator<IPage> pageIterator = pages.iterator();
             while (pageIterator.hasNext()){
                 IPage page = pageIterator.next();
                 if(!page.validateScreen(leagueName, teamName))
                     break;
             }
         }
	}

	@DataProvider(name = "testdata")
	public Object[][] excelDP() throws IOException{
    	Object[][] arrObj = getExcelData("ScoreData.xlsx","Sheet1");
    	return arrObj;
	}
	
	public String[][] getExcelData(String fileName, String sheetName){
    	
    	String[][] data = null;
	  	try
	  	{
	   	FileInputStream fis = new FileInputStream(fileName);
	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
	   	XSSFSheet sh = wb.getSheet(sheetName);
	   	XSSFRow row = sh.getRow(0);
	   	int noOfRows = sh.getPhysicalNumberOfRows();
	   	int noOfCols = row.getLastCellNum();
	   	Cell cell;
	   	data = new String[noOfRows-1][noOfCols];
	   	
	   	for(int i =1; i<noOfRows;i++){
			for (int j = 0; j < noOfCols; j++) {
				row = sh.getRow(i);
				cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
	   	}
	  	}
	  	catch (Exception e) {
	     	   System.out.println("The exception is: " +e.getMessage());
       	}
    	return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
