package Excel_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.WMS_Utilities.WMS_GlobalProperties;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class DataProviders implements WMS_GlobalProperties {

	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public ExtentReports extent;

	@DataProvider(name = "WMS_PAST_Gift_Card")
	public static Iterator<Object[]> WMS_PAST_Gift_Card() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("PackWrap");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
				CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, TotUserKey4,
				LocationKey, CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9, PackStation, sortloc1,
				sortloc2, chasewall;
		for (int i = 1; i <= numOfRows; i++) {
			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs1 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey1 = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey4 = sheet.getRow(i).getCell(12).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey1 = sheet.getRow(i).getCell(14).getStringCellValue();
			CartUserKey2 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(16).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(17).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(18).getStringCellValue();
			sortloc1 = sheet.getRow(i).getCell(19).getStringCellValue();
			sortloc2 = sheet.getRow(i).getCell(20).getStringCellValue();
			chasewall = sheet.getRow(i).getCell(21).getStringCellValue();
			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2,
					TotUserKey3, TotUserKey4, LocationKey, CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9,
					PackStation, sortloc1, sortloc2, chasewall });
		}
		return myData.iterator();
	}

	@DataProvider(name = "DR_Receiving")
	public static Iterator<Object[]> SingleSkuDRReceiving() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ASN_Single_LPN");
		int numOfRows = sheet.getLastRowNum();
		String Asn_ID, Lpn_ID, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID;

		for (int i = 1; i <= numOfRows; i++) {
			Asn_ID = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn_ID = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			CartID = sheet.getRow(i).getCell(6).getStringCellValue();
			myData.add(new Object[] { Asn_ID, Lpn_ID, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Ship_Confirmation")
	public static Iterator<Object[]> Ship_Confirmation() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Ship_Con");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Multi_DR_Receiving")
	public static Iterator<Object[]> MultiDRReceiving() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Multi_ASN_LPN");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID, itemID1, itemID2;
		for (int i = 1; i <= numOfRows; i++) {
			Asn = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			ToteID2 = sheet.getRow(i).getCell(6).getStringCellValue();
			CartID = sheet.getRow(i).getCell(7).getStringCellValue();
			itemID1 = sheet.getRow(i).getCell(8).getStringCellValue();
			itemID2 = sheet.getRow(i).getCell(9).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID,
					itemID1, itemID2 });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Multi_DR_Receiving_SC")
	public static Iterator<Object[]> Multi_DR_Receiving_SC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Mult_SC");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID, itemID1, itemID2;
		for (int i = 1; i <= numOfRows; i++) {
			Asn = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			ToteID2 = sheet.getRow(i).getCell(6).getStringCellValue();
			CartID = sheet.getRow(i).getCell(7).getStringCellValue();
			itemID1 = sheet.getRow(i).getCell(8).getStringCellValue();
			itemID2 = sheet.getRow(i).getCell(9).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID,
					itemID1, itemID2 });
		}
		return myData.iterator();
	}

	@DataProvider(name = "ReceivingInput")
	public static Iterator<Object[]> fetchData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet1");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, Asn, relatedLink, Lpn, menuSearch1;
		for (int i = 0; i < numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			Asn = sheet.getRow(i).getCell(4).getStringCellValue();
			relatedLink = sheet.getRow(i).getCell(5).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(6).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(7).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, Asn, relatedLink, menuSearch1, Lpn });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PutAwayInput")
	public static Iterator<Object[]> fetchData1() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet2");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, taskGroup, cartId, containerId, itemId;
		for (int i = 1; i < numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			taskGroup = sheet.getRow(i).getCell(4).getStringCellValue();
			cartId = sheet.getRow(i).getCell(5).getStringCellValue();
			containerId = sheet.getRow(i).getCell(6).getStringCellValue();
			itemId = sheet.getRow(i).getCell(7).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, taskGroup, cartId, containerId, itemId });
		}
		return myData.iterator();
	}

	@DataProvider(name = "RunWaveInput")
	public static Iterator<Object[]> fetchData2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("RunWave");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, order, menuSearch1, menuSearch2;
		for (int i = 1; i <= numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			order = sheet.getRow(i).getCell(4).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(5).getStringCellValue();
			menuSearch2 = sheet.getRow(i).getCell(6).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, order, menuSearch1, menuSearch2 });
		}
		return myData.iterator();
	}

	@DataProvider(name = "TaskAssigningInput")
	public static Iterator<Object[]> taskAssigningData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet5");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, order, menuSearch1, taskGroup, cartId, itemId, units, toteId,
				destinationLocationId;
		for (int i = 1; i <= numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			order = sheet.getRow(i).getCell(4).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(5).getStringCellValue();
			taskGroup = sheet.getRow(i).getCell(6).getStringCellValue();
			cartId = sheet.getRow(i).getCell(7).getStringCellValue();
			itemId = sheet.getRow(i).getCell(8).getStringCellValue();
			units = sheet.getRow(i).getCell(9).getStringCellValue();
			toteId = sheet.getRow(i).getCell(10).getStringCellValue();
			destinationLocationId = sheet.getRow(i).getCell(11).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, order, menuSearch1, taskGroup, cartId, itemId,
					units, toteId, destinationLocationId });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickingOrdersInput")
	public static Iterator<Object[]> pickingOrders() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet4");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, tote, itemBarCode, actualweight, menuSearch1, order;
		for (int i = 1; i <= numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			tote = sheet.getRow(i).getCell(4).getStringCellValue();
			itemBarCode = sheet.getRow(i).getCell(5).getStringCellValue();
			actualweight = sheet.getRow(i).getCell(6).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(7).getStringCellValue();
			order = sheet.getRow(i).getCell(8).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, tote, itemBarCode, actualweight, menuSearch1,
					order });
		}
		return myData.iterator();
	}

	@DataProvider(name = "ASNVerification")
	public static Iterator<Object[]> fetchASNData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ASN_LPN_PO_ITEM_BARCODE");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, VerifyItemid, VerifyASNSpecs, VerifyLPN, TotUserKey, TotStart, CartUserKey, LastLpn;

		for (int i = 1; i <= numOfRows; i++) {

			Asn = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			VerifyItemid = sheet.getRow(i).getCell(2).getStringCellValue();
			VerifyASNSpecs = sheet.getRow(i).getCell(3).getStringCellValue();
			VerifyLPN = sheet.getRow(i).getCell(4).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(5).getStringCellValue();
			TotStart = sheet.getRow(i).getCell(6).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(7).getStringCellValue(); // SinglegiftCard
			LastLpn = sheet.getRow(i).getCell(8).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, VerifyItemid, VerifyASNSpecs, VerifyLPN, TotUserKey, TotStart,
					CartUserKey, LastLpn });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_Cartoon")
	public static Iterator<Object[]> SingleBagGC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBagGc");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_PackStation_One")
	public static Iterator<Object[]> SingleBagOne() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBag_1");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_PackStation_Two")
	public static Iterator<Object[]> SingleBagPakTwo() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBag_2");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_PackStation_Three")
	public static Iterator<Object[]> SinglesBagPackThree() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBag_3");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglegiftCard")
	public static Iterator<Object[]> singlegiftCard() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SingGifCard");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SingleWrap")
	public static Iterator<Object[]> singlesWrap() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SingWGP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SingleExport")
	public static Iterator<Object[]> singlesExport() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SingExp");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SingleCartons")
	public static Iterator<Object[]> singleCartons() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "MultiBag_GC")
	public static Iterator<Object[]> Multibags_2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_GC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "WMS_MultiBag_GiftCard")
	public static Iterator<Object[]> Multibags_GiftCard() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_GiftCard");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "MultiGift_2Units")
	public static Iterator<Object[]> MultiGift_2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("M_Gift_2");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "WMS_Multis_Gift_Wrap")
	public static Iterator<Object[]> Multis_gift_wrap() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("M_Gift_Wrp");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "WMS_Multi_Gift_Wrap")
	public static Iterator<Object[]> Multis_GiftWrap() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_GiftWrap");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, TotUserKey3, TotUserKey4, LocationKey,
				CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey4 = sheet.getRow(i).getCell(12).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					TotUserKey3, TotUserKey4, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "WMS_Multis_Export")
	public static Iterator<Object[]> Multis_Export() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_Export");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Positive_Adjusment")
	public static Iterator<Object[]> Positive_Adjusments() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Positive_Adj");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID, ITEMBAR;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEMBAR = sheet.getRow(i).getCell(1).getStringCellValue();

			myData.add(new Object[] { TOTEID, ITEMBAR, });
		}
		return myData.iterator();
	}

	@DataProvider(name = "blind_receiving")
	public static Iterator<Object[]> blindReceiving() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Blind_R");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();

			myData.add(new Object[] { TOTEID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Add_and_Remove_Condition")
	public static Iterator<Object[]> AddandRemove() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ARcond");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();

			myData.add(new Object[] { TOTEID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "cycle_Count_UserDirected")
	public static Iterator<Object[]> cycleCount() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Cycle_User");
		int numOfRows = sheet.getLastRowNum();
		String LOCATION, ITEM, LOCATIONID;

		for (int i = 1; i <= numOfRows; i++) {

			LOCATION = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEM = sheet.getRow(i).getCell(1).getStringCellValue();
			LOCATIONID = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { LOCATION, ITEM, LOCATIONID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "cycle_Recounts")
	public static Iterator<Object[]> cycleReCountas() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Cycle_Rec");
		int numOfRows = sheet.getLastRowNum();
		String LOCATION, ITEM, LOCATIONID;

		for (int i = 1; i <= numOfRows; i++) {

			LOCATION = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEM = sheet.getRow(i).getCell(1).getStringCellValue();
			LOCATIONID = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { LOCATION, ITEM, LOCATIONID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Negative_Adjusment")
	public static Iterator<Object[]> Negative_Adjusment() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Negative_Adj");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID, ITEMBAR;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEMBAR = sheet.getRow(i).getCell(1).getStringCellValue();

			myData.add(new Object[] { TOTEID, ITEMBAR, });
		}
		return myData.iterator();
	}

	@DataProvider(name = "RateShop")
	public static Iterator<Object[]> rateshop() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("RS");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "RateShop_Validation")
	public static Iterator<Object[]> rateShop() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("RateShop");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickShort_Singles_bag")
	public static Iterator<Object[]> picksortSB() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SB");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickShort_Singles_Carton")
	public static Iterator<Object[]> picksortSingleCarton() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickShort_Singles_Gift_Card")
	public static Iterator<Object[]> singleGiftCard_pick_Short() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SGC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Cancel_Olpns")
	public static Iterator<Object[]> Cancel_Olpns() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Can_Olpn");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs2, CompleteSpecs3;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs2, CompleteSpecs3 });
		}
		return myData.iterator();
	}

	@DataProvider(name = "WMS_Cancel_Order")
	public static Iterator<Object[]> WMS_Cancel_Order1() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Can_Ord");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs2, CompleteSpecs3;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(2).getStringCellValue();
			myData.add(new Object[] { OrderNumber, CompleteSpecs2, CompleteSpecs3 });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PackShorts_SingleBag_Cartons")
	public static Iterator<Object[]> singleBag_Cartons_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack_SCP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;
		for (int i = 1; i <= numOfRows; i++) {
			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PackShorts_Singles_bags")
	public static Iterator<Object[]> singles_bag_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack_SBP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;
		for (int i = 1; i <= numOfRows; i++) {
			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "ParcelEnd_of_TheDay")
	public static Iterator<Object[]> ParcelEnd() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Par_EOD");
		int numOfRows = sheet.getLastRowNum();
		String CarrierServer, ParcelEndDate;

		for (int i = 1; i <= numOfRows; i++) {

			CarrierServer = sheet.getRow(i).getCell(0).getStringCellValue();

			ParcelEndDate = sheet.getRow(i).getCell(1).getStringCellValue();

			myData.add(new Object[] { CarrierServer, ParcelEndDate });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Fill_And_Kill_Wave")
	public static Iterator<Object[]> fill_and_kill() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Fill_Kill");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Single_SKU")
	public static Iterator<Object[]> SingleSKULPN() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ASN_LPN");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID;

		for (int i = 1; i <= numOfRows; i++) {

			Asn = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			CartID = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Single_SKU_SC")
	public static Iterator<Object[]> Single_SKU_SC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SSku_SC");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID;

		for (int i = 1; i <= numOfRows; i++) {

			Asn = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			CartID = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PackShorts_Single_Export")
	public static Iterator<Object[]> singles_Export_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack_SEP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;
		for (int i = 1; i <= numOfRows; i++) {
			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Printing_Journal")
	public static Iterator<Object[]> printing_Journal() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("P-Jour");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, TaskGroup, PrintType;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			TaskGroup = sheet.getRow(i).getCell(2).getStringCellValue();
			PrintType = sheet.getRow(i).getCell(3).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, TaskGroup, PrintType });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Large_Wave")
	public static Iterator<Object[]> LargeWave_Task_release() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Lr_Wave");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, OrderNumber3, OrderNumber4, OrderNumber5, OrderNumber6, OrderNumber7,
				OrderNumber8, OrderNumber9, OrderNumber10, OrderNumber11, OrderNumber12, OrderNumber13, OrderNumber14,
				OrderNumber15, OrderNumber16, OrderNumber17, OrderNumber18, CompleteSpecs, CompleteSpecs2,
				CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1,
				TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			OrderNumber3 = sheet.getRow(i).getCell(2).getStringCellValue();
			OrderNumber4 = sheet.getRow(i).getCell(3).getStringCellValue();
			OrderNumber5 = sheet.getRow(i).getCell(4).getStringCellValue();
			OrderNumber6 = sheet.getRow(i).getCell(5).getStringCellValue();
			OrderNumber7 = sheet.getRow(i).getCell(6).getStringCellValue();
			OrderNumber8 = sheet.getRow(i).getCell(7).getStringCellValue();
			OrderNumber9 = sheet.getRow(i).getCell(8).getStringCellValue();
			OrderNumber10 = sheet.getRow(i).getCell(9).getStringCellValue();
			OrderNumber11 = sheet.getRow(i).getCell(10).getStringCellValue();
			OrderNumber12 = sheet.getRow(i).getCell(11).getStringCellValue();
			OrderNumber13 = sheet.getRow(i).getCell(12).getStringCellValue();
			OrderNumber14 = sheet.getRow(i).getCell(13).getStringCellValue();
			OrderNumber15 = sheet.getRow(i).getCell(14).getStringCellValue();
			OrderNumber16 = sheet.getRow(i).getCell(15).getStringCellValue();
			OrderNumber17 = sheet.getRow(i).getCell(16).getStringCellValue();
			OrderNumber18 = sheet.getRow(i).getCell(17).getStringCellValue();

			CompleteSpecs = sheet.getRow(i).getCell(18).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(19).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(20).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(21).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(22).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(23).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(24).getStringCellValue();

			TotUserKey1 = sheet.getRow(i).getCell(25).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(26).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(27).getStringCellValue();

			LocationKey = sheet.getRow(i).getCell(28).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(29).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(30).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(31).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(32).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, OrderNumber3, OrderNumber4, OrderNumber5, OrderNumber6,
					OrderNumber7, OrderNumber8, OrderNumber9, OrderNumber10, OrderNumber11, OrderNumber12,
					OrderNumber13, OrderNumber14, OrderNumber15, OrderNumber16, OrderNumber17, OrderNumber18,
					CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6,
					CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8,
					CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "DO_SingleBag")
	public static Iterator<Object[]> DOsinglebag() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("DO_SB");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation, TaskGroup, PrintType;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();
			TaskGroup = sheet.getRow(i).getCell(14).getStringCellValue();
			PrintType = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation, TaskGroup, PrintType });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PackShorts__Multis_Gift_Wrap")
	public static Iterator<Object[]> singles_GiftWrap_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack-Wrap");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
				CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey,
				CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			OrderNumber3 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(8).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(9).getStringCellValue();

			TotUserKey1 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(12).getStringCellValue();

			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2,
					CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1,
					TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickSort_MultiBag_Corton")
	public static Iterator<Object[]> PickSort_MultiBag_Corton() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_MB_Corton");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickShort_Multis_Export")
	public static Iterator<Object[]> PickShort_Multis_Export() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_MExport");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8,
				CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,
					LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PackShort_Multis_Gift_Card")
	public static Iterator<Object[]> Pack_Multis_GiftCard_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack_GC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
				CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey,
				CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			OrderNumber3 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(8).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(9).getStringCellValue();

			TotUserKey1 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(12).getStringCellValue();

			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2,
					CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1,
					TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Clock_In_Clock_Out")
	public static Iterator<Object[]> clock_In_Out() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ClockInOut");
		int numOfRows = sheet.getLastRowNum();
		String UserId, TimeIn, OutTime;

		for (int i = 1; i <= numOfRows; i++) {

			UserId = sheet.getRow(i).getCell(0).getStringCellValue();
			TimeIn = sheet.getRow(i).getCell(1).getStringCellValue();
			OutTime = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { UserId, TimeIn, OutTime });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Alternate_Pick_Location")
	public static Iterator<Object[]> Alternate_Pick_Location() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_AltLoca");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FE2D_RateShop_Validation")
	public static Iterator<Object[]> rateShopFE2D() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FE2D");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "DHEP_RateShop_Validation")
	public static Iterator<Object[]> rateShopDHEP() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("DHEP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FEPO_RateShop_Validation")
	public static Iterator<Object[]> rateShopFEPO() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FEPO");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FEGC_RateShop_Validation")
	public static Iterator<Object[]> rateShopFEGC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FEGC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FGHD_RateShop_Validation")
	public static Iterator<Object[]> rateShopFGHD() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FGHD");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "ONTRAC_RateShop_Validation")
	public static Iterator<Object[]> rateShopONTRAC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ONTRAC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "USSG_RateShop_Validation")
	public static Iterator<Object[]> rateShopUSSG() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("USSG");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "USFC_RateShop_Validation")
	public static Iterator<Object[]> rateShopUSFC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEFIRST);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("USFC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickShort_Singles_Gift_Wrap")
	public static Iterator<Object[]> singleGift_Wrap_pick_Short() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SGW");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickSort_MultiBag_Corton_2slot")
	public static Iterator<Object[]> PickSort_MultiBag_Corton_2slot() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_MB_Corton_2slot");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber1, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
				CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey,
				CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber1 = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs1 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey1 = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(11).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CartUserKey1 = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey2 = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber1, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2,
					TotUserKey3, LocationKey, CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9,
					PackStation, });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Create_New_Colors")
	public static Iterator<Object[]> createNewColors() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, actionvalue, redvalue, bluevalue, greenvalue, colorname, colorfamily, standardprovider,
				colorcode, providercolorname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Palette_CreateColor".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				actionvalue = sheet.getRow(i).getCell(2).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(4).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				colorname = sheet.getRow(i).getCell(6).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(7).getStringCellValue();
				standardprovider = sheet.getRow(i).getCell(8).getStringCellValue();
				colorcode = sheet.getRow(i).getCell(9).getStringCellValue();
				providercolorname = sheet.getRow(i).getCell(10).getStringCellValue();
				myData.add(new Object[] { TestType, season, actionvalue, redvalue, bluevalue, greenvalue, colorname,
						colorfamily, standardprovider, colorcode, providercolorname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC285_P0_E2E_Create_new_palette")
	public static Iterator<Object[]> TC285_P0_E2E_Create_new_palette() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, palettename;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC285_P0_E2E_Create_new_palette".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				palettename = sheet.getRow(i).getCell(2).getStringCellValue();
				myData.add(new Object[] { TestType, season, palettename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "Create_Colors_PrintsandPatterns")
	public static Iterator<Object[]> CreateColors_PrintsandPatterns() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, redvalue, bluevalue, greenvalue, artworkname, colorfamily, artworkcode, patterntype,
				colorcombo, developer, colortype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P0_Create_PrintsAndPatterns_color".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(4).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				artworkname = sheet.getRow(i).getCell(11).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(7).getStringCellValue();
				artworkcode = sheet.getRow(i).getCell(12).getStringCellValue();
				patterntype = sheet.getRow(i).getCell(13).getStringCellValue();
				colorcombo = sheet.getRow(i).getCell(14).getStringCellValue();
				developer = sheet.getRow(i).getCell(15).getStringCellValue();
				colortype = sheet.getRow(i).getCell(16).getStringCellValue();
				myData.add(new Object[] { TestType, season, redvalue, bluevalue, greenvalue, artworkname, colorfamily,
						artworkcode, patterntype, colorcombo, developer, colortype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "Product_Segmentation_LSE")
	public static Iterator<Object[]> ProductSegmentationLSE() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, brand, productcategory, consumergroup_1, productsegLSEvalue, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P0_Validate_ProductSegmentationLSE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				brand = sheet.getRow(i).getCell(3).getStringCellValue();
				productcategory = sheet.getRow(i).getCell(4).getStringCellValue();
				consumergroup_1 = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(9).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, brand, productcategory, consumergroup_1,
						productsegLSEvalue, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "Product_Segmentation_LSUS")
	public static Iterator<Object[]> ProductSegmentationLSUS() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, brand, productcategory, consumer_PH, productsegLSUSvalue, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P0_Validate_ProductSegmentationLSUS".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				brand = sheet.getRow(i).getCell(3).getStringCellValue();
				productcategory = sheet.getRow(i).getCell(4).getStringCellValue();
				consumer_PH = sheet.getRow(i).getCell(7).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(8).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(9).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, brand, productcategory, consumer_PH,
						productsegLSUSvalue, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC04_P0_SCL_Create_seasonalBFFcolor")
	public static Iterator<Object[]> TC04_P0_SCL_Create_seasonalBFFcolor() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colortype, redvalue, bluevalue, greenvalue, colorfamily, tier, base, facode,
				createdfrom;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC04_P0_SCL_Create_seasonalBFFcolor".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colortype = sheet.getRow(i).getCell(2).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(4).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(6).getStringCellValue();
				tier = sheet.getRow(i).getCell(7).getStringCellValue();
				base = sheet.getRow(i).getCell(8).getStringCellValue();
				facode = sheet.getRow(i).getCell(9).getStringCellValue();
				createdfrom = sheet.getRow(i).getCell(10).getStringCellValue();
				myData.add(new Object[] { TestType, season, colortype, redvalue, bluevalue, greenvalue, colorfamily,
						tier, base, facode, createdfrom });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC04_P0_SCL_seasonalBFFColor_ERROR")
	public static Iterator<Object[]> TC04_P0_SCL_seasonalBFFColor_ERROR() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colortype, redvalue, bluevalue, greenvalue, facode, createdfrom;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC04_P0_SCL_seasonalBFFColor_ERROR".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colortype = sheet.getRow(i).getCell(2).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(4).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				facode = sheet.getRow(i).getCell(9).getStringCellValue();
				createdfrom = sheet.getRow(i).getCell(10).getStringCellValue();
				myData.add(new Object[] { TestType, season, colortype, redvalue, bluevalue, greenvalue, facode,
						createdfrom });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC04_P0_Create_PC9")
	public static Iterator<Object[]> TC04_P0_Create_PC9() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC04_P0_Create_PC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_CreateColorway_SetUPLSE_LSUS")
	public static Iterator<Object[]> TC_CreateColorway_SetUPLSE_LSUS() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_CreateColorway_SetUPLSE_LSUS".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(12).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(13).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(14).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(15).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(16).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(17).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(18).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(19).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(20).getStringCellValue();
				createddate = sheet.getRow(i).getCell(21).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(22).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(23).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(24).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(25).getStringCellValue();
				capsule = sheet.getRow(i).getCell(26).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(27).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(28).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(29).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC14_P0_Validate_ProductDevCenter")
	public static Iterator<Object[]> TC14_P0_Validate_ProductDevCenter() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC14_P0_Validate_ProductDevCenter".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC16_P0_Validate_ProfitCenter_EUROPE")
	public static Iterator<Object[]> TC16_P0_Validate_ProfitCenter_EUROPE() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC16_P0_Validate_ProfitCenter_EUROPE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC32_P0_SCL_UpdateSeasonalColorLookName")
	public static Iterator<Object[]> TC32_P0_SCL_UpdateSeasonalColorLookName()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC32_P0_SCL_UpdateSeasonalColorLookName".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC04_P0_SCL_UpdateColorLookName")
	public static Iterator<Object[]> TC04_P0_SCL_UpdateColorLookName() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, colorname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC04_P0_SCL_UpdateColorLookName".equalsIgnoreCase(TestType)) {
				colorname = sheet.getRow(i).getCell(1).getStringCellValue();
				myData.add(new Object[] { TestType, colorname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P0_SetUpLSE")
	public static Iterator<Object[]> TC17_P0_SetUpLSE() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P0_SetUpLSE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC18_P0_SetUpLSUS")
	public static Iterator<Object[]> TC18_P0_SetUpLSUS() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC18_P0_SetUpLSUS".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC19_P0_Update_PC_LSUS")
	public static Iterator<Object[]> TC19_P0_Update_PC_LSUS() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, productsegLSEvalue, productsegLSUSvalue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC19_P0_Update_PC_LSUS".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, productsegLSEvalue, productsegLSUSvalue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P0_CopyProduct")
	public static Iterator<Object[]> TC17_P0_CopyProduct() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, newseason, filtervalue, newname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P0_CopyProduct".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				newseason = sheet.getRow(i).getCell(3).getStringCellValue();
				filtervalue = sheet.getRow(i).getCell(9).getStringCellValue();
				newname = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, newseason, filtervalue, newname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC21_P0_CopyExistingColorway")
	public static Iterator<Object[]> TC21_P0_CopyExistingColorway() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, viewoption, merchfabrictype, productsegLSEvalue, productsegLSUSvalue,
				hubofferedto;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC21_P0_CopyExistingColorway".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				viewoption = sheet.getRow(i).getCell(4).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(8).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, viewoption, merchfabrictype, productsegLSEvalue,
						productsegLSUSvalue, hubofferedto });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC10_P0_CL_Placement_Part2")
	public static Iterator<Object[]> TC10_P0_CL_Placement_Part2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC10_P0_CL_Placement_Part2".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC11_P0_CL_CreateBulkColorway")
	public static Iterator<Object[]> TC11_P0_CL_CreateBulkColorway() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC11_P0_CL_CreateBulkColorway".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P0_AdoptionLH")
	public static Iterator<Object[]> TC02_P0_AdoptionLH() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, affiliate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P0_AdoptionLH".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, affiliate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P0_AdoptionAFF")
	public static Iterator<Object[]> TC03_P0_AdoptionAFF() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, affiliate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_P0_AdoptionAFF".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, affiliate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P0_Views_ValidateLinesheet_Adoption")
	public static Iterator<Object[]> TC01_P0_Views_ValidateLinesheet_Adoption()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, affiliate, lastElement;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P0_Views_ValidateLinesheet_Adoption".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(5).getStringCellValue();
				lastElement = sheet.getRow(i).getCell(6).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, affiliate,
						lastElement });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P0_Views_ValidateLinesheet_FLA_finalizeDetails")
	public static Iterator<Object[]> TC02_P0_Views_ValidateLinesheet_FLA_finalizeDetails()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, affiliate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P0_Views_ValidateLinesheet_FLA_finalizeDetails".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(5).getStringCellValue();
