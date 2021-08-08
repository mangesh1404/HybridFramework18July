package com.utility;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtils{

	// read, write, readAllsheet, dp
	FileInputStream fis=null;
	Workbook wb=null;
	
	public void getAllData(String filePath, String name) {
		DataFormatter df= new DataFormatter();
		try
		{
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh= wb.getSheet(name);
		int rows= sh.getLastRowNum();
		for(int i=0;i<=rows;i++) {
			int col= sh.getRow(i).getLastCellNum();
			for(int j=0;j<=col;j++) {		
				Cell c= sh.getRow(i).getCell(j);
				System.out.print(df.formatCellValue(c)+" ");
			}
			System.out.println();
		}
	}
	
	public String[][] getAllDataAsDP(String filePath, String name, int noOfParam) {
		String value=null;
		DataFormatter df= new DataFormatter();
		try
		{
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh= wb.getSheet(name);
		int rows= sh.getLastRowNum();
		String data[][]=new String[rows][noOfParam];//3,2
		for(int i=0;i<rows;i++) {
			for(int j=0;j<noOfParam;j++) {		
				Cell c= sh.getRow(i).getCell(j);
				 value=df.formatCellValue(c);
				data[i][j]=value;
			}	
		}
		return data;
	}
	
	public String readCell(String filePath, String name, int rownum, int cellnum) {
		DataFormatter df= new DataFormatter();
		try
		{
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh= wb.getSheet(name);
		return df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
	}
	
	@Test
	public void test01() {
		System.out.println(readCell("TestData.xlsx", "login", 0, 0));
	}
	
}
