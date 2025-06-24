package com.WMS_ApplicationPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class ProductDetailsPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement createColorwayDropdown;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement optionsContainerLocator;

	@FindBy(xpath = "//div[@id='lscoBrand']/div[@class='display-only-label']")
	//// div[@id='lscoBrand']/div[2]
	private WebElement productBrand;

	@FindBy(xpath = "//div[@id='lscoProductCategory']/div[@class='display-only-label']")
	// div[@id='lscoProductCategory']/div[2]
	private WebElement productCategory;

	@FindBy(xpath = "//div[@id='lscoConsumerGrp1']/div[@class='display-only-label']")
	// div[@id='lscoConsumerGrp1']/div[2]
	private WebElement consumerGroup;

	@FindBy(xpath = "//div[@id='lscoConsumerProdHier']//div[@class='display-only-label']")
	// div[@id='lscoConsumerProdHier']//div[2]
	private WebElement ConsumerPH;

	@FindBy(xpath = "//div[normalize-space()='Profit Center [APD]']/following-sibling::div")
	// div[@id='lscoConsumerProdHier']//div[2]
	private WebElement profitCenter_APD;

	@FindBy(xpath = "//div[@id='lscoProdSegmentEUR']//div[@class='display-only-label']//a[1]")
	private WebElement lseProductSegmentationLink;

	@FindBy(xpath = "//div[@id='lscoProdSegmentUS']//div[@class='display-only-label']//a[1]")
	private WebElement lsusProductSegmentationLink;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colourwayDropDown;

	@FindBy(xpath = "//a[@id='editColorwaySeason']")
	private WebElement editColorwayIcon;

	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@id='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//body/form[@id='MAINFORM']/div[@id='allSpace']/div[@class='flex-content']/div[@id='contentDiv']/div[@class='themedPage']/div[1]")
	private WebElement uniqueElementLocator;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement threeDots;

	@FindBy(xpath = "//span[normalize-space()='Create...']")
	private WebElement createDropdown;

	@FindBy(xpath = "//span[normalize-space()='Create Colorway']")
	private WebElement createColorwayOption;

	@FindBy(xpath = "//a[normalize-space()='Colorway (Look/Color):']")
	private WebElement LookColorLink;

	@FindBy(xpath = "//div[normalize-space()='Colorway Code']/following::div[1]")
	private WebElement pc9CodeElement;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colourwayNameElement;

	@FindBy(xpath = "//div[normalize-space()='Colorway (Look/Color)']/following::div[1]/a")
	private WebElement linkToColorDetails;

	@FindBy(xpath = "//div[@id='lscoProdMarketingName']/child::div[2]")
	private WebElement productMarketingNameElement;

	@FindBy(xpath = "//div[@id='navHeader']/child::a")
	private WebElement productNameElement;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	private boolean Capture;

	public void CreateColorway() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colourwayDropDown));
//		System.out.println("string menu" +":");
		driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Create...']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Create Colorway']")).click();

	}

	public void selectColorwayFromMenu(String colourWayName, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement dropdownSymbol = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(createColorwayDropdown));
		dropdownSymbol.click();

		WebElement searchBox = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='searchbox']")));
		searchBox.sendKeys(colourWayName);

		WebElement option = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option']")));
		option.click();

		test.log(Status.INFO, "Selected Colorway from menu: " + colourWayName);
		addSrceenShot("Selected Colorway from menu", test, Capture);
	}

	public void validateDetails(String Brand, String Product_Category, String Consumer_PH, String Profit_Center_APD,
			ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Validate the details
		try {
			boolean isBrandValid = productBrand.getText().equalsIgnoreCase(Brand);
			boolean isCategoryValid = productCategory.getText().equalsIgnoreCase(Product_Category);
			boolean isConsumerPHValid = ConsumerPH.getText().equalsIgnoreCase(Consumer_PH);
			boolean isProfitCenterValid = profitCenter_APD.getText().equals(Profit_Center_APD);

			if (isBrandValid && isCategoryValid && isConsumerPHValid) {
				Assert.assertTrue(isProfitCenterValid, "Profit Center APD does not match!");
				test.log(Status.PASS, "Validated details: Brand = " + Brand + ", Product Category = " + Product_Category
						+ ", Consumer PH = " + Consumer_PH + ", Profit Center APD = " + Profit_Center_APD);
				addSrceenShot("Validated details", test, Capture);
			} else {
				throw new AssertionError("One or more details do not match!");
			}
		} catch (Exception e) {

			System.err.println("Validation failed: " + e.getMessage());
			test.log(Status.FAIL, "Validation failed: " + e.getMessage());
			addSrceenShot("Validation failed", test, Capture);
			throw e;
		}
	}

	public void editColorway() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
