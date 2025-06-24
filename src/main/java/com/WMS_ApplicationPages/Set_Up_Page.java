package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class Set_Up_Page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Set_Up_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	boolean Capture = true;
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

	@FindBy(xpath = "(//name-cell-renderer[@class='ng-star-inserted'])[2]/a")
	private WebElement firstcolorway;

	@FindBy(xpath = "//button[@title='Options']")
	private WebElement settings;

	@FindBy(xpath = "//span[@id='pr_id_4_label']")
	private WebElement level_DD;

	@FindBy(xpath = "//button[@title='Apply Changes']")
	private WebElement ApplyChanges;

	@FindBy(xpath = "//li[@aria-label='Colorway']")
	private WebElement colorway_value;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement Action_dropdown;

	@FindBy(xpath = "//a[@id='updateSkuSeason']")
	private WebElement EditColorwaySeason_link;

	@FindBy(xpath = "//input[@id='ptc_bln_5']")
	private WebElement setUpLSE_value;
	
	@FindBy(xpath = "//input[@id='ptc_bln_9']")
	private WebElement setUpLSEValidation_value;

	@FindBy(xpath = "//input[@id='ptc_bln_4']")
	private WebElement setUpLSUSValidation_value;
	
	@FindBy(xpath = "//input[@id='ptc_bln_3']")
	private WebElement setUpLSUS_value;

	@FindBy(xpath = "//input[@id='ptc_bln_5box']//following-sibling::span")
	private WebElement SetUpLSE_checkbox;
	
	@FindBy(xpath = "//input[@id='ptc_bln_9box']//following-sibling::span")
	private WebElement SetUpLSEValidations_checkbox;

	@FindBy(xpath = "//input[@id='ptc_bln_4box']//following-sibling::span")
	private WebElement SetUpLSUSValidations_checkbox;
	
	@FindBy(xpath = "//input[@id='ptc_bln_3box']//following-sibling::span")
	private WebElement SetUpLSUS_checkbox;
	
	

	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement SaveButton;
	
	@FindBy(xpath = "//a[@id='cancelButton']")
	private WebElement CancelButton;

	@FindBy(xpath = "//div[@id='lscoLSEValidationReport']//div[2]")
	private WebElement LSEValidationResults;
	
	@FindBy(xpath = "//div[@id='lscoLSUSValidationReport']/div[2]")
	private WebElement LSUSValidationResults;
	
	@FindBy(xpath = "//div[@id='lscoLSUSValidation']/following-sibling::div[1]//div[2]")
	private WebElement LSEFeedback;
	
	

	@FindBy(xpath = "//div[@id='lscoLSUSStatus']//div[2]")
	private WebElement LSUS_Status;
	
	@FindBy(xpath = "//div[@id='lscoEuAffTriggered']/div[2]")
	private WebElement EU_AFF_Trigger;
	
	@FindBy(xpath = "//div[@id='lscoActivated']/div[2]")
	private WebElement Activated;
	
	@FindBy(xpath = "//div[@id='lscoSendToSAPStatus']/div[2]")
	private WebElement SendToSAP_SetUP;
	
	@FindBy(xpath = "//div[@id='lscoSendToSAPActivate']/div[2]")
	private WebElement SendToSAP_Activate;
	
	@FindBy(xpath = "//div[@id='lscoLSEStatus']/div[2]")
	private WebElement LSE_Status;
	
	@FindBy(xpath = "//div[@id='lscoLSECSTrigger']/div[2]")
	private WebElement SetUpLSE_triggervalue;
	
	@FindBy(xpath = "//div[@id='lscoLSEValidation']/div[2]")
	private WebElement SetUpLSE_Validation_triggervalue;
	
	@FindBy(xpath = "//div[@id='lscoLSEValidationReport']//div[2]/a")
	private WebElement SetUpLSE_Validation_trigger_Result;
	
	@FindBy(xpath = "//a[@id='updateSku']")
	private WebElement EditColorway;
	
	@FindBy(xpath = "//span[@id='select2-ptc_ref_6-container']")
	private WebElement ProductSeg_LSUS_DD;
	
	@FindBy(xpath = "//span[@id='select2-ptc_ref_5-container']")
	private WebElement ProductSeg_LSE_DD;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement ProductSeg_LSUS_TextBox;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement ProductSeg_LSE_TextBox;
	
	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductSeg_LSUS_Selection;
	
	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductSeg_LSE_Selection;
	
	@FindBy(xpath = "//div[@id='lscoProfitCtrUS']//div/a")
	private WebElement ProfitCenterUS;
	
	
