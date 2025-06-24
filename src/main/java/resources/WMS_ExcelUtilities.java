package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.WMS_Utilities.WMS_GlobalProperties;

public class WMS_ExcelUtilities implements WMS_GlobalProperties{

	
	public static XSSFWorkbook workbook = null;
    public static XSSFSheet sheet = null;
    public static XSSFRow row = null;
    public static XSSFCell cell = null;
 
    public static void invokeExcel(String sheetName) throws IOException 
    {
    	String filePath = System.getProperty("user.dir")+FILEPATH;
		File file =    new File(filePath+"\\"+FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
    }
 
    public static String getData(String colName, int rowNum)
    {
    	int col_Num = -1;
        try
        {
            
          //  sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);
 
           
                return cell.getStringCellValue();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
           
			return "row "+rowNum+" or column "+col_Num +" does not exist  in Excel";
        }
    }
}
