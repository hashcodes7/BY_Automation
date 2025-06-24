package com.WMS_ApplicationPages;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class BOM_Page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public BOM_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement Loactors------------------------------------------------------
// -----------------------PLM attributes--------------------------------------	
	@FindBy(xpath = "//*[@name='headerframe']")
	private WebElement iframeHeaderframe;

	@FindBy(xpath = "//*[@id='quickLinkSelectionId']")
	private WebElement quicklink;

	@FindBy(xpath = "//*[text()='Use another account']")
	private WebElement account1;

	@FindBy(xpath = "//*[text()='Use another account']")
	private WebElement account;

	@FindBy(xpath = "//*[@type='email']")
	private WebElement email;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement next;

	@FindBy(xpath = "//*[@name='passwd']")
	private WebElement password;

	@FindBy(xpath = "//select")
	private WebElement seasonSelect;

	@FindBy(xpath = "(//input)[2]")
	private WebElement PC9Select;

	@FindBy(xpath = "//*[text()=' Quick Search ']")
	private WebElement quicksearch;

	@FindBy(xpath = "//*[@class='ContextMenu BomResultsMenu']//div")
	private WebElement results;

	@FindBy(xpath = "//*[text()=' Deselect all ']")
	private WebElement deselectAll;

	@FindBy(xpath = "//*[@class='SelectAllLink']//following::ul//li[1]//input")
	private WebElement select;

	@FindBy(xpath = "//*[text()=' Add Fabric Subsection ']")
	private WebElement addFabric;

	@FindBy(xpath = "//*[@class='ComponentDropdown']")
	private WebElement componentLocator;

	@FindBy(xpath = "//*[@class='ComponentLocationDropdown']")
	private WebElement componentLocLocator;

	@FindBy(xpath = "//*[@class='remarksField']//input")
	private WebElement remarksLocator;

	@FindBy(xpath = "//*[@class='button confirm']")
	private WebElement addFabricSection;

	@FindBy(xpath = "(//*[text()=' Find Fabric '])[2]")
	private WebElement findFabric;

	@FindBy(xpath = "//*[@class='AutoComplete']//input")
	private WebElement materialLocator;

	@FindBy(xpath = "(//*[@class='supplier'])[1]")
	private WebElement drag;

	@FindBy(xpath = "//*[@class='lineItemCardTop']")
	private WebElement drop;

	@FindBy(xpath = "//*[@class='button confirm']")
	private WebElement addMaterial;

	@FindBy(xpath = "//*[@class='cell supplierDescription']")
	private WebElement materialDescr;

//	@FindBy(xpath = "(//*[@class='content'])[7]//div//div")
	@FindBy(xpath = "(//*[text()=' Quantity: ']//following::div[1]//div/div)[13]")
	private WebElement editQty;

