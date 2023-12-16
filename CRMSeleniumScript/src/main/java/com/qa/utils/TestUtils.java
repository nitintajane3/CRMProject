package com.qa.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class TestUtils extends com.qa.testbase.TestBase
{
	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public static String newtestfilename = System.getProperty("user.dir")+"/src/test/resources/com/qa/testdata/autoationtestdata.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public static BufferedInputStream bs;
	
	
	public static Object[][] getTestData(String sheetName) throws IOException, InvalidFormatException {
	
		try {
					
	        bs = new BufferedInputStream(new FileInputStream(newtestfilename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(bs);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
	
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("last row of sheet  " + sheet.getLastRowNum() + " last cell of sheet " +
		sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			Row row = sheet.getRow(i + 1);
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				 Cell cell = row.getCell(k);
				 String value;
	               try {
				  value = cell.getRichStringCellValue().toString();
	               } catch (Exception e) {
	                   
	            	   value = ((XSSFCell) cell).getRawValue();
	                }
				
				data[i][k] = value;
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/src/test/resources/com/qa/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
}
