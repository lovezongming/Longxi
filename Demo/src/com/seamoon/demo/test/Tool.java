/**
 * 
 */
package com.seamoon.demo.test;

/**
 * @author Administrator
 * @Date   2013-5-2下午09:06:01
 * @File   Tool.java
 */
import java.io.*;
import jxl.*;
import jxl.write.*;
import jxl.format.*;
import java.util.*;
import java.awt.Color;

import javax.servlet.ServletOutputStream;

public class Tool {
	public void writeExcel(File f) throws Exception {
	//public void writeExcel(OutputStream f) throws Exception {

		int ColumnCount = 20;
		int RowCount = 20;

		jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(f);
		jxl.write.WritableSheet ws = wwb.createSheet("TestSheet1", 0);

		jxl.write.Label labelC = new jxl.write.Label(0, 0, "Caption0");
		ws.addCell(labelC);

		labelC = new jxl.write.Label(1, 0, "caption1");
		ws.addCell(labelC);

		labelC = new jxl.write.Label(2, 0, " caption2");
		ws.addCell(labelC);

		labelC = new jxl.write.Label(3, 0, " caption3");
		ws.addCell(labelC);
		
		// fill caption
		for (int i = 4; i < RowCount; i++) {

			labelC = new jxl.write.Label(i, 0, "Caption"+Integer.toString(i));
			ws.addCell(labelC);

		}	
		

		/*
		 * jxl.write.WritableFont wfc = new jxl.write.WritableFont(
		 * WritableFont.ARIAL, 20, WritableFont.BOLD, false,
		 * UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);
		 * jxl.write.WritableCellFormat wcfFC = new
		 * jxl.write.WritableCellFormat( wfc);
		 * wcfFC.setBackground(jxl.format.Colour.RED); labelC = new
		 * jxl.write.Label(6, 0, "设置颜色背景", wcfFC); ws.addCell(labelC);
		 */

		// fill data
		for (int i = 1; i <= RowCount; i++) {
			for (int j = 0; j < ColumnCount; j++) {
				labelC = new jxl.write.Label(j, i, Integer.toString(i) + "---"
						+ Integer.toString(j));
				ws.addCell(labelC);
			}
		}

		// write into Excel sheet
		wwb.write();
		// close Excel sheet object
		wwb.close();
	}

	public void readExcel(File os) throws Exception {
		Workbook wb = Workbook.getWorkbook(os);
		Sheet s = wb.getSheet("TestSheet1");
		Cell c = s.getCell(0, 0);
		System.out.println(c.getContents());
	}

	// test writeExcel and readExcel method of Tool class
	public static void main(String[] args) throws Exception {
		File f = new File("book1.xls");
		f.createNewFile();

		Tool tool = new Tool();

		tool.writeExcel(f);
		tool.readExcel(f);
	}
}

