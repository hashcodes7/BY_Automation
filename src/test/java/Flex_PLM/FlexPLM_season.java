package Flex_PLM;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups = { "Single_Orders" })
public class FlexPLM_season extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	int CartSlot = 6;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			setReport("Season : Create, update and delete from Library");

		}
	}

	@Test(priority = 0, dataProvider = "SinglesBagOrder_Cartoon", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String CompleteSpecs4, String CompleteSpecs5, String CompleteSpecs6,
			String CompleteSpecs7, String TotUserKey, String LocationKey, String CARTKEY, String CompleteSpecs8,
			String CompleteSpecs9, String PackStation) throws Exception {
try {
		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::Season : Create, update and delete from Library:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts
			
				long startTime = System.nanoTime();

				/*
				 * //String GetTime = utilities.Timer(); String GetTime;
				 * System.out.println("Browser Launched Time :" + GetTime);
				 * test.log(Status.PASS, "Browser Launched Time :" + GetTime);
				 */
				// ......................................................................................//

				System.out.println("Browser Launched successfully");
				test.log(Status.PASS, "Browser Launched successfully");

				System.out.println("login to flex PLM application successfully");
				test.log(Status.PASS, "login to flex PLM application successfully");
				
				Thread.sleep(5000);
				//dashboardPage.logoutDropdown();
			//	
				
				System.out.println("logout successful");
				test.log(Status.PASS, "logout successful");
				
				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.PASS, "Clicked on open Left plane");
				addSrceenShot("Clicked on open Left plane", test, Capture);
				
				mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu(),true);
				//seasonPage.selectLineSheet(MainMenuEnum.LIBRARIES_Season.menu());
				
				seasonPage.clikOnNewBtn();
				System.out.println("New season is successful");
				test.log(Status.PASS, "Clicked on New button to create season");
				addSrceenShot("New season is successful", test, Capture);
				//seasonPage.clikOnVerticalBtn();
				
				String seasonType = "Dockers";
				seasonPage.chooseSeasonType(seasonType);
				test.log(Status.PASS, "season type is choosen");
				System.out.println("season type is choosen");
				addSrceenShot("Season type is choosen", test, Capture);
				
				
				seasonPage.selectProductType(seasonType);
				test.log(Status.PASS, "season type is choosen");
				System.out.println("selected the product type");
				addSrceenShot("selected the product type", test, Capture);
				
			//	seasonPage.selectCategory1("Tops");
				seasonPage.selectCategory("Bottoms");
				test.log(Status.PASS, "select Category is choosen");
				addSrceenShot("selected the product type", test, Capture);
				
				seasonPage.selectGender("Female");
				test.log(Status.PASS, " Gender is choosen");
				addSrceenShot("selected the product type", test, Capture);
				
				  seasonPage.selectBrand("Dockers");
				  test.log(Status.PASS, "Brand is choosen");
					addSrceenShot("selected the product type", test, Capture);
					
				  seasonPage.selectYear("2022");
				  test.log(Status.PASS, "Year is choosen");
					addSrceenShot("selected the product type", test, Capture);
					
				  seasonPage.selectSeason("S4");
				  test.log(Status.PASS, "season  is choosen");
					addSrceenShot("selected the product type", test, Capture);
					
				  seasonPage.selectSeasonCode("2024 Spring");
				  test.log(Status.PASS, "season code is choosen");
					addSrceenShot("selected the product type", test, Capture);
					
				  seasonPage.clikOnCreateBtn();
				  test.log(Status.PASS, "season type is choosen");
					addSrceenShot("selected the product type", test, Capture);
				  //SeasonDetailsPage
				  seasonPage.verifySeasonCreation();
				  test.log(Status.PASS, "season creation is successful");
					addSrceenShot("selected the product type", test, Capture);
				  String verifyseason = "Update"; 
				  seasonPage.selectAction(verifyseason);
				  test.log(Status.PASS, "Clicked on update season  is successful");
					addSrceenShot("selected the product type", test, Capture);
				 
				  //System.out.println("test:"+value);
				  String year ="2024 Fall";
				  String updateYear = year.replace(".0", "");
				  seasonPage.selectSeasonCode(year);
				  test.log(Status.PASS, "updated the season code successfully");
					addSrceenShot("selected the product type", test, Capture);
					
				  seasonPage.clikOnSaveBtn();
				  test.log(Status.PASS, "Clicked on save button successfully");
					addSrceenShot("selected the product type", test, Capture);
					
				  System.out.println("season type is choosen");
				  seasonPage.verifySeasonUpdatedupdated();
				  test.log(Status.PASS, "season type is choosen");
					addSrceenShot("selected the product type", test, Capture);
					
				  String ActionDD = "Delete";
				  seasonPage.selectAction(ActionDD);
				  test.log(Status.PASS, "Selected on Delete button successfully");
					addSrceenShot("selected the product type", test, Capture);
						
				  //(testData.get("ActionDD").split(",")[1]);
				  seasonPage.clikOnDeleteBtn();
				  test.log(Status.PASS, "Clicked on Delete button successfully");
					addSrceenShot("selected the product type", test, Capture);
				
				  seasonPage.verifyDeleteMessage();
				  test.log(Status.PASS, "Delete message gives access denied error");
					addSrceenShot("selected the product type", test, Capture);
				  
				  System.out.println("season type is choosen");
				 
				  System.out.println("season type is choosen");
				
				
				dashboardPage.closeLeftPanel();
				System.out.println("Clicked on close Left plane");
				addSrceenShot("Clicked on close Left plane", test, Capture);
				
				dashboardPage.Logout();
				System.out.println("Logout successful");
				addSrceenShot("Clicked on Logout successful", test, Capture);
				
				//dashboardPage.openLeftPanel();
				
			//	MainMenuPage mainMenuPage = dashboardPage.openLeftPanel();
				//mainMenuPage.openSubMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu());
				
				
				

				
		}
}
catch (Exception e) {
	System.out.println("Test case failed due to application slowness"+ e);
	test.log(Status.FAIL, "Test case failed due to application slowness");
}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}