//				lastElement=sheet.getRow(i).getCell(6).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, affiliate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC07_P0_Linesheet_ValidateFilters_FLA")
	public static Iterator<Object[]> TC07_P0_Linesheet_ValidateFilters_FLA()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC07_P0_Linesheet_ValidateFilters_FLA".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P0_Linesheet_ValidateFilters_Merch")
	public static Iterator<Object[]> TC01_P0_Linesheet_ValidateFilters_Merch()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P0_Linesheet_ValidateFilters_Merch".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC14_P0_Linesheet_ValidateFilters_techpack")
	public static Iterator<Object[]> TC14_P0_Linesheet_ValidateFilters_techpack()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC14_P0_Linesheet_ValidateFilters_techpack".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes });
			}

		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_01_P0_CS_SeasonalGroupsValidations_Male")
	public static Iterator<Object[]> TC_01_P0_CS_SeasonalGroupsValidations_Male()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_01_P0_CS_SeasonalGroupsValidations_Male".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, season });
			}

		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_04_P0_CS_SeasonalGroupsValidations_Female")
	public static Iterator<Object[]> TC_04_P0_CS_SeasonalGroupsValidations_Female()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_04_P0_CS_SeasonalGroupsValidations_Female".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, season });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_02_P0_Placements_Results_BlankSeason")
	public static Iterator<Object[]> TC_02_P0_Placements_Results_BlankSeason()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_02_P0_Placements_Results_BlankSeason".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_03_P0_Placements_Results_Blank_Brand")
	public static Iterator<Object[]> TC_03_P0_Placements_Results_Blank_Brand()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_03_P0_Placements_Results_Blank_Brand".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC36_P0_Placements_UpdatingMultiplePlacementValue")
	public static Iterator<Object[]> TC36_P0_Placements_UpdatingMultiplePlacementValue()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, uploadFilePath_update,
				resultfilepath_update;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC36_P0_Placements_UpdatingMultiplePlacementValue".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				uploadFilePath_update = sheet.getRow(i).getCell(6).getStringCellValue();
				resultfilepath_update = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview,
						uploadFilePath_update, resultfilepath_update });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P0_Measurements_CreateTemplate")
	public static Iterator<Object[]> TC02_P0_Measurements_CreateTemplate() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, template, measurement_name, measurement_type;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P0_Measurements_CreateTemplate".equalsIgnoreCase(TestType)) {
				template = sheet.getRow(i).getCell(1).getStringCellValue();
				measurement_name = sheet.getRow(i).getCell(2).getStringCellValue();
				measurement_type = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, template, measurement_name, measurement_type });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P0_Measurements_Create_POM")
	public static Iterator<Object[]> TC03_P0_Measurements_Create_POM() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, template, pomdescription, pomId;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_P0_Measurements_Create_POM".equalsIgnoreCase(TestType)) {
				template = sheet.getRow(i).getCell(1).getStringCellValue();
				pomdescription = sheet.getRow(i).getCell(2).getStringCellValue();
				pomId = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, template, pomdescription, pomId });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC10_P0_CreateMeasureSet_UsingTemplate")
	public static Iterator<Object[]> TC10_P0_CreateMeasureSet_UsingTemplate()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications, measurementsetname,
				template_name, sizevalue, measurementtype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC10_P0_CreateMeasureSet_UsingTemplate".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();
				measurementsetname = sheet.getRow(i).getCell(6).getStringCellValue();
				template_name = sheet.getRow(i).getCell(7).getStringCellValue();
				sizevalue = sheet.getRow(i).getCell(8).getStringCellValue();
				measurementtype = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications,
						measurementsetname, template_name, sizevalue, measurementtype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC11_P0_Measurements_CreateSet_NonMeasurementAdmin")
	public static Iterator<Object[]> TC11_P0_Measurements_CreateSet_NonMeasurementAdmin()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC11_P0_Measurements_CreateSet_NonMeasurementAdmin".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P0_TechPack_PDView")
	public static Iterator<Object[]> TC01_P0_TechPack_PDView() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P0_TechPack_PDView".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P0_TechPack_GarmentView")
	public static Iterator<Object[]> TC02_P0_TechPack_GarmentView() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P0_TechPack_GarmentView".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC15_P0_GD_Generate_TP_BOMOnly")
	public static Iterator<Object[]> TC15_P0_GD_Generate_TP_BOMOnly() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC15_P0_GD_Generate_TP_BOMOnly".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P0_Techpack_GenerateBOMOnly_MultipleColorway_SingleSource")
	public static Iterator<Object[]> TC17_P0_Techpack_GenerateBOMOnly_MultipleColorway_SingleSource()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P0_Techpack_GenerateBOMOnly_MultipleColorway_SingleSource".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC05_P0_TechPack_DownloadBOMTechpack")
	public static Iterator<Object[]> TC05_P0_TechPack_DownloadBOMTechpack() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC05_P0_TechPack_DownloadBOMTechpack".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC06_P0_Download_TechpackOnly_File")
	public static Iterator<Object[]> TC06_P0_Download_TechpackOnly_File() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, productname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC06_P0_Download_TechpackOnly_File".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, productname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC286_P0_E2E_caryyover_PC5_PC9")
	public static Iterator<Object[]> TC286_P0_E2E_caryyover_PC5_PC9() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, to_season, from_season, linesheetview, productname, colorwayname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC286_P0_E2E_caryyover_PC5_PC9".equalsIgnoreCase(TestType)) {
				to_season = sheet.getRow(i).getCell(1).getStringCellValue();
				from_season = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, to_season, from_season, linesheetview, productname, colorwayname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC288_E2E_create_colorway")
	public static Iterator<Object[]> TC288_E2E_create_colorway() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC288_E2E_create_colorway".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC290_P0_E2E_CreateColors_SL_FG")
	public static Iterator<Object[]> TC290_P0_E2E_CreateColors_SL_FG() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colortype, redvalue, bluevalue, greenvalue, colorfamily, color, finishtype, lookname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC290_P0_E2E_CreateColors_SL_FG".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colortype = sheet.getRow(i).getCell(2).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(4).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(6).getStringCellValue();
				color = sheet.getRow(i).getCell(7).getStringCellValue();
				finishtype = sheet.getRow(i).getCell(8).getStringCellValue();
				lookname = sheet.getRow(i).getCell(9).getStringCellValue();
				myData.add(new Object[] { TestType, season, colortype, redvalue, bluevalue, greenvalue, colorfamily,
						color, finishtype, lookname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC291_P0_E2E_CreateColors_BFF")
	public static Iterator<Object[]> TC291_P0_E2E_CreateColors_BFF() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colortype, redvalue, bluevalue, greenvalue, colorfamily, tier, base, facode,
				createdfrom;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC291_P0_E2E_CreateColors_BFF".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colortype = sheet.getRow(i).getCell(2).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(4).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(6).getStringCellValue();
				tier = sheet.getRow(i).getCell(7).getStringCellValue();
				base = sheet.getRow(i).getCell(8).getStringCellValue();
				facode = sheet.getRow(i).getCell(9).getStringCellValue();
				createdfrom = sheet.getRow(i).getCell(10).getStringCellValue();
				myData.add(new Object[] { TestType, season, colortype, redvalue, bluevalue, greenvalue, colorfamily,
						tier, base, facode, createdfrom });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC292_P0_E2E_CreateColors_Solid")
	public static Iterator<Object[]> TC292_P0_E2E_CreateColors_Solid() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, colortype, redvalue, bluevalue, greenvalue, colorfamily, standardprovider, colorcode,
				colorname, providercolorname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC292_P0_E2E_CreateColors_Solid".equalsIgnoreCase(TestType)) {
				colortype = sheet.getRow(i).getCell(1).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(2).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(3).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(4).getStringCellValue();
				colorname = sheet.getRow(i).getCell(5).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(6).getStringCellValue();
				standardprovider = sheet.getRow(i).getCell(7).getStringCellValue();
				colorcode = sheet.getRow(i).getCell(8).getStringCellValue();
				providercolorname = sheet.getRow(i).getCell(9).getStringCellValue();
				myData.add(new Object[] { TestType, colortype, redvalue, bluevalue, greenvalue, colorfamily,
						standardprovider, colorcode, colorname, providercolorname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC293_P0_E2E_Change_AdoptionGBValue")
	public static Iterator<Object[]> TC293_P0_E2E_Change_AdoptionGBValue() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filtercolorway;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC293_P0_E2E_Change_AdoptionGBValue".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filtercolorway });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC294_P0_E2E_Change_AdoptedLHValue")
	public static Iterator<Object[]> TC294_P0_E2E_Change_AdoptedLHValue() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC294_P0_E2E_Change_AdoptedLHValue".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC295_P0_E2E_Change_AdoptedAFFValue")
	public static Iterator<Object[]> TC295_P0_E2E_Change_AdoptedAFFValue() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, affiliate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC295_P0_E2E_Change_AdoptedAFFValue".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, affiliate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC296_P0_E2E_FLAFinalizeView")
	public static Iterator<Object[]> TC296_P0_E2E_FLAFinalizeView() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, affiliate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC296_P0_E2E_FLAFinalizeView".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(5).getStringCellValue();
//				lastElement=sheet.getRow(i).getCell(6).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, affiliate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC297_P0_E2E_Create_MeasurementSet")
	public static Iterator<Object[]> TC297_P0_E2E_Create_MeasurementSet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications, measurementsetname,
				template_name, sizevalue, measurementtype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC297_P0_E2E_Create_MeasurementSet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();
				measurementsetname = sheet.getRow(i).getCell(6).getStringCellValue();
				template_name = sheet.getRow(i).getCell(7).getStringCellValue();
				sizevalue = sheet.getRow(i).getCell(8).getStringCellValue();
				measurementtype = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications,
						measurementsetname, template_name, sizevalue, measurementtype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC301_P0_E2E_SetUp_LSUS_Linesheet")
	public static Iterator<Object[]> TC301_P0_E2E_SetUp_LSUS_Linesheet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview, localhub, affiliate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC301_P0_E2E_SetUp_LSUS_Linesheet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				localhub = sheet.getRow(i).getCell(6).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview, localhub, affiliate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC303_P0_E2E_UploadThumbnail")
	public static Iterator<Object[]> TC303_P0_E2E_UploadThumbnail() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview, uploadFilepath;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC303_P0_E2E_UploadThumbnail".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				colorway = sheet.getRow(i).getCell(8).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview, uploadFilepath });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC318_P0_E2E_BulkBOMURL")
	public static Iterator<Object[]> TC318_P0_E2E_BulkBOMURL() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC318_P0_E2E_BulkBOMURL".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC317_P0_E2E_TechPackONLY_URL")
	public static Iterator<Object[]> TC317_P0_E2E_TechPackONLY_URL() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, productname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC317_P0_E2E_TechPackONLY_URL".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, productname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC324_P0_E2E_PlacementLoadFile")
	public static Iterator<Object[]> TC324_P0_E2E_PlacementLoadFile() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, colorway, vendor_Id,
				materialcode, millsapcode, usagevalue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC324_P0_E2E_PlacementLoadFile".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(8).getStringCellValue();
				vendor_Id = sheet.getRow(i).getCell(9).getStringCellValue();
				materialcode = sheet.getRow(i).getCell(10).getStringCellValue();
				millsapcode = sheet.getRow(i).getCell(11).getStringCellValue();
				usagevalue = sheet.getRow(i).getCell(12).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview,
						colorway, vendor_Id, materialcode, millsapcode, usagevalue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC320_P0_E2E_UploadPlacementFile")
	public static Iterator<Object[]> TC320_P0_E2E_UploadPlacementFile() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC320_P0_E2E_UploadPlacementFile".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC315_P0_E2E_Specifications_AddImage")
	public static Iterator<Object[]> TC315_P0_E2E_Specifications_AddImage() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications, pagetype, pagedescription,
				pagelayout;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC315_P0_E2E_Specifications_AddImage".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();
				pagetype = sheet.getRow(i).getCell(6).getStringCellValue();
				pagedescription = sheet.getRow(i).getCell(7).getStringCellValue();
				pagelayout = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications,
						pagetype, pagedescription, pagelayout });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC34_P0_Specifications_CarryoverAttributes")
	public static Iterator<Object[]> TC34_P0_Specifications_CarryoverAttributes()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC34_P0_Specifications_CarryoverAttributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "Vendor_Portal_Data")
	public static Iterator<Object[]> Vendor_Portal_Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, vendorId, material, color, materialCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_02_vendor_Master_Update".equalsIgnoreCase(TestType)) {
				vendorId = sheet.getRow(i).getCell(1).getStringCellValue();
				material = sheet.getRow(i).getCell(2).getStringCellValue();
				color = sheet.getRow(i).getCell(3).getStringCellValue();
				materialCode = sheet.getRow(i).getCell(4).getStringCellValue();
				myData.add(new Object[] { TestType, vendorId, material, color, materialCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC30_P0_ADD_POMtoMeasurementTable")
	public static Iterator<Object[]> TC30_P0_ADD_POMtoMeasurementTable() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications, measurementsetname,
				template_name, productsize, gradetemplate, measurementtype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC30_P0_ADD_POMtoMeasurementTable".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();
				measurementsetname = sheet.getRow(i).getCell(6).getStringCellValue();
				template_name = sheet.getRow(i).getCell(7).getStringCellValue();
				productsize = sheet.getRow(i).getCell(10).getStringCellValue();
				measurementtype = sheet.getRow(i).getCell(9).getStringCellValue();
				gradetemplate = sheet.getRow(i).getCell(11).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications,
						measurementsetname, template_name, productsize, gradetemplate, measurementtype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC49_P0_CreateMultipleMesurementSet")
	public static Iterator<Object[]> TC49_P0_CreateMultipleMesurementSet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications, measurementsetname,
				template_name, productsize, gradetemplate, measurementtype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC49_P0_CreateMultipleMesurementSet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();
				measurementsetname = sheet.getRow(i).getCell(6).getStringCellValue();
				template_name = sheet.getRow(i).getCell(7).getStringCellValue();
				productsize = sheet.getRow(i).getCell(10).getStringCellValue();
				measurementtype = sheet.getRow(i).getCell(9).getStringCellValue();
				gradetemplate = sheet.getRow(i).getCell(11).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications,
						measurementsetname, template_name, productsize, gradetemplate, measurementtype });
			}
		}
		return myData.iterator();
	}

//------------------------------------------------------------------------------------------------------------------------

//	-------------------------------------------------------------------------------------------------------------------------

	@DataProvider(name = "TC01_P0_Product_CreateNewProduct")
	public static Iterator<Object[]> TC01_P0_Product_CreateNewProduct() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Product_CreateNewProduct".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "vendorLinkageData")
	public static Iterator<Object[]> vendorLinkageData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, viewType, colorWayName;
		List<String> vendorNames;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC321_P0_E2E_Vendor_Linkage_to_Colorway".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				vendorNames = Arrays.asList(sheet.getRow(i).getCell(4).getStringCellValue().split(";"));

				myData.add(new Object[] { TestType, mySeasonType, viewType, colorWayName, vendorNames });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "materialCreationData")
	public static Iterator<Object[]> materialCreationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription, uom;
		Map<String, String> fabricContents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC307_P0_E2E_MaterialCreation_YarnFabri".equalsIgnoreCase(TestType)) {
				typeOfFabric = sheet.getRow(i).getCell(1).getStringCellValue();
				fabricType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				fabricDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				uom = sheet.getRow(i).getCell(5).getStringCellValue();

				for (int j = 6; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					fabricContents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription,
						uom, fabricContents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "materialCreationSundriesData")
	public static Iterator<Object[]> materialCreationSundriesData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sundryType, sundryTypeValue, sundrySubTypeValue, seasonFirstIntroduced, genderType,
				sundryDescription, productCategoryType, brandType, sizeLength, sizeWidth, sizeUOM, uom;
		Map<String, String> Contents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC308_P0_E2E_MaterialCreation_SundriesPackaging".equalsIgnoreCase(TestType)) {
				sundryType = sheet.getRow(i).getCell(1).getStringCellValue();
				sundryTypeValue = sheet.getRow(i).getCell(2).getStringCellValue();
				sundrySubTypeValue = sheet.getRow(i).getCell(3).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(4).getStringCellValue();
				genderType = sheet.getRow(i).getCell(5).getStringCellValue();
				sundryDescription = sheet.getRow(i).getCell(6).getStringCellValue();
				productCategoryType = sheet.getRow(i).getCell(7).getStringCellValue();
				brandType = sheet.getRow(i).getCell(8).getStringCellValue();
				sizeLength = sheet.getRow(i).getCell(9).getStringCellValue();
				sizeWidth = sheet.getRow(i).getCell(10).getStringCellValue();
				sizeUOM = sheet.getRow(i).getCell(11).getStringCellValue();
				uom = sheet.getRow(i).getCell(12).getStringCellValue();

				for (int j = 13; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					Contents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, sundryType, sundryTypeValue, sundrySubTypeValue,
						seasonFirstIntroduced, genderType, sundryDescription, productCategoryType, brandType,
						sizeLength, sizeWidth, sizeUOM, uom, Contents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "materialCodeGenerationData")
	public static Iterator<Object[]> materialCodeGenerationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFinishRecipe, finishRecipeDescription, seasonFirstIntroduced, uom;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC309_P0_E2E_MaterialCodeGeneration_FinishRecipe".equalsIgnoreCase(TestType)) {
				typeOfFinishRecipe = sheet.getRow(i).getCell(1).getStringCellValue();
				finishRecipeDescription = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				uom = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, typeOfFinishRecipe, finishRecipeDescription, seasonFirstIntroduced,
						uom });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "fabricCodeAssociationData")
	public static Iterator<Object[]> fabricCodeAssociationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFinishRecipe, finishRecipeDescription, seasonFirstIntroduced, uom, materialCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC310_P0_E2E_FabricCodeAssociation_LookFinish".equalsIgnoreCase(TestType)) {
				typeOfFinishRecipe = sheet.getRow(i).getCell(1).getStringCellValue();
				finishRecipeDescription = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				uom = sheet.getRow(i).getCell(4).getStringCellValue();
				materialCode = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, typeOfFinishRecipe, finishRecipeDescription, seasonFirstIntroduced,
						uom, materialCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "lookFinishRecipeData")
	public static Iterator<Object[]> lookFinishRecipeData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonalLook, lookFinishRecipe;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC311_P0_E2E_LookFinishRecipe".equalsIgnoreCase(TestType)) {
				seasonalLook = sheet.getRow(i).getCell(1).getStringCellValue();
				lookFinishRecipe = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, seasonalLook, lookFinishRecipe });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "levisFemaleAccessoriesData")
	public static Iterator<Object[]> levisFemaleAccessoriesData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonType, productType, category, gender, brand, year, season, seasonCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC282_P0_E2E_SeasonCreation_FemaleAccessories".equalsIgnoreCase(TestType)) {
				seasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productType = sheet.getRow(i).getCell(2).getStringCellValue();
				category = sheet.getRow(i).getCell(3).getStringCellValue();
				gender = sheet.getRow(i).getCell(4).getStringCellValue();
				brand = sheet.getRow(i).getCell(5).getStringCellValue();
				year = sheet.getRow(i).getCell(6).getStringCellValue();
				season = sheet.getRow(i).getCell(7).getStringCellValue();
				seasonCode = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, seasonType, productType, category, gender, brand, year, season,
						seasonCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "orderAllocationData")
	public static Iterator<Object[]> orderAllocationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC287_P0_E2E_ProductCreation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizingAttributesData_Global")
	public static Iterator<Object[]> sizingAttributesData_Global() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, viewType, globalVaue, sizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC298_P0_E2E_SizingAttributes_Global".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				viewType = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, viewType, globalVaue, sizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizingAttributesData_Local")
	public static Iterator<Object[]> sizingAttributesData_Local() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, viewType, globalVaue, localHubValue, newSelectedSizesLH;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC299_P0_E2E_SizingAttributes_Local".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				viewType = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				newSelectedSizesLH = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, viewType, globalVaue, localHubValue,
						newSelectedSizesLH });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizingAttributesAffiliateData")
	public static Iterator<Object[]> sizingAttributesAffiliateData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, viewType, globalVaue, localHubValue, affiliateValue,
				newSelectedSizesLH;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC300_P0_E2E_SizingAttributes_Affiliate".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				viewType = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();
				newSelectedSizesLH = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, viewType, globalVaue, localHubValue,
						affiliateValue, newSelectedSizesLH });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "paletteFilterData")
	public static Iterator<Object[]> paletteFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, inputName, attributeValue, colorCodeNumber;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P0_Palette_CreateNewFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				inputName = sheet.getRow(i).getCell(2).getStringCellValue();
				attributeValue = sheet.getRow(i).getCell(3).getStringCellValue();
				colorCodeNumber = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, inputName, attributeValue, colorCodeNumber });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "profitCenterData")
	public static Iterator<Object[]> profitCenterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, businessObject;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P0_Validate_ProfitCenter_Creation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				businessObject = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, businessObject });
			}
		}
		return myData.iterator();
	}