//		System.out.println("string menu" +":");
		driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Edit Colorway']")).click();

	}

	public boolean isPC5DetailsPageDisplayed(ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Details']")));

		boolean isDisplayed = driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
		test.log(Status.PASS, "PC5 Details Page displayed: " + isDisplayed);
		addSrceenShot("PC5 Details Page displayed", test, Capture);

		return isDisplayed;
//		return driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
	}

	public void clickOnLSEProductSegmentationLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lseProductSegmentationLink));

		lseProductSegmentationLink.click();
	}

	public void clickOnLSUSProductSegmentationLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lsusProductSegmentationLink));

		lsusProductSegmentationLink.click();
	}

	// Getters for the product details
	public String getProductBrand() throws InterruptedException {

//		 JavascriptExecutor js = (JavascriptExecutor) driver;
//		    js.executeScript("document.body.style.zoom = '80%'");

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productBrand));
			return productBrand.getText();
		} catch (StaleElementReferenceException e) {
			// Handle the stale element reference exception
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			productBrand = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productBrand));
			return productBrand.getText();
		}
	}

	public String getProductCategory() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(productCategory));
		return productCategory.getText();
	}

	public String getConsumerGroup() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(consumerGroup));
		return consumerGroup.getText();
	}

	public String getConsumerPH() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ConsumerPH));
		return ConsumerPH.getText();
	}

	public String getPc9Code(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9CodeElement));
		String pc9Code = pc9CodeElement.getText();
		test.log(Status.INFO, "Pc9 code extracted: " + pc9Code);
		addSrceenShot("Pc9 code extracted", test, Capture);
		return pc9Code;
	}

	public String getColourwayName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colourwayNameElement));
		String colourwayName = colourwayNameElement.getText();
		test.log(Status.INFO, "Colorway name extracted: " + colourwayName);
		addSrceenShot("Colorway name extracted", test, Capture);
		return colourwayName;
	}

	public void clickOnColorDetailsLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(linkToColorDetails));
		linkToColorDetails.click();
	}

//public ColorDetailsPage clickOnColorDetailsLink() throws InterruptedException {
//	driver.switchTo().defaultContent();
//	driver.switchTo().frame(iframeContentframe);
//	new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(linkToColorDetails));
//	linkToColorDetails.click();
//        return new ColorDetailsPage(driver);
//    }

	public String getProductName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productNameElement));
		String productName = productNameElement.getText();
		test.log(Status.INFO, "Product Name extracted: " + productName);
		addSrceenShot("Product Name extracted", test, Capture);
		return productName;
	}

	public String getProductMarketingName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productMarketingNameElement));
		String productMarketingName = productMarketingNameElement.getText();
		test.log(Status.INFO, "Product Marketing Name extracted: " + productMarketingName);
		addSrceenShot("Product Marketing Name extracted", test, Capture);
		return productMarketingName;
	}

	public boolean isColorwayCodeDisplayed() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9CodeElement));
		return pc9CodeElement.isDisplayed();
	}

	public String getColorwayCode(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9CodeElement));

		String colorwayCode = pc9CodeElement.getText();
		test.log(Status.INFO, "Colorway code retrieved: " + colorwayCode);
		addSrceenShot("Colorway code retrieved", test, Capture);
		return colorwayCode;
//    return pc9CodeElement.getText();
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//div[normalize-space()='Product Code']/following::div[1]")
	private WebElement pc5CodeElement;

	@FindBy(xpath = "//div[@id='lscoProductDevCenter']//div[2]")
	private WebElement PDCValue;

	@FindBy(xpath = "//div[@id='lscoProductDevCenter']//div[1]")
	private WebElement pDCElement;

	public boolean isPC5CodeDisplayed() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc5CodeElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pc5CodeElement);
		return pc5CodeElement.isDisplayed();
	}

	public String getPC5Code(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc5CodeElement));

		String pc5Code = pc5CodeElement.getText();
		test.log(Status.INFO, "PC5 code retrieved: " + pc5Code);
		addSrceenShot("PC5 code retrieved", test, Capture);
		return pc5Code;
//return pc9CodeElement.getText();
	}

	public void validatePDC_ValueForProduct(ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			String PCC_Value = PDCValue.getText();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pDCElement);

			if (PCC_Value.equals("Global")) {
				System.out.println(PCC_Value + " is derived from user profile and set on PC5");
				test.log(Status.INFO, PCC_Value + " is derived from user profile and set on PC5");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean isPC5DetailsPage_Displayed(ExtentTest test) throws InterruptedException {

		Thread.sleep(5000);
		switchToWindowByTitle("View Season Product Information");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Details']")));

		boolean isDisplayed = driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
		test.log(Status.PASS, "PC5 Details Page displayed: " + isDisplayed);
		addSrceenShot("PC5 Details Page displayed", test, Capture);

		return isDisplayed;
	}
}
