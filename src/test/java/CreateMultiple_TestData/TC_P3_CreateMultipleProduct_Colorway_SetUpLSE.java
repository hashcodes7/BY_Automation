package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleProduct_Colorway_SetUpLSE extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Set_Up_Page SetUpPage;
	Techpack_pages Techpackpages;
	E2E_Pages E2EPages;
	ProductPage productPage;
	
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			SetUpPage = new Set_Up_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			E2EPages = new E2E_Pages(driver);
			productPage = new ProductPage(driver);

			setReport("TC_P3_CreateMultipleProduct_Colorway_SetUpLSE");
		}
	}

	@Test(priority = 0, dataProvider = "CreateMultipleProduct_Colorway_SetUpLSE", dataProviderClass = DataProviders.class)
		
		public void CreateMultipleProduct_Colorway(String[][] testData) throws Exception {

			for (int i = 0; i < testData.length; i++) {
				String[] data = testData[i];
//				String TestType = data[0];
				String season = data[1];
				String productName = data[2];
				String brandHierarchy = data[3];
				String proSubCat1 = data[4];
				String proSubCat2 = data[5];
				String classValue = data[6];
				String subClassValue = data[7];
				String consumer = data[8];
				String consumerGrp1 = data[9];
				String consumerGrp2 = data[10];
				String colormenu = data[11];
				String colorsubmenu = data[12];
				String filtercolor = data[13];
				String productsegLSUSvalue = data[14];
				String productsegLSEvalue = data[15];
				String classification = data[16];
				String producttype = data[17];
				String hubofferedto = data[18];
				String linesheetview = data[19];
				String consumergroup = data[20];
				String consumergroupext1 = data[21];
				String consumergroupext2 = data[22];
				String materialtype = data[23];
				String productmarketingname = data[24];
				String rigidindicator = data[25];
				String productlifecyclegroup = data[26];
				String lastseasonoffered = data[27];
				String productpricepositioning = data[28];
				String createddate = data[29];
				String filtermaterial = data[30];
				String merchfabrictype = data[31];
				String destroysampleInd = data[32];
				String collectionType = data[33];
				String capsule = data[34];
				String sizeGridCode = data[35];
				String currentPlannedLifecycle = data[36];
				String linesheetview_LSUS = data[37];
				String primaryfabric = data[38];
				

		
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC_P3_CreateMultipleProduct_Colorway_SetUpLSE:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL : " + Global_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addScreenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

			try {

				lineSheetPage.createProduct();
				test.log(Status.INFO, "Clicked on Create New product");
				addScreenShot("Clicked on Create New product", test, Capture);
				WaitforPage(4000);

//				String productName = "NTEST_AM_02Q";
				productPage.enterProductName(productName);
				test.log(Status.INFO, "Entered product Name successfully: " + productName);
				addScreenShot("Entered product Name successfully", test, Capture);
				WaitforPage(4000);

//				String brandHierarchy = "Red Tab Global";
				productPage.selectBrandHierarchy(brandHierarchy);
				test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
				addScreenShot("Entered Brand Hierarchy value successfully", test, Capture);
				WaitforPage(5000);

//				String proSubCat1 = "Alternative Lengths";
				productPage.selectProSubCat1(proSubCat1);
				test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
				addScreenShot("Entered product Sub Cat 1 successfully", test, Capture);
				WaitforPage(5000);

//				String proSubCat2 = "Not Applicable";
				productPage.selectProSubCat2(proSubCat2);
				test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
				addScreenShot("Entered product Sub Cat 2 successfully", test, Capture);
				WaitforPage(5000);

//				String classValue = "Jeans";
				productPage.selectClass(classValue);
				test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
				addScreenShot("Entered class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

//				String subClassValue = "Bootcut or Flare";
				productPage.selectSubClass(subClassValue);
				test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
				addScreenShot("Entered sub class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

//				String consumer = "Mens";
				productPage.selectConsumer(consumer);
				test.log(Status.INFO, "Entered consumer successfully: " + consumer);
				addScreenShot("Entered consumer successfully", test, Capture);
				WaitforPage(5000);

//				String consumerGrp1 = "Adult Mens";
				productPage.selectConsumerGrp1(consumerGrp1);
				test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
				addScreenShot("Entered consumer Group 1 successfully", test, Capture);
				WaitforPage(5000);

//				String consumerGrp2 = "Regular";
				productPage.selectConsumerGrp2(consumerGrp2);
				test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
				addScreenShot("Entered consumer Group 2 successfully", test, Capture);
				WaitforPage(5000);

				productPage.clikOnSaveBtn();
				test.log(Status.INFO, "Clicked on save button successfully");
				addScreenShot("Clicked on save button successfully", test, Capture);
				WaitforPage(2000);

				productPage.clikViewProduct();
				test.log(Status.INFO, "Clicked on View Product successfully");
				addScreenShot("Clicked on View Product successfully", test, Capture);
				WaitforPage(2000);

				// Verify product name
				String product_Name = productPage.getProductName();
				if (product_Name.equals(productName)) {
					test.log(Status.PASS, "Product name verification--- PC5 is created: " + productName);
					addScreenShot("Product name verification", test, Capture);
				} else {
					test.log(Status.FAIL, "Product name verification: Failed");
					addScreenShot("Product name verification", test, Capture);
				}
			} catch (

			Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
				test.log(Status.FAIL, "Test case failed due to application slowness " + e);
			}

			Colorwaypage.Create_ColorwayafterProductcreation();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addScreenShot("Colorway page displayed", test, Capture);

//         if colorsubmenu element is not there just keep blank string ----------------------			
			String thumbnail = Colorwaypage.selectcolour_afterproductcreation(colormenu, colorsubmenu, filtercolor, test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addScreenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);

			Colorwaypage.MandatoryColorwayDetails_ForLSESetUP(productsegLSUSvalue, productsegLSEvalue, classification,
					producttype, consumergroup, consumergroupext1, consumergroupext2, materialtype,
					productmarketingname, rigidindicator, merchfabrictype, destroysampleInd, collectionType, capsule,
					test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addScreenShot("All mandatory fields filled", test, Capture);
			WaitforPage(4000);

			Colorwaypage.MandatoryFields_colorwaySeason_SetUpLSE_afterproductcreation(hubofferedto, productlifecyclegroup, lastseasonoffered,
					productpricepositioning, createddate, filtermaterial, sizeGridCode, currentPlannedLifecycle,
					primaryfabric, test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addScreenShot("Colorway season fields selected and view product clicked", test, Capture);

			Thread.sleep(2000);
			String colorwayname = Colorwaypage.validateColorway_creation(filtercolor, test);
			System.out.println("Validated Colorway creation");
			test.log(Status.PASS, "Validated Colorway creation");
			addScreenShot("Validated Colorway creation", test, Capture);
			
			Colorwaypage.SiteClick();
			Thread.sleep(2000);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);
	
			LineSheetEditPage.filter_View_Change(linesheetview_LSUS, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_LSUS);
			addScreenShot("Linesheet view is " + linesheetview_LSUS, test, Capture);
			WaitforPage(5000);
			
			Techpackpages.filterdata(colorwayname);
			test.log(Status.INFO, "colorway filtered " + colorwayname);
			addScreenShot("colorway filtered " + colorwayname, test, Capture);
			System.out.println("colorway filtered " + colorwayname);

			Thread.sleep(5000);

			LineSheetEditPage.setting_colorway();

			E2EPages.Linesheet_SetUpLSE(test);
			test.log(Status.PASS, " LSE setup completed ");
			System.out.println(" LSE setup completed ");
			addScreenShot(" LSE setup completed ", test, Capture);
			Thread.sleep(3000);
			
			
			 if (i == testData.length - 1) {
					// Last iteration, perform logout

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addScreenShot("Logout successful", test, Capture);
					
				} else {
					
					ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				    driver.switchTo().window(tabs.get(0));
				    driver.switchTo().window(tabs.get(1));
				    driver.close(); // Close the second tab
				    driver.switchTo().window(tabs.get(0));
					// Not the last iteration, refresh the browser
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
