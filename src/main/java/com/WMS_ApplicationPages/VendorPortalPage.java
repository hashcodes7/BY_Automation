package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

//import junit.framework.Assert;

public class VendorPortalPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public VendorPortalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement Loactors------------------------------------------------------
// -----------------------vendor attributes--------------------------------------	
	@FindBy(xpath = "//*[@id='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//*[@id='LCSSUPPLIER_ptc_str_1']")
	private WebElement vendorNameField;

	@FindBy(xpath = "//*[@id='SearchButton2']")
	private WebElement vendorSearch;

	@FindBy(xpath = "//*[@id='lscoLegalName']")
	private WebElement legalName;

	@FindBy(xpath = "//*[@id='lscoVendorID']")
	private WebElement vendorId;

	@FindBy(xpath = "//*[@id='lscoCountry']")
	private WebElement country;

	@FindBy(xpath = "//*[@id='lscoVendorShortName']")
	private WebElement shortName;

	@FindBy(xpath = "//*[@id='supplierIdentification']/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]")
	private WebElement vendorNameValue;

	// -----------------------material
	// attributes--------------------------------------
	@FindBy(xpath = "(//*[text()=' Name ']//following::div[1]//input)[1]")
	private WebElement materialField;

	@FindBy(xpath = "//*[text()=' Material Code ']//following::div[1]//input")
	private WebElement materialCodeField;

	@FindBy(xpath = "//*[text()='Search']")
	private WebElement materialSearch;

	@FindBy(xpath = "//*[@id=\"material-library-app-parent\"]/div[3]/div[2]//following::div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]/div[2]")
	private WebElement chooseMaterial;

	@FindBy(xpath = "//*[text()='Material Details']")
	private WebElement materialPage;

	@FindBy(xpath = "//*[@id='select2-supplierLinkId-container']")
	private WebElement supDropDown;

	@FindBy(xpath = "//*[@id='select2-supplierLinkId-results']//li[2]")
	private WebElement supValue1;

	@FindBy(xpath = "//*[@id='tool-bar']/div[4]/div/img")
	private WebElement edit;

	@FindBy(xpath = "//*[@id='editMaterial']/span")
	private WebElement editMaterial;

	@FindBy(xpath = "//*[contains(text(),'Description')]//following::div[1]/input")
	private WebElement editMaterialDescr;

	@FindBy(xpath = "//*[text()='Save']")
	private WebElement save;

	@FindBy(xpath = "//*[@id='lscoDescription']/div[2]")
	private WebElement matDescr;

	@FindBy(xpath = "//*[text()='Edit Material Supplier']")
	private WebElement editMatSupplier;

	@FindBy(xpath = "(//*[text()='RYG']//following::div[1]//following::span[4])[1]")
	private WebElement colorChange;

	@FindBy(xpath = "//*[@id='select2-ptc_str_16-results']//li[2]")
	private WebElement editColor1;

	@FindBy(xpath = "//*[@id='select2-ptc_str_16-results']//li[3]")
	private WebElement editColor2;

	@FindBy(xpath = "//*[@id='select2-ptc_str_16-results']//li[1]")
	private WebElement editColor3;

	@FindBy(xpath = "//*[@id='lscoRYG']/div[2]")
	private WebElement newColor;

	@FindBy(xpath = "//*[text()='Clear Criteria']")
	private WebElement clearCriteria;

	@FindBy(xpath = "//*[text()='Reset Defaults']")
	private WebElement resetDef;

	@FindBy(xpath = "//*[@id='product-context-selector']/div[1]/div/div[1]")
	private WebElement supplier;

	@FindBy(xpath = "//*[text()='Colors']")
	private WebElement colorTab;

	@FindBy(xpath = "(//*[@id='null']/img)[2]")
	private WebElement add;

	@FindBy(xpath = "//*[text()='Color:']")
	private WebElement colorLink;

	@FindBy(xpath = "//*[text()=' Color Code ']//following::div[1]//input")
	private WebElement colorCode;

	@FindBy(xpath = "//*[@id='SEARCH_FORM_COLLAPSIBLE']//following::div[1]//div//button/span")
	private WebElement colorSearch;

	@FindBy(xpath = "(//*[text()='(choose)'])[1]")
	private WebElement colorChoose;

	@FindBy(xpath = "//*[text()='Save']")
	private WebElement colorSave;

	@FindBy(xpath = "//*[@id='colorId']//following::input[1]")
	private WebElement expColText;

	@FindBy(xpath = "//table/tbody/tr[2]/td[7]/a")
	private WebElement newColText;

	@FindBy(xpath = "//*[@id='colorlibraryframe']")
	private WebElement iframeColorContentframe;

	@FindBy(xpath = "//*[@id='addAction']/span[2]")
	private WebElement addAction;

	@FindBy(xpath = "//*[@id='addSuppliers']/span")
	private WebElement addSupplier;

	@FindBy(xpath = "(//*[text()='Search'])[1]")
	private WebElement supSearch;

	@FindBy(xpath = "(//*[@id='checkboxlist']//following::span)[1]")
	private WebElement supChoose;

	@FindBy(xpath = "(//*[text()='Select'])[1]")
	private WebElement supSelect;

	@FindBy(xpath = "(//*[@id='checkboxlist']//following::span//following::td[2]/a)[1]")
	private WebElement supName;

	@FindBy(xpath = "//*[text()='Documents']")
	private WebElement documentTab;

	@FindBy(xpath = "//*[@class='FORMELEMENT']")
	private WebElement documentDropdown;

	@FindBy(xpath = "//*[text()='Vendor Documents']")
	private WebElement vendorDoc;

	@FindBy(xpath = "//*[text()='Vendor(Supplier) Name:']")
	private WebElement vendorName;

	@FindBy(xpath = "(//*[text()='Search'])[1]")
	private WebElement search;

	@FindBy(xpath = "(//*[text()='(choose)'])[2]")
	private WebElement choose;

	@FindBy(xpath = "(//table)[12]/tbody/tr[1]/td[2]/input")
	private WebElement description;

	@FindBy(xpath = "(//table)[12]/tbody/tr[1]/td[4]/select")
	private WebElement docType;

	@FindBy(xpath = "//*[text()='LS&Co. Developer:']")
	private WebElement LsDeveloper;

	@FindBy(xpath = "(//*[text()='(choose)'])[4]")
	private WebElement choose1;

	@FindBy(xpath = "//*[text()='Create']")
	private WebElement create;

	@FindBy(xpath = "(//table)[10]/tbody/tr[2]/td[5]/a")
	private WebElement docName;

	@FindBy(xpath = "//*[@id='select2-ptc_str_10-container']")
	private WebElement colorUOM;

	@FindBy(xpath = "//li[text()='gram']")
	private WebElement UOMVal;

	@FindBy(xpath = "//*[@id='select2-ptc_str_11-container']")
	private WebElement orderUOM;

	@FindBy(xpath = "//*[text()='Minimum Per Color UOM']//following::div[1]")
	private WebElement updColorUOM;

	@FindBy(xpath = "//*[text()='Minimum Per Order UOM']//following::div[1]")
	private WebElement updOrderUOM;

	@FindBy(xpath = "//*[text()='Site']")
	private WebElement site;

	@FindBy(xpath = "//*[@ID='sidebarframe']")
	private WebElement sideFrame;

	@FindBy(xpath = "//*[text()='Supplier Status']//following::div[1]")
	private WebElement supStatus;

	@FindBy(xpath = "//*[text()='RYG']//following::div[1]")
	private WebElement RYG;

	@FindBy(xpath = "//*[text()='RYG Warning']//following::div[1]")
	private WebElement RYGWarning;

	@FindBy(xpath = "//*[text()='You do not have permission to Update Materials']")
	private WebElement errorMsg;

	@FindBy(xpath = "//*[text()='Specifications']")
	private WebElement specifications;

	@FindBy(xpath = "//*[text()='Visual Assets']")
	private WebElement visualAssets;

	@FindBy(xpath = "//*[text()='Edit Material Supplier']")
	private WebElement editMaterialSupplier;

	@FindBy(xpath = "//*[@id='select2-supplierLinkId-results']//li[1]")
	private WebElement supValue;

