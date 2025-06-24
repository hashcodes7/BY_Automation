package com.WMS_ApplicationPages;
import java.lang.reflect.Field;
import java.util.ArrayList;
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

public class SpecificationPage extends WMS_WebDriverUtilities{
	WebDriver driver;
	
	public SpecificationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement Loactors------------------------------------------------------
// -----------------------sourcing attributes--------------------------------------	
	@FindBy(xpath = "//*[@id='contentframe']")
	private WebElement iframeContentframe;
	
	@FindBy(xpath = "//*[text()='Sourcing']")
	private WebElement srcTab;
	
	@FindBy(xpath = "//*[text()='Sourcing']//following::ul[1]/li[1]/a/span[2]")
	private WebElement srcSummary;
	
	@FindBy(xpath = "//*[@id='select2-sourcingConfigId-container']")
	private WebElement source;
	
	@FindBy(xpath = "//*[@id='sourcingConfigId']/option[2]")
	private WebElement sourceValue;
	
	@FindBy(xpath = "//*[@id='lscoIsPrimarySource']/div[2]")
	private WebElement primarySrc;
	
	@FindBy(xpath = "//*[@id='lscoIsCustomSource']/div[2]")
	private WebElement customSrc;
	
	@FindBy(xpath = "//*[@id='lscoProductCode']/div[2]")
	private WebElement productCode;
	
	@FindBy(xpath = "//*[text()='Sourcing Configuration']//following::div[1]")
	private WebElement srcConfigName;
	
	@FindBy(xpath = "//*[@id='lscoSourceName']/div[2]")
	private WebElement srcName;
	
	@FindBy(xpath = "//*[@id='lscoVendor']/div[2]")
	private WebElement vendor;
	
	@FindBy(xpath = "//*[@id='actions-menu']/div/img")
	private WebElement edit;
	
	@FindBy(xpath = "//*[@id='removeSTSL']/span")
	private WebElement removeSrc;
	
	@FindBy(xpath = "//*[@id='product-context-selector']/div[2]/div/div[1]")
	private WebElement sourceBox;
	
	
//-------------------specification attributes------------------------------------
	@FindBy(xpath = "//*[text()='Details']")
	private WebElement prodDetailsTab;
	
	@FindBy(xpath = "//*[text()='Specifications']")
	private WebElement spectab;
	
	@FindBy(xpath = "//*[text()='Specifications']//following::ul[1]/li[1]/a/span[2]")
	private WebElement specSummary;
	
	@FindBy(xpath = "//*[@id='select2-contextSpecId-container']")
	private WebElement specification;
	
	@FindBy(xpath = "//*[@id='contextSpecId']/option[2]")
	private WebElement specValue;
	
	@FindBy(xpath = "//*[@id='lscoIsPrimarySpec']/div[2]")
	private WebElement primarySpec;
	
	@FindBy(xpath = "//*[@id='lscoIsCustomSpec']/div[2]")
	private WebElement customSpec;
	
	@FindBy(xpath = "//*[@id='lscoStatus']/div[2]")
	private WebElement status;
	
	@FindBy(xpath = "//*[@id='lscoProductDesc']/div[2]")
	private WebElement prodDescr;
	
	@FindBy(xpath = "//*[@id='lscoSeasonCode']/div[2]")
	private WebElement season;
	
	@FindBy(xpath = "//*[@id='lscoSpecName']/div[2]")
	private WebElement specName;
	
	@FindBy(xpath = "//*[@id=\"product-context-selector\"]/div[3]/div/div[1]")
	private WebElement specificationName;
	
	@FindBy(xpath = "//span[normalize-space()='Sourcing']")
	private WebElement SourcingFeild;
	
	@FindBy(xpath = "//span[contains(text(),'Sourcing')]/following::span[contains(text(),'Summary')][1]")
	private WebElement summaryOptn;
	
	@FindBy(xpath = "//select[@id='sourcingConfigId']/ancestor::div[1]")
	private WebElement sourceDropdown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement searchField;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement searchOption;
	
	@FindBy(xpath = "//span[@id='select2-contextSpecId-container']")
	private WebElement specDropDownText;
	