//	@DataProvider(name = "profitCenterData")
//	public static Iterator<Object[]> profitCenterData() throws InvalidFormatException, IOException {
//		ArrayList<Object[]> myData = new ArrayList<Object[]>();
//		String filePath = System.getProperty("user.dir") + FILEPATH;
//		File file = new File(filePath + "\\" + FILENAME);
//		FileInputStream inputStream = new FileInputStream(file);
//		@SuppressWarnings("resource")
//		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
//		int numOfRows = sheet.getLastRowNum();
//		String TestType, mySeasonType, productName, colourWayName, Brand, Product_Category, Consumer_PH,
//				Profit_Center_APD;
//
//		for (int i = 1; i <= numOfRows; i++) {
//			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
//			if ("TC03_P0_Validate_ProfitCenter_Creation".equalsIgnoreCase(TestType)) {
//				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
//				productName = sheet.getRow(i).getCell(2).getStringCellValue();
//				colourWayName = sheet.getRow(i).getCell(3).getStringCellValue();
//				Brand = sheet.getRow(i).getCell(4).getStringCellValue();
//				Product_Category = sheet.getRow(i).getCell(5).getStringCellValue();
//				Consumer_PH = sheet.getRow(i).getCell(6).getStringCellValue();
//				Profit_Center_APD = sheet.getRow(i).getCell(7).getStringCellValue();
//
//				myData.add(new Object[] { TestType, mySeasonType, productName, colourWayName, Brand, Product_Category,
//						Consumer_PH, Profit_Center_APD });
//			}
//		}
//		return myData.iterator();
//	}

	@DataProvider(name = "printAndPatternsData")
	public static Iterator<Object[]> printAndPatternsData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, colourWayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC05_P0_VerifyColorwayAndMarketingNames".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colourWayName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, colourWayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "pc9CodeData")
	public static Iterator<Object[]> pc9CodeData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, colourWayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC15_P0_VerifyPC9CodeCreation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colourWayName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, colourWayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sundryColorwayData")
	public static Iterator<Object[]> sundryColorwayData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, colorType, sundryColorName, productSegmentationLSE_Value,
				productSegmentationLSUS_Value;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC38_P0_CreateSundryColorway".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colorType = sheet.getRow(i).getCell(3).getStringCellValue();
				sundryColorName = sheet.getRow(i).getCell(4).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(5).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, colorType, sundryColorName,
						productSegmentationLSE_Value, productSegmentationLSUS_Value });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updateSundryColorwayData")
	public static Iterator<Object[]> updateSundryColorwayData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, colourWayName, colorType, sundryColorName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC39_P0_UpdateSundryColorway".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colourWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				colorType = sheet.getRow(i).getCell(4).getStringCellValue();
				sundryColorName = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, colourWayName, colorType,
						sundryColorName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "adoptionData")
	public static Iterator<Object[]> adoptionData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, viewType, colorwayName, globalVaue, localHubValue, affiliateValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Adoption_Status_Changes".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorwayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, viewType, colorwayName, globalVaue, localHubValue,
						affiliateValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "adoptionPart2Data")
	public static Iterator<Object[]> adoptionPart2Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();

		String TestType, mySeasonType, productName, brandHierarchy, classValue, subClassValue, proSubCat1, proSubCat2,
				consumer, consumerGrp1, consumerGrp2, colorName, productTypeValue, rigidIndicatorValue,
				productSegmentationLSE_Value, productSegmentationLSUS_Value, hubOfferdToValue, viewType, filterType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Adoption_Product_Colorway_Creation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				classValue = sheet.getRow(i).getCell(4).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(5).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(6).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();
				colorName = sheet.getRow(i).getCell(11).getStringCellValue();
				productTypeValue = sheet.getRow(i).getCell(12).getStringCellValue();
				rigidIndicatorValue = sheet.getRow(i).getCell(13).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(14).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(15).getStringCellValue();
				hubOfferdToValue = sheet.getRow(i).getCell(16).getStringCellValue();
				viewType = sheet.getRow(i).getCell(17).getStringCellValue();
				filterType = sheet.getRow(i).getCell(18).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, brandHierarchy, classValue,
						subClassValue, proSubCat1, proSubCat2, consumer, consumerGrp1, consumerGrp2, colorName,
						productTypeValue, rigidIndicatorValue, productSegmentationLSE_Value,
						productSegmentationLSUS_Value, hubOfferdToValue, viewType, filterType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "linesheetFilterData")
	public static Iterator<Object[]> linesheetFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, filterName, attributeValue, colorwayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC59_P0_Linesheet_CreateNewFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				filterName = sheet.getRow(i).getCell(2).getStringCellValue();
				attributeValue = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayName = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, filterName, attributeValue, colorwayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "linesheetUpdateFilterData")
	public static Iterator<Object[]> linesheetUpdateFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, filterName, attributeValue, colorwayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC60_P0_Linesheet_UpdateFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				filterName = sheet.getRow(i).getCell(2).getStringCellValue();
				attributeValue = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayName = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, filterName, attributeValue, colorwayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "linesheetCopyFilterData")
	public static Iterator<Object[]> linesheetCopyFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, filterName, copyFilterName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC61_P0_Linesheet_CopyFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				filterName = sheet.getRow(i).getCell(2).getStringCellValue();
				copyFilterName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, filterName, copyFilterName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "linesheetShareFilterData")
	public static Iterator<Object[]> linesheetShareFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, filterName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC62_P0_Linesheet_ShareFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				filterName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, filterName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "linesheetDeleteFilterData")
	public static Iterator<Object[]> linesheetDeleteFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, filterName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC63_P0_Linesheet_DeleteFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				filterName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, filterName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "linesheetWormFilterData")
	public static Iterator<Object[]> linesheetWormFilterData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC64_P0_Linesheet_WormFilter".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "fabricRecordsData")
	public static Iterator<Object[]> fabricRecordsData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription, uom;
		Map<String, String> fabricContents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Material_CreateNewFabricRecords".equalsIgnoreCase(TestType)) {
				typeOfFabric = sheet.getRow(i).getCell(1).getStringCellValue();
				fabricType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				fabricDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				uom = sheet.getRow(i).getCell(5).getStringCellValue();

				for (int j = 6; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					fabricContents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription,
						uom, fabricContents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "fabricContentData")
	public static Iterator<Object[]> fabricContentData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription, uom;
		Map<String, String> fabricContents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC02_P0_Material_SetFabricContentAndVerifySorting".equalsIgnoreCase(TestType)) {
				typeOfFabric = sheet.getRow(i).getCell(1).getStringCellValue();
				fabricType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				fabricDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				uom = sheet.getRow(i).getCell(5).getStringCellValue();

				for (int j = 6; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					fabricContents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription,
						uom, fabricContents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updateMaterialData")
	public static Iterator<Object[]> updateMaterialData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialName, fabricType, seasonFirstIntroduced, fabricDescription, uom;
		Map<String, String> fabricContents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P0_UpdateMaterialrecord".equalsIgnoreCase(TestType)) {
				materialName = sheet.getRow(i).getCell(1).getStringCellValue();
				fabricType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				fabricDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				uom = sheet.getRow(i).getCell(5).getStringCellValue();

				for (int j = 6; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					fabricContents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, materialName, fabricType, seasonFirstIntroduced, fabricDescription,
						uom, fabricContents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "finishRecordsData")
	public static Iterator<Object[]> finishRecordsData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFinishRecipe, finishRecipeDescription, seasonFirstIntroduced, uom;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC10_P0_Material_CreateFinishRecordsTest".equalsIgnoreCase(TestType)) {
				typeOfFinishRecipe = sheet.getRow(i).getCell(1).getStringCellValue();
				finishRecipeDescription = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				uom = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, typeOfFinishRecipe, finishRecipeDescription, seasonFirstIntroduced,
						uom });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sundryMaterialData")
	public static Iterator<Object[]> sundryMaterialData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sundryType, sundryTypeValue, sundrySubTypeValue, seasonFirstIntroduced, genderType,
				sundryDescription, productCategoryType, brandType, size, sizeUOM, uom, sizeLength, sizeWidth;
		Map<String, String> Contents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC20_P0_Material_CreateSundryMaterial".equalsIgnoreCase(TestType)) {
				sundryType = sheet.getRow(i).getCell(1).getStringCellValue();
				sundryTypeValue = sheet.getRow(i).getCell(2).getStringCellValue();
				sundrySubTypeValue = sheet.getRow(i).getCell(3).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(4).getStringCellValue();
				genderType = sheet.getRow(i).getCell(5).getStringCellValue();
				sundryDescription = sheet.getRow(i).getCell(6).getStringCellValue();
				productCategoryType = sheet.getRow(i).getCell(7).getStringCellValue();
				brandType = sheet.getRow(i).getCell(8).getStringCellValue();
				size = sheet.getRow(i).getCell(9).getStringCellValue();
				sizeUOM = sheet.getRow(i).getCell(10).getStringCellValue();
				uom = sheet.getRow(i).getCell(11).getStringCellValue();
				sizeLength = sheet.getRow(i).getCell(12).getStringCellValue();
				sizeWidth = sheet.getRow(i).getCell(13).getStringCellValue();

				for (int j = 14; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					Contents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, sundryType, sundryTypeValue, sundrySubTypeValue,
						seasonFirstIntroduced, genderType, sundryDescription, productCategoryType, brandType, size,
						sizeUOM, uom, sizeLength, sizeWidth, Contents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updateSundryMaterialData")
	public static Iterator<Object[]> updateSundryMaterialData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sundryType, materialName, sundryTypeValue, sundrySubTypeValue, seasonFirstIntroduced,
				genderType, sundryDescription, productCategoryType, brandType, size, sizeUOM, uom, sizeLength,
				sizeWidth;
		Map<String, String> Contents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC21_P0_Material_UpdateSundryMaterial".equalsIgnoreCase(TestType)) {
				sundryType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				sundryTypeValue = sheet.getRow(i).getCell(3).getStringCellValue();
				sundrySubTypeValue = sheet.getRow(i).getCell(4).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(5).getStringCellValue();
				genderType = sheet.getRow(i).getCell(6).getStringCellValue();
				sundryDescription = sheet.getRow(i).getCell(7).getStringCellValue();
				productCategoryType = sheet.getRow(i).getCell(8).getStringCellValue();
				brandType = sheet.getRow(i).getCell(9).getStringCellValue();
				size = sheet.getRow(i).getCell(10).getStringCellValue();
				sizeUOM = sheet.getRow(i).getCell(11).getStringCellValue();
				uom = sheet.getRow(i).getCell(12).getStringCellValue();
				sizeLength = sheet.getRow(i).getCell(13).getStringCellValue();
				sizeWidth = sheet.getRow(i).getCell(14).getStringCellValue();
				for (int j = 15; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					Contents.put(contentType, percentage);
				}

				myData.add(new Object[] { TestType, sundryType, materialName, sundryTypeValue, sundrySubTypeValue,
						seasonFirstIntroduced, genderType, sundryDescription, productCategoryType, brandType, size,
						sizeUOM, uom, sizeLength, sizeWidth, Contents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "maleSeasonCreationData")
	public static Iterator<Object[]> maleSeasonCreationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonType, productType, Category, Gender, Brand, Year, season, seasonCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Create_Levis_Male_Accessories_Season".equalsIgnoreCase(TestType)) {
				seasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productType = sheet.getRow(i).getCell(2).getStringCellValue();
				Category = sheet.getRow(i).getCell(3).getStringCellValue();
				Gender = sheet.getRow(i).getCell(4).getStringCellValue();
				Brand = sheet.getRow(i).getCell(5).getStringCellValue();
				Year = sheet.getRow(i).getCell(6).getStringCellValue();
				season = sheet.getRow(i).getCell(7).getStringCellValue();
				seasonCode = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, seasonType, productType, Category, Gender, Brand, Year, season,
						seasonCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "femaleSeasonCreationData")
	public static Iterator<Object[]> femaleSeasonCreationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonType, productType, Category, Gender, Brand, Year, season, seasonCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC04_P0_Create_Levis_Female_Accessories_Season".equalsIgnoreCase(TestType)) {
				seasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productType = sheet.getRow(i).getCell(2).getStringCellValue();
				Category = sheet.getRow(i).getCell(3).getStringCellValue();
				Gender = sheet.getRow(i).getCell(4).getStringCellValue();
				Brand = sheet.getRow(i).getCell(5).getStringCellValue();
				Year = sheet.getRow(i).getCell(6).getStringCellValue();
				season = sheet.getRow(i).getCell(7).getStringCellValue();
				seasonCode = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, seasonType, productType, Category, Gender, Brand, Year, season,
						seasonCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "maleSeasonSearchData")
	public static Iterator<Object[]> maleSeasonSearchData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, searchValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC02_P0_seasonGroupAssociationsLevisMaleAccessories".equalsIgnoreCase(TestType)) {
				searchValue = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, searchValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "femaleSeasonSearchData")
	public static Iterator<Object[]> femaleSeasonSearchData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, searchValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC06_P0_seasonGroupAssociationsLevisFemaleAccessories".equalsIgnoreCase(TestType)) {
				searchValue = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, searchValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "paletteCreationData")
	public static Iterator<Object[]> paletteCreationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonType, prodCat1, prodCat2, brand, capsule, gender, category, reverseSeason;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC07_P0_Create_Levis_Accessories_Seasonal_Palette".equalsIgnoreCase(TestType)) {
				seasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				prodCat1 = sheet.getRow(i).getCell(2).getStringCellValue();
				prodCat2 = sheet.getRow(i).getCell(3).getStringCellValue();
				brand = sheet.getRow(i).getCell(4).getStringCellValue();
				capsule = sheet.getRow(i).getCell(5).getStringCellValue();
				gender = sheet.getRow(i).getCell(6).getStringCellValue();
				category = sheet.getRow(i).getCell(7).getStringCellValue();
				reverseSeason = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, seasonType, prodCat1, prodCat2, brand, capsule, gender, category,
						reverseSeason });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizeDimensionData")
	public static Iterator<Object[]> sizeDimensionData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, dimensionName, dimensionCode, dimension_Name, sizesString;
		List<String> sizes;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Creation_Of_Size_Dimension_In_Library".equalsIgnoreCase(TestType)) {
				dimensionName = sheet.getRow(i).getCell(1).getStringCellValue();
				dimensionCode = sheet.getRow(i).getCell(2).getStringCellValue();
				dimension_Name = sheet.getRow(i).getCell(3).getStringCellValue();
				sizesString = sheet.getRow(i).getCell(4).getStringCellValue();
				sizes = Arrays.asList(sizesString.split(","));

				myData.add(new Object[] { TestType, dimensionName, dimensionCode, dimension_Name, sizes });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizeScaleData")
	public static Iterator<Object[]> sizeScaleData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sizeScaleName, columnAbbreviation, columnDimension, columnName, sizeScaleCode, rowAbbreviation,
				rowDimension, rowName, description;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC02_P0_Creation_Of_Size_Scale_In_Library".equalsIgnoreCase(TestType)) {
				sizeScaleName = sheet.getRow(i).getCell(1).getStringCellValue();
				columnAbbreviation = sheet.getRow(i).getCell(2).getStringCellValue();
				columnDimension = sheet.getRow(i).getCell(3).getStringCellValue();
				columnName = sheet.getRow(i).getCell(4).getStringCellValue();
				sizeScaleCode = sheet.getRow(i).getCell(5).getStringCellValue();
				rowAbbreviation = sheet.getRow(i).getCell(6).getStringCellValue();
				rowDimension = sheet.getRow(i).getCell(7).getStringCellValue();
				rowName = sheet.getRow(i).getCell(8).getStringCellValue();
				description = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, sizeScaleName, columnAbbreviation, columnDimension, columnName,
						sizeScaleCode, rowAbbreviation, rowDimension, rowName, description });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizeGridData")
	public static Iterator<Object[]> sizeGridData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sizeGridName, code, sampleSize, coreOrSeasonal, SizeScale, sizeGridStatus;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P0_Creation_Of_Size_Grid_In_Library".equalsIgnoreCase(TestType)) {
				sizeGridName = sheet.getRow(i).getCell(1).getStringCellValue();
				code = sheet.getRow(i).getCell(2).getStringCellValue();
				sampleSize = sheet.getRow(i).getCell(3).getStringCellValue();
				coreOrSeasonal = sheet.getRow(i).getCell(4).getStringCellValue();
				SizeScale = sheet.getRow(i).getCell(5).getStringCellValue();
				sizeGridStatus = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, sizeGridName, code, sampleSize, coreOrSeasonal, SizeScale,
						sizeGridStatus });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "productData")
	public static Iterator<Object[]> productData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Product_CreateNewProduct".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "styleTypeData")
	public static Iterator<Object[]> styleTypeData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, proSubCat1, proSubCat2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC08_P0_Product_Verify_Style_Type_Derivation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, proSubCat1, proSubCat2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "colorwayAndProductData")
	public static Iterator<Object[]> colorwayAndProductData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, colourWayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC66_P0_ColorwayAndProductMarketingDerivation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colourWayName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, colourWayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "fitBlockData")
	public static Iterator<Object[]> fitBlockData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfProduct, fitBlockName, proSubCat1, gender_consGroup, measurementData, constructionData;
		List<String> sizes;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC41_P0_Product_Create_Fit_Block_Records".equalsIgnoreCase(TestType)) {
				typeOfProduct = sheet.getRow(i).getCell(1).getStringCellValue();
				fitBlockName = sheet.getRow(i).getCell(2).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(3).getStringCellValue();
				gender_consGroup = sheet.getRow(i).getCell(4).getStringCellValue();
				measurementData = sheet.getRow(i).getCell(5).getStringCellValue();
				sizes = Arrays.asList(sheet.getRow(i).getCell(6).getStringCellValue().split(","));
				constructionData = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, typeOfProduct, fitBlockName, proSubCat1, gender_consGroup,
						measurementData, sizes, constructionData });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "fitBlockSampleData")
	public static Iterator<Object[]> fitBlockSampleData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, productName, requestName, quantity, sampleRequestType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC42_P0_Initiate_FitBlock_Sample_Request".equalsIgnoreCase(TestType)) {
				productName = sheet.getRow(i).getCell(1).getStringCellValue();
				requestName = sheet.getRow(i).getCell(2).getStringCellValue();
				quantity = sheet.getRow(i).getCell(3).getStringCellValue();
				sampleRequestType = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, productName, requestName, quantity, sampleRequestType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "primarySourceData")
	public static Iterator<Object[]> primarySourceData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, productName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P0_Sourcing_PrimarySourceCreation".equalsIgnoreCase(TestType)) {
				productName = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, productName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updateSourceConfigData")
	public static Iterator<Object[]> updateSourceConfigData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, productName, seasonType, sourceName, vendor;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P0_Sourcing_UpdateSourceConfig".equalsIgnoreCase(TestType)) {
				productName = sheet.getRow(i).getCell(1).getStringCellValue();
				seasonType = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();
				vendor = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, productName, seasonType, sourceName, vendor });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "primarySource_Data")
	public static Iterator<Object[]> primarySource_Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC19_P0_PrimarySource_Specifications".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "removeSourceData")
	public static Iterator<Object[]> removeSourceData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, sourceName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC25_P0_RemoveSourcefromSeason".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, sourceName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sourceData")
	public static Iterator<Object[]> sourceData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName;
		List<String> vendorNames;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC16_P0_VerifySourceAddingAndRemovingFunctionality".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				vendorNames = Arrays.asList(sheet.getRow(i).getCell(3).getStringCellValue().split(","));

				myData.add(new Object[] { mySeasonType, productName, vendorNames });
			}
		}
		return myData.iterator();
	}

//-----------------------------------------------------------------------------------------------
//	P1 Testcases Data Providers

