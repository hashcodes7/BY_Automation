package E2E_Testcases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC308_P0_E2E_MaterialCreation_SundriesPackaging extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC308_P0_E2E_Sundries_Packaging_subtype_MaterialCreation_verification");
		}
	}

	@Test(priority = 0, dataProvider = "materialCreationSundriesData", dataProviderClass = DataProviders.class)
	public void P0_TC07_E2E_MaterialCreation_SundriesPackaging(String TestType, String sundryType,
			String sundryTypeValue, String sundrySubTypeValue, String seasonFirstIntroduced, String genderType,
			String sundryDescription, String productCategoryType, String brandType, String sizeLength, String sizeWidth,
			String sizeUOM, String uom, Map<String, String> Contents) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC308_P0_E2E_Sundries_Packaging_subtype_MaterialCreation_verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);
			
			test.log(Status.INFO, "This test case covers E2E module 308");


			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
			addScreenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addScreenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);

			// Navigate to the Material Library page
			materialPage.selectMaterial(MainMenuEnum.LIBRARIES_MATERIAL.menu());
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addScreenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			// Create a new material
			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addScreenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

			// Select Sundry Type
//			String sundryType = "Packaging";
			materialPage.chooseSundryType(sundryType);
			System.out.println("Sundry type was chosen: " + sundryType);
			test.log(Status.INFO, "Sundry type was chosen: " + sundryType);
			addScreenShot("Sundry type was chosen", test, Capture);
			WaitforPage(4000);

			// Enter values into mandatory fields
//			String sundryTypeValue = "Booklet";
			materialPage.chooseSundryTypeValue(sundryTypeValue);
			System.out.println("Sundry Type Was Choosen: " + sundryTypeValue);
			test.log(Status.INFO, "Sundry Type Was Choosen: " + sundryTypeValue);
			addScreenShot("Sundry Type Was Choosen", test, Capture);
			WaitforPage(4000);

//			String sundrySubTypeValue = "Not Applicable";
			materialPage.chooseSundrySubTypeValue(sundrySubTypeValue);
			System.out.println("Sundry Sub Type Was Choosen: " + sundrySubTypeValue);
			test.log(Status.INFO, "Sundry Sub Type Was Choosen: " + sundrySubTypeValue);
			addScreenShot("Sundry Sub Type Was Choosen", test, Capture);
			WaitforPage(4000);

//			String seasonFirstIntroduced = "2026 Fall";
			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addScreenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

//			String genderType = "Female";
			materialPage.chooseGender(genderType);
			System.out.println("Gender Was Choosen: " + genderType);
			test.log(Status.INFO, "Gender Was Choosen: " + genderType);
			addScreenShot("Gender Was Choosen: ", test, Capture);
			WaitforPage(4000);

//			String sundryDescription = "Sundry_demo_01_aug06th";
			materialPage.enterSundryDescription(sundryDescription);
			System.out.println("Entered Sundry Description: " + sundryDescription);
			test.log(Status.INFO, "Entered Sundry Description: " + sundryDescription);
			addScreenShot("Entered Sundry Description", test, Capture);
			WaitforPage(4000);

//			String productCategoryType = "Accessories";
			materialPage.chooseProductCategory(productCategoryType);
			System.out.println("Product Category Was Choosen: " + productCategoryType);
			test.log(Status.INFO, "Product Category Was Choosen: " + productCategoryType);
			addScreenShot("Product Category Was Choosen: ", test, Capture);
			WaitforPage(4000);

//			String brandType = "Denizen";
			materialPage.chooseBrand(brandType);
			System.out.println("Brand Was choosen" + brandType);
			test.log(Status.INFO, "Brand Was choosen: " + brandType);
			addScreenShot("Brand Was choosen", test, Capture);
			WaitforPage(4000);

//			String sizeLength = "22";
			materialPage.enterSizeLength(sizeLength);
			System.out.println("Entered Size Length: " + sizeLength);
			test.log(Status.INFO, "Entered Size Length: " + sizeLength);
			addScreenShot("Entered Size Length", test, Capture);
			WaitforPage(4000);

//			String sizeWidth = "32";
			materialPage.enterSizeWidth(sizeWidth);
			System.out.println("Entered Size Width: " + sizeWidth);
			test.log(Status.INFO, "Entered Size Width: " + sizeWidth);
			addScreenShot("Entered Size Width", test, Capture);
			WaitforPage(4000);

//			String sizeUOM = "centimeter";
			materialPage.enterSizeUOM(sizeUOM);
			System.out.println("Entered Size UOM: " + sizeUOM);
			test.log(Status.INFO, "Entered Size UOM: " + sizeUOM);
			addScreenShot("Entered Size UOM", test, Capture);
			WaitforPage(4000);

//			String uom = "dozen";
			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addScreenShot("Entered UOM", test, Capture);
			WaitforPage(4000);

//			Map<String, String> Contents = new HashMap<>();
//			Contents.put("Cotton", "30.00");
//			Contents.put("Corozo", "50.00");
//			Contents.put("Bullion", "10.00");
//			Contents.put("Bone", "5.00");
//			Contents.put("Poly Wrapped Poly", "5.00");
			materialPage.setContents(Contents, test);
			test.log(Status.INFO, "Contents: " + Contents.toString());
			addScreenShot("Contents", test, Capture);

			// Save the new material
			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addScreenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify that the new sundry record is created
			boolean isRecordCreated = materialPage.isSundryRecordCreated(sundryDescription, test);
			if (isRecordCreated) {
				System.out.println("New Sundries/Packaging  subtype material is created successfully.");
				test.log(Status.PASS,
						"New Sundries/Packaging  subtype material is created successfully: " + sundryDescription);
				addScreenShot("New Sundries/Packaging  subtype material is created successfully", test, Capture);
			} else {
				System.out.println("Failed to create new Sundries/Packaging  subtype material.");
				test.log(Status.FAIL, "Failed to create new Sundries/Packaging  subtype material.");
				addScreenShot("Failed to create new Sundries/Packaging  subtype material", test, Capture);
			}
			WaitforPage(4000);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

		} catch (

		Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}