	@FindBy(xpath = "//a[@id='ui-id-2']")
	private WebElement specification_tab;
	
	@FindBy(xpath = "//a[@id='ui-id-2']/following-sibling::ul/li[1]/a")
	private WebElement specification_Summary;
	
	@FindBy(xpath = "(//div[@col-id='product-season.lscoAllComponents|~*~|TechpackGeneration:GarmentDeveloperView'])[2]/div/span")
	private WebElement ComponentsProduct_Value;
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoAllComponentsSKU|~*~|TechpackGeneration:GarmentDeveloperView'])[2]/div/span")
	private WebElement ComponentsColorway_Value;
	
	@FindBy(xpath = "//button[@title='Options']")
	private WebElement settings;

	@FindBy(xpath = "//span[@id='pr_id_4_label']")
	private WebElement level_DD;
	
	@FindBy(xpath = "//li[@aria-label='Colorway']")
	private WebElement colorway_value;

	@FindBy(xpath = "//button[@title='Apply Changes']")
	private WebElement ApplyChanges;
	
	@FindBy(xpath = "//div[contains(text(),'Include All Sources')]/following::div[2]")
	private WebElement includeAllSources;
	
	@FindBy(xpath = "//*[text()='Run']")
	private WebElement run;
	
	//-------------------season attributes------------------------------------
	
	@FindBy(xpath = "(//*[text()='Product Name'])[1]")
	private WebElement productName;	

	@FindBy(xpath = "//*[@id='quickSearchText']")
	private WebElement filterData;
	
	@FindBy(xpath = "(//*[contains(@col-id,'AllComponents')])[3]/div[1]/span")
	private WebElement ComponentField;
	
	@FindBy(xpath = "//*[text()='Save']")
	private WebElement save;
	