//	----------------------------------------------------------------------------------------------------

	@DataProvider(name = "TC01_P1_Search_PrintsandPatterns")
	public static Iterator<Object[]> TC01_P1_Search_PrintsandPatterns() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colorname, createdfrom, attributes;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P1_Search_PrintsandPatterns".equalsIgnoreCase(TestType)) {
				colorname = sheet.getRow(i).getCell(1).getStringCellValue();
				createdfrom = sheet.getRow(i).getCell(2).getStringCellValue();
				attributes = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, colorname, createdfrom, attributes });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P1_VerifyAttributes_CreatePrintsandPatternsPage")
	public static Iterator<Object[]> TC01_P1_VerifyAttributes_CreatePrintsandPatternsPage()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colortype, attributes;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P1_VerifyAttributes_CreatePrintsandPatternsPage".equalsIgnoreCase(TestType)) {
				attributes = sheet.getRow(i).getCell(3).getStringCellValue();
				colortype = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, colortype, attributes });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P1_UpdateExistingHeather_verifyName")
	public static Iterator<Object[]> TC03_P1_UpdateExistingHeather_verifyName()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colorname, createdfrom, newcolorname;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P1_UpdateExistingHeather_verifyName".equalsIgnoreCase(TestType)) {
				colorname = sheet.getRow(i).getCell(1).getStringCellValue();
				createdfrom = sheet.getRow(i).getCell(2).getStringCellValue();
				newcolorname = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, colorname, createdfrom, newcolorname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC06_P1_Verify_ReUse_PrintsandPatternsColor")
	public static Iterator<Object[]> TC06_P1_Verify_ReUse_PrintsandPatternsColor()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, classification, producttype, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC06_P1_Verify_ReUse_PrintsandPatternsColor".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC10_P1_VerifyLookdetails_InCreatePC9")
	public static Iterator<Object[]> TC10_P1_VerifyLookdetails_InCreatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				linesheetview, hubofferedto, secondseason, secondproduct;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC10_P1_VerifyLookdetails_InCreatePC9".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				secondseason = sheet.getRow(i).getCell(8).getStringCellValue();
				secondproduct = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(11).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview, hubofferedto, secondseason,
						secondproduct });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC12_P1_VerifySeasonalLook_InCreatePC9")
	public static Iterator<Object[]> TC12_P1_VerifySeasonalLook_InCreatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				linesheetview, hubofferedto, secondseason, secondproduct, createddate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC12_P1_VerifySeasonalLook_InCreatePC9".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				secondseason = sheet.getRow(i).getCell(8).getStringCellValue();
				secondproduct = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(11).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();
				createddate = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview, hubofferedto, secondseason,
						secondproduct, createddate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P1_VerifyProfitCenter_US")
	public static Iterator<Object[]> TC17_P1_VerifyProfitCenter_US() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P1_VerifyProfitCenter_US".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC18_P1_Verify_SeasonFirstIntroduced")
	public static Iterator<Object[]> TC18_P1_Verify_SeasonFirstIntroduced() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC18_P1_Verify_SeasonFirstIntroduced".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC19_P1_Verify_ConsumerGroupExt_1_2")
	public static Iterator<Object[]> TC19_P1_Verify_ConsumerGroupExt_1_2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC19_P1_Verify_ConsumerGroupExt_1_2".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC20_P1_Verify_SampleDestroyIndicator")
	public static Iterator<Object[]> TC20_P1_Verify_SampleDestroyIndicator()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC20_P1_Verify_SampleDestroyIndicator".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC24_P1_Verify_updatePC9_thumbnail")
	public static Iterator<Object[]> TC24_P1_Verify_updatePC9_thumbnail() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, linesheetview, hubofferedto;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC24_P1_Verify_updatePC9_thumbnail".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(11).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview, hubofferedto });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC30_P1_VerifyLookDetails_UpdatePC9")
	public static Iterator<Object[]> TC30_P1_VerifyLookDetails_UpdatePC9() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, linesheetview, hubofferedto, secondseason, secondcolorway;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC30_P1_VerifyLookDetails_UpdatePC9".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				secondseason = sheet.getRow(i).getCell(8).getStringCellValue();
				secondcolorway = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(11).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview, hubofferedto, secondseason,
						secondcolorway });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC36_P1_Verify_ConsumerExt1_2_UpdatePC9")
	public static Iterator<Object[]> TC36_P1_Verify_ConsumerExt1_2_UpdatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview, consumergroupext1, consumergroupext2;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC36_P1_Verify_ConsumerExt1_2_UpdatePC9".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(4).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview, consumergroupext1,
						consumergroupext2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC33_P1_Verify_ReuseSeasonalLook_updatePC9")
	public static Iterator<Object[]> TC33_P1_Verify_ReuseSeasonalLook_updatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, linesheetview, createddate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC33_P1_Verify_ReuseSeasonalLook_updatePC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();
				createddate = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview, createddate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC37_P1_Verify_DestroySample_UpdatePC9")
	public static Iterator<Object[]> TC37_P1_Verify_DestroySample_UpdatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview, productsegLSUSvalue, productsegLSEvalue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC37_P1_Verify_DestroySample_UpdatePC9".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview, productsegLSUSvalue,
						productsegLSEvalue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC40_P1_Verify_BrandHierarchyValue")
	public static Iterator<Object[]> TC40_P1_Verify_BrandHierarchyValue() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC40_P1_Verify_BrandHierarchyValue".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC41_P1_Verify_StagingId")
	public static Iterator<Object[]> TC41_P1_Verify_StagingId() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC41_P1_Verify_StagingId".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC165_P1_CreatePC9_SeasonalBFF")
	public static Iterator<Object[]> TC165_P1_CreatePC9_SeasonalBFF() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, linesheetview, hubofferedto, rigidindicator, createddate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC165_P1_CreatePC9_SeasonalBFF".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(12).getStringCellValue();
				createddate = sheet.getRow(i).getCell(13).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, linesheetview,
						hubofferedto, rigidindicator, createddate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC181_P1_addPD_GD_PM_newproduct_Linesheet")
	public static Iterator<Object[]> TC181_P1_addPD_GD_PM_newproduct_Linesheet()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorway, merchant, PDS, garmentdeveloper, designer;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC181_P1_addPD_GD_PM_newproduct_Linesheet".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				merchant = sheet.getRow(i).getCell(4).getStringCellValue();
				PDS = sheet.getRow(i).getCell(5).getStringCellValue();
				garmentdeveloper = sheet.getRow(i).getCell(6).getStringCellValue();
				designer = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, merchant, PDS, garmentdeveloper,
						designer });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC182_P1_addPD_GD_Designer_UpdateColorway")
	public static Iterator<Object[]> TC182_P1_addPD_GD_Designer_UpdateColorway()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorway, merchant, fieldPDS, garmentdeveloper, designer;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC182_P1_addPD_GD_Designer_UpdateColorway".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				merchant = sheet.getRow(i).getCell(4).getStringCellValue();
				fieldPDS = sheet.getRow(i).getCell(5).getStringCellValue();
				garmentdeveloper = sheet.getRow(i).getCell(6).getStringCellValue();
				designer = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, merchant, fieldPDS,
						garmentdeveloper, designer });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC183_UpdatePC9_BFFcolor")
	public static Iterator<Object[]> TC183_UpdatePC9_BFFcolor() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview, productsegLSUSvalue, productsegLSEvalue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC183_UpdatePC9_BFFcolor".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, linesheetview, productsegLSUSvalue,
						productsegLSEvalue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC191_P1_CreatePC9_usingPaletteColor")
	public static Iterator<Object[]> TC191_P1_CreatePC9_usingPaletteColor() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, palettecolorname, productsegLSUSvalue, productsegLSEvalue, classification,
				producttype, hubofferedto, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC191_P1_CreatePC9_usingPaletteColor".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				palettecolorname = sheet.getRow(i).getCell(3).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(4).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				classification = sheet.getRow(i).getCell(6).getStringCellValue();
				producttype = sheet.getRow(i).getCell(7).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(8).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, palettecolorname, productsegLSUSvalue,
						productsegLSEvalue, classification, producttype, hubofferedto, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC195_P1_UpdatePC9_paletteColor")
	public static Iterator<Object[]> TC195_P1_UpdatePC9_paletteColor() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, palettecolorname, productsegLSUSvalue, productsegLSEvalue, classification,
				producttype, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC195_P1_UpdatePC9_paletteColor".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				palettecolorname = sheet.getRow(i).getCell(3).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(4).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(5).getStringCellValue();
				classification = sheet.getRow(i).getCell(6).getStringCellValue();
				producttype = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, palettecolorname, productsegLSUSvalue,
						productsegLSEvalue, classification, producttype, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC33_Specifications_carryoverColorway")
	public static Iterator<Object[]> TC33_Specifications_carryoverColorway()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, to_season, from_season, linesheetview, garmentlinesheetview, colorwayname, source,
				specifications, pagetype, pagedescription, pagelayout;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC33_Specifications_carryoverColorway".equalsIgnoreCase(TestType)) {

				to_season = sheet.getRow(i).getCell(1).getStringCellValue();
				from_season = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(4).getStringCellValue();
				source = sheet.getRow(i).getCell(5).getStringCellValue();
				specifications = sheet.getRow(i).getCell(6).getStringCellValue();
				pagetype = sheet.getRow(i).getCell(7).getStringCellValue();
				pagedescription = sheet.getRow(i).getCell(8).getStringCellValue();
				pagelayout = sheet.getRow(i).getCell(9).getStringCellValue();
				garmentlinesheetview = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, to_season, from_season, linesheetview, garmentlinesheetview,
						colorwayname, source, specifications, pagetype, pagedescription, pagelayout });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC19_P1_CopyCarryover_VerifyPC5Attributes")
	public static Iterator<Object[]> TC19_P1_CopyCarryover_VerifyPC5Attributes()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, linesheetview, finalseason, copiedproduct;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC19_P1_CopyCarryover_VerifyPC5Attributes".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				finalseason = sheet.getRow(i).getCell(4).getStringCellValue();
				copiedproduct = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, linesheetview, finalseason, copiedproduct });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct")
	public static Iterator<Object[]> TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P1_UpdateRigidIndicator_AfterSetupLSE")
	public static Iterator<Object[]> TC02_P1_UpdateRigidIndicator_AfterSetupLSE()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P1_UpdateRigidIndicator_AfterSetupLSE".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC09_P1_CustomLoaders_MaterialPrice")
	public static Iterator<Object[]> TC09_P1_CustomLoaders_MaterialPrice() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC09_P1_CustomLoaders_MaterialPrice".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC08_P1_CustomLoaders_ProfitCenterAPD")
	public static Iterator<Object[]> TC08_P1_CustomLoaders_ProfitCenterAPD()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, colorway, profitcenterAPD;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC08_P1_CustomLoaders_ProfitCenterAPD".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();
				profitcenterAPD = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview,
						colorway, profitcenterAPD });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P1_ValidateFilters_BFF")
	public static Iterator<Object[]> TC02_P1_ValidateFilters_BFF() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, productname, colorwayname, colorwaycode, productcode,
				linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P1_ValidateFilters_BFF".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(6).getStringCellValue();
				productcode = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();
				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, productname, colorwayname,
						colorwaycode, productcode, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC06_P1_ValidateFilters_DataValidation")
	public static Iterator<Object[]> TC06_P1_ValidateFilters_DataValidation()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, activate;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC06_P1_ValidateFilters_DataValidation".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				activate = sheet.getRow(i).getCell(15).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, activate });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC08_P1_ValidateFilters_GlobalFilter")
	public static Iterator<Object[]> TC08_P1_ValidateFilters_GlobalFilter() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, colorwayname, colorwaycode, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC08_P1_ValidateFilters_GlobalFilter".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(6).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();
				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, colorwayname, colorwaycode,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC12_P1_ValidateFilter_PDS_SSM")
	public static Iterator<Object[]> TC12_P1_ValidateFilter_PDS_SSM() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, productname, colorwayname, colorwaycode, productcode,
				linesheetview, merchant, PDS, vendorId;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC12_P1_ValidateFilter_PDS_SSM".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(6).getStringCellValue();
				productcode = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();
				merchant = sheet.getRow(i).getCell(9).getStringCellValue();
				PDS = sheet.getRow(i).getCell(10).getStringCellValue();
				vendorId = sheet.getRow(i).getCell(11).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, productname, colorwayname,
						colorwaycode, productcode, linesheetview, merchant, PDS, vendorId });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC15_P1_validateFilters_SizeSelection")
	public static Iterator<Object[]> TC15_P1_validateFilters_SizeSelection()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, adoptedLH, adoptedAFF, carryover, capsule, available,
				productdevcenter, colorwaycode, sizegridcode, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC15_P1_validateFilters_SizeSelection".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				adoptedLH = sheet.getRow(i).getCell(4).getStringCellValue();
				adoptedAFF = sheet.getRow(i).getCell(5).getStringCellValue();
				carryover = sheet.getRow(i).getCell(6).getStringCellValue();
				capsule = sheet.getRow(i).getCell(7).getStringCellValue();
				available = sheet.getRow(i).getCell(8).getStringCellValue();
				productdevcenter = sheet.getRow(i).getCell(9).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(10).getStringCellValue();
				sizegridcode = sheet.getRow(i).getCell(11).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, adoptedLH, adoptedAFF,
						carryover, capsule, available, productdevcenter, colorwaycode, sizegridcode, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC16_P1_ValidateFilter_SSM")
	public static Iterator<Object[]> TC16_P1_ValidateFilter_SSM() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, productname, colorwayname, vendorId, colorwaycode,
				productcode, carryover, available, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC16_P1_ValidateFilter_SSM".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				vendorId = sheet.getRow(i).getCell(11).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(6).getStringCellValue();
				productcode = sheet.getRow(i).getCell(7).getStringCellValue();
				carryover = sheet.getRow(i).getCell(12).getStringCellValue();
				available = sheet.getRow(i).getCell(13).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, productname, colorwayname,
						vendorId, colorwaycode, productcode, carryover, available, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P1_ValidateFilters_Techpackgrouping")
	public static Iterator<Object[]> TC17_P1_ValidateFilters_Techpackgrouping()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, productname, colorwayname, vendorId, colorwaycode,
				productcode, available, PDS, garmentdeveloper, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P1_ValidateFilters_Techpackgrouping".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				vendorId = sheet.getRow(i).getCell(11).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(6).getStringCellValue();
				productcode = sheet.getRow(i).getCell(7).getStringCellValue();
				PDS = sheet.getRow(i).getCell(10).getStringCellValue();
				available = sheet.getRow(i).getCell(13).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();
				garmentdeveloper = sheet.getRow(i).getCell(14).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, productname, colorwayname,
						vendorId, colorwaycode, productcode, available, PDS, garmentdeveloper, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC12_P1_ValidateFilters_Placement")
	public static Iterator<Object[]> TC12_P1_ValidateFilters_Placement() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC12_P1_ValidateFilters_Placement".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_setUPLSUS_usingLinesheet")
	public static Iterator<Object[]> TC03_setUPLSUS_usingLinesheet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_setUPLSUS_usingLinesheet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC57_P1_Placement_ValidateBlank_MX_GDV_value")
	public static Iterator<Object[]> TC57_P1_Placement_ValidateBlank_MX_GDV_value()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC57_P1_Placement_ValidateBlank_MX_GDV_value".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, colorway,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value")
	public static Iterator<Object[]> TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, colorway,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC59_P1_Placement_ValidateBlank_CHINA_GDV_value")
	public static Iterator<Object[]> TC59_P1_Placement_ValidateBlank_CHINA_GDV_value()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC59_P1_Placement_ValidateBlank_CHINA_GDV_value".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, colorway,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC60_P1_Placement_ValidateBlank_CA_GDV_value")
	public static Iterator<Object[]> TC60_P1_Placement_ValidateBlank_CA_GDV_value()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC60_P1_Placement_ValidateBlank_CA_GDV_value".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, colorway,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC62_P1_Placement_ValidateBlank_MALA_GDV_Value")
	public static Iterator<Object[]> TC62_P1_Placement_ValidateBlank_MALA_GDV_Value()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC62_P1_Placement_ValidateBlank_MALA_GDV_Value".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, colorway,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor")
	public static Iterator<Object[]> TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview, filepath;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				filepath = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview, filepath });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P1_Techpack_MassEditable_PDView")
	public static Iterator<Object[]> TC01_P1_Techpack_MassEditable_PDView() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P1_Techpack_MassEditable_PDView".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage")
	public static Iterator<Object[]> TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filterproduct, source, specifications, requestType;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filterproduct = sheet.getRow(i).getCell(3).getStringCellValue();
				source = sheet.getRow(i).getCell(4).getStringCellValue();
				specifications = sheet.getRow(i).getCell(5).getStringCellValue();
				requestType = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filterproduct, source, specifications,
						requestType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC35_P1_CopyCarryover_ValidateAttributes")
	public static Iterator<Object[]> TC35_P1_CopyCarryover_ValidateAttributes()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorwayCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC35_P1_CopyCarryover_ValidateAttributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayCode = sheet.getRow(i).getCell(2).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, colorwayCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC37_P1_CopyCarryOver_moveCarryoverAttributes")
	public static Iterator<Object[]> TC37_P1_CopyCarryOver_moveCarryoverAttributes()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorwayCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC37_P1_CopyCarryOver_moveCarryoverAttributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayCode = sheet.getRow(i).getCell(2).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, colorwayCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "Create_Colors_Sundry_PrintPatterns")
	public static Iterator<Object[]> Create_Colors_Sundry() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, name, redvalue, bluevalue, greenvalue, colorname, colorfamily, artworkname, artworkcode,
				patterntype, colorcombo, developer, colortype, material, printColor, sundryColor, descriptionValue, UOM;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P1_Create_Sundry_PrintPatterns_color".equalsIgnoreCase(TestType)) {
				name = sheet.getRow(i).getCell(1).getStringCellValue();
				redvalue = sheet.getRow(i).getCell(2).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(3).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(4).getStringCellValue();
				colorname = sheet.getRow(i).getCell(5).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(6).getStringCellValue();
				artworkname = sheet.getRow(i).getCell(7).getStringCellValue();
				artworkcode = sheet.getRow(i).getCell(8).getStringCellValue();
				patterntype = sheet.getRow(i).getCell(9).getStringCellValue();
				colorcombo = sheet.getRow(i).getCell(10).getStringCellValue();
				developer = sheet.getRow(i).getCell(11).getStringCellValue();
				colortype = sheet.getRow(i).getCell(12).getStringCellValue();
				material = sheet.getRow(i).getCell(13).getStringCellValue();
				printColor = sheet.getRow(i).getCell(14).getStringCellValue();
				sundryColor = sheet.getRow(i).getCell(15).getStringCellValue();
				descriptionValue = sheet.getRow(i).getCell(16).getStringCellValue();
				UOM = sheet.getRow(i).getCell(17).getStringCellValue();
				myData.add(new Object[] { TestType, name, redvalue, bluevalue, greenvalue, colorname, colorfamily,
						artworkname, artworkcode, patterntype, colorcombo, developer, colortype, material, printColor,
						sundryColor, descriptionValue, UOM });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "component_selection_view")
	public static Iterator<Object[]> component_selection_view() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, product;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P1_component_selection_view".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				product = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, product });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "copyColorway")
	public static Iterator<Object[]> copyColorway() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview1, colorwayCode, colorCode, linesheetview2, linesheetview3, colorwayCode2;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC08_P1_copyColorway".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview1 = sheet.getRow(i).getCell(2).getStringCellValue();
				colorwayCode = sheet.getRow(i).getCell(3).getStringCellValue();
				colorCode = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview2 = sheet.getRow(i).getCell(5).getStringCellValue();
				linesheetview3 = sheet.getRow(i).getCell(6).getStringCellValue();
				colorwayCode2 = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview1, colorwayCode, colorCode, linesheetview2,
						linesheetview3, colorwayCode2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "multiple_colorways_sources")
	public static Iterator<Object[]> multiple_colorways_sources() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview1, linesheetview2, productCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC11_P1_MultipleSources_Colorways".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview1 = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview2 = sheet.getRow(i).getCell(3).getStringCellValue();
				productCode = sheet.getRow(i).getCell(4).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview1, linesheetview2, productCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "delink_colorway")
	public static Iterator<Object[]> delink_colorway() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview1, productCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC20_P1_delink_colorway".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview1 = sheet.getRow(i).getCell(2).getStringCellValue();
				productCode = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview1, productCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "carryover_colorway")
	public static Iterator<Object[]> carryover_colorway() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, toSeason, fromSeason, linesheetview1, productCode, colorwayname, linesheetview2,
				linesheetview3;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC007_P1_Caryyover_Colorway".equalsIgnoreCase(TestType)) {
				toSeason = sheet.getRow(i).getCell(1).getStringCellValue();
				fromSeason = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview1 = sheet.getRow(i).getCell(3).getStringCellValue();
				productCode = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				linesheetview2 = sheet.getRow(i).getCell(6).getStringCellValue();
				linesheetview3 = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, toSeason, fromSeason, linesheetview1, productCode, colorwayname,
						linesheetview2, linesheetview3 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "download_techpack")
	public static Iterator<Object[]> download_techpack() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorwayCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_P1_Download_TechPack".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorwayCode = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, colorwayCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "AttributesValidation")
	public static Iterator<Object[]> AttributesValidation() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorwayCode;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC35_P1_Attributes_Validation".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorwayCode = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, colorwayCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "BOM_App_Data")
	public static Iterator<Object[]> BOM_App_Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, Season, PC9_1, Component, ComponentLoc, Remarks, Material, PC9_2, Qty, NewRemarks;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC_05_BOM_Details_Update".equalsIgnoreCase(TestType)) {
				Season = sheet.getRow(i).getCell(1).getStringCellValue();
				PC9_1 = sheet.getRow(i).getCell(2).getStringCellValue();
				Component = sheet.getRow(i).getCell(3).getStringCellValue();
				ComponentLoc = sheet.getRow(i).getCell(4).getStringCellValue();
				Remarks = sheet.getRow(i).getCell(5).getStringCellValue();
				Material = sheet.getRow(i).getCell(6).getStringCellValue();
				PC9_2 = sheet.getRow(i).getCell(7).getStringCellValue();
				Qty = sheet.getRow(i).getCell(8).getStringCellValue();
				NewRemarks = sheet.getRow(i).getCell(9).getStringCellValue();
				myData.add(new Object[] { TestType, Season, PC9_1, Component, ComponentLoc, Remarks, Material, PC9_2,
						Qty, NewRemarks });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "colorwayCodeData")
	public static Iterator<Object[]> colorwayCodeData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, viewType, colorWay, affiliateValue, currentPlannedLifecycleAFF,
				firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF,
				bucketCodeAFF;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC302_P0_E2E_Colorway_Activation_LSA".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWay = sheet.getRow(i).getCell(3).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(4).getStringCellValue();
				currentPlannedLifecycleAFF = sheet.getRow(i).getCell(5).getStringCellValue();
				firstOnFloorMonthAFF = sheet.getRow(i).getCell(6).getStringCellValue();
				dlvySelectedAFF = sheet.getRow(i).getCell(7).getStringCellValue();
				ticketCode = sheet.getRow(i).getCell(8).getStringCellValue();
				lsusStockingCSC = sheet.getRow(i).getCell(9).getStringCellValue();
				targetAFFMSRP = sheet.getRow(i).getCell(10).getStringCellValue();
				priceWhslAFF = sheet.getRow(i).getCell(11).getStringCellValue();
				bucketCodeAFF = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, viewType, colorWay, affiliateValue,
						currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode, lsusStockingCSC,
						targetAFFMSRP, priceWhslAFF, bucketCodeAFF });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "AssociateSolidColorsToFabrics")
	public static Iterator<Object[]> AssociateSolidColorsToFabrics() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplierName, colorType, colorItem;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC05_P1_AssociateSolidColorsToFabrics".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplierName = sheet.getRow(i).getCell(3).getStringCellValue();
				colorType = sheet.getRow(i).getCell(4).getStringCellValue();
				colorItem = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplierName, colorType, colorItem });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC12_P1_UpdateSolidColorWithSameColorLookID")
	public static Iterator<Object[]> TC12_P1_UpdateSolidColorWithSameColorLookID()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colorLookType, solidColor_1, solidColor_2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC12_P1_UpdateSolidColorWithSameColorLookID".equalsIgnoreCase(TestType)) {
				colorLookType = sheet.getRow(i).getCell(1).getStringCellValue();
				solidColor_1 = sheet.getRow(i).getCell(2).getStringCellValue();
				solidColor_2 = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, colorLookType, solidColor_1, solidColor_2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC19_P1_Seasonal_Look_Update_and_Derived_Attribute")
	public static Iterator<Object[]> TC19_P1_Seasonal_Look_Update_and_Derived_Attribute()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colorLookType, seasonalLook, lookName, colorFamily;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC19_P1_Seasonal_Look_Update_and_Derived_Attribute".equalsIgnoreCase(TestType)) {
				colorLookType = sheet.getRow(i).getCell(1).getStringCellValue();
				seasonalLook = sheet.getRow(i).getCell(2).getStringCellValue();
				lookName = sheet.getRow(i).getCell(3).getStringCellValue();
				colorFamily = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, colorLookType, seasonalLook, lookName, colorFamily });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC31_P1_Verify_LSE_Product_Segmentation")
	public static Iterator<Object[]> TC31_P1_Verify_LSE_Product_Segmentation()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorWay, businessObject;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC31_P1_Verify_LSE_Product_Segmentation".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWay = sheet.getRow(i).getCell(3).getStringCellValue();
				businessObject = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorWay, businessObject });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC32_P1_Verify_LSUS_Product_Segmentation")
	public static Iterator<Object[]> TC32_P1_Verify_LSUS_Product_Segmentation()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorWay, businessObject;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC32_P1_Verify_LSUS_Product_Segmentation".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWay = sheet.getRow(i).getCell(3).getStringCellValue();
				businessObject = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorWay, businessObject });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC33_P1_Verify_Profit_Center_APD")
	public static Iterator<Object[]> TC33_P1_Verify_Profit_Center_APD() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorWay, businessObject;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC33_P1_Verify_Profit_Center_APD".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWay = sheet.getRow(i).getCell(3).getStringCellValue();
				businessObject = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorWay, businessObject });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC35_P1_VerifyColorwayAndMarketingNames")
	public static Iterator<Object[]> TC35_P1_VerifyColorwayAndMarketingNames()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, rigidIndicatorValue, productSegmentationLSE_Value,
				productSegmentationLSUS_Value, colorLookType, printPatternColor;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC35_P1_VerifyColorwayAndMarketingNames".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				rigidIndicatorValue = sheet.getRow(i).getCell(4).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(5).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(6).getStringCellValue();
				colorLookType = sheet.getRow(i).getCell(7).getStringCellValue();
				printPatternColor = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, rigidIndicatorValue,
						productSegmentationLSE_Value, productSegmentationLSUS_Value, colorLookType,
						printPatternColor });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC38_P1_Verify_ProfitCenter_EUROPE")
	public static Iterator<Object[]> TC38_P1_Verify_ProfitCenter_EUROPE() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, productSegmentationLSE_Value;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC38_P1_Verify_ProfitCenter_EUROPE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, productSegmentationLSE_Value });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC39_P1_Verify_ProfitCenter_US")
	public static Iterator<Object[]> TC39_P1_Verify_ProfitCenter_US() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, productSegmentationLSUS_Value;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC39_P1_Verify_ProfitCenter_US".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, productSegmentationLSUS_Value });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC46_P1_Update_PC9")
	public static Iterator<Object[]> TC46_P1_Update_PC9() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, targetVolume, collectionType, capsule, materialType,
				performance, consumerGroup, consumerGroupExt1, consumerGroupExt2, destroySampleInd, profitCenterAPD,
				merchFabricType, briefCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC46_P1_Update_PC9_With_Non_Required_Attributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				targetVolume = sheet.getRow(i).getCell(4).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(5).getStringCellValue();
				capsule = sheet.getRow(i).getCell(6).getStringCellValue();
				materialType = sheet.getRow(i).getCell(7).getStringCellValue();
				performance = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGroup = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGroupExt1 = sheet.getRow(i).getCell(10).getStringCellValue();
				consumerGroupExt2 = sheet.getRow(i).getCell(11).getStringCellValue();
				destroySampleInd = sheet.getRow(i).getCell(12).getStringCellValue();
				profitCenterAPD = sheet.getRow(i).getCell(13).getStringCellValue();
				merchFabricType = sheet.getRow(i).getCell(14).getStringCellValue();
				briefCode = sheet.getRow(i).getCell(15).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, targetVolume, collectionType,
						capsule, materialType, performance, consumerGroup, consumerGroupExt1, consumerGroupExt2,
						destroySampleInd, profitCenterAPD, merchFabricType, briefCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC99_P1_Adoption_Product_Colorway_Creation")
	public static Iterator<Object[]> TC99_P1_Adoption_Product_Colorway_Creation()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, productName, brandHierarchy, classValue, subClassValue, proSubCat1, proSubCat2,
				consumer, consumerGrp1, consumerGrp2, colorName, productTypeValue, rigidIndicatorValue,
				productSegmentationLSE_Value, productSegmentationLSUS_Value, hubOfferdToValue, viewType, filterType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC99_P1_Adoption_Product_Colorway_Creation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				classValue = sheet.getRow(i).getCell(4).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(5).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(6).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();
				colorName = sheet.getRow(i).getCell(11).getStringCellValue();
				productTypeValue = sheet.getRow(i).getCell(12).getStringCellValue();
				rigidIndicatorValue = sheet.getRow(i).getCell(13).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(14).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(15).getStringCellValue();
				hubOfferdToValue = sheet.getRow(i).getCell(16).getStringCellValue();
				viewType = sheet.getRow(i).getCell(17).getStringCellValue();
				filterType = sheet.getRow(i).getCell(18).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, productName, brandHierarchy, classValue,
						subClassValue, proSubCat1, proSubCat2, consumer, consumerGrp1, consumerGrp2, colorName,
						productTypeValue, rigidIndicatorValue, productSegmentationLSE_Value,
						productSegmentationLSUS_Value, hubOfferdToValue, viewType, filterType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "colorwayCode_Data")
	public static Iterator<Object[]> colorwayCode_Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, viewType, colorWay, affiliateValue, currentPlannedLifecycleAFF,
				firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF,
				bucketCodeAFF;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC302_P0_E2E_ColorwayCodeActivation".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWay = sheet.getRow(i).getCell(3).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(4).getStringCellValue();
				currentPlannedLifecycleAFF = sheet.getRow(i).getCell(5).getStringCellValue();
				firstOnFloorMonthAFF = sheet.getRow(i).getCell(6).getStringCellValue();
				dlvySelectedAFF = sheet.getRow(i).getCell(7).getStringCellValue();
				ticketCode = sheet.getRow(i).getCell(8).getStringCellValue();
				lsusStockingCSC = sheet.getRow(i).getCell(9).getStringCellValue();
				targetAFFMSRP = sheet.getRow(i).getCell(10).getStringCellValue();
				priceWhslAFF = sheet.getRow(i).getCell(11).getStringCellValue();
				bucketCodeAFF = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, viewType, colorWay, affiliateValue,
						currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode, lsusStockingCSC,
						targetAFFMSRP, priceWhslAFF, bucketCodeAFF });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sourceData_LinkAndDlink")
	public static Iterator<Object[]> sourceData_LinkAndDlink() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P0");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, viewType1, colorWayName, viewType2, delinkSourceToColorway;
		List<String> vendorNames;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC16_P0_VerifySourceAddingAndRemovingFunctionality".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType1 = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				vendorNames = Arrays.asList(sheet.getRow(i).getCell(4).getStringCellValue().split(";"));
				viewType2 = sheet.getRow(i).getCell(5).getStringCellValue();
				delinkSourceToColorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, viewType1, colorWayName, vendorNames, viewType2,
						delinkSourceToColorway });
			}
		}
		return myData.iterator();
	}

	/////////////////////////////////////////////////////

	////////////////////////////////////////////////////

	////////////////////////////////////////////////////

	@DataProvider(name = "associateSupplier_FinishRecords_Data")
	public static Iterator<Object[]> associateSupplier_FinishRecords_Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplier;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC148_P1_AssociateSupplierToFinishRecords".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplier = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplier });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "associateColorsData")
	public static Iterator<Object[]> associateColorsData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplierName, colorItem;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC154_P1_AssociateColorsToFinishRecords".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplierName = sheet.getRow(i).getCell(3).getStringCellValue();
				colorItem = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplierName, colorItem });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "associateFabricsData")
	public static Iterator<Object[]> associateFabricsData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, fabric;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC161_P1_AssociateFabricsToFinishRecords".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				fabric = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, fabric });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "associateSupplier_Sundries_Data")
	public static Iterator<Object[]> associateSupplier_Sundries_Data() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplier;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC167_P1_AssociateSupplierToSundries".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplier = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplier });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updateMaterialSupplierData")
	public static Iterator<Object[]> updateMaterialSupplierData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplierName, supplierArticleNo, supplierDescription,
				minimumPerColorUOM, approvalDate_MMDDYYYY, MinimumPerOrderUOM, materialCountryOfOrigin, IncoTerms,
				testResults, labTestReportNumber, physicalTestPassed, minimumPerColor, performanceTestPass,
				minimumsPerOrder, leadTimeProductionCalendardays, uomConversionFactor, leadTimeSampleCalendardays,
				MaterialPrice;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC174_P1_UpdateMaterialSupplierRecordsForSundries".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplierName = sheet.getRow(i).getCell(3).getStringCellValue();
				supplierArticleNo = sheet.getRow(i).getCell(4).getStringCellValue();
				supplierDescription = sheet.getRow(i).getCell(5).getStringCellValue();
				minimumPerColorUOM = sheet.getRow(i).getCell(6).getStringCellValue();
				approvalDate_MMDDYYYY = sheet.getRow(i).getCell(7).getStringCellValue();
				MinimumPerOrderUOM = sheet.getRow(i).getCell(8).getStringCellValue();
				materialCountryOfOrigin = sheet.getRow(i).getCell(9).getStringCellValue();
				IncoTerms = sheet.getRow(i).getCell(10).getStringCellValue();
				testResults = sheet.getRow(i).getCell(11).getStringCellValue();
				labTestReportNumber = sheet.getRow(i).getCell(12).getStringCellValue();
				physicalTestPassed = sheet.getRow(i).getCell(13).getStringCellValue();
				minimumPerColor = sheet.getRow(i).getCell(14).getStringCellValue();
				performanceTestPass = sheet.getRow(i).getCell(15).getStringCellValue();
				minimumsPerOrder = sheet.getRow(i).getCell(16).getStringCellValue();
				leadTimeProductionCalendardays = sheet.getRow(i).getCell(17).getStringCellValue();
				uomConversionFactor = sheet.getRow(i).getCell(18).getStringCellValue();
				leadTimeSampleCalendardays = sheet.getRow(i).getCell(19).getStringCellValue();
				MaterialPrice = sheet.getRow(i).getCell(20).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplierName, supplierArticleNo,
						supplierDescription, minimumPerColorUOM, approvalDate_MMDDYYYY, MinimumPerOrderUOM,
						materialCountryOfOrigin, IncoTerms, testResults, labTestReportNumber, physicalTestPassed,
						minimumPerColor, performanceTestPass, minimumsPerOrder, leadTimeProductionCalendardays,
						uomConversionFactor, leadTimeSampleCalendardays, MaterialPrice });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "copyProductMeasurementData")
	public static Iterator<Object[]> copyProductMeasurementData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, product, season, specification, measurementSet, newProduct, seasonOfNewProd, specOfNewProd,
				measurementsetname, sizevalue, measurementtype;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC179_P1_CopyProductMeasurementSetsFromClipboard".equalsIgnoreCase(TestType)) {
				product = sheet.getRow(i).getCell(1).getStringCellValue();
				season = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();
				measurementSet = sheet.getRow(i).getCell(4).getStringCellValue();
				newProduct = sheet.getRow(i).getCell(5).getStringCellValue();
				seasonOfNewProd = sheet.getRow(i).getCell(6).getStringCellValue();
				specOfNewProd = sheet.getRow(i).getCell(7).getStringCellValue();
				measurementsetname = sheet.getRow(i).getCell(8).getStringCellValue();
				sizevalue = sheet.getRow(i).getCell(9).getStringCellValue();
				measurementtype = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, product, season, specification, measurementSet, newProduct,
						seasonOfNewProd, specOfNewProd, measurementsetname, sizevalue, measurementtype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updatePOMImagesData")
	public static Iterator<Object[]> updatePOMImagesData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specification, measurementSet, imagePath;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC186_P1_UpdatePOMImageFromProdManagement".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();
				measurementSet = sheet.getRow(i).getCell(4).getStringCellValue();
				imagePath = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specification, measurementSet, imagePath });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updatePOMpointsData")
	public static Iterator<Object[]> updatePOMpointsData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, template, pomDescription, updatedPOMDescription, updatedId;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC191_P1_Measurements_Update_POM".equalsIgnoreCase(TestType)) {
				template = sheet.getRow(i).getCell(1).getStringCellValue();
				pomDescription = sheet.getRow(i).getCell(2).getStringCellValue();
				updatedPOMDescription = sheet.getRow(i).getCell(3).getStringCellValue();
				updatedId = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, template, pomDescription, updatedPOMDescription, updatedId });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "measurementsCriticalDropdownData")
	public static Iterator<Object[]> measurementsCriticalDropdownData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specification, measurementSet, criticality, pomID, pomDescription,
				tolPlusCell, tolMinusCell;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC195_P1_Measurements_Critical_Dropdown_Functionality".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();
				measurementSet = sheet.getRow(i).getCell(4).getStringCellValue();
				criticality = sheet.getRow(i).getCell(5).getStringCellValue();
				pomID = sheet.getRow(i).getCell(6).getStringCellValue();
				pomDescription = sheet.getRow(i).getCell(7).getStringCellValue();
				tolPlusCell = sheet.getRow(i).getCell(8).getStringCellValue();
				tolMinusCell = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specification, measurementSet, criticality,
						pomID, pomDescription, tolPlusCell, tolMinusCell });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "moveDeleteRowData")
	public static Iterator<Object[]> moveDeleteRowData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, product, season, source, specification, measurementSet;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC203_P1_Measurements_Move_Delete_Row".equalsIgnoreCase(TestType)) {
				product = sheet.getRow(i).getCell(1).getStringCellValue();
				season = sheet.getRow(i).getCell(2).getStringCellValue();
				source = sheet.getRow(i).getCell(3).getStringCellValue();
				specification = sheet.getRow(i).getCell(4).getStringCellValue();
				measurementSet = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, product, season, source, specification, measurementSet });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "styleTypeData_P1")
	public static Iterator<Object[]> styleTypeData_P1() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC214_P1_VerifyStyleTypeDerivation".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "updateProductData")
	public static Iterator<Object[]> updateProductData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, updatedProductName, updatedBrandHierarchy, updatedClassValue,
				updatedSubClassValue, updatedProSubCat1, updatedProSubCat2, updatedConsumer, updatedConsumerGrp1,
				updatedConsumerGrp2, updatedCustomsClassification;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC217_P1_VerifyUpdateProduct".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				updatedProductName = sheet.getRow(i).getCell(3).getStringCellValue();
				updatedBrandHierarchy = sheet.getRow(i).getCell(4).getStringCellValue();
				updatedClassValue = sheet.getRow(i).getCell(5).getStringCellValue();
				updatedSubClassValue = sheet.getRow(i).getCell(6).getStringCellValue();
				updatedProSubCat1 = sheet.getRow(i).getCell(7).getStringCellValue();
				updatedProSubCat2 = sheet.getRow(i).getCell(8).getStringCellValue();
				updatedConsumer = sheet.getRow(i).getCell(9).getStringCellValue();
				updatedConsumerGrp1 = sheet.getRow(i).getCell(10).getStringCellValue();
				updatedConsumerGrp2 = sheet.getRow(i).getCell(11).getStringCellValue();
				updatedCustomsClassification = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, updatedProductName, updatedBrandHierarchy,
						updatedClassValue, updatedSubClassValue, updatedProSubCat1, updatedProSubCat2, updatedConsumer,
						updatedConsumerGrp1, updatedConsumerGrp2, updatedCustomsClassification });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "createProductData")
	public static Iterator<Object[]> createProductData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, brandHierarchy, classValue, subClassValue, proSubCat1, proSubCat2,
				consumer, consumerGrp1, consumerGrp2, customsClassification, includeMerchFabricTypeinCWName, codeType,
				productType, productReportCharacteristics, dimensions, typeOfClosure, fitReference, capacity;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC220_P1_CreateNewProduct_With_Non_Required_Attributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				classValue = sheet.getRow(i).getCell(4).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(5).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(6).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();
				customsClassification = sheet.getRow(i).getCell(11).getStringCellValue();
				includeMerchFabricTypeinCWName = sheet.getRow(i).getCell(12).getStringCellValue();
				codeType = sheet.getRow(i).getCell(13).getStringCellValue();
				productType = sheet.getRow(i).getCell(14).getStringCellValue();
				productReportCharacteristics = sheet.getRow(i).getCell(15).getStringCellValue();
				dimensions = sheet.getRow(i).getCell(16).getStringCellValue();
				typeOfClosure = sheet.getRow(i).getCell(17).getStringCellValue();
				fitReference = sheet.getRow(i).getCell(18).getStringCellValue();
				capacity = sheet.getRow(i).getCell(19).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, brandHierarchy, classValue, subClassValue,
						proSubCat1, proSubCat2, consumer, consumerGrp1, consumerGrp2, customsClassification,
						includeMerchFabricTypeinCWName, codeType, productType, productReportCharacteristics, dimensions,
						typeOfClosure, fitReference, capacity });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "createPaletteData")
	public static Iterator<Object[]> createPaletteData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, paletteName, seasonType, category, gender, brand, colorItem, materialName,
				materialColorName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC230_P1_CreateSeasonalPalette".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				paletteName = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonType = sheet.getRow(i).getCell(3).getStringCellValue();
				category = sheet.getRow(i).getCell(4).getStringCellValue();
				gender = sheet.getRow(i).getCell(5).getStringCellValue();
				brand = sheet.getRow(i).getCell(6).getStringCellValue();
				colorItem = sheet.getRow(i).getCell(7).getStringCellValue();
				materialName = sheet.getRow(i).getCell(8).getStringCellValue();
				materialColorName = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, paletteName, seasonType, category, gender, brand, colorItem,
						materialName, materialColorName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizeGridData_P1")
	public static Iterator<Object[]> sizeGridData_P1() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, sizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC242_P1_VerifyActiveSizeGridSelection".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, sizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizeGridAttributesData")
	public static Iterator<Object[]> sizeGridAttributesData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, sizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC244_P1_VerifySizeGridSelection_and_Attributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, sizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "sizeGridData_NEW_PC9_Prior_to_Setup")
	public static Iterator<Object[]> sizeGridData_NEW_PC9_Prior_to_Setup() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, linesheetview, colorway, sizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC248_P1_ApplySizeGridToNEW_PC9_Prior_to_Setup".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, colorway, sizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "materialSupplierAttributesData")
	public static Iterator<Object[]> materialSupplierData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplierName, materialCountryOfOrigin, fabricCuttableWidth,
				fabricCuttableWidthUOM, supplierArticleNo, uomConversionFactor, fabricPurchaseWeight,
				fabricPurchaseWeightUOM, fabricMill;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC143_P1_UpdateMaterialSupplierAttributes".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplierName = sheet.getRow(i).getCell(3).getStringCellValue();
				materialCountryOfOrigin = sheet.getRow(i).getCell(4).getStringCellValue();
				fabricCuttableWidth = sheet.getRow(i).getCell(5).getStringCellValue();
				fabricCuttableWidthUOM = sheet.getRow(i).getCell(6).getStringCellValue();
				supplierArticleNo = sheet.getRow(i).getCell(7).getStringCellValue();
				uomConversionFactor = sheet.getRow(i).getCell(8).getStringCellValue();
				fabricPurchaseWeight = sheet.getRow(i).getCell(9).getStringCellValue();
				fabricPurchaseWeightUOM = sheet.getRow(i).getCell(10).getStringCellValue();
				fabricMill = sheet.getRow(i).getCell(11).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplierName, materialCountryOfOrigin,
						fabricCuttableWidth, fabricCuttableWidthUOM, supplierArticleNo, uomConversionFactor,
						fabricPurchaseWeight, fabricPurchaseWeightUOM, fabricMill });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "pc9CreationData")
	public static Iterator<Object[]> pc9CreationData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, colorName, productTypeValue, rigidIndicatorValue,
				productSegmentationLSE_Value, productSegmentationLSUS_Value, targetVolume, collectionType, capsule,
				materialType, performance, consumerGroup, consumerGroupExt1, consumerGroupExt2, destroySampleInd,
				profitCenterAPD, merchFabricType, briefCode, hubOfferdToValue, sizeGridCode, primaryFabric,
				seasonalDirection, gtmTrack, firstDirectiveMonth, lastSeasonOffered, globalOnFloorIntent,
				firstMonthOnFloor, winAtMarketplaceSoHem, winAtMarketplaceNoHem, winAtMarketplaceEquatorial,
				blpForecast, equityMOQRequest, earlyDelivery, lsusStockingCSC, currentPlannedLifecycle, heroOutfit,
				productPricePositioning, primaryFinishMill, primaryFinish, fabricMill, seasonalLook;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC45_P1_Create_PC9_With_Non_Required_Attributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colorName = sheet.getRow(i).getCell(3).getStringCellValue();
				productTypeValue = sheet.getRow(i).getCell(4).getStringCellValue();
				rigidIndicatorValue = sheet.getRow(i).getCell(5).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(6).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(7).getStringCellValue();
				targetVolume = sheet.getRow(i).getCell(8).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(9).getStringCellValue();
				capsule = sheet.getRow(i).getCell(10).getStringCellValue();
				materialType = sheet.getRow(i).getCell(11).getStringCellValue();
				performance = sheet.getRow(i).getCell(12).getStringCellValue();
				consumerGroup = sheet.getRow(i).getCell(13).getStringCellValue();
				consumerGroupExt1 = sheet.getRow(i).getCell(14).getStringCellValue();
				consumerGroupExt2 = sheet.getRow(i).getCell(15).getStringCellValue();
				destroySampleInd = sheet.getRow(i).getCell(16).getStringCellValue();
				profitCenterAPD = sheet.getRow(i).getCell(17).getStringCellValue();
				merchFabricType = sheet.getRow(i).getCell(18).getStringCellValue();
				briefCode = sheet.getRow(i).getCell(19).getStringCellValue();
				hubOfferdToValue = sheet.getRow(i).getCell(20).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(21).getStringCellValue();
				primaryFabric = sheet.getRow(i).getCell(22).getStringCellValue();
				seasonalDirection = sheet.getRow(i).getCell(23).getStringCellValue();
				gtmTrack = sheet.getRow(i).getCell(24).getStringCellValue();
				firstDirectiveMonth = sheet.getRow(i).getCell(25).getStringCellValue();
				lastSeasonOffered = sheet.getRow(i).getCell(26).getStringCellValue();
				globalOnFloorIntent = sheet.getRow(i).getCell(27).getStringCellValue();
				firstMonthOnFloor = sheet.getRow(i).getCell(28).getStringCellValue();
				winAtMarketplaceSoHem = sheet.getRow(i).getCell(29).getStringCellValue();
				winAtMarketplaceNoHem = sheet.getRow(i).getCell(30).getStringCellValue();
				winAtMarketplaceEquatorial = sheet.getRow(i).getCell(31).getStringCellValue();
				blpForecast = sheet.getRow(i).getCell(32).getStringCellValue();
				equityMOQRequest = sheet.getRow(i).getCell(33).getStringCellValue();
				earlyDelivery = sheet.getRow(i).getCell(34).getStringCellValue();
				lsusStockingCSC = sheet.getRow(i).getCell(35).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(36).getStringCellValue();
				heroOutfit = sheet.getRow(i).getCell(37).getStringCellValue();
				productPricePositioning = sheet.getRow(i).getCell(38).getStringCellValue();
				primaryFinishMill = sheet.getRow(i).getCell(39).getStringCellValue();
				primaryFinish = sheet.getRow(i).getCell(40).getStringCellValue();
				fabricMill = sheet.getRow(i).getCell(41).getStringCellValue();
				seasonalLook = sheet.getRow(i).getCell(42).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, colorName, productTypeValue,
						rigidIndicatorValue, productSegmentationLSE_Value, productSegmentationLSUS_Value, targetVolume,
						collectionType, capsule, materialType, performance, consumerGroup, consumerGroupExt1,
						consumerGroupExt2, destroySampleInd, profitCenterAPD, merchFabricType, briefCode,
						hubOfferdToValue, sizeGridCode, primaryFabric, seasonalDirection, gtmTrack, firstDirectiveMonth,
						lastSeasonOffered, globalOnFloorIntent, firstMonthOnFloor, winAtMarketplaceSoHem,
						winAtMarketplaceNoHem, winAtMarketplaceEquatorial, blpForecast, equityMOQRequest, earlyDelivery,
						lsusStockingCSC, currentPlannedLifecycle, heroOutfit, productPricePositioning,
						primaryFinishMill, primaryFinish, fabricMill, seasonalLook });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "adoptionStatusData")
	public static Iterator<Object[]> adoptionStatusData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorwayName, globalVaue, localHubValue, affiliateValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC93_P1_Adoption_Status_Changes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorwayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorwayName, globalVaue, localHubValue,
						affiliateValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "associateSupplierData")
	public static Iterator<Object[]> associateSupplierData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P1");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplier;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC137_P1_AssociateSupplierToFabricRecords".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplier = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplier });
			}
		}
		return myData.iterator();
	}

