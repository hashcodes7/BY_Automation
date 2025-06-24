package P0_TestCases;

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


import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC20_P0_Material_CreateSundryMaterial extends WMS_TestBase {

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
			setReport("TC20_P0_Material_SundryMaterialCreation verification");
		}
	}

	@Test(priority = 0, dataProvider = "sundryMaterialData", dataProviderClass = DataProviders.class)
	public void P0_TC_Material_Create_a_new_Material_for_type_Sundry_Button(String TestType, String sundryType,
			String sundryTypeValue, String sundrySubTypeValue, String seasonFirstIntroduced, String genderType,
			String sundryDescription, String productCategoryType, String brandType, String size, String sizeUOM,
			String uom, String sizeLength, String sizeWidth, Map<String, String> Contents) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC20_P0_Material_SundryMaterialCreation verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {
			test.log(Status.INFO, "This test case covers material module from 149 to 152");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			// Create a new material
			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addSrceenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

			// Select Sundry Type
			materialPage.chooseSundryType(sundryType);
			System.out.println("Sundry type was chosen: " + sundryType);
			test.log(Status.INFO, "Sundry type was chosen: " + sundryType);
			addSrceenShot("Sundry type was chosen", test, Capture);
			WaitforPage(4000);

			// Enter values into mandatory fields
			materialPage.chooseSundryTypeValue(sundryTypeValue);
			System.out.println("Sundry Type Was Choosen: " + sundryTypeValue);
			test.log(Status.INFO, "Sundry Type Was Choosen: " + sundryTypeValue);
			addSrceenShot("Sundry Type Was Choosen", test, Capture);
			WaitforPage(4000);

			materialPage.chooseSundrySubTypeValue(sundrySubTypeValue);
			System.out.println("Sundry Sub Type Was Choosen: " + sundrySubTypeValue);
			test.log(Status.INFO, "Sundry Sub Type Was Choosen: " + sundrySubTypeValue);
			addSrceenShot("Sundry Sub Type Was Choosen", test, Capture);
			WaitforPage(4000);

			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addSrceenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

			materialPage.chooseGender(genderType);
			System.out.println("Gender Was Choosen: " + genderType);
			test.log(Status.INFO, "Gender Was Choosen: " + genderType);
			addSrceenShot("Gender Was Choosen: ", test, Capture);
			WaitforPage(4000);

			materialPage.enterSundryDescription(sundryDescription);
			System.out.println("Entered Sundry Description: " + sundryDescription);
			test.log(Status.INFO, "Entered Sundry Description: " + sundryDescription);
			addSrceenShot("Entered Sundry Description", test, Capture);
			WaitforPage(4000);

			materialPage.chooseProductCategory(productCategoryType);
			System.out.println("Product Category Was Choosen: " + productCategoryType);
			test.log(Status.INFO, "Product Category Was Choosen: " + productCategoryType);
			addSrceenShot("Product Category Was Choosen: ", test, Capture);
			WaitforPage(4000);

			materialPage.chooseBrand(brandType);
			System.out.println("Brand Was choosen" + brandType);
			test.log(Status.INFO, "Brand Was choosen: " + brandType);
			addSrceenShot("Brand Was choosen", test, Capture);
			WaitforPage(4000);

			materialPage.enterSize(size, sundryType, test);
			System.out.println("Entered Size: " + size);
			WaitforPage(4000);

			materialPage.enterSizeUOM(sizeUOM);
			System.out.println("Entered Size UOM: " + sizeUOM);
			test.log(Status.INFO, "Entered Size UOM: " + sizeUOM);
			addSrceenShot("Entered Size UOM", test, Capture);
			WaitforPage(4000);

			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addSrceenShot("Entered UOM", test, Capture);
			WaitforPage(4000);
			
			materialPage.enterSize_Length(sizeLength, sundryType,  test);
			materialPage.enterSize_Width(sizeWidth, sundryType, test);
			WaitforPage(4000);

			materialPage.setContents(Contents, test);
			test.log(Status.INFO, "Contents: " + Contents.toString());
			addSrceenShot("Contents", test, Capture);

			// Save the new material
			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify that the new sundry record is created
			boolean isRecordCreated = materialPage.isSundryRecordCreated(sundryDescription, test);
			if (isRecordCreated) {
				System.out.println("New sundry record is created successfully.");
				test.log(Status.PASS, "New sundry record is created successfully.");
				addSrceenShot("New sundry record is created successfully", test, Capture);
			} else {
				System.out.println("Failed to create new sundry record.");
				test.log(Status.FAIL, "Failed to create new sundry record.");
				addSrceenShot("Failed to create new sundry record", test, Capture);
			}

			// Validate additional attributes
			boolean isMaterialCodeUpdated = materialPage.isMaterialCodeUpdated(test);
			if (isMaterialCodeUpdated) {
				System.out.println("Material code verification.");
				test.log(Status.PASS, "Material code verification.");
				addSrceenShot("Material code verification", test, Capture);
			} else {
				System.out.println("Material code verification failed.");
				test.log(Status.FAIL, "Material code verification failed.");
				addSrceenShot("Material code verification failed", test, Capture);
			}
			materialPage.verifySortedContents(test);

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);

			WaitforPage(4000);

		} catch (

		Exception e) {
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