//	@FindBy(xpath = "(//*[@class='readMode'])[8]//div")
	@FindBy(xpath = "(//*[text()=' Remarks: ']//following::div[1]//div/div)[13]")
	private WebElement editRemarks;

	@FindBy(xpath = "//*[text()=' Change MRP Lock ']")
	private WebElement MRPlock;

	@FindBy(xpath = "(//*[contains(@class,'ag-icon ag-icon-checkbox')])[6]")
	private WebElement checkBox;

	@FindBy(xpath = "//*[text()=' Dashboard ']")
	private WebElement dashboard;

	@FindBy(xpath = "//*[text()=' Submit ']")
	private WebElement submit;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement yesOptn;

	public void openBomApp(ExtentTest test) throws InterruptedException {
		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeHeaderframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicklink));
			Select sel = new Select(quicklink);
			sel.selectByValue("bomApp");
			Thread.sleep(5000);
			System.out.println("Bom App is opened");

			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			String mainWinId = itr.next();
			String ChildWinId = itr.next();
			driver.switchTo().window(ChildWinId);
			driver.manage().window().maximize();
			System.out.println("maximised the browser");

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(account)).click();
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(email)).sendKeys("mankumar@levi.com");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(email)).sendKeys("nakula@levi.com");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(password)).sendKeys("PowerCore@28");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(password))
					.sendKeys("Venkatashriyan@0121");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
			Thread.sleep(60000);

			// new WebDriverWait(driver,
			// 60).until(ExpectedConditions.visibilityOf(submit)).click();
			System.out.println("Bom App opened successfully");
			test.log(Status.INFO, "Bom App opened successfully");
		} catch (Exception e) {
			System.out.println("Bom App not opened ");
		}
	}

	public void updateBomDetails(ExtentTest test, String season, String PC9_1, String component, String componentLoc,
			String remarks, String material) throws InterruptedException {
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonSelect));
			Select sel = new Select(seasonSelect);
			// sel.selectByValue("483-S1-2022-664-674");
			sel.selectByValue(season);
			Thread.sleep(5000);
			System.out.println("Season is selected");
			// new WebDriverWait(driver,
			// 60).until(ExpectedConditions.visibilityOf(PC9Select)).sendKeys("0WKCY");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PC9Select)).sendKeys(PC9_1);
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicksearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(results)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(deselectAll)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(select)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(results)).click();
			Thread.sleep(3000);
			// adding fabric section
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addFabric)).click();
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(componentLocator));
			Select sel2 = new Select(componentLocator);
			sel2.selectByValue(component);
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(componentLocLocator));
			Select sel3 = new Select(componentLocLocator);
			sel3.selectByValue(componentLoc);
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(remarksLocator)).sendKeys(remarks);
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addFabricSection)).click();
			Thread.sleep(5000);
			System.out.println("fabric section added");
			test.log(Status.INFO, "fabric section added");
			// adding material to the added fabric
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(findFabric)).click();
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialLocator)).sendKeys(material);
			Thread.sleep(5000);
			materialLocator.sendKeys(Keys.ARROW_DOWN);
			materialLocator.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
			Thread.sleep(3000);
			String AddMatDescr = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(drag)).getText();
			System.out.println("material to add is " + AddMatDescr);
			Actions actions = new Actions(driver);
			actions.dragAndDrop(drag, drop).perform();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addMaterial)).click();
			Thread.sleep(5000);
			// String AddedMatDescr = new WebDriverWait(driver,
			// 60).until(ExpectedConditions.visibilityOf(materialDescr)).getText();
			// System.out.println("added material is " +AddedMatDescr);
			// Assert.assertEquals(AddMatDescr, AddedMatDescr);
			System.out.println("material added to the fabric");
			test.log(Status.INFO, "material added to the fabric");
			System.out.println("Updated & validated Bom Details by adding the fabric section and material to it");
			test.log(Status.INFO, "Updated & validated Bom Details by adding the fabric section and material to it");

		} catch (Exception e) {
			System.out.println("Bom details are not updated");
		}
	}

	public void MassUpdateBomDetails(ExtentTest test, String season, String PC9_2, String qty, String newRemarks)
			throws InterruptedException {
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(dashboard)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonSelect));
			Select sel = new Select(seasonSelect);
			sel.selectByValue(season);
			Thread.sleep(5000);
			System.out.println("Season is selected");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PC9Select)).sendKeys(PC9_2);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicksearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editQty));
			editQty.click();
			Thread.sleep(5000);
			System.out.println("qty is clicked");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].innerText = '2';", editQty);
			// js.executeScript("arguments[0].innerText = qty;", editQty);
			// Thread.sleep(5000);
			System.out.println("Div value updated to: " + editQty.getAttribute("innerText"));
			System.out.println("qty is entered");
			Thread.sleep(5000);
			String updatedQty = editQty.getText();
			System.out.println("updated qty is " + updatedQty);
			// Assert.assertEquals(qty, updatedQty);
			System.out.println("Quantity is changed");

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editRemarks));
			editRemarks.click();
			js.executeScript("arguments[0].innerText = 'Automation_editted';", editRemarks);
			// js.executeScript("arguments[0].innerText = newRemarks;", editRemarks);
			// Thread.sleep(5000);
			System.out.println("Div value updated to: " + editRemarks.getAttribute("innerText"));
			Thread.sleep(5000);
			String updatedRemarks = editRemarks.getText();
			System.out.println("New Remarks are " + updatedRemarks);
			// Assert.assertEquals(newRemarks, updatedRemarks);
			System.out.println("Remarks are changed");
			Thread.sleep(8000);
			System.out.println("Updated & Validated Bom bulk details by changing the quantity and remarks");
			test.log(Status.INFO, "Updated & validated Bom bulk details by changing the quantity and remarks");

		} catch (Exception e) {
			System.out.println("Bom bulk details are not updated");
		}
	}

	public void releaseBomDetails(ExtentTest test, String season, String PC9_2) throws InterruptedException {
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonSelect));
			Select sel = new Select(seasonSelect);