//---------------------------------------------------------------------------------------------------------------------------
//	```````````````````````P2 scripts`````````````````````````````````````````````````````````````````````
//--------------------------------------------------------------------------------------------------------------------------------------------	

	@DataProvider(name = "TC01_P2_Color_CopySolidColor")
	public static Iterator<Object[]> TC01_P2_Color_CopySolidColor() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colormenu, colorsubmenu, filtercolor, newcolorname;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P2_Color_CopySolidColor".equalsIgnoreCase(TestType)) {
				colormenu = sheet.getRow(i).getCell(1).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(2).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(3).getStringCellValue();
				newcolorname = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, colormenu, colorsubmenu, filtercolor, newcolorname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette")
	public static Iterator<Object[]> TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colorname, artworkcode, artworkname;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorname = sheet.getRow(i).getCell(2).getStringCellValue();
				artworkcode = sheet.getRow(i).getCell(3).getStringCellValue();
				artworkname = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorname, artworkcode, artworkname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P2_Color_UploadPrintsandpatternsThumbnail")
	public static Iterator<Object[]> TC03_P2_Color_UploadPrintsandpatternsThumbnail()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colorname, filepath, colorway, linesheetview, filename;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC03_P2_Color_UploadPrintsandpatternsThumbnail".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorname = sheet.getRow(i).getCell(2).getStringCellValue();
				filepath = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(7).getStringCellValue();
				filename = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorname, filepath, colorway, linesheetview, filename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC04_P2_Color_UpdateLookInformation_SeasonalLook")
	public static Iterator<Object[]> TC04_P2_Color_UpdateLookInformation_SeasonalLook()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colormenu, colorsubmenu, filtercolor, finishformulaname;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC04_P2_Color_UpdateLookInformation_SeasonalLook".equalsIgnoreCase(TestType)) {
				colormenu = sheet.getRow(i).getCell(1).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(2).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(3).getStringCellValue();
				finishformulaname = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, colormenu, colorsubmenu, filtercolor, finishformulaname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC05_P2_Color_UploadThumbnail_SeasonalLook")
	public static Iterator<Object[]> TC05_P2_Color_UploadThumbnail_SeasonalLook()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colormenu, colorsubmenu, filtercolor, filepath, linesheetview, colorway, filename;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC05_P2_Color_UploadThumbnail_SeasonalLook".equalsIgnoreCase(TestType)) {
				colormenu = sheet.getRow(i).getCell(1).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(2).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(3).getStringCellValue();
				filepath = sheet.getRow(i).getCell(6).getStringCellValue();
				colorway = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();
				filename = sheet.getRow(i).getCell(9).getStringCellValue();
				season = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, colormenu, colorsubmenu, filtercolor, filepath,
						linesheetview, colorway, filename });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC05_P2_Color_Delete_LookInformation")
	public static Iterator<Object[]> TC05_P2_Color_Delete_LookInformation() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, colormenu, colorsubmenu, filtercolor, finishformulaname;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC05_P2_Color_Delete_LookInformation".equalsIgnoreCase(TestType)) {
				colormenu = sheet.getRow(i).getCell(1).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(2).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(3).getStringCellValue();
				finishformulaname = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, colormenu, colorsubmenu, filtercolor, finishformulaname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC11_P2_Colorwway_VerifyReuseLook_CreatePC9")
	public static Iterator<Object[]> TC11_P2_Colorwway_VerifyReuseLook_CreatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, classification, producttype, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC11_P2_Colorwway_VerifyReuseLook_CreatePC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC13_P2_Colorway_VerifySeasonalLook_CreatePC9")
	public static Iterator<Object[]> TC13_P2_Colorway_VerifySeasonalLook_CreatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, classification, producttype, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC13_P2_Colorway_VerifySeasonalLook_CreatePC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC31_P2_Colorway_VerifyReuseLook_UpdatePC9")
	public static Iterator<Object[]> TC31_P2_Colorway_VerifyReuseLook_UpdatePC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC31_P2_Colorway_VerifyReuseLook_UpdatePC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC26_P2_Colorway_VerifyReusePrintsandPatterns_Update_different_PC9")
	public static Iterator<Object[]> TC26_P2_Colorway_VerifyReusePrintsandPatterns_Update_different_PC9()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC26_P2_Colorway_VerifyReusePrintsandPatterns_Update_different_PC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC167_P2_Colorway_CreatePC9_withBFFcolor")
	public static Iterator<Object[]> TC167_P2_Colorway_CreatePC9_withBFFcolor()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				linesheetview, hubofferedto;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC167_P2_Colorway_CreatePC9_withBFFcolor".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(10).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(11).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, linesheetview, hubofferedto });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE")
	public static Iterator<Object[]> TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colorway, linesheetview, capsule, materialType, consumerGroup, consumerGroupExt1,
				consumerGroupExt2, destroySampleInd, profitCenterAPD, productlifecyclegroup, hubofferedto,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, sizeGridCode,
				currentPlannedLifecycle, updatedBrandHierarchy, updatedClassValue, updatedSubClassValue,
				updatedProSubCat1, updatedProSubCat2, updatedConsumer, updatedConsumerGrp1, updatedConsumerGrp2,
				updatedCustomsClassification;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				materialType = sheet.getRow(i).getCell(4).getStringCellValue();
				consumerGroup = sheet.getRow(i).getCell(5).getStringCellValue();
				consumerGroupExt1 = sheet.getRow(i).getCell(6).getStringCellValue();
				consumerGroupExt2 = sheet.getRow(i).getCell(7).getStringCellValue();
				destroySampleInd = sheet.getRow(i).getCell(8).getStringCellValue();
				capsule = sheet.getRow(i).getCell(9).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(11).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(12).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(13).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(14).getStringCellValue();
				profitCenterAPD = sheet.getRow(i).getCell(15).getStringCellValue();
				createddate = sheet.getRow(i).getCell(16).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(17).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(18).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(19).getStringCellValue();
				updatedBrandHierarchy = sheet.getRow(i).getCell(20).getStringCellValue();
				updatedClassValue = sheet.getRow(i).getCell(21).getStringCellValue();
				updatedSubClassValue = sheet.getRow(i).getCell(22).getStringCellValue();
				updatedProSubCat1 = sheet.getRow(i).getCell(23).getStringCellValue();
				updatedProSubCat2 = sheet.getRow(i).getCell(24).getStringCellValue();
				updatedConsumer = sheet.getRow(i).getCell(25).getStringCellValue();
				updatedConsumerGrp1 = sheet.getRow(i).getCell(26).getStringCellValue();
				updatedConsumerGrp2 = sheet.getRow(i).getCell(27).getStringCellValue();
				updatedCustomsClassification = sheet.getRow(i).getCell(28).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview, capsule, materialType,
						consumerGroup, consumerGroupExt1, consumerGroupExt2, destroySampleInd, profitCenterAPD,
						productlifecyclegroup, hubofferedto, lastseasonoffered, productpricepositioning, createddate,
						filtermaterial, sizeGridCode, currentPlannedLifecycle, updatedBrandHierarchy, updatedClassValue,
						updatedSubClassValue, updatedProSubCat1, updatedProSubCat2, updatedConsumer,
						updatedConsumerGrp1, updatedConsumerGrp2, updatedCustomsClassification });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE")
	public static Iterator<Object[]> TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colorway, linesheetview, productlifecyclegroup, lastseasonoffered,
				currentPlannedLifecycle;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();

				productlifecyclegroup = sheet.getRow(i).getCell(4).getStringCellValue();

				lastseasonoffered = sheet.getRow(i).getCell(5).getStringCellValue();

				currentPlannedLifecycle = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview, productlifecyclegroup,
						lastseasonoffered, currentPlannedLifecycle });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE")
	public static Iterator<Object[]> TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colorway, linesheetview, productlifecyclegroup, lastseasonoffered,
				currentPlannedLifecycle;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();

				productlifecyclegroup = sheet.getRow(i).getCell(4).getStringCellValue();

				lastseasonoffered = sheet.getRow(i).getCell(5).getStringCellValue();

				currentPlannedLifecycle = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview, productlifecyclegroup,
						lastseasonoffered, currentPlannedLifecycle });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy")
	public static Iterator<Object[]> TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, product, newseason, filtervalue, newname, updatedBrandHierarchy, updatedClassValue,
				updatedSubClassValue, updatedProSubCat1, updatedProSubCat2, updatedConsumer, updatedConsumerGrp1,
				updatedConsumerGrp2, updatedCustomsClassification;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				newseason = sheet.getRow(i).getCell(3).getStringCellValue();
				filtervalue = sheet.getRow(i).getCell(4).getStringCellValue();
				newname = sheet.getRow(i).getCell(5).getStringCellValue();
				updatedBrandHierarchy = sheet.getRow(i).getCell(6).getStringCellValue();
				updatedClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				updatedSubClassValue = sheet.getRow(i).getCell(8).getStringCellValue();
				updatedProSubCat1 = sheet.getRow(i).getCell(9).getStringCellValue();
				updatedProSubCat2 = sheet.getRow(i).getCell(10).getStringCellValue();
				updatedConsumer = sheet.getRow(i).getCell(11).getStringCellValue();
				updatedConsumerGrp1 = sheet.getRow(i).getCell(12).getStringCellValue();
				updatedConsumerGrp2 = sheet.getRow(i).getCell(13).getStringCellValue();
				updatedCustomsClassification = sheet.getRow(i).getCell(14).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, newseason, filtervalue, newname,
						updatedBrandHierarchy, updatedClassValue, updatedSubClassValue, updatedProSubCat1,
						updatedProSubCat2, updatedConsumer, updatedConsumerGrp1, updatedConsumerGrp2,
						updatedCustomsClassification });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC05_P2_CustomLoaders_Verify_Taget_FOB")
	public static Iterator<Object[]> TC05_P2_CustomLoaders_Verify_Taget_FOB()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, colorway, targetFOB;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC05_P2_CustomLoaders_Verify_Taget_FOB".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();
				targetFOB = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview,
						colorway, targetFOB });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_SetUP_And_Activate_LSUS_Linesheet")
	public static Iterator<Object[]> TC_SetUP_And_Activate_LSUS_Linesheet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_FLA,
				linesheetview_LSUS, globalVaue, linesheetview_sizes, localhub, newSelectedSizesLH, affiliate,
				linesheetview_activation, currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode,
				lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, newSelectedSizesAFF, linesheetview_NRF,
				LSEStockingvalue, FirstMonthValue, Targetmsrpvalue, NRFclass, NRFcolor, NRFsizescale, primaryfabric;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC_SetUP_And_Activate_LSUS_Linesheet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				linesheetview_sizes = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview_FLA = sheet.getRow(i).getCell(5).getStringCellValue();
				linesheetview_LSUS = sheet.getRow(i).getCell(6).getStringCellValue();
				linesheetview_activation = sheet.getRow(i).getCell(7).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(8).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(9).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(10).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(11).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(12).getStringCellValue();
				classification = sheet.getRow(i).getCell(13).getStringCellValue();
				producttype = sheet.getRow(i).getCell(14).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(15).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(16).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(17).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(18).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(19).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(20).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(21).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(22).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(23).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(24).getStringCellValue();
				createddate = sheet.getRow(i).getCell(25).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(26).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(27).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(28).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(29).getStringCellValue();
				capsule = sheet.getRow(i).getCell(30).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(31).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(32).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(33).getStringCellValue();
				localhub = sheet.getRow(i).getCell(34).getStringCellValue();
				newSelectedSizesLH = sheet.getRow(i).getCell(35).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(36).getStringCellValue();
				currentPlannedLifecycleAFF = sheet.getRow(i).getCell(37).getStringCellValue();
				firstOnFloorMonthAFF = sheet.getRow(i).getCell(38).getStringCellValue();
				dlvySelectedAFF = sheet.getRow(i).getCell(39).getStringCellValue();
				ticketCode = sheet.getRow(i).getCell(40).getStringCellValue();
				lsusStockingCSC = sheet.getRow(i).getCell(41).getStringCellValue();
				targetAFFMSRP = sheet.getRow(i).getCell(42).getStringCellValue();
				priceWhslAFF = sheet.getRow(i).getCell(43).getStringCellValue();
				bucketCodeAFF = sheet.getRow(i).getCell(44).getStringCellValue();
				newSelectedSizesAFF = sheet.getRow(i).getCell(45).getStringCellValue();
				linesheetview_NRF = sheet.getRow(i).getCell(46).getStringCellValue();
				LSEStockingvalue = sheet.getRow(i).getCell(47).getStringCellValue();
				FirstMonthValue = sheet.getRow(i).getCell(48).getStringCellValue();
				Targetmsrpvalue = sheet.getRow(i).getCell(49).getStringCellValue();
				NRFclass = sheet.getRow(i).getCell(50).getStringCellValue();
				NRFcolor = sheet.getRow(i).getCell(51).getStringCellValue();
				NRFsizescale = sheet.getRow(i).getCell(52).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(53).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_FLA,
						linesheetview_LSUS, globalVaue, linesheetview_sizes, localhub, newSelectedSizesLH, affiliate,
						linesheetview_activation, currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF,
						ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, newSelectedSizesAFF,
						linesheetview_NRF, LSEStockingvalue, FirstMonthValue, Targetmsrpvalue, NRFclass, NRFcolor,
						NRFsizescale, primaryfabric });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC05_P2_Linesheet_Adoption_DropGB_LH")
	public static Iterator<Object[]> TC05_P2_Linesheet_Adoption_DropGB_LH() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, globalValue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC05_P2_Linesheet_Adoption_DropGB_LH".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				globalValue = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, globalValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available")
	public static Iterator<Object[]> TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, localhub, filtercolorway, globalValue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				localhub = sheet.getRow(i).getCell(3).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(4).getStringCellValue();
				globalValue = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, localhub, filtercolorway, globalValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC69_P2_Placement_VerifyPlacementAttributes_Carryover")
	public static Iterator<Object[]> TC69_P2_Placement_VerifyPlacementAttributes_Carryover()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, filtercolorway, vendor_Id, AusGdv_value, MALAGdv_value, usagevalue,
				changereason_value, changecomments_value;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC69_P2_Placement_VerifyPlacementAttributes_Carryover".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				filtercolorway = sheet.getRow(i).getCell(3).getStringCellValue();
				vendor_Id = sheet.getRow(i).getCell(4).getStringCellValue();
				AusGdv_value = sheet.getRow(i).getCell(5).getStringCellValue();
				MALAGdv_value = sheet.getRow(i).getCell(6).getStringCellValue();
				usagevalue = sheet.getRow(i).getCell(7).getStringCellValue();
				changereason_value = sheet.getRow(i).getCell(8).getStringCellValue();
				changecomments_value = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, filtercolorway, vendor_Id, AusGdv_value,
						MALAGdv_value, usagevalue, changereason_value, changecomments_value });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC24_P2_Techpack_ProtoTechpack")
	public static Iterator<Object[]> TC24_P2_Techpack_ProtoTechpack() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename, specstatus, techpackoptions;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC24_P2_Techpack_ProtoTechpack".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(3).getStringCellValue();
				specstatus = sheet.getRow(i).getCell(4).getStringCellValue();
				techpackoptions = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename, specstatus, techpackoptions });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC24_P2_Techpack_CSTeschpack_download")
	public static Iterator<Object[]> TC24_P2_Techpack_CSTeschpack_download()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename, specstatus, techpackoptions;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC24_P2_Techpack_CSTeschpack_download".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(3).getStringCellValue();
				specstatus = sheet.getRow(i).getCell(4).getStringCellValue();
				techpackoptions = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename, specstatus, techpackoptions });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P2_TechPack_MassEditable_PDView")
	public static Iterator<Object[]> TC01_P2_TechPack_MassEditable_PDView() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, sourcename, specstatus, techpackoptions;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P2_TechPack_MassEditable_PDView".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				sourcename = sheet.getRow(i).getCell(3).getStringCellValue();
				specstatus = sheet.getRow(i).getCell(4).getStringCellValue();
				techpackoptions = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, linesheetview, sourcename, specstatus, techpackoptions });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_SetUP_And_Activate_LSE_Linesheet")
	public static Iterator<Object[]> TC_SetUP_And_Activate_LSE_Linesheet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_FLA,
				linesheetview_LSUS, globalVaue, linesheetview_sizes, localhub, newSelectedSizesLH, affiliate,
				linesheetview_activation, currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode,
				lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, newSelectedSizesAFF, linesheetview_NRF,
				LSEStockingvalue, FirstMonthValue, Targetmsrpvalue, NRFclass, NRFcolor, NRFsizescale, primaryfabric;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC_SetUP_And_Activate_LSE_Linesheet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				linesheetview_sizes = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview_FLA = sheet.getRow(i).getCell(5).getStringCellValue();
				linesheetview_LSUS = sheet.getRow(i).getCell(6).getStringCellValue();
				linesheetview_activation = sheet.getRow(i).getCell(7).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(8).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(9).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(10).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(11).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(12).getStringCellValue();
				classification = sheet.getRow(i).getCell(13).getStringCellValue();
				producttype = sheet.getRow(i).getCell(14).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(15).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(16).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(17).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(18).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(19).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(20).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(21).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(22).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(23).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(24).getStringCellValue();
				createddate = sheet.getRow(i).getCell(25).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(26).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(27).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(28).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(29).getStringCellValue();
				capsule = sheet.getRow(i).getCell(30).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(31).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(32).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(33).getStringCellValue();
				localhub = sheet.getRow(i).getCell(34).getStringCellValue();
				newSelectedSizesLH = sheet.getRow(i).getCell(35).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(36).getStringCellValue();
				currentPlannedLifecycleAFF = sheet.getRow(i).getCell(37).getStringCellValue();
				firstOnFloorMonthAFF = sheet.getRow(i).getCell(38).getStringCellValue();
				dlvySelectedAFF = sheet.getRow(i).getCell(39).getStringCellValue();
				ticketCode = sheet.getRow(i).getCell(40).getStringCellValue();
				lsusStockingCSC = sheet.getRow(i).getCell(41).getStringCellValue();
				targetAFFMSRP = sheet.getRow(i).getCell(42).getStringCellValue();
				priceWhslAFF = sheet.getRow(i).getCell(43).getStringCellValue();
				bucketCodeAFF = sheet.getRow(i).getCell(44).getStringCellValue();
				newSelectedSizesAFF = sheet.getRow(i).getCell(45).getStringCellValue();
				linesheetview_NRF = sheet.getRow(i).getCell(46).getStringCellValue();
				LSEStockingvalue = sheet.getRow(i).getCell(47).getStringCellValue();
				FirstMonthValue = sheet.getRow(i).getCell(48).getStringCellValue();
				Targetmsrpvalue = sheet.getRow(i).getCell(49).getStringCellValue();
				NRFclass = sheet.getRow(i).getCell(50).getStringCellValue();
				NRFcolor = sheet.getRow(i).getCell(51).getStringCellValue();
				NRFsizescale = sheet.getRow(i).getCell(52).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(53).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_FLA,
						linesheetview_LSUS, globalVaue, linesheetview_sizes, localhub, newSelectedSizesLH, affiliate,
						linesheetview_activation, currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF,
						ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, newSelectedSizesAFF,
						linesheetview_NRF, LSEStockingvalue, FirstMonthValue, Targetmsrpvalue, NRFclass, NRFcolor,
						NRFsizescale, primaryfabric });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC_SetUp_And_Activate_APD_Linesheet")
	public static Iterator<Object[]> TC_SetUp_And_Activate_APD_Linesheet() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_APD,
				globalVaue, localhub, newSelectedSizesLH, affiliate, linesheetview_activation,
				currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF, targetAFFMSRP, priceWhslAFF,
				FirstMonthValue, Targetmsrpvalue, ProfitcenterAPD, primaryfabric;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC_SetUp_And_Activate_APD_Linesheet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				linesheetview_APD = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview_activation = sheet.getRow(i).getCell(5).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(6).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(7).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(8).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(9).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(10).getStringCellValue();
				classification = sheet.getRow(i).getCell(11).getStringCellValue();
				producttype = sheet.getRow(i).getCell(12).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(13).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(14).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(15).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(16).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(17).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(18).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(19).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(20).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(21).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(22).getStringCellValue();
				createddate = sheet.getRow(i).getCell(23).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(24).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(25).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(26).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(27).getStringCellValue();
				capsule = sheet.getRow(i).getCell(28).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(29).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(30).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(31).getStringCellValue();
				localhub = sheet.getRow(i).getCell(32).getStringCellValue();
				newSelectedSizesLH = sheet.getRow(i).getCell(33).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(34).getStringCellValue();
				currentPlannedLifecycleAFF = sheet.getRow(i).getCell(35).getStringCellValue();
				firstOnFloorMonthAFF = sheet.getRow(i).getCell(36).getStringCellValue();
				dlvySelectedAFF = sheet.getRow(i).getCell(37).getStringCellValue();
				targetAFFMSRP = sheet.getRow(i).getCell(38).getStringCellValue();
				priceWhslAFF = sheet.getRow(i).getCell(39).getStringCellValue();
				FirstMonthValue = sheet.getRow(i).getCell(40).getStringCellValue();
				Targetmsrpvalue = sheet.getRow(i).getCell(41).getStringCellValue();
				ProfitcenterAPD = sheet.getRow(i).getCell(42).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(43).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_APD, globalVaue,
						localhub, newSelectedSizesLH, affiliate, linesheetview_activation, currentPlannedLifecycleAFF,
						firstOnFloorMonthAFF, dlvySelectedAFF, targetAFFMSRP, priceWhslAFF, FirstMonthValue,
						Targetmsrpvalue, ProfitcenterAPD, primaryfabric });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P2_CustomLoaders_CreateLooks_usingLoaders")
	public static Iterator<Object[]> TC01_P2_CustomLoaders_CreateLooks_usingLoaders()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, lookname;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P2_CustomLoaders_CreateLooks_usingLoaders".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				lookname = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, lookname });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P3_UpdateColorway_AfterSetUpLSE")
	public static Iterator<Object[]> TC02_P3_UpdateColorway_AfterSetUpLSE() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC02_P3_UpdateColorway_AfterSetUpLSE".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, colorway, linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P3_CreateColorway_CheckLogEntry")
	public static Iterator<Object[]> TC03_P3_CreateColorway_CheckLogEntry() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric,
				LogEntryObject, event;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_P3_CreateColorway_CheckLogEntry".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(12).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(13).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(14).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(15).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(16).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(17).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(18).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(19).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(20).getStringCellValue();
				createddate = sheet.getRow(i).getCell(21).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(22).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(23).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(24).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(25).getStringCellValue();
				capsule = sheet.getRow(i).getCell(26).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(27).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(28).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(29).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(30).getStringCellValue();
				event = sheet.getRow(i).getCell(31).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric, LogEntryObject,
						event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC03_P3_CreateColorwaySeason_CheckLogEntry")
	public static Iterator<Object[]> TC03_P3_CreateColorwaySeason_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric,
				LogEntryObject, event;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC03_P3_CreateColorwaySeason_CheckLogEntry".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(12).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(13).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(14).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(15).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(16).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(17).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(18).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(19).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(20).getStringCellValue();
				createddate = sheet.getRow(i).getCell(21).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(22).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(23).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(24).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(25).getStringCellValue();
				capsule = sheet.getRow(i).getCell(26).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(27).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(28).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(29).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(30).getStringCellValue();
				event = sheet.getRow(i).getCell(31).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric, LogEntryObject,
						event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P3_CreateProduct_Colorway_SetUpLSE")
	public static Iterator<Object[]> TC17_P3_CreateProduct_Colorway_SetUpLSE()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue,
				productsegLSEvalue, classification, producttype, hubofferedto, linesheetview, consumergroup,
				consumergroupext1, consumergroupext2, materialtype, productmarketingname, rigidindicator,
				productlifecyclegroup, lastseasonoffered, productpricepositioning, createddate, filtermaterial,
				merchfabrictype, destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle,
				linesheetview_LSUS, primaryfabric;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P3_CreateProduct_Colorway_SetUpLSE".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(12).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(13).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(14).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(15).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(16).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(17).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(18).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(19).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(20).getStringCellValue();
				createddate = sheet.getRow(i).getCell(21).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(22).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(23).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(24).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(25).getStringCellValue();
				capsule = sheet.getRow(i).getCell(26).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(27).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(28).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(29).getStringCellValue();
				linesheetview_LSUS = sheet.getRow(i).getCell(30).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(31).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(32).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(33).getStringCellValue();
				classValue = sheet.getRow(i).getCell(34).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(35).getStringCellValue();
				consumer = sheet.getRow(i).getCell(36).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(37).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(38).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2, colormenu, colorsubmenu,
						filtercolor, productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, linesheetview_LSUS,
						primaryfabric, });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P3_ActivateColorway_LSE")
	public static Iterator<Object[]> TC02_P3_ActivateColorway_LSE() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, colorway, affiliate, linesheetview_activation, currentPlannedLifecycleAFF,
				firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF,
				bucketCodeAFF;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC02_P3_ActivateColorway_LSE".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				colorway = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview_activation = sheet.getRow(i).getCell(3).getStringCellValue();
				affiliate = sheet.getRow(i).getCell(4).getStringCellValue();
				currentPlannedLifecycleAFF = sheet.getRow(i).getCell(5).getStringCellValue();
				firstOnFloorMonthAFF = sheet.getRow(i).getCell(6).getStringCellValue();
				dlvySelectedAFF = sheet.getRow(i).getCell(7).getStringCellValue();
				ticketCode = sheet.getRow(i).getCell(8).getStringCellValue();
				lsusStockingCSC = sheet.getRow(i).getCell(9).getStringCellValue();
				targetAFFMSRP = sheet.getRow(i).getCell(10).getStringCellValue();
				priceWhslAFF = sheet.getRow(i).getCell(11).getStringCellValue();
				bucketCodeAFF = sheet.getRow(i).getCell(12).getStringCellValue();
				myData.add(new Object[] { TestType, season, colorway, affiliate, linesheetview_activation,
						currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF, ticketCode, lsusStockingCSC,
						targetAFFMSRP, priceWhslAFF, bucketCodeAFF });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_Staging_CreateColor_VerifyStagingId")
	public static Iterator<Object[]> TC01_P3_Staging_CreateColor_VerifyStagingId()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, redvalue, bluevalue, greenvalue, artworkname, colorfamily, artworkcode, patterntype,
				colorcombo, developer, colortype, businessObjectType, actionType, createdDate, messageTableValue,
				hierarchyValue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P3_Staging_CreateColor_VerifyStagingId".equalsIgnoreCase(TestType)) {
				redvalue = sheet.getRow(i).getCell(1).getStringCellValue();
				bluevalue = sheet.getRow(i).getCell(2).getStringCellValue();
				greenvalue = sheet.getRow(i).getCell(3).getStringCellValue();
				artworkname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorfamily = sheet.getRow(i).getCell(5).getStringCellValue();
				artworkcode = sheet.getRow(i).getCell(6).getStringCellValue();
				patterntype = sheet.getRow(i).getCell(7).getStringCellValue();
				colorcombo = sheet.getRow(i).getCell(8).getStringCellValue();
				developer = sheet.getRow(i).getCell(9).getStringCellValue();
				colortype = sheet.getRow(i).getCell(10).getStringCellValue();
				businessObjectType = sheet.getRow(i).getCell(11).getStringCellValue();
				actionType = sheet.getRow(i).getCell(12).getStringCellValue();
				createdDate = sheet.getRow(i).getCell(13).getStringCellValue();
				messageTableValue = sheet.getRow(i).getCell(14).getStringCellValue();
				hierarchyValue = sheet.getRow(i).getCell(15).getStringCellValue();

				myData.add(new Object[] { TestType, redvalue, bluevalue, greenvalue, artworkname, colorfamily,
						artworkcode, patterntype, colorcombo, developer, colortype, businessObjectType, actionType,
						createdDate, messageTableValue, hierarchyValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC19_P3_Staging_CreateColorway_VerifyStagingId")
	public static Iterator<Object[]> TC19_P3_Staging_CreateColorway_VerifyStagingId()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, consumergroup, consumergroupext1,
				consumergroupext2, materialtype, productmarketingname, rigidindicator, productlifecyclegroup,
				lastseasonoffered, productpricepositioning, createddate, filtermaterial, merchfabrictype,
				destroysampleInd, collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric,
				businessObjectType, actionType, messageTableValue, hierarchyValue;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC19_P3_Staging_CreateColorway_VerifyStagingId".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				consumergroup = sheet.getRow(i).getCell(12).getStringCellValue();
				consumergroupext1 = sheet.getRow(i).getCell(13).getStringCellValue();
				consumergroupext2 = sheet.getRow(i).getCell(14).getStringCellValue();
				materialtype = sheet.getRow(i).getCell(15).getStringCellValue();
				productmarketingname = sheet.getRow(i).getCell(16).getStringCellValue();
				rigidindicator = sheet.getRow(i).getCell(17).getStringCellValue();
				productlifecyclegroup = sheet.getRow(i).getCell(18).getStringCellValue();
				lastseasonoffered = sheet.getRow(i).getCell(19).getStringCellValue();
				productpricepositioning = sheet.getRow(i).getCell(20).getStringCellValue();
				createddate = sheet.getRow(i).getCell(21).getStringCellValue();
				filtermaterial = sheet.getRow(i).getCell(22).getStringCellValue();
				merchfabrictype = sheet.getRow(i).getCell(23).getStringCellValue();
				destroysampleInd = sheet.getRow(i).getCell(24).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(25).getStringCellValue();
				capsule = sheet.getRow(i).getCell(26).getStringCellValue();
				sizeGridCode = sheet.getRow(i).getCell(27).getStringCellValue();
				currentPlannedLifecycle = sheet.getRow(i).getCell(28).getStringCellValue();
				primaryfabric = sheet.getRow(i).getCell(29).getStringCellValue();
				businessObjectType = sheet.getRow(i).getCell(30).getStringCellValue();
				actionType = sheet.getRow(i).getCell(31).getStringCellValue();
				messageTableValue = sheet.getRow(i).getCell(32).getStringCellValue();
				hierarchyValue = sheet.getRow(i).getCell(33).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, merchfabrictype, destroysampleInd,
						collectionType, capsule, sizeGridCode, currentPlannedLifecycle, primaryfabric,
						businessObjectType, actionType, messageTableValue, hierarchyValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_CostwiseView_MassUpdate_CheckLogEntry")
	public static Iterator<Object[]> TC01_P3_CostwiseView_MassUpdate_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterdata, linesheetview, targetvolume, globalmsrp, createddate, LogEntryObject,
				event;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC01_P3_CostwiseView_MassUpdate_CheckLogEntry".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterdata = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				targetvolume = sheet.getRow(i).getCell(4).getStringCellValue();
				globalmsrp = sheet.getRow(i).getCell(5).getStringCellValue();
				createddate = sheet.getRow(i).getCell(6).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(7).getStringCellValue();
				event = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterdata, linesheetview, targetvolume, globalmsrp,
						createddate, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC04_P3_Costwise_Massupdate_PDS_CheckLogEntry")
	public static Iterator<Object[]> TC04_P3_Costwise_Massupdate_PDS_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterdata, linesheetview, targetvolume, globalmsrp, createddate, LogEntryObject,
				event;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC04_P3_Costwise_Massupdate_PDS_CheckLogEntry".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterdata = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				targetvolume = sheet.getRow(i).getCell(4).getStringCellValue();
				globalmsrp = sheet.getRow(i).getCell(5).getStringCellValue();
				createddate = sheet.getRow(i).getCell(6).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(7).getStringCellValue();
				event = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterdata, linesheetview, targetvolume, globalmsrp,
						createddate, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC06_P3_SKUSourcing_update_CheckLogEntry")
	public static Iterator<Object[]> TC06_P3_SKUSourcing_update_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterdata, linesheetview, vendor, createddate, LogEntryObject, event;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC06_P3_SKUSourcing_update_CheckLogEntry".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterdata = sheet.getRow(i).getCell(2).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(3).getStringCellValue();
				vendor = sheet.getRow(i).getCell(4).getStringCellValue();
				createddate = sheet.getRow(i).getCell(5).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(6).getStringCellValue();
				event = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, filterdata, linesheetview, vendor, createddate,
						LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC07_P3_TargetFOBLoadersFile_CheckLogEntry")
	public static Iterator<Object[]> TC07_P3_TargetFOBLoadersFile_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, colorway, targetFOB,
				createddate, LogEntryObject, event;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC07_P3_TargetFOBLoadersFile_CheckLogEntry".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();
				targetFOB = sheet.getRow(i).getCell(7).getStringCellValue();
				createddate = sheet.getRow(i).getCell(8).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(9).getStringCellValue();
				event = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview,
						colorway, targetFOB, createddate, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_SeasonCreation_CheckLogEntry")
	public static Iterator<Object[]> TC01_P3_SeasonCreation_CheckLogEntry() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonType, productType, Category, Gender, Brand, Year, season, seasonCode, createddate,
				LogEntryObject, event;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P3_SeasonCreation_CheckLogEntry".equalsIgnoreCase(TestType)) {
				seasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				productType = sheet.getRow(i).getCell(2).getStringCellValue();
				Category = sheet.getRow(i).getCell(3).getStringCellValue();
				Gender = sheet.getRow(i).getCell(4).getStringCellValue();
				Brand = sheet.getRow(i).getCell(5).getStringCellValue();
				Year = sheet.getRow(i).getCell(6).getStringCellValue();
				season = sheet.getRow(i).getCell(7).getStringCellValue();
				seasonCode = sheet.getRow(i).getCell(8).getStringCellValue();
				createddate = sheet.getRow(i).getCell(9).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(10).getStringCellValue();
				event = sheet.getRow(i).getCell(11).getStringCellValue();
				myData.add(new Object[] { TestType, seasonType, productType, Category, Gender, Brand, Year, season,
						seasonCode, createddate, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@DataProvider(name = "TC135_P2_CreateColorRecordsforSundriesButton")
	public static Iterator<Object[]> TC135_P2_CreateColorRecordsforSundriesButton()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, actionValue, colorType, colorName, lSAndCo_ColorName, colorFamily, colorStatus,
				seasonFirstIntroduced, imagePath;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC135_P2_CreateColorRecordsforSundriesButton".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				actionValue = sheet.getRow(i).getCell(2).getStringCellValue();
				colorType = sheet.getRow(i).getCell(3).getStringCellValue();
				colorName = sheet.getRow(i).getCell(4).getStringCellValue();
				lSAndCo_ColorName = sheet.getRow(i).getCell(5).getStringCellValue();
				colorFamily = sheet.getRow(i).getCell(6).getStringCellValue();
				colorStatus = sheet.getRow(i).getCell(7).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(8).getStringCellValue();
				imagePath = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, season, actionValue, colorType, colorName, lSAndCo_ColorName,
						colorFamily, colorStatus, seasonFirstIntroduced, imagePath });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC147_P2_AssociateColorsToSundryRecords")
	public static Iterator<Object[]> TC147_P2_AssociateColorsToSundryRecords()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplierName, colorItem;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC147_P2_AssociateColorsToSundryRecords".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplierName = sheet.getRow(i).getCell(3).getStringCellValue();
				colorItem = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, materialType, materialName, supplierName, colorItem });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC154_P2_ArchiveField_Access_for_Grade_Rule_Template")
	public static Iterator<Object[]> TC154_P2_ArchiveField_Access_for_Grade_Rule_Template()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, template, gradeRuleTempName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC154_P2_ArchiveField_Access_for_Grade_Rule_Template".equalsIgnoreCase(TestType)) {
				template = sheet.getRow(i).getCell(1).getStringCellValue();
				gradeRuleTempName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, template, gradeRuleTempName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC157_P2_ArchiveField_Access_for_Measurements_Template")
	public static Iterator<Object[]> TC157_P2_ArchiveField_Access_for_Measurements_Template()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, template, measurementTempName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC157_P2_ArchiveField_Access_for_Measurements_Template".equalsIgnoreCase(TestType)) {
				template = sheet.getRow(i).getCell(1).getStringCellValue();
				measurementTempName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, template, measurementTempName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC161_P2_Viewing_the_Measurement_Set_Table_Display")
	public static Iterator<Object[]> TC161_P2_Viewing_the_Measurement_Set_Table_Display()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specification;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC161_P2_Viewing_the_Measurement_Set_Table_Display".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specification });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC162_Viewing_Attributes_of_Prod_Measurement_Sets")
	public static Iterator<Object[]> TC162_Viewing_Attributes_of_Prod_Measurement_Sets()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specification;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC162_Viewing_Attributes_of_Prod_Measurement_Sets".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specification });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC167_P2_InsertingPointsOfMeasure")
	public static Iterator<Object[]> TC167_P2_InsertingPointsOfMeasure() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specification, pomDescription;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC167_P2_InsertingPointsOfMeasure".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();
				pomDescription = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specification, pomDescription });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC173_P2_Add_size_based_on_set_values_from_Grade_Table")
	public static Iterator<Object[]> TC173_P2_Add_size_based_on_set_values_from_Grade_Table()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specification, measurementSet, newSize;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC173_P2_Add_size_based_on_set_values_from_Grade_Table".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specification = sheet.getRow(i).getCell(3).getStringCellValue();
				measurementSet = sheet.getRow(i).getCell(4).getStringCellValue();
				newSize = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specification, measurementSet, newSize });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC194_P2_Validate_PDC_Value_For_Product")
	public static Iterator<Object[]> TC194_P2_Validate_PDC_Value_For_Product()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC194_P2_Validate_PDC_Value_For_Product".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC196_P2_VerifyPC5CodeCreationForProduct")
	public static Iterator<Object[]> TC196_P2_VerifyPC5CodeCreationForProduct()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC196_P2_VerifyPC5CodeCreationForProduct".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables")
	public static Iterator<Object[]> TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, businessObject;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables".equalsIgnoreCase(TestType)) {
				businessObject = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, businessObject });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC218_P2_Update_Product_to_Non_Required_Attributes")
	public static Iterator<Object[]> TC218_P2_Update_Product_to_Non_Required_Attributes()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, includeMerchFabricTypeinCWName, codeType, productType,
				productReportCharacteristics, dimensions, typeOfClosure, fitReference, capacity;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC218_P2_Update_Product_to_Non_Required_Attributes".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				includeMerchFabricTypeinCWName = sheet.getRow(i).getCell(3).getStringCellValue();
				codeType = sheet.getRow(i).getCell(4).getStringCellValue();
				productType = sheet.getRow(i).getCell(5).getStringCellValue();
				productReportCharacteristics = sheet.getRow(i).getCell(6).getStringCellValue();
				dimensions = sheet.getRow(i).getCell(7).getStringCellValue();
				typeOfClosure = sheet.getRow(i).getCell(8).getStringCellValue();
				fitReference = sheet.getRow(i).getCell(9).getStringCellValue();
				capacity = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, includeMerchFabricTypeinCWName, codeType,
						productType, productReportCharacteristics, dimensions, typeOfClosure, fitReference, capacity });
			}
		}
		return myData.iterator();
	}

	/////////////////////////////////////////////////////////////////////////////

	@DataProvider(name = "TC221_P2_Create_Levis_LSE_Affiliate_Season_Collection")
	public static Iterator<Object[]> TC221_P2_Create_Levis_LSE_Affiliate_Season_Collection()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonCollectionName, collectionId, collectionDesc, seasonDesc, bookBeginDate, bookEndDate,
				shipBeginDate, shipEndDate, theme, themeDesc, affiliateAdoptGroup, collectionType, brand, year, season;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC221_P2_Create_Levis_LSE_Affiliate_Season_Collection".equalsIgnoreCase(TestType)) {
				seasonCollectionName = sheet.getRow(i).getCell(1).getStringCellValue();
				collectionId = sheet.getRow(i).getCell(2).getStringCellValue();
				collectionDesc = sheet.getRow(i).getCell(3).getStringCellValue();
				seasonDesc = sheet.getRow(i).getCell(4).getStringCellValue();
				bookBeginDate = sheet.getRow(i).getCell(5).getStringCellValue();
				bookEndDate = sheet.getRow(i).getCell(6).getStringCellValue();
				shipBeginDate = sheet.getRow(i).getCell(7).getStringCellValue();
				shipEndDate = sheet.getRow(i).getCell(8).getStringCellValue();
				theme = sheet.getRow(i).getCell(9).getStringCellValue();
				themeDesc = sheet.getRow(i).getCell(10).getStringCellValue();
				affiliateAdoptGroup = sheet.getRow(i).getCell(11).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(12).getStringCellValue();
				brand = sheet.getRow(i).getCell(13).getStringCellValue();
				year = sheet.getRow(i).getCell(14).getStringCellValue();
				season = sheet.getRow(i).getCell(15).getStringCellValue();

				myData.add(new Object[] { TestType, seasonCollectionName, collectionId, collectionDesc, seasonDesc,
						bookBeginDate, bookEndDate, shipBeginDate, shipEndDate, theme, themeDesc, affiliateAdoptGroup,
						collectionType, brand, year, season });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC223_P2_Create_Levis_NON_LSE_Affiliate_Season_Collection")
	public static Iterator<Object[]> TC223_P2_Create_Levis_NON_LSE_Affiliate_Season_Collection()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, seasonCollectionName, collectionId, collectionDesc, seasonDesc, bookBeginDate, bookEndDate,
				shipBeginDate, shipEndDate, theme, themeDesc, affiliateAdoptGroup, collectionType, brand, year, season;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC223_P2_Create_Levis_NON_LSE_Affiliate_Season_Collection".equalsIgnoreCase(TestType)) {
				seasonCollectionName = sheet.getRow(i).getCell(1).getStringCellValue();
				collectionId = sheet.getRow(i).getCell(2).getStringCellValue();
				collectionDesc = sheet.getRow(i).getCell(3).getStringCellValue();
				seasonDesc = sheet.getRow(i).getCell(4).getStringCellValue();
				bookBeginDate = sheet.getRow(i).getCell(5).getStringCellValue();
				bookEndDate = sheet.getRow(i).getCell(6).getStringCellValue();
				shipBeginDate = sheet.getRow(i).getCell(7).getStringCellValue();
				shipEndDate = sheet.getRow(i).getCell(8).getStringCellValue();
				theme = sheet.getRow(i).getCell(9).getStringCellValue();
				themeDesc = sheet.getRow(i).getCell(10).getStringCellValue();
				affiliateAdoptGroup = sheet.getRow(i).getCell(11).getStringCellValue();
				collectionType = sheet.getRow(i).getCell(12).getStringCellValue();
				brand = sheet.getRow(i).getCell(13).getStringCellValue();
				year = sheet.getRow(i).getCell(14).getStringCellValue();
				season = sheet.getRow(i).getCell(15).getStringCellValue();

				myData.add(new Object[] { TestType, seasonCollectionName, collectionId, collectionDesc, seasonDesc,
						bookBeginDate, bookEndDate, shipBeginDate, shipEndDate, theme, themeDesc, affiliateAdoptGroup,
						collectionType, brand, year, season });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC225_P2_ReplaceSizeGridOfPC9_PriorToSetup")
	public static Iterator<Object[]> TC225_P2_ReplaceSizeGridOfPC9_PriorToSetup()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName, globalVaue, localHubValue, affiliateValue, newSizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC225_P2_ReplaceSizeGridOfPC9_PriorToSetup".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();
				newSizeGridCode = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName, globalVaue, localHubValue,
						affiliateValue, newSizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC233_P2_ReplaceSizeGridOfPC9_PostSetup")
	public static Iterator<Object[]> TC233_P2_ReplaceSizeGridOfPC9_PostSetup()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName, globalVaue, localHubValue, affiliateValue, newSizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC233_P2_ReplaceSizeGridOfPC9_PostSetup".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();
				newSizeGridCode = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName, globalVaue, localHubValue,
						affiliateValue, newSizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC239_P2_ReplaceSizeGridOfPC9_PostActivation")
	public static Iterator<Object[]> TC239_P2_ReplaceSizeGridOfPC9_PostActivation()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName, globalVaue, localHubValue, affiliateValue, newSizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC239_P2_ReplaceSizeGridOfPC9_PostActivation".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();
				newSizeGridCode = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName, globalVaue, localHubValue,
						affiliateValue, newSizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC252_P2_ReplaceSizeGridWithCorrectCSsize_PriorToSetup")
	public static Iterator<Object[]> TC252_P2_ReplaceSizeGridWithCorrectCSsize_PriorToSetup()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName, globalVaue, localHubValue, affiliateValue, newSizeGridCode;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC252_P2_ReplaceSizeGridWithCorrectCSsize_PriorToSetup".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();
				newSizeGridCode = sheet.getRow(i).getCell(7).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName, globalVaue, localHubValue,
						affiliateValue, newSizeGridCode });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC253_P2_AssociateSourceToProduct")
	public static Iterator<Object[]> TC253_P2_AssociateSourceToProduct() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, vendor;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC253_P2_AssociateSourceToProduct".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				vendor = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, vendor });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC256_P2_AssociateMultipleSourcesToProduct")
	public static Iterator<Object[]> TC256_P2_AssociateMultipleSourcesToProduct()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName;
		String[] vendors;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC256_P2_AssociateMultipleSourcesToProduct".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				vendors = sheet.getRow(i).getCell(3).getStringCellValue().split(";");

				myData.add(new Object[] { TestType, season, productName, vendors });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC260_P2_RemoveSourceToColorwayAssociationFromLinesheet")
	public static Iterator<Object[]> TC260_P2_RemoveSourceToColorwayAssociationFromLinesheet()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC260_P2_RemoveSourceToColorwayAssociationFromLinesheet".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC264_P2_RemoveSourcefromSeason")
	public static Iterator<Object[]> TC264_P2_RemoveSourcefromSeason() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, sourceName, viewType1;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC264_P2_RemoveSourcefromSeason".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();
				viewType1 = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, sourceName, viewType1 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC266_P2_AssociateColorwayWithRemovedSource")
	public static Iterator<Object[]> TC266_P2_AssociateColorwayWithRemovedSource()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, sourceName, viewType1, viewType2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC266_P2_AssociateColorwayWithRemovedSource".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();
				viewType1 = sheet.getRow(i).getCell(4).getStringCellValue();
				viewType2 = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, sourceName, viewType1, viewType2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC270_P2_CheckColorwayVariationOption_componentMeasurementPage")
	public static Iterator<Object[]> TC270_P2_CheckColorwayVariationOption_componentMeasurementPage()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, sourceName, specification, measurementTemplateName, measurementsetname,
				sizes, measurementType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC270_P2_CheckColorwayVariationOption_componentMeasurementPage".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();
				specification = sheet.getRow(i).getCell(4).getStringCellValue();
				measurementTemplateName = sheet.getRow(i).getCell(5).getStringCellValue();
				measurementsetname = sheet.getRow(i).getCell(6).getStringCellValue();
				sizes = sheet.getRow(i).getCell(7).getStringCellValue();
				measurementType = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, sourceName, specification,
						measurementTemplateName, measurementsetname, sizes, measurementType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC274_P2_CheckColorwayVariationOption_componentsImagePage")
	public static Iterator<Object[]> TC274_P2_CheckColorwayVariationOption_componentsImagePage()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, sourceName, specification, pagetype, pagedescription, pagelayout,
				imagePath;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC274_P2_CheckColorwayVariationOption_componentsImagePage".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();
				specification = sheet.getRow(i).getCell(4).getStringCellValue();
				pagetype = sheet.getRow(i).getCell(5).getStringCellValue();
				pagedescription = sheet.getRow(i).getCell(6).getStringCellValue();
				pagelayout = sheet.getRow(i).getCell(7).getStringCellValue();
				imagePath = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, sourceName, specification, pagetype,
						pagedescription, pagelayout, imagePath });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC277_P2_RemoveComponentFromProductAndColorwaySections")
	public static Iterator<Object[]> TC277_P2_RemoveComponentFromProductAndColorwaySections()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC277_P2_RemoveComponentFromProductAndColorwaySections".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC278_P2_AppendComponentToComponentsProductList")
	public static Iterator<Object[]> TC278_P2_AppendComponentToComponentsProductList()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName, NewComponent;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC278_P2_AppendComponentToComponentsProductList".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				NewComponent = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, colorWayName, NewComponent });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC289_P2_Create_Source_For_Duplicate_Vendor")
	public static Iterator<Object[]> TC289_P2_Create_Source_For_Duplicate_Vendor()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, vendor;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC289_P2_Create_Source_For_Duplicate_Vendor".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				vendor = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, vendor });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC282_P2_VerifyAttributesOnCreationOfNonPrimarySrcAndSpec")
	public static Iterator<Object[]> TC282_P2_VerifyAttributesOnCreationOfNonPrimarySrcAndSpec()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, vendor;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC282_P2_VerifyAttributesOnCreationOfNonPrimarySrcAndSpec".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				vendor = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, vendor });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC296_P2_VendorUpdateReflectsInAllSpecifications")
	public static Iterator<Object[]> TC296_P2_VendorUpdateReflectsInAllSpecifications()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, sourceName, newVendor;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC296_P2_VendorUpdateReflectsInAllSpecifications".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				sourceName = sheet.getRow(i).getCell(3).getStringCellValue();
				newVendor = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, sourceName, newVendor });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC302_P2_VerifyTechPackAndAddComponentsOptions")
	public static Iterator<Object[]> TC302_P2_VerifyTechPackAndAddComponentsOptions()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, specificationName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC302_P2_VerifyTechPackAndAddComponentsOptions".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				specificationName = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, specificationName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC257_P2_AssociateColorwaySource_sourceAlreadyAssociatedToPC5")
	public static Iterator<Object[]> TC257_P2_AssociateColorwaySource_sourceAlreadyAssociatedToPC5()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, colorWayName;
		List<String> vendorNames;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC257_P2_AssociateColorwaySource_sourceAlreadyAssociatedToPC5".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				vendorNames = Arrays.asList(sheet.getRow(i).getCell(4).getStringCellValue().split(";"));

				myData.add(new Object[] { TestType, season, viewType, colorWayName, vendorNames });
			}
		}
		return myData.iterator();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	@DataProvider(name = "TC319_P2_VendorPortalAccessAndUpdate_DocumentsCreatedByVendor")
	public static Iterator<Object[]> TC319_P2_VendorPortalAccessAndUpdate_DocumentsCreatedByVendor()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, documentType, vendorDOCName, newVendorName, newDescription, newDocumentType, newLSCoDeveloper;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC319_P2_VendorPortalAccessAndUpdate_DocumentsCreatedByVendor".equalsIgnoreCase(TestType)) {
				documentType = sheet.getRow(i).getCell(1).getStringCellValue();
				vendorDOCName = sheet.getRow(i).getCell(2).getStringCellValue();
				newVendorName = sheet.getRow(i).getCell(3).getStringCellValue();
				newDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				newDocumentType = sheet.getRow(i).getCell(5).getStringCellValue();
				newLSCoDeveloper = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, documentType, vendorDOCName, newVendorName, newDescription,
						newDocumentType, newLSCoDeveloper });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC322_P2_VendorPortalAccess_DocumentSubTypeImagesVendorImages")
	public static Iterator<Object[]> TC322_P2_VendorPortalAccess_DocumentSubTypeImagesVendorImages()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, documentType, vendorDOCName, newVendorName, newImgLayout, newImgDescription, newImgType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC322_P2_VendorPortalAccess_DocumentSubTypeImagesVendorImages".equalsIgnoreCase(TestType)) {
				documentType = sheet.getRow(i).getCell(1).getStringCellValue();
				vendorDOCName = sheet.getRow(i).getCell(2).getStringCellValue();
				newVendorName = sheet.getRow(i).getCell(3).getStringCellValue();
				newImgLayout = sheet.getRow(i).getCell(4).getStringCellValue();
				newImgDescription = sheet.getRow(i).getCell(5).getStringCellValue();
				newImgType = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, documentType, vendorDOCName, newVendorName, newImgLayout,
						newImgDescription, newImgType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC323_P2_VendorPortalAccess_MaterialColorDevelopmentSamples")
	public static Iterator<Object[]> TC323_P2_VendorPortalAccess_MaterialColorDevelopmentSamples()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sampleType, name, airwayBill, shippedDate, vendorComments, requestName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC323_P2_VendorPortalAccess_MaterialColorDevelopmentSamples".equalsIgnoreCase(TestType)) {
				sampleType = sheet.getRow(i).getCell(1).getStringCellValue();
				name = sheet.getRow(i).getCell(2).getStringCellValue();
				airwayBill = sheet.getRow(i).getCell(3).getStringCellValue();
				shippedDate = sheet.getRow(i).getCell(4).getStringCellValue();
				vendorComments = sheet.getRow(i).getCell(5).getStringCellValue();
				requestName = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, sampleType, name, airwayBill, shippedDate, vendorComments,
						requestName });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC327_P2_VendorPortal_UpdateMaterialColorDevelopmentSamples")
	public static Iterator<Object[]> TC327_P2_VendorPortal_UpdateMaterialColorDevelopmentSamples()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sampleType, airwayBill, shippedDate, vendorComments;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC327_P2_VendorPortal_UpdateMaterialColorDevelopmentSamples".equalsIgnoreCase(TestType)) {
				sampleType = sheet.getRow(i).getCell(1).getStringCellValue();
				airwayBill = sheet.getRow(i).getCell(2).getStringCellValue();
				shippedDate = sheet.getRow(i).getCell(3).getStringCellValue();
				vendorComments = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, sampleType, airwayBill, shippedDate, vendorComments });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC329_P2_VendorPortalAccessToSamplesProductFit")
	public static Iterator<Object[]> TC329_P2_VendorPortalAccessToSamplesProductFit()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, sampleType;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC329_P2_VendorPortalAccessToSamplesProductFit".equalsIgnoreCase(TestType)) {
				sampleType = sheet.getRow(i).getCell(1).getStringCellValue();

				myData.add(new Object[] { TestType, sampleType });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC330_P2_VendorPortalOnlyViewAccessToTechpackgenerationPage")
	public static Iterator<Object[]> TC330_P2_VendorPortalOnlyViewAccessToTechpackgenerationPage()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P2");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, colourWayName, specificationName;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC330_P2_VendorPortalOnlyViewAccessToTechpackgenerationPage".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				colourWayName = sheet.getRow(i).getCell(3).getStringCellValue();
				specificationName = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, colourWayName, specificationName });
			}
		}
		return myData.iterator();
	}
	///////////// p3//////////////////

	@DataProvider(name = "TC01_P3_CreateMaterial_CheckLogEntry")
	public static Iterator<Object[]> TC01_P3_CreateMaterial_CheckLogEntry() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription, uom, LogEntryObject, event;
		Map<String, String> fabricContents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P3_CreateFabricTypeMaterial_CheckLogEntry".equalsIgnoreCase(TestType)) {
				typeOfFabric = sheet.getRow(i).getCell(1).getStringCellValue();
				fabricType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				fabricDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				uom = sheet.getRow(i).getCell(5).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(6).getStringCellValue();
				event = sheet.getRow(i).getCell(7).getStringCellValue();
				for (int j = 8; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					fabricContents.put(contentType, percentage);
				}
				myData.add(new Object[] { TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription,
						uom, LogEntryObject, event, fabricContents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_CreateProduct_CheckLogEntry")
	public static Iterator<Object[]> TC01_P3_CreateProduct_CheckLogEntry() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2, LogEntryObject, event;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P3_CreateProduct_CheckLogEntry".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(11).getStringCellValue();
				event = sheet.getRow(i).getCell(12).getStringCellValue();
				myData.add(new Object[] { TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "CreateProduct_CheckLogEntry")
	public static Object[][] Create_Product_CheckLogEntry() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P4");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[11];
			for (int j = 0; j < 11; j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC02_P3_CreateMaterialSupplier_CheckLogEntry")
	public static Iterator<Object[]> TC02_P3_CreateMaterialSupplier_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, materialType, materialName, supplier, LogEntryObject, event;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC02_P3_CreateMaterialSupplier_CheckLogEntry".equalsIgnoreCase(TestType)) {
				materialType = sheet.getRow(i).getCell(1).getStringCellValue();
				materialName = sheet.getRow(i).getCell(2).getStringCellValue();
				supplier = sheet.getRow(i).getCell(3).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(4).getStringCellValue();
				event = sheet.getRow(i).getCell(5).getStringCellValue();
				myData.add(new Object[] { TestType, materialType, materialName, supplier, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_UpdateSeasonGroupColorway_CheckLogEntry")
	public static Iterator<Object[]> TC01_P3_UpdateSeasonGroupColorway_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, mySeasonType, viewType, colorwayName, globalVaue, localHubValue, affiliateValue,
				LogEntryObject, event;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P3_UpdateSeasonGroupColorway_CheckLogEntry".equalsIgnoreCase(TestType)) {
				mySeasonType = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				colorwayName = sheet.getRow(i).getCell(3).getStringCellValue();
				globalVaue = sheet.getRow(i).getCell(4).getStringCellValue();
				localHubValue = sheet.getRow(i).getCell(5).getStringCellValue();
				affiliateValue = sheet.getRow(i).getCell(6).getStringCellValue();
				LogEntryObject = sheet.getRow(i).getCell(7).getStringCellValue();
				event = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, mySeasonType, viewType, colorwayName, globalVaue, localHubValue,
						affiliateValue, LogEntryObject, event });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC12_P3_Integration_Staging_CreateMaterial")
	public static Iterator<Object[]> TC12_P3_Integration_Staging_CreateMaterial()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription, uom, businessObjectType,
				actionType, messageTableValue, hierarchyValue;
		Map<String, String> fabricContents = new HashMap<>();

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC12_P3_Staging_CreateFabricTypeMaterial_VerifyStagingID".equalsIgnoreCase(TestType)) {
				typeOfFabric = sheet.getRow(i).getCell(1).getStringCellValue();
				fabricType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonFirstIntroduced = sheet.getRow(i).getCell(3).getStringCellValue();
				fabricDescription = sheet.getRow(i).getCell(4).getStringCellValue();
				uom = sheet.getRow(i).getCell(5).getStringCellValue();
				businessObjectType = sheet.getRow(i).getCell(6).getStringCellValue();
				actionType = sheet.getRow(i).getCell(7).getStringCellValue();
				messageTableValue = sheet.getRow(i).getCell(8).getStringCellValue();
				hierarchyValue = sheet.getRow(i).getCell(9).getStringCellValue();
				for (int j = 10; j < sheet.getRow(i).getLastCellNum(); j += 2) {
					String contentType = sheet.getRow(i).getCell(j).getStringCellValue();
					String percentage = sheet.getRow(i).getCell(j + 1).getStringCellValue();
					fabricContents.put(contentType, percentage);
				}
				myData.add(new Object[] { TestType, typeOfFabric, fabricType, seasonFirstIntroduced, fabricDescription,
						uom, businessObjectType, actionType, messageTableValue, hierarchyValue, fabricContents });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC18_P3_Integration_Staging_CreateProduct")
	public static Iterator<Object[]> TC18_P3_Integration_Staging_CreateProduct()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2, businessObjectType, actionType, messageTableValue, hierarchyValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC18_P3_Staging_CreateProduct_VerifyStagingID".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();
				businessObjectType = sheet.getRow(i).getCell(11).getStringCellValue();
				actionType = sheet.getRow(i).getCell(12).getStringCellValue();
				messageTableValue = sheet.getRow(i).getCell(13).getStringCellValue();
				hierarchyValue = sheet.getRow(i).getCell(14).getStringCellValue();
				myData.add(new Object[] { TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2, businessObjectType, actionType,
						messageTableValue, hierarchyValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC20_P3_Intigration_Staging_CreateSeasonGroupToSKULink")
	public static Iterator<Object[]> TC20_P3_Intigration_Staging_CreateSeasonGroupToSKULink()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, viewType, seasonGroupName, colorwayName, businessObjectType, actionType,
				messageTableValue, hierarchyValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC20_P3_Staging_CreateSeasonGroupToSKULink".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				viewType = sheet.getRow(i).getCell(2).getStringCellValue();
				seasonGroupName = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwayName = sheet.getRow(i).getCell(4).getStringCellValue();
				businessObjectType = sheet.getRow(i).getCell(5).getStringCellValue();
				actionType = sheet.getRow(i).getCell(6).getStringCellValue();
				messageTableValue = sheet.getRow(i).getCell(7).getStringCellValue();
				hierarchyValue = sheet.getRow(i).getCell(8).getStringCellValue();

				myData.add(new Object[] { TestType, season, viewType, seasonGroupName, colorwayName, businessObjectType,
						actionType, messageTableValue, hierarchyValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_CreateMaleProduct_ValidateUniqueProductCode")
	public static Iterator<Object[]> TC01_P3_CreateMaleProduct_ValidateUniqueProductCode()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P3_CreateMaleProduct_ValidateUniqueProductCode".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC02_P3_CreateFemaleProduct_ValidateUniqueProductCode")
	public static Iterator<Object[]> TC02_P3_CreateFemaleProduct_ValidateUniqueProductCode()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2, classValue, subClassValue,
				consumer, consumerGrp1, consumerGrp2;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC02_P3_CreateFemaleProduct_ValidateUniqueProductCode".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				productName = sheet.getRow(i).getCell(2).getStringCellValue();
				brandHierarchy = sheet.getRow(i).getCell(3).getStringCellValue();
				proSubCat1 = sheet.getRow(i).getCell(4).getStringCellValue();
				proSubCat2 = sheet.getRow(i).getCell(5).getStringCellValue();
				classValue = sheet.getRow(i).getCell(6).getStringCellValue();
				subClassValue = sheet.getRow(i).getCell(7).getStringCellValue();
				consumer = sheet.getRow(i).getCell(8).getStringCellValue();
				consumerGrp1 = sheet.getRow(i).getCell(9).getStringCellValue();
				consumerGrp2 = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, season, productName, brandHierarchy, proSubCat1, proSubCat2,
						classValue, subClassValue, consumer, consumerGrp1, consumerGrp2 });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC01_P3_Check_MeasurementType")
	public static Iterator<Object[]> TC01_P3_Check_MeasurementType() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, product, season, source, specification, measurementSet;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC01_P3_Check_MeasurementType".equalsIgnoreCase(TestType)) {
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				source = sheet.getRow(i).getCell(3).getStringCellValue();
				specification = sheet.getRow(i).getCell(4).getStringCellValue();
				measurementSet = sheet.getRow(i).getCell(5).getStringCellValue();

				myData.add(new Object[] { TestType, product, season, source, specification, measurementSet });
			}
		}
		return myData.iterator();
	}

	///////////////////////////////////////////////////////

	@DataProvider(name = "TC29_P3_BomAPP_Search_UsingAllAttributes")
	public static Iterator<Object[]> TC29_P3_BomAPP_Search_UsingAllAttributes()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		String TestType, username, password, season, colorwaycode, productcode, Merchant, material, available,
				carryover;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC29_P3_BomAPP_Search_UsingAllAttributes".equalsIgnoreCase(TestType)) {
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();
				season = sheet.getRow(i).getCell(3).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(4).getStringCellValue();
				productcode = sheet.getRow(i).getCell(5).getStringCellValue();
				Merchant = sheet.getRow(i).getCell(6).getStringCellValue();
				material = sheet.getRow(i).getCell(7).getStringCellValue();
				available = sheet.getRow(i).getCell(8).getStringCellValue();
				carryover = sheet.getRow(i).getCell(9).getStringCellValue();

				myData.add(new Object[] { TestType, username, password, season, colorwaycode, productcode, Merchant,
						material, available, carryover });
			}
		}
		return myData.iterator();
	}

	//// P3__AA____

	@DataProvider(name = "TC12_P3_CreatePC9ForFemaleAcc_CheckPC9Code")
	public static Iterator<Object[]> TC12_P3_CreatePC9ForFemaleAcc_CheckPC9Code()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();

		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC12_P3_CreatePC9ForFemaleAcc_CheckPC9Code".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC13_P3_CreatePC9ForMaleAcc_CheckPC9Code")
	public static Iterator<Object[]> TC13_P3_CreatePC9ForMaleAcc_CheckPC9Code()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC13_P3_CreatePC9ForMaleAcc_CheckPC9Code".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC11_TD_VerifyCodeSequencePC9")
	public static Iterator<Object[]> TC11_TD_VerifyCodeSequencePC9() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, product, colormenu, colorsubmenu, filtercolor, productsegLSUSvalue, productsegLSEvalue,
				classification, producttype, hubofferedto, linesheetview, filtercolor2;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC11_P3_VerifyCodeSequencePC9".equalsIgnoreCase(TestType)) {

				season = sheet.getRow(i).getCell(1).getStringCellValue();
				product = sheet.getRow(i).getCell(2).getStringCellValue();
				colormenu = sheet.getRow(i).getCell(3).getStringCellValue();
				colorsubmenu = sheet.getRow(i).getCell(4).getStringCellValue();
				filtercolor = sheet.getRow(i).getCell(5).getStringCellValue();
				productsegLSUSvalue = sheet.getRow(i).getCell(6).getStringCellValue();
				productsegLSEvalue = sheet.getRow(i).getCell(7).getStringCellValue();
				classification = sheet.getRow(i).getCell(8).getStringCellValue();
				producttype = sheet.getRow(i).getCell(9).getStringCellValue();
				hubofferedto = sheet.getRow(i).getCell(10).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(11).getStringCellValue();
				filtercolor2 = sheet.getRow(i).getCell(12).getStringCellValue();

				myData.add(new Object[] { TestType, season, product, colormenu, colorsubmenu, filtercolor,
						productsegLSUSvalue, productsegLSEvalue, classification, producttype, hubofferedto,
						linesheetview, filtercolor2 });
			}
		}
		return myData.iterator();
	}

	////////////////////////////////////////////// P2__AANAD__

