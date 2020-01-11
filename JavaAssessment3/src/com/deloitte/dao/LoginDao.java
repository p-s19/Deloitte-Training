package com.deloitte.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.deloitte.bean.LoginPage;
import com.deloitte.bean.Users;

@Transactional
@Repository
public class LoginDao implements ILoginDao {

	@PersistenceContext
	EntityManager entityManager;
	Logger logger = Logger.getLogger(LoginDao.class);
	
	@Override
	public int loginPage(LoginPage lp) {
		System.out.println("DAO : "+lp);
		try{
		   LoginPage lpdb = entityManager.find(LoginPage.class, lp.getName());
		   if(!lpdb.getPwd().equals(lp.getPwd())) {
			  return 0; 
		   }
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in inserting data "+e);
		}
		return 1;
	}

	@Override
	public List<LoginPage> getUsers() {
		TypedQuery<LoginPage> query = null;
		try{
			String sql = "SELECT list from LoginPage list";
			query = entityManager.createQuery(sql, LoginPage.class);
		    logger.info("Fetching Users ");
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Error in fetching data "+e);
		}
		return query.getResultList();
	}

}
