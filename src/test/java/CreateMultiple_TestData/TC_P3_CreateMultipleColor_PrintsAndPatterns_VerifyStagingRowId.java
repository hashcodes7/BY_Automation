package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BusinessObjectPage;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;
import junit.framework.Assert;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleColor_PrintsAndPatterns_VerifyStagingRowId extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	BusinessObjectPage businessObjectPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;
	CreateNewColorPage CNCP;
	
	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Admin_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			businessObjectPage = new BusinessObjectPage(driver);
			CNCP = new CreateNewColorPage(driver);
			setReport("CreateMultipleColor_PrintsAndPatterns_VerifyStagingRowId");
		}
	}

	@Test(priority = 0, dataProvider = "CreateMultipleColor_PrintsAndPatterns", dataProviderClass = DataProviders.class)
		
		public void Createcolor_PrintsAndPatterns(String[][] testData) throws Exception {
			 
			for (int i = 0; i < testData.length; i++) {
				String[] data = testData[i];
//				String TestType = data[0];
				String redvalue = data[1];
				String bluevalue = data[2];
				String greenvalue = data[3];
				String artworkname = data[4];
				String colorfamily = data[5];
				String artworkcode = data[6];
				String patterntype = data[7];
				String colorcombo = data[8];
				String developer = data[9];
				String colortype = data[10];
				String businessObjectType=data[11];
				String actionType = data[12];
				String createdDate = data[13];
				String messageTableValue=data[14];
				String hierarchyValue=data[15];
				
		if (CloseBrowser) {
			test = extent.createTest(":::CreateMultipleColor_PrintsAndPatterns_VerifyStagingRowId:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);


			System.out.println("login to flex PLM application successfully with URl : " + Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully with URL : " + Admin_URL_STG);
			addScreenShot("login to flex PLM application successfully", test, Capture);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addScreenShot("opened left panel", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addScreenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(5000);

			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color Sign");
			addScreenShot("Clicked on Add color Sign", test, Capture);
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addScreenShot("Clicked On: " +colortype+" and color page opened", test, Capture);
			
			String title= driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.PASS, "create colour page opened");
			
			Thread.sleep(5000);
			
			CNCP.createcolorPrintsandPatterns(redvalue,bluevalue,greenvalue,artworkname,artworkcode,colorfamily,patterntype,colorcombo,developer,test);
			test.log(Status.INFO, "All the required fields are filled");
			addScreenShot("All the required fields are filled", test, Capture);
			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "Colour created under Prints and patterns");
			
			Thread.sleep(3000);
			CNCP.PrintsandPatterns_color_validation(artworkname,test);
			test.log(Status.PASS, "Validation is successful");
			addScreenShot("Validation is successful", test, Capture);
			

			mainMenuPage.LibraryMenu( MainMenuEnum.LIBRARIES_BUSSINESS.menu());
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Business Object");
			test.log(Status.INFO, "Clicked on Business Object");
			addScreenShot("Clicked on Business Object", test, Capture);
			WaitforPage(4000);


//			String businessObjectType =  "LSCOTransactionTable";
			businessObjectPage.chooseBusinessObjectType(businessObjectType);
		    System.out.println("Business object type chosen: "+businessObjectType);
		    test.log(Status.INFO, "Business object type chosen: "+businessObjectType);
		    addScreenShot("Business object type chosen", test, Capture);
		    WaitforPage(4000);

//			String actionType =  "Create";
			businessObjectPage.chooseActionType(actionType);
		    System.out.println("Action type chosen: "+actionType);
		    test.log(Status.INFO, "Action type chosen: "+actionType);
		    addScreenShot("Action type chosen", test, Capture);
		    WaitforPage(4000);
		    
//			String createdDate =  "10/09/2024";
		    businessObjectPage.enterCreatedDate(createdDate);
		    System.out.println("Entered Created Date: " + createdDate);
		    test.log(Status.INFO, "Entered Created Date: " + createdDate);
		    addScreenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    
//		    String messageTableValue =  "*LSCOMaterial*";
		    businessObjectPage.enterMessageTable(messageTableValue);
		    System.out.println("Entered Message Table: " + messageTableValue);
		    test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
		    addScreenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    
//		    String hierarchyValue =  "*LSCO\\Fabric\\Knits*";
		    businessObjectPage.enterHierarchy(hierarchyValue);
		    System.out.println("Entered Hierarchy: " + hierarchyValue);
		    test.log(Status.INFO, "Entered Hierarchy: " + hierarchyValue);
		    addScreenShot("Entered Hierarchy", test, Capture);
		    WaitforPage(4000);
		    
		    businessObjectPage.clickSearch();
		    System.out.println("Clicked on Search");
		    test.log(Status.INFO, "Clicked on Search");
		    addScreenShot("Clicked on Search", test, Capture);
		    WaitforPage(4000);
		    
		 // Verify the staging row ID
		    businessObjectPage.verifyStagingRowId(test);
		    System.out.println("Validation successful for Staging row Id for Create color");
		    test.log(Status.INFO, "Validation successful for Staging row Id for Create color");
		    addScreenShot("Validation successful for Staging row Id for Create color", test, Capture);
		    
		    if (i == testData.length - 1) {
				// Last iteration, perform logout

				dashboardPage.Logout();
				System.out.println("Logout successful");
				test.log(Status.INFO, "Logout successful");
				addScreenShot("Logout successful", test, Capture);
			} else {
//				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//			    driver.switchTo().window(tabs.get(0));
//			    driver.switchTo().window(tabs.get(1));
//			    driver.close(); // Close the second tab
//			    driver.switchTo().window(tabs.get(0));
//				// Not the last iteration, refresh the browser
				driver.manage().deleteAllCookies();
				driver.navigate().refresh();		
			}
			
		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;
		}
			}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}