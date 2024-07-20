package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
    
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static CellStyle style;
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		return rowcount;
			
	}
public static Short getColumnCount(String xlfile,String xlsheet, int rownum) throws IOException
{		
		
	fi = new FileInputStream(xlfile);	
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);	
	row = ws.getRow(rownum);
	Short colnum = row.getLastCellNum();
	wb.close();
	return colnum ;
		
}
public static String getStringData(String xlfile,String xlsheet,int rownum,int colnum ) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	String data;
	try
	{
		cell = row.getCell(colnum);
	data = cell.getStringCellValue();
	}catch(Exception e)
	{
		data = "";
	}
	return data;
}

public static Double getNumericData(String xlfile,String xlsheet,int rownum,int colnum ) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	Double data;
	try
	{
		cell = row.getCell(colnum);
	data = cell.getNumericCellValue();
	}catch(Exception e)
	{
		data = 0.0;
	}
	return data;
}
public static Boolean getBooleanData(String xlfile,String xlsheet,int rownum,int colnum ) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	Boolean data;
	try
	{
		cell = row.getCell(colnum);
	data = cell.getBooleanCellValue();
	}catch(Exception e)
	{
		data = false;
	}
	return data;
}
public static void setData(String xlfile,String xlsheet,int rownum,int colnum,String Data) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell =row.createCell(colnum);
	cell.setCellValue(Data);
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
    wb.close();
	
}
public static void fillGreenColour(String xlfile,String xlsheet,int rownum,int colnum,String Data) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell= row.getCell(colnum);
	style = wb.createCellStyle();
	style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
}
public static void fillRedColour(String xlfile,String xlsheet,int rownum,int colnum,String Data) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);	
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell= row.getCell(colnum);
	style = wb.createCellStyle();
	style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(style);
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
}	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		
	
