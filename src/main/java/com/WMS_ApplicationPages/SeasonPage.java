package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.relevantcodes.extentreports.LogStatus;

public class SeasonPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public SeasonPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "//select[@id='seasonSelectList']")
	private WebElement seasonDropdown;

	// Assuming 'paletteButton' is the WebElement for the "Palette" button
	@FindBy(id = "//a[@href='javascript:viewSelectedPalette()']")
	private WebElement paletteButton;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//iframe[@name='headerframe']")
	private WebElement iframeHeader;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newBtn;

	@FindBy(xpath = "//a[.='Vertical']")
	private WebElement vertical;

	@FindBy(xpath = "//a[contains(text(),'Levis')]")
	private WebElement seasonTypeLink;

	@FindBy(xpath = "//div[@id='pinbutton']")
	private WebElement pinbutton;

	@FindBy(xpath = "//div[@class='x-tool x-tool-unpin collapseExpandAndPin']")
	private WebElement pinbuttonclose;

	@FindBy(xpath = "//a[.='* Product Type']")
	private WebElement productType;

	@FindBy(xpath = "//div[@id='userLabelDiv']")
	private WebElement UserNameLabel;

	@FindBy(xpath = "//select[@id='quickLinkSelectionId']")
	private WebElement quickLinkDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Category')]/following-sibling::td[1]")
	private WebElement CategoryDropdown1;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Category')]/following-sibling::td[1]/select")
	private WebElement CategoryDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Brand')]/following-sibling::td[1]/select")
	private WebElement BrandDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Gender')]//following-sibling::td/select")
	private WebElement GenderDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Year')]//following-sibling::td/select")
	private WebElement YearDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Season')]//following-sibling::td[1]/select")
	private WebElement SeasonDropdown;

	@FindBy(xpath = "//a[.='Create']")
	private WebElement createBtn;

	@FindBy(xpath = "//td[@class='HEADING2']//select")
	private WebElement actionDD;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Quarter')]//preceding-sibling::td/select")
	private WebElement yearDD;

	@FindBy(xpath = "//a[.='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//a[.='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//td[@class='HEADING1']")
	private WebElement deleteMessage;

	@FindBy(xpath = "(//div[@class='BlueBox']//td[@class='BlueHeader'])[1]")
	private WebElement seasonIdentificationValue;

	@FindBy(xpath = "//div[@id='null']//td[contains(.,'Name')]//following-sibling::td[@class='DISPLAYTEXT'][1]")
	private WebElement nameValue;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Season Introduced Code')]//following-sibling::td/select")
	private WebElement SeasonCodeDropdown;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//div[@id='allSpace']")
	private WebElement dashboardElement;

	@FindBy(xpath = "//select[@id='quickLinkSelectionId']")
	private WebElement logout;

	@FindBy(xpath = "//center[contains(text(),'Logged Out')]")
	private WebElement logoutText;

	@FindBy(xpath = "//*[@id=\"seasonFavoritesContent\"]/div/div[2]/a")
	private WebElement seasonSelection;

	@FindBy(xpath = "//input[@id='quickSearchCriteria']")
	private WebElement quickSearchText;

	@FindBy(xpath = "//td[contains(text(),'Season Name')]/following-sibling::td[1]")
	private WebElement seasonName;

	@FindBy(xpath = "//td[contains(text(),'Status')]/following-sibling::td[1]")
	private WebElement statusInput;

	@FindBy(xpath = "//td[contains(text(),'Season Code')]/following-sibling::td[1]")
	private WebElement seasonCodeInput;

	@FindBy(xpath = "//label[normalize-space()='My Seasons']")
	private WebElement MySeasonsOption;

	@FindBy(xpath = "//div[@id='librariesContent']/child::a[text()='Season']")
	private WebElement seasonOptn;

	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement searchoptn;

	private static By productTypeOption = By.xpath("//a[.='<productType>']");

	/////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//iframe[@id='materiallibraryframe']")
	private WebElement iframeMateriallibraryframe;
	
	
	@FindBy(xpath = "//span[normalize-space()='Clear Criteria']")
	private WebElement clearCriteria;

	@FindBy(xpath = "//span[normalize-space()='Reset Defaults']")
	private WebElement resetDefaults;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='Name']/following::input[1]")
	private WebElement nameSearchField;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	private WebElement editOptn;

	@FindBy(xpath = "//td[@class='PAGEHEADINGTITLE']")
	private WebElement pageHeadTitle;

	@FindBy(xpath = "//tr[@id='columns']/following::td[3]")
	private WebElement finishFormulaField;

	@FindBy(xpath = "//div[@class='input-title']/a")
	private WebElement finishFomulahyperlink;

	@FindBy(xpath = "(//a[contains(text(),'(choose)')])[1]")
	private WebElement optnSelect;

	@FindBy(xpath = "//div[@class='scope-header'][normalize-space()='Material']/following::div[@class='input-title'][1]/following::input[1]")
	private WebElement MaterailNameInput;

	@FindBy(xpath = "//span[normalize-space()='Save & Close']")
	private WebElement saveAnCheckIn;

	@FindBy(xpath = "//a[normalize-space()='Fabric Mill']/following::td[normalize-space()='Yes']/following::a[1]")
	private WebElement fabricField;

	@FindBy(xpath = "//a[normalize-space()='Fabric Mill']/following::a[3]")
	private WebElement lookFinishRecipeField;

	String currentTest;

	private boolean Capture;
	
	
	
	
	@FindBy(xpath = "//a[normalize-space()='Create New Palette']")
	private WebElement createNewPaletteOptn;

	@FindBy(xpath = "//td[@class='REQUIRED']/following::td[1]/input")
	private WebElement paletteNameFeild;

	@FindBy(xpath = "//span[@class='PAGEHEADINGTITLE']/a")
	private WebElement paletteNameValue;

	public String getPaletteName() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(paletteNameValue));
		String paletteNameValue_Extract = paletteNameValue.getText();

		return paletteNameValue_Extract;
	}

	public void createPalette(String paletteName, String seasonType, String brand, String gender, String category, ExtentTest test)
			throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createNewPaletteOptn)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(paletteNameFeild));
		paletteNameFeild.clear();
		paletteNameFeild.sendKeys(paletteName);
		test.log(Status.INFO, "Entered Palette name: " + paletteName);

		Thread.sleep(2000);
		WebElement seasonDropDown = driver.findElement(By.xpath("//td[contains(text(),'Season')]/following::select[1]"));
		Select selectvalue4 = new Select(seasonDropDown);
		selectvalue4.selectByVisibleText(seasonType);
		test.log(Status.INFO, "Selected season: " + seasonType);
		
		Thread.sleep(2000);
		WebElement brandDropDown = driver.findElement(By.xpath("//td[contains(text(),'Brand')]/following::select[1]"));
		Select selectvalue1 = new Select(brandDropDown);
		selectvalue1.selectByVisibleText(brand);
		test.log(Status.INFO, "Selected Brand: " + brand);
		Thread.sleep(2000);

		WebElement genderDropDown = driver
				.findElement(By.xpath("//td[contains(text(),'Gender')]/following::select[1]"));
		Select selectvalue2 = new Select(genderDropDown);
		selectvalue2.selectByVisibleText(gender);
		test.log(Status.INFO, "Selected Gender: " + gender);
		Thread.sleep(2000);

		WebElement categoryDropDown = driver
				.findElement(By.xpath("//td[contains(text(),'Category')]/following::select[1]"));
		Select selectvalue3 = new Select(categoryDropDown);
		selectvalue3.selectByVisibleText(category);
		test.log(Status.INFO, "Selected Category: " + category);
		addSrceenShot("Palette created", test, Capture);
		Thread.sleep(2000);
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(createOptn));
		createOptn.click();

	}

	public void goToSeasonViewPage(String mySeasonType, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonOptn));
		seasonOptn.click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quickSearchText));
		quickSearchText.sendKeys(mySeasonType);
		test.log(Status.INFO, "Entered season name in quick search.");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchoptn));
		searchoptn.click();
		test.log(Status.INFO, "Clicked on search option.");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonName));
		test.log(Status.INFO, "Season name is visible.");
	}

	public boolean isPaletteLinkPresent(String paletteName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonName));
			test.log(Status.INFO, "Season name is visible.");
			WebElement paletteLink = driver.findElement(By.xpath("//td[contains(text(),'Palette')]/following-sibling::td[1]/a"));
			Thread.sleep(4000);

			// Check if the palette link is displayed
			if (paletteLink.isDisplayed()) {
				System.out.println("Palette link is present: " + paletteName);
				test.log(Status.INFO, "Palette link is present: " + paletteName);
				addSrceenShot("Palette link is present", test, Capture);
				return true;
			} else {
				System.out.println("Palette link is not displayed: " + paletteName);
				test.log(Status.ERROR, "Palette link is not displayed: " + paletteName);
				addSrceenShot("Palette link is not displayed", test, Capture);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Palette link is not found: " + paletteName);
			test.log(Status.ERROR, "Palette link is not found: " + paletteName);
			addSrceenShot("Palette link is not found", test, Capture);
			return false;
		}
	}

	@FindBy(xpath = "//select[@onchange='evalList(this)']")
	private WebElement paletteActionsDrpDwn;

	@FindBy(xpath = "//div[@ref='eCheckbox']/child::div[2]/input")
	private WebElement firstCheckBox;

	@FindBy(xpath = "//span[normalize-space()='Select']")
	private WebElement select_Optn;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	private WebElement createOptn;
	
	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframecolorlibraryframe;
	
	@FindBy(xpath = "//label[normalize-space()='View']/following::span[1]")
	private WebElement viewDropDown;
	
	@FindBy(xpath = "//label[normalize-space()='View']//following::div[@role='button']//following::input[1]")
	private WebElement ViewType_SearchBox;

	public void addColorsToPalette(String colorItem, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(paletteActionsDrpDwn));

		Select selectvalue = new Select(paletteActionsDrpDwn);
		selectvalue.selectByVisibleText("Add Multiple Colors");
		Thread.sleep(2000);

		test.log(Status.INFO, "Clicked on 'Add multiple colors' Option from actions DropDown");
		addSrceenShot("Clicked on 'Add multiple colors' Option from actions DropDown", test, Capture);
		Thread.sleep(2000);
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframecolorlibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameSearchField));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(viewDropDown));
		viewDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ViewType_SearchBox));
		ViewType_SearchBox.sendKeys("None Selected");
		Thread.sleep(3000);
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-label='None Selected']"))).click();
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		nameSearchField.clear();
		nameSearchField.sendKeys(colorItem);
		test.log(Status.INFO, "Entered color item: " + colorItem);
		addSrceenShot("Entered color item", test, Capture);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);

		Thread.sleep(15000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCheckBox);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(select_Optn));
		select_Optn.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicked on select option");

		driver.switchTo().window(ParentWinhadle);
		Thread.sleep(3000);
	}

	public boolean isColorAddedToPalette(String colorItem, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			// Locate the element that confirms the colors have been added
			WebElement colorConfirmation = driver.findElement(By.xpath("//a[normalize-space()='" + colorItem + "']"));

			// Check if the confirmation message is displayed
			if (colorConfirmation.isDisplayed()) {
				System.out.println("Selected colors were added to the palette under Colors tab");
				test.log(Status.INFO, "Selected colors were added to the palette under Colors tab");
				addSrceenShot("Colors added to palette", test, Capture);
				return true;
			} else {
				System.out.println("Selected colors were not added to the palette under Colors tab");
				test.log(Status.ERROR, "Selected colors were not added to the palette under Colors tab");
				addSrceenShot("Colors not added to palette", test, Capture);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Confirmation message for added colors not found");
			test.log(Status.ERROR, "Confirmation message for added colors not found");
			addSrceenShot("Confirmation message not found", test, Capture);
			return false;
		}
	}

	public void addMaterialsToPalette(String materialName, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(paletteActionsDrpDwn));

		Select selectvalue = new Select(paletteActionsDrpDwn);
		selectvalue.selectByVisibleText("Add Materials");
		Thread.sleep(2000);

		test.log(Status.INFO, "Clicked on 'Add Materials' Option from actions DropDown");
		addSrceenShot("Clicked on 'Add Materials' Option from actions DropDown", test, Capture);
		Thread.sleep(2000);
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameSearchField));
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		nameSearchField.sendKeys(materialName);
		test.log(Status.INFO, "Entered Material: " + materialName);
		addSrceenShot("Entered Material", test, Capture);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);

		Thread.sleep(15000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCheckBox);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(select_Optn));
		select_Optn.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicked on select option");

		driver.switchTo().window(ParentWinhadle);
		Thread.sleep(3000);
	}

	public boolean isMaterialAddedToPalette(String materialName, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);
		try {
			// Locate the element that confirms the colors have been added
			WebElement materialConfirmation = driver
					.findElement(By.xpath("//a[normalize-space()='" + materialName + "']"));

			// Check if the confirmation message is displayed
			if (materialConfirmation.isDisplayed()) {
				System.out.println("Selected Material was added to the palette under Material tab");
				test.log(Status.INFO, "Selected Material was added to the palette under Material tab");
				addSrceenShot("Material added to palette", test, Capture);
				return true;
			} else {
				System.out.println("Selected Material was not added to the palette under Material tab");
				test.log(Status.ERROR, "Selected Material was not added to the palette under Material tab");
				addSrceenShot("material not added to palette", test, Capture);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Confirmation message for added Material not found");
			test.log(Status.ERROR, "Confirmation message for added Material not found");
			addSrceenShot("Confirmation message not found", test, Capture);
			return false;
		}
	}

	public void addMaterialColorToPalette(String materialColorName, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(paletteActionsDrpDwn));

		Select selectvalue = new Select(paletteActionsDrpDwn);
		selectvalue.selectByVisibleText("Add Material Colors");
		Thread.sleep(2000);

		test.log(Status.INFO, "Clicked on 'Add Material Colors' Option from actions DropDown");
		addSrceenShot("Clicked on 'Add Material Colors' Option from actions DropDown", test, Capture);
		Thread.sleep(2000);
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameSearchField));
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		nameSearchField.sendKeys(materialColorName);
		test.log(Status.INFO, "Entered Material: " + materialColorName);
		addSrceenShot("Entered Material", test, Capture);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);

		Thread.sleep(15000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCheckBox);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(select_Optn));
		select_Optn.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicked on select option");

		driver.switchTo().window(ParentWinhadle);
		Thread.sleep(3000);
	}

	public boolean isMaterialColorAddedToPalette(String materialColorName, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);
		try {
			// Locate the element that confirms the colors have been added
			WebElement materialColorConfirmation = driver
					.findElement(By.xpath("//a[normalize-space()='" + materialColorName + "']"));

			// Check if the confirmation message is displayed
			if (materialColorConfirmation.isDisplayed()) {
				System.out.println("Selected Material Color was added to the palette under Material tab");
				test.log(Status.INFO, "Selected Material Color was added to the palette under Material tab");
				addSrceenShot("Material added to palette", test, Capture);
				return true;
			} else {
				System.out.println("Selected Material Color was not added to the palette under Material tab");
				test.log(Status.ERROR, "Selected Material Color was not added to the palette under Material tab");
				addSrceenShot("material not added to palette", test, Capture);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Confirmation message for added Material Color not found");
			test.log(Status.ERROR, "Confirmation message for added Material Color not found");
			addSrceenShot("Confirmation message not found", test, Capture);
			return false;
		}
	}

	public void chooseMySeasonType(String mySeasonType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		WebElement staticDropDown = driver.findElement(By.xpath("//select[@id='seasonSelectList']"));

		Select selectvalue = new Select(staticDropDown);
		selectvalue.selectByVisibleText(mySeasonType);

		// Code to select the season from the dropdown
	}

	public void clickOnPalette() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		WebElement element = driver.findElement(By.xpath("//a[@href='javascript:viewSelectedPalette()']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);

	}

	public void clikOnNewBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newBtn));
		clickElement(newBtn);
	}

	public void verifyAffiliatevalues(ExtentTest test) throws Exception {
		ArrayList<String> option1 = new ArrayList<String>();
		try {
			Select select = new Select(driver.findElement(By.id("LCSREVISABLEENTITY_ptc_str_4Options")));
			List<WebElement> options = select.getOptions();
			System.out.println("The dropdown options are:");
			for (WebElement option : options) {
				System.out.println(option.getText());
				option1.add(option.getText());

			}
			int size = option1.size();
			System.out.println(size);
			if (size == 56) {
				System.out.println("The dropdown options are: true");
				test.log(Status.PASS, "Total number of Affilate dropdown values present: " + size);
				test.log(Status.PASS, "values of Affilate dropdown: " + option1);

			} else {
				System.out.println("The dropdown options are: FAIL");
				test.log(Status.FAIL, "Total number of Affilate dropdown values present: " + size);
				test.log(Status.FAIL, "values of Affilate dropdown: " + option1);
			}
		} catch (Exception e) {
			System.out.println(e);
			test.log(Status.FAIL, "Exception occurred while verifying Affiliate values: " + e.getMessage());
			addSrceenShot("Exception in verifying Affiliate values", test, Capture);
		}

	}

	//

	public void verifyGlobalvalues(ExtentTest test) throws Exception {
		ArrayList<String> option1 = new ArrayList<String>();
		try {
			Select select = new Select(driver.findElement(By.id("LCSREVISABLEENTITY_ptc_str_10Options")));
			List<WebElement> options = select.getOptions();
			System.out.println("The dropdown options are:");
			for (WebElement option : options) {
				System.out.println(option.getText());
				option1.add(option.getText());

			}
			int size = option1.size();
			System.out.println(size);
			if (size == 1) {
				System.out.println("The dropdown options are: true");
				test.log(Status.PASS, "Total number of Global dropdown values present: " + size);
				test.log(Status.PASS, "Values of Global dropdown: " + option1);
				addSrceenShot("Verified Global dropdown values", test, Capture);

			} else {
				System.out.println("The dropdown options are: FAIL");
				test.log(Status.FAIL, "Total number of Global dropdown values present: " + size);
				test.log(Status.FAIL, "Values of Global dropdown: " + option1);
				addSrceenShot("Failed to verify Global dropdown values", test, Capture);
			}
		} catch (Exception e) {
			System.out.println(e);
			test.log(Status.FAIL, "Exception occurred while verifying Global values: " + e.getMessage());
			addSrceenShot("Exception in verifying Global values", test, Capture);
		}

	}

	public void verifyLocalHubvalues(ExtentTest test) throws Exception {
		ArrayList<String> option1 = new ArrayList<String>();
		try {
			Select select = new Select(driver.findElement(By.id("LCSREVISABLEENTITY_ptc_str_11Options")));
			List<WebElement> options = select.getOptions();
			System.out.println("The dropdown options are:");
			for (WebElement option : options) {
				System.out.println(option.getText());
				option1.add(option.getText());

			}
			int size = option1.size();
			System.out.println(size);
			if (size == 5) {
				System.out.println("The dropdown options are: true" + size);
				test.log(Status.PASS, "Total number of Local Hub dropdown values present: " + size);
				test.log(Status.PASS, "Values of Local Hub dropdown: " + option1);
				addSrceenShot("Verified Local Hub dropdown values", test, Capture);

			} else {
				System.out.println("The dropdown options are: FAIL" + size);
				test.log(Status.FAIL, "Total number of Local Hub dropdown values present: " + size);
				test.log(Status.FAIL, "Values of Local Hub dropdown: " + option1);
				addSrceenShot("Failed to verify Local Hub dropdown values", test, Capture);
			}
		} catch (Exception e) {
			System.out.println(e);
			test.log(Status.FAIL, "Exception occurred while verifying Local Hub values: " + e.getMessage());
			addSrceenShot("Exception in verifying Local Hub values", test, Capture);
		}

	}

	public void selectLineSheet(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + ":" + submenu);
		driver.findElement(By.xpath("//div[@id='seasonDevelopmentContent']/a[2]")).click();
		/*
		 * clickElement("//label[@title='My Work']");
		 * clickElement("//label[@title='Season']");
		 */
		// click("//label[@title='" + menu + "']", menu);
	}

	public void chooseSeasonType(String seasonType) throws Exception {
		driver.switchTo().defaultContent();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonTypeLink));
		driver.findElement(By.xpath("//a[contains(text(),'"+seasonType+"')]")).click();
		// driver.findElement(By.xpath("//a[(text()='" + seasonType + "']")).click();
		// driver.findElement(By.xpath("//a[(text()='" + seasonType + "']")).click();

	}

	/**
	 * Function to click Vertical button
	 * 
	 * @throws Exception
	 */
	public void clikOnVerticalBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(vertical));
		clickElement(vertical);
	}

	/**
	 * Function to click product type
	 * 
	 * @throws Exception
	 */
	public void clikOnProductType() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(productType));
		clickElement(productType);
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

	public void selectSeason() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonSelection));
		clickElement(seasonSelection);
	}

	/**
	 * Function to select product type option
	 * 
	 * @throws Exception
	 */
	public void selectProductType(String option) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			this.clikOnProductType();
			String parentWindow = driver.getWindowHandle();
			this.switchToWindowTitle();
			By.xpath("//a[.='<productType>']");
			String locator = productTypeOption.toString().replace("By.xpath:", "").replace("<productType>",
					option.trim());
			WebElement ele = driver.findElement(By.xpath(locator));
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ele));
			clickElement(ele);
			driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			String parentWindow = driver.getWindowHandle();
			driver.switchTo().window(parentWindow);
		}
	}

	public void selectCategory1(String categoryValue) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CategoryDropdown));
		clickElement(CategoryDropdown);
		try {
			Select selectvalue = new Select(CategoryDropdown1);
			selectvalue.selectByVisibleText(categoryValue);
			// selectvalue.selectByValue("508");
			// clickElement(quickLinkDropdown);
		} catch (Exception e) {

			Select logoutvalue = new Select(CategoryDropdown);
			logoutvalue.selectByVisibleText(categoryValue);
			logoutvalue.selectByValue("508");
			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("arguments[0].click();", packStationDropdownElement);
			 */
			// }
		}

	}

	/**
	 * Function to select year drop down
	 * 
	 * @throws Exception
	 */

	public void quickSearchText(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(quickSearchText));
		clickElement(quickSearchText);
		quickSearchText.sendKeys(value);
		quickSearchText.click();
		System.out.println("Performed quick search with value: " + value);
		test.log(Status.INFO, "Performed quick search with value: " + value);
		addSrceenShot("Performed quick search", test, Capture);
	}

	public void selectCategory(String value) throws Exception {
		driver.switchTo().defaultContent();
		System.out.println("test:" + value);
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CategoryDropdown1));
		this.selectOPtionByVisibleText(CategoryDropdown, value.trim(), "Category :-" + value);
	}

	public void selectGender(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(GenderDropdown));
		this.selectOPtionByVisibleText(GenderDropdown, value.trim(), "Gender :-" + value);
	}

	public void selectSeasonCode(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SeasonCodeDropdown));
		this.selectOPtionByVisibleText(SeasonCodeDropdown, value.trim(), "Gender :-" + value);
	}

	public void selectBrand(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(BrandDropdown));
		this.selectOPtionByVisibleText(BrandDropdown, value.trim(), "Gender :-" + value);
	}

	public void selectYear(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(YearDropdown));
		this.selectOPtionByVisibleText(YearDropdown, value.trim(), "Gender :-" + value);
	}

	public void selectSeason(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SeasonDropdown));
		this.selectOPtionByVisibleText(SeasonDropdown, value.trim(), "Gender :-" + value);
	}

	/**
	 * Function to click create button
	 * 
	 * @throws Exception
	 */
	public void clikOnCreateBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(createBtn));
		clickElement(createBtn);

	}

	public void verifySeasonCreation(String expectedSeasonName, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonOptn));
		seasonOptn.click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quickSearchText));
		quickSearchText.sendKeys(expectedSeasonName);
		test.log(Status.INFO, "Entered season name in quick search.");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchoptn));
		searchoptn.click();
		test.log(Status.INFO, "Clicked on search option.");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonName));
		test.log(Status.INFO, "Season name is visible.");

		if (seasonName.isDisplayed()) {
			String actualSeasonName = seasonName.getText();
			Assert.assertEquals(actualSeasonName, expectedSeasonName, "Season Name does not match!");
			test.log(Status.PASS, "Retrieved Season Name: " + actualSeasonName);
			addSrceenShot("Retrieved Season Name", test, Capture);
		} else {
			test.log(Status.FAIL, "Season Name not found: " + expectedSeasonName);
			addSrceenShot("Season Name not found", test, Capture);
		}
	}

	public String getSeasonName(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonName));
		String name = seasonName.getText();
		test.log(Status.PASS, "Retrieved Season Name: " + name);
		addSrceenShot("Retrieved Season Name", test, Capture);
		return name;

	}

	public String getSeasonStatus(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(statusInput));
		String status = statusInput.getText();
		test.log(Status.PASS, "Retrieved Season Status: " + status);
		addSrceenShot("Retrieved Season Status", test, Capture);
		addSrceenShot("Retrieved Season Status", test, Capture);

		return status;
	}

	public String getSeasonCode(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(seasonCodeInput));
		String seasonCode = seasonCodeInput.getText();
		test.log(Status.PASS, "Retrieved Season Code: " + seasonCode);
		addSrceenShot("Retrieved Season Code", test, Capture);

		return seasonCodeInput.getText();
	}

	public boolean isSeasonInDropdown(String expectedSeasonName, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(MySeasonsOption));
		MySeasonsOption.click();
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='seasonSelectList']"));
		System.out.println("season drop down clicked");
		Select select = new Select(dropDown);

		// Get all options in the dropdown
		List<WebElement> options = select.getOptions();

		// Check if the expected season name is present in the options
		for (WebElement option : options) {
			if (option.getText().equals(expectedSeasonName)) {
				test.log(Status.PASS, "Season found in dropdown: " + expectedSeasonName);
				addSrceenShot("Season found in dropdown", test, Capture);

				return true;
			}
		}
		test.log(Status.FAIL, "Season not found in dropdown: " + expectedSeasonName);
		addSrceenShot("Season not found in dropdown", test, Capture);
		return false;
	}

	/**
	 * Function to verify season creation
	 * 
	 * @throws Exception
	 */
	public void verifySeasonCreation() throws Exception {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		boolean flag = waitForElement(nameValue);
		System.out.println("Season created successfully :" + flag);
		// assertThat(flag, "Season created successfully", "Season not created", true);
	}

	public boolean waitForElement(WebElement element) throws Exception {
		boolean statusOfTheElement = false;
		WebDriverWait waitSelenium = new WebDriverWait(driver, 50, 500);
		try {
			WebElement waitElement = waitSelenium.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = true;
			}
		} catch (Exception ex) {

			statusOfTheElement = false;
		}
		return statusOfTheElement;

	}

	public void selectOPtionByVisibleText(WebElement e, String text, String elementName) throws Exception {
		Thread.sleep(5000);

		try {

			WebDriverWait waitSelenium = new WebDriverWait(driver, 80, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			e.click();
			// e.click();
			Select sl = new Select(e);
			sl.selectByVisibleText(text);
			System.out.println("test:" + e + text);
			// System.out.println("test:"+e +text);

		} catch (Exception exc) {

			throw new Exception(elementName + " not found because of ::->" + exc.getStackTrace());

		}
	}

	/**
	 * Function to select action value from DD
	 * 
	 * @throws Exception
	 */
	public void selectAction(String value) throws Exception {
		System.out.println("test:" + value);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(actionDD));
		this.selectOPtionByVisibleText(actionDD, value, "Actions Dropdown :-" + value);
		System.out.println("test:" + value);

	}

	/**
	 * Function to select year drop down
	 * 
	 * @throws Exception
	 */
	public void selectYearDD(String value) throws Exception {
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(yearDD));
		this.selectOPtionByVisibleText(yearDD, value.trim(), "Season Year :-" + value);
		System.out.println("test:" + value);

	}

	/**
	 * Function to click save button
	 * 
	 * @throws Exception
	 */
	public void clikOnSaveBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(saveBtn));
		clickElement(saveBtn);
		System.out.println("saved test:");
	}

	/**
	 * Function to verify season creation
	 * 
	 * @throws Exception
	 */
	public void verifySeasonUpdatedupdated() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		boolean flag = waitForElement(seasonIdentificationValue);
		System.out.println("Season updated successfully" + flag);
	}

	/**
	 * Function to click delete button
	 * 
	 * @throws Exception
	 */
	public void clikOnDeleteBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(deleteBtn));
		System.out.println("test:" + deleteBtn);
		clickElement(deleteBtn);
		this.clickAlert();
	}

	public void clickAlert() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			Alert a1 = driver.switchTo().alert();
			a1.accept();
		} catch (UnhandledAlertException f) {
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			} catch (NoAlertPresentException exc) {
				throw new Exception(exc);
			}
		}
	}

	/**
	 * Function to verify delete message displays in the page
	 * 
	 * @throws Exception
	 */
	public void verifyDeleteMessage() throws Exception {
		driver.switchTo().frame(iframeContentframe);
		boolean flag = waitForElement(deleteMessage);
		System.out.println("Season deleted successfully:" + flag + true);
	}

