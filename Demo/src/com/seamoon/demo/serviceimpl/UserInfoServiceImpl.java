/**
 * 
 */
package com.seamoon.demo.serviceimpl;

import java.util.List;

import com.seamoon.demo.dao.UserInfoDAO;
import com.seamoon.demo.entity.UserInfo;
import com.seamoon.demo.service.UserInfoService;

/**
 * @author Administrator
 * @Date   2012-2-19上午11:40:45
 * @File   UserInfoServiceImpl.java
 */
public class UserInfoServiceImpl implements UserInfoService{

	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#queryAll()
	 */
	private UserInfoDAO userInfoDAO;
	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	public int queryAll() {
		// TODO Auto-generated method stub
		return userInfoDAO.queryAll();
	}
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#getFirst(int, int, int)
	 */
	public int getFirst(int first, int last, int mode) {
		// TODO Auto-generated method stub
		if (mode == 1) {
			first = 0;
		} else if (mode == 2) {
			first = first - 15;
		} else if (mode == 3) {
			first = first + 15;
		} else if (mode == 4) {
			first = last;
		} else {
			first = 0;
		}
		return first;
	}
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#queryList(int, int)
	 */
	public List<UserInfo> queryList(int first, int i) {
		// TODO Auto-generated method stub
		return userInfoDAO.queryList(first,i);
	}
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#addUserInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public int addUserInfo(String companyName, String userName,
			String mobileNumber) {
		// TODO Auto-generated method stub
		UserInfo userInfo=new UserInfo();
		userInfo.setCompanyName(companyName);
		userInfo.setUserName(userName);
		userInfo.setMobileNumber(mobileNumber);
		return userInfoDAO.addUserInfo(userInfo);
	}
	
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#editorIn(int)
	 */
	public List<UserInfo> editorIn(int id) {
		// TODO Auto-generated method stub
		return userInfoDAO.editorIn(id);
	}
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#editor(int, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int editor(int id, String companyName, String userName,
			String mobileNumber) {
		// TODO Auto-generated method stub
		UserInfo userInfo=new UserInfo();
		userInfo.setId(id);
		userInfo.setCompanyName(companyName);
		userInfo.setUserName(userName);
		userInfo.setMobileNumber(mobileNumber);
		return userInfoDAO.updateUserInfo(userInfo);
	}

	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#delUserInfo(int)
	 */
	public int delUserInfo(int id) {
		// TODO Auto-generated method stub
		UserInfo userInfo=new UserInfo();
		userInfo.setId(id);
		return userInfoDAO.delUserInfo(userInfo);
	}
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#deleteAll(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.seamoon.demo.service.UserInfoService#queryList()
	 */
	@Override
	public List queryList() {
		// TODO Auto-generated method stub
		return userInfoDAO.queryList();
	}
	

	

		
	
	
	

}



		
		
	
	
	


