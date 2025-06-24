package com.WMS_ApplicationPages;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.net.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class Techpack_pages extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Techpack_pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//label[contains(text(),'My Seasons')]")
	private WebElement Myseason;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement SeasonsDropdown;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;

	@FindBy(xpath = "//name-cell-renderer[@class='ng-star-inserted']/a")
	private WebElement firstproduct;

	@FindBy(xpath = "(//div[@col-id='source-season.lscoSpecStatus|~*~|TechpackGeneration:PDView'])[2]")
	private WebElement specStatus_value;

	@FindBy(xpath = "(//div[@col-id='source-season.lscoSpecStatus|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement GD_specStatus_value;

	@FindBy(xpath = "(//div[@col-id='source-season.lscoTechPackOptions|~*~|TechpackGeneration:PDView'])[2]")
	private WebElement TechpackOptions_value;

	@FindBy(xpath = "(//div[@col-id='source-season.lscoTechPackOptions|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement GD_TechpackOptions_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoPC9BOMTechPack|~*~|TechpackGeneration:PDView'])[2]")
	private WebElement INcludePC9_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoPC9BOMTechPack|~*~|TechpackGeneration:PDView'])[3]")
	private WebElement INcludePC9_value_2;

	@FindBy(xpath = "(//div[@col-id='source-season.lscoGenerateTechPack|~*~|TechpackGeneration:PDView'])[2]")
	private WebElement GenerateTechpack_value;

	@FindBy(xpath = "(//div[@col-id='source-season.lscoGenerateTechPack|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement GD_GenerateTechpack_value;
	
	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoTPErrorMsg|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement GD_Techpack_message;

	@FindBy(xpath = "(//input[@type='text'][@aria-activedescendant='p-highlighted-option'])[2]")
	private WebElement Textbox;
	
	@FindBy(xpath = "//i[@class='p-dropdown-clear-icon pi pi-times ng-tns-c59-13 ng-star-inserted']")
	private WebElement cross_button;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement IncludePC9_checkbox;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement select_value;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement Save_button;

	@FindBy(xpath = "//span[@class='p-button-label'][text()='Run']")
	private WebElement Run_button;

	@FindBy(xpath = "(//div[@col-id='colorway-source.LSCOBOMColorwayURL|~*~|TechpackGeneration:PDView'])[2]//a")
	private WebElement Colorway_BOM_URL_Link;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoColorwayTP|~*~|TechpackGeneration:GarmentDeveloperView'])[2]//a")
	private WebElement Techpack_URL_Link;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoProtoBOMURL|~*~|TechpackGeneration:PDView'])[2]//a")
	private WebElement Proto_BOM_URL_Link;
	
	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoBulkBOMURL|~*~|TechpackGeneration:PDView'])[2]//a")
	private WebElement BULK_BOM_URL_Link;

//	----------------------------------------------------------------------------------------

	public void filterdata(String filtervalue) {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
		FilterTextbox.clear();
		FilterTextbox.sendKeys(filtervalue);
	}
	public void filterdataa(String filtervalue) {
		FilterTextbox.clear();
		FilterTextbox.sendKeys(filtervalue);
	}
	

	public void Download_ColorwayBOM_File(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_PD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			Thread.sleep(300);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(specStatus_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("Co-Creation BOM 1 of 2");
				Thread.sleep(2000);
				select_value.click();

				Thread.sleep(2000);
				test.log(Status.INFO, "After changing spec status value is :  " + specStatus_value.getText());
			}
			if (ColumnHeader.equals("TechPack Options")) {

				Actions action = new Actions(driver);
				action.doubleClick(TechpackOptions_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("BOM only");
				Thread.sleep(2000);
				select_value.click();
				test.log(Status.INFO, "After changing techpack options value is :  " + TechpackOptions_value.getText());
				Thread.sleep(2000);

			}
			if (ColumnHeader.equals("Include PC9 in Tech-Pack?")) {
				Thread.sleep(2000);
				if (INcludePC9_value.getText().equalsIgnoreCase("yes")) {

					test.log(Status.INFO, " IncludePC9 value is already checked ");
					System.out.println("IncludePC9 value is already checked");
				} else {
					Actions action = new Actions(driver);
					action.doubleClick(INcludePC9_value).perform();
					IncludePC9_checkbox.click();
					test.log(Status.INFO, " IncludePC9 value is checked  ");
				}
				Thread.sleep(2000);
			}
				if (ColumnHeader.equals("Generate TechPack Status")) {
					Actions action = new Actions(driver);
					action.doubleClick(GenerateTechpack_value).perform();
					Textbox.sendKeys("Generate Techpack Now");
					Thread.sleep(2000);
					select_value.click();
					GenerateTechpack_value.click();
					Thread.sleep(2000);
					
					Save_button.click();
					Thread.sleep(5000);
				}
				if (ColumnHeader.equals("Techpack Error Message")) {
					while(GenerateTechpack_value.getText().equalsIgnoreCase("Submitted")) {
						Thread.sleep(3000);
						Run_button.click();
						Thread.sleep(7000);
						
					}
					test.log(Status.PASS, "Colorway BOM tech-pack URL is generated   ");
				}
				if (ColumnHeader.equals("(Retired) Colorway BOM Techpack URL")) {
					Thread.sleep(3000);
					test.log(Status.PASS, Colorway_BOM_URL_Link.getAttribute("href"));
					new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(Colorway_BOM_URL_Link));
					Colorway_BOM_URL_Link.click();
					Thread.sleep(5000);
				}
				
		}
	
	}
	
	public void MassEditable_PDView(String specstatus, String techpackoptions, ExtentTest test)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_PD_ColumnHeaderValue();
		for (int i = 0; i < header.size()-1; i++) {
			String ColumnHeader = header.get(i);
			Thread.sleep(300);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {

				List<WebElement> SpecstatusList = driver.findElements(
						By.xpath("//div[@col-id='source-season.lscoSpecStatus|~*~|TechpackGeneration:PDView']"));
				for (int j = 1; j <= SpecstatusList.size()-1; j++) {

					WebElement Specstatus = driver.findElement(By.xpath("(//div[@col-id='source-season.lscoSpecStatus|~*~|TechpackGeneration:PDView'])["+ (j + 1) + "]"));
					Actions action = new Actions(driver);
					action.doubleClick(Specstatus).perform();
					Thread.sleep(2000);
					Textbox.sendKeys(specstatus);
					Thread.sleep(2000);
					select_value.click();
					Thread.sleep(1000);
					Specstatus.sendKeys(Keys.ENTER);

					test.log(Status.INFO, "spec status value is :  " + Specstatus.getText());
				}
				Save_button.click();
				Thread.sleep(8000);
				test.log(Status.INFO, "MASS Editing of spec status is completed");

			}
			if (ColumnHeader.equals("TechPack Options")) {

				List<WebElement> TechpackoptionList = driver.findElements(
						By.xpath("//div[@col-id='source-season.lscoTechPackOptions|~*~|TechpackGeneration:PDView']"));
				for (int k = 1; k <= TechpackoptionList.size()-1; k++) {

					WebElement Techpackoptions = driver.findElement(By.xpath("(//div[@col-id='source-season.lscoTechPackOptions|~*~|TechpackGeneration:PDView'])["+ (k + 1) + "]"));
					Actions action = new Actions(driver);
					action.doubleClick(Techpackoptions).perform();
					Thread.sleep(2000);
					Textbox.sendKeys(techpackoptions);
					Thread.sleep(2000);
					select_value.click();
					Thread.sleep(1000);
					Techpackoptions.sendKeys(Keys.ENTER);

					test.log(Status.INFO, "After changing Techpack options value is :  " + Techpackoptions.getText());
				}
				Save_button.click();
				Thread.sleep(5000);
				test.log(Status.INFO, "MASS Editing for Techpack options is completed");
			}
			if (ColumnHeader.equals("Include PC9 in Tech-Pack?")) {
				Thread.sleep(2000);
				
				List<WebElement> IncludePC9List = driver.findElements(By.xpath("//div[@col-id='colorway-source.lscoPC9BOMTechPack|~*~|TechpackGeneration:PDView']"));
				for (int l = 1; l <= IncludePC9List.size()-1; l++) {
					WebElement IncludePC9 = driver.findElement(By.xpath("(//div[@col-id='colorway-source.lscoPC9BOMTechPack|~*~|TechpackGeneration:PDView'])["+ (l + 1) + "]"));
					if (IncludePC9.getText().equalsIgnoreCase("yes")) {

						test.log(Status.INFO, " IncludePC9 value is already checked ");
						System.out.println("IncludePC9 value is already checked");
					}
					else {
						Actions action = new Actions(driver);
						action.doubleClick(IncludePC9).perform();
						IncludePC9_checkbox.click();
						test.log(Status.INFO, " IncludePC9 value is checked  ");
					}
				}
				Save_button.click();
				Thread.sleep(5000);
				test.log(Status.INFO, "MASS Editing for Include PC9 in TechPack? is completed");
				Thread.sleep(2000);
			}
			if (ColumnHeader.equals("Generate TechPack Status")) {
				List<WebElement> Generatetechpack = driver.findElements(By.xpath("//div[@col-id='source-season.lscoGenerateTechPack|~*~|TechpackGeneration:PDView']"));
				for (int m = 1; m <= Generatetechpack.size()-1; m++) {

					WebElement generateTechpack = driver.findElement(
							By.xpath("(//div[@col-id='source-season.lscoGenerateTechPack|~*~|TechpackGeneration:PDView'])["+ (m + 1) + "]"));
					Actions action = new Actions(driver);
					action.doubleClick(generateTechpack).perform();
					Thread.sleep(2000);
					Textbox.sendKeys("Generate Techpack Now");
					Thread.sleep(2000);
					select_value.click();
					Thread.sleep(1000);
					generateTechpack.sendKeys(Keys.ENTER);
					
					test.log(Status.INFO, "After changing Generate Techpack Status, value is :  " + generateTechpack.getText());
				}
				Save_button.click();
				Thread.sleep(5000);
				test.log(Status.INFO, "MASS Editing for Generate Techpack Status is completed");
				Thread.sleep(3000);
				
			}

		}

	}

	public void Download_BulkTechpack_File(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_GD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(200);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(GD_specStatus_value).perform();
				Thread.sleep(1000);
				Textbox.sendKeys("Bulk");
				Thread.sleep(1000);
				select_value.click();

				Thread.sleep(2000);
				test.log(Status.INFO, "After changing spec status value is :  " + GD_specStatus_value.getText());
			}
			if (ColumnHeader.equals("TechPack Options")) {

				Actions action = new Actions(driver);
				action.doubleClick(GD_TechpackOptions_value).perform();
				Thread.sleep(1000);
				Textbox.sendKeys("Techpack only");
				Thread.sleep(1000);
				select_value.click();
				test.log(Status.INFO,
						"After changing Techpack option value is :  " + GD_TechpackOptions_value.getText());
				Thread.sleep(2000);

			}

			if (ColumnHeader.equals("Generate TechPack Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(GD_GenerateTechpack_value).perform();
				Thread.sleep(1000);
				Textbox.sendKeys("Generate Techpack Now");
				Thread.sleep(1000);
				select_value.click();
				Thread.sleep(1000);
				GD_GenerateTechpack_value.click();
				Thread.sleep(1000);
				Save_button.click();
				Thread.sleep(8000);
			}
			
			if (ColumnHeader.equals("Generate TechPack Status")) {
				if (GD_GenerateTechpack_value.getText().equalsIgnoreCase("Submitted")) {
					Run_button.click();
					Thread.sleep(8000);
					test.log(Status.PASS, "Techpack URL is generated    ");
				}else {
					test.log(Status.PASS, "Techpack URL is generated ");
				}
			}
			if (ColumnHeader.equals("Garment TechPack URL")) {
				Thread.sleep(3000);
				test.log(Status.PASS,"tech pack URL- "+ Techpack_URL_Link.getAttribute("href"));
				System.out.println(Techpack_URL_Link.getAttribute("href"));
				Techpack_URL_Link.click();
				Thread.sleep(5000);
			}
		}
	}
	public void Download_Techpack_File(String specstatus,String techpackoptions,ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_GD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(200);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {
				Actions action = new Actions(driver);
				action.doubleClick(GD_specStatus_value).perform();
//				if (cross_button.isDisplayed()) {
//					cross_button.click();
//					GD_specStatus_value.click();
//				}
				Thread.sleep(1000);
				Textbox.sendKeys(specstatus);
				Thread.sleep(1000);
				select_value.click();
				GD_specStatus_value.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				test.log(Status.INFO, "After changing spec status value is :  " + GD_specStatus_value.getText());
			}
			if (ColumnHeader.equals("TechPack Options")) {
				Actions action = new Actions(driver);
				action.doubleClick(GD_TechpackOptions_value).perform();
//				if (cross_button.isDisplayed()) {
//					cross_button.click();
//					GD_TechpackOptions_value.click();
//				}

				Thread.sleep(1000);
				Textbox.sendKeys(techpackoptions);
				Thread.sleep(1000);
				select_value.click();
				GD_TechpackOptions_value.sendKeys(Keys.ENTER);
				test.log(Status.INFO,
						"After changing Techpack option value is :  " + GD_TechpackOptions_value.getText());
				Thread.sleep(2000);

			}

			if (ColumnHeader.equals("Generate TechPack Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(GD_GenerateTechpack_value).perform();
				
				Thread.sleep(1000);
				Textbox.sendKeys("Generate Techpack Now");
				Thread.sleep(1000);
				select_value.click();
				Thread.sleep(1000);
				GD_GenerateTechpack_value.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				Save_button.click();
				Thread.sleep(8000);
				
				if (GD_GenerateTechpack_value.getText().equalsIgnoreCase("Submitted")) {
					Run_button.click();
					Thread.sleep(15000);
					test.log(Status.PASS, "Techpack URL is generated    ");
				}else {
					test.log(Status.PASS, "Techpack URL is generated ");
				}
			}
			
			if (ColumnHeader.equals("Garment TechPack URL")) {
				Thread.sleep(3000);
				test.log(Status.PASS,"tech pack URL- "+ Techpack_URL_Link.getAttribute("href"));
				System.out.println(Techpack_URL_Link.getAttribute("href"));
				Techpack_URL_Link.click();
				Thread.sleep(5000);
			}
		}
	}
	
	public void Download_BULK_BOM_File(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_PD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(1000);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(specStatus_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("Bulk");
				Thread.sleep(2000);
				select_value.click();

				Thread.sleep(2000);
				test.log(Status.INFO, "After changing spec status value is :  " + specStatus_value.getText());
			}
			if (ColumnHeader.equals("TechPack Options")) {

				Actions action = new Actions(driver);
				action.doubleClick(TechpackOptions_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("BOM only");
				Thread.sleep(2000);
				select_value.click();
				test.log(Status.INFO, "After changing techpack options value is :  " + TechpackOptions_value.getText());
				Thread.sleep(2000);

			}
			if (ColumnHeader.equals("Include PC9 in Tech-Pack?")) {
				Thread.sleep(2000);
				if (INcludePC9_value.getText().equalsIgnoreCase("yes")) {

					test.log(Status.INFO, " IncludePC9 value is already checked ");
					System.out.println("IncludePC9 value is already checked");
				} else {
					Actions action = new Actions(driver);
					action.doubleClick(INcludePC9_value).perform();
					IncludePC9_checkbox.click();
					test.log(Status.INFO, " IncludePC9 value is checked  ");
				}
				Thread.sleep(2000);
			}

			if (ColumnHeader.equals("Generate TechPack Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(GenerateTechpack_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("Generate Techpack Now");
				Thread.sleep(2000);
				select_value.click();
				Thread.sleep(2000);
				Save_button.click();
				Thread.sleep(5000);
				if (GenerateTechpack_value.getText().equalsIgnoreCase("Submitted")) {
					Run_button.click();
					test.log(Status.PASS, "After clicking RUN-BULK BOM tech-pack URL is generated   ");
				}
				test.log(Status.PASS, "BULK BOM tech-pack URL is generated");
			}
		}
		System.out.println(BULK_BOM_URL_Link.getAttribute("href"));
		test.log(Status.PASS,"BOM- URL: " +BULK_BOM_URL_Link.getAttribute("href"));
		Thread.sleep(5000);
	}

	public void Download_Proto_BOM_File(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_PD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(1000);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(specStatus_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("proto");
				Thread.sleep(2000);
				select_value.click();

				Thread.sleep(2000);
				test.log(Status.INFO, "After changing spec status value is :  " + specStatus_value.getText());
			}
			if (ColumnHeader.equals("TechPack Options")) {

				Actions action = new Actions(driver);
				action.doubleClick(TechpackOptions_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("BOM only");
				Thread.sleep(2000);
				select_value.click();
				test.log(Status.INFO, "After changing techpack options value is :  " + TechpackOptions_value.getText());
				Thread.sleep(2000);

			}
			if (ColumnHeader.equals("Include PC9 in Tech-Pack?")) {
				Thread.sleep(2000);
				if (INcludePC9_value.getText().equalsIgnoreCase("yes")) {

					test.log(Status.INFO, " IncludePC9 value is already checked ");
					System.out.println("IncludePC9 value is already checked");
				} else {
					Actions action = new Actions(driver);
					action.doubleClick(INcludePC9_value).perform();
					IncludePC9_checkbox.click();
					test.log(Status.INFO, " IncludePC9 value is checked  ");
				}
				Thread.sleep(2000);
			}

			if (ColumnHeader.equals("Generate TechPack Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(GenerateTechpack_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("Generate Techpack Now");
				Thread.sleep(2000);
				select_value.click();
				Thread.sleep(2000);
				Save_button.click();
				Thread.sleep(5000);
				if (GenerateTechpack_value.getText().equalsIgnoreCase("Submitted")) {
					Run_button.click();
					test.log(Status.PASS, "proto BOM tech-pack URL is generated   ");
				}
				test.log(Status.PASS, "Proto BOM tech-pack URL is generated");
			}
		}
		Proto_BOM_URL_Link.click();
		Thread.sleep(5000);
	}
	

	public void Download_Proto_BOM_File_MULTIPLECOLORWAY(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_PD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(1000);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Spec Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(specStatus_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("proto");
				Thread.sleep(2000);
				select_value.click();

				Thread.sleep(2000);
				test.log(Status.INFO, "After changing spec status value is :  " + specStatus_value.getText());
			}
			if (ColumnHeader.equals("TechPack Options")) {

				Actions action = new Actions(driver);
				action.doubleClick(TechpackOptions_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("BOM only");
				Thread.sleep(2000);
				select_value.click();
				test.log(Status.INFO, "After changing techpack options value is :  " + TechpackOptions_value.getText());
				Thread.sleep(2000);

			}
			if (ColumnHeader.equals("Include PC9 in Tech-Pack?")) {
				Thread.sleep(2000);
				if (INcludePC9_value.getText().equalsIgnoreCase("yes")) {

					test.log(Status.INFO, " IncludePC9 value is already checked ");
					System.out.println("IncludePC9 value is already checked");
				} else {
					Actions action = new Actions(driver);
					action.doubleClick(INcludePC9_value).perform();
					IncludePC9_checkbox.click();
					test.log(Status.INFO, " IncludePC9 value is checked  ");
				}
				Thread.sleep(2000);
				if (INcludePC9_value_2.getText().equalsIgnoreCase("yes")) {

					test.log(Status.INFO, " IncludePC9 value is already checked ");
					System.out.println("IncludePC9 value is already checked");
				} else {
					Actions action = new Actions(driver);
					action.doubleClick(INcludePC9_value_2).perform();
					IncludePC9_checkbox.click();
					test.log(Status.INFO, " IncludePC9 value is checked  ");
				}

			}
			if (ColumnHeader.equals("Generate TechPack Status")) {

				Actions action = new Actions(driver);
				action.doubleClick(GenerateTechpack_value).perform();
				Thread.sleep(2000);
				Textbox.sendKeys("Generate Techpack Now");
				Thread.sleep(2000);
				select_value.click();
				Thread.sleep(2000);
				Save_button.click();
				Thread.sleep(5000);
				if (GenerateTechpack_value.getText().equalsIgnoreCase("Submitted")) {
					Run_button.click();
					test.log(Status.PASS, "proto BOM tech-pack URL is generated   ");
				}
				test.log(Status.PASS, "Proto BOM tech-pack URL is generated");
			}
		}
		Proto_BOM_URL_Link.click();
		Thread.sleep(5000);
	}

	public void Read_Techpack_PDF_file(String filepath, ExtentTest test) throws Exception {

		URL pdfUrl = new URL(filepath);
		InputStream ip = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(ip);

		// Load the PDF document
		PDDocument document = PDDocument.load(ip);

		// Extract text from the PDF
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setStartPage(1);
		String pdfText = pdfStripper.getText(document);
		System.out.println(pdfText);

//        if (pdfText.contains("Colorway Codes:")) {
//        	System.out.println(pdfText.lines());
//        	test.log(Status.PASS, "the coloway codes are: "+pdfText.lines());
//        }

	}

}
