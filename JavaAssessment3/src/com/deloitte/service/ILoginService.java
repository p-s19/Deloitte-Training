package com.deloitte.service;

import com.deloitte.bean.LoginPage;
import com.deloitte.bean.Users;
import java.util.List;

public interface ILoginService {

	int loginPage(LoginPage lp);

	List<LoginPage> getUsers();

}