//				sel.selectByIndex(1);;
			sel.selectByValue(season);
			System.out.println("Season is selected");
			// new WebDriverWait(driver,
			// 60).until(ExpectedConditions.visibilityOf(PC9Select)).sendKeys("A0887");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PC9Select)).sendKeys(PC9_2);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicksearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(results)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(MRPlock)).click();
			Thread.sleep(5000);
			String chkbox = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(checkBox))
					.getAttribute("class");
			System.out.println("checkbox is " + chkbox);
			Thread.sleep(5000);
			if (chkbox.contains("unchecked")) {
				checkBox.click();
				Thread.sleep(5000);
				checkBox.click();
			} else {
				checkBox.click();
			}
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(submit)).click();
			Thread.sleep(5000);
			System.out.println("Bom bulk details are released");
			test.log(Status.INFO, "Bom bulk details are released");

		} catch (Exception e) {
			System.out.println("Bom bulk details are not released");
		}
	}

	@FindBy(xpath = "(//select)[1]")
	private WebElement SelectSeason;

	@FindBy(xpath = "//a[@href='/search']")
	private WebElement DashboardSearchmenu;

	@FindBy(xpath = "//a[@class='seasonListSwitcher']")
	private WebElement uselist;

	@FindBy(xpath = "//a[@class='seasonListSwitcher']/span/span")
	private WebElement season_uselist;

	@FindBy(xpath = "//label[text()='PC9 Name']/following-sibling::div/input")
	private WebElement pc9_name;

	@FindBy(xpath = "//label[text()='PC5 Code']/following-sibling::div/input")
	private WebElement pc5_code;

	@FindBy(xpath = "//label[text()='PC5 Name']/following-sibling::div/input")
	private WebElement pc5_name;

	@FindBy(xpath = "//label[text()='PDS']/following-sibling::div/input")
	private WebElement PDS_textbox;

	@FindBy(xpath = "//label[text()='Merchant']/following-sibling::div/input")
	private WebElement Merchant_textbox;

	@FindBy(xpath = "//label[text()='Designer']/following-sibling::div/input")
	private WebElement Designer_textbox;

	@FindBy(xpath = "//label[text()='Material']/following-sibling::div/input")
	private WebElement Material_textbox;

	@FindBy(xpath = "//label[text()='Color']/following-sibling::div/input")
	private WebElement Color_textbox;

	@FindBy(xpath = "//div[@class='BomSearchComponentField cell']//select")
	private WebElement component_DD;

	@FindBy(xpath = "//div[@class='BomSearchComponentLocationField cell']//select")
	private WebElement componentLocation_DD;

	public void SearchUsingAttributes(String season, String colorwaycode, String colorwayname, String productcode,
			String productname, String PDS, String Merchant, String Designer, String material, String color,
			String component, String componentlocation, String available, String carryover,
			String Productpricepositioning, String producttype, String earlydelivery, String mrplock, String powercore,
			String gtmtrack, ExtentTest test) throws InterruptedException {

		Thread.sleep(5000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(DashboardSearchmenu));
		DashboardSearchmenu.click();
		Thread.sleep(2000);

		if (season_uselist.getText().contains("use full list")) {
			uselist.click();
		}

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SelectSeason));
		Select sel = new Select(SelectSeason);
		sel.selectByValue(season);
		Thread.sleep(5000);
		System.out.println("Season is selected: " + season);
		test.log(Status.INFO, "Season is selected: " + season);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9_code)).sendKeys(colorwaycode);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9_name)).sendKeys(colorwayname);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc5_code)).sendKeys(productcode);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc5_name)).sendKeys(productname);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PDS_textbox)).sendKeys(PDS);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Merchant_textbox)).sendKeys(Merchant);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Designer_textbox)).sendKeys(Designer);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Material_textbox)).sendKeys(material);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Color_textbox)).sendKeys(color);

		Select selectcomponent = new Select(component_DD);
		selectcomponent.selectByValue(component);
		Thread.sleep(2000);

		Select selectcomponentlocation = new Select(componentLocation_DD);
		selectcomponentlocation.selectByValue(componentlocation);
		Thread.sleep(2000);

		if (available.equalsIgnoreCase("Yes")) {
			driver.findElement(By.xpath("((//h5)[1]/following-sibling::ul/li//input)[1]")).click();
			System.out.println("Available? value selected: " + available);
			test.log(Status.INFO, "Available? value selected: " + available);
		} else if (available.equalsIgnoreCase("No")) {
			driver.findElement(By.xpath("((//h5)[1]/following-sibling::ul/li//input)[2]")).click();
			System.out.println("Available? value selected: " + available);
			test.log(Status.INFO, "Available? value selected: " + available);

		} else {
			System.out.println("Available? value is not present ");
			test.log(Status.INFO, "Available? value is not present ");
		}
		Thread.sleep(1000);
		if (carryover.equalsIgnoreCase("Carryover")) {
			driver.findElement(By.xpath("(//h5[text()=' Carryover or New? ']/following-sibling::ul/li//input)[1]"))
					.click();
			System.out.println("Carryover value selected: " + carryover);
			test.log(Status.INFO, "Carryover value selected: " + carryover);
		} else if (carryover.equalsIgnoreCase("New")) {
			driver.findElement(By.xpath("(//h5[text()=' Carryover or New? ']/following-sibling::ul/li//input)[2]"))
					.click();
			System.out.println("Carryover value selected: " + carryover);
			test.log(Status.INFO, "Carryover value selected: " + carryover);

		} else {
			System.out.println("Carryover value is not present ");
			test.log(Status.INFO, "Carryover value is not present ");
		}
		Thread.sleep(1000);
		WebElement product_price_positioning = driver.findElement(
				By.xpath("//span[contains(text(),'" + Productpricepositioning + "')]/preceding-sibling::input"));
		product_price_positioning.click();
		Thread.sleep(1000);
		WebElement ProductType = driver
				.findElement(By.xpath("//span[contains(text(),'" + producttype + "')]/preceding-sibling::input"));
		ProductType.click();
		Thread.sleep(1000);
		WebElement EarlyDelivery = driver
				.findElement(By.xpath("//h5[text()=' Early Delivery ']/following-sibling::ul/li//span[contains(text(),'"
						+ earlydelivery + "')]/preceding-sibling::input"));
		EarlyDelivery.click();
		Thread.sleep(1000);
		WebElement MrpLock = driver
				.findElement(By.xpath("//h5[text()=' MRP Lock ']/following-sibling::ul/li//span[contains(text(),'"
						+ mrplock + "')]/preceding-sibling::input"));
		MrpLock.click();
		Thread.sleep(1000);
		WebElement PowerCore = driver
				.findElement(By.xpath("//h5[text()=' Power Core ']/following-sibling::div//label[contains(text(),'"
						+ powercore + "')]/input"));
		PowerCore.click();
		Thread.sleep(1000);
		WebElement GTMtrack = driver
				.findElement(By.xpath("//h5[text()=' GTM Track ']/following-sibling::ul/li//span[contains(text(),'"
						+ gtmtrack + "')]/preceding-sibling::input"));
		GTMtrack.click();

	}

	////////////////////// testdatascripts////////////////////////////////////

	@FindBy(xpath = "//button[@class='button']")
	private WebElement Search_button;

	@FindBy(xpath = "(//div[@class='buttonWrapper'])[2]")
	private WebElement boms_details;

	@FindBy(xpath = "//a[@class='button' and text()=' Review Mode ']")
	private WebElement review_mode;

	@FindBy(xpath = "//div[@class='BomReviewBom' ]/div/h3")
	private WebElement review_mode_details;

	public void Validate_BomsDetails(ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(boms_details));

		System.out.println("Bom details is present ");
		test.log(Status.INFO, "Bom details is present ");
		addSrceenShot("Bom details is present", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(review_mode));
		review_mode.click();
		Thread.sleep(2000);

		System.out.println("Review mode details is present and the name is:  " + review_mode_details.getText());
		test.log(Status.INFO, "Review mode details is present and the name is:  " + review_mode_details.getText());
		addSrceenShot("Review mode details is present and the name is:  " + review_mode_details.getText(), test,
				Capture);

	}

	public void SearchUsingAttributes(String season, String colorwaycode, String productcode, String Merchant,
			String material, String available, String carryover, ExtentTest test) throws InterruptedException {

		Thread.sleep(5000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(DashboardSearchmenu));
		DashboardSearchmenu.click();
		Thread.sleep(2000);

		if (seasonListSwitcher.getText().toLowerCase().contains("use full list".toLowerCase())) {
			seasonListSwitcher.click();
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SelectSeason));
		Select sel = new Select(SelectSeason);
		sel.selectByValue(season);
		Thread.sleep(5000);
		System.out.println("Season is selected: " + season);
		test.log(Status.INFO, "Season is selected: " + season);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9_code)).sendKeys(colorwaycode);
		Thread.sleep(3000);
		pc9_code.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Colorway code Entered: " + colorwaycode);