//	@FindBy(xpath = "(//*[@class='view-image-page-wrapper']//div[2]/div[1])[1]")
	@FindBy(xpath = "//*[@id='fileUpload']")
	private WebElement dragAndDrop;

	@FindBy(xpath = "//*[@id='quickSearchText']")
	private WebElement filterdata;

	@FindBy(xpath = "(//*[contains(@class,'urlAttribute')])[3]")
	private WebElement URL;

	private boolean Capture;

//	Methods------------------------------------------------------	
	public void vendorPage(ExtentTest test, String vendorId) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			// String vendorId = "ACCESORIOS GLOBALES, S.A. 4965 GT";
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorNameField)).sendKeys(vendorId);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", vendorSearch);
			vendorSearch.click();
			test.log(Status.INFO, "vendor details page opens up");
			System.out.println("vendor details page loaded");

		} catch (Exception e) {
			System.out.println("vendor details page not loaded");
		}
	}

	public void vendorNameValidation(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			String ActVendorName = vendorNameValue.getText();
			System.out.println("vendor name is " + ActVendorName);
			int lastSpaceIndex = ActVendorName.lastIndexOf(" ");
			int secondLastSpaceIndex = ActVendorName.lastIndexOf(" ", lastSpaceIndex - 1);
			int thirdLastSpaceIndex = ActVendorName.lastIndexOf(" ", secondLastSpaceIndex - 1);
			String part1 = ActVendorName.substring(0, thirdLastSpaceIndex).trim();
			String part2 = ActVendorName.substring(thirdLastSpaceIndex + 1, secondLastSpaceIndex).trim();
			String part3 = ActVendorName.substring(secondLastSpaceIndex + 1, lastSpaceIndex).trim();
			String part4 = ActVendorName.substring(lastSpaceIndex + 1).trim();
			String[] parts = { part1, part2, part3, part4 };

			System.out.println("Expected legal name: " + part1);
			System.out.println("Actual legal name: " + legalName.getText());
			test.log(Status.INFO, "Expected legal name: " + part1);
			test.log(Status.INFO, "Actual legal name: " + legalName.getText());
			Assert.assertEquals(part1, legalName.getText());

			System.out.println("Expected vendor id: " + part2);
			System.out.println("Actual vendor id: " + vendorId.getText());
			test.log(Status.INFO, "Expected vendor id: " + part2);
			test.log(Status.INFO, "Actual vendor id: " + vendorId.getText());
			Assert.assertEquals(part2, vendorId.getText());

			System.out.println("Expected vendor short name: " + part3);
			System.out.println("Actual vendor short name: " + shortName.getText());
			test.log(Status.INFO, "Expected vendor short name: " + part3);
			test.log(Status.INFO, "Actual vendor short name: " + shortName.getText());
			Assert.assertEquals(part3, shortName.getText());

			System.out.println("Expected country name: " + part4);
			System.out.println("Actual country name: " + country.getText());
			test.log(Status.INFO, "Expected country name: " + part4);
			test.log(Status.INFO, "Actual country name: " + country.getText());
			Assert.assertEquals(part4, country.getText());

			System.out.println("vendor name validation is done");

		} catch (Exception e) {
			System.out.println("vendor name validation is not done");
		}
	}

	public void materialPage(ExtentTest test, String material) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clearCriteria)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(resetDef)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialField)).sendKeys(material);
			// new WebDriverWait(driver,
			// 60).until(ExpectedConditions.visibilityOf(materialCodeField)).sendKeys(material);
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialSearch)).click();
			Thread.sleep(15000);
			WebElement matele = driver.findElement(By.xpath("(//*[text()=\'" + material + "\'])[1]"));
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(matele)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(chooseMaterial)).click();
			Thread.sleep(5000);
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			String mainWinId = itr.next();
			String ChildWinId = itr.next();
			driver.switchTo().window(ChildWinId);
			driver.switchTo().frame(iframeContentframe);
			Assert.assertTrue(materialPage.isDisplayed());
			test.log(Status.INFO, "material details page opens up");
			System.out.println("material details page loaded");
		} catch (Exception e) {
			System.out.println("material details page not loaded");
		}
	}

	public void materialUpdate(ExtentTest test) {
		try {

			// Update material information
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supValue1)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(8000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editMaterial)).click();
			Thread.sleep(5000);
			String descr = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editMaterialDescr))
					.getAttribute("value");
			System.out.println("before material decription " + descr);
			String newDescr = descr + "_editted";
			Thread.sleep(5000);
			editMaterialDescr.clear();
			Thread.sleep(5000);
			editMaterialDescr.sendKeys(newDescr);
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
			Thread.sleep(5000);
			String updDescr = matDescr.getText();
			System.out.println("after material decription " + updDescr);
			Assert.assertNotEquals(descr, updDescr);
		} catch (Exception e) {
			System.out.println("material details are not updated");
		}
	}

	public void materialSupplierUpdate(ExtentTest test) {
		try {
//		Update material supplier information
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(4000);
			List<WebElement> supValue = driver.findElements(By.xpath("//*[@id='select2-supplierLinkId-results']//li"));
			System.out.println("supplier dropdown size " + supValue.size());
			for (int j = 1; j < supValue.size(); j++) {
//				supValue.get(j+1).click();
				driver.findElement(By.xpath("//*[@id='select2-supplierLinkId-results']//li[" + (j + 1) + "]")).click();
				// new WebDriverWait(driver,
				// 60).until(ExpectedConditions.visibilityOf(supValue1)).click();
				Thread.sleep(5000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
				Thread.sleep(5000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editMatSupplier)).click();
				Thread.sleep(5000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorChange));
				String beforeRYG = colorChange.getAttribute("title");
				System.out.println("before material color change " + beforeRYG);
				colorChange.click();
				Thread.sleep(5000);
				// color changing from red to yellow for RYG
				if (beforeRYG.equals("Red")) {
					editColor1.click();
				}
				// color changing from yellow to green for RYG
				if (beforeRYG.equals("Yellow")) {
					editColor2.click();
				}
				// color changing from green to red for RYG
				if (beforeRYG.equals("Green")) {
					editColor3.click();
				}
				Thread.sleep(5000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
				Thread.sleep(5000);
				String updRYG = newColor.getText();
				System.out.println("after material color change " + updRYG);
				Assert.assertNotEquals(beforeRYG, updRYG);
				test.log(Status.PASS, "material supplier details are updated for supplier");
				System.out.println("material supplier details updated for supplier");
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			System.out.println("material supplier details are not updated");
		}

//        }
	}

	public void addColorToMaterial(ExtentTest test, String color) throws InterruptedException {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supValue1)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorTab)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(add)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorLink)).click();
			Thread.sleep(5000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));
			driver.switchTo().frame(iframeColorContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorCode)).sendKeys(color);
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorSearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorChoose)).click();
			Thread.sleep(5000);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().frame(iframeContentframe);
			String addColor = expColText.getAttribute("value");
			System.out.println("color need to add is " + addColor);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorSave)).click();
			Thread.sleep(5000);

			String addedColor = newColText.getText();
			System.out.println("color added is " + addedColor);
			Assert.assertEquals(addColor, addedColor);
			test.log(Status.PASS, "color added to the material");
			System.out.println("color added to the material");

		} catch (Exception e) {
			System.out.println("color is not added to the material");
		}
	}

	public void materialCode(ExtentTest test, String materialCode) throws InterruptedException {
//		written code for PD User
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clearCriteria)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(resetDef)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialCodeField))
					.sendKeys(materialCode);
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialSearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(chooseMaterial)).click();
			Thread.sleep(5000);
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			String mainWinId = itr.next();
			String ChildWinId = itr.next();
			driver.switchTo().window(ChildWinId);
			driver.switchTo().frame(iframeContentframe);
			Assert.assertTrue(materialPage.isDisplayed());
			test.log(Status.INFO, "material details page opens up");
			System.out.println("material details page loaded");
		} catch (Exception e) {
			System.out.println("material details page not loaded");
		}
	}

	public void addSupplierToMaterial(ExtentTest test) throws InterruptedException {
//		written code for PD User
		try {

			// Actions action=new Actions(driver);
			// action.moveToElement(edit).moveToElement(addAction).moveToElement(addSupplier).click().build().perform();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addAction)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addSupplier)).click();
			Thread.sleep(2000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supSearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supChoose)).click();
			Thread.sleep(3000);
			String addSupplier = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supName))
					.getText();
			System.out.println("supplier need to add is " + addSupplier);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supSelect)).click();
			Thread.sleep(3000);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(5000);
			String addedSupplier = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supValue1))
					.getText();
			System.out.println("supplier added is " + addedSupplier);
			Assert.assertEquals(addSupplier, addedSupplier);
			test.log(Status.INFO, "supplier details added");
			System.out.println("supplier details are added to the material");
		} catch (Exception e) {
			System.out.println("supplier details are not added");
		}
	}

	public void addDocuments(ExtentTest test, String descriptionValue) throws Exception {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(documentTab)).click();
			Thread.sleep(5000);
			WebElement createDoc = new WebDriverWait(driver, 60)
					.until(ExpectedConditions.visibilityOf(documentDropdown));
			Select sel = new Select(createDoc);
			sel.selectByIndex(1);
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorDoc)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorName)).click();
			Thread.sleep(3000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(search)).click();
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(choose)).click();
			Thread.sleep(3000);
			driver.switchTo().window(tabs.get(0));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(description))
					.sendKeys(descriptionValue);
			Thread.sleep(3000);
			WebElement drop = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(docType));
			Select sel1 = new Select(drop);
			sel1.selectByIndex(3);
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LsDeveloper)).click();
			Thread.sleep(3000);
			Set<String> allWindowHandles1 = driver.getWindowHandles();
			ArrayList<String> tabs1 = new ArrayList<>(allWindowHandles1);
			driver.switchTo().window(tabs1.get(1));

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(search)).click();
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(choose1)).click();
			Thread.sleep(3000);
			driver.switchTo().window(tabs1.get(0));
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(create)).click();
			Thread.sleep(7000);
			String name = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(docName)).getText();
			System.out.println("doc name is " + name);
			if (name.contains(descriptionValue)) {
				System.out.println("documents are added ");
			} else {
				System.out.println("documents are not added ");
			}

		} catch (Exception e) {
			System.out.println("documents are not added " + e);
		}
	}

	public void P1materialPage(ExtentTest test, String material) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clearCriteria)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(resetDef)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialField)).sendKeys(material);
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialSearch)).click();
			Thread.sleep(15000);
			/*
			 * Set<String> set =driver.getWindowHandles(); Iterator<String> itr =
			 * set.iterator(); String mainWinId= itr.next(); String ChildWinId= itr.next();
			 * driver.switchTo().window(ChildWinId);
			 * driver.switchTo().frame(iframeContentframe);
			 * Assert.assertTrue(materialPage.isDisplayed());
			 */
			System.out.println("material details page loaded");
		} catch (Exception e) {
			System.out.println("material details page not loaded");
		}
	}

	public void materialUpdate(ExtentTest test, String UOM) {
		try {

			// Update material information
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supValue)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editMaterialSupplier)).click();
			Thread.sleep(2000);
			// String UOM="gram";
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorUOM)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(UOMVal)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(orderUOM)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(UOMVal)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(updColorUOM));
			String updColorUOMValue = updColorUOM.getText();
			System.out.println("after material decription " + updColorUOMValue);
			Assert.assertEquals(UOM, updColorUOMValue);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(updOrderUOM));
			String updOrderUOMValue = updOrderUOM.getText();
			System.out.println("after material decription " + updOrderUOMValue);
			Assert.assertEquals(UOM, updOrderUOMValue);

		} catch (Exception e) {
			System.out.println("material details are not updated" + e);
		}
	}

	public void fabricMaterialUpdate(ExtentTest test) {
		try {

			// Update material information
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(3000);
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(editMaterialSupplier)).click();
			Thread.sleep(3000);
			String supStatusVal = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supStatus))
					.getAttribute("class");
			String RYGVal = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(RYG))
					.getAttribute("class");
			String RYGWarningVal = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(RYGWarning))
					.getAttribute("class");
			String classVal = "display-only-label";
			if ((supStatusVal.equals(classVal)) && (RYGVal.equals(classVal)) && (RYGWarningVal.equals(classVal))) {
				System.out.println("fabric material details are not editable");
			}
		} catch (Exception e) {
			System.out.println("fabric material details are not editable");
		}
	}

	public void clickOnSite(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(sideFrame);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(site)).click();
		Thread.sleep(5000);
		System.out.println("clicked on site");
	}

	public void uploadThumbnailMaterial(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String supStatusVal = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supStatus))
				.getAttribute("class");
		if (!(supStatusVal.equals("Approved for bulk"))) {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supValue)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(8000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editMaterial)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(errorMsg));
			Assert.assertTrue(errorMsg.isDisplayed());
			System.out.println("vendor user won't have access for upload thumbnail to material");
		}
	}

	public void uploadImageMaterial(ExtentTest test) throws Exception {
		try {
			String supStatusVal = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supStatus))
					.getAttribute("class");
			if (!(supStatusVal.equals("Approved for bulk"))) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specifications)).click();
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(visualAssets)).click();
				String filepath = "C:\\Users\\770660\\OneDrive - Cognizant\\Desktop\\levis_logo.jpg";
				dragAndDrop.sendKeys(filepath);
				Thread.sleep(3000);
				Alert alert = new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
				String alertMessage = alert.getText();
				if (alertMessage.contains("You do not have the required permissions for this action")) {
					System.out.println("vendor user won't have permission for upload image to material");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void downloadTechpack(ExtentTest test, String colorwayCode) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode);
			Thread.sleep(5000);
			ArrayList<String> header = new ArrayList<String>();
			header = TechpackGenerationPDViewColumnHeaderValue();
			for (int i = 0; i < 19; i++) {
				String ColumnHeader = header.get(i);
				scroll(i + 3);
				System.out.println(ColumnHeader);
				if (ColumnHeader.equals("(Retired) Colorway BOM Techpack URL")) {
					new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(URL)).click();
					Thread.sleep(5000);
				}
				System.out.println("Downloaded the techpack from the linesheet");
			}
		} catch (Exception e) {
			System.out.println("Download the techpack from linesheet is failed" + e);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////

	public void selectvendorDocumentsAndclickOnSearch(String value, ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
// String vendorId = "ACCESORIOS GLOBALES, S.A. 4965 GT";
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorSearch));
			Thread.sleep(2000);
			WebElement business_Object = driver.findElement(By.xpath("//a[normalize-space()='" + value.trim() + "']"));
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", business_Object);
			business_Object.click();
			Thread.sleep(3000);
			test.log(Status.INFO, "clicked on vendorDocuments");
			addSrceenShot("clicked on vendorDocuments", test, Capture);
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorSearch));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", vendorSearch);
			vendorSearch.click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Hide/Show Columns']")
	private WebElement hideColButton;

	public void clickOnDocumentName(String vendorDOCName) throws InterruptedException {

		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hideColButton));
			WebElement document = driver.findElement(By.xpath("//a[contains(text(),'" + vendorDOCName + "')]"));
			document.click();

		} catch (Exception e) {
		}
	}

