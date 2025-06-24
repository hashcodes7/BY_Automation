package P1_Testcases;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorDetailsPage;
import com.WMS_ApplicationPages.ColorWayPage;
import com.WMS_ApplicationPages.Colorway_page;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LSEProductSegmentationPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;

import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC35_P1_VerifyColorwayAndMarketingNames extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	Palette_Page palettePage;

	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	ProductDetailsPage productDetailsPage;
	LSEProductSegmentationPage lseProductSegmentationPage;
	PopUpPage popUpPage;
	ColorWayPage colorWayPage;

	Colorway_page Colorwaypage;


	ColorDetailsPage colorDetailsPage;
	LineSheet_Edit_Page LineSheetEditPage;

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
			seasonPage = new SeasonPage(driver);
			palettePage = new Palette_Page(driver);

			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new ColorWayPage(driver);
			colorDetailsPage = new ColorDetailsPage(driver);
			Colorwaypage = new Colorway_page(driver);


			LineSheetEditPage = new LineSheet_Edit_Page(driver);

			setReport("TC35_P1_Colorway Name and Product Marketing Name Validation");
		}
	}

	@Test(priority = 0, dataProvider = "TC35_P1_VerifyColorwayAndMarketingNames", dataProviderClass = DataProviders.class)
	public void P1_TC35_Validate_PrintAndPatterns(String TestType, String season, String linesheetview, String colorway,
			String rigidIndicatorValue, String productSegmentationLSE_Value, String productSegmentationLSUS_Value,
			String colorLookType, String printPatternColor) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC35_P1_Colorway Name and Product Marketing Name Validation:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts
		try {

			long startTime = System.nanoTime();

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 Colorway module from TC35");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + Global_URL);
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2023 Male Accessories";
			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

//			String linesheetview = "Adoption";
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			WaitforPage(5000);

//			String colorway = "0WP6W-0001 ULTRAVIOLET HEATHER";
			Colorwaypage.SelectColorway(colorway, test);
			test.log(Status.INFO, "Clicked on filtered colorway ");
			test.log(Status.INFO, "colorway details page opened ");
			addSrceenShot("colorway details page opened ", test, Capture);

			Colorwaypage.editColorWay();
			test.log(Status.INFO, "Clicked On Edit Colorway from the Menu");
			addSrceenShot("Clicked On Edit Colorway from the Menu", test, Capture);
			WaitforPage(5000);

//			String rigidIndicatorValue = "Normal Product";
//			String productSegmentationLSE_Value = "A66 - LFB RT Accessories Belts";
//			String productSegmentationLSUS_Value = "5 - LFK Boys 8-20 Discontinued Licensed";

			Colorwaypage.enterMandatoryDetails(rigidIndicatorValue, productSegmentationLSE_Value,
					productSegmentationLSUS_Value, test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addSrceenShot("All mandatory fields filled", test, Capture);
			WaitforPage(3000);

//			String colorLookType = "Prints and Patterns";
//			String printPatternColor = "DA04DY SNAKE BLACK/NATURAL BLACK NATURAL Print A131-M";
			Colorwaypage.selectPrintPatternColor(colorLookType, printPatternColor, test);
			System.out.println("Selected Print and pattern type Color: " + printPatternColor);
			test.log(Status.INFO, "Selected Print and pattern type Color: " + printPatternColor);
			addSrceenShot("Selected Print and pattern type Color", test, Capture);
			WaitforPage(3000);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
			WaitforPage(10000);

			String pc9Code = productDetailsPage.getPc9Code(test);
			String actualColourwayName = productDetailsPage.getColourwayName(test);
			String product_Name = productDetailsPage.getProductName(test);
			String actualProductMarketingName = productDetailsPage.getProductMarketingName(test);

//			 Click the link to navigate to the color details page
			productDetailsPage.clickOnColorDetailsLink();

			String lscoArtworkFromColor = colorDetailsPage.getLscoArtwork(test);
			String lscoArtworkNameFromColor = colorDetailsPage.getLscoArtworkName(test);
			String colorCombo = colorDetailsPage.getColorCombo(test);
			String printType = colorDetailsPage.getPrintType(test);

			// Verify that the colourway name is derived correctly
			String expectedColourwayName = pc9Code + " " + lscoArtworkNameFromColor;

			// Verify that the Product Marketing Name is derived correctly
			String expectedProductMarketingName = product_Name + " " + lscoArtworkFromColor + " " + colorCombo + " "
					+ printType;

			Assert.assertEquals(actualColourwayName, expectedColourwayName, "Colourway name does not match.");
			System.out.println("Colorway name  is  derived from the PC9 Code  & LSCO Artwork Name from the color");
			test.log(Status.PASS,
					"Validation: Colorway name  is  derived from the PC9 Code  & LSCO Artwork Name from the color: "
							+ actualColourwayName);

			Assert.assertEquals(actualProductMarketingName, expectedProductMarketingName,
					"Product Marketing Name does not match.");
			System.out.println(
					"Product Marketing Name is  derived from the Product Name &  LSCO Artwork , Color Combo  and  Print Type from the color");
			test.log(Status.PASS,
					"Validation: Product Marketing Name is  derived from the Product Name &  LSCO Artwork , Color Combo  and  Print Type from the color: "
							+ actualProductMarketingName);
			
			WaitforPage(4000);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);

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
//
//	@Test
//    public void verifyColorwayNameDerived() throws InterruptedException {
//        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
// 
//        // Navigate to the product details page
//        driver.get("url_of_the_product_details_page");
// 
//        String pc9Code = productDetailsPage.getPc9Code();
//        String lscoArtworkNameFromProduct = productDetailsPage.getLscoArtworkName();
// 
//        // Click the link to navigate to the color details page
//        ColorDetailsPage colorDetailsPage = productDetailsPage.clickOnColorDetailsLink();
//        
//        String lscoArtworkNameFromColor = colorDetailsPage.getLscoArtworkName();
// 
//        // Verify that the colourway name is derived correctly
//        String expectedColourwayName = pc9Code + " " + lscoArtworkNameFromColor;
//        String actualColourwayName = productDetailsPage.getColourwayName();
// 
//        Assert.assertEquals(actualColourwayName, expectedColourwayName, "Colourway name does not match.");
//    }

//productDetailsPage.selectCreateColorwayFromMenu();
//System.out.println("Clicked on Colorway From Menu");
//test.log(Status.INFO, "Clicked on Colorway From Menu");
//addSrceenShot("Clicked on Colorway From Menu", test, Capture);

//try {
//
//
//
//	String expectedBrand = productDetailsPage.getProductBrand();
//	System.out.println(expectedBrand);
//	test.log(Status.INFO, "product band captured");
//	addSrceenShot("product band captured", test, Capture);
//
//	
//	String expectedCategory = productDetailsPage.getProductCategory();
//	System.out.println(expectedCategory);
//	test.log(Status.INFO, "product category captured");
//	addSrceenShot("product category captured", test, Capture);
//
//
//	String expectedConsumerGroup = productDetailsPage.getConsumerGroup();
//	System.out.println(expectedConsumerGroup);
//	test.log(Status.INFO, "product consumer group captured");
//	addSrceenShot("product consumer group captured", test, Capture);
//
//
//	productDetailsPage.clickOnLSEProductSegmentationLink();
//	System.out.println("Clicked on LSEProductSegmentationLink");
//	test.log(Status.INFO, "Clicked on LSEProductSegmentationLink");
//	addSrceenShot("Clicked on LSEProductSegmentationLink", test, Capture);
//
//
//	String actualBrand = lseProductSegmentationPage.getLSEProductBrand();
//	System.out.println(actualBrand);
//	test.log(Status.INFO, "lse product band captured");
//	addSrceenShot("lse product band captured", test, Capture);
//
//
//	String actualCategory = lseProductSegmentationPage.getLSEProductCategory();
//	System.out.println(actualCategory);
//	test.log(Status.INFO, "lse product category captured");
//	addSrceenShot("lse product category captured", test, Capture);
//
//
//	String actualConsumerGroup = lseProductSegmentationPage.getLSEConsumerGroup();
//	System.out.println(actualConsumerGroup);
//	test.log(Status.INFO, "lse product consumer group captured");
//	addSrceenShot("lse product consumer group captured", test, Capture);
//
//
//	Assert.assertEquals(actualBrand, expectedBrand, "Brand does not match!");
//	Assert.assertEquals(actualCategory, expectedCategory, "Category does not match!");
//	Assert.assertEquals(actualConsumerGroup, expectedConsumerGroup, "Consumer Group does not match!");
//
//} catch (Exception e) {
//	System.out.println("Test case failed due to application slowness" + e);
//	test.log(Status.FAIL, "Test case failed due to application slowness");
//
//}