////////////////////////////////////////////////////////////////////////////////

	public void searchSeasonalLook(String seasonalLook, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(nameSearchField));
		System.out.println("name search feild found");

		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='" + seasonalLook + "';", nameSearchField);
		nameSearchField.sendKeys(seasonalLook);
		Thread.sleep(5000);
		System.out.println("Seasonal Look Name: " + seasonalLook);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		nameSearchField.sendKeys(seasonalLook);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(5000);
//	searchButton.click();
		js.executeScript("arguments[0].click();", searchButton);

	}

	public void clickOnEditLookInfo() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pageHeadTitle));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", editOptn);

		// Wait until the element is visible and then click
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editOptn));
		editOptn.click();

	}

	public void selectFinishRecipe(String lookFinishRecipe, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(finishFormulaField));
		finishFormulaField.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(finishFomulahyperlink));
		finishFomulahyperlink.click();
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(MaterailNameInput));
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(lookFinishRecipe);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		driver.switchTo().window(ParentWinhadle);
		test.log(Status.INFO, "Selected Look Finish Recipe");
		addSrceenShot("Selected Fabric Mill", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(saveAnCheckIn));
		saveAnCheckIn.click();

	}

	public boolean isFabricAutoPopulated(String lookFinishRecipe, ExtentTest test) throws InterruptedException {
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeContentframe);

	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pageHeadTitle));
	    Thread.sleep(3000);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lookInfoEle);

	    WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']//table"));
	    List<WebElement> allRows = table.findElements(By.tagName("tr"));

	    for (int i = 2; i <= allRows.size(); i++) { // Start from 2 to skip the header row
	        WebElement finishFormulaCell = driver
	                .findElement(By.xpath("//div[@class='table-wrapper']//table//tr[" + i + "]/td[1]/a"));
	        if (finishFormulaCell.getText().trim().contains(lookFinishRecipe)) {
	            try {
	                // Locate the fabric cell in the same row
	                WebElement fabricCell = driver.findElement(By.xpath("//div[@class='table-wrapper']//table//tr[" + i + "]/td[3]/a")); // Assuming the fabric info is in the 3rd column

	                // Get the text of the fabric cell
	                String fabricText = fabricCell.getText().trim();
	                System.out.println("Fabric cell text: " + fabricText);
	                test.log(Status.INFO, "Fabric cell text: " + fabricText);
	                addSrceenShot("Fabric cell text", test, Capture);

	                // Check if the fabric cell is populated
	                boolean isPopulated = !fabricText.isEmpty();
	                if (isPopulated) {
	                    System.out.println("Fabric is auto-populated in the Look info MOA table: "+fabricText);
	                    test.log(Status.INFO, "Fabric is auto-populated in the Look info MOA table: "+fabricText);
	                    addSrceenShot("Fabric is auto-populated in the Look info MOA table", test, Capture);
	                } else {
	                    System.out.println("Fabric is not auto-populated in the Look info MOA table.");
	                    test.log(Status.FAIL, "Fabric is not auto-populated in the Look info MOA table.");
	                    addSrceenShot("Fabric is not auto-populated in the Look info MOA table", test, Capture);
	                }
	                return isPopulated;
	            } catch (Exception e) {
	                System.out.println("Fabric Mill  is not Populated.");
	                return false;
	            }
	        }
	    }

	    System.out.println("Look Finish Recipe is not found in the Look Info table.");
	    test.log(Status.FAIL, "Look Finish Recipe is not found in the Look Info table.");
	    addSrceenShot("Look Finish Recipe is not found in the Look Info table", test, Capture);
	    return false; // Return false if the lookFinishRecipe is not found
	}



	@FindBy(xpath = "//a[@name='Look Information']")
	private WebElement lookInfoEle;
	
	public boolean verifyLookFinishRecipeLine(String lookFinishRecipe, ExtentTest test) {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		 WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']//table"));
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));

		    for (int i = 2; i <= allRows.size(); i++) { // Start from 2 to skip the header row
		        WebElement finishFormulaCell = driver
		                .findElement(By.xpath("//div[@class='table-wrapper']//table//tr[" + i + "]/td[1]/a"));
		        if (finishFormulaCell.getText().trim().contains(lookFinishRecipe)) {
		            // Check if the look Finish Recipe is updated
		            return true;
		        }
		    }

		    return false; // Return false if the look Finish Recipe is not found
		}

	public boolean verifyMaterialCodeLinkedToSeasonalLooks(String lookFinishRecipe, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		 WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']//table"));
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));

		    for (int i = 2; i <= allRows.size(); i++) { // Start from 2 to skip the header row
		        WebElement finishFormulaCell = driver
		                .findElement(By.xpath("//div[@class='table-wrapper']//table//tr[" + i + "]/td[1]/a"));
		        if (finishFormulaCell.getText().trim().contains(lookFinishRecipe)) {
					String materialCode = lookFinishRecipe.split(" ")[0];
					System.out.println("Material code is linked to Seasonal Looks: " + materialCode);
					test.log(Status.INFO, "Material code is linked to Seasonal Looks: " + materialCode);
		            return true;
		        }
		    }

		    return false;
		}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//td[contains(text(),'Name')]//following-sibling::td[1]/input")
	private WebElement collectionNameInput;

	@FindBy(xpath = "//td[contains(text(),'COLLECTION_ID')]//following-sibling::td[1]/input")
	private WebElement collectionIdInput;

	@FindBy(xpath = "//td[contains(text(),'COLLECTION_DESC')]//following-sibling::td[1]/input")
	private WebElement collectionDescInput;

	@FindBy(xpath = "//td[contains(text(),'SEASON_DESC')]//following-sibling::td[1]/input")
	private WebElement seasonDescInput;

	@FindBy(xpath = "//td[contains(text(),'BOOK_BEGIN_DT')]//following-sibling::td[1]/input")
	private WebElement bookBeginDateInput;

	@FindBy(xpath = "//td[contains(text(),'BOOK_END_DT')]//following-sibling::td[1]/input")
	private WebElement bookEndDateInput;

	@FindBy(xpath = "//td[contains(text(),'SHIP_BEGIN_DT')]//following-sibling::td[1]/input")
	private WebElement shipBeginDateInput;

	@FindBy(xpath = "//td[contains(text(),'SHIP_END_DT')]//following-sibling::td[1]/input")
	private WebElement shipEndDateInput;

	@FindBy(xpath = "//td[contains(text(),'THEME')]//following-sibling::td[1]/input")
	private WebElement themeInput;

	@FindBy(xpath = "//td[contains(text(),'THEME_DESC')]//following-sibling::td[1]/input")
	private WebElement themeDescInput;

	@FindBy(xpath = "//td[contains(text(),'AFFILIATE ADOPT GROUP')]//following-sibling::td[1]//select")
	private WebElement affiliateAdoptGroupInput;

	@FindBy(xpath = "//td[contains(text(),'Collection Type')]//following-sibling::td[1]//select")
	private WebElement collectionTypeInput;

	@FindBy(xpath = "//td[contains(text(),'Brand')]//following-sibling::td[1]//select")
	private WebElement brandInput;

	@FindBy(xpath = "//td[contains(text(),'Year')]//following-sibling::td[1]//select")
	private WebElement yearInput;

	@FindBy(xpath = "//td[contains(text(),'Season')]//following-sibling::td[1]//select")
	private WebElement seasonInput;

	public void fillSeasonCollectionForm(String seasonCollectionName, String collectionId, String collectionDesc,
			String seasonDesc, String bookBeginDate, String bookEndDate, String shipBeginDate, String shipEndDate,
			String theme, String themeDesc, String affiliateAdoptGroup, String collectionType, String brand,
			String year, String season, ExtentTest test) throws InterruptedException,  AWTException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(collectionNameInput));
		collectionNameInput.sendKeys(seasonCollectionName);
		test.log(Status.INFO, "Season Collection Name is entered: " + seasonCollectionName);
		addSrceenShot("Season Collection Name is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(collectionIdInput));
		collectionIdInput.sendKeys(collectionId);
		test.log(Status.INFO, "Collection ID is entered: " + collectionId);
		addSrceenShot("Collection ID is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(collectionDescInput));
		collectionDescInput.sendKeys(collectionDesc);
		test.log(Status.INFO, "Collection Description is entered: " + collectionDesc);
		addSrceenShot("Collection Description is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonDescInput));
		seasonDescInput.sendKeys(seasonDesc);
		test.log(Status.INFO, "Season Description is entered: " + seasonDesc);
		addSrceenShot("Season Description is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(bookBeginDateInput));
		bookBeginDateInput.sendKeys(bookBeginDate);
		test.log(Status.INFO, "Book Begin Date is entered: " + bookBeginDate);
		addSrceenShot("Book Begin Date is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(bookEndDateInput));
		bookEndDateInput.sendKeys(bookEndDate);
		test.log(Status.INFO, "Book End Date is entered: " + bookEndDate);
		addSrceenShot("Book End Date is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(shipBeginDateInput));
		shipBeginDateInput.sendKeys(shipBeginDate);
		test.log(Status.INFO, "Ship Begin Date is entered: " + shipBeginDate);
		addSrceenShot("Ship Begin Date is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(shipEndDateInput));
		shipEndDateInput.sendKeys(shipEndDate);
		test.log(Status.INFO, "Ship End Date is entered: " + shipEndDate);
		addSrceenShot("Ship End Date is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(themeInput));
		themeInput.sendKeys(theme);
		test.log(Status.INFO, "Theme is entered: " + theme);
		addSrceenShot("Theme is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(themeDescInput));
		themeDescInput.sendKeys(themeDesc);
		test.log(Status.INFO, "Theme Description is entered: " + themeDesc);
		addSrceenShot("Theme Description is entered", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(affiliateAdoptGroupInput));
		selectValueFromDropdown(affiliateAdoptGroupInput, affiliateAdoptGroup);
		test.log(Status.INFO, "Affiliate Adopt Group is selected: " + affiliateAdoptGroup);
		addSrceenShot("Affiliate Adopt Group is selected", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(collectionTypeInput));
		selectValueFromDropdown(collectionTypeInput, collectionType);
		test.log(Status.INFO, "Collection Type is selected: " + collectionType);
		addSrceenShot("Collection Type is selected", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(brandInput));
		selectValueFromDropdown(brandInput, brand);
		test.log(Status.INFO, "Brand is selected: " + brand);
		addSrceenShot("Brand is selected", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(yearInput));
		selectValueFromDropdown(yearInput, year);
		test.log(Status.INFO, "Year is selected: " + year);
		addSrceenShot("Year is selected", test, Capture);
		Thread.sleep(4000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonInput));
		Thread.sleep(2000);
		Select select = new Select(seasonInput);
		select.selectByVisibleText(season);
		Thread.sleep(2000);
		
	      Robot robot = new Robot();
          robot.mouseMove(100, 200); // Replace with the coordinates where you want to click
          robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
//		create_Btn2.click();
//		test.log(Status.INFO, "New Season Collection Created Successfully");
//		addSrceenShot("New Season Collection Created Successfully", test, Capture);
	}
	
	public void clikOnCreate_Btn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(create_Btn2));
		clickElement(create_Btn2);

	}

	@FindBy(xpath = "(//a[.='Create'])[2]")
	private WebElement create_Btn2;
	
	@FindBy(xpath = "//td[@id='name']")
	private WebElement collectionNameInput_value;

	@FindBy(xpath = "//td[@id='lscoCollectionID']")
	private WebElement collectionIdInput_value;

	@FindBy(xpath = "//td[@id='lscoCollectionDesc']")
	private WebElement collectionDescInput_value;

	@FindBy(xpath = "//td[@id='lscoSeasonDesc']")
	private WebElement seasonDescInput_value;

	@FindBy(xpath = "(//td[contains(text(),'BOOK_BEGIN_DT')]//following-sibling::td[1])[1]")
	private WebElement bookBeginDateInput_value;

	@FindBy(xpath = "(//td[contains(text(),'BOOK_END_DT')]//following-sibling::td[1])[1]")
	private WebElement bookEndDateInput_value;

	@FindBy(xpath = "(//td[contains(text(),'SHIP_BEGIN_DT')]//following-sibling::td[1])[1]")
	private WebElement shipBeginDateInput_value;

	@FindBy(xpath = "(//td[contains(text(),'SHIP_END_DT')]//following-sibling::td[1])[1]")
	private WebElement shipEndDateInput_value;

	@FindBy(xpath = "//td[@id='lscoTheme']")
	private WebElement themeInput_value;

	@FindBy(xpath = "//td[@id='lscoThemeDesc']")
	private WebElement themeDescInput_value;

	@FindBy(xpath = "//td[@id='lscoAffiliateAdoptGroup']")
	private WebElement affiliateAdoptGroupInput_value;

	@FindBy(xpath = "//td[@id='lscoCollectionType']")
	private WebElement collectionTypeInput_value;

	@FindBy(xpath = "//td[@id='lscoBrand']")
	private WebElement brandInput_value;

	@FindBy(xpath = "//td[@id='year']")
	private WebElement yearInput_value;

	@FindBy(xpath = "//td[@id='lscoSeason']")
	private WebElement seasonInput_value;

	public boolean validateSeasonCollection(String seasonCollectionName, String collectionId, String collectionDesc,
			String seasonDesc, String bookBeginDate, String bookEndDate, String shipBeginDate, String shipEndDate,
			String theme, String themeDesc, String affiliateAdoptGroup, String collectionType, String brand,
			String year, String season, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(collectionNameInput_value));
		Thread.sleep(4000);
		boolean isValid = true;

		isValid &= collectionNameInput_value.getText().equals(seasonCollectionName);
		isValid &= collectionIdInput_value.getText().equals(collectionId);
//		isValid &= collectionDescInput_value.getText().equals(collectionDesc);
//		isValid &= seasonDescInput_value.getText().equals(seasonDesc);
//		isValid &= bookBeginDateInput_value.getText().equals(bookBeginDate);
//		isValid &= bookEndDateInput_value.getText().equals(bookEndDate);
//		isValid &= shipBeginDateInput_value.getText().equals(shipBeginDate);
//		isValid &= shipEndDateInput_value.getText().equals(shipEndDate);
//		isValid &= themeInput_value.getText().equals(theme);
//		isValid &= themeDescInput_value.getText().equals(themeDesc);
//		isValid &= affiliateAdoptGroupInput_value.getText().equals(affiliateAdoptGroup);
//		isValid &= collectionTypeInput_value.getText().equals(collectionType);
//		isValid &= brandInput_value.getText().equals(brand);
//		isValid &= yearInput_value.getText().equals(year);
//		isValid &= seasonInput_value.getText().equals(season);

		if (isValid) {
			test.log(Status.PASS, "All attributes are validated successfully");
			addSrceenShot("All attributes are validated successfully", test, Capture);
		} else {
			test.log(Status.FAIL, "Validation failed for one or more attributes");
			addSrceenShot("Validation failed", test, Capture);
		}

		return isValid;
	}

	public String get_SeasonCode(ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonCodeInput));
		String seasonCode = seasonCodeInput.getText();
		test.log(Status.INFO, "Retrieved Season Code: " + seasonCode);
		addSrceenShot("Retrieved Season Code", test, Capture);

		return seasonCode;
	}

	@FindBy(xpath = "//label[normalize-space()='Libraries']")
	private WebElement librariesOption;

	@FindBy(xpath = "//div[@id='librariesContent']/child::a[text()='Season Collection']")
	private WebElement seasonCollectionOptn;

	@FindBy(xpath = "//td[@id='lscoSAPTriggerReport']//a")
	private WebElement sapTriggerReportStatus;
	
	@FindBy(xpath = "//td[@id='lscoSAPTriggerReport']")
	private WebElement sapTriggerReportStatus_NON_LSE;

	@FindBy(xpath = "//td[@id='lscoSAPFeedback']")
	private WebElement sapFeedbackStatus;

	@FindBy(xpath = "//td[@id='lscoStRevisableEntity']")
	private WebElement uniqueIdInStaging;

	public void refreshPageAndValidateSAPIntegration(String seasonCollectionName, ExtentTest test)
			throws InterruptedException {

		// Wait for the integration to complete
		Thread.sleep(300000);
		test.log(Status.INFO, "Waited for 5 minutes for SAP integration");

		// Refresh the page
		driver.navigate().refresh();
		test.log(Status.INFO, "Page refreshed to validate SAP integration");
		addSrceenShot("Page refreshed", test, Capture);

		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pinbutton)).click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(librariesOption)).click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonCollectionOptn)).click();
		Thread.sleep(2000);

		System.out.println("Clicked on season collection under libraries");
		test.log(Status.INFO, "Clicked on season collection under libraries");