//	Data Provider for India Kids
	@DataProvider(name = "TC010_P2_VerifyFilters_IndiaKids")
	public static Iterator<Object[]> TC010_P2_VerifyFilters_IndiaKids() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, productname, colorwayname, colorwaycode, productcode,
				linesheetview, carryover, available, consumerGroup1, productdevcenter;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC010_P2_VerifyFilters_IndiaKids".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				filterValue = sheet.getRow(i).getCell(2).getStringCellValue();
				expectedAttributes = sheet.getRow(i).getCell(3).getStringCellValue();
				productname = sheet.getRow(i).getCell(4).getStringCellValue();
				colorwayname = sheet.getRow(i).getCell(5).getStringCellValue();
				colorwaycode = sheet.getRow(i).getCell(6).getStringCellValue();
				productcode = sheet.getRow(i).getCell(7).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(8).getStringCellValue();
				carryover = sheet.getRow(i).getCell(9).getStringCellValue();
				available = sheet.getRow(i).getCell(10).getStringCellValue();
				consumerGroup1 = sheet.getRow(i).getCell(11).getStringCellValue();
				productdevcenter = sheet.getRow(i).getCell(12).getStringCellValue();
				myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, productname, colorwayname,
						colorwaycode, productcode, linesheetview, carryover, available, consumerGroup1,
						productdevcenter });
			}
		}
		return myData.iterator();
	}

