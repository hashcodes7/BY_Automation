package P0_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
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
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC21_P0_Material_UpdateSundryMaterial extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

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
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC21_P0_Material_SundryMaterialUpdation verification");
		}
	}

	@Test(priority = 0, dataProvider = "updateSundryMaterialData", dataProviderClass = DataProviders.class)
	public void P0_TC_21_Material_Update_a_Material_for_type_Sundry_Button(String TestType, String sundryType, String materialName,
			String sundryTypeValue, String sundrySubTypeValue, String seasonFirstIntroduced, String genderType,
			String sundryDescription, String productCategoryType, String brandType, String size, String sizeUOM,
			String uom, String sizeLength, String sizeWidth, Map<String, String> Contents) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC21_P0_Material_SundryMaterialUpdation verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material module from 153 to 156");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
			addSrceenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			
			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

//			String sundryType = "Buttons";
			materialPage.selectMaterialType(sundryType, test);
			System.out.println("Sundries type Record type Was choosen: " + sundryType);
			test.log(Status.INFO, "Sundries type Record type Was choosen: " + sundryType);
			addSrceenShot("Sundries type Record type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "S231114 Button Demo_sundries_material_02";
			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addSrceenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);

			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: " + materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addSrceenShot("Ciicked On material: ", test, Capture);
			
			materialPage.clickOnEditMaterial();
			System.out.println("clicked On Edit Material");
			test.log(Status.INFO, "clicked On Edit Material");
			addSrceenShot("clicked On Edit Material", test, Capture);
			WaitforPage(4000);

			// Enter values into mandatory fields
			materialPage.chooseSundryTypeValue(sundryTypeValue);
			System.out.println("Updated Sundry Type: " + sundryTypeValue);
			test.log(Status.INFO, "Updated Sundry Type: " + sundryTypeValue);
			addSrceenShot("Updated Sundry Type", test, Capture);
			WaitforPage(4000);

			materialPage.chooseSundrySubTypeValue(sundrySubTypeValue);
			System.out.println("Updated Sundry Sub Type: " + sundrySubTypeValue);
			test.log(Status.INFO, "Updated Sundry Sub Type: " + sundrySubTypeValue);
			addSrceenShot("Updated Sundry Sub Type", test, Capture);
			WaitforPage(4000);

			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Updated Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Updated Season First Introduced: " + seasonFirstIntroduced);
			addSrceenShot("Updated Season First Introduced", test, Capture);
			WaitforPage(4000);

			materialPage.chooseGender(genderType);
			System.out.println("Updated Gender: " + genderType);
			test.log(Status.INFO, "Updated Gender: " + genderType);
			addSrceenShot("Updated Gender: ", test, Capture);
			WaitforPage(4000);

			materialPage.enterSundryDescription(sundryDescription);
			System.out.println("Updated Sundry Description: " + sundryDescription);
			test.log(Status.INFO, "Updated Sundry Description: " + sundryDescription);
			addSrceenShot("Updated Sundry Description", test, Capture);
			WaitforPage(4000);

			materialPage.chooseProductCategory(productCategoryType);
			System.out.println("Updated Product Category: " + productCategoryType);
			test.log(Status.INFO, "Updated Product Category: " + productCategoryType);
			addSrceenShot("Updated Product Category: ", test, Capture);
			WaitforPage(4000);

			materialPage.chooseBrand(brandType);
			System.out.println("Updated Brand: " + brandType);
			test.log(Status.INFO, "Updated Brand: " + brandType);
			addSrceenShot("Updated Brand", test, Capture);
			WaitforPage(4000);

			materialPage.enterSize(size, sundryType, test);
			System.out.println("Updated Size: " + size);
			test.log(Status.INFO, "Updated Size: " + size);
			addSrceenShot("Entered Size", test, Capture);
			WaitforPage(4000);

			materialPage.enterSizeUOM(sizeUOM);
			System.out.println("Updated Size UOM: " + sizeUOM);
			test.log(Status.INFO, "Updated Size UOM: " + sizeUOM);
			addSrceenShot("Updated Size UOM", test, Capture);
			WaitforPage(4000);

			materialPage.enterUOM(uom);
			System.out.println("Updated UOM: " + uom);
			test.log(Status.INFO, "Updated UOM: " + uom);
			addSrceenShot("Updated UOM", test, Capture);
			WaitforPage(4000);
			
			materialPage.enterSize_Length(sizeLength, sundryType,  test);
			materialPage.enterSize_Width(sizeWidth, sundryType, test);
			WaitforPage(4000);

			materialPage.removeChosenContents();
			System.out.println("Chosen Contents removed ");
			test.log(Status.INFO, "Chosen Contents removed");
			addSrceenShot("Chosen Contents removed", test, Capture);
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

			// Verify that the material details are updated
			boolean isMaterialUpdated = materialPage.isMaterialUpdated(sundryDescription, test);
			if (isMaterialUpdated) {
				System.out.println("Material details updated successfully.");
				test.log(Status.PASS, "Material details updated successfully.");
				addSrceenShot("Material details updated successfully", test, Capture);
			} else {
				System.out.println("Failed to update material details.");
				test.log(Status.FAIL, "Failed to update material details.");
				addSrceenShot("Failed to update material details", test, Capture);
			}
			

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);

		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness: " + e);
			test.log(Status.FAIL, "Test case failed due to application slowness");
			addSrceenShot("Test case failed due to application slowness", test, Capture);
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