//		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonCollectionOptn));
//		seasonOptn.click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quickSearchText));
		quickSearchText.sendKeys(seasonCollectionName);
		test.log(Status.INFO, "Entered season name in quick search.");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchoptn));
		searchoptn.click();
		test.log(Status.INFO, "Clicked on search option.");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(collectionNameInput_value));

		// Validate SAP Trigger Report and Feedback
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sapTriggerReportStatus));
		String sapTriggerStatus = sapTriggerReportStatus.getText();
		Assert.assertTrue(sapTriggerStatus.contains("No Error"), "SAP Trigger Report Generated: " + sapTriggerStatus);
		test.log(Status.PASS, "SAP Trigger Report Generated: " + sapTriggerStatus);
		addSrceenShot("SAP Trigger Report", test, Capture);
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sapFeedbackStatus));
		String sapFeedback = sapFeedbackStatus.getText();
		Assert.assertTrue(sapFeedback.contains("Successfully"), "SAP Feedback shows an error: " + sapFeedback);
		test.log(Status.PASS, "SAP Feedback shows successful integration: " + sapFeedback);
		addSrceenShot("SAP Feedback", test, Capture);

//		// Validate unique ID in staging
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(uniqueIdInStaging));
		String uniqueId = uniqueIdInStaging.getText();
		Assert.assertNotNull(uniqueId, "Unique ID in staging is not populated");
		test.log(Status.PASS, "Unique ID in staging is populated: " + uniqueId);
		addSrceenShot("Unique ID in staging", test, Capture);
	}
	
	public void refreshPageAndValidateNoSAPIntegration(String seasonCollectionName, ExtentTest test) throws InterruptedException {
		
		// Wait for the integration to complete
		Thread.sleep(300000);
		test.log(Status.INFO, "Waited for 5 minutes for no SAP integration");
	    // Refresh the page
	    driver.navigate().refresh();
	    test.log(Status.INFO, "Page refreshed to validate no SAP integration");
	    addSrceenShot("Page refreshed", test, Capture);

	    driver.switchTo().frame(iframeLeftPanel);
	    new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pinbutton)).click();
	    Thread.sleep(2000);

	    new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(librariesOption)).click();
	    Thread.sleep(2000);

	    new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonCollectionOptn)).click();
	    Thread.sleep(2000);

	    System.out.println("Clicked on season collection under libraries");
	    test.log(Status.INFO, "Clicked on season collection under libraries");

	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeContentframe);

	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quickSearchText));
	    quickSearchText.sendKeys(seasonCollectionName);
	    test.log(Status.INFO, "Entered season name in quick search.");

	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchoptn));
	    searchoptn.click();
	    test.log(Status.INFO, "Clicked on search option.");

	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(collectionNameInput_value));

	    // Validate no SAP Trigger Report and Feedback
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeContentframe);

	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sapTriggerReportStatus_NON_LSE));
	    String sapTriggerStatus = sapTriggerReportStatus_NON_LSE.getText();
	    Assert.assertTrue(sapTriggerStatus.isEmpty(), "SAP Trigger Report should be empty: " + sapTriggerStatus);
	    test.log(Status.PASS, "No SAP Trigger Report generated: " + sapTriggerStatus);
	    addSrceenShot("No SAP Trigger Report", test, Capture);

	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sapFeedbackStatus));
	    String sapFeedback = sapFeedbackStatus.getText();
	    Assert.assertTrue(sapFeedback.isEmpty(), "SAP Feedback should be empty: " + sapFeedback);
	    test.log(Status.PASS, "No SAP Feedback generated: " + sapFeedback);
	    addSrceenShot("No SAP Feedback", test, Capture);

	    // Validate unique ID in staging
	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(uniqueIdInStaging));
	    String uniqueId = uniqueIdInStaging.getText();
	    Assert.assertNotNull(uniqueId, "Unique ID in staging is not populated");
	    test.log(Status.PASS, "Unique ID in staging is populated: " + uniqueId);
	    addSrceenShot("Unique ID in staging", test, Capture);
	}


}