//	Data Provider for TP_Bangalore
	@DataProvider(name = "TC018_P2_VerifyFilters_TP_Bangalore")
	public static Iterator<Object[]> TC018_P2_VerifyFilters_TP_Bangalore() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, filterValue, expectedAttributes, productname, colorwayname, colorwaycode, productcode,
				linesheetview, PDS, ProductDevCenter, vendorId, available, garmentdeveloper, Grouping;
		for (int i = 1; i <= numOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				TestType = getCellValue(row.getCell(0));
	
				if ("TC018_P2_VerifyFilters_TP_Bangalore".equalsIgnoreCase(TestType)) {
					season = getCellValue(row.getCell(1));
					filterValue = getCellValue(row.getCell(2));
					expectedAttributes = getCellValue(row.getCell(3));
					productname = getCellValue(row.getCell(4));
					colorwayname = getCellValue(row.getCell(5));
					colorwaycode = getCellValue(row.getCell(6));
					productcode = getCellValue(row.getCell(7));
					linesheetview = getCellValue(row.getCell(8));
					PDS = getCellValue(row.getCell(9));
					ProductDevCenter = getCellValue(row.getCell(10));
					vendorId = getCellValue(row.getCell(11));
					available = getCellValue(row.getCell(12));
					garmentdeveloper = getCellValue(row.getCell(13));
					Grouping = getCellValue(row.getCell(14));

					myData.add(new Object[] { TestType, season, filterValue, expectedAttributes, productname,
							colorwayname, colorwaycode, productcode, linesheetview, PDS, ProductDevCenter, vendorId,
							available, garmentdeveloper, Grouping });
				}
			}
		}
		return myData.iterator();
	}

	private static String getCellValue(XSSFCell cell) {
		return cell == null ? "" : cell.getStringCellValue();
	}

	@DataProvider(name = "TC09_P2_Upload_MillSapCode")
	public static Iterator<Object[]> TC09_P2_Upload_MillSapCode() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, uploadFilePath_update,
				resultfilepath_update;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC09_P2_Upload_MillSapCode".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
