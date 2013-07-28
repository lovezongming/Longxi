/**
 * @author Coco
 * @2013-5-2下午08:31:40
 * @param 
 * @return
 * @描述：
 */
package com.seamoon.demo.test;

/**
 * @author Coco
 * @2013-5-2下午08:31:40
 * @描述：
 */
import java.io.*;
import jxl.*;
import jxl.write.*;
import jxl.format.*;
import java.util.*;
import java.awt.Color;

public class Test{
    public static void writeExcel(OutputStream os) throws Exception {
    jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);
    jxl.write.WritableSheet ws = wwb.createSheet("TestSheet1", 0);
    jxl.write.Label labelC = new jxl.write.Label(0, 0, "我爱中国");
    ws.addCell(labelC);
    jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.ARIAL,20, WritableFont.BOLD, false,
    UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);
    jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc);
    wcfFC.setBackground(jxl.format.Colour.RED);
    labelC = new jxl.write.Label(6, 0, "中国爱我",wcfFC);
    ws.addCell(labelC);
    //写入Exel工作表
    wwb.write();
    //关闭Excel工作薄对象
    wwb.close();
    }

    //最好写一个这样的main方法来测试一下你的这个class是否写好了。
    public static void main(String[] args)throws Exception{
    File f=new File("kk.xls");
    f.createNewFile();
    writeExcel(new FileOutputStream(f));
    }
}
