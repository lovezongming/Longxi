/**
 * 
 */
package com.seamoon.demo.dao;

import java.util.List;

import com.seamoon.demo.entity.UserInfo;

/**
 * @author Administrator
 * @Date   2012-2-19上午11:38:35
 * @File   UserInfoDAO.java
 */
public interface UserInfoDAO {

	/**
	 * @return
	 */
	int queryAll();

	/**
	 * @param first
	 * @param i
	 * @return
	 */
	List<UserInfo> queryList(int first, int i);

	/**
	 * @param userInfo
	 * @return
	 */
	int addUserInfo(UserInfo userInfo);

	/**
	 * @param id
	 * @return
	 */
	List<UserInfo> editorIn(int id);

	

	

	/**
	 * @param userInfo
	 * @return
	 */
	int updateUserInfo(UserInfo userInfo);

	/**
	 * @param userInfo
	 * @return
	 */
	int delUserInfo(UserInfo userInfo);

	/**
	 * @param ids
	 */
	void deleteAll(int ids);

	/**
	 * @return
	 */
	List queryList();



	




	
	

	

	



	
	

}