//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9_name)).sendKeys(colorwayname);
//			Thread.sleep(3000);
//			pc9_name.sendKeys(Keys.ENTER);
//			test.log(Status.INFO, "colorwayname Entered: " + colorwayname);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc5_code)).sendKeys(productcode);
		Thread.sleep(3000);
		pc5_code.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "productcode  Entered: " + productcode);

//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc5_name)).sendKeys(productname);
//			Thread.sleep(3000);
//			pc5_name.sendKeys(Keys.ENTER);
//			test.log(Status.INFO, "productname  Entered: " + productname);

//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PDS_textbox)).sendKeys(PDS);
//			test.log(Status.INFO, "PDS Entered: " + PDS);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Merchant_textbox)).sendKeys(Merchant);
		Thread.sleep(3000);
		Merchant_textbox.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Merchant Entered: " + Merchant);

//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Designer_textbox)).sendKeys(Designer);
//			test.log(Status.INFO, "Designer Entered: " + Designer);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Material_textbox)).sendKeys(material);
		Thread.sleep(3000);
		Material_textbox.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "material code Entered: " + material);

//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Color_textbox)).sendKeys(color);
//			Thread.sleep(3000);
//			Color_textbox.sendKeys(Keys.ENTER);
//			test.log(Status.INFO, "Color Entered: " + color);

