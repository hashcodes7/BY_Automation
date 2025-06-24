package com.WMS_ApplicationPages;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class CreateNewColorPage extends WMS_WebDriverUtilities{
	WebDriver driver;
	
	public CreateNewColorPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	boolean Capture = true;
//	WebElement Loactors------------------------------------------------------
// -----------------------Create color(Heathers)--------------------------------------	
	@FindBy(xpath = "//img[@title='Create New Color']")
	private WebElement PlusSign;
	
	@FindBy(xpath = "//a[contains(text(),'Prints and Patterns')]")
	private WebElement printAndPatterns;
	
	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;
	
	@FindBy(xpath = "//iframe[@name='materiallibraryframe']")
	private WebElement iframeMaterialframe;
	
	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;
	
	@FindBy(xpath = "//input[@name='redValue']")
	private WebElement RedValue;
	
	@FindBy(xpath = "//input[@name='grnValue']")
	private WebElement GreenValue;
	
	@FindBy(xpath = "//input[@name='bluValue']")
	private WebElement BlueValue;
	
	@FindBy(xpath = "//input[@id='ptc_str_5']")
	private WebElement ColorName;
	
	@FindBy(xpath = "//select[@id='ptc_str_4']")
	private WebElement ColorFamily;
	
	@FindBy(xpath = "//select[@id='ptc_str_27']")
	private WebElement Color;
	
	@FindBy(xpath = "//select[@id='ptc_str_29']")
	private WebElement FinishType;
	
	@FindBy(xpath = "//td[@class='DISPLAYTEXT']")
	private WebElement Color_name;
	
	@FindBy(xpath = "//select[@id='ptc_str_11']")
	private WebElement StandardProvider;
	
	@FindBy(xpath = "//input[@id='ptc_str_9']")
	private WebElement ColorCode;
	
	@FindBy(xpath = "//input[@id='ptc_str_10']")
	private WebElement ProviderColorName;
	
	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement Createbutton;
	
//-------------------Createcolor(Print and patterns)------------------------------------
	
	@FindBy(xpath = "//input[@id='ptc_str_18']")
	private WebElement ArtWorkName;
	
	@FindBy(xpath = "//input[@id='ptc_str_19']")
	private WebElement ArtWorkCode;
	
	@FindBy(xpath = "//select[@id='ptc_str_11']")
	private WebElement PatternType;
	
	@FindBy(xpath = "//input[@id='ptc_str_9']")
	private WebElement ColorCombo;
	
	@FindBy(xpath = "//a[normalize-space()='LS&Co. Developer:']")
	private WebElement Lsco_Developer;
	
	@FindBy(xpath = "//div[@id='ptc_ref_2Display']/input")
	private WebElement Lsco_DeveloperTextBox;
	
	@FindBy(xpath = "//a[@id='2038473709']")
	private WebElement Createdcolourname;
	
	@FindBy(xpath = "//table[@id='selector_Table']//tr[2]/td")
	private WebElement Lsco_DeveloperDD;
	
	
	
// -------------------------------Create color (Seasonal look BFF)------------------------------
	
	@FindBy(xpath = "//a[contains(text(),'Seasonal Look BFF')]")
	private WebElement SeasonalLookBFF;
	
	@FindBy(xpath = "//select[@id='ptc_str_25']")
	private WebElement Base;
	
	@FindBy(xpath = "//select[@id='ptc_str_33']")
	private WebElement Tier;
	
	@FindBy(xpath = "(//a[normalize-space()='------'])[1]")
	private WebElement Season;
	
	@FindBy(xpath = "(//a[normalize-space()='------'])[2]")
	private WebElement FACode;
	
	@FindBy(xpath = "//div[@id='ptc_verRef_1Display']/input")
	private WebElement SeasonTextBox;
	
	@FindBy(xpath = "//table[@id='selector_Table']//tr[2]/td")
	private WebElement Season_DD;
	
	@FindBy(xpath = "//div[@id='ptc_verRef_2Display']/input")
	private WebElement FA_CodeTextBox;
	
	@FindBy(xpath = "//table[@id='selector_Table']//tr[2]/td")
	private WebElement FACode_DD;
	
//	--------------------------------View color page------------------------------------------------
	@FindBy(xpath = "(//table//td[@class='DISPLAYTEXT'])[1]")
	private WebElement ViewColorName;
	
	@FindBy(xpath = "//td[@id='lscoSeason']/a")
	private WebElement ViewSeason;
	
	@FindBy(xpath = "//td[@id='lscoLook']/a")
	private WebElement ViewLook;
	
	@FindBy(xpath = "//td[@id='lscoColorCode']")
	private WebElement ViewColorCode;
	
	@FindBy(xpath = "//td[@id='lscoFinishDevelopmentTrack']")
	private WebElement FinishedDevelopmentTrack;
	
	@FindBy(xpath = "(//td[@class='PAGEHEADINGTEXT']/select)[1]")
	private WebElement Update_DD;
	
	@FindBy(xpath = "(//table//td[@class='DISPLAYTEXT'])[1]")
	private WebElement LookName;
	
	@FindBy(xpath = "(//img[@id='searchButton'])[1]")
	private WebElement SearchButton;
	
	@FindBy(xpath = "(//span[text()='Search'])")
	private WebElement ColorSearchButton;
	
	@FindBy(xpath = "//input[@id='ptc_str_3']")
	private WebElement UpdateColorCode;
	
	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement SaveButton;
	
	@FindBy(xpath = "(//td[@class='DISPLAYTEXT'])[1]")
	private WebElement ViewLookName;
	
	@FindBy(xpath = "//input[@id='ptc_str_28']")
	private WebElement UpdateFACode;
	 
	@FindBy(xpath = "//select[@id='ptc_str_25']//option[@selected]")
	private WebElement SelectedBase;
	
	@FindBy(xpath = "//select[@id='ptc_str_33']//option[@selected]")
	private WebElement SelectedTier;
	
	@FindBy(xpath = "//td[@id='lscoSeason']/a")
	private WebElement SeasonName;
	
	@FindBy(xpath = "//input[@id='ptc_str_3']")
	private WebElement Colorcode;
	
	@FindBy(xpath = "//td[contains(text(),'Look Name')]/following-sibling::td[1]")
	private WebElement Lookname;
	
	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement Searchbutton;
	
	@FindBy(xpath = "//td[@class='SEARCH_RESULTS_BAR']/span/a[contains(text(),'Show All')]")
	private WebElement ShowALL;
	
	@FindBy(xpath = "//a[text()='Season:']")
	private WebElement Lsco_Season;
	
	@FindBy(xpath = "//a[normalize-space()='FA Code:']")
	private WebElement Lsco_FAcode;
	
	@FindBy(xpath = "//iframe[@id='materiallibraryframe']")
	private WebElement materialframe;
	
	@FindBy(xpath = "//input[@class='ng-tns-c62-268 p-inputtext p-component ng-star-inserted']")
	private WebElement CreatedFrom;
	
	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement filter_FAcode;
	
	@FindBy(xpath = "//a[normalize-space()='(choose)']")
	private WebElement Choose_FAcode;
	
	@FindBy(xpath = "//input[@id='ptc_str_5']")
	private WebElement Look_Name_FG;
	
	@FindBy(xpath = "//*[@id='ptc_str_1']")
	private WebElement nameField;
	
	@FindBy(xpath = "//*[@id='ptc_str_5']")
	private WebElement colorName;
	
	public void createcolorSundry(String name,String Redvalue, String bluevalue, String greenvalue, String colorname,
			String colorfamily,ExtentTest test ) throws InterruptedException {
		nameField.sendKeys(name);
		RedValue.sendKeys(Redvalue);
		GreenValue.sendKeys(greenvalue);
		BlueValue.sendKeys(bluevalue);
		Thread.sleep(2000);
		colorName.sendKeys(colorname);
		selectValueFromDropdown(ColorFamily,colorfamily);
		Thread.sleep(2000);
		
		test.log(Status.INFO, "Value for " +"Name: "+name+",Redvalue: "+Redvalue+",greenvalue: "+greenvalue+",bluevalue: "+bluevalue+",colorname: "+
				colorname+",colorfamily: " +colorfamily);
	}
	
	public void clickplussign() throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);		
			PlusSign.click();
			
		}catch( Exception e) {
			System.out.println("string menu" +":");
		}
		
	}
	public void selectColor(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" +":"+submenu);
		driver.findElement(By.xpath("//div[@id='librariesContent']/a[5]")).click();
		
	}
	public void SelectColorType(String colortype,ExtentTest test) {
		driver.findElement(By.xpath("//a[text()='"+colortype+"']")).click();
	}
	
	public void EnterValues(String Redvalue, String bluevalue, String greenvalue, String colorname, 
			String colorfamily,String standardprovider, String colorcode, String providercolorname,ExtentTest test) throws Exception {
		
		RedValue.sendKeys(Redvalue);
		GreenValue.sendKeys(greenvalue);
		BlueValue.sendKeys(bluevalue);
		ColorName.sendKeys(colorname);
		selectValueFromDropdown(ColorFamily,colorfamily);
		selectValueFromDropdown(StandardProvider,standardprovider);
		ColorCode.sendKeys(colorcode);
		ProviderColorName.sendKeys(providercolorname);
		
		test.log(Status.INFO, "Value for " +"Redvalue: "+Redvalue+",greenvalue: "+greenvalue+",bluevalue: "+bluevalue+",colorname: "+
				colorname+",colorfamily: " +colorfamily+",standardprovider: "+standardprovider+",colorcode: "+colorcode+
				",providercolorname: "+providercolorname);
	}
	
