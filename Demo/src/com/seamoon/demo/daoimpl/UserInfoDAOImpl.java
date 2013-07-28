package com.seamoon.demo.daoimpl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.orm.hibernate3.HibernateCallback;

import com.seamoon.demo.dao.UserInfoDAO;
import com.seamoon.demo.entity.UserInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.seamoon.demo.entity.UserInfo
 * @author MyEclipse Persistence Tools
 */

public class UserInfoDAOImpl extends HibernateDaoSupport implements UserInfoDAO{
	private static final Logger log = LoggerFactory
			.getLogger(UserInfoDAOImpl.class);
	// property constants
	public static final String COMPANY_NAME = "companyName";
	public static final String USER_NAME = "userName";
	public static final String MOBILE_NUMBER = "mobileNumber";

	protected void initDao() {
		// do nothing
	}
	

	public void save(UserInfo transientInstance) {
		log.debug("saving UserInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserInfo persistentInstance) {
		log.debug("deleting UserInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserInfo findById(java.lang.Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) getHibernateTemplate().get(
					"com.seamoon.demo.entity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserInfo instance) {
		log.debug("finding UserInfo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCompanyName(Object companyName) {
		return findByProperty(COMPANY_NAME, companyName);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByMobileNumber(Object mobileNumber) {
		return findByProperty(MOBILE_NUMBER, mobileNumber);
	}

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInfo instance) {
		log.debug("attaching dirty UserInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInfo instance) {
		log.debug("attaching clean UserInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserInfoDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (UserInfoDAOImpl) ctx.getBean("UserInfoDAO");
	}

	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#queryAll()
	 */
	public int queryAll() {
		// TODO Auto-generated method stub
		String hql="from UserInfo";
		List list = getHibernateTemplate().find(hql);
//		String sql = "selete * from user_info";
//		List list = getSession().createQuery(sql).list();
	
		int flag = 0;
		if (null != list && list.size() > 0) {
			flag = list.size();
		}
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#queryList(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> queryList(final int first, final int i) {
		// TODO Auto-generated method stub
		final String hql="select id , company_name ,user_name ,mobile_number  from user_info";
		//final String hql="select * from user_info";
//		final String hql="from UserInfo";
		List<UserInfo> list=null;
		list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
//				Query query = getSession().createQuery(hql);
//				Query query = getSession().createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(UserInfo.class));
				Query query = getSession().createSQLQuery(hql).addEntity(UserInfo.class);

				query.setFirstResult(first);
				query.setMaxResults(i);
				List list = query.list();
				return list;
			}
		});


		return list;
	}


	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#addUserInfo(com.seamoon.demo.entity.UserInfo)
	 */
	public int addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			getHibernateTemplate().save(userInfo);
			getHibernateTemplate().flush();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}


	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#editorIn(int)
	 */
	public List<UserInfo> editorIn(int id) {
		// TODO Auto-generated method stub
		String hql="from UserInfo where id='"+id+"'";
//		Object[] values = { id };
//		List list = getHibernateTemplate().find(hql,values);
		List list = getHibernateTemplate().find(hql);
			return list;
	}







	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#deleteAll(java.lang.String)
	 */
	public void deleteAll(int id) {
		// TODO Auto-generated method stub
		String hql="from UserInfo where id='"+id+"'";
		List list=getHibernateTemplate().find(hql);
		if(null != list && list.size() > 0){
			getHibernateTemplate().delete(list);
			getHibernateTemplate().flush();
		}
		
	}


	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#updateUserInfo(com.seamoon.demo.entity.UserInfo)
	 */
	public int updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			getHibernateTemplate().saveOrUpdate(userInfo);
			getHibernateTemplate().flush();
			
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}


	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#delUserInfo(com.seamoon.demo.entity.UserInfo)
	 */
	public int delUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
		try {
			getHibernateTemplate().delete(userInfo);
			
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	
	}


	/* (non-Javadoc)
	 * @see com.seamoon.demo.dao.UserInfoDAO#queryList()
	 */
	@Override
	public List queryList() {
		// TODO Auto-generated method stub
		return findAll();
	}





	





	}


	


	
	


	



	
	


	
	