//public void clickOnFirstDocumentName() throws InterruptedException {
//driver.switchTo().defaultContent();
//driver.switchTo().frame(iframeContentframe);
//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hideColButton));
//WebElement document = driver.findElement(By.xpath("//a[contains(text(),'" + vendorDOCName + "')]"));
//document.click();
//}

	@FindBy(xpath = "//td[@class='PAGEHEADINGTEXT']//select")
	private WebElement actionsMenu;

	public void clickOnUpdateInActionsMenu() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(actionsMenu));
		Thread.sleep(2000);
		selectValueFromDropdown(actionsMenu, "Update");
		WaitforPage(2000);
	}

	@FindBy(xpath = "//a[normalize-space()='Vendor(Supplier) Name:']")
	private WebElement vendorLink;

	@FindBy(xpath = "//a[normalize-space()='LS&Co. Developer:']")
	private WebElement lSCoDeveloperLink;

	@FindBy(xpath = "//td[contains(text(), 'Description')]/following-sibling::td[1]//child::input")
	private WebElement description_Input;

	@FindBy(xpath = "//td[contains(text(), 'Document Type')]/following-sibling::td[1]//child::select//option")
	private WebElement documentTypeDpDn;

	@FindBy(xpath = "//td[contains(text(),'Name')]/following-sibling::td[1]/child::input[1]")
	private WebElement nameInput;

	@FindBy(xpath = "(//a[contains(text(),'Search')])[2]")
	private WebElement searchBtn;

	@FindBy(xpath = "(//a[contains(text(),'(choose)')])[1]")
	private WebElement optnSelect;

	public void updateAttributes(String newVendorName, String newDescription, String newDocumentType,
			String newLSCoDeveloper, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorLink));
		Thread.sleep(2000);
		vendorLink.click();
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(newVendorName);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		test.log(Status.INFO, "Updated Vendor(Supplier) Name: " + newVendorName);
		addSrceenShot("Updated Vendor(Supplier) Name", test, Capture);
		driver.switchTo().window(ParentWinhadle);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		description_Input.clear();
		description_Input.sendKeys(newDescription);
		test.log(Status.INFO, "Updated Description: " + newDescription);
		addSrceenShot("Updated Description", test, Capture);
		Thread.sleep(2000);

		WebElement attributeField = driver.findElement(
				By.xpath("//td[contains(text(), 'Document Type')]/following-sibling::td[1]//child::select"));
		selectValueFromDropdown(attributeField, newDocumentType);
		test.log(Status.INFO, "Updated Document Type: " + newDocumentType);
		addSrceenShot("Updated newDocument Type", test, Capture);
		Thread.sleep(2000);

		lSCoDeveloperLink.click();
		String ParentWinhadle1 = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(newLSCoDeveloper);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", searchBtn);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		addSrceenShot("Selected Vendor", test, Capture);
		test.log(Status.INFO, "Updated LS&Co. Developer: " + newDocumentType);
		addSrceenShot("Updated LS&Co. Developer", test, Capture);
		driver.switchTo().window(ParentWinhadle1);

	}

	public void clickOnSaveButton() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement saveButton = driver.findElement(By.xpath("//div[@id='saveButtonDiv']/following-sibling::div"));
		saveButton.click();
	}

	@FindBy(xpath = "//td[@id='lscoVendorID']//a")
	private WebElement getVendorNameValue;

	@FindBy(xpath = "//td[contains(text(), 'Description')]/following-sibling::td[1]")
	private WebElement getDescriptionValue;

	@FindBy(xpath = "//td[contains(text(), 'Document Type')]/following-sibling::td[1]")
	private WebElement getDocumentTypeValue;

	@FindBy(xpath = "//td[@id='lscoDeveloperObjRef']//a")
	private WebElement getLScoDeveloperValue;

	public void verifyUpdatedAttributes(String newVendorName, String newDescription, String newDocumentType,
			String newLSCoDeveloper) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(getVendorNameValue));
		Thread.sleep(2000);
		Assert.assertEquals(getVendorNameValue.getText(), newVendorName, "Vendor name did not update correctly");
		Assert.assertEquals(getDescriptionValue.getText(), newDescription, "Description did not update correctly");
		Assert.assertEquals(getDocumentTypeValue.getText(), newDocumentType, "Document type did not update correctly");
		Assert.assertEquals(getLScoDeveloperValue.getText(), newLSCoDeveloper,
				"LS&Co. Developer did not update correctly");
	}

	@FindBy(xpath = "//td[@id='lscoImageLayout']")
	private WebElement getImgLayoutValue;

	@FindBy(xpath = "//td[@id='pageDescription']")
	private WebElement getImgDecValue;

	@FindBy(xpath = "//td[@id='lscoImageType']")
	private WebElement getImgType;

	public void verifyUpdated_Attributes(String newVendorName, String newImgLayout, String newImgDescription,
			String newImgType) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(getVendorNameValue));
		Thread.sleep(2000);
		Assert.assertEquals(getVendorNameValue.getText(), newVendorName, "Vendor name did not update correctly");
		Assert.assertEquals(getImgLayoutValue.getText(), newImgLayout, "Image Layout did not update correctly");
		Assert.assertEquals(getImgDecValue.getText(), newImgDescription, "Image description did not update correctly");
		Assert.assertEquals(getImgType.getText(), newImgType, "Image Type did not update correctly");
	}

	public void updateAttributesForVendorImgDocumnet(String newVendorName, String newImgLayout,
			String newImgDescription, String newImgType, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorLink));
		Thread.sleep(2000);
		vendorLink.click();
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(newVendorName);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		test.log(Status.INFO, "Updated Vendor(Supplier) Name: " + newVendorName);
		addSrceenShot("Updated Vendor(Supplier) Name", test, Capture);
		driver.switchTo().window(ParentWinhadle);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement attributeField = driver.findElement(
				By.xpath("//td[contains(text(), 'Image Layout')]/following-sibling::td[1]//child::select"));
		selectValueFromDropdown(attributeField, newImgLayout);
		test.log(Status.INFO, "Updated Image Layout: " + newImgLayout);
		addSrceenShot("Updated Image Layout", test, Capture);
		Thread.sleep(2000);

		description_Input.clear();
		description_Input.sendKeys(newImgDescription);
		test.log(Status.INFO, "Updated Image Description: " + newImgDescription);
		addSrceenShot("Updated Description", test, Capture);
		Thread.sleep(2000);

		WebElement attributeField2 = driver
				.findElement(By.xpath("//td[contains(text(), 'Image Type')]/following-sibling::td[1]//child::select"));
		selectValueFromDropdown(attributeField2, newImgType);
		test.log(Status.INFO, "Updated Image Type: " + newImgType);
		addSrceenShot("Updated Image Type", test, Capture);
		Thread.sleep(2000);

	}

	public void verifyListOfValuesInImgTypeDropdown(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		List<String> expectedValues = Arrays.asList("Commercial Sample Image", "Construction", "Embellishment Artwork",
				"Fabric Swatch Image", "Finish Image", "Labeling Images", "Line Build Sample Image",
				"Line Launch Sample Image", "PPS Sample Image", "Packaging Images", "Placement Guide",
				"Print and Pattern CAD", "Proto Image", "Sealed Sample Image", "Sundry Images");

		List<WebElement> actualValuesElements = driver.findElements(
				By.xpath("//td[contains(text(), 'Image Type')]/following-sibling::td[1]//child::select//option"));
		List<String> actualValues = actualValuesElements.stream().map(WebElement::getText).collect(Collectors.toList());

		List<String> missingValues = new ArrayList<>();
		for (String expectedValue : expectedValues) {
			if (!actualValues.contains(expectedValue)) {
				missingValues.add(expectedValue);
			}
		}

		if (missingValues.isEmpty()) {
			test.log(Status.PASS,
					"Verified all the Image Type list values under Document sub-type Images Vendor Images: "
							+ expectedValues);
		} else {
			test.log(Status.WARNING,
					"The following expected values were not found in the Image Type dropdown: " + missingValues);
			test.log(Status.FAIL, "Some expected values were not found in the Image Type dropdown. Expected values: "
					+ expectedValues);
		}
		addSrceenShot("Verified all the Image Type list values under Document sub-type Images Vendor Images", test,
				Capture);
	}

	public void chooseMaterialColorDevelopment(String sampleType, ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
// String vendorId = "ACCESORIOS GLOBALES, S.A. 4965 GT";
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorSearch));
			Thread.sleep(2000);
			WebElement business_Object = driver
					.findElement(By.xpath("//a[normalize-space()='" + sampleType.trim() + "']"));
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", business_Object);
			business_Object.click();
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickOnSearchTab() throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(vendorSearch));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", vendorSearch);
			vendorSearch.click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//span[normalize-space(text())='Hide All/Show All']/preceding-sibling::input[@type='checkbox']")
	private WebElement hideall_showall_Checkbox;

	@FindBy(xpath = "//span[normalize-space(text())='Name']/preceding-sibling::input[@type='checkbox']")
	private WebElement nameCheckBox;

	@FindBy(xpath = "//td[@class='PAGEHEADINGTITLE']")
	private WebElement pagHeaderTitle;

	@FindBy(xpath = "//td[contains(text(), 'from Vendor')]/following-sibling::td[1]/input")
	private WebElement airwayBillField;

	@FindBy(xpath = "//td[contains(text(), 'Shipped Date')]/following-sibling::td[1]/input")
	private WebElement shippedDateField;

	@FindBy(xpath = "//td[contains(text(), 'Vendor Comments')]/following-sibling::td[1]/textarea")
	private WebElement vendorCommentsField;

	@FindBy(xpath = "//td[contains(text(), 'Request Name')]/following-sibling::td[1]/input")
	private WebElement requestNameField;

	public void updateSampleInformation(String airwayBill, String shippedDate, String vendorComments,
			String requestName, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(pagHeaderTitle));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(requestNameField));
		requestNameField.clear();
		requestNameField.sendKeys(requestName);
		test.log(Status.INFO, "Updated Request Name: " + requestName);
		addSrceenShot("Updated Request Name", test, Capture);
		Thread.sleep(2000);

		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", airwayBillField);

		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(airwayBillField));

		airwayBillField.clear();
		airwayBillField.sendKeys(airwayBill);
		test.log(Status.INFO, "Updated  Airway Bill # from Vendor: " + airwayBill);
		addSrceenShot("Updated  Airway Bill # from Vendor", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(shippedDateField));

		shippedDateField.clear();
		shippedDateField.sendKeys(shippedDate);
		test.log(Status.INFO, "Updated Shipped Date: " + shippedDate);
		addSrceenShot("Updated Shipped Date", test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(shippedDateField));

		vendorCommentsField.clear();
		vendorCommentsField.sendKeys(vendorComments);
		test.log(Status.INFO, "Updated Vendor Comments: " + vendorComments);
		addSrceenShot("Updated Vendor Comments", test, Capture);

		Thread.sleep(2000);
	}

	@FindBy(xpath = "//td[contains(text(), 'Request Name')]/following-sibling::td[1]")
	private WebElement reqNmaeValue;

	@FindBy(xpath = "//td[@id='lscoAWBNumber']")
	private WebElement airWaybillValue;

	@FindBy(xpath = "//td[contains(text(), 'Shipped Date')]/following-sibling::td[1]")
	private WebElement shippedDateValue;

	@FindBy(xpath = "//td[@id='lscoVendorComments']")
	private WebElement vendorCommentsValue;

	public void verifyChangesSaved(String airwayBill, String shippedDate, String vendorComments, String requestName,
			ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(reqNmaeValue));
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippedDateValue);
		Thread.sleep(2000);
		Assert.assertEquals(reqNmaeValue.getText(), requestName, "Request Name did not update correctly");
		Assert.assertEquals(airWaybillValue.getText(), airwayBill, "Air Bill # from Vendor did not update correctly");
		Assert.assertEquals(shippedDateValue.getText(), shippedDate, "Shipped Date did not update correctly");
		Assert.assertEquals(vendorCommentsValue.getText(), vendorComments, "vendor Comments did not update correctly");
	}

	public void clickOnmaterialColorSample(String name) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hideColButton));
		Thread.sleep(2000);
		hideColButton.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", hideall_showall_Checkbox);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameCheckBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nameCheckBox);
		Thread.sleep(1000);
		hideColButton.click();
		Thread.sleep(3000);

		WebElement sampleNameEle = driver.findElement(By.xpath("//a[normalize-space(text())='" + name + "']"));
		sampleNameEle.click();
		Thread.sleep(8000);
	}

	public void clickSave() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(save));
		save.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//select[@id='sampleRequestActions']")
	private WebElement sample_actionsMenu;

	public void clickOnUpdateIn_ActionsMenu() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sample_actionsMenu));
		Thread.sleep(2000);
		sample_actionsMenu.click();
		driver.findElement(By.xpath("//option[contains(text(), 'Update')]")).click();
