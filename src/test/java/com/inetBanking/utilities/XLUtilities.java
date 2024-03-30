package com.inetBanking.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilities {
	
	FileInputStream fileInputStream;
	XSSFWorkbook xssfWorkbook;
	String path;
	
	//Constructor
	public XLUtilities(String path) {
		this.path=path;
	}
	public int getRow(String sheetName) throws Exception{	
		fileInputStream = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;	
	}
	
	public int getCell(String sheetName)throws Exception{
		fileInputStream = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		return lastCellNum;
	}
	
	public String getData(int rowNum,int cellNum,String sheetName)throws Exception{
		fileInputStream = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}
	
	
	
	
	
	
	
	
	
	
}

