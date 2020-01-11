package com.deloitte.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deloitte.bean.LoginPage;
import com.deloitte.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	ILoginService loginService;

	List<LoginPage> LPlist;

	@RequestMapping(value = "/loginPage.obj")
	public String redirectToLoginPage(Model model){
		LoginPage lp = new LoginPage();
		model.addAttribute("lp", lp);
		return "login";
	}

	@RequestMapping(value = "/login.obj")
	public String loginPage(
			@ModelAttribute(value = "lp") @Valid LoginPage lp,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			int output = loginService.loginPage(lp);
			model.addAttribute("name", lp.getName());
			model.addAttribute("password", lp.getPwd());
			model.addAttribute("email", lp.getEmail());
			model.addAttribute("mobile", lp.getMobile());
			if (output == 1) {
				model.addAttribute("olist", LPlist);
				return "loginsuccess";
			} else {
				return "loginfail";
			}			
		}
	}

	@RequestMapping(value = "/dispUsers.obj")
	public String showUsers(Model model) {
		LPlist = loginService.getUsers();
		model.addAttribute("elist", LPlist);
		return "showUsers";
	}
	
	@RequestMapping(value = "/goToLogin.obj")
	public String goToLogin(Model model) {
		LoginPage lp = new LoginPage();
		model.addAttribute("lp", lp);
		return "login";
	}

	@RequestMapping(value = "/goHome.obj")
	public String goToHome(Model model) {
		return "index";
	}

}

