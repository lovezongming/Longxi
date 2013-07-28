/**
 * 
 */
package com.seamoon.demo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





import com.opensymphony.xwork2.ActionSupport;
import com.seamoon.demo.dao.UserInfoDAO;
import com.seamoon.demo.entity.UserInfo;
import com.seamoon.demo.service.UserInfoService;

/**
 * @author Administrator
 * @Date   2012-2-19上午11:29:58
 * @File   UserAction.java
 */


public class UserInfoAction extends ActionSupport{
	private Logger log = Logger.getLogger(this.getClass().getName());
	

	private int sid;
	
	private String companyName;//公司名称
	private String userName;//姓名
	private String mobileNumber;//联系方式
	private int first;// 记录起始位置
	private int pages;// 记录总页数
	private int mode;// 记录点击的那个连接
	private int last;// 记录最后位置
	private int maxsize;// 记录最大数
	private int currentPage;// 当前页码
	private List<UserInfo> userInfoList;// 员工表信息
	private UserInfoService userInfoService;
	private List list;
	

	/**
	 * 显示所有记录
	 */

	public String showAllRecord(){
		
		maxsize=userInfoService.queryAll();
		log.info("页数"+maxsize);
		pages = (maxsize + 14) / 15;
		last = (pages - 1) * 15;
		first = userInfoService.getFirst(first, last, mode);
		if (first == 0) {
			currentPage = 1;
		} else {
			currentPage = (first / 15) + 1;
		}
		
		userInfoList=userInfoService.queryList(first, 15);
		
		return "jsp/addsuccess";
	
	}
	
	/**
	 * 添加记录
	 */
	public String addUserInfo(){
		int flag=0;
		log.info(companyName+userName+mobileNumber);
		flag=userInfoService.addUserInfo(companyName,userName,mobileNumber);
		
		if(flag>0){
			log.info("添加成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
		
		
	}
	/**
	 * 进入编辑
	 */
	public String editorIn(){
		
		userInfoList=userInfoService.editorIn(sid);
		
		return SUCCESS;
	}
	/**
	 * 修改编辑
	 */
	public String updateeditor(){
		int flag=0;
		flag=userInfoService.editor(sid,companyName,userName,mobileNumber);
		log.info(sid+companyName+userName+mobileNumber);
		if (flag>0) {
			log.info("xiugai/");
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	/**
	 * 删除单个资料
	 */
	public String delUserInfo(){
		int flag=0;

		flag=userInfoService.delUserInfo(sid);
		if (flag>0) {
			log.info("aaaaaaaaa");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	/**
	 * 批量删除
	 */
	public String deleteAll(){
		log.info("aaaaaaaaaaa");

		for(int i=0;i<list.size();i++){
			String flag=list.get(i).toString();
			System.out.println(flag);
			int flag1=Integer.parseInt(flag);
			userInfoService.delUserInfo(flag1);
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	
	

	public Logger getLog() {
		return log;
	}

	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getMode() {
		return mode;
	}


	

	

	public void setLog(Logger log) {
		this.log = log;
	}

	

	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getMaxsize() {
		return maxsize;
	}
	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	

	




	

	

}