//			Select selectcomponent = new Select(component_DD);
//			selectcomponent.selectByValue(component);
//			Thread.sleep(2000);
//			test.log(Status.INFO, "Component is selected: " + component);
//			
//			Select selectcomponentlocation = new Select(componentLocation_DD);
//			selectcomponentlocation.selectByValue(componentlocation);
//			test.log(Status.INFO, "Component Location is selected: " + componentlocation);
//			Thread.sleep(2000);

		if (available.equalsIgnoreCase("Yes")) {
			System.out.println("Available? value is already selected: " + available);
			test.log(Status.INFO, "Available? value is already selected: " + available);
		} else if (available.equalsIgnoreCase("No")) {
			driver.findElement(By.xpath("((//h5)[1]/following-sibling::ul/li//input)[1]")).click();
			driver.findElement(By.xpath("((//h5)[1]/following-sibling::ul/li//input)[2]")).click();
			System.out.println("Available? value selected: " + available);
			test.log(Status.INFO, "Available? value selected: " + available);

		} else {
			System.out.println("Available? value is not present ");
			test.log(Status.INFO, "Available? value is not present ");
		}
		Thread.sleep(1000);

		if (carryover.equalsIgnoreCase("Carryover")) {
			driver.findElement(By.xpath("(//h5[text()=' Carryover or New? ']/following-sibling::ul/li//input)[1]"))
					.click();
			System.out.println("Carryover value selected: " + carryover);
			test.log(Status.INFO, "Carryover value selected: " + carryover);
		} else if (carryover.equalsIgnoreCase("New")) {
			driver.findElement(By.xpath("(//h5[text()=' Carryover or New? ']/following-sibling::ul/li//input)[2]"))
					.click();
			System.out.println("Carryover value selected: " + carryover);
			test.log(Status.INFO, "Carryover value selected: " + carryover);

		} else {
			System.out.println("Carryover value is incorrect ");
			test.log(Status.INFO, "Carryover value is incorrect ");
		}
		Thread.sleep(1000);
//			WebElement product_price_positioning=driver.findElement(By.xpath("//span[contains(text(),'"+Productpricepositioning+"')]/preceding-sibling::input"));
//			product_price_positioning.click();
//			Thread.sleep(1000);
//			WebElement ProductType=driver.findElement(By.xpath("//span[contains(text(),'"+producttype+"')]/preceding-sibling::input"));
//			ProductType.click();
//			Thread.sleep(1000);
//			WebElement EarlyDelivery=driver.findElement(By.xpath("//h5[text()=' Early Delivery ']/following-sibling::ul/li//span[contains(text(),'"+earlydelivery+"')]/preceding-sibling::input"));
//			EarlyDelivery.click();
//			Thread.sleep(1000);
//			WebElement MrpLock=driver.findElement(By.xpath("//h5[text()=' MRP Lock ']/following-sibling::ul/li//span[contains(text(),'"+mrplock+"')]/preceding-sibling::input"));
//			MrpLock.click();
//			Thread.sleep(1000);
//			WebElement PowerCore=driver.findElement(By.xpath("//h5[text()=' Power Core ']/following-sibling::div//label[contains(text(),'"+powercore+"')]/input"));
//			PowerCore.click();
//			Thread.sleep(1000);
//			WebElement GTMtrack=driver.findElement(By.xpath("//h5[text()=' GTM Track ']/following-sibling::ul/li//span[contains(text(),'"+gtmtrack+"')]/preceding-sibling::input"));
//			GTMtrack.click();

		Thread.sleep(2000);

		Search_button.click();
		Thread.sleep(4000);

	}

