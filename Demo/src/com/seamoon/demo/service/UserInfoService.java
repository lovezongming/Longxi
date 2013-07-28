/**
 * 
 */
package com.seamoon.demo.service;

import java.util.List;

import com.seamoon.demo.entity.UserInfo;

/**
 * @author Administrator
 * @Date   2012-2-19上午11:40:11
 * @File   UserInfoService.java
 */
public interface UserInfoService {

	/**
	 * @return
	 */
	int queryAll();

	/**
	 * @param first
	 * @param last
	 * @param mode
	 * @return
	 */
	int getFirst(int first, int last, int mode);

	/**
	 * @param first
	 * @param i
	 * @return
	 */
	List<UserInfo> queryList(int first, int i);

	/**
	 * @param companyName
	 * @param userName
	 * @param mobileNumber
	 * @return
	 */
	int addUserInfo(String companyName, String userName, String mobileNumber);

	/**
	 * @param id
	 * @return
	 */
	List<UserInfo> editorIn(int id);

	

	

	/**
	 * @param id
	 * @return
	 */
	int delUserInfo(int id);



	

	/**
	 * @param id
	 * @param companyName
	 * @param userName
	 * @param mobileNumber
	 * @return
	 */
	int editor(int id, String companyName, String userName, String mobileNumber);

	/**
	 * @return
	 */
	List queryList();


	





	
	

}
