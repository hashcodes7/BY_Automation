package TestData_Testcases;

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
public class TC01_P3_Staging_CreateColor_VerifyStagingId extends WMS_TestBase {

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
			setReport("TC01_P3_Staging_CreateColor_VerifyStagingId");
		}
	}

	@Test(priority = 0, dataProvider = "TC01_P3_Staging_CreateColor_VerifyStagingId", dataProviderClass = DataProviders.class)
	public void P3_TC01_StagingIntegration_CreateColor_VerifyStagingId(String TestType,String redvalue, String bluevalue, String greenvalue, String artworkname, 
			String colorfamily,String artworkcode, String patterntype, String colorcombo, String developer,String colortype,String businessObjectType,
			String actionType,String createdDate,String messageTableValue,String hierarchyValue)
			throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P3_Staging_CreateColor_VerifyStagingId:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material module from 83 to 84");

			System.out.println("login to flex PLM application successfully with URl : " + Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully with URL : " + Admin_URL_STG);
			addSrceenShot("login to flex PLM application successfully", test, Capture);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addSrceenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(5000);

			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color Sign");
			addSrceenShot("Clicked on Add color Sign", test, Capture);
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addSrceenShot("Clicked On: " +colortype+" and color page opened", test, Capture);
			
			String title= driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.PASS, "create colour page opened");
			
			Thread.sleep(5000);
			
			CNCP.createcolorPrintsandPatterns(redvalue,bluevalue,greenvalue,artworkname,artworkcode,colorfamily,patterntype,colorcombo,developer,test);
			test.log(Status.INFO, "All the required fields are filled");
			addSrceenShot("All the required fields are filled", test, Capture);
			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "Colour created under Prints and patterns");
			
			Thread.sleep(3000);
			CNCP.PrintsandPatterns_color_validation(artworkname,test);
			test.log(Status.PASS, "Validation is successful");
			addSrceenShot("Validation is successful", test, Capture);
			

			mainMenuPage.LibraryMenu( MainMenuEnum.LIBRARIES_BUSSINESS.menu());
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Business Object");
			test.log(Status.INFO, "Clicked on Business Object");
			addSrceenShot("Clicked on Business Object", test, Capture);
			WaitforPage(4000);


//			String businessObjectType =  "LSCOTransactionTable";
			businessObjectPage.chooseBusinessObjectType(businessObjectType);
		    System.out.println("Business object type chosen: "+businessObjectType);
		    test.log(Status.INFO, "Business object type chosen: "+businessObjectType);
		    addSrceenShot("Business object type chosen", test, Capture);
		    WaitforPage(4000);

//			String actionType =  "Create";
			businessObjectPage.chooseActionType(actionType);
		    System.out.println("Action type chosen: "+actionType);
		    test.log(Status.INFO, "Action type chosen: "+actionType);
		    addSrceenShot("Action type chosen", test, Capture);
		    WaitforPage(4000);
		    
//			String createdDate =  "10/09/2024";
		    businessObjectPage.enterCreatedDate(createdDate);
		    System.out.println("Entered Created Date: " + createdDate);
		    test.log(Status.INFO, "Entered Created Date: " + createdDate);
		    addSrceenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    
//		    String messageTableValue =  "*LSCOMaterial*";
		    businessObjectPage.enterMessageTable(messageTableValue);
		    System.out.println("Entered Message Table: " + messageTableValue);
		    test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
		    addSrceenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    
//		    String hierarchyValue =  "*LSCO\\Fabric\\Knits*";
		    businessObjectPage.enterHierarchy(hierarchyValue);
		    System.out.println("Entered Hierarchy: " + hierarchyValue);
		    test.log(Status.INFO, "Entered Hierarchy: " + hierarchyValue);
		    addSrceenShot("Entered Hierarchy", test, Capture);
		    WaitforPage(4000);
		    
		    businessObjectPage.clickSearch();
		    System.out.println("Clicked on Search");
		    test.log(Status.INFO, "Clicked on Search");
		    addSrceenShot("Clicked on Search", test, Capture);
		    WaitforPage(4000);
		    
		 // Verify the staging row ID
		    businessObjectPage.verifyStagingRowId(test);
		    System.out.println("Validation successful for Staging row Id for Create color");
		    test.log(Status.INFO, "Validation successful for Staging row Id for Create color");
		    addSrceenShot("Validation successful for Staging row Id for Create color", test, Capture);
		    
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
			

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Test case failed due to exception: " + e.getMessage());
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}