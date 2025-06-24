package com.WMS_ApplicationPages;

import java.util.ArrayList;
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

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class ColorWayPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public ColorWayPage(WebDriver driver) {
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

	@FindBy(xpath = "//div[@id='lscoProdSegmentEUR']//div[@class='display-only-label']//a[1]")
	private WebElement lseProductSegmentationLink;

	@FindBy(xpath = "//div[@id='lscoProdSegmentUS']//div[@class='display-only-label']//a[1]")
	private WebElement lsusProductSegmentationLink;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colourwayDropDown;
	
	@FindBy(xpath = "//div[normalize-space()='* Product Type']/following-sibling::div")
	private WebElement productTypeDropDown;
	
	@FindBy(xpath = "//div[normalize-space()='* Rigid Indicator']/following-sibling::div")
	private WebElement rigidBodyDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Product Segmentation [LSE]']/following-sibling::div")
	private WebElement productSegmentationLSEDropDown;
	
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement ProductSeg_LSE_TextBox;
	
	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductSeg_LSE_Selection;
	
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement ProductSeg_LSUS_TextBox;
	
	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductSeg_LSUS_Selection;

	@FindBy(xpath = "//div[normalize-space()='* Product Segmentation [LSUS]']/following-sibling::div")
	private WebElement productSegmentationLSUSDropDown;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Hub Offered To')]/following-sibling::div")
	private WebElement hubOfferedToDropDown;
	
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement HubOfferdTo_TextBox;
	
	@FindBy(xpath = "//li[@role='option']")
	private WebElement HubOfferdTo_Selection;
	
	
	@FindBy(xpath = "//span[contains(text(), 'View Product')]")
	private WebElement viewProductButton;

	@FindBy(xpath = "//div[@class='error-message']")
	private WebElement errorMessage;

	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;

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

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	public void CreateColorway() throws Exception {

		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));

//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
		String mainWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!mainWindow.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
//		Set<String> handler = driver.getWindowHandles(); 
//		Iterator<String> it = handler.iterator();
//		String parentwindow = it.next();
//		String childwindow = it.next();
//		driver.switchTo().window(childwindow);
//		driver.manage().window().fullscreen();

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
   //		System.out.println("string menu" +":");
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Create...']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Create Colorway']")).click();
//		System.out.println("string menu" +":");
//		System.out.println("string menu" +":");
//		System.out.println("string menu" +":");
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@class='dropdown menu-icon']"))).perform();
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Create...']"))).perform();
//        driver.findElement(By.xpath("//span[normalize-space()='Create Colorway']")).click();

//        new Actions(driver).moveToElement(threeDots).perform();
//        new Actions(driver).moveToElement(createDropdown).perform();
//        createColorwayOption.click();

		} catch (Exception e) {
//			System.out.println("string menu" +":");
		}
	}

	public void ClickColorwayLookColor() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LookColorLink));
		LookColorLink.click();

	}

	public void selectCreateColorwayFromMenu() throws InterruptedException {
		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement dropdownSymbol = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(createColorwayDropdown));
		dropdownSymbol.click();

		// dropdown options container
		WebElement optionsContainer = driver.findElement(By.xpath("//ul[@id='select2-contextSKUId-results']"));

		// Get all the options within the container
		List<WebElement> options = optionsContainer.findElements(By.tagName("li")); // Assuming each option is an 'li'
																					// element

		// Check if there are options available
		if (options.size() > 1) {
			options.get(1).click();
		}
	}

	public void switchToWindowTitle() throws Exception {

		try {

			String ParentWinhadle = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);

			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}
	
	public void selectProductType(String productTypeValue) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement dropdownSymbol = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(productTypeDropDown));
		dropdownSymbol.click();

		WebElement optionsContainer = driver.findElement(By.xpath("//li[text()='" + productTypeValue.trim() + "']"));
		optionsContainer.click();
	
		}
		
		
		public void selectRigidIndicator(String rigidIndicatorValue) throws InterruptedException {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(rigidBodyDropDown));
			rigidBodyDropDown.click();

			WebElement optionsContainer = driver.findElement(By.xpath("//li[text()='" + rigidIndicatorValue.trim() + "']"));
			optionsContainer.click();
		
			}

	public void selectProductSegmentationLSE_DropDown(String productSegmentationLSE_Value) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(productSegmentationLSEDropDown));
		productSegmentationLSEDropDown.click();
		ProductSeg_LSE_TextBox.sendKeys(productSegmentationLSE_Value);
		ProductSeg_LSE_Selection.click();
		
		

	}

	public void selectProductSegmentationLSUS_DropDown(String productSegmentationLSUS_Value) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(productSegmentationLSUSDropDown));
		productSegmentationLSUSDropDown.click();
		ProductSeg_LSUS_TextBox.sendKeys(productSegmentationLSUS_Value);
		ProductSeg_LSUS_Selection.click();



	}

	public void clickOnSave() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveButton));

		saveButton.click();

	}
	

	public void selectHubOfferdToValue(String hubOfferdToValue) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		
		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(hubOfferedToDropDown));
		hubOfferedToDropDown.click();
		HubOfferdTo_TextBox.sendKeys(hubOfferdToValue);
		HubOfferdTo_Selection.click();



	
	}
	
	public void clickOnViewProduct() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewProductButton));

		viewProductButton.click();

	}
	
	
	
	public boolean isErrorMessageDisplayed() throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.isDisplayed();

	}

	public boolean isPC5DetailsPageDisplayed() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Details']")));

		return driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
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
}

//	public void openSubMenu(String menu, String submenu) throws Exception {
//		System.out.println("string menu"+menu +":"+submenu);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeLeft);
//		System.out.println("string menu"+menu +":"+submenu);
//		driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
//		driver.findElement(By.xpath("//a[text()='" + submenu + "']")).click();
//		/*
//		 * clickElement("//label[@title='My Work']");
//		 * clickElement("//label[@title='Season']");
//		 */
//		//click("//label[@title='" + menu + "']", menu);
//
//		
//	}
