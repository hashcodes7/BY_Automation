package com.plm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.WMS_ApplicationPages.PageBase;
import com.relevantcodes.extentreports.LogStatus;

public class PlmUtills {

	public static int plmMinElementWait = 2;

	public static void switchLeftPanel(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo()
				.frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@name='sidebarframe']")));
	}

	public static void switchContentFrame(RemoteWebDriver remoteDriver) {
		remoteDriver.switchTo().defaultContent();
		remoteDriver.switchTo()
				.frame((WebElement) remoteDriver.findElement(By.xpath("//iframe[@name='contentframe']")));
	}

	public static void switchBOMContentFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo()
				.frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@name='contentframe']")));
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@name='mainFrame']")));
	}

	public static void switchColorFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath("//frame[@id='colorframe']")));
	}

	public static void switchmainFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath("//frame[@name='mainFrame']")));
	}

	public static void switchBomFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath("//frame[@id='materialframe']")));
	}

	public static void switchContentFrameDmc(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo()
				.frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@id='invisible_iframe']")));
	}

	public static void switchFrame(ChromeDriver chromeDriver, String element) {
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath(element)));
	}

	public static void switchMeasurementFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo()
				.frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@name='contentframe']")));
		chromeDriver.switchTo()
				.frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@id='measurementWorkFrame']")));
	}

	public static void switchToMeasurementFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo().frame("contentframe").switchTo().frame("measurementWorkFrame");
	}

	public static void switchHeaderFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@name='headerframe']")));
	}

	public static boolean compareTwoHashMap(Map<String, String> expectedList, Map<String, String> actualList) {
		try {
			List<String> missedKeys = new ArrayList<String>();
			HashMap<String, String> missedValue = new HashMap<String, String>();
			for (String k : expectedList.keySet()) {
				if (!(actualList.get(k).trim().equalsIgnoreCase(expectedList.get(k).trim()))) {
					missedValue.put(k, actualList.get(k));
					ExtentUtility.getTest().log(LogStatus.INFO, "Missed Values:" + missedValue);
					return false;
				}
			}
			for (String y : expectedList.keySet()) {
				if (!actualList.containsKey(y)) {
					missedKeys.add(y);
					ExtentUtility.getTest().log(LogStatus.INFO, "Missed Keys:" + missedKeys);
					return false;
				}
			}
		} catch (Exception e) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Error occured while verification");
		}
		return true;
	}

	public static boolean compareTwoList(String[] expectedList, List<String> actualList) {
		List<String> missedValues = new ArrayList<String>();
		actualList = actualList.stream().map(val -> val.trim()).collect(Collectors.toList());
		boolean flag = false;
		for (String value : expectedList) {
			if (actualList.contains(value.trim())) {
				flag = true;
			} else {
				missedValues.add(value);
				flag = false;
			}
		}
		if (flag == false) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Keys:" + missedValues);
		}
		return flag;
	}

	public static boolean isPropertyCorrect(String propertyName, Map<String, String> expectedProperties,
			String valueToTest, ChromeDriver chromeDriver) {
		boolean isCorrect = java.util.Objects.equals(valueToTest, expectedProperties.get(propertyName).trim());
		if (!isCorrect) {
			ExtentUtility.getTest().log(LogStatus.FAIL,
					String.format("property %s is not matching! expected : [%s] found : [%s]", propertyName,
							expectedProperties.get(propertyName), valueToTest));
		}
		return isCorrect;
	}

	public static boolean isAllTrue(ArrayList<Boolean> array) {
		for (boolean b : array) {
			if (!b) {
				return false;
			}
		}
		return array != null && array.size() > 0;
	}

	public static boolean isElementPresentByText(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {

			if (!page.elementIsDisplayed("//td[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByLabel(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//label[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByDropdown(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//option[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}

		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByTagName(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//*[text()='" + value + "']")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByAttributeNamesequals(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//div[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByAttributeNamesEqualsTagname(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//span[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	/**
	 * @param values
	 * @param chromeDriver
	 * @return
	 * @throws Exception
	 */
	public static boolean isElementPresentByAttributeEquals(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//div[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByproductAttributes(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//li[contains(text(),'" + value + "')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByTextEqual(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed("//a[text()='" + value + "']")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean MassChangeAttributes(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.elementIsDisplayed(
					"//a[contains(@id,'" + value + "')]/following::span[contains(text(),'Fill Column')]")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean verifyMandatoryFields(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (page.elementIsDisplayed("//*[contains(text(),'" + value + "')]")) {
				String attrValue = page.getAttributeValue(page.getElement("//*[contains(text(),'" + value + "')]/.."),
						"class");
				String attrValueRequired = page
						.getAttributeValue(page.getElement("//*[contains(text(),'" + value + "')]"), "class");
				if (!(attrValue.equals("input-title-required") || attrValueRequired.equals("input-title-required"))) {
					flag = false;
					missedLabels.add(value);
				}
			} else {
				flag = false;
				missedLabels.add(value);
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Missed Labels and not mentioned as (*) feilds:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean verifyMandatoryFieldInSameClass(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (page.elementIsDisplayed("//div[contains(text(),'" + value + "')]")) {
				String attrValue = page.getAttributeValue(page.getElement("//div[contains(text(),'" + value + "')]"),
						"class");
				if (!(attrValue.equals("required"))) {
					flag = false;
					missedLabels.add(value);
				}
			} else {
				flag = false;
				missedLabels.add(value);
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Missed Labels and not mentioned as (*) feilds:" + missedLabels);
			return false;
		}
		return true;
	}

	/**
	 * @param parentMenu
	 * @param expectedHierarchy
	 * @param chromeDriver
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyMaterialHierarchy(String parentMenu, String[] expectedHierarchy,
			ChromeDriver chromeDriver) throws Exception {
		String xpath = "//td[a[text()='" + parentMenu
				+ "']]//ancestor::div[@id='divChildren_root_objTree' or @id='divChildren_root']/div/table/following-sibling::div/div/table/tbody/tr/td[3]/a";
		PageBase page = new PageBase();
		List<String> ParentElements = page.getElements(xpath).stream().map(element -> element.getText())
				.collect(Collectors.toList());
		return PlmUtills.compareTwoList(expectedHierarchy, ParentElements);
	}

	/**
	 * @param parentMenu
	 * @param expectedHierarchy
	 * @param chromeDriver
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyChildHierarchy(String parentMenu, String[] expectedHierarchy,
			ChromeDriver chromeDriver) throws Exception {
		String xpath = "//td[a[text()='" + parentMenu + "']]/../../../following-sibling::div/div/table/tbody/tr/td[3]";
		PageBase page = new PageBase();
		List<String> ParentElements = page.getElements(xpath).stream().map(element -> element.getText())
				.collect(Collectors.toList());
		return PlmUtills.compareTwoList(expectedHierarchy, ParentElements);
	}

	public static String getDateTestFromSystemDate(RemoteWebDriver driver) throws Exception {
		String systemDate = (String) ((JavascriptExecutor) driver)
				.executeScript("var d=new Date();return d.getMonth()+1 + '/' + d.getDate() + '/' + d.getFullYear();");
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		java.util.Date date = dateformat.parse(systemDate);
		return dateformat.format(date);
	}

	public static void verifyObjectIsEmpty(Object objectName, String message) throws Exception {
		PageBase page = new PageBase();
		page.assertThat(Objects.nonNull(objectName), "Passed: - " + message, "Failed: - " + message, true);
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
//				 dirContents[i].delete();
				return true;
			}
		}
		ExtentUtility.getTest().log(LogStatus.INFO,
				"Expected file " + fileName + ".zip" + " Actual :" + dirContents[0].getName());
		return false;
	}

	public static void closeOtherWindows(RemoteWebDriver driver, String parentwindow) {
		Set<String> allwindows = driver.getWindowHandles();
		allwindows.removeAll(allwindows);
		if (!allwindows.isEmpty()) {
			for (String window : allwindows) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
	}

	public static void unZipFile(String zipFile, String outputPath) throws IOException {
		if (outputPath == null)
			outputPath = "";
		else
			outputPath += File.separator;
		File outputDirectory = new File(outputPath);
		if (outputDirectory.exists()) {
			FileUtils.deleteDirectory(outputDirectory);
		}
		outputDirectory.mkdir();
		try {
			ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry entry = null;
			int len;
			byte[] buffer = new byte[1024];

			while ((entry = zip.getNextEntry()) != null) {
				if (!entry.isDirectory()) {
					File file = new File(outputPath + entry.getName());
					if (!new File(file.getParent()).exists())
						new File(file.getParent()).mkdirs();
					FileOutputStream fos = new FileOutputStream(file);
					while ((len = zip.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
				}
			}
			zip.close();
			ExtentUtility.getTest().log(LogStatus.INFO, "Unzipped file " + zipFile + "to location :" + outputPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDirectory(String outputPath) throws IOException {
		if (outputPath == null)
			outputPath = "";
		else
			outputPath += File.separator;
		File outputDirectory = new File(outputPath);
		if (outputDirectory.exists()) {
			FileUtils.deleteDirectory(outputDirectory);
		}
		ExtentUtility.getTest().log(LogStatus.INFO, "Deleted Directory :" + outputPath);
	}

	public static void ReadPDF(String path, String contentExpected) throws Exception {
		PDDocument doc = PDDocument.load(new File(path));
		PDFTextStripper pdfStrip = new PDFTextStripper();
		String content = pdfStrip.getText(doc);
		System.out.println("Boolean =====" + content.contains(contentExpected) + "=====" + contentExpected);
		doc.close();
	}

	public static void switchheaderFrame(ChromeDriver chromeDriver) {
		chromeDriver.switchTo().defaultContent();
		chromeDriver.switchTo().frame((WebElement) chromeDriver.findElement(By.xpath("//iframe[@name='headerframe']")));
	}

	public static boolean isElementPresentByTextFunction(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {

			if (!page.elementIsDisplayed("//*[text()='" + value + "']")) {
				// *[text()='" + value + "']
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean compareTwoList(List<String> actualList, List<String> list2) {
		List<String> missedValues = new ArrayList<String>();
		actualList = actualList.stream().map(val -> val.trim()).collect(Collectors.toList());
		boolean flag = false;
		for (String value : list2) {
			if (actualList.contains(value.trim())) {
				flag = true;
			} else {
				missedValues.add(value);
				flag = false;
			}
		}
		if (flag == false) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Keys:" + missedValues);
		}
		return flag;
	}

	public static boolean verifyAttributesGroupsNotEditable(String[] list, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedElements = new ArrayList<String>();
		boolean result = true;
		for (String elements : list) {
			if (!page.getElement("//div[contains(text(),'" + elements + "')]/following-sibling::div")
					.getAttribute("class").equals("display-only-label")) {
				missedElements.add(elements);
				result = false;
			}
		}
		if (!result) {
			ExtentUtility.getTest().log(LogStatus.INFO,
					"Following Attribute Group Is editable" + missedElements + "---------->in the Given list:-" + Arrays.asList(list));
			return false;
		}
		return true;
	}

	public static void verifyDropDownWithSelectTag(WebElement selectDropDown, String dropdDownValues,
			ChromeDriver chromeDriver) throws Exception {
		Select select_DropDown = new Select(selectDropDown);
		List<WebElement> listOfValues = select_DropDown.getOptions();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement webElement : listOfValues) {
			dropDownList.add(webElement.getText());
		}
		String[] attributes = dropdDownValues.split(":");
		Arrays.parallelSetAll(attributes, (i) -> attributes[i].trim());
		List<String> wordList = Arrays.asList(attributes);
		boolean result = wordList.size() == dropDownList.size() && wordList.containsAll(dropDownList)
				&& dropDownList.containsAll(wordList);
		PageBase page = new PageBase();
		page.assertThat(result,
				"Test passed: the dropdown data are matching with the given data::->" + Arrays.toString(attributes),
				"Test Failed:the dropdown data are not matching with the given data::->" + Arrays.toString(attributes),
				true);
	}

	public static void verifyDynamicDropDown(String dropdDownValues, String xpath, WebElement dropDownToBeVerified,
			ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		page.click(dropDownToBeVerified, dropDownToBeVerified.getText());
		String[] attributes = dropdDownValues.replaceAll("\\s", "").split(":");
		List<String> dropDownList = new ArrayList<String>();
		List<WebElement> valuesFromDropDown = page.getElements(xpath);
		for (int i = 0; i < valuesFromDropDown.size(); i++) {
			String productToolTipNames = valuesFromDropDown.get(i).getText().trim();
			dropDownList.add(productToolTipNames);
		}
		String[] array = new String[dropDownList.size()];
		for (int i = 0; i < dropDownList.size(); i++) {
			array[i] = dropDownList.get(i).replaceAll("\\s", "");
		}

		page.assertThat(Arrays.asList(array).containsAll(Arrays.asList(attributes)),
				"Test passed: the dropdown data are matching with the given data::->" + dropDownList,
				"Test Failed:the dropdown data are not matching with the given data::->" + dropDownList, true);
	}

	public static void verifyAttributeIsHavingAsterixAsPrefix(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		for (String value : values) {
			page.elementIsDisplayed("//div[contains(text(),'" + value + "')]");
			String text = page.getTextWithoutJse("//div[contains(text(),'" + value + "')]");
			boolean isContainingAsterix = (text.charAt(0) + "").equalsIgnoreCase("*");
			page.scrollTo("//div[contains(text(),'" + value + "')]", value);
			page.assertThat(isContainingAsterix, "Test Passed: " + value + " has prefix " + text.charAt(0),
					"Test Failed: " + value + " doesn't have prefix '*'", true);
		}

	}
	public static boolean isElementPresentByDisplayOnlyLabelAttribute(String[] values, ChromeDriver chromeDriver)
            throws Exception {
        PageBase page = new PageBase();
        List<String> missedLabels = new ArrayList<String>();
        boolean flag = true;
        for (String value : values) {
            if (!page.getAttributeValueXpath("//label[text()='" + value + "']//following::div[1]","class").equalsIgnoreCase("display-only-label")) {
                missedLabels.add(value);
                flag = false;
            }
        }
        if (!flag) {
            ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
            return false;
        }
        return true;
    }

	public static boolean isElementPresentByDisplayOnlyLabel(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.getAttributeValueXpath("//div[text()='" + value + "']//following::div[1]","class").equalsIgnoreCase("display-only-label")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByDisplayOnlyGroup(String[] values, ChromeDriver chromeDriver)
			throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {
			if (!page.getAttributeValueXpath("//label[text()='" + value + "']//following::a[contains(text(),'Edit')][1]", "class").equalsIgnoreCase("TABLEHEADERLINK")) {
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}

	public static boolean isElementPresentByMandatoryFields(String[] values, ChromeDriver chromeDriver) throws Exception {
		PageBase page = new PageBase();
		List<String> missedLabels = new ArrayList<String>();
		boolean flag = true;
		for (String value : values) {

			if (!page.elementIsDisplayed("//*[contains(text(),'" + value + "')]")) {
				// *[text()='" + value + "']
				missedLabels.add(value);
				flag = false;
			}
		}
		if (!flag) {
			ExtentUtility.getTest().log(LogStatus.INFO, "Missed Labels:" + missedLabels);
			return false;
		}
		return true;
	}
	
}