//				season = sheet.getRow(i).getCell(4).getStringCellValue();
//				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
//				uploadFilePath_update = sheet.getRow(i).getCell(6).getStringCellValue();
//				resultfilepath_update = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC16_P2_Placment_IncorrectColorwayCode")
	public static Iterator<Object[]> TC16_P2_Placment_IncorrectColorwayCode()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, uploadFilePath_update,
				resultfilepath_update;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC16_P2_Placment_IncorrectColorwayCode".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
//				season = sheet.getRow(i).getCell(4).getStringCellValue();
//				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
//				uploadFilePath_update = sheet.getRow(i).getCell(6).getStringCellValue();
//				resultfilepath_update = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC18_P2_Placement_IncorrectMillCode")
	public static Iterator<Object[]> TC18_P2_Placement_IncorrectMillCode() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, uploadFilePath_update,
				resultfilepath_update;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC18_P2_Placement_IncorrectMillCode".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC17_P2_Placment_IncorectMaterialCode")
	public static Iterator<Object[]> TC17_P2_Placment_IncorectMaterialCode()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, linesheetview, uploadFilePath_update,
				resultfilepath_update;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC17_P2_Placment_IncorectMaterialCode".equalsIgnoreCase(TestType)) {
				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
//				season = sheet.getRow(i).getCell(4).getStringCellValue();
//				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
//				uploadFilePath_update = sheet.getRow(i).getCell(6).getStringCellValue();
//				resultfilepath_update = sheet.getRow(i).getCell(7).getStringCellValue();
				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC036_P2_AttributesForCarryoverScenario")
	public static Iterator<Object[]> TC036_P2_AttributesForCarryoverScenario()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, season, linesheetview, colorway;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC036_P2_AttributesForCarryoverScenario".equalsIgnoreCase(TestType)) {
				season = sheet.getRow(i).getCell(1).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(2).getStringCellValue();
				colorway = sheet.getRow(i).getCell(3).getStringCellValue();
				myData.add(new Object[] { TestType, season, linesheetview, colorway });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC10_P2_Placement_ValidateBlank_USAGE_YIELD_value")
	public static Iterator<Object[]> TC10_P2_Placement_ValidateBlank_USAGE_YIELD_value()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SOLOPLM");
		int numOfRows = sheet.getLastRowNum();
		System.out.println(numOfRows);
		String TestType, uploadFilepath, resultFilepath, filetype, season, colorway, linesheetview;
		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();

			if ("TC10_P2_Placement_ValidateBlank_USAGE_YIELD_value".equalsIgnoreCase(TestType)) {

				uploadFilepath = sheet.getRow(i).getCell(1).getStringCellValue();
				resultFilepath = sheet.getRow(i).getCell(2).getStringCellValue();
				filetype = sheet.getRow(i).getCell(3).getStringCellValue();
				season = sheet.getRow(i).getCell(4).getStringCellValue();
				linesheetview = sheet.getRow(i).getCell(5).getStringCellValue();
				colorway = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, uploadFilepath, resultFilepath, filetype, season, colorway,
						linesheetview });
			}
		}
		return myData.iterator();
	}

////////////////////////////////////////////////////////////

	@DataProvider(name = "TC35_36_P3_BOMAPP_ADD_Replace_Material")
	public static Iterator<Object[]> TC35_36_P3_BOMAPP_ADD_Replace_Material()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, username, password, season, PC9Code, materialType, component, componentLocation, remarks,
				quantity, newMaterial, replaceMaterial;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC35_36_P3_BOMAPP_ADD_Replace_Material".equalsIgnoreCase(TestType)) {
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();
				season = sheet.getRow(i).getCell(3).getStringCellValue();
				PC9Code = sheet.getRow(i).getCell(4).getStringCellValue();
				materialType = sheet.getRow(i).getCell(5).getStringCellValue();
				component = sheet.getRow(i).getCell(6).getStringCellValue();
				componentLocation = sheet.getRow(i).getCell(7).getStringCellValue();
				remarks = sheet.getRow(i).getCell(8).getStringCellValue();
				quantity = sheet.getRow(i).getCell(9).getStringCellValue();
				newMaterial = sheet.getRow(i).getCell(10).getStringCellValue();
				replaceMaterial = sheet.getRow(i).getCell(11).getStringCellValue();

				myData.add(new Object[] { TestType, username, password, season, PC9Code, materialType, component,
						componentLocation, remarks, quantity, newMaterial, replaceMaterial });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM")
	public static Iterator<Object[]> TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, username, password, season, productName, colorName, productTypeValue, rigidIndicatorValue,
				productSegmentationLSE_Value, productSegmentationLSUS_Value, hubOfferdToValue;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM".equalsIgnoreCase(TestType)) {
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();
				season = sheet.getRow(i).getCell(3).getStringCellValue();
				productName = sheet.getRow(i).getCell(4).getStringCellValue();
				colorName = sheet.getRow(i).getCell(5).getStringCellValue();
				productTypeValue = sheet.getRow(i).getCell(6).getStringCellValue();
				rigidIndicatorValue = sheet.getRow(i).getCell(7).getStringCellValue();
				productSegmentationLSE_Value = sheet.getRow(i).getCell(8).getStringCellValue();
				productSegmentationLSUS_Value = sheet.getRow(i).getCell(9).getStringCellValue();
				hubOfferdToValue = sheet.getRow(i).getCell(10).getStringCellValue();

				myData.add(new Object[] { TestType, username, password, season, productName, colorName,
						productTypeValue, rigidIndicatorValue, productSegmentationLSE_Value,
						productSegmentationLSUS_Value, hubOfferdToValue });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC33_P3_BOMAPP_Ability_to_search_partial_entry")
	public static Iterator<Object[]> TC33_P3_BOMAPP_Ability_to_search_partial_entry()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, username, password, season, PC9Code;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC33_P3_BOMAPP_Ability_to_search_partial_entry".equalsIgnoreCase(TestType)) {
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();
				season = sheet.getRow(i).getCell(3).getStringCellValue();
				PC9Code = sheet.getRow(i).getCell(4).getStringCellValue();

				myData.add(new Object[] { TestType, username, password, season, PC9Code });
			}
		}
		return myData.iterator();
	}

	@DataProvider(name = "TC37_P3_BOMAPP_Mass_update_BOM_details")
	public static Iterator<Object[]> TC37_P3_BOMAPP_Mass_update_BOM_details()
			throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "PLM_TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SOLOPLM_P3");
		int numOfRows = sheet.getLastRowNum();
		String TestType, username, password, season, PC5Code, newQuantity, newRemarks;

		for (int i = 1; i <= numOfRows; i++) {
			TestType = sheet.getRow(i).getCell(0).getStringCellValue();
			if ("TC37_P3_BOMAPP_Mass_update_BOM_details".equalsIgnoreCase(TestType)) {
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();
				season = sheet.getRow(i).getCell(3).getStringCellValue();
				PC5Code = sheet.getRow(i).getCell(4).getStringCellValue();
				newQuantity = sheet.getRow(i).getCell(5).getStringCellValue();
				newRemarks = sheet.getRow(i).getCell(6).getStringCellValue();

				myData.add(new Object[] { TestType, username, password, season, PC5Code, newQuantity, newRemarks });
			}
		}
		return myData.iterator();
	}

	///////////////////////////////////////////////////////////////////////////

	@DataProvider(name = "Multple_CreateProducts_CheckLogEntries")
	public static Object[][] Multple_CreateProducts_CheckLogEntries() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateProduct_CLE");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multple_CreateMaleProduct_ValidateUniqueProductCode")
	public static Object[][] Multple_CreateMaleProduct_ValidateUniqueProductCode()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateMaleProduct_ValidateUPC");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multple_CreateFemaleProduct_ValidateUniqueProductCode")
	public static Object[][] Multple_CreateFemaleProduct_ValidateUniqueProductCode()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateFemaleProduct_ValidateUPC");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_CreateFabricTypeMaterial_CheckLogEntry")
	public static Object[][] Multple_CreateMaterials_CheckLogEntries() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateFabricMate_ValidateCLE");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_StagingID_CreateFabricTypeMaterial")
	public static Object[][] Multiple_StagingID_CreateFabricTypeMaterial() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateFabricMate_ValidateSRID");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_Integration_Staging_CreateProduct")
	public static Object[][] Multiple_Integration_Staging_CreateProduct() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateProduct_ValidateSRID");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_Staging_CreateSeasonGroupToSKULink")
	public static Object[][] Multiple_Staging_CreateSeasonGroupToSKULink() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateSeasonGroupToSKULink_SRID");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_CreateMaterialSupplier_CheckLogEntry")
	public static Object[][] Multiple_CreateMaterialSupplier_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateMaterialSupplier_CLE");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	/////////////////////////////////////////// aa////////////////////////////////

	@DataProvider(name = "multiple_VerifyCodeSequencePC9")
	public static Object[][] multiple_VerifyCodeSequencePC9() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CodeSequenceOfPC9'sCreation");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_CreatePC9ForFemaleAcc_CheckPC9Code")
	public static Object[][] Multiple_CreatePC9ForFemaleAcc_CheckPC9Code() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreatePC9FemaleAcc_CheckPC9Code");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_CreatePC9ForMaleAcc_CheckPC9Code")
	public static Object[][] Multiple_CreatePC9ForMaleAcc_CheckPC9Code() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreatePC9MaleAcc_CheckPC9Code");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	////////////////////////////// 04/11/24//

	@DataProvider(name = "Multiple_UpdateSeasonGroupColorway_CheckLogEntry")
	public static Object[][] Multiple_UpdateSeasonGroupColorway_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("UpdateSeasonGroupColorway_CLE");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_BOMAPP_VerifyDataSyncFromFlexPLM")
	public static Object[][] Multiple_BOMAPP_VerifyDataSyncFromFlexPLM() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("VerifyDataSyncFromFlexPLMToBOM");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_BOMAPP_Ability_to_search_partial_entry")
	public static Object[][] Multiple_BOMAPP_Ability_to_search_partial_entry()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("BOM_AbilityToSearchPartialEntry");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_BOMAPP_ADD_Replace_Material")
	public static Object[][] Multiple_BOMAPP_ADD_Replace_Material() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("BOM_AddReplaceMaterial");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_BOMAPP_Mass_update_BOM_details")
	public static Object[][] Multiple_BOMAPP_Mass_update_BOM_details() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("MassUpdateBOMDetails");
		int numOfRows = sheet.getLastRowNum();

		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	///////////////////////////////////////////////////////

	@DataProvider(name = "CreateMultiple_Season")
	public static Object[][] CreateProduct_CheckLogEntry() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateNewSeason_Checklog");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "CreateMultipleColor_PrintsAndPatterns")
	public static Object[][] CreateMultipleColor_PrintsAndPatterns() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateColor_PrintsAndPatterns");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "CreateMultipleColorway_ExistingProducts")
	public static Object[][] CreateMultipleColorway_ExistingProducts() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateColorway_ExistingProduct");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "CreateMultipleProduct_Colorway_SetUpLSE")
	public static Object[][] CreateMultipleProduct_Colorway_SetUpLSE() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateProduct_Colorway_setUpLSE");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC_P3_ActivateMultipleColorway_LSE")
	public static Object[][] TC_P3_ActivateMultipleColorway_LSE() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("ActivateMultipleColorway_LSE");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "CreateMultipleColorway_VerifyStagingRowId")
	public static Object[][] CreateMultipleColorway_VerifyStagingRowId() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("MultipleColorway_VerifyRowID");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC_P3_UpdateMultipleColorway_RigidIndicator")
	public static Object[][] TC_P3_UpdateMultipleColorway_RigidIndicator() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("UpdateMultipleColorway_RigidInd");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC_P3_CreateMutipleColorwaySeason_CheckLogEntry")
	public static Object[][] TC_P3_CreateMutipleColorwaySeason_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("CreateMultipleColorwaySeason");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC_P3_UpdateMultipleSourcingValue_CheckLogEntry")
	public static Object[][] TC_P3_UpdateMultipleSourcingValue_CheckLogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("UpdateMultipleColorwaySourcing");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC_P3_UpdateMultipleMassUpdate_CostwiseView_LogEntry")
	public static Object[][] TC_P3_UpdateMultipleMassUpdate_CostwiseView_LogEntry()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("UpdateMul-Attribute_CostWise");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "TC_P3_SearchMultipleData_BomAPP_AllAttributes")
	public static Object[][] TC_P3_SearchMultipleData_BomAPP_AllAttributes()
			throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SearchAllAttributes_BomAPP");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}

	@DataProvider(name = "Multiple_Check_MeasurementType")
	public static Object[][] Multiple_Check_MeasurementType() throws InvalidFormatException, IOException {
		ArrayList<String[]> myData = new ArrayList<>();
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", FILENAMEMULTIPLE);
    FileInputStream inputStream = new FileInputStream(filePath.toFile());
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Check_MeasurementType");
		int numOfRows = sheet.getLastRowNum();
		for (int i = 1; i <= numOfRows; i++) {
			String[] rowData = new String[sheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				rowData[j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
			myData.add(rowData);
		}
		return new Object[][] { { myData.toArray(new String[0][0]) } };
	}
		
}