	@FindBy(xpath = "(//*[text()='Components - Colorway'])[1]")
	private WebElement componentColorway;	

	
	
	
	public void validateLineSheet(ExtentTest test) throws Exception {
		WaitforPage(5000);	
		Assert.assertTrue(productName.isDisplayed());
		System.out.println("linesheet is loaded");
	}
	public void RemoveComponents(ExtentTest test,String product) throws Exception {
		try {
		filterData.sendKeys(product);
		WaitforPage(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", ComponentField);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ComponentField));
		Actions actions = new Actions(driver);
	    actions.doubleClick(ComponentField).perform();
		Thread.sleep(5000);
	//	int count = Integer.parseInt(components);
		List<WebElement> componentElements = driver.findElements(By.xpath("//*[contains(@class,'p-chips-token-icon pi')]"));
		System.out.println("No Of component elements are "+componentElements.size());
		for(int i=0;i<componentElements.size();i++)
		{
			componentElements.get(i).click();
		}
		componentColorway.click();
		WaitforPage(5000);
		save.click();
		WaitforPage(5000);
		String componentsAvailable= ComponentField.getText();
		System.out.println("components Available after remove is "+componentsAvailable);
		if(componentsAvailable.equals("")){
			System.out.println("All componets are removed");
		}
		else		{
			System.out.println("All componets are not removed");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
		@FindBy(xpath = "//*[@id='select2-splId-container']")
		private WebElement seasondrp;
	//*[@id="select2-splId-container"]
		@FindBy(xpath = "//li[@role='option'][1]")
		private WebElement unselseason;

		private boolean Capture;
	
	public void sourcingSummary() throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);		
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcTab)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcSummary)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(source)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceValue)).click();
			Thread.sleep(3000);
		}catch( Exception e) {
			System.out.println("sourcing summary page not loaded");
		}
		
	}
	public void sourcingValidations(ExtentTest test) throws Exception {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);		
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primarySrc));
		String primsrc =primarySrc.getText();
		System.out.println(primsrc);
		test.log(Status.PASS, "primary source value: "+primsrc);
		System.out.println(primsrc);
		Assert.assertEquals(primsrc, "Yes");
		Thread.sleep(2000);
		
		String customsrc = customSrc.getText();
		System.out.println(customsrc);
		test.log(Status.PASS, "custom source object value: "+customsrc);
		System.out.println(customsrc);
		Assert.assertEquals(customsrc, "Yes");
		
		
		Assert.assertTrue(productCode.isDisplayed());
		System.out.println(productCode.getText());
		test.log(Status.PASS, "product code: "+productCode.getText());
		
		Assert.assertTrue(srcConfigName.isDisplayed());
		System.out.println(srcConfigName.getText());
		test.log(Status.PASS, "source configuration name: "+srcConfigName.getText());
			
		String ActualSrcName= srcConfigName.getText();
		String ExpectedSrcName= productCode.getText() +" - "+ srcName.getText() +" -" + vendor.getText();		
		System.out.println(ActualSrcName);
		System.out.println(ExpectedSrcName);
		test.log(Status.PASS, "Primary Source not have a Vendor (Vendor attribute data is always NULL): "+vendor.getText());
		test.log(Status.PASS, "Actual color name: "+ActualSrcName);
		test.log(Status.PASS, "Expected color name: "+ExpectedSrcName);			
		Assert.assertEquals(ActualSrcName, ExpectedSrcName);
	}
	
	public void specificationSummary(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);	
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(prodDetailsTab)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(spectab)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specSummary)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specification)).click();
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specValue)).click();
			test.log(Status.INFO, "specification summary page opens up");
			
		}catch( Exception e) {
			System.out.println("specification summary page not loaded");
		}
		
	}
	public void specificationValidations(ExtentTest test) throws Exception {
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primarySpec));
		String primspec =primarySpec.getText();
		System.out.println(primspec);
		test.log(Status.PASS, "primary specification value: "+primspec);
		Assert.assertEquals(primspec, "Yes");
		
		String customspec = customSpec.getText();
		System.out.println(customspec);
		test.log(Status.PASS, "custom specification object value: "+customspec);
		Assert.assertEquals(customspec, "Yes");
		
		String statusval = status.getText();
		System.out.println(statusval);
		test.log(Status.PASS, "status value: "+statusval);
		Assert.assertEquals(statusval, "Proto");
		
		Assert.assertTrue(productCode.isDisplayed());
		System.out.println(productCode.getText());
		test.log(Status.PASS, "product code: "+productCode.getText());
		
		Assert.assertTrue(prodDescr.isDisplayed());
		System.out.println(prodDescr.getText());
		test.log(Status.PASS, "product description: "+prodDescr.getText());
		
		
		Assert.assertTrue(specName.isDisplayed());
		System.out.println(specName.getText());
		test.log(Status.PASS, "specification name: "+specName.getText());
		
		if(!primspec.equals("Yes"))
		{
		Assert.assertTrue(vendor.isDisplayed());
		System.out.println(vendor.getText());
		test.log(Status.INFO, "vendor Id: "+vendor.getText());
		
		String ActualSpecName= specName.getText();
		String ExpectedSpecName= season.getText() +" - "+productCode.getText() +" - "+ prodDescr.getText() +" - " + vendor.getText();		
		System.out.println(ActualSpecName);
		System.out.println(ExpectedSpecName);
		test.log(Status.INFO, "Actual color name: "+ActualSpecName);
		test.log(Status.INFO, "Expected color name: "+ExpectedSpecName);			
		Assert.assertEquals(ActualSpecName, ExpectedSpecName);
		}
		else
		{
			String ActualSpecName= specName.getText();
			String ExpectedSpecName= season.getText() +" - "+productCode.getText() +" - "+ prodDescr.getText() +" -";		
			System.out.println(ActualSpecName);
			System.out.println(ExpectedSpecName);
			test.log(Status.INFO, "Actual color name: "+ActualSpecName);
			test.log(Status.INFO, "Expected color name: "+ExpectedSpecName);			
			Assert.assertEquals(ActualSpecName, ExpectedSpecName);
		}
		
	}
	
	public void selectSourcingTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SourcingFeild));
		SourcingFeild.click();
	}
	public void clickOnSummary() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(summaryOptn));
		summaryOptn.click();

	}
	
	public void selectSourceFromDropDown(String sourceName, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sourceDropdown));
		sourceDropdown.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys(sourceName);

		Thread.sleep(3000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchOption));
		searchOption.click();

		test.log(Status.INFO, "Selected Source from menu: " + sourceName);
		addSrceenShot("Selected Source from menu", test, Capture);
	}
	
	public void removeSourceFromSeason(ExtentTest test) throws InterruptedException
	{
		String srcBoxName=sourceBox.getText();
        StringBuilder digitStr = new StringBuilder();
        for (char c : srcBoxName.toCharArray()) {
            if (Character.isDigit(c)) {
                digitStr.append(c);
            }
        }
        if (digitStr.length() > 0) {
            int digit = Integer.parseInt(digitStr.toString());
            if (digit > 1) {
            	
            	
	    			String actSrcVal =sourceValue.getText();
	    			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
	                addSrceenShot("Clicked on edit", test, Capture);

	    			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(removeSrc)).click();
	                addSrceenShot("Clicked on remove source", test, Capture);
	                test.log(Status.INFO, "Clicked on 'Remove Source From Season' from 'Actions:' drop down of 'Sourcing Details' Page");

	    			if (new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent()) != null) {
	    				// Switch to the alert and accept it
	    				Alert alt =driver.switchTo().alert();
	    				String ActalertMsg=alt.getText();
	    				String ExpalertMsg="Are you sure you want to remove the Sourcing Configuration?";
	    				Assert.assertEquals(ActalertMsg, ExpalertMsg);
	    				Thread.sleep(2000);
	    				alt.accept();
	    				System.out.println("Alert was present and accepted");
		    			test.log(Status.PASS, "Source Is Removed from Season");

	    			} else {
	    				System.out.println("No alert was present");
		    			test.log(Status.PASS, "Source Is Not Removed from Season");
		                addSrceenShot("No alert was present", test, Capture);


	    			}
	 /*   			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(source)).click();
	    			String expSrcVal =sourceValue.getText();
//	    			Assert.assertNotEquals(actSrcVal, expSrcVal);
	    			System.out.println("source is removed in the sourcing summary page");*/
		
//	    			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasondrp)).click();
//	    			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(unselseason)).click();
//		 
//	    			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(source)).click();
//	    			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceValue)).click();
//	    			Thread.sleep(5000);
//	    			String name=specificationName.getText();
//	    			Assert.assertTrue(name.contains("0"));
//	    			System.out.println("Specification is removed from season");
	    		}
	    	
	    	else
	    	{
	    		System.out.println("More than one source is not available for the product");
	    	}
	    }
		
	}
	
	public void removeSpecFromSeason(ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasondrp)).click();
		test.log(Status.INFO, "Clicked on season dropdown");
	    addSrceenShot("Clicked on season dropdown", test, Capture);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(unselseason)).click();
		test.log(Status.INFO, "Unselected the season");
		addSrceenShot("Unselected the season", test, Capture);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sourceDropdown));
		sourceDropdown.click();
		test.log(Status.INFO, "Clicked on source dropdown");
	    addSrceenShot("Clicked on source dropdown", test, Capture);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys("Primary");
		Thread.sleep(3000);
		searchOption.click();
		test.log(Status.INFO, "Entered 'Primary Source' in search field ");
	    addSrceenShot("Entered 'Primary Source", test, Capture);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specDropDownText));
		String name=specDropDownText.getText();
		Assert.assertEquals(name, "-- None Selected --");
		System.out.println("Specification is removed from season: "+name);
		test.log(Status.PASS, "Specification is removed from season: "+name);
		addSrceenShot("Unselected the season from season drop down", test, Capture);
		
	}
	
	public void removeSpecFromSource(ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specDropDownText));
		String name=specDropDownText.getText();
		Assert.assertEquals(name, "-- None Selected --");
		System.out.println("Specification is removed from source: "+name);
		test.log(Status.PASS, "Specification is removed from source: "+name);
	    addSrceenShot("Specification is removed from source", test, Capture);

	}
	

	
	public String CheckComponents_CarriedOver(ExtentTest test) throws InterruptedException {
		
		String Components="";
		String componentsproduct="";
		String componentscolorway="";
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_GD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(500);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Components - Product")) {
				componentsproduct=ComponentsProduct_Value.getText();
				test.log(Status.INFO,
						" Components Product value is :  " + ComponentsProduct_Value.getText());
				System.out.println(componentsproduct);
			}
			if (ColumnHeader.equals("Components - Colorway")) {

				componentscolorway= ComponentsColorway_Value.getText();
				test.log(Status.INFO,
						"Components Colorway value is " + ComponentsColorway_Value.getText());
				System.out.println(componentscolorway);
				Thread.sleep(2000);
			}	
		}
		Components=componentsproduct+","+componentscolorway;
		System.out.println(Components);
		test.log(Status.INFO,Components);
		return Components;
		
	}
	
	public void NavigateToSpecifications_Summary() throws InterruptedException {
		specification_tab.click();
		specification_Summary.click();
		Thread.sleep(3000);
	}
	public String Components_FromProductsDetails() {
		String components="";
		String components_product="";
		List<WebElement> List=driver.findElements(By.xpath("//div[@class='contents-table card-content']//table/tbody/tr"));
		for(int i=1;i<List.size()-1;i++) {
			components_product=driver.findElement(By.xpath("//div[@class='contents-table card-content']//table/tbody/tr["+(i+1)+"]/td[3]/a")).getText();
			System.out.println(components_product);
			components+=components_product+",";
			
		}System.out.println(components);
		return components;
	}
	

	
	public void SelectColorway(ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			settings.click();
			level_DD.click();
			colorway_value.click();
			System.out.println("Colorway selected");
			WaitforPage(5000);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}	
	public void SelectIncludeAllSources(ExtentTest test) throws Exception {
			 WebElement checkbox = driver.findElement(By.xpath("//div[contains(text(),'Include All Sources')]/following::div[2]"));
             String chkboxStatus= checkbox.getAttribute("class");
			 if (!(chkboxStatus.contains("checked"))) {
                 checkbox.click();                   
             } else {
            	 System.out.println("Checkbox was already selected");            
             }
		System.out.println("Include All Sources selected");
		WaitforPage(5000);
	}
	public void clickOnApply(ExtentTest test) throws Exception {
			ApplyChanges.click();
			WaitforPage(7000);	
			run.click();
			WaitforPage(15000);	
			
	}
	
	public void nonPrimarySourcingValidations(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(customSrc));
		String customsrc = customSrc.getText();
		System.out.println(customsrc);
		test.log(Status.PASS, "custom source object? value: " + customsrc);
		addSrceenShot("custom source object? value", test, Capture);
		System.out.println(customsrc);
		Assert.assertEquals(customsrc, "Yes");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primarySrc));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", primarySrc);
		String primsrc = primarySrc.getText();
		System.out.println(primsrc);
		test.log(Status.PASS, "Is Primary (source)? value: " + primsrc);
		addSrceenShot("Is primary (source)? value", test, Capture);
		System.out.println(primsrc);
		Assert.assertEquals(primsrc, "No");
		Thread.sleep(2000);

		Assert.assertTrue(productCode.isDisplayed());
		System.out.println(productCode.getText());
		test.log(Status.PASS, "product code: " + productCode.getText());
		addSrceenShot("product code", test, Capture);

		Assert.assertTrue(srcConfigName.isDisplayed());
		System.out.println(srcConfigName.getText());
		test.log(Status.PASS, "source configuration name: " + srcConfigName.getText());
		addSrceenShot("source configuration name", test, Capture);

		String ActualSrcName = srcConfigName.getText();
		String ExpectedSrcName = productCode.getText() + " -  - " + vendor.getText();
		System.out.println(ActualSrcName);
		System.out.println(ExpectedSrcName);
		test.log(Status.PASS, "Non Primary Source not have a Source Name (Source Name attribute data is always NULL): "
				+ srcName.getText());
