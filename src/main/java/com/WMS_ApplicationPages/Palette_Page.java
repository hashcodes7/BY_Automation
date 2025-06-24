package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Palette_Page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Palette_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement Loactors------------------------------------------------------
	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//label[contains(text(),'My Seasons')]")
	private WebElement Myseason;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement SeasonsDropdown;

	@FindBy(xpath = "//div[@id='seasonConceptContent']/a[3]")
	private WebElement palettemenu;

	@FindBy(xpath = "//td/span[@class='LABEL']/following-sibling::select")
	private WebElement Actionsdropdown;

	@FindBy(xpath = "//a[@id='VR:com.ptc.core.meta.type.mgmt.server.impl.WTTypeDefinition:2715699555_link']")
	private WebElement heatherssubmenu;

//	--------------------------------------------------

	@FindBy(xpath = "//a[@id='FilterButton']//img[@align='absmiddle']")
	public WebElement createNewFilterIcon;

	@FindBy(xpath = "//input[@id='displayName']")
	public WebElement filterNameInput;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	public WebElement createButton;

	@FindBy(xpath = "//input[@id='LCSCOLOR_ptc_str_3']")
	public WebElement textBoxLocator;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	public WebElement addButtonLocator;

	@FindBy(xpath = "//a[normalize-space()='Update']")
	public WebElement updateButton;

	@FindBy(xpath = "//a[normalize-space()='Return']")
	public WebElement returnButton;

	@FindBy(xpath = "//select[@id='filterId']")
	public WebElement filtersDropdown;

	@FindBy(xpath = "//select[@id='filterId']/option")
	public WebElement searchCriteriaContainer;

	@FindBy(xpath = "//select[@id='filterId']/option")
	private List<WebElement> dropdownItems;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newBtn;

	@FindBy(xpath = "//select[@id='ptc_verRef_1']")
	private WebElement seasondropdown;

	@FindBy(xpath = "//input[@id='ptc_str_1']")
	private WebElement name;

	@FindBy(xpath = "//select[@id='ptc_str_6']")
	private WebElement prodCat1;

	@FindBy(xpath = "//select[@id='ptc_str_7']")
	private WebElement prodCat2;

	@FindBy(xpath = "//select[@id='ptc_str_2']")
	private WebElement brand;

	@FindBy(xpath = "//select[@id='ptc_str_3']")
	private WebElement capsule;

	@FindBy(xpath = "//select[@id='ptc_str_4']")
	private WebElement category;

	@FindBy(xpath = "//select[@id='ptc_str_5']")
	private WebElement gender;

	@FindBy(xpath = "//select[@id='ptc_str_8']")
	private WebElement reverseSeason;

	@FindBy(xpath = "//a[.='Create']")
	private WebElement createBtn;

	@FindBy(xpath = "//span[@class='PAGEHEADINGTITLE']/child::a")
	private WebElement newPalettePageElement;

	String currentTest;

	private boolean Capture;

	public void clickCreateNewFilterIcon() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(createNewFilterIcon));
		clickElement(createNewFilterIcon);

	}

	// Method to enter all data to create a new filter
	public void enterFilterData(String value) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filterNameInput));
		filterNameInput.sendKeys(value);

	}

	// Method to click on the "Create" button
	public void clickCreateButton() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(createButton));
		clickElement(createButton);

	}

	public void addToFilters(String attributeValue, String colorCodeNumber) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		WebElement staticDropDown = driver.findElement(By.xpath("//select[@name='attributeSelect']"));

		Select selectvalue = new Select(staticDropDown);
		selectvalue.selectByVisibleText(attributeValue);

		WebElement colorCodeInput = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		colorCodeInput.sendKeys(colorCodeNumber);

		WebElement addButton = driver.findElement(By.xpath("//a[normalize-space()='Add']"));
		addButton.click();
	}

	public void clickUpdateButton() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(updateButton));
		clickElement(updateButton);

	}

	public void clickReturnButton() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(returnButton));
		clickElement(returnButton);

	}

	public boolean isFilterPresentInSearchCriteria(String inputName, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			test.log(Status.INFO, "Switched to iframe successfully.");

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(filtersDropdown));
			filtersDropdown.click();
			test.log(Status.INFO, "Clicked on filters dropdown.");

			for (WebElement item : dropdownItems) {
				if (item.getText().contains(inputName)) {
					test.log(Status.PASS, "Found filter: " + inputName);
					return true;
				}
			}
			test.log(Status.INFO, "Filter not found: " + inputName);
			return false;
		} catch (Exception e) {
			test.log(Status.FAIL, "Error while verifying filter in search criteria: " + e.getMessage());
			return false;
		}
	}

	public void clikOnNewBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newBtn));
		clickElement(newBtn);
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

	public void selectSeason(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(seasondropdown));
		this.selectOPtionByVisibleText(seasondropdown, value.trim(), "Season :-" + value);
		test.log(Status.INFO, "Selected Season: " + value);
		addSrceenShot("Selected Season", test, Capture);
	}

	public void selectProdCat1(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(prodCat1));
		this.selectOPtionByVisibleText(prodCat1, value.trim(), "prodCat1 :-" + value);
		test.log(Status.INFO, "Selected Product Category 1: " + value);
		addSrceenShot("Selected Product Category 1", test, Capture);
	}

	public void selectProdCat2(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(prodCat2));
		this.selectOPtionByVisibleText(prodCat2, value.trim(), "prodCat2 :-" + value);
		test.log(Status.INFO, "Selected Product Category 2: " + value);
		addSrceenShot("Selected Product Category 2", test, Capture);
	}

	public void selectBrand(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(brand));
		this.selectOPtionByVisibleText(brand, value.trim(), "brand :-" + value);
		test.log(Status.INFO, "Selected Brand: " + value);
		addSrceenShot("Selected Brand", test, Capture);
	}

	public void selectCapsule(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(capsule));
		this.selectOPtionByVisibleText(capsule, value.trim(), "capsule :-" + value);
		test.log(Status.INFO, "Selected Capsule: " + value);
		addSrceenShot("Selected Capsule", test, Capture);
	}

	public void selectCategory(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(category));
		this.selectOPtionByVisibleText(category, value.trim(), "category :-" + value);
		test.log(Status.INFO, "Selected Category: " + value);
		addSrceenShot("Selected Category", test, Capture);
	}

	public void selectGender(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(gender));
		this.selectOPtionByVisibleText(gender, value.trim(), "gender :-" + value);
		test.log(Status.PASS, "Selected Gender: " + value);
		addSrceenShot("Selected Gender", test, Capture);
	}

	public void selectreverseSeason(String value, ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(reverseSeason));
		this.selectOPtionByVisibleText(reverseSeason, value.trim(), "reverseSeason :-" + value);
		test.log(Status.INFO, "Selected Reverse Season: " + value);
		addSrceenShot("Selected Reverse Season", test, Capture);
	}

	public void enterName(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(name));
		clickElement(name);
		name.sendKeys(value);
		name.click();
		test.log(Status.INFO, "Entered Name: " + value);
		addSrceenShot("Entered Name", test, Capture);
	}

	public void clikOnCreateBtn(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(createBtn));
		clickElement(createBtn);
		test.log(Status.INFO, "Clicked on Create button");
		addSrceenShot("Clicked on Create button", test, Capture);
	}

	public boolean isNewPalettePageDisplayed(ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newPalettePageElement));

			String pageText = newPalettePageElement.getText();

			test.log(Status.PASS, "New Palette Page is displayed with text: " + pageText);
			addSrceenShot("New Palette Page is displayed", test, Capture);

			return true;
		} catch (Exception e) {
			test.log(Status.FAIL, "New Palette Page is not displayed: " + e.getMessage());
			addSrceenShot("New Palette Page is not displayed", test, Capture);
			return false;
		}
	}