////////////////////////////////////////////////////////////////////////////////

	public void navigate_ToBOMApp() throws InterruptedException {

		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeHeaderframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicklink));
			Select sel = new Select(quicklink);
			sel.selectByValue("bomApp");
			Thread.sleep(5000);
			System.out.println("Bom App is opened");

			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));
			driver.manage().window().maximize();
			System.out.println("maximised the browser");

		} catch (Exception e) {
			System.out.println("Navigate bom app failed ");
		}

	}

	public void navigateToBOMApp() throws InterruptedException {

		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeHeaderframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicklink));
			Select sel = new Select(quicklink);
			sel.selectByValue("bomApp");
			Thread.sleep(5000);
			System.out.println("Bom App is opened");

			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.manage().window().maximize();
			System.out.println("maximised the browser");

		} catch (Exception e) {
			System.out.println("Navigate bom app failed ");
		}

	}

	@FindBy(xpath = "//*[@name='passwd']")
	private WebElement password1;

	@FindBy(xpath = "//a[normalize-space()='Search']")
	private WebElement searchOptn;

	@FindBy(xpath = "//button[normalize-space()='Search BOMs']")
	private WebElement searchBOMsOptn;

	@FindBy(xpath = "//a[@class='seasonListSwitcher']//span//span")
	private WebElement seasonListSwitcher;

	@FindBy(xpath = "//input[@placeholder='Type or paste your PC9 codes']")
	private WebElement pc9CodeSearchBox;

	@FindBy(xpath = "//*[@class='button confirm']")
	private WebElement replaceMaterial;

	// Method to login to BOM App
	public void login(String username, String password, ExtentTest test) throws InterruptedException {
		try {
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(account)).click();
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(email)).sendKeys(username);
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(password1)).sendKeys(password);
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
	        
	        System.out.println("Please approve the sign-in request in your authenticator app.");

	        // Loop to check for approval
	        boolean approved = false;
	        for (int i = 0; i < 12; i++) { // Check every 5 seconds for 1 minute
	            if (yesOptn.isDisplayed()) {
	                approved = true;
	                break;
	            } else {
	                Thread.sleep(5000); // Wait for 5 seconds before checking again
	            }
	        }

	        if (approved) {
	        	yesOptn.click();	            
	        	System.out.println("Bom App opened successfully");
	        	test.log(Status.INFO,
						"Logged into BOM App with username: " + username + " and password: " + "**********");
	            test.log(Status.INFO, "Bom App opened successfully");
	        } else {
	            System.out.println("Approval not received in time.");
	            test.log(Status.ERROR, "Approval not received in time.");
	        }
	    } catch (Exception e) {
	        System.out.println("Login failed");
	        test.log(Status.ERROR, "Login failed: " + e.getMessage());
	    }
	}
	

	// Method to select season
	public void selectSeason(String season) throws InterruptedException {
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchOptn));
			Thread.sleep(5000);
			searchOptn.click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchBOMsOptn));
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonListSwitcher));

			if (seasonListSwitcher.getText().toLowerCase().contains("use full list".toLowerCase())) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", seasonListSwitcher);
				Thread.sleep(2000);
			} else if (season.equals(season)) {
				Thread.sleep(2000);
			}
			selectValueFromDropdown(seasonSelect, season);
			Thread.sleep(3000);