//		Assert.assertEquals(ActualSrcName, ExpectedSrcName);
		// Validate the Sourcing Config Name
		if (ExpectedSrcName.equals(ActualSrcName)) {
			test.log(Status.PASS,
					"Sourcing Config Name is correct and derived from Product Code: " + productCode.getText()
							+ ", Source Name: " + srcName.getText() + ", and Vendor: " + vendor.getText() + ".");
		} else {
			test.log(Status.FAIL, "Sourcing Config Name is incorrect. Expected: " + ExpectedSrcName + ", but found: "
					+ ActualSrcName + ".");
		}
	}

	public void specification_Summary(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(prodDetailsTab)).click();
			test.log(Status.INFO, "Clicked on product details page");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(spectab)).click();
			test.log(Status.INFO, "Clicked on Specifications Tab");
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specSummary)).click();
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specification)).click();
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specValue)).click();
			test.log(Status.INFO, "specification summary page opens up");

		} catch (Exception e) {
			System.out.println("specification summary page not loaded");
		}

	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement DD_textbox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement select_value;

	@FindBy(xpath = "//*[@id='lscoVendorID']/div[2]")
	private WebElement vendorId;

	public void selectSpecificationFromDropDown(String specificationName, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(3000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(specification)).click();
		DD_textbox.sendKeys(specificationName);
		Thread.sleep(2000);
		select_value.click();
		Thread.sleep(2000);
	}

	public void nonPrimaryspecificationValidations(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(customSpec));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", customSpec);
		String customspec = customSpec.getText();
		System.out.println(customspec);
		test.log(Status.PASS, "custom source object? value: " + customspec);
		addSrceenShot("source configuration name", test, Capture);
		Assert.assertEquals(customspec, "Yes");

		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primarySpec));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", primarySpec);
		String primspec = primarySpec.getText();
		System.out.println(primspec);
		test.log(Status.PASS, "Is Primary Specification value? : " + primspec);
		addSrceenShot("Is Primary Specification value?", test, Capture);
		Assert.assertEquals(primspec, "No");

		Thread.sleep(1000);
		String statusval = status.getText();
		System.out.println(statusval);
		test.log(Status.PASS, "status value: " + statusval);
		Assert.assertEquals(statusval, "Proto");

		Thread.sleep(1000);
		Assert.assertTrue(productCode.isDisplayed());
		System.out.println(productCode.getText());
		test.log(Status.PASS, "product code: " + productCode.getText());

		Thread.sleep(1000);
		Assert.assertTrue(prodDescr.isDisplayed());
		System.out.println(prodDescr.getText());
		test.log(Status.PASS, "product description: " + prodDescr.getText());

		Thread.sleep(1000);
		Assert.assertTrue(specName.isDisplayed());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specName);
		System.out.println(specName.getText());
		test.log(Status.PASS, "specification name: " + specName.getText());
		addSrceenShot("specification name", test, Capture);

		String ActualSpecName = specName.getText();
		String ExpectedSpecName = season.getText() + " - " + productCode.getText() + " - " + prodDescr.getText() + " - "
				+ vendorId.getText();
		System.out.println(ActualSpecName);
		System.out.println(ExpectedSpecName);
		test.log(Status.INFO, "Actual Specification name: " + ActualSpecName);
		test.log(Status.INFO, "Expected Specification name: " + ExpectedSpecName);
