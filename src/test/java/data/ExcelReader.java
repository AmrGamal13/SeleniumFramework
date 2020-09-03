package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis=null;
	
	public FileInputStream getFileInputStream() throws FileNotFoundException {
		
		//path of the excel file
		String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx";
		File srcFile = new File(filepath);
		
		fis = new FileInputStream(srcFile);
		return fis;
	}
	//method for reading the excel sheet
	//array of 2 dimension to read the rows and columns
	
	public Object[][] getExcelData() throws IOException
	{
		fis= getFileInputStream();
		//workbook here is the excel file itself
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//read the sheet in the excel which is index 0 (sheet number one)
		XSSFSheet sheet = wb.getSheetAt(0);
		int TotalNumberofRows = sheet.getLastRowNum()+1;
		//total number of cols from the excel sheet itself
		int TotalNumberofCols= 4;
		//array of 2 diemsnions to store the rows and cols
		String[][] arrayExcelData= new String[TotalNumberofRows][TotalNumberofCols];
		//will loop on the rows and in every row will loop over the cols to reach to the cell to get the data
		for (int i = 0; i < TotalNumberofRows; i++) {
			
			for (int j = 0; j < TotalNumberofCols; j++) {
				//get the row
				XSSFRow row =sheet.getRow(i);
				//get the value of the cell
				arrayExcelData[i][j]= row.getCell(j).toString();
			}
		}
		//close the stream to stop reading
		wb.close();
		return arrayExcelData;
	}
}
