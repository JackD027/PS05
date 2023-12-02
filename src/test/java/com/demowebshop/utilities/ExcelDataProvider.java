package com.demowebshop.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	static Workbook book;
	static Sheet sheet;
   
	public static String testdata_sheet_path = "src/test/resources/login.xlsx";
	
	public static Object[][] getTestData(String sheetName ) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =	new FileInputStream(testdata_sheet_path);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		Object[][] inputdata = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				try {
					inputdata[i][j] = sheet.getRow(i+1).getCell(j).toString();
				} catch (Exception e) {
				}
			}
		}
		return inputdata;
	}
	
	public static void addTestData(int row, String status ) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(new File(testdata_sheet_path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        XSSFRow dataRow = sheet.getRow(row);
        XSSFCell statusCell = dataRow.createCell(dataRow.getLastCellNum());
        statusCell.setCellValue(status);

        FileOutputStream outFile = new FileOutputStream(new File(testdata_sheet_path));
        workbook.write(outFile);
        outFile.close();
        workbook.close();
        file.close();
	}
}