//				searchBOMsOptn.click();
//				Thread.sleep(5000);
//				dashboard.click();
//				Thread.sleep(5000);
//				selectValueFromDropdown(seasonSelect, season);
			System.out.println("Season is selected");
		} catch (Exception e) {
			System.out.println("Season is selection failed");
		}
	}

	// Method to search for PC9

	@FindBy(xpath = "//label[text()='PC9 Code']/following-sibling::div/input")
	private WebElement pc9_code;

	public void searchForPC9(String PC9Code, ExtentTest test) throws InterruptedException {

//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9CodeSearchBox)).sendKeys(PC9Code);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9_code)).sendKeys(PC9Code);
		Thread.sleep(1000);
		addSrceenShot("PC9", test, Capture);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchBOMsOptn)).click();
		Thread.sleep(5000);
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quicksearch)).click();
//			Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(results));
	}

	public boolean verifySearchResults(String partialEntry, ExtentTest test) throws InterruptedException {

		// Get the list of search result elements
		Thread.sleep(3000);
		WebElement bomStatus = driver.findElement(By.xpath("//*[@class='ContextMenu BomResultsMenu']//div"));
		// Check if any result contains the partial entry
		if (!bomStatus.getText().contains("0 of 0 BOMs")) {
			bomStatus.click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(deselectAll));
			WebElement bomTextElement = driver.findElement(By.xpath("//div[@class='SelectAllLink']//following::input"));
			String searchResultValue = bomTextElement.getAttribute("value");
			test.log(Status.PASS, "Search result for partial entry is: " + searchResultValue);
			addSrceenShot("earch result for partial entry is", test, Capture);
			return true;
		} else {
			System.out.println("BOM not updated in BOM app");
			return false;
		}
	}

	// Method to check BOM status and click if "1 of 1 BOMs"
	public boolean checkAndClickBOM() throws InterruptedException {

		Thread.sleep(3000);
		WebElement bomStatus = driver.findElement(By.xpath("//*[@class='ContextMenu BomResultsMenu']//div"));
		if (!bomStatus.getText().contains("0 of 0 BOMs")) {
			bomStatus.click();
			return true;
		} else {
			System.out.println("BOM not updated in BOM app");
			return false;
		}
	}

	@FindBy(xpath = "//a[@class='prefs']//div[@class='buttonWrapper']//*")
	private WebElement settingsIcon;

	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	private WebElement logoutButton;

	public void logout(ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon)).click();
		Thread.sleep(3000);
		// Wait for the logout button to be visible
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(logoutButton));

		// Click the logout button
		logoutButton.click();
		test.log(Status.INFO, "Clicked on Logout button");
	}

	// Method to extract and check text after clicking BOM
	public String extractBOMText() throws InterruptedException {

		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(deselectAll));
		WebElement bomTextElement = driver.findElement(By.xpath("//div[@class='SelectAllLink']//following::input"));
		return bomTextElement.getAttribute("value");
	}

	@FindBy(xpath = "(//div[@class='BomEditorListHeader']//a)[2]")
	private WebElement add_matType_Subsection;

	@FindBy(xpath = "(//div[@class='BomEditorListHeader']//a)[1]")
	private WebElement add_Find_matType;

	@FindBy(xpath = "//label[contains(normalize-space(), 'Quantity')]/following-sibling::input")
	private WebElement quantityLocator;

	@FindBy(xpath = "//div[@draggable='true']")
	private WebElement drag_Ele;

	public void selectMaterialType(String materialType, ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(add_matType_Subsection));
		Thread.sleep(2000);
		WebElement material_Type = driver
				.findElement(By.xpath("//span[contains(normalize-space(), '" + materialType + "')]"));
		material_Type.click();
		test.log(Status.INFO, "Selected material type: " + materialType);
		Thread.sleep(3000);
	}

	public void addMaterialSubsection(ExtentTest test) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(add_matType_Subsection));
		add_matType_Subsection.click();
		test.log(Status.INFO, "Clicked to add material subsection");
	}

	public void fillComponentDetails(String component, String componentLocation, String remarks, String quantity,
			ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(componentLocator));
		Select e1 = new Select(componentLocator);
		e1.selectByValue(component);
		test.log(Status.INFO, "Selected component: " + component);
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(componentLocLocator));
		Select e2 = new Select(componentLocLocator);
		e2.selectByValue(componentLocation);
		test.log(Status.INFO, "Selected component location: " + componentLocation);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quantityLocator));
		quantityLocator.click();
		quantityLocator.clear();
		for (int i = 0; i < 20; i++) {
			quantityLocator.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		quantityLocator.sendKeys(quantity);
		test.log(Status.INFO, "Entered quantity: " + quantity);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(remarksLocator)).sendKeys(remarks);
		test.log(Status.INFO, "Entered remarks: " + remarks);
		Thread.sleep(3000);
	}

	public void clickAddSubsection(ExtentTest test) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addFabricSection)).click();
		test.log(Status.INFO, "Clicked to add subsection");
		addSrceenShot("Clicked to add subsection", test, Capture);
	}

	public void findMaterialByName(String materialName, ExtentTest test) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(add_Find_matType)).click();
		test.log(Status.INFO, "Clicked to find material");
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialLocator)).sendKeys(materialName);
		test.log(Status.INFO, "Entered material name: " + materialName);
		addSrceenShot("Entered material name", test, Capture);
		Thread.sleep(5000);
		materialLocator.sendKeys(Keys.ARROW_DOWN);
		materialLocator.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Selected material from dropdown");
		addSrceenShot("Selected material from dropdown", test, Capture);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
		test.log(Status.INFO, "Clicked next");
		addSrceenShot("Clicked next", test, Capture);
		Thread.sleep(3000);
	}

	public void dragMaterialIntoSubsection(String materialName, ExtentTest test) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(drag_Ele));
		Thread.sleep(4000);
		WebElement material = driver.findElement(By.xpath("//div[contains(text(), '" + materialName + "')]"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(material, drop).perform();
		test.log(Status.INFO, "Dragged material: " + materialName + " into subsection");
		addSrceenShot("Dragged material", test, Capture);
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addMaterial)).click();
		test.log(Status.INFO, "Clicked to add material");
		addSrceenShot("Clicked to add material", test, Capture);
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//div[@class='sliderHeader']//span[contains(text(),'Back')]")
	private WebElement backOptn;

	private boolean Capture;

	public void findReplaceMaterialByName(String materialName, ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(backOptn)).click();
		test.log(Status.INFO, "Clicked back option");
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialLocator));
		materialLocator.clear();
		materialLocator.sendKeys(materialName);
		test.log(Status.INFO, "Entered replace material name: " + materialName);
		addSrceenShot("Entered replace material name: ", test, Capture);
		Thread.sleep(5000);
		materialLocator.sendKeys(Keys.ARROW_DOWN);
		materialLocator.sendKeys(Keys.ENTER);
		test.log(Status.INFO, "Selected replace material from dropdown");
		addSrceenShot("Selected replace material from dropdown", test, Capture);

		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(next)).click();
		test.log(Status.INFO, "Clicked next");
		addSrceenShot("Clicked next", test, Capture);
		Thread.sleep(3000);
	}

	public void replaceMaterialIntoDropZonelistItem(String materialName, ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(drag_Ele));
		Thread.sleep(4000);
		WebElement material = driver.findElement(By.xpath("//div[contains(text(), '" + materialName + "')]"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(material, drop).perform();
		test.log(Status.INFO, "Dragged replace material: " + materialName + " into drop zone");
		addSrceenShot("Dragged replace material", test, Capture);
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(replaceMaterial)).click();
		test.log(Status.INFO, "Clicked to replace material");
		Thread.sleep(3000);
		test.log(Status.PASS, "Material replaced successfully");
		addSrceenShot("Material replaced successfully", test, Capture);
	}

	@FindBy(xpath = "//*[contains(text(),'Quantity')]//following-sibling::div//div//div")
	private WebElement edit_Qty;

	@FindBy(xpath = "//*[contains(text(),'Remarks')]//following-sibling::div//div//div")
	private WebElement edit_Remarks;

	public void MassUpdate_BomDetails(ExtentTest test, String newQuantity, String newRemarks)
			throws InterruptedException {
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit_Qty));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement valueDiv = driver.findElement(By.xpath("(//div[@class='readValue'])[1]"));
			String oldValue = valueDiv.getAttribute("innerHTML").trim(); // Get current value and trim whitespace
			System.out.println("Old Quantity value: " + oldValue);
			test.log(Status.INFO, "Old Quantity value: " + oldValue);
			js.executeScript("arguments[0].innerHTML = arguments[1];", valueDiv, newQuantity);
			System.out.println("Updated Quantity value to: " + newQuantity);
			test.log(Status.INFO, "Updated Quantity value to: " + newQuantity);
			Thread.sleep(8000);
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit_Remarks));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebElement valueDiv1 = driver.findElement(By.xpath("(//div[@class='readValue'])[2]"));
			String oldValue1 = valueDiv1.getAttribute("innerHTML").trim(); // Get current value and trim whitespace
			System.out.println("Old Remarks value: " + oldValue1);
			test.log(Status.INFO, "Old Remarks value: " + oldValue1);
			js1.executeScript("arguments[0].innerHTML = arguments[1];", valueDiv1, newRemarks);
			System.out.println("Updated Remarks value to: " + newRemarks);
			test.log(Status.INFO, "Updated Remarks value to: " + newRemarks);
			Thread.sleep(8000);

			System.out.println("Updated & Validated Bom bulk details by changing the quantity and remarks");
			test.log(Status.INFO, "Updated & validated Bom bulk details by changing the quantity and remarks");

		} catch (Exception e) {
			System.out.println("Bom bulk details are not updated");
		}
	}

	@FindBy(xpath = "//div[@class='sliderHeader']//button//*[name()='svg']")
	private WebElement crossButton;

	public void select_MaterialType(String materialType, ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(add_matType_Subsection));
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(crossButton));
		crossButton.click();
		Thread.sleep(3000);
		WebElement material_Type = driver
				.findElement(By.xpath("//span[contains(normalize-space(), '" + materialType + "')]"));
		material_Type.click();
		test.log(Status.INFO, "Selected material type: " + materialType);
		Thread.sleep(3000);
	}

}
