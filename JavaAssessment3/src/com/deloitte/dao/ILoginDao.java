package com.deloitte.dao;

import java.util.List;

import com.deloitte.bean.LoginPage;
import com.deloitte.bean.Users;

public interface ILoginDao {

	int loginPage(LoginPage lp);

	List<LoginPage> getUsers();

}