//		Assert.assertEquals(ActualSpecName, ExpectedSpecName);
		// Validate the Specification Name
		if (ExpectedSpecName.equals(ActualSpecName)) {
			test.log(Status.PASS,
					"Specification Name is correct and derived from Season Code: " + season.getText()
							+ ", Product Code: " + productCode.getText() + ", Product Description: "
							+ prodDescr.getText() + ", and Vendor ID: " + vendorId.getText() + ".");
		} else {
			test.log(Status.FAIL, "Specification Name is incorrect. Expected: " + ExpectedSpecName + ", but found: "
					+ ActualSpecName + ".");
		}
	}

	public boolean verifyVendorIdInSpecifications(String vendorId, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
		List<WebElement> specifications = driver.findElements(By.xpath("//select[@id='contextSpecId']//option"));
		List<String> specTexts = new ArrayList<>();

		// Skip the first option and validate the remaining ones
		for (int i = 1; i < specifications.size(); i++) {
			WebElement specification = specifications.get(i);
			String specText = specification.getText();
			specTexts.add(specText);
			if (!specText.contains(vendorId)) {
				test.log(Status.FAIL, "Vendor ID not found in specification: " + specText);
				return false;
			}
		}

		// Log all specifications in one test log entry
		test.log(Status.INFO, "All specifications: " + String.join(", ", specTexts));
		test.log(Status.PASS, "Vendor ID found in all specifications.");
		return true;
	}

	@FindBy(xpath = "(//div[@col-id='product-season.lscoAllComponents|~*~|TechpackGeneration:GarmentDeveloperView'])[2]//span")
	private WebElement prod_componentField_Text;

	@FindBy(xpath = "(//div[@col-id='product-season.lscoAllComponents|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement prod_ComponentField;

	public void removeComponentFromProductSection(ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(4000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTechpack_GD_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Components - Product")) {
				String componetText = prod_componentField_Text.getText();
				test.log(Status.INFO, "Components-Product text: " + componetText);
				addSrceenShot("Components-Product text", test, Capture);
				Actions actions = new Actions(driver);
				actions.doubleClick(prod_ComponentField).perform();
				Thread.sleep(2000);
				List<WebElement> componentElements = driver
						.findElements(By.xpath("//*[contains(@class,'p-chips-token-label')]"));
				test.log(Status.INFO, "Number of components In Components-Product: " + componentElements.size());
				addSrceenShot("Number of components In Components-Product", test, Capture);

				 StringBuilder componentsLog = new StringBuilder("Components: ");
	                for (WebElement component : componentElements) {
	                    componentsLog.append(component.getText()).append(", ");
	                }
	                test.log(Status.INFO, componentsLog.toString());

				WebElement lastComponent = componentElements.get(componentElements.size() - 1);
				String lastComponentName = lastComponent.getText();
				test.log(Status.INFO, "Removing last component in components-Product: " + lastComponentName);
				addSrceenShot("Removing last component in components-Product", test, Capture);

				WebElement removeButton = lastComponent
						.findElement(By.xpath("following-sibling::*[contains(@class,'pi-times-circle')]"));
				removeButton.click();
				test.log(Status.INFO, "Removed component in components-Product: " + lastComponentName);
				addSrceenShot("Removed component in components-Product", test, Capture);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				save.click();
				test.log(Status.INFO, "Clicked on Save button");
				addSrceenShot("Clicked on Save button", test, Capture);

				Thread.sleep(7000); // Wait for the changes to be saved

				String updatedComponentsText = prod_componentField_Text.getText();
				test.log(Status.INFO, "Updated components text in components-Product: " + updatedComponentsText);
				addSrceenShot("Updated components text in components-Product", test, Capture);

				String[] updatedComponentsArray = updatedComponentsText.split(", ");
				addSrceenShot("Removed component in components-Product", test, Capture);

				boolean isRemoved = true;
				for (String component : updatedComponentsArray) {
					if (component.equals(lastComponentName)) {
						isRemoved = false;
						break;
					}
				}

				assert isRemoved : "Component removal failed for Components-Product";
				break;
			}
		}
	}
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoAllComponentsSKU|~*~|TechpackGeneration:GarmentDeveloperView'])[2]//span")
	private WebElement colorway_componentField_Text;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoAllComponentsSKU|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement colorway_ComponentField;

	public void removeComponentFromColorwaySection(ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(4000);

		String componetText = colorway_componentField_Text.getText();
		test.log(Status.INFO, "Components-Colorway text: " + componetText);
		addSrceenShot("Components-Colorway text", test, Capture);
		Actions actions = new Actions(driver);
		actions.doubleClick(colorway_ComponentField).perform();
		Thread.sleep(2000);
		List<WebElement> componentElements = driver
				.findElements(By.xpath("//*[contains(@class,'p-chips-token-label')]"));
		test.log(Status.INFO, "Number of components in Components-Colorway: " + componentElements.size());
		addSrceenShot("Number of components in Components-Colorway", test, Capture);

		 StringBuilder componentsLog = new StringBuilder("Components: ");
         for (WebElement component : componentElements) {
             componentsLog.append(component.getText()).append(", ");
         }
         test.log(Status.INFO, componentsLog.toString());

		WebElement lastComponent = componentElements.get(componentElements.size() - 1);
		String lastComponentName = lastComponent.getText();
		test.log(Status.INFO, "Removing last component in components-Colorway: " + lastComponentName);
		addSrceenShot("Removing last component in components-Colorway", test, Capture);

		WebElement removeButton = lastComponent
				.findElement(By.xpath("following-sibling::*[contains(@class,'pi-times-circle')]"));
		removeButton.click();
		test.log(Status.INFO, "Removed component in components-Colorway: " + lastComponentName);
		addSrceenShot("Removed component in components-Colorway", test, Capture);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		save.click();
		test.log(Status.INFO, "Clicked on Save button");
		addSrceenShot("Clicked on Save button", test, Capture);

		Thread.sleep(7000); // Wait for the changes to be saved

		String updatedComponentsText = colorway_componentField_Text.getText();
		test.log(Status.INFO, "Updated component text in components-Coloway: " + updatedComponentsText);
		addSrceenShot("Updated component text in components-Coloway", test, Capture);

		String[] updatedComponentsArray = updatedComponentsText.split(", ");
		boolean isRemoved = true;
		for (String component : updatedComponentsArray) {
			if (component.equals(lastComponentName)) {
				isRemoved = false;
				break;
			}
		}

		assert isRemoved : "Component removal failed for Component-Colorway";
	}
	
	public void appendComponentToComponentsProductSection(ExtentTest test, String NewComponent) throws Exception {
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeContentframe);

        Thread.sleep(4000);

        ArrayList<String> header = getTechpack_GD_ColumnHeaderValue();
        for (int i = 0; i < header.size(); i++) {
            String ColumnHeader = header.get(i);
            scroll(i + 3);
            if (ColumnHeader.equals("Components - Product")) {
                String componetText = prod_componentField_Text.getText();
                test.log(Status.INFO, "Components-Product text: " + componetText);
        		addSrceenShot("Components-Product text", test, Capture);
                Actions actions = new Actions(driver);
                actions.doubleClick(prod_ComponentField).perform();
                Thread.sleep(2000);
                WebElement addComponentField = driver.findElement(By.xpath("//input[@id='multiEntryInput']"));
                addComponentField.sendKeys(NewComponent);
                test.log(Status.INFO, "Added component name: " + NewComponent);
        		addSrceenShot("Added component name", test, Capture);

                actions.sendKeys(Keys.ENTER).perform();
                Thread.sleep(2000);
                save.click();
                test.log(Status.INFO, "Clicked on Save button");
        		addSrceenShot("Clicked on Save button", test, Capture);

                Thread.sleep(7000); // Wait for the changes to be saved

                String updatedComponentsText = prod_componentField_Text.getText();
                test.log(Status.INFO, "Updated components text in components-Product: " + updatedComponentsText);
        		addSrceenShot("Updated components text in components-Product", test, Capture);

                String[] updatedComponentsArray = updatedComponentsText.split(", ");
                boolean isAppended = updatedComponentsArray[updatedComponentsArray.length - 1].equals(NewComponent);

                assert isAppended : "Component append failed for Components-Product";
                break;
            }
        }
    }
	
	public boolean isGenerateTechPackEnabled(ExtentTest test) throws Exception {
		
		driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeContentframe); 
        Thread.sleep(2000);
        try {

            WebElement actionsDropdown = driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")); 
            actionsDropdown.click();
            
            WebElement moreOption = driver.findElement(By.xpath("//span[normalize-space()='More...']")); 
            moreOption.click();
            
            WebElement generateTechPackOption = driver.findElement(By.xpath("//span[text()='Generate Tech Pack']")); 
            boolean isEnabled = generateTechPackOption.isEnabled();
            test.log(Status.INFO, "'Generate Tech Pack' option is " + (isEnabled ? "enabled" : "disabled"));
            return isEnabled;
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "'Generate Tech Pack' option not found in Actions Drop Down.");
            return false;
        }
    }
	
	public boolean isAddExistingComponentsEnabled(ExtentTest test) {
        try {
            WebElement addOption = driver.findElement(By.xpath("//span[normalize-space()='Add...']")); 
            addOption.click();
            WebElement addExistingComponentsOption = driver.findElement(By.xpath("//span[normalize-space()='Add Existing Product Specifications']"));
            boolean isEnabled = addExistingComponentsOption.isEnabled();
            test.log(Status.INFO, "'Add Existing Components' option is " + (isEnabled ? "enabled" : "disabled"));
            return isEnabled;
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "'Add Existing Components' option not found in Actions Drop Down.");
            return false;
        }
	}
}	