//	public void EnterValues() {
//		RedValue.sendKeys("120");
//		GreenValue.sendKeys("200");
//		BlueValue.sendKeys("140");
//		ColorName.sendKeys("Autotest2");
//		selectValueFromDropdown(ColorFamily,"Blues");
//		selectValueFromDropdown(StandardProvider,"Custom");
//		ColorCode.sendKeys("123423");
//		ProviderColorName.sendKeys("Lightblue");
//	}
	public void clickcreatebutton() throws InterruptedException {
		Createbutton.click();
	}
	public void createcolorPrintsandPatterns(String Redvalue, String bluevalue, String greenvalue, String artworkname,
			String artworkcode, String colorfamily,String patterntype,String colorcombo,String developer,ExtentTest test ) throws InterruptedException {
		RedValue.sendKeys(Redvalue);
		GreenValue.sendKeys(greenvalue);
		BlueValue.sendKeys(bluevalue);
		Thread.sleep(2000);
		ArtWorkName.sendKeys(artworkname);
		ArtWorkCode.sendKeys(artworkcode);
		selectValueFromDropdown(ColorFamily,colorfamily);
		selectValueFromDropdown(PatternType,patterntype);
		ColorCombo.sendKeys(colorcombo);
		
		Thread.sleep(2000);
		
		Lsco_Developer.click();
		developervalue(developer,test);
		Thread.sleep(2000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		test.log(Status.INFO, "Value for " +"Redvalue: "+Redvalue+",greenvalue: "+greenvalue+",bluevalue: "+bluevalue+",artworkname: "+
				artworkname+",colorfamily: " +colorfamily+",artworkcode: "+artworkcode+",patterntype: "+patterntype+
				",colorcombo: "+colorcombo+" and colorcombo: "+colorcombo);
	}
	
	public void developervalue(String developername,ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Searchbutton)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowALL)).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for(int i=1;i<=list.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[2]/a"));
			if(ele.getText().equals(developername)) {
				test.log(Status.INFO, "developername selected: "+developername);
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[1]/a")).click();
				break;
			}
		}
		
	}
	
	public void EnterSeasonalBFFValues(String season,String Redvalue, String bluevalue, String greenvalue, String colorfamily,String tier,String base,String facode,String createdfrom,ExtentTest test) throws InterruptedException{
		try {
			RedValue.sendKeys(Redvalue);
			GreenValue.sendKeys(greenvalue);
			BlueValue.sendKeys(bluevalue);
			Thread.sleep(2000);
			selectValueFromDropdown(Base,base);
			Thread.sleep(1000);
			selectValueFromDropdown(Tier,tier);
			Thread.sleep(1000);
			selectValueFromDropdown(ColorFamily,colorfamily);
			
			Thread.sleep(2000);
			
			Lsco_FAcode.click();
			FAcodeValue_seasonallookBFF(createdfrom,facode,test);
			Thread.sleep(2000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(0));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			Lsco_Season.click();
			SeasonValue_seasonallookBFF(season,test);
			Thread.sleep(2000);
			Set<String> allWindowHandle = driver.getWindowHandles();
			ArrayList<String> tab = new ArrayList<>(allWindowHandle);
			driver.switchTo().window(tab.get(0));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			Thread.sleep(2000);
			test.log(Status.INFO, "Value for " +"Season: "+season+" Redvalue: "+Redvalue+",greenvalue: "+greenvalue+",bluevalue: "+bluevalue+",season: "+
					season+",colorfamily: " +colorfamily+",tier: "+tier+",base: "+base+", created from: "+createdfrom+
					" and facode: "+facode);

		}catch(Exception e) {
				System.out.println("filling Invalid details");
		}
	}
	
	public void EnterSeasonalFG_Values(String season,String Redvalue, String bluevalue, String greenvalue, String colorfamily,String color,String finishtype,String lookname,ExtentTest test) {
		try {
			
			RedValue.sendKeys(Redvalue);
			GreenValue.sendKeys(greenvalue);
			BlueValue.sendKeys(bluevalue);
			Look_Name_FG.sendKeys(lookname);
			Thread.sleep(2000);
			
			Lsco_Season.click();
			SeasonValue_seasonallookBFF(season,test);
			Thread.sleep(2000);
			Set<String> allWindowHandle = driver.getWindowHandles();
			ArrayList<String> tab = new ArrayList<>(allWindowHandle);
			driver.switchTo().window(tab.get(0));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			Thread.sleep(2000);
			selectValueFromDropdown(ColorFamily,colorfamily);
			Thread.sleep(1000);
			selectValueFromDropdown(Color,color);
			Thread.sleep(1000);
			selectValueFromDropdown(FinishType,finishtype);	
			Thread.sleep(1000);
			
			test.log(Status.INFO, "Value for " +"Redvalue: "+Redvalue+",greenvalue: "+greenvalue+",bluevalue: "+bluevalue+",color: "+
					color+",colorfamily: " +colorfamily+",lookname: "+lookname+",finishtype: "+finishtype+", and season: "+ season);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void Validate_Color_FG(String season,String lookname,ExtentTest test) {
		String Actualcolorname=Color_name.getText();
		String Expectedcolorname=season+" "+lookname;
		if(Actualcolorname.equals(Expectedcolorname)) {
			System.out.println("seasonal look FG color validated and the color name is: "+Actualcolorname);
			test.log(Status.INFO, "seasonal look FG color validated and the color name is: "+Actualcolorname);
		}
	}
	
	public void EnterSolidColors_Values(String Redvalue, String bluevalue, String greenvalue, String colorfamily,String standardprovider,String colorcode,String colorname,String providercolorname,ExtentTest test) throws InterruptedException {
		RedValue.sendKeys(Redvalue);
		GreenValue.sendKeys(greenvalue);
		BlueValue.sendKeys(bluevalue);
		Thread.sleep(2000);
		ColorName.sendKeys(colorname);
		selectValueFromDropdown(ColorFamily,colorfamily);
		selectValueFromDropdown(StandardProvider,standardprovider);
		ColorCode.sendKeys(colorcode);
		
		ProviderColorName.sendKeys(providercolorname);
		test.log(Status.INFO, "Value for " +"Redvalue: "+Redvalue+",greenvalue: "+greenvalue+",bluevalue: "+bluevalue+",colorname: "+
				colorname+",colorfamily: " +colorfamily+",standardprovider: "+standardprovider+",colorcode: "+colorcode+
				",providercolorname: "+providercolorname);
		
	}
	
	public void Validate_SolidColors(String colorname,ExtentTest test) {
		String Actualcolorname=ViewLookName.getText();
		if(Actualcolorname.contains(colorname)) {
			System.out.println("Solid Color created and validated with name: " +Actualcolorname);
			test.log(Status.INFO, "Solid color Created and validated with name : "+Actualcolorname);
		}
	}
	
	
	public void SeasonValue_seasonallookBFF(String season,ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//input[@id='quickSearchCriteria']")).sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Searchbutton)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowALL)).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for(int i=1;i<=list.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[2]/a"));
			if(ele.getText().equals(season)) {
				test.log(Status.INFO, "season name selected: "+season);
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[1]/a")).click();
				break;
			}
		}	
	}
	public void FAcodeValue_seasonallookBFF(String createdfrom,String facode,ExtentTest test) throws Exception {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(materialframe);
		
		CreatedFrom.sendKeys(createdfrom);
		CreatedFrom.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		filter_FAcode.sendKeys(facode);
		Thread.sleep(2000);
		Choose_FAcode.click();	
		
	}
	
	
	
	
	public void ValidateRequiredfields(String season,String Redvalue, String bluevalue, String greenvalue,String facode,String createdfrom,ExtentTest test) throws Exception {
		WebElement[] str= {RedValue,GreenValue,BlueValue,Base,Tier,ColorFamily,Lsco_FAcode,Lsco_Season};			
		for (int i=0;i<=str.length;i++) {
			WebElement field= str[i];
			if (field.equals(RedValue)){
				field.clear();
				driver.switchTo().alert().accept();
				test.log(Status.INFO, "Got Error popups for"+field+"field");
				Thread.sleep(2000);
				field.sendKeys(Redvalue);
				Createbutton.click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();

			}
			else if (field.equals(GreenValue)||field.equals(BlueValue)){
				System.out.println(field);
				field.clear();
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				field.sendKeys(greenvalue);
				Createbutton.click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				
			}
			else if(field.equals(Base)||field.equals(Tier)||field.equals(ColorFamily)){
				
				selectValueFromDropdown(field,3);
				Createbutton.click();
				driver.switchTo().alert().accept();
			}
			else if(field.equals(Lsco_Season)){
				field.click();
				Thread.sleep(2000);
				SeasonValue_seasonallookBFF(season,test);
				Set<String> allWindowHandle = driver.getWindowHandles();
				ArrayList<String> tab = new ArrayList<>(allWindowHandle);
				driver.switchTo().window(tab.get(0));
				driver.switchTo().defaultContent();
				driver.switchTo().frame(iframeContentframe);
				Createbutton.click();
				break;
			}
			else {
				field.click();
				FAcodeValue_seasonallookBFF(createdfrom,facode,test);
				Thread.sleep(2000);
				Set<String> allWindowHandles = driver.getWindowHandles();
				ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
				driver.switchTo().window(tabs.get(0));
				driver.switchTo().defaultContent();
				driver.switchTo().frame(iframeContentframe);
				Createbutton.click();
				driver.switchTo().alert().accept();
			}
			
//			driver.switchTo().alert().accept();
			test.log(Status.INFO, "Got Error popups for "+field+"field");
			WaitforPage(2000);
		}
	}
	public void VerifyViewColor(ExtentTest test) {
		String ActualName= ViewColorName.getText();
		String ExpectedName= ViewSeason.getText() +" "+ ViewColorCode.getText() +" " + ViewLook.getText();
		
		System.out.println(ActualName);
		System.out.println(ExpectedName);
		test.log(Status.INFO, "Actual color name: "+ActualName);
		test.log(Status.INFO, "Expected color name: "+ExpectedName);
		
		Assert.assertEquals(ActualName, ExpectedName);

		Assert.assertTrue(ViewLook.isDisplayed());
		System.out.println(ViewLook.getText());
		test.log(Status.INFO, "view look name: "+ViewLook.getText());
		
		Assert.assertEquals(FinishedDevelopmentTrack.getText(),"Traditional");
		System.out.println(FinishedDevelopmentTrack.getText());
		test.log(Status.INFO, "Finished development track value: "+FinishedDevelopmentTrack.getText());
	}
	
	public void Action_update_DD() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Select select = new Select(Update_DD);
		select.selectByIndex(1);
		
	}
	public void Validate_updatecolor(ExtentTest test) {
		String ActualName= ViewLookName.getText();
		String seasonname= SeasonName.getText();
		String colorcode= Colorcode.getAttribute("value");
		String lookname= Lookname.getText();
		String ExpectedName= seasonname+" "+colorcode+" "+lookname;
		
		System.out.println("Validation: color loook name is matching "+ActualName+" and after update "+ ExpectedName);
		test.log(Status.PASS, "Validation: color loook name is matching before "+ActualName+" and after update "+ ExpectedName);
	}

	public void searchButton() {
		SearchButton.click();		
	}
	
	public void savebutton() {
		SaveButton.click();
	}
	public void searchBox(String Colorname) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys(Colorname);
		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
	}
	public void color_validation(String colorname,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		List<WebElement> ColorName = driver.findElements(By.xpath("//div[@class='table-wrapper']//tr/td[3]/a"));
		for (WebElement CN:ColorName) {
			String Name=CN.getText();
			if (Name.contains(colorname)) {
				test.log(Status.PASS, "The colorname generated in UI: "+Name +" "
						+ "and the colorname user sent contains : "+colorname);
				System.out.println("The colorname generated in UI: "+Name +" "
						+ "and the colorname user sent contains : "+colorname);
			}
		}
	}
	public void PrintsandPatterns_color_validation(String artworkname,ExtentTest test) {
		String look=ViewLookName.getText();
		Assert.assertTrue(look.contains(artworkname));
		test.log(Status.PASS, "The artworkname generated in UI: "+look +" "
				+ "and the colorname user sent  : "+artworkname);
	}
	
