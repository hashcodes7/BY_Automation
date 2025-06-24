package P1_Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Color_Page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.Measurements_Page;

import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC186_P1_UpdatePOMImageFromProdManagement extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	ProductDetailsPage productDetailsPage;
	LineSheetPage lineSheetPage;
	Measurements_Page MeasurementsPage;

	ProductPage productPage;


	boolean Capture = true;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(GarmentDeveloper_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			MeasurementsPage = new Measurements_Page(driver);

			productPage = new ProductPage(driver);



			setReport("TC186_P1_Update POM Images from Product Measurement");
		}
	}

	 @Test(priority = 0, dataProvider = "updatePOMImagesData", dataProviderClass = DataProviders.class)
	    public void P1_TC186_UpdatePOMImages(String TestType, String season, String productName, String specification, String measurementSet, String imagePath) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC186_P1_Update POM Images from Product Measurement:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 measurment module from TC186 to TC190");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL " + GarmentDeveloper_URL);
			addSrceenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addSrceenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2024 Male Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "Test060524";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
			addSrceenShot("PC5 Details Page is displayed", test, Capture);
			
			MeasurementsPage.clickDetailsTab();
			test.log(Status.INFO, "Clicked on Details tab");
			addSrceenShot("Clicked on Details tab", test, Capture);

//			String source = "0WOZV - Primary -";
//			MeasurementsPage1.select_Source(source, test);
//			System.out.println("Selected Primary source " + source);
//			test.log(Status.INFO, "Selected Primary source " + source);
//			addSrceenShot("Selected Primary source " + source, test, Capture);

//			String specification = "S1 2024 - 0WOZV - Test060524 -";
			MeasurementsPage.selectSpecifications(specification, test);
			System.out.println("Selected specifications " + specification);
			test.log(Status.INFO, "Selected specification " + specification);
			addSrceenShot("Selected specification " + specification, test, Capture);

			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			System.out.println("Navigated to measurement page  ");
			addSrceenShot("Navigated to measurement page  ", test, Capture);

//			String measurementSet = "001 : test_auto_21";
			MeasurementsPage.selectMeasurementSet(measurementSet);
			test.log(Status.INFO, "Selected m easurement set: " + measurementSet);
			addSrceenShot("Selected measurement set: " + measurementSet, test, Capture);

			MeasurementsPage.clickNewPOMImages();
			test.log(Status.INFO, "Clicked on New POM Images");
			addSrceenShot("Clicked on New POM Images", test, Capture);

//			String imagePath = "C:\\Users\\2240786\\Downloads\\levis_logo.jpg";
			MeasurementsPage.uploadImage(imagePath);
			test.log(Status.INFO, "Image selected: " + imagePath);
			addSrceenShot("Image selected: " + imagePath, test, Capture);

			MeasurementsPage.clickSaveButton();
			test.log(Status.INFO, "Clicked on Save button");
			addSrceenShot("Clicked on Save button", test, Capture);

			boolean isImageUpdated = MeasurementsPage.verifyImageUpdate();
			if (isImageUpdated) {
				test.log(Status.PASS, "Image successfully updated. Verification passed.");
				addSrceenShot("Image successfully updated", test, Capture);
			} else {
				test.log(Status.FAIL, "Image update failed. Verification failed.");
				addSrceenShot("Image update failed", test, Capture);
			}

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left panel");
			test.log(Status.INFO, "Clicked on close Left panel");
			addSrceenShot("Clicked on close Left panel", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);

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

//MeasurementsPage1.clickChooseFile();
//test.log(Status.INFO, "Clicked on Choose File");
//addSrceenShot("Clicked on Choose File", test, Capture);
