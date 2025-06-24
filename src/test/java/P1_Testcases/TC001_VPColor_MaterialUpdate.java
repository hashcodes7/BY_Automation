package P1_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorLookPage;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;

import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC001_VPColor_MaterialUpdate extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	CreateNewColorPage newColorPage;
	ColorLookPage colorPage;
	VendorPortalPage vendorPortalPage;
	
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;
	
	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			newColorPage = new CreateNewColorPage(driver);
			colorPage = new ColorLookPage(driver);
			vendorPortalPage = new VendorPortalPage(driver);
			setReport("TC_001_Validate VP Color and Material update");
		}
	}

	@Test( priority = 0, dataProvider = "Create_Colors_Sundry_PrintPatterns", dataProviderClass = DataProviders.class)

	public void P0_TC_05_VPColorMaterialUpdate(String TestType,String name,String redvalue, String bluevalue, String greenvalue, String colorname, String colorfamily,
			String artworkname, String artworkcode,String patterntype,String colorcombo,String developer,String colortype,String material,
			String printColor,String sundryColor,String descriptionValue,String UOM) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC_001_Validate VP Color and Material update:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers from TC_296 to 303");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + URL);
			Thread.sleep(5000);
			
//Create print and pattern Color - By supplier
			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Color menu ");
			addSrceenShot("Clicked on Color menu ", test, Capture);
			Thread.sleep(4000);
			
			newColorPage.clickplussign();
			test.log(Status.INFO, "Clicked on add color");
			addSrceenShot("Clicked on add color", test, Capture);
			
			//create print and pattern color and upload the thumbnail
			colorPage.selectPrintPatternsColor(test);
			test.log(Status.INFO, "print and patterns color is selected ");
			addSrceenShot("Selected print and patterns color ", test, Capture); 
			
			colorPage.uploadThumbnail(test);
			test.log(Status.INFO, "Thumbnail is uploaded ");
			addSrceenShot("Uploaded Thumbnail ", test, Capture); 
			
			newColorPage.createcolorPrintsandPatterns(redvalue,bluevalue,greenvalue,artworkname,artworkcode,colorfamily,patterntype,colorcombo,developer,test);
			test.log(Status.INFO, "All the required fields are filled");
			addSrceenShot("All the required fields are filled", test, Capture); 
			
			newColorPage.clickcreatebutton();
			test.log(Status.PASS, "Colour created under Prints and patterns");
			addSrceenShot("Colour created under Prints and patterns", test, Capture);
			
			colorPage.validateVendorCreatedFlag(test);
			test.log(Status.INFO, "Vendor Created Flag ");
			addSrceenShot("Vendor Created Flag", test, Capture); 
			
//Update print and pattern Color - By supplier	
			
			colorPage.updatepickPatternsColor(test);
			test.log(Status.INFO, "pick and patterns color is updated ");
			addSrceenShot("pick and patterns color is updated", test, Capture); 
			
			
			
//Create Sundry Color - By supplier					
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Color menu ");
			addSrceenShot("Clicked on Color menu ", test, Capture);
			Thread.sleep(4000);
			
			newColorPage.clickplussign();
			test.log(Status.INFO, "Clicked on add color");
			addSrceenShot("Clicked on add color", test, Capture); 

			colorPage.selectSundryColor(test);
			test.log(Status.INFO, "Sundry color is selected ");
			addSrceenShot("Selected Sundry color ", test, Capture);
			
			colorPage.uploadThumbnail(test);
			test.log(Status.INFO, "Thumbnail is uploaded ");
			addSrceenShot("Uploaded Thumbnail ", test, Capture); 
			
			newColorPage.createcolorSundry(name,redvalue,bluevalue,greenvalue,colorname,colorfamily,test);
			test.log(Status.INFO, "All the required fields are filled");
			addSrceenShot("All the required fields are filled", test, Capture);
			
			newColorPage.clickcreatebutton();
			test.log(Status.PASS, "Colour created under Prints and patterns");
			addSrceenShot("Colour created under Prints and patterns", test, Capture);

			colorPage.validateVendorCreatedFlag(test);
			test.log(Status.INFO, "Vendor Created Flag ");
			addSrceenShot("Vendor Created Flag", test, Capture); 
			
//Update Sundry Color - By supplier	
	
			colorPage.updateSundryColor(test);
			test.log(Status.INFO, "Sundry color is updated ");
			addSrceenShot("Sundry color is updated", test, Capture); 
//Upload Thumbnail to material			
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES_MATERIAL.menu());
			test.log(Status.INFO, "Clicked on Material menu ");
			Thread.sleep(4000);
			addSrceenShot("Clicked on Material menu ", test, Capture);
			
			vendorPortalPage.P1materialPage(test,material);
			test.log(Status.INFO, "Material page is loaded"); 
			
			vendorPortalPage.uploadThumbnailMaterial(test);
			test.log(Status.INFO, "vendor user won't have access for upload thumbnail to material");
			Thread.sleep(4000);
			addSrceenShot("vendor user won't have access for upload thumbnail to material", test, Capture);		
//Upload Images for materials	
			vendorPortalPage.uploadImageMaterial(test);
			test.log(Status.INFO, "vendor user won't have permission for upload image to material");
			Thread.sleep(4000);
			addSrceenShot("vendor user won't have permission for upload image to material", test, Capture); 
		
//Add documents at material supplier information
			vendorPortalPage.clickOnSite(test);
			System.out.println("Clicked on site"); 

			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES_MATERIAL.menu());
			test.log(Status.INFO, "Clicked on Material menu ");
			addSrceenShot("Clicked on Material menu ", test, Capture);
			Thread.sleep(4000);
			
			vendorPortalPage.P1materialPage(test,material);
			test.log(Status.INFO, "Material page is loaded");
			
			vendorPortalPage.addDocuments(test, descriptionValue);
			test.log(Status.PASS, "Document is added ");
			addSrceenShot("Document is added", test, Capture); 
			
//open material supplier information
			vendorPortalPage.clickOnSite(test);
			System.out.println("Clicked on site"); 
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES_MATERIAL.menu());
			test.log(Status.INFO, "Clicked on Material menu ");
			addSrceenShot("Clicked on Material menu ", test, Capture);
			Thread.sleep(4000);
			
			vendorPortalPage.P1materialPage(test,material);
			test.log(Status.INFO, "Material page is loaded");
			
//Update material supplier information			
			vendorPortalPage.materialUpdate(test,UOM);
			test.log(Status.PASS, "Material details are updated ");
			addSrceenShot("Material details are updated", test, Capture); 
			
			vendorPortalPage.fabricMaterialUpdate(test);
			test.log(Status.PASS, "fabric material details are not editable ");
			addSrceenShot("fabric material details are not editable", test, Capture); 
					
		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;
		}

	}
	
	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}