//---------------------------------------------------------------------------------------------------------------
//	````````````````````````````````````````P2 Methods`````````````````````````````````````````````````````````````
//	-------------------------------------------------------------------------------------------------------------------
	@FindBy(xpath = "//div[@class='p-multiselect-label ng-tns-c34-3 p-placeholder']")
	private WebElement ColorLookDropdown;
	
	@FindBy(xpath = "//div[@aria-label='LSCO']/button")
	private WebElement LSCOmenu;
	
	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;
	
	public void SelectColorLook_colorpage(String colormenu , String colorsubmenu, String filtercolor, ExtentTest test) throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		WebElement colorLookDropdown = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		colorLookDropdown.click();
		
		test.log(Status.INFO, "Color menu selected: "+colormenu);
		LSCOmenu.click();
		List<WebElement> list=driver.findElements(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div"));
		for(WebElement ele:list) {
			if(ele.getAttribute("aria-label").equals(colormenu)) {
				if(colormenu.equals("Looks") || colormenu.equals("Sundry Color")) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"+colormenu+"']")).click();
				}else if(colormenu.equals("Colors") || colormenu.equals("Seasonal Look")){
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"+colormenu+"']/button")).click();
					List<WebElement> col=driver.findElements(By.xpath("//div[@aria-label='"+colormenu+"']/following-sibling::ul/p-treenode//div"));
					for (WebElement submenu:col){	
						Thread.sleep(2000);
						if(submenu.getAttribute("aria-label").equals(colorsubmenu)) {
							test.log(Status.INFO, "Color submenu selected: "+colorsubmenu);
							submenu.click();
							Thread.sleep(2000);
							
						}				
					}
				}
			}	
		}
		
		Thread.sleep(2000);
		ColorSearchButton.click();
		
		Thread.sleep(10000);
		FilterTextbox.sendKeys(filtercolor);
		test.log(Status.INFO, "filter Color value: "+filtercolor);
		
	}
	
	@FindBy(xpath = "//div[contains(text(),'Name')]/following-sibling::div[1]//input[1]")
	private WebElement BFF_FG_nameInput;
	
	public void SelectSeasonalColorLook_colorpage(String colormenu , String colorsubmenu, String filtercolor, ExtentTest test) throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		WebElement colorLookDropdown = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		colorLookDropdown.click();
		
		test.log(Status.INFO, "Color menu selected: "+colormenu);
		LSCOmenu.click();
		List<WebElement> list=driver.findElements(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div"));
		for(WebElement ele:list) {
			if(ele.getAttribute("aria-label").equals(colormenu)) {
				if(colormenu.equals("Looks") || colormenu.equals("Sundry Color")) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"+colormenu+"']")).click();
				}else if(colormenu.equals("Colors") || colormenu.equals("Seasonal Look")){
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"+colormenu+"']/button")).click();
					List<WebElement> col=driver.findElements(By.xpath("//div[@aria-label='"+colormenu+"']/following-sibling::ul/p-treenode//div"));
					for (WebElement submenu:col){	
						Thread.sleep(2000);
						if(submenu.getAttribute("aria-label").equals(colorsubmenu)) {
							test.log(Status.INFO, "Color submenu selected: "+colorsubmenu);
							submenu.click();
							Thread.sleep(2000);
							
						}				
					}
				}
			}	
		}
