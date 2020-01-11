package com.deloitte.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.bean.LoginPage;
import com.deloitte.bean.Users;
import com.deloitte.dao.ILoginDao;

@Transactional
@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	ILoginDao loginDao;
	
	@Override
	public int loginPage(LoginPage lp) {
		return loginDao.loginPage(lp);
	}

	@Override
	public List<LoginPage> getUsers() {
		return loginDao.getUsers();
	}

}