//	Method related to webPage------------------------------------------------------

	public void SeasonDropdown(String season) throws InterruptedException {
		selectValueFromDropdown(SeasonsDropdown, season);

	}

	public void palettemenu() throws InterruptedException {
		palettemenu.click();
	}

	public void action_DD(String Action_value) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Select select = new Select(Actionsdropdown);
		select.selectByValue(Action_value);

	}

	public void heathers() throws InterruptedException {
		heatherssubmenu.click();
	}

//	-----------------------------------------------------------------------------------------------------------
//	P2 scripts------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//td[@class='PAGEHEADINGTEXT']/select")
	private WebElement Actions;

	@FindBy(xpath = "//td[contains(text(),'LS&Co. Artwork Code')]/following-sibling::td/input")
	private WebElement ArtWork_code_Textbox;

	@FindBy(xpath = "(//td[contains(text(),'LS&Co. Artwork')]/following-sibling::td/input)[1]")
	private WebElement ArtWork_name_Textbox;

	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement SaveButton;

	@FindBy(xpath = "//td[@id='lscoArtworkCode']")
	private WebElement Updated_ArtworkCode;

	@FindBy(xpath = "//td[@id='lscoArtwork']")
	private WebElement Updated_ArtworkName;

	@FindBy(xpath = "//input[@id='imageFile']")
	private WebElement Choose_File;

	@FindBy(xpath = "//img[@id='thumbnail']")
	private WebElement thumbnail;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	public void Click_PrintsandPatterns_color(String colorname, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		List<WebElement> colorlist = driver.findElements(By.xpath("//div[@class='table-wrapper']//tr/td[3]/a"));
		for (WebElement color : colorlist) {
			if (color.getText().contains(colorname)) {
				System.out.println("color selected is: " + color.getText());
				test.log(Status.INFO, " color selected is:" + color.getText());
				color.click();
				break;
			}
		}

	}

	public void Click_SeasonalLook_color(String colorname, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		List<WebElement> colorlist = driver.findElements(By.xpath("//div[@class='table-wrapper']//tr/td[3]/a"));
		for (WebElement color : colorlist) {
			if (color.getText().contains(colorname)) {
				System.out.println("color selected is: " + color.getText());
				test.log(Status.INFO, " color selected is:" + color.getText());
				color.click();
				break;
			}
		}

	}

	public void NavigateTo_updatecolorPage() throws InterruptedException {

//		Set<String> allWindowHandles = driver.getWindowHandles();
//		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
//		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Actions));
		selectValueFromDropdown(Actions, "Update");
	}

	public void update_colorAttributes(String artworkcode, String artworkname, ExtentTest test)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ArtWork_code_Textbox));
		ArtWork_code_Textbox.clear();
		ArtWork_code_Textbox.sendKeys(artworkcode);
		test.log(Status.INFO, "Artwork code value Entered: " + artworkcode);
		Thread.sleep(1000);
		ArtWork_name_Textbox.clear();
		ArtWork_name_Textbox.sendKeys(artworkname);
		test.log(Status.INFO, "Artwork name value Entered: " + artworkname);
		Thread.sleep(1000);
		SaveButton.click();
		Thread.sleep(1000);

	}

	public void validate_UpdatedAttributes(String artworkcode, String artworkname, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (Updated_ArtworkCode.getText().equals(artworkcode)) {
			System.out.println("Artwork code value is updated and the value is: " + Updated_ArtworkCode.getText());
			test.log(Status.INFO, "Artwork code value is updated and the value is: " + Updated_ArtworkCode.getText());
			addSrceenShot("Artwork code value is updated and the value is: " + Updated_ArtworkCode.getText(), test,
					Capture);
		} else {
			System.out.println("Artwork code value did Not updated ");
			test.log(Status.FAIL, "Artwork code value did not updated ");
			addSrceenShot("Artwork code value did not updated ", test, Capture);
		}

		if (Updated_ArtworkName.getText().equals(artworkname)) {
			System.out.println("Artwork name  is updated and the value is: " + Updated_ArtworkName.getText());
			test.log(Status.INFO, "Artwork name  is updated and the value is: " + Updated_ArtworkName.getText());
			addSrceenShot("Artwork name is updated and the value is: " + Updated_ArtworkName.getText(), test, Capture);
		} else {
			System.out.println("Artwork name value did not updated ");
			test.log(Status.FAIL, "Artwork name value did not updated ");
			addSrceenShot("Artwork name value did not updated ", test, Capture);
		}

	}

	public String UploadThumbnail(String filepath, ExtentTest test) throws InterruptedException {
		String ExpectedThumbnail = "";
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Choose_File));

		Choose_File.sendKeys(filepath);
		Thread.sleep(2000);

		SaveButton.click();
		System.out.println("File is Uploaded");
		test.log(Status.INFO, "File is Uploaded");
		Thread.sleep(3000);

		ExpectedThumbnail = thumbnail.getAttribute("src");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		return ExpectedThumbnail;
	}

	@FindBy(xpath = "//div[@id='color']//div[2]/a")
	private WebElement colorlink;

	@FindBy(xpath = "//a[@id='thumbnailViewer']/img")
	private WebElement ActualThumbnail;

	public void Validate_thumbnailColor(String filename, String thumbnail, ExtentTest test)
			throws InterruptedException {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		List<WebElement> list = driver.findElements(By.xpath("//table[@id='productSKUCard']//tr/td/div"));
		for (WebElement ele : list) {
			if (ele.getAttribute("style").contains(filename)) {

				System.out.println("color thumbnail: " + thumbnail);
				test.log(Status.INFO, "color thumbnail: " + thumbnail);

				System.out.println("PC9 thumbnail: " + ele.getAttribute("style"));
				test.log(Status.INFO, "PC9 thumbnail: " + ele.getAttribute("style"));

				System.out.println(
						"Color Thumbnail contains filename : " + filename + " is present in colorway thumbnail");
				test.log(Status.INFO,
						"Color Thumbnail contains filename : " + filename + " is present in colorway thumbnail");
			}

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(colorlink));
		colorlink.click();

		if (thumbnail.contains(ActualThumbnail.getAttribute("src"))) {
			System.out.println(
					"Color Thumbnail  : " + ActualThumbnail.getAttribute("src") + " is present in colorway thumbnail");
			test.log(Status.INFO,
					"Color Thumbnail: " + ActualThumbnail.getAttribute("src") + " is present in colorway thumbnail");
			addSrceenShot(
					"Color Thumbnail: " + ActualThumbnail.getAttribute("src") + " is present in colorway thumbnail",
					test, Capture);
		}
	}

	/////////////////////////////////////////////////////////////// 30/10/2024

	@FindBy(xpath = "//a[@class='button' and text()='Create New Palette']")
	private WebElement createnewPalette;

	@FindBy(xpath = "//input[@id='ptc_str_1']")
	private WebElement Pallette_Name;

	@FindBy(xpath = "//a[@class='button' and text()='Create']")
	private WebElement Create_button;

	@FindBy(xpath = "//a[@class='HEADING2']")
	private WebElement NamePalette;

	public void Click_CreateNewPalette() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(createnewPalette));
		createnewPalette.click();
	}

	public void Fill_CreateNewPalette(String PaletteName) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Pallette_Name.sendKeys(PaletteName);
		Create_button.click();
		Thread.sleep(3000);

	}

	public void Validate_PaletteCreation(String PaletteName, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (NamePalette.getText().equalsIgnoreCase(PaletteName)) {
			System.out.println("The Palette created with name : " + NamePalette.getText());
			test.log(Status.INFO, "The Palette created with name : " + NamePalette.getText());
			addSrceenShot("The Palette created with name : " + NamePalette.getText(), test, Capture);
		}
	}

}