//		Levi's S1 2025 Female Accessories Auto__02
		Thread.sleep(2000);
		BFF_FG_nameInput.sendKeys(filtercolor);
		Thread.sleep(2000);	
		
		Thread.sleep(2000);
		ColorSearchButton.click();
		
		Thread.sleep(5000);

	}
	
	
	@FindBy(xpath = "//div[@role='gridcell']//a[@class='ng-star-inserted']")
	private WebElement FirstSolid_color;
	
	@FindBy(xpath = "//td[@class='PAGEHEADINGTEXT']/select")
	private WebElement Actions;
	
	@FindBy(xpath = "//td[contains(text(),'LS&Co. Color Name')]/following-sibling::td/input")
	private WebElement LSCO_colorName;
	
	@FindBy(xpath = "//a[@id='copyColorButton']")
	private WebElement Copy_button;
	
	@FindBy(xpath = "//td[@id='lscoColorName']")
	private WebElement colorname;
	
	@FindBy(xpath = "(//div[@col-id='color.name|~*~|Solids'])[2]//a")
	private WebElement filtered_Color;
	
	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement Edit_button;
	
	@FindBy(xpath = "(//a[@id='insertButton'])")
	private WebElement Insert_button;
	
	@FindBy(xpath = "(//td[contains(@id,'lscoFinishFormula')])")
	private WebElement AddfinishFormula_button;
	
	@FindBy(xpath = "(//td[contains(@id,'lscoFinishFormula')])//a")
	private WebElement finishFormula_link;
	
	@FindBy(xpath = "(//a[@class='pointer-link ng-star-inserted'])[1]")
	private WebElement choosenFirstColor;
	
	@FindBy(xpath = "(//td[contains(@id,'lsocPrimaryIndicator')])")
	private WebElement PrimaryIndicator;
	
	@FindBy(xpath = "//input[@id='ptc_bln_1box']/following-sibling::span")
	private WebElement PrimaryIndicator_checkbox;
	
	@FindBy(xpath = "(//td[contains(@id,'lscoFinishFormula')])[1]")
	private WebElement finishformulafield;
	
	@FindBy(xpath = "(//td[contains(@id,'lscoFabricMill')])")
	private WebElement FabricMillfield;
	
	@FindBy(xpath = "(//input[@id='checkboxlist'])/following-sibling::span")
	private WebElement looktablelement;
	
	@FindBy(xpath = "(//a[@class='table-header-icons']/img)[1]")
	private WebElement deletebutton;
	
	@FindBy(xpath = "//a[@id='saveCheckInButton']")
	private WebElement Saveandclosebutton;
	
	@FindBy(xpath = "//td[@id='lscoLook']/a")
	private WebElement Looklink;
	
	
	public void Click_Solids_Color() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getcolor_Solids_ColumnHeaderValue();
		for (int i = 0; i < header.size() ; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("LS&Co. Color")) {
				FirstSolid_color.click();
				Thread.sleep(3000);
			}
			}
	}
	
	public void NavigateTo_CopyColorPage() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		selectValueFromDropdown(Actions, "Copy Color");

	}
	
	
	public void Copy_SolidColor(String newcolorname) throws InterruptedException {
		LSCO_colorName.clear();
		Thread.sleep(1000);
		LSCO_colorName.sendKeys(newcolorname);
		Thread.sleep(2000);
		Copy_button.click();
	}
	
	public void Validate_CopiedColor(String newcolorname,ExtentTest test) throws InterruptedException {
		String Actual_colorname= colorname.getText();
		String Expected_colorname= newcolorname;
		if(Actual_colorname.equals(Expected_colorname)) {
			System.out.println("Actual color Name is:  "+Actual_colorname+"  and the Expected color name is : " +Expected_colorname+" Both  are Matching ");
			test.log(Status.INFO,"Actual color Name is:  "+Actual_colorname+"  and the Expected color name is : " +Expected_colorname+" Both   are Matching ");
			addSrceenShot("Actual color Name is:  "+Actual_colorname+"  and the Expected color name is : " +Expected_colorname+" Both are Matching ", test, Capture);
		
		}
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		FilterTextbox.clear();
		Thread.sleep(2000);
		FilterTextbox.sendKeys(newcolorname);
		test.log(Status.INFO, "filter Color value: "+newcolorname);
		
		Thread.sleep(2000);
		ColorSearchButton.click();
		
		
		if(filtered_Color.getText().contains(Expected_colorname)) {
			System.out.println("The copied color is present in Solid colors list");
			test.log(Status.INFO,"The copied color is present in Solid colors list");
			addSrceenShot("The copied color is present in Solid colors list ", test, Capture);
		
		}
		
	}
	
	public void NavigateTo_EditLookInformationPage() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Edit_button));
		Edit_button.click();
		
	}
	
	public void ColorseasonalLook_page(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		List<WebElement> seasonalLooklist=driver.findElements(By.xpath("(//div[@class='table-wrapper'])[1]//tbody/tr"));
		int countlook=seasonalLooklist.size()-1;
		System.out.println("Count of row in seasonal look MOA table is: "+ countlook);
		test.log(Status.INFO,"Count of row in seasonal look MOA table is: "+ countlook);
		
		
	}
	
	public void Delete_seasonalLookInformation(String finishformulaname) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='TBLeditorTable']//tr"));
		for (int i=0;i<=(list.size()-1);i++) {
			WebElement finishname=driver.findElement(By.xpath("//table[@id='TBLeditorTable']//tr["+(i+1)+"]/td[3]"));
			if(finishname.getText().contains(finishformulaname)) {
				driver.findElement(By.xpath("//table[@id='TBLeditorTable']//tr["+(i+1)+"]/td[1]//span")).click();
				break;
				
			}
		}
		Thread.sleep(1000);
		deletebutton.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		Saveandclosebutton.click();
		Thread.sleep(2000);
	}
	
	public void Validate_Deleted_lookInformation(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		
		List<WebElement> seasonalLooklist=driver.findElements(By.xpath("(//div[@class='table-wrapper'])[1]//tbody/tr"));
		int seasonalcountlook=seasonalLooklist.size()-1;
		System.out.println("After deleting Count of row in seasonal look MOA table is: "+ seasonalcountlook);
		test.log(Status.INFO,"After deleting Count of row in seasonal look MOA table is: "+ seasonalcountlook);
		addSrceenShot("After deleting Count of row in seasonal look MOA table is: "+ seasonalcountlook, test, Capture);
		
		Looklink.click();
		
		List<WebElement> Looklist=driver.findElements(By.xpath("(//div[@class='table-wrapper'])[1]//tbody/tr"));
		int countlook=Looklist.size()-1;
		System.out.println("After deleting looks  Count of row in look MOA table is: "+ countlook);
		test.log(Status.INFO,"After deleting looks Count of row in  look MOA table is: "+ countlook);
		addSrceenShot("After deleting looks Count of row in  look MOA table is: "+ countlook, test, Capture);
		
		if(countlook==seasonalcountlook) {
			System.out.println("For both seasonal look and Look MOA table the count is same after deleting");
			test.log(Status.INFO,"For both seasonal look and Look MOA table the count is same after deleting");
			addSrceenShot("For both seasonal look and Look MOA table the count is same after deleting ", test, Capture);
		}
		
	}
	
	public void Edit_LookInformation(String finishformulaname,ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		if(!finishformulafield.getText().isEmpty()) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Insert_button));
			Insert_button.click();
		}

		AddfinishFormula_button.click();
		finishFormula_link.click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMaterialframe);
		Thread.sleep(5000);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(BFF_FG_nameInput));
		BFF_FG_nameInput.sendKeys(finishformulaname);
		
		Thread.sleep(3000);
		ColorSearchButton.click();
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", choosenFirstColor);
		
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		List<WebElement> list= driver.findElements(By.xpath("//td[contains(@id,'lsocPrimaryIndicator')]"));
		for(WebElement ele:list) {
			if (PrimaryIndicator.getText().equalsIgnoreCase("Yes")) {
				PrimaryIndicator.click();
				PrimaryIndicator_checkbox.click();
				System.out.println("for all look Primary Indicator is set to NO");
				test.log(Status.INFO,"for all look Primary Indicator is set to NO");
				addSrceenShot("for all look Primary Indicator is set to NO", test, Capture);		
			}
		}
		SaveButton.click();
		Thread.sleep(3000);
		
		if(PrimaryIndicator.getText().equalsIgnoreCase("No")){
			PrimaryIndicator.click();
			PrimaryIndicator_checkbox.click();
			System.out.println("Primary Indicator is set to Yes");
			test.log(Status.INFO,"Primary Indicator is set to Yes");
			addSrceenShot("Primary Indicator is set to Yes", test, Capture);
			
		}else {
			System.out.println("Primary Indicator is already Yes");
			test.log(Status.INFO,"Primary Indicator is already Yes");
			addSrceenShot("Primary Indicator is already Yes", test, Capture);
		}
		Thread.sleep(3000);
		
		SaveButton.click();	
		
	}
	
	public void Validate_FabricMillvalue_LookInformation(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		if(!FabricMillfield.getText().isEmpty()) {
			System.out.println("Fabric mill value is auto populating and the value is : "+FabricMillfield.getText());
			test.log(Status.INFO,"Fabric mill value is auto populating and the value is : "+FabricMillfield.getText());
			addSrceenShot("Fabric mill value is auto populating and the value is : "+FabricMillfield.getText(), test, Capture);
		}
		
		
	}
	
	
	
	
}
