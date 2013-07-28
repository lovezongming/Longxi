/**
 * 
 */
package com.seamoon.demo.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.java2d.pipe.AATextRenderer;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.opensymphony.xwork2.ActionSupport;
import com.seamoon.demo.entity.UserInfo;
import com.seamoon.demo.service.UserInfoService;
import com.seamoon.demo.test.Person;

/**
 * @author Administrator
 * @Date   2013-5-2下午08:15:44
 * @File   ReportUserInfo.java
 */
public class ReportUserInfoAction extends ActionSupport {
	private UserInfoService userInfoService;
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	 private static String[] titles={"序号","公司名称","员工姓名","联系方式"};
	 private static String column="id,companyName,userName,mobileNumber";
	 private static String[] columns=column.split(",");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(); 
	 public String Report2UserInfo() throws IOException, WriteException{
		 List rsList = userInfoService.queryList();
		 String fileName = sf.format(date)+".xls";
		 WritableWorkbook wwb;
	       FileOutputStream fos;
		  try {
			fos = new FileOutputStream(fileName);
			   wwb = Workbook.createWorkbook(fos);
		          WritableSheet ws = wwb.createSheet("员工信息表", 0);        // 创建一个工作表
		          //    设置单元格的文字格式
//		          WritableFont wf = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false,
//		                  UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
//		          WritableCellFormat wcf = new WritableCellFormat(wf);
//		          wcf.setVerticalAlignment(VerticalAlignment.CENTRE); 
//		          wcf.setAlignment(Alignment.CENTRE); 
//		          ws.setRowView(1, 500);
		          WritableFont wf = new  WritableFont(WritableFont.TIMES, 10 ,WritableFont.BOLD);//定义字体
		          wf.setColour(Colour.BLUE);//蓝色字体
		          WritableCellFormat wcf = new  WritableCellFormat(wf);
		          wcf.setAlignment(jxl.format.Alignment.CENTRE);//左右居中
		          wcf.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//上下居中
		          wcf.setBorder(Border.ALL,BorderLineStyle.THIN,Colour.BLACK);//黑色边框
		          wcf.setBackground(Colour.YELLOW);//黄色背景
		          int charTitle = 10;// 标题字体大小   
		          int charNormal = 10;// 标题字体大小   
		          // 添加带有字型Formatting的对象   
		          // 用于标题   
		          jxl.write.WritableFont titleFont = new jxl.write.WritableFont(   
		          WritableFont.createFont("宋体"), charTitle, WritableFont.BOLD);   
		          jxl.write.WritableCellFormat titleFormat = new jxl.write.WritableCellFormat(   
		           titleFont);   
		          titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条   
		          titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐   
		          titleFormat.setAlignment(Alignment.CENTRE); // 水平对齐   
//		          titleFormat.setWrap(true); // 是否换行   
		          titleFormat.setBackground(Colour.GRAY_25);// 背景色暗灰-25%   
		          // 用于正文   
		          WritableFont wcf1 = new WritableFont(WritableFont   
		            .createFont("宋体"), charNormal);
//		        填充数据的内容
		            UserInfo[] p = new UserInfo[rsList.size()];
		            for (int i=0;i<titles.length;i++) {
			            Label label=new Label(i,0,titles[i],wcf);
			            //将定义好的单元格添加到工作表中
			            ws.addCell(label);
			        }
		            for (int i = 0; i < rsList.size(); i++){
		                p[i] = (UserInfo)rsList.get(i);
		                ws.addCell(new Label(0, i + 1, String.valueOf(i+1), titleFormat));
		                ws.addCell(new Label(1, i + 1, p[i].getCompanyName(), titleFormat));
		                ws.addCell(new Label(2, i + 1, p[i].getUserName(), titleFormat));
		                ws.addCell(new Label(3, i + 1, p[i].getMobileNumber(), titleFormat));
		                if(i == 0)
		                    wcf1 = new WritableFont(WritableFont   
		        		            .createFont("宋体"), charNormal);
		            }

		            wwb.write();
		            wwb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		 return null;
	 }
	/**
	 * 
	 * @return 导出用户数据
	 */
	public String ReportUserInfo(){
		HttpServletResponse  response = ServletActionContext.getResponse();
		List rsList = userInfoService.queryList();
//		String fileName = "C:\\"+sf.format(date)+".xls";
		String fileName = sf.format(date)+".xls";
		 try
	        {
			 OutputStream	 os = response.getOutputStream();
				// 取得输出流   
           response.reset();// 清空输出流  
//		           response.setHeader("Content-disposition", "attachment; filename="+new String(fileName.getBytes("utf-8"),"8859_1"));// 设定输出文件头  
           response.setHeader("Content-disposition", "attachment; filename="+fileName);// 设定输出文件头   
           response.setContentType("application/msexcel");// 定义输出类型 
		    WritableWorkbook book=Workbook.createWorkbook(os); // 建立excel文件 
//	        WritableWorkbook book=Workbook.createWorkbook(new File(fileName));
	        //生成名为“第一页”的工作表，参数0表示这是第一页
	        WritableSheet sheet=book.createSheet("员工信息表",0);
	        //在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
	        //以及单元格内容为test
	        for (int i=0;i<titles.length;i++) {
	            Label label=new Label(i,0,titles[i]);
	            //将定义好的单元格添加到工作表中
	            sheet.addCell(label);
	        }
	        long countNumber=0;
	        for (int i=0;i<rsList.size();i++) {
	            /*Map tmpMap= new HashMap();
	            tmpMap.put(i, rsList.get(i));*/
	        	UserInfo userInfo = (UserInfo) rsList.get(i);
	            Label label3=new Label(0,i+1,(i+1)+"");
	            //将定义好的单元格添加到工作表中
	            sheet.addCell(label3);
	            List list =getContent(userInfo);
            	Label label = null;
            	for(int k = 0;k <list.size(); k++){
            		 label=new Label(k+1,i+1,list.get(k).toString());
            		sheet.addCell(label);
            	}
/*	            for (int j=0;j<columns.length;j++) {
	            	String abc = null;
	            	if(j == 0){
	            		abc = userInfo.getCompanyName();
	            	}
	            	if(j == 1){
	            		abc = userInfo.getUserName();
	            	}
	            	if(j == 2){
	            		abc = userInfo.getMobileNumber();
	            	}
	            	 Label label=new Label(j+1,i+1, abc);
	                将定义好的单元格添加到工作表中
	            }*/
	        }
	        //写入数据并关闭文件
	        book.write();
	        book.close();
	        }catch(Exception e)
	        {
	        e.printStackTrace();
	        }
		return null;
	}
	
	public List getContent (UserInfo userInfo)  {
		String abc = null;
		List list = new ArrayList();
		try {
			UserInfo userInfo1 = new UserInfo();
			Field[] fds = userInfo1.getClass().getDeclaredFields();
			 Field.setAccessible(fds,   true); 
			for(int i=1;i<fds.length;i++){   
				abc =  fds[i].get(userInfo).toString();
				list.add(abc);
			  }
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