//---------------------------------Method----------------------------------------

	public void SeasonDropdown(String season) throws InterruptedException {
		selectValueFromDropdown(SeasonsDropdown, season);
	}

	public void SelectColorway(String colorway) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();
		ApplyChanges.click();
		FilterTextbox.sendKeys(colorway);
		
		Thread.sleep(5000);
//		"1955 501 JEANS"
		firstcolorway.click();
		WaitforPage(5000);

	}

	public void ClickEditColorwayseason() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Action_dropdown.click();
		EditColorwaySeason_link.click();
	}
	
	
	
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement field_searchBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement filtred_option;

	@FindBy(xpath = "//div[contains(text(),'Target Volume [Colorway]')]//following::div[1]//input")
	private WebElement targetVolumeField;

	@FindBy(xpath = "//div[contains(text(),'Collection Type')]//following::div[1]")
	private WebElement collectionTypeField;

	@FindBy(xpath = "//div[contains(text(),'Capsule')]//following::div[1]")
	private WebElement capsuleField;

	@FindBy(xpath = "//div[contains(text(),'Material Type')]//following::div[1]")
	private WebElement materialTypeField;

	@FindBy(xpath = "//div[contains(text(),'Performance')]//following::div[1]")
	private WebElement performanceField;

	@FindBy(xpath = "//div[normalize-space()='Consumer Group']/following::div[1]")
	private WebElement consumerGroupField;

	@FindBy(xpath = "//div[normalize-space()='Consumer Group Ext 1']/following::div[1]")
	private WebElement consumerGroupExt1Field;

	@FindBy(xpath = "//div[normalize-space()='Consumer Group Ext 2']/following::div[1]")
	private WebElement consumerGroupExt2Field;

	@FindBy(xpath = "//div[contains(text(),'Destroy Sample Ind')]//following::div[1]")
	private WebElement destroySampleIndField;

	@FindBy(xpath = "//div[contains(text(),'Profit Center [APD]')]//following::div[1]")
	private WebElement profitCenterAPDField;

	@FindBy(xpath = "//div[contains(text(),'Merch Fabric Type')]//following::div[1]")
	private WebElement merchFabricTypeField;

	@FindBy(xpath = "//div[contains(text(),'Brief Code')]//following::div[1]/textarea")
	private WebElement briefCodeField;

	
	public void updateColorwayFields_SetUpLSE_LSUS(String capsule,String materialType,  String consumerGroup, String consumerGroupExt1,String consumerGroupExt2,
			String destroySampleInd, String profitCenterAPD,ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);
		
		WebElement capsuleFieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(capsuleField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", capsuleFieldElement);
		capsuleFieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(capsule);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement materialTypeFieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(materialTypeField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", materialTypeFieldElement);
		materialTypeFieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(materialType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupField));
		consumerGroupField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroup);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(3000);

		WebElement consumerGroupExt1FieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(consumerGroupExt1Field));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", materialTypeFieldElement);
		consumerGroupExt1FieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroupExt1);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(3000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupExt2Field));
		consumerGroupExt2Field.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroupExt2);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(destroySampleIndField));
		destroySampleIndField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(destroySampleInd);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);
		
		SaveButton.click();
		Thread.sleep(2000);

	}
	

	public void ClickEditColorway() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Action_dropdown.click();
		EditColorway.click();
	}

	public void SetUpLSE(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
			
		if(setUpLSEValidation_value.getAttribute("value").equals("false")) {
			test.log(Status.INFO, "Set UP LSE validation value is: "+ setUpLSEValidation_value.getAttribute("value"));
			
			SetUpLSEValidations_checkbox.click();
			test.log(Status.INFO, "Set UP LSE Validation checkbox clicked");
			System.out.println("Set UP LSE Validation checkbox clicked");
			
		}else {
			System.out.println("Set UP LSE validation value is already TRUE");
			test.log(Status.FAIL, "Set UP LSE validation value is already TRUE");
			CancelButton.click();
		}
		if (setUpLSE_value.getAttribute("value").equals("false")) {
			test.log(Status.INFO, "Set UP LSE value is: "+ setUpLSE_value.getAttribute("value"));
			SetUpLSE_checkbox.click();
			Thread.sleep(2000);
			SaveButton.click();
		} else {
			System.out.println("Set UP LSE value is already TRUE");
			test.log(Status.FAIL, "Set UP LSE value is already TRUE");
			CancelButton.click();
		}
	}
	
	
	
	public void setupLSE_with_updatedSAPattributes(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
			
		if(setUpLSEValidation_value.getAttribute("value").equals("false")) {
			
			SetUpLSEValidations_checkbox.click();
			test.log(Status.INFO, "Set UP LSE Validation checkbox checked");
			System.out.println("Set UP LSE Validation checkbox checked");
			
		}else {
			SetUpLSEValidations_checkbox.click();
			Thread.sleep(500);
			SetUpLSEValidations_checkbox.click();
			System.out.println("Set UP LSE validation checkbox is checked");
			test.log(Status.INFO, "Set UP LSE validation checkbox is checked");
		}
		if (setUpLSE_value.getAttribute("value").equals("false")) {
			SetUpLSE_checkbox.click();
			Thread.sleep(2000);
			SaveButton.click();
		} else {
			SetUpLSE_checkbox.click();
			Thread.sleep(500);
			SetUpLSE_checkbox.click();
			System.out.println("Set UP LSE checkbox is checked");
			test.log(Status.INFO, "Set UP LSE checkbox is checked");
			SaveButton.click();
		}
		
	}
	
	
	public void UncheckBox_SetUpLSE(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (setUpLSE_value.getAttribute("value").equals("true")) {
			SetUpLSE_checkbox.click();
			Thread.sleep(2000);
			SaveButton.click();
		} else {
			System.out.println("Set UP LSE value is already false");
			test.log(Status.FAIL, "Set UP LSE value is already false");
			CancelButton.click();
		}
		
	}

	public void ValidationLSE(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		Assert.assertTrue(LSEValidationResults.getText().contains("No Error"));
		test.log(Status.INFO, "Validation Result"+LSEValidationResults.getText());
		System.out.println("Validation Result"+LSEValidationResults.getText());
		addSrceenShot("Validation Result"+LSEValidationResults.getText(), test, Capture);
		
		Assert.assertTrue(LSE_Status.getText().contains("Processing")||LSE_Status.getText().contains("Completed") );
		test.log(Status.INFO, "Set UP LSE status value is: "+ LSE_Status.getText());
		System.out.println("Set UP LSE status value is: "+ LSE_Status.getText());
		addSrceenShot("Set UP LSE status value is: "+ LSE_Status.getText(), test, Capture);
			
//		Assert.assertTrue(LSEFeedback.getText().contains("has been created or extended"));
//		test.log(Status.INFO, "LSE Feedback is-  "+LSEFeedback.getText());
//		System.out.println("LSE Feedback is-  "+LSEFeedback.getText());
//		addSrceenShot("LSE Feedback is-  "+LSEFeedback.getText(), test, Capture);
		
	}
	
	public void ValidateLSE_productdetailspage(ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		Assert.assertTrue(SetUpLSE_triggervalue.getText().contains("Yes"));
		test.log(Status.INFO, "Set Up LSE value is: "+SetUpLSE_triggervalue.getText());
		System.out.println("Set Up LSE value is: "+SetUpLSE_triggervalue.getText());
		addSrceenShot("Set Up LSE value is: "+SetUpLSE_triggervalue.getText(), test, Capture);
		
		Assert.assertTrue(LSE_Status.getText().contains("Complete"));
		test.log(Status.INFO, "Set UP LSE status value is: "+ LSE_Status.getText());
		System.out.println("Set UP LSE status value is: "+ LSE_Status.getText());
		addSrceenShot("Set UP LSE status value is: "+ LSE_Status.getText(), test, Capture);
		
		Assert.assertTrue(LSEFeedback.getText().contains("has been created or extended"));
		test.log(Status.INFO, "LSE Feedback is-  "+LSEFeedback.getText());
		System.out.println("LSE Feedback is-  "+LSEFeedback.getText());
		addSrceenShot("LSE Feedback is-  "+LSEFeedback.getText(), test, Capture);
		
		
	}
	
	public void Validate_Administrator_Attributes_for_LSE(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		
		Assert.assertTrue(EU_AFF_Trigger.getText().contains("Yes"));
		test.log(Status.INFO, "EU/AFF_Trigger value is: "+EU_AFF_Trigger.getText());
		System.out.println("EU/AFF_Trigger value is: "+EU_AFF_Trigger.getText());
		addSrceenShot("EU/AFF_Trigger value is: "+EU_AFF_Trigger.getText(), test, Capture);
		
		Assert.assertTrue(Activated.getText().contains("completed"));
		test.log(Status.INFO, "Activated? value is: "+Activated.getText());
		System.out.println("Activated? value is: "+Activated.getText());
		addSrceenShot("Activated? value is: "+Activated.getText(), test, Capture);
		
		Assert.assertTrue(SendToSAP_SetUP.getText().contains("Yes"));
		test.log(Status.INFO, "SendToSAP_SetUP value is: "+SendToSAP_SetUP.getText());
		System.out.println("SendToSAP_SetUP value is: "+SendToSAP_SetUP.getText());
		addSrceenShot("SendToSAP_SetUP value is: "+SendToSAP_SetUP.getText(), test, Capture);
		
		Assert.assertTrue(SendToSAP_Activate.getText().contains("Yes"));
		test.log(Status.INFO, "SendToSAP_Activate value is: "+SendToSAP_Activate.getText());
		System.out.println("SendToSAP_Activate value is: "+SendToSAP_Activate.getText());
		addSrceenShot("SendToSAP_Activate value is: "+SendToSAP_Activate.getText(), test, Capture);
		
	}
	
	
	public void validate_NoTriggerSent_LSE(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		Assert.assertTrue(SetUpLSE_triggervalue.getText().contains("No"));
		test.log(Status.INFO, "Set Up LSE value is: "+SetUpLSE_triggervalue.getText());
		System.out.println("Set Up LSE value is: "+SetUpLSE_triggervalue.getText());
		addSrceenShot("Set Up LSE value is: "+SetUpLSE_triggervalue.getText(), test, Capture);
		
		Assert.assertTrue(SetUpLSE_Validation_triggervalue.getText().contains("No"));
		test.log(Status.INFO, "Set Up LSE Validation value is: "+SetUpLSE_Validation_triggervalue.getText());
		System.out.println("Set Up LSE Validation value is: "+SetUpLSE_Validation_triggervalue.getText());
		addSrceenShot("Set Up LSE Validation value is: "+SetUpLSE_Validation_triggervalue.getText(), test, Capture);
		
		Assert.assertTrue(LSE_Status.getText().contains("Validation Error"));
		test.log(Status.INFO, "Set UP LSE status value is: "+ LSE_Status.getText());
		System.out.println("Set UP LSE status value is: "+ LSE_Status.getText());
		addSrceenShot("Set UP LSE status value is: "+ LSE_Status.getText(), test, Capture);
		
		Assert.assertTrue(SetUpLSE_Validation_trigger_Result.getText().contains("Error"));
		test.log(Status.INFO, "Set UP LSE Validation result  is: "+ SetUpLSE_Validation_trigger_Result.getText());
		System.out.println("Set UP LSE Validation result  is: "+ SetUpLSE_Validation_trigger_Result.getText());
		addSrceenShot("Set UP LSE Validation result  is: "+ SetUpLSE_Validation_trigger_Result.getText(), test, Capture);
		
	}
	
	public boolean validateLSEError() {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Assert.assertTrue(SetUpLSE_triggervalue.getText().contains("No"));
		return false;
		
	}
	
	public void Validate_blankSetUp_Attributes(ExtentTest test) {
		if (setUpLSE_value.getAttribute("value").equals("false")) {
			test.log(Status.INFO, "Set UP LSE value is: "+ setUpLSE_value.getAttribute("value"));
			System.out.println("Set UP LSE value is: "+ setUpLSE_value.getAttribute("value"));
			addSrceenShot("Set UP LSE value is: "+ setUpLSE_value.getAttribute("value"), test, Capture);
		}
		if (setUpLSUS_value.getAttribute("value").equals("false")) {
			test.log(Status.INFO, "Set UP LSUS value is: "+ setUpLSUS_value.getAttribute("value"));
			System.out.println("Set UP LSUS value is: "+ setUpLSUS_value.getAttribute("value"));
			addSrceenShot("Set UP LSUS value is: "+ setUpLSUS_value.getAttribute("value"), test, Capture);	
		}
		if(LSEValidationResults.getText().isBlank()) {
			test.log(Status.INFO, "Set UP LSE validation result is blank");
			System.out.println("Set UP LSE validation result is blank");
			addSrceenShot("Set UP LSE validation result is blank", test, Capture);
		}else {
			test.log(Status.FAIL, "Set UP LSE validation result is not blank");
			System.out.println("Set UP LSE validation result is not blank");
		}
		if(LSUSValidationResults.getText().isEmpty()) {
			test.log(Status.INFO, "Set UP LSUS validation result is blank");
			System.out.println("Set UP LSUS validation result is blank");
			addSrceenShot("Set UP LSUS validation result is blank", test, Capture);
			
		}else {
			test.log(Status.FAIL, "Set UP LSUS validation result is not blank");
			System.out.println("Set UP LSUS validation result is not blank");
		}
	}

	public void SetUpLSUS(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		if (setUpLSUS_value.getAttribute("value").equals("false")) {
			test.log(Status.INFO, "Set UP LSUS value is: "+ setUpLSUS_value.getAttribute("value"));
			SetUpLSUS_checkbox.click();
			if(setUpLSUSValidation_value.getAttribute("value").equals("false")) {
				SetUpLSUSValidations_checkbox.click();
				SaveButton.click();
			}else {
				System.out.println("Set UP LSUS validation value is already TRUE");
				test.log(Status.FAIL, "Set UP LSUS validation value is already TRUE");
				CancelButton.click();
			}
			
		} else {
			System.out.println("Set UP LSUS value is already TRUE");
			test.log(Status.FAIL, "Set UP LSUS value is already TRUE");
			CancelButton.click();
		}
	}

	public void ValidationLSUS(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		test.log(Status.INFO, "LSUS Status Result: "+LSUS_Status.getText());
		Assert.assertTrue(LSUS_Status.getText().contains("No Validation Error"));
	}

	public void Update_ProductSegmentation_US(String ProdSegLSUSValue, String ProdSegLSEValue,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ProductSeg_LSUS_DD)).click();
		ProductSeg_LSUS_TextBox.sendKeys(ProdSegLSUSValue);
		ProductSeg_LSUS_Selection.click();
		test.log(Status.INFO, "LSUS value selected: "+ProdSegLSUSValue);
		ProductSeg_LSE_DD.click();
		ProductSeg_LSE_TextBox.sendKeys(ProdSegLSEValue);
		test.log(Status.INFO, "LSE value selected: "+ProdSegLSEValue);
		ProductSeg_LSE_Selection.click();
		SaveButton.click();
	}
	
	public void ValidateProfitCenterUS(String ProdSegLSUSValue,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Action_dropdown));
		String ActualProfitCenter= ProfitCenterUS.getText().substring(0,3);
		String ExpectedProfitCenter= ProdSegLSUSValue.substring(0, 3);
		
		Assert.assertEquals(ExpectedProfitCenter, ActualProfitCenter);
		test.log(Status.INFO, "Actual profit center US: "+ProfitCenterUS.getText());
		test.log(Status.INFO, "Expected profit center US: "+ProdSegLSUSValue);
		System.out.println("Product Segmentaion_LSUS and Profit center US value is same");
	}
	
	
	@FindBy(xpath = "//div[@id='lscoLSEValidation']/div[2]")
	private WebElement details_LSErunvalidtionValue;
	
	@FindBy(xpath = "//div[@id='lscoLSUSValidation']/div[2]")
	private WebElement details_LSUSrunvalidtionValue;
	
	@FindBy(xpath = "//div[@id='lscoLSECSTrigger']/div[2]")
	private WebElement details_LSEtriggerValue;
	
	@FindBy(xpath = "//div[@id='lscoLSUSCSTrigger']/div[2]")
	private WebElement details_LSUStriggerValue;
	
	@FindBy(xpath = "//div[text()='Set Up LSE Feedback from SAP']/following-sibling::div")
	private WebElement details_LSEfeedbackValue;
	
	@FindBy(xpath = "//div[text()='Set Up LSE Status']/following-sibling::div")
	private WebElement details_LSEStatusValue;
	
	@FindBy(xpath = "//div[text()='Set Up LSUS Status']/following-sibling::div")
	private WebElement details_LSUSStatusValue;
	
	@FindBy(xpath = "//div[@id='lscoLSEValidationReport']/div[2]")
	private WebElement details_LSEvalidationresultValue;
	

}