//selectValueFromDropdown(sample_actionsMenu, "Update");
	}

	@FindBy(xpath = "//span[@class='PAGEHEADINGTITLE']")
	private WebElement pageHeadingTitle;

	public boolean verifyProductFitSearchPage() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pageHeadingTitle));
		Thread.sleep(3000);
		return pageHeadingTitle.isDisplayed();
	}

	public boolean verifyTechpackgenerationPage() {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pagHeaderTitle));

		return pagHeaderTitle.isDisplayed();
	}

	public void clickGenerateTechpack() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		try {

			WebElement actionsDropdown = driver.findElement(By.xpath("//div[@class='dropdown menu-icon']"));
			actionsDropdown.click();
			WebElement moreOption = driver.findElement(By.xpath("//span[normalize-space()='More...']"));
			moreOption.click();
			WebElement generateTechPackOption = driver.findElement(By.xpath("//span[text()='Generate Tech Pack']"));
			generateTechPackOption.click();

		} catch (Exception e) {

		}
	}

	@FindBy(xpath = "(//a[@href='javascript:updateResults()'][normalize-space()='Update Results'])[1]")
	private WebElement updateResultsButton;

	@FindBy(xpath = "//a[contains(text(), 'from Vendor')]")
	private WebElement awbNumberHeaderField;

	@FindBy(xpath = "//td[contains(text(), 'from Vendor')]/following::input[1]")
	private WebElement awbNumberField;

	@FindBy(xpath = "//td[contains(text(), 'Shipped Date')]/following::input[1]")
	private WebElement shippedDate_Field;

	@FindBy(xpath = "//td[contains(text(), 'Vendor Comments')]/following::textarea[1]")
	private WebElement vendorComments_Field;

	public void clickUpdateResults() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(updateResultsButton));
		Thread.sleep(2000);
		updateResultsButton.click();
	}

	public void updateAWBNumber(String airwayBill) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(awbNumberField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", awbNumberHeaderField);
		Thread.sleep(2000);
		awbNumberField.clear();
		awbNumberField.sendKeys(airwayBill);

	}

	public void updateShippedDate(String shippedDate) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(shippedDate_Field));
		Thread.sleep(2000);
		shippedDate_Field.clear();
		shippedDate_Field.sendKeys(shippedDate);
	}

	public void updateVendorComments(String comments) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorComments_Field));
		Thread.sleep(2000);
		vendorComments_Field.clear();
		vendorComments_Field.sendKeys(comments);
	}

	public boolean verifyUpdates(String airwayBill, String shippedDate, String vendorComments)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(awbNumberHeaderField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", awbNumberHeaderField);
		Thread.sleep(3000);
		WebElement actualAWBNumber = driver.findElement(By.xpath("//td[normalize-space()='" + airwayBill + "']"));
		WebElement actualShippedDate = driver.findElement(By.xpath("//td[normalize-space()='" + shippedDate + "']"));
		WebElement actualComments = driver.findElement(By.xpath("//td[normalize-space()='" + vendorComments + "']"));
		Thread.sleep(3000);

		String actualAWBNumber_Value = actualAWBNumber.getText();
		String actualShippedDate_Value = actualShippedDate.getText();
		String actualComments_Value = actualComments.getText();

		boolean isAWBNumberCorrect = actualAWBNumber_Value.equals(airwayBill);
		boolean isShippedDateCorrect = actualShippedDate_Value.equals(shippedDate);
		boolean isCommentsCorrect = actualComments_Value.equals(vendorComments);

		return isAWBNumberCorrect && isShippedDateCorrect && isCommentsCorrect